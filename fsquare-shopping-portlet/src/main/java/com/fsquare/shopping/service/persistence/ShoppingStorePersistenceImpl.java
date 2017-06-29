package com.fsquare.shopping.service.persistence;

import com.fsquare.shopping.NoSuchShoppingStoreException;
import com.fsquare.shopping.model.ShoppingStore;
import com.fsquare.shopping.model.impl.ShoppingStoreImpl;
import com.fsquare.shopping.model.impl.ShoppingStoreModelImpl;
import com.fsquare.shopping.service.persistence.ShoppingStorePersistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the shopping store service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingStorePersistence
 * @see ShoppingStoreUtil
 * @generated
 */
public class ShoppingStorePersistenceImpl extends BasePersistenceImpl<ShoppingStore>
    implements ShoppingStorePersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link ShoppingStoreUtil} to access the shopping store persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = ShoppingStoreImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ShoppingStoreModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingStoreModelImpl.FINDER_CACHE_ENABLED,
            ShoppingStoreImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ShoppingStoreModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingStoreModelImpl.FINDER_CACHE_ENABLED,
            ShoppingStoreImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ShoppingStoreModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingStoreModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_SHOPPINGSTORE = "SELECT shoppingStore FROM ShoppingStore shoppingStore";
    private static final String _SQL_COUNT_SHOPPINGSTORE = "SELECT COUNT(shoppingStore) FROM ShoppingStore shoppingStore";
    private static final String _ORDER_BY_ENTITY_ALIAS = "shoppingStore.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ShoppingStore exists with the primary key ";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(ShoppingStorePersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "currency"
            });
    private static ShoppingStore _nullShoppingStore = new ShoppingStoreImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<ShoppingStore> toCacheModel() {
                return _nullShoppingStoreCacheModel;
            }
        };

    private static CacheModel<ShoppingStore> _nullShoppingStoreCacheModel = new CacheModel<ShoppingStore>() {
            @Override
            public ShoppingStore toEntityModel() {
                return _nullShoppingStore;
            }
        };

    public ShoppingStorePersistenceImpl() {
        setModelClass(ShoppingStore.class);
    }

    /**
     * Caches the shopping store in the entity cache if it is enabled.
     *
     * @param shoppingStore the shopping store
     */
    @Override
    public void cacheResult(ShoppingStore shoppingStore) {
        EntityCacheUtil.putResult(ShoppingStoreModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingStoreImpl.class, shoppingStore.getPrimaryKey(),
            shoppingStore);

        shoppingStore.resetOriginalValues();
    }

    /**
     * Caches the shopping stores in the entity cache if it is enabled.
     *
     * @param shoppingStores the shopping stores
     */
    @Override
    public void cacheResult(List<ShoppingStore> shoppingStores) {
        for (ShoppingStore shoppingStore : shoppingStores) {
            if (EntityCacheUtil.getResult(
                        ShoppingStoreModelImpl.ENTITY_CACHE_ENABLED,
                        ShoppingStoreImpl.class, shoppingStore.getPrimaryKey()) == null) {
                cacheResult(shoppingStore);
            } else {
                shoppingStore.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all shopping stores.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(ShoppingStoreImpl.class.getName());
        }

        EntityCacheUtil.clearCache(ShoppingStoreImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the shopping store.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(ShoppingStore shoppingStore) {
        EntityCacheUtil.removeResult(ShoppingStoreModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingStoreImpl.class, shoppingStore.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<ShoppingStore> shoppingStores) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (ShoppingStore shoppingStore : shoppingStores) {
            EntityCacheUtil.removeResult(ShoppingStoreModelImpl.ENTITY_CACHE_ENABLED,
                ShoppingStoreImpl.class, shoppingStore.getPrimaryKey());
        }
    }

    /**
     * Creates a new shopping store with the primary key. Does not add the shopping store to the database.
     *
     * @param companyId the primary key for the new shopping store
     * @return the new shopping store
     */
    @Override
    public ShoppingStore create(long companyId) {
        ShoppingStore shoppingStore = new ShoppingStoreImpl();

        shoppingStore.setNew(true);
        shoppingStore.setPrimaryKey(companyId);

        return shoppingStore;
    }

    /**
     * Removes the shopping store with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param companyId the primary key of the shopping store
     * @return the shopping store that was removed
     * @throws com.fsquare.shopping.NoSuchShoppingStoreException if a shopping store with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingStore remove(long companyId)
        throws NoSuchShoppingStoreException, SystemException {
        return remove((Serializable) companyId);
    }

    /**
     * Removes the shopping store with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the shopping store
     * @return the shopping store that was removed
     * @throws com.fsquare.shopping.NoSuchShoppingStoreException if a shopping store with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingStore remove(Serializable primaryKey)
        throws NoSuchShoppingStoreException, SystemException {
        Session session = null;

        try {
            session = openSession();

            ShoppingStore shoppingStore = (ShoppingStore) session.get(ShoppingStoreImpl.class,
                    primaryKey);

            if (shoppingStore == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchShoppingStoreException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(shoppingStore);
        } catch (NoSuchShoppingStoreException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected ShoppingStore removeImpl(ShoppingStore shoppingStore)
        throws SystemException {
        shoppingStore = toUnwrappedModel(shoppingStore);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(shoppingStore)) {
                shoppingStore = (ShoppingStore) session.get(ShoppingStoreImpl.class,
                        shoppingStore.getPrimaryKeyObj());
            }

            if (shoppingStore != null) {
                session.delete(shoppingStore);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (shoppingStore != null) {
            clearCache(shoppingStore);
        }

        return shoppingStore;
    }

    @Override
    public ShoppingStore updateImpl(
        com.fsquare.shopping.model.ShoppingStore shoppingStore)
        throws SystemException {
        shoppingStore = toUnwrappedModel(shoppingStore);

        boolean isNew = shoppingStore.isNew();

        Session session = null;

        try {
            session = openSession();

            if (shoppingStore.isNew()) {
                session.save(shoppingStore);

                shoppingStore.setNew(false);
            } else {
                session.merge(shoppingStore);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }

        EntityCacheUtil.putResult(ShoppingStoreModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingStoreImpl.class, shoppingStore.getPrimaryKey(),
            shoppingStore);

        return shoppingStore;
    }

    protected ShoppingStore toUnwrappedModel(ShoppingStore shoppingStore) {
        if (shoppingStore instanceof ShoppingStoreImpl) {
            return shoppingStore;
        }

        ShoppingStoreImpl shoppingStoreImpl = new ShoppingStoreImpl();

        shoppingStoreImpl.setNew(shoppingStore.isNew());
        shoppingStoreImpl.setPrimaryKey(shoppingStore.getPrimaryKey());

        shoppingStoreImpl.setCompanyId(shoppingStore.getCompanyId());
        shoppingStoreImpl.setUserId(shoppingStore.getUserId());
        shoppingStoreImpl.setUserName(shoppingStore.getUserName());
        shoppingStoreImpl.setCreateDate(shoppingStore.getCreateDate());
        shoppingStoreImpl.setModifiedDate(shoppingStore.getModifiedDate());
        shoppingStoreImpl.setName(shoppingStore.getName());
        shoppingStoreImpl.setDefaultEmailAddress(shoppingStore.getDefaultEmailAddress());
        shoppingStoreImpl.setProductsMainPageUuid(shoppingStore.getProductsMainPageUuid());
        shoppingStoreImpl.setCartPageUuid(shoppingStore.getCartPageUuid());
        shoppingStoreImpl.setCheckoutPageUuid(shoppingStore.getCheckoutPageUuid());
        shoppingStoreImpl.setOnAddToCart(shoppingStore.getOnAddToCart());
        shoppingStoreImpl.setCurrency(shoppingStore.getCurrency());
        shoppingStoreImpl.setCountry(shoppingStore.getCountry());
        shoppingStoreImpl.setUserTypes(shoppingStore.getUserTypes());
        shoppingStoreImpl.setCheckoutPageFullscreen(shoppingStore.isCheckoutPageFullscreen());
        shoppingStoreImpl.setCheckoutCompletePageTemplate(shoppingStore.getCheckoutCompletePageTemplate());
        shoppingStoreImpl.setOrderCreatedEmailTemplate(shoppingStore.getOrderCreatedEmailTemplate());
        shoppingStoreImpl.setOrderShippedEmailTemplate(shoppingStore.getOrderShippedEmailTemplate());
        shoppingStoreImpl.setOrderCreatedEmailSubject(shoppingStore.getOrderCreatedEmailSubject());
        shoppingStoreImpl.setOrderCreatedEmailFromAddress(shoppingStore.getOrderCreatedEmailFromAddress());
        shoppingStoreImpl.setIntegrateWithStripe(shoppingStore.isIntegrateWithStripe());
        shoppingStoreImpl.setStripeTestSecretKey(shoppingStore.getStripeTestSecretKey());
        shoppingStoreImpl.setStripeTestPublishableKey(shoppingStore.getStripeTestPublishableKey());
        shoppingStoreImpl.setStripeTesting(shoppingStore.isStripeTesting());
        shoppingStoreImpl.setStripeLiveSecretKey(shoppingStore.getStripeLiveSecretKey());
        shoppingStoreImpl.setStripeLivePublishableKey(shoppingStore.getStripeLivePublishableKey());
        shoppingStoreImpl.setStripeApiVersion(shoppingStore.getStripeApiVersion());
        shoppingStoreImpl.setIntegrateWithBraintree(shoppingStore.isIntegrateWithBraintree());
        shoppingStoreImpl.setBraintreePrivateKey(shoppingStore.getBraintreePrivateKey());
        shoppingStoreImpl.setBraintreePublicKey(shoppingStore.getBraintreePublicKey());
        shoppingStoreImpl.setBraintreeMerchantId(shoppingStore.getBraintreeMerchantId());
        shoppingStoreImpl.setUseBraintreeSandbox(shoppingStore.isUseBraintreeSandbox());
        shoppingStoreImpl.setBraintreeSandboxMerchantId(shoppingStore.getBraintreeSandboxMerchantId());
        shoppingStoreImpl.setBraintreeSandboxPrivateKey(shoppingStore.getBraintreeSandboxPrivateKey());
        shoppingStoreImpl.setBraintreeSandboxPublicKey(shoppingStore.getBraintreeSandboxPublicKey());

        return shoppingStoreImpl;
    }

    /**
     * Returns the shopping store with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the shopping store
     * @return the shopping store
     * @throws com.fsquare.shopping.NoSuchShoppingStoreException if a shopping store with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingStore findByPrimaryKey(Serializable primaryKey)
        throws NoSuchShoppingStoreException, SystemException {
        ShoppingStore shoppingStore = fetchByPrimaryKey(primaryKey);

        if (shoppingStore == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchShoppingStoreException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return shoppingStore;
    }

    /**
     * Returns the shopping store with the primary key or throws a {@link com.fsquare.shopping.NoSuchShoppingStoreException} if it could not be found.
     *
     * @param companyId the primary key of the shopping store
     * @return the shopping store
     * @throws com.fsquare.shopping.NoSuchShoppingStoreException if a shopping store with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingStore findByPrimaryKey(long companyId)
        throws NoSuchShoppingStoreException, SystemException {
        return findByPrimaryKey((Serializable) companyId);
    }

    /**
     * Returns the shopping store with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the shopping store
     * @return the shopping store, or <code>null</code> if a shopping store with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingStore fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        ShoppingStore shoppingStore = (ShoppingStore) EntityCacheUtil.getResult(ShoppingStoreModelImpl.ENTITY_CACHE_ENABLED,
                ShoppingStoreImpl.class, primaryKey);

        if (shoppingStore == _nullShoppingStore) {
            return null;
        }

        if (shoppingStore == null) {
            Session session = null;

            try {
                session = openSession();

                shoppingStore = (ShoppingStore) session.get(ShoppingStoreImpl.class,
                        primaryKey);

                if (shoppingStore != null) {
                    cacheResult(shoppingStore);
                } else {
                    EntityCacheUtil.putResult(ShoppingStoreModelImpl.ENTITY_CACHE_ENABLED,
                        ShoppingStoreImpl.class, primaryKey, _nullShoppingStore);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(ShoppingStoreModelImpl.ENTITY_CACHE_ENABLED,
                    ShoppingStoreImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return shoppingStore;
    }

    /**
     * Returns the shopping store with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param companyId the primary key of the shopping store
     * @return the shopping store, or <code>null</code> if a shopping store with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingStore fetchByPrimaryKey(long companyId)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) companyId);
    }

    /**
     * Returns all the shopping stores.
     *
     * @return the shopping stores
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ShoppingStore> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the shopping stores.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingStoreModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of shopping stores
     * @param end the upper bound of the range of shopping stores (not inclusive)
     * @return the range of shopping stores
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ShoppingStore> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the shopping stores.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingStoreModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of shopping stores
     * @param end the upper bound of the range of shopping stores (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of shopping stores
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ShoppingStore> findAll(int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
            finderArgs = FINDER_ARGS_EMPTY;
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
            finderArgs = new Object[] { start, end, orderByComparator };
        }

        List<ShoppingStore> list = (List<ShoppingStore>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_SHOPPINGSTORE);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_SHOPPINGSTORE;

                if (pagination) {
                    sql = sql.concat(ShoppingStoreModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<ShoppingStore>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<ShoppingStore>(list);
                } else {
                    list = (List<ShoppingStore>) QueryUtil.list(q,
                            getDialect(), start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Removes all the shopping stores from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (ShoppingStore shoppingStore : findAll()) {
            remove(shoppingStore);
        }
    }

    /**
     * Returns the number of shopping stores.
     *
     * @return the number of shopping stores
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_SHOPPINGSTORE);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    @Override
    protected Set<String> getBadColumnNames() {
        return _badColumnNames;
    }

    /**
     * Initializes the shopping store persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.fsquare.shopping.model.ShoppingStore")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<ShoppingStore>> listenersList = new ArrayList<ModelListener<ShoppingStore>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<ShoppingStore>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(ShoppingStoreImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
