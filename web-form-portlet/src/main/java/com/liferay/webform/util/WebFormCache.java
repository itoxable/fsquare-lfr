package com.liferay.webform.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import com.liferay.portal.kernel.cache.CacheListener;
import com.liferay.portal.kernel.cache.CacheListenerScope;
import com.liferay.portal.kernel.cache.PortalCache;
import com.liferay.portal.kernel.concurrent.ConcurrentHashSet;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class WebFormCache <K extends Serializable, V> implements PortalCache<K, V> {

		
	private static WebFormCache<String, Object> instance;
	private static Log _log = LogFactoryUtil.getLog(WebFormCache.class);

    public static synchronized WebFormCache<String, Object> getInstance(){
        if(instance == null){
            instance = new WebFormCache<String, Object>("WebFormCache", 20);
        }
        return instance;
    }
	
	
	private Set<CacheListener<K, V>> _cacheListeners = new ConcurrentHashSet<CacheListener<K, V>>();
	private Map<K, V> _map;
	private String _name;
	private Map<K, Long> _keyTime; 
	
	private WebFormCache(String name, int initialCapacity) {
		_name = name;
		_map = new ConcurrentHashMap<K, V>(initialCapacity);
		_keyTime = new HashMap<K, Long>();
	}

	@Override
	public void destroy() {
		removeAll();

		_cacheListeners = null;
		_map = null;
		_name = null;
		_keyTime = null;
	}

	@Override
	public Collection<V> get(Collection<K> keys) {
		List<V> values = new ArrayList<V>(keys.size());

		for (K key : keys) {
			values.add(get(key));
		}

		return values;
	}

	@Override
	public V get(K key) {
		Long expireTime = _keyTime.get(key);
		long currentTime = System.currentTimeMillis();
		if(expireTime != null && expireTime > 0 && currentTime > expireTime){
			Date date = new Date(expireTime);
			System.out.println("KEY: "+key+", EXPIRED IN: "+date);
			remove(key);
			return null;
		}
		return _map.get(key);
	}

	@Override
	public String getName() {
		return _name;
	}

	@Override
	public void put(K key, V value) {
		V oldValue = _map.put(key, value);

		notifyPutEvents(key, value, oldValue != null);
		
		_keyTime.put(key, -1L);
	}

	@Override
	public void put(K key, V value, int timeToLive) {
		V oldValue = _map.put(key, value);

		notifyPutEvents(key, value, oldValue != null);
		
		long currentTime = System.currentTimeMillis();
		
		Date date = new Date(currentTime + (timeToLive*60000L));
		System.out.println("ADDING KEY: "+key+", EXPIRING AT: "+date);
		_keyTime.put(key, currentTime + timeToLive);
	}

	@Override
	public void registerCacheListener(CacheListener<K, V> cacheListener) {
		_cacheListeners.add(cacheListener);
	}

	@Override
	public void registerCacheListener(
		CacheListener<K, V> cacheListener,
		CacheListenerScope cacheListenerScope) {

		registerCacheListener(cacheListener);
	}

	@Override
	public void remove(K key) {
		V value = _map.remove(key);

		for (CacheListener<K, V> cacheListener : _cacheListeners) {
			cacheListener.notifyEntryRemoved(this, key, value);
		}
		
		_keyTime.remove(key);
	}

	@Override
	public void removeAll() {
		_map.clear();
		_keyTime.clear();
		for (CacheListener<K, V> cacheListener : _cacheListeners) {
			cacheListener.notifyRemoveAll(this);
		}
	}

	@Override
	public void unregisterCacheListener(CacheListener<K, V> cacheListener) {
		_cacheListeners.remove(cacheListener);
	}

	@Override
	public void unregisterCacheListeners() {
		_cacheListeners.clear();
	}

	protected void notifyPutEvents(K key, V value, boolean updated) {
		if (updated) {
			for (CacheListener<K, V> cacheListener : _cacheListeners) {
				cacheListener.notifyEntryUpdated(this, key, value);
			}
		}
		else {
			for (CacheListener<K, V> cacheListener : _cacheListeners) {
				cacheListener.notifyEntryPut(this, key, value);
			}
		}
	}

}
