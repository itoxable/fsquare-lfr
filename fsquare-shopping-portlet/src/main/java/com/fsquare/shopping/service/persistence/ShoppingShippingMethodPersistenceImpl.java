package com.fsquare.shopping.service.persistence;

import com.fsquare.shopping.NoSuchShoppingShippingMethodException;
import com.fsquare.shopping.model.ShoppingShippingMethod;
import com.fsquare.shopping.model.impl.ShoppingShippingMethodImpl;
import com.fsquare.shopping.model.impl.ShoppingShippingMethodModelImpl;
import com.fsquare.shopping.service.persistence.ShoppingShippingMethodPersistence;

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
 * The persistence implementation for the shopping shipping method service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingShippingMethodPersistence
 * @see ShoppingShippingMethodUtil
 * @generated
 */
public class ShoppingShippingMethodPersistenceImpl extends BasePersistenceImpl<ShoppingShippingMethod>
    implements ShoppingShippingMethodPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link ShoppingShippingMethodUtil} to access the shopping shipping method persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = ShoppingShippingMethodImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ShoppingShippingMethodModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingShippingMethodModelImpl.FINDER_CACHE_ENABLED,
            ShoppingShippingMethodImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ShoppingShippingMethodModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingShippingMethodModelImpl.FINDER_CACHE_ENABLED,
            ShoppingShippingMethodImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ShoppingShippingMethodModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingShippingMethodModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_SHOPPINGSHIPPINGMETHOD = "SELECT shoppingShippingMethod FROM ShoppingShippingMethod shoppingShippingMethod";
    private static final String _SQL_COUNT_SHOPPINGSHIPPINGMETHOD = "SELECT COUNT(shoppingShippingMethod) FROM ShoppingShippingMethod shoppingShippingMethod";
    private static final String _ORDER_BY_ENTITY_ALIAS = "shoppingShippingMethod.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ShoppingShippingMethod exists with the primary key ";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(ShoppingShippingMethodPersistenceImpl.class);
    private static ShoppingShippingMethod _nullShoppingShippingMethod = new ShoppingShippingMethodImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<ShoppingShippingMethod> toCacheModel() {
                return _nullShoppingShippingMethodCacheModel;
            }
        };

    private static CacheModel<ShoppingShippingMethod> _nullShoppingShippingMethodCacheModel =
        new CacheModel<ShoppingShippingMethod>() {
            @Override
            public ShoppingShippingMethod toEntityModel() {
                return _nullShoppingShippingMethod;
            }
        };

    public ShoppingShippingMethodPersistenceImpl() {
        setModelClass(ShoppingShippingMethod.class);
    }

    /**
     * Caches the shopping shipping method in the entity cache if it is enabled.
     *
     * @param shoppingShippingMethod the shopping shipping method
     */
    @Override
    public void cacheResult(ShoppingShippingMethod shoppingShippingMethod) {
        EntityCacheUtil.putResult(ShoppingShippingMethodModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingShippingMethodImpl.class,
            shoppingShippingMethod.getPrimaryKey(), shoppingShippingMethod);

        shoppingShippingMethod.resetOriginalValues();
    }

    /**
     * Caches the shopping shipping methods in the entity cache if it is enabled.
     *
     * @param shoppingShippingMethods the shopping shipping methods
     */
    @Override
    public void cacheResult(
        List<ShoppingShippingMethod> shoppingShippingMethods) {
        for (ShoppingShippingMethod shoppingShippingMethod : shoppingShippingMethods) {
            if (EntityCacheUtil.getResult(
                        ShoppingShippingMethodModelImpl.ENTITY_CACHE_ENABLED,
                        ShoppingShippingMethodImpl.class,
                        shoppingShippingMethod.getPrimaryKey()) == null) {
                cacheResult(shoppingShippingMethod);
            } else {
                shoppingShippingMethod.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all shopping shipping methods.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(ShoppingShippingMethodImpl.class.getName());
        }

        EntityCacheUtil.clearCache(ShoppingShippingMethodImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the shopping shipping method.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(ShoppingShippingMethod shoppingShippingMethod) {
        EntityCacheUtil.removeResult(ShoppingShippingMethodModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingShippingMethodImpl.class,
            shoppingShippingMethod.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<ShoppingShippingMethod> shoppingShippingMethods) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (ShoppingShippingMethod shoppingShippingMethod : shoppingShippingMethods) {
            EntityCacheUtil.removeResult(ShoppingShippingMethodModelImpl.ENTITY_CACHE_ENABLED,
                ShoppingShippingMethodImpl.class,
                shoppingShippingMethod.getPrimaryKey());
        }
    }

    /**
     * Creates a new shopping shipping method with the primary key. Does not add the shopping shipping method to the database.
     *
     * @param shippingMethodId the primary key for the new shopping shipping method
     * @return the new shopping shipping method
     */
    @Override
    public ShoppingShippingMethod create(long shippingMethodId) {
        ShoppingShippingMethod shoppingShippingMethod = new ShoppingShippingMethodImpl();

        shoppingShippingMethod.setNew(true);
        shoppingShippingMethod.setPrimaryKey(shippingMethodId);

        return shoppingShippingMethod;
    }

    /**
     * Removes the shopping shipping method with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param shippingMethodId the primary key of the shopping shipping method
     * @return the shopping shipping method that was removed
     * @throws com.fsquare.shopping.NoSuchShoppingShippingMethodException if a shopping shipping method with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingShippingMethod remove(long shippingMethodId)
        throws NoSuchShoppingShippingMethodException, SystemException {
        return remove((Serializable) shippingMethodId);
    }

    /**
     * Removes the shopping shipping method with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the shopping shipping method
     * @return the shopping shipping method that was removed
     * @throws com.fsquare.shopping.NoSuchShoppingShippingMethodException if a shopping shipping method with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingShippingMethod remove(Serializable primaryKey)
        throws NoSuchShoppingShippingMethodException, SystemException {
        Session session = null;

        try {
            session = openSession();

            ShoppingShippingMethod shoppingShippingMethod = (ShoppingShippingMethod) session.get(ShoppingShippingMethodImpl.class,
                    primaryKey);

            if (shoppingShippingMethod == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchShoppingShippingMethodException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(shoppingShippingMethod);
        } catch (NoSuchShoppingShippingMethodException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected ShoppingShippingMethod removeImpl(
        ShoppingShippingMethod shoppingShippingMethod)
        throws SystemException {
        shoppingShippingMethod = toUnwrappedModel(shoppingShippingMethod);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(shoppingShippingMethod)) {
                shoppingShippingMethod = (ShoppingShippingMethod) session.get(ShoppingShippingMethodImpl.class,
                        shoppingShippingMethod.getPrimaryKeyObj());
            }

            if (shoppingShippingMethod != null) {
                session.delete(shoppingShippingMethod);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (shoppingShippingMethod != null) {
            clearCache(shoppingShippingMethod);
        }

        return shoppingShippingMethod;
    }

    @Override
    public ShoppingShippingMethod updateImpl(
        com.fsquare.shopping.model.ShoppingShippingMethod shoppingShippingMethod)
        throws SystemException {
        shoppingShippingMethod = toUnwrappedModel(shoppingShippingMethod);

        boolean isNew = shoppingShippingMethod.isNew();

        Session session = null;

        try {
            session = openSession();

            if (shoppingShippingMethod.isNew()) {
                session.save(shoppingShippingMethod);

                shoppingShippingMethod.setNew(false);
            } else {
                session.merge(shoppingShippingMethod);
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

        EntityCacheUtil.putResult(ShoppingShippingMethodModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingShippingMethodImpl.class,
            shoppingShippingMethod.getPrimaryKey(), shoppingShippingMethod);

        return shoppingShippingMethod;
    }

    protected ShoppingShippingMethod toUnwrappedModel(
        ShoppingShippingMethod shoppingShippingMethod) {
        if (shoppingShippingMethod instanceof ShoppingShippingMethodImpl) {
            return shoppingShippingMethod;
        }

        ShoppingShippingMethodImpl shoppingShippingMethodImpl = new ShoppingShippingMethodImpl();

        shoppingShippingMethodImpl.setNew(shoppingShippingMethod.isNew());
        shoppingShippingMethodImpl.setPrimaryKey(shoppingShippingMethod.getPrimaryKey());

        shoppingShippingMethodImpl.setShippingMethodId(shoppingShippingMethod.getShippingMethodId());
        shoppingShippingMethodImpl.setGroupId(shoppingShippingMethod.getGroupId());
        shoppingShippingMethodImpl.setCompanyId(shoppingShippingMethod.getCompanyId());
        shoppingShippingMethodImpl.setUserId(shoppingShippingMethod.getUserId());
        shoppingShippingMethodImpl.setUserName(shoppingShippingMethod.getUserName());
        shoppingShippingMethodImpl.setCreateDate(shoppingShippingMethod.getCreateDate());
        shoppingShippingMethodImpl.setModifiedDate(shoppingShippingMethod.getModifiedDate());
        shoppingShippingMethodImpl.setPrice(shoppingShippingMethod.getPrice());
        shoppingShippingMethodImpl.setName(shoppingShippingMethod.getName());
        shoppingShippingMethodImpl.setMethodName(shoppingShippingMethod.getMethodName());

        return shoppingShippingMethodImpl;
    }

    /**
     * Returns the shopping shipping method with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the shopping shipping method
     * @return the shopping shipping method
     * @throws com.fsquare.shopping.NoSuchShoppingShippingMethodException if a shopping shipping method with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingShippingMethod findByPrimaryKey(Serializable primaryKey)
        throws NoSuchShoppingShippingMethodException, SystemException {
        ShoppingShippingMethod shoppingShippingMethod = fetchByPrimaryKey(primaryKey);

        if (shoppingShippingMethod == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchShoppingShippingMethodException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return shoppingShippingMethod;
    }

    /**
     * Returns the shopping shipping method with the primary key or throws a {@link com.fsquare.shopping.NoSuchShoppingShippingMethodException} if it could not be found.
     *
     * @param shippingMethodId the primary key of the shopping shipping method
     * @return the shopping shipping method
     * @throws com.fsquare.shopping.NoSuchShoppingShippingMethodException if a shopping shipping method with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingShippingMethod findByPrimaryKey(long shippingMethodId)
        throws NoSuchShoppingShippingMethodException, SystemException {
        return findByPrimaryKey((Serializable) shippingMethodId);
    }

    /**
     * Returns the shopping shipping method with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the shopping shipping method
     * @return the shopping shipping method, or <code>null</code> if a shopping shipping method with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingShippingMethod fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        ShoppingShippingMethod shoppingShippingMethod = (ShoppingShippingMethod) EntityCacheUtil.getResult(ShoppingShippingMethodModelImpl.ENTITY_CACHE_ENABLED,
                ShoppingShippingMethodImpl.class, primaryKey);

        if (shoppingShippingMethod == _nullShoppingShippingMethod) {
            return null;
        }

        if (shoppingShippingMethod == null) {
            Session session = null;

            try {
                session = openSession();

                shoppingShippingMethod = (ShoppingShippingMethod) session.get(ShoppingShippingMethodImpl.class,
                        primaryKey);

                if (shoppingShippingMethod != null) {
                    cacheResult(shoppingShippingMethod);
                } else {
                    EntityCacheUtil.putResult(ShoppingShippingMethodModelImpl.ENTITY_CACHE_ENABLED,
                        ShoppingShippingMethodImpl.class, primaryKey,
                        _nullShoppingShippingMethod);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(ShoppingShippingMethodModelImpl.ENTITY_CACHE_ENABLED,
                    ShoppingShippingMethodImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return shoppingShippingMethod;
    }

    /**
     * Returns the shopping shipping method with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param shippingMethodId the primary key of the shopping shipping method
     * @return the shopping shipping method, or <code>null</code> if a shopping shipping method with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingShippingMethod fetchByPrimaryKey(long shippingMethodId)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) shippingMethodId);
    }

    /**
     * Returns all the shopping shipping methods.
     *
     * @return the shopping shipping methods
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ShoppingShippingMethod> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the shopping shipping methods.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingShippingMethodModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of shopping shipping methods
     * @param end the upper bound of the range of shopping shipping methods (not inclusive)
     * @return the range of shopping shipping methods
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ShoppingShippingMethod> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the shopping shipping methods.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingShippingMethodModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of shopping shipping methods
     * @param end the upper bound of the range of shopping shipping methods (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of shopping shipping methods
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ShoppingShippingMethod> findAll(int start, int end,
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

        List<ShoppingShippingMethod> list = (List<ShoppingShippingMethod>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_SHOPPINGSHIPPINGMETHOD);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_SHOPPINGSHIPPINGMETHOD;

                if (pagination) {
                    sql = sql.concat(ShoppingShippingMethodModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<ShoppingShippingMethod>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<ShoppingShippingMethod>(list);
                } else {
                    list = (List<ShoppingShippingMethod>) QueryUtil.list(q,
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
     * Removes all the shopping shipping methods from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (ShoppingShippingMethod shoppingShippingMethod : findAll()) {
            remove(shoppingShippingMethod);
        }
    }

    /**
     * Returns the number of shopping shipping methods.
     *
     * @return the number of shopping shipping methods
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

                Query q = session.createQuery(_SQL_COUNT_SHOPPINGSHIPPINGMETHOD);

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
     * Initializes the shopping shipping method persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.fsquare.shopping.model.ShoppingShippingMethod")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<ShoppingShippingMethod>> listenersList = new ArrayList<ModelListener<ShoppingShippingMethod>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<ShoppingShippingMethod>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(ShoppingShippingMethodImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
