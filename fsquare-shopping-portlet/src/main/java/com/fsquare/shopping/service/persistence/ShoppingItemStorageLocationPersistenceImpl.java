package com.fsquare.shopping.service.persistence;

import com.fsquare.shopping.NoSuchShoppingItemStorageLocationException;
import com.fsquare.shopping.model.ShoppingItemStorageLocation;
import com.fsquare.shopping.model.impl.ShoppingItemStorageLocationImpl;
import com.fsquare.shopping.model.impl.ShoppingItemStorageLocationModelImpl;
import com.fsquare.shopping.service.persistence.ShoppingItemStorageLocationPersistence;

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

/**
 * The persistence implementation for the shopping item storage location service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingItemStorageLocationPersistence
 * @see ShoppingItemStorageLocationUtil
 * @generated
 */
public class ShoppingItemStorageLocationPersistenceImpl
    extends BasePersistenceImpl<ShoppingItemStorageLocation>
    implements ShoppingItemStorageLocationPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link ShoppingItemStorageLocationUtil} to access the shopping item storage location persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = ShoppingItemStorageLocationImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ShoppingItemStorageLocationModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingItemStorageLocationModelImpl.FINDER_CACHE_ENABLED,
            ShoppingItemStorageLocationImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ShoppingItemStorageLocationModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingItemStorageLocationModelImpl.FINDER_CACHE_ENABLED,
            ShoppingItemStorageLocationImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ShoppingItemStorageLocationModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingItemStorageLocationModelImpl.FINDER_CACHE_ENABLED,
            Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
            new String[0]);
    private static final String _SQL_SELECT_SHOPPINGITEMSTORAGELOCATION = "SELECT shoppingItemStorageLocation FROM ShoppingItemStorageLocation shoppingItemStorageLocation";
    private static final String _SQL_COUNT_SHOPPINGITEMSTORAGELOCATION = "SELECT COUNT(shoppingItemStorageLocation) FROM ShoppingItemStorageLocation shoppingItemStorageLocation";
    private static final String _ORDER_BY_ENTITY_ALIAS = "shoppingItemStorageLocation.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ShoppingItemStorageLocation exists with the primary key ";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(ShoppingItemStorageLocationPersistenceImpl.class);
    private static ShoppingItemStorageLocation _nullShoppingItemStorageLocation = new ShoppingItemStorageLocationImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<ShoppingItemStorageLocation> toCacheModel() {
                return _nullShoppingItemStorageLocationCacheModel;
            }
        };

    private static CacheModel<ShoppingItemStorageLocation> _nullShoppingItemStorageLocationCacheModel =
        new CacheModel<ShoppingItemStorageLocation>() {
            @Override
            public ShoppingItemStorageLocation toEntityModel() {
                return _nullShoppingItemStorageLocation;
            }
        };

    public ShoppingItemStorageLocationPersistenceImpl() {
        setModelClass(ShoppingItemStorageLocation.class);
    }

    /**
     * Caches the shopping item storage location in the entity cache if it is enabled.
     *
     * @param shoppingItemStorageLocation the shopping item storage location
     */
    @Override
    public void cacheResult(
        ShoppingItemStorageLocation shoppingItemStorageLocation) {
        EntityCacheUtil.putResult(ShoppingItemStorageLocationModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingItemStorageLocationImpl.class,
            shoppingItemStorageLocation.getPrimaryKey(),
            shoppingItemStorageLocation);

        shoppingItemStorageLocation.resetOriginalValues();
    }

    /**
     * Caches the shopping item storage locations in the entity cache if it is enabled.
     *
     * @param shoppingItemStorageLocations the shopping item storage locations
     */
    @Override
    public void cacheResult(
        List<ShoppingItemStorageLocation> shoppingItemStorageLocations) {
        for (ShoppingItemStorageLocation shoppingItemStorageLocation : shoppingItemStorageLocations) {
            if (EntityCacheUtil.getResult(
                        ShoppingItemStorageLocationModelImpl.ENTITY_CACHE_ENABLED,
                        ShoppingItemStorageLocationImpl.class,
                        shoppingItemStorageLocation.getPrimaryKey()) == null) {
                cacheResult(shoppingItemStorageLocation);
            } else {
                shoppingItemStorageLocation.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all shopping item storage locations.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(ShoppingItemStorageLocationImpl.class.getName());
        }

        EntityCacheUtil.clearCache(ShoppingItemStorageLocationImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the shopping item storage location.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(
        ShoppingItemStorageLocation shoppingItemStorageLocation) {
        EntityCacheUtil.removeResult(ShoppingItemStorageLocationModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingItemStorageLocationImpl.class,
            shoppingItemStorageLocation.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(
        List<ShoppingItemStorageLocation> shoppingItemStorageLocations) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (ShoppingItemStorageLocation shoppingItemStorageLocation : shoppingItemStorageLocations) {
            EntityCacheUtil.removeResult(ShoppingItemStorageLocationModelImpl.ENTITY_CACHE_ENABLED,
                ShoppingItemStorageLocationImpl.class,
                shoppingItemStorageLocation.getPrimaryKey());
        }
    }

    /**
     * Creates a new shopping item storage location with the primary key. Does not add the shopping item storage location to the database.
     *
     * @param itemStorageLocationId the primary key for the new shopping item storage location
     * @return the new shopping item storage location
     */
    @Override
    public ShoppingItemStorageLocation create(long itemStorageLocationId) {
        ShoppingItemStorageLocation shoppingItemStorageLocation = new ShoppingItemStorageLocationImpl();

        shoppingItemStorageLocation.setNew(true);
        shoppingItemStorageLocation.setPrimaryKey(itemStorageLocationId);

        return shoppingItemStorageLocation;
    }

    /**
     * Removes the shopping item storage location with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param itemStorageLocationId the primary key of the shopping item storage location
     * @return the shopping item storage location that was removed
     * @throws com.fsquare.shopping.NoSuchShoppingItemStorageLocationException if a shopping item storage location with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingItemStorageLocation remove(long itemStorageLocationId)
        throws NoSuchShoppingItemStorageLocationException, SystemException {
        return remove((Serializable) itemStorageLocationId);
    }

    /**
     * Removes the shopping item storage location with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the shopping item storage location
     * @return the shopping item storage location that was removed
     * @throws com.fsquare.shopping.NoSuchShoppingItemStorageLocationException if a shopping item storage location with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingItemStorageLocation remove(Serializable primaryKey)
        throws NoSuchShoppingItemStorageLocationException, SystemException {
        Session session = null;

        try {
            session = openSession();

            ShoppingItemStorageLocation shoppingItemStorageLocation = (ShoppingItemStorageLocation) session.get(ShoppingItemStorageLocationImpl.class,
                    primaryKey);

            if (shoppingItemStorageLocation == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchShoppingItemStorageLocationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(shoppingItemStorageLocation);
        } catch (NoSuchShoppingItemStorageLocationException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected ShoppingItemStorageLocation removeImpl(
        ShoppingItemStorageLocation shoppingItemStorageLocation)
        throws SystemException {
        shoppingItemStorageLocation = toUnwrappedModel(shoppingItemStorageLocation);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(shoppingItemStorageLocation)) {
                shoppingItemStorageLocation = (ShoppingItemStorageLocation) session.get(ShoppingItemStorageLocationImpl.class,
                        shoppingItemStorageLocation.getPrimaryKeyObj());
            }

            if (shoppingItemStorageLocation != null) {
                session.delete(shoppingItemStorageLocation);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (shoppingItemStorageLocation != null) {
            clearCache(shoppingItemStorageLocation);
        }

        return shoppingItemStorageLocation;
    }

    @Override
    public ShoppingItemStorageLocation updateImpl(
        com.fsquare.shopping.model.ShoppingItemStorageLocation shoppingItemStorageLocation)
        throws SystemException {
        shoppingItemStorageLocation = toUnwrappedModel(shoppingItemStorageLocation);

        boolean isNew = shoppingItemStorageLocation.isNew();

        Session session = null;

        try {
            session = openSession();

            if (shoppingItemStorageLocation.isNew()) {
                session.save(shoppingItemStorageLocation);

                shoppingItemStorageLocation.setNew(false);
            } else {
                session.merge(shoppingItemStorageLocation);
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

        EntityCacheUtil.putResult(ShoppingItemStorageLocationModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingItemStorageLocationImpl.class,
            shoppingItemStorageLocation.getPrimaryKey(),
            shoppingItemStorageLocation);

        return shoppingItemStorageLocation;
    }

    protected ShoppingItemStorageLocation toUnwrappedModel(
        ShoppingItemStorageLocation shoppingItemStorageLocation) {
        if (shoppingItemStorageLocation instanceof ShoppingItemStorageLocationImpl) {
            return shoppingItemStorageLocation;
        }

        ShoppingItemStorageLocationImpl shoppingItemStorageLocationImpl = new ShoppingItemStorageLocationImpl();

        shoppingItemStorageLocationImpl.setNew(shoppingItemStorageLocation.isNew());
        shoppingItemStorageLocationImpl.setPrimaryKey(shoppingItemStorageLocation.getPrimaryKey());

        shoppingItemStorageLocationImpl.setItemStorageLocationId(shoppingItemStorageLocation.getItemStorageLocationId());
        shoppingItemStorageLocationImpl.setItemId(shoppingItemStorageLocation.getItemId());
        shoppingItemStorageLocationImpl.setStorageLocationId(shoppingItemStorageLocation.getStorageLocationId());
        shoppingItemStorageLocationImpl.setGroupId(shoppingItemStorageLocation.getGroupId());
        shoppingItemStorageLocationImpl.setCompanyId(shoppingItemStorageLocation.getCompanyId());
        shoppingItemStorageLocationImpl.setUserId(shoppingItemStorageLocation.getUserId());
        shoppingItemStorageLocationImpl.setUserName(shoppingItemStorageLocation.getUserName());
        shoppingItemStorageLocationImpl.setCreateDate(shoppingItemStorageLocation.getCreateDate());
        shoppingItemStorageLocationImpl.setModifiedDate(shoppingItemStorageLocation.getModifiedDate());
        shoppingItemStorageLocationImpl.setName(shoppingItemStorageLocation.getName());
        shoppingItemStorageLocationImpl.setQuantity(shoppingItemStorageLocation.getQuantity());
        shoppingItemStorageLocationImpl.setMovementType(shoppingItemStorageLocation.getMovementType());

        return shoppingItemStorageLocationImpl;
    }

    /**
     * Returns the shopping item storage location with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the shopping item storage location
     * @return the shopping item storage location
     * @throws com.fsquare.shopping.NoSuchShoppingItemStorageLocationException if a shopping item storage location with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingItemStorageLocation findByPrimaryKey(Serializable primaryKey)
        throws NoSuchShoppingItemStorageLocationException, SystemException {
        ShoppingItemStorageLocation shoppingItemStorageLocation = fetchByPrimaryKey(primaryKey);

        if (shoppingItemStorageLocation == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchShoppingItemStorageLocationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return shoppingItemStorageLocation;
    }

    /**
     * Returns the shopping item storage location with the primary key or throws a {@link com.fsquare.shopping.NoSuchShoppingItemStorageLocationException} if it could not be found.
     *
     * @param itemStorageLocationId the primary key of the shopping item storage location
     * @return the shopping item storage location
     * @throws com.fsquare.shopping.NoSuchShoppingItemStorageLocationException if a shopping item storage location with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingItemStorageLocation findByPrimaryKey(
        long itemStorageLocationId)
        throws NoSuchShoppingItemStorageLocationException, SystemException {
        return findByPrimaryKey((Serializable) itemStorageLocationId);
    }

    /**
     * Returns the shopping item storage location with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the shopping item storage location
     * @return the shopping item storage location, or <code>null</code> if a shopping item storage location with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingItemStorageLocation fetchByPrimaryKey(
        Serializable primaryKey) throws SystemException {
        ShoppingItemStorageLocation shoppingItemStorageLocation = (ShoppingItemStorageLocation) EntityCacheUtil.getResult(ShoppingItemStorageLocationModelImpl.ENTITY_CACHE_ENABLED,
                ShoppingItemStorageLocationImpl.class, primaryKey);

        if (shoppingItemStorageLocation == _nullShoppingItemStorageLocation) {
            return null;
        }

        if (shoppingItemStorageLocation == null) {
            Session session = null;

            try {
                session = openSession();

                shoppingItemStorageLocation = (ShoppingItemStorageLocation) session.get(ShoppingItemStorageLocationImpl.class,
                        primaryKey);

                if (shoppingItemStorageLocation != null) {
                    cacheResult(shoppingItemStorageLocation);
                } else {
                    EntityCacheUtil.putResult(ShoppingItemStorageLocationModelImpl.ENTITY_CACHE_ENABLED,
                        ShoppingItemStorageLocationImpl.class, primaryKey,
                        _nullShoppingItemStorageLocation);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(ShoppingItemStorageLocationModelImpl.ENTITY_CACHE_ENABLED,
                    ShoppingItemStorageLocationImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return shoppingItemStorageLocation;
    }

    /**
     * Returns the shopping item storage location with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param itemStorageLocationId the primary key of the shopping item storage location
     * @return the shopping item storage location, or <code>null</code> if a shopping item storage location with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingItemStorageLocation fetchByPrimaryKey(
        long itemStorageLocationId) throws SystemException {
        return fetchByPrimaryKey((Serializable) itemStorageLocationId);
    }

    /**
     * Returns all the shopping item storage locations.
     *
     * @return the shopping item storage locations
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ShoppingItemStorageLocation> findAll()
        throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the shopping item storage locations.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingItemStorageLocationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of shopping item storage locations
     * @param end the upper bound of the range of shopping item storage locations (not inclusive)
     * @return the range of shopping item storage locations
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ShoppingItemStorageLocation> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the shopping item storage locations.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingItemStorageLocationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of shopping item storage locations
     * @param end the upper bound of the range of shopping item storage locations (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of shopping item storage locations
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ShoppingItemStorageLocation> findAll(int start, int end,
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

        List<ShoppingItemStorageLocation> list = (List<ShoppingItemStorageLocation>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_SHOPPINGITEMSTORAGELOCATION);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_SHOPPINGITEMSTORAGELOCATION;

                if (pagination) {
                    sql = sql.concat(ShoppingItemStorageLocationModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<ShoppingItemStorageLocation>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<ShoppingItemStorageLocation>(list);
                } else {
                    list = (List<ShoppingItemStorageLocation>) QueryUtil.list(q,
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
     * Removes all the shopping item storage locations from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (ShoppingItemStorageLocation shoppingItemStorageLocation : findAll()) {
            remove(shoppingItemStorageLocation);
        }
    }

    /**
     * Returns the number of shopping item storage locations.
     *
     * @return the number of shopping item storage locations
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

                Query q = session.createQuery(_SQL_COUNT_SHOPPINGITEMSTORAGELOCATION);

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

    /**
     * Initializes the shopping item storage location persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.fsquare.shopping.model.ShoppingItemStorageLocation")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<ShoppingItemStorageLocation>> listenersList = new ArrayList<ModelListener<ShoppingItemStorageLocation>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<ShoppingItemStorageLocation>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(ShoppingItemStorageLocationImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
