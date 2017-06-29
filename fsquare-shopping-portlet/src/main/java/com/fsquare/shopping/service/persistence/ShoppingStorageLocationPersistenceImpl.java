package com.fsquare.shopping.service.persistence;

import com.fsquare.shopping.NoSuchShoppingStorageLocationException;
import com.fsquare.shopping.model.ShoppingStorageLocation;
import com.fsquare.shopping.model.impl.ShoppingStorageLocationImpl;
import com.fsquare.shopping.model.impl.ShoppingStorageLocationModelImpl;
import com.fsquare.shopping.service.persistence.ShoppingStorageLocationPersistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
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
import com.liferay.portal.kernel.util.StringPool;
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
 * The persistence implementation for the shopping storage location service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingStorageLocationPersistence
 * @see ShoppingStorageLocationUtil
 * @generated
 */
public class ShoppingStorageLocationPersistenceImpl extends BasePersistenceImpl<ShoppingStorageLocation>
    implements ShoppingStorageLocationPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link ShoppingStorageLocationUtil} to access the shopping storage location persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = ShoppingStorageLocationImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ShoppingStorageLocationModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingStorageLocationModelImpl.FINDER_CACHE_ENABLED,
            ShoppingStorageLocationImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ShoppingStorageLocationModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingStorageLocationModelImpl.FINDER_CACHE_ENABLED,
            ShoppingStorageLocationImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ShoppingStorageLocationModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingStorageLocationModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID =
        new FinderPath(ShoppingStorageLocationModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingStorageLocationModelImpl.FINDER_CACHE_ENABLED,
            ShoppingStorageLocationImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompanyId",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID =
        new FinderPath(ShoppingStorageLocationModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingStorageLocationModelImpl.FINDER_CACHE_ENABLED,
            ShoppingStorageLocationImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyId",
            new String[] { Long.class.getName() },
            ShoppingStorageLocationModelImpl.COMPANYID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYID = new FinderPath(ShoppingStorageLocationModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingStorageLocationModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyId",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_COMPANYID_COMPANYID_2 = "shoppingStorageLocation.companyId = ?";
    private static final String _SQL_SELECT_SHOPPINGSTORAGELOCATION = "SELECT shoppingStorageLocation FROM ShoppingStorageLocation shoppingStorageLocation";
    private static final String _SQL_SELECT_SHOPPINGSTORAGELOCATION_WHERE = "SELECT shoppingStorageLocation FROM ShoppingStorageLocation shoppingStorageLocation WHERE ";
    private static final String _SQL_COUNT_SHOPPINGSTORAGELOCATION = "SELECT COUNT(shoppingStorageLocation) FROM ShoppingStorageLocation shoppingStorageLocation";
    private static final String _SQL_COUNT_SHOPPINGSTORAGELOCATION_WHERE = "SELECT COUNT(shoppingStorageLocation) FROM ShoppingStorageLocation shoppingStorageLocation WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "shoppingStorageLocation.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ShoppingStorageLocation exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ShoppingStorageLocation exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(ShoppingStorageLocationPersistenceImpl.class);
    private static ShoppingStorageLocation _nullShoppingStorageLocation = new ShoppingStorageLocationImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<ShoppingStorageLocation> toCacheModel() {
                return _nullShoppingStorageLocationCacheModel;
            }
        };

    private static CacheModel<ShoppingStorageLocation> _nullShoppingStorageLocationCacheModel =
        new CacheModel<ShoppingStorageLocation>() {
            @Override
            public ShoppingStorageLocation toEntityModel() {
                return _nullShoppingStorageLocation;
            }
        };

    public ShoppingStorageLocationPersistenceImpl() {
        setModelClass(ShoppingStorageLocation.class);
    }

    /**
     * Returns all the shopping storage locations where companyId = &#63;.
     *
     * @param companyId the company ID
     * @return the matching shopping storage locations
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ShoppingStorageLocation> findByCompanyId(long companyId)
        throws SystemException {
        return findByCompanyId(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
    }

    /**
     * Returns a range of all the shopping storage locations where companyId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingStorageLocationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param companyId the company ID
     * @param start the lower bound of the range of shopping storage locations
     * @param end the upper bound of the range of shopping storage locations (not inclusive)
     * @return the range of matching shopping storage locations
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ShoppingStorageLocation> findByCompanyId(long companyId,
        int start, int end) throws SystemException {
        return findByCompanyId(companyId, start, end, null);
    }

    /**
     * Returns an ordered range of all the shopping storage locations where companyId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingStorageLocationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param companyId the company ID
     * @param start the lower bound of the range of shopping storage locations
     * @param end the upper bound of the range of shopping storage locations (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching shopping storage locations
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ShoppingStorageLocation> findByCompanyId(long companyId,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID;
            finderArgs = new Object[] { companyId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID;
            finderArgs = new Object[] { companyId, start, end, orderByComparator };
        }

        List<ShoppingStorageLocation> list = (List<ShoppingStorageLocation>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (ShoppingStorageLocation shoppingStorageLocation : list) {
                if ((companyId != shoppingStorageLocation.getCompanyId())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_SHOPPINGSTORAGELOCATION_WHERE);

            query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(ShoppingStorageLocationModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyId);

                if (!pagination) {
                    list = (List<ShoppingStorageLocation>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<ShoppingStorageLocation>(list);
                } else {
                    list = (List<ShoppingStorageLocation>) QueryUtil.list(q,
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
     * Returns the first shopping storage location in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching shopping storage location
     * @throws com.fsquare.shopping.NoSuchShoppingStorageLocationException if a matching shopping storage location could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingStorageLocation findByCompanyId_First(long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchShoppingStorageLocationException, SystemException {
        ShoppingStorageLocation shoppingStorageLocation = fetchByCompanyId_First(companyId,
                orderByComparator);

        if (shoppingStorageLocation != null) {
            return shoppingStorageLocation;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchShoppingStorageLocationException(msg.toString());
    }

    /**
     * Returns the first shopping storage location in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching shopping storage location, or <code>null</code> if a matching shopping storage location could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingStorageLocation fetchByCompanyId_First(long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        List<ShoppingStorageLocation> list = findByCompanyId(companyId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last shopping storage location in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching shopping storage location
     * @throws com.fsquare.shopping.NoSuchShoppingStorageLocationException if a matching shopping storage location could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingStorageLocation findByCompanyId_Last(long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchShoppingStorageLocationException, SystemException {
        ShoppingStorageLocation shoppingStorageLocation = fetchByCompanyId_Last(companyId,
                orderByComparator);

        if (shoppingStorageLocation != null) {
            return shoppingStorageLocation;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchShoppingStorageLocationException(msg.toString());
    }

    /**
     * Returns the last shopping storage location in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching shopping storage location, or <code>null</code> if a matching shopping storage location could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingStorageLocation fetchByCompanyId_Last(long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByCompanyId(companyId);

        if (count == 0) {
            return null;
        }

        List<ShoppingStorageLocation> list = findByCompanyId(companyId,
                count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the shopping storage locations before and after the current shopping storage location in the ordered set where companyId = &#63;.
     *
     * @param storageLocationId the primary key of the current shopping storage location
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next shopping storage location
     * @throws com.fsquare.shopping.NoSuchShoppingStorageLocationException if a shopping storage location with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingStorageLocation[] findByCompanyId_PrevAndNext(
        long storageLocationId, long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchShoppingStorageLocationException, SystemException {
        ShoppingStorageLocation shoppingStorageLocation = findByPrimaryKey(storageLocationId);

        Session session = null;

        try {
            session = openSession();

            ShoppingStorageLocation[] array = new ShoppingStorageLocationImpl[3];

            array[0] = getByCompanyId_PrevAndNext(session,
                    shoppingStorageLocation, companyId, orderByComparator, true);

            array[1] = shoppingStorageLocation;

            array[2] = getByCompanyId_PrevAndNext(session,
                    shoppingStorageLocation, companyId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected ShoppingStorageLocation getByCompanyId_PrevAndNext(
        Session session, ShoppingStorageLocation shoppingStorageLocation,
        long companyId, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_SHOPPINGSTORAGELOCATION_WHERE);

        query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(ShoppingStorageLocationModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(companyId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(shoppingStorageLocation);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<ShoppingStorageLocation> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the shopping storage locations where companyId = &#63; from the database.
     *
     * @param companyId the company ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByCompanyId(long companyId) throws SystemException {
        for (ShoppingStorageLocation shoppingStorageLocation : findByCompanyId(
                companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(shoppingStorageLocation);
        }
    }

    /**
     * Returns the number of shopping storage locations where companyId = &#63;.
     *
     * @param companyId the company ID
     * @return the number of matching shopping storage locations
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByCompanyId(long companyId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_COMPANYID;

        Object[] finderArgs = new Object[] { companyId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_SHOPPINGSTORAGELOCATION_WHERE);

            query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyId);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Caches the shopping storage location in the entity cache if it is enabled.
     *
     * @param shoppingStorageLocation the shopping storage location
     */
    @Override
    public void cacheResult(ShoppingStorageLocation shoppingStorageLocation) {
        EntityCacheUtil.putResult(ShoppingStorageLocationModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingStorageLocationImpl.class,
            shoppingStorageLocation.getPrimaryKey(), shoppingStorageLocation);

        shoppingStorageLocation.resetOriginalValues();
    }

    /**
     * Caches the shopping storage locations in the entity cache if it is enabled.
     *
     * @param shoppingStorageLocations the shopping storage locations
     */
    @Override
    public void cacheResult(
        List<ShoppingStorageLocation> shoppingStorageLocations) {
        for (ShoppingStorageLocation shoppingStorageLocation : shoppingStorageLocations) {
            if (EntityCacheUtil.getResult(
                        ShoppingStorageLocationModelImpl.ENTITY_CACHE_ENABLED,
                        ShoppingStorageLocationImpl.class,
                        shoppingStorageLocation.getPrimaryKey()) == null) {
                cacheResult(shoppingStorageLocation);
            } else {
                shoppingStorageLocation.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all shopping storage locations.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(ShoppingStorageLocationImpl.class.getName());
        }

        EntityCacheUtil.clearCache(ShoppingStorageLocationImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the shopping storage location.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(ShoppingStorageLocation shoppingStorageLocation) {
        EntityCacheUtil.removeResult(ShoppingStorageLocationModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingStorageLocationImpl.class,
            shoppingStorageLocation.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(
        List<ShoppingStorageLocation> shoppingStorageLocations) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (ShoppingStorageLocation shoppingStorageLocation : shoppingStorageLocations) {
            EntityCacheUtil.removeResult(ShoppingStorageLocationModelImpl.ENTITY_CACHE_ENABLED,
                ShoppingStorageLocationImpl.class,
                shoppingStorageLocation.getPrimaryKey());
        }
    }

    /**
     * Creates a new shopping storage location with the primary key. Does not add the shopping storage location to the database.
     *
     * @param storageLocationId the primary key for the new shopping storage location
     * @return the new shopping storage location
     */
    @Override
    public ShoppingStorageLocation create(long storageLocationId) {
        ShoppingStorageLocation shoppingStorageLocation = new ShoppingStorageLocationImpl();

        shoppingStorageLocation.setNew(true);
        shoppingStorageLocation.setPrimaryKey(storageLocationId);

        return shoppingStorageLocation;
    }

    /**
     * Removes the shopping storage location with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param storageLocationId the primary key of the shopping storage location
     * @return the shopping storage location that was removed
     * @throws com.fsquare.shopping.NoSuchShoppingStorageLocationException if a shopping storage location with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingStorageLocation remove(long storageLocationId)
        throws NoSuchShoppingStorageLocationException, SystemException {
        return remove((Serializable) storageLocationId);
    }

    /**
     * Removes the shopping storage location with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the shopping storage location
     * @return the shopping storage location that was removed
     * @throws com.fsquare.shopping.NoSuchShoppingStorageLocationException if a shopping storage location with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingStorageLocation remove(Serializable primaryKey)
        throws NoSuchShoppingStorageLocationException, SystemException {
        Session session = null;

        try {
            session = openSession();

            ShoppingStorageLocation shoppingStorageLocation = (ShoppingStorageLocation) session.get(ShoppingStorageLocationImpl.class,
                    primaryKey);

            if (shoppingStorageLocation == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchShoppingStorageLocationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(shoppingStorageLocation);
        } catch (NoSuchShoppingStorageLocationException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected ShoppingStorageLocation removeImpl(
        ShoppingStorageLocation shoppingStorageLocation)
        throws SystemException {
        shoppingStorageLocation = toUnwrappedModel(shoppingStorageLocation);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(shoppingStorageLocation)) {
                shoppingStorageLocation = (ShoppingStorageLocation) session.get(ShoppingStorageLocationImpl.class,
                        shoppingStorageLocation.getPrimaryKeyObj());
            }

            if (shoppingStorageLocation != null) {
                session.delete(shoppingStorageLocation);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (shoppingStorageLocation != null) {
            clearCache(shoppingStorageLocation);
        }

        return shoppingStorageLocation;
    }

    @Override
    public ShoppingStorageLocation updateImpl(
        com.fsquare.shopping.model.ShoppingStorageLocation shoppingStorageLocation)
        throws SystemException {
        shoppingStorageLocation = toUnwrappedModel(shoppingStorageLocation);

        boolean isNew = shoppingStorageLocation.isNew();

        ShoppingStorageLocationModelImpl shoppingStorageLocationModelImpl = (ShoppingStorageLocationModelImpl) shoppingStorageLocation;

        Session session = null;

        try {
            session = openSession();

            if (shoppingStorageLocation.isNew()) {
                session.save(shoppingStorageLocation);

                shoppingStorageLocation.setNew(false);
            } else {
                session.merge(shoppingStorageLocation);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !ShoppingStorageLocationModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((shoppingStorageLocationModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        shoppingStorageLocationModelImpl.getOriginalCompanyId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
                    args);

                args = new Object[] {
                        shoppingStorageLocationModelImpl.getCompanyId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
                    args);
            }
        }

        EntityCacheUtil.putResult(ShoppingStorageLocationModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingStorageLocationImpl.class,
            shoppingStorageLocation.getPrimaryKey(), shoppingStorageLocation);

        return shoppingStorageLocation;
    }

    protected ShoppingStorageLocation toUnwrappedModel(
        ShoppingStorageLocation shoppingStorageLocation) {
        if (shoppingStorageLocation instanceof ShoppingStorageLocationImpl) {
            return shoppingStorageLocation;
        }

        ShoppingStorageLocationImpl shoppingStorageLocationImpl = new ShoppingStorageLocationImpl();

        shoppingStorageLocationImpl.setNew(shoppingStorageLocation.isNew());
        shoppingStorageLocationImpl.setPrimaryKey(shoppingStorageLocation.getPrimaryKey());

        shoppingStorageLocationImpl.setStorageLocationId(shoppingStorageLocation.getStorageLocationId());
        shoppingStorageLocationImpl.setCompanyId(shoppingStorageLocation.getCompanyId());
        shoppingStorageLocationImpl.setUserId(shoppingStorageLocation.getUserId());
        shoppingStorageLocationImpl.setUserName(shoppingStorageLocation.getUserName());
        shoppingStorageLocationImpl.setCreateDate(shoppingStorageLocation.getCreateDate());
        shoppingStorageLocationImpl.setModifiedDate(shoppingStorageLocation.getModifiedDate());
        shoppingStorageLocationImpl.setName(shoppingStorageLocation.getName());
        shoppingStorageLocationImpl.setDescription(shoppingStorageLocation.getDescription());
        shoppingStorageLocationImpl.setLocation(shoppingStorageLocation.getLocation());

        return shoppingStorageLocationImpl;
    }

    /**
     * Returns the shopping storage location with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the shopping storage location
     * @return the shopping storage location
     * @throws com.fsquare.shopping.NoSuchShoppingStorageLocationException if a shopping storage location with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingStorageLocation findByPrimaryKey(Serializable primaryKey)
        throws NoSuchShoppingStorageLocationException, SystemException {
        ShoppingStorageLocation shoppingStorageLocation = fetchByPrimaryKey(primaryKey);

        if (shoppingStorageLocation == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchShoppingStorageLocationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return shoppingStorageLocation;
    }

    /**
     * Returns the shopping storage location with the primary key or throws a {@link com.fsquare.shopping.NoSuchShoppingStorageLocationException} if it could not be found.
     *
     * @param storageLocationId the primary key of the shopping storage location
     * @return the shopping storage location
     * @throws com.fsquare.shopping.NoSuchShoppingStorageLocationException if a shopping storage location with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingStorageLocation findByPrimaryKey(long storageLocationId)
        throws NoSuchShoppingStorageLocationException, SystemException {
        return findByPrimaryKey((Serializable) storageLocationId);
    }

    /**
     * Returns the shopping storage location with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the shopping storage location
     * @return the shopping storage location, or <code>null</code> if a shopping storage location with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingStorageLocation fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        ShoppingStorageLocation shoppingStorageLocation = (ShoppingStorageLocation) EntityCacheUtil.getResult(ShoppingStorageLocationModelImpl.ENTITY_CACHE_ENABLED,
                ShoppingStorageLocationImpl.class, primaryKey);

        if (shoppingStorageLocation == _nullShoppingStorageLocation) {
            return null;
        }

        if (shoppingStorageLocation == null) {
            Session session = null;

            try {
                session = openSession();

                shoppingStorageLocation = (ShoppingStorageLocation) session.get(ShoppingStorageLocationImpl.class,
                        primaryKey);

                if (shoppingStorageLocation != null) {
                    cacheResult(shoppingStorageLocation);
                } else {
                    EntityCacheUtil.putResult(ShoppingStorageLocationModelImpl.ENTITY_CACHE_ENABLED,
                        ShoppingStorageLocationImpl.class, primaryKey,
                        _nullShoppingStorageLocation);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(ShoppingStorageLocationModelImpl.ENTITY_CACHE_ENABLED,
                    ShoppingStorageLocationImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return shoppingStorageLocation;
    }

    /**
     * Returns the shopping storage location with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param storageLocationId the primary key of the shopping storage location
     * @return the shopping storage location, or <code>null</code> if a shopping storage location with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingStorageLocation fetchByPrimaryKey(long storageLocationId)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) storageLocationId);
    }

    /**
     * Returns all the shopping storage locations.
     *
     * @return the shopping storage locations
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ShoppingStorageLocation> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the shopping storage locations.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingStorageLocationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of shopping storage locations
     * @param end the upper bound of the range of shopping storage locations (not inclusive)
     * @return the range of shopping storage locations
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ShoppingStorageLocation> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the shopping storage locations.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingStorageLocationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of shopping storage locations
     * @param end the upper bound of the range of shopping storage locations (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of shopping storage locations
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ShoppingStorageLocation> findAll(int start, int end,
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

        List<ShoppingStorageLocation> list = (List<ShoppingStorageLocation>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_SHOPPINGSTORAGELOCATION);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_SHOPPINGSTORAGELOCATION;

                if (pagination) {
                    sql = sql.concat(ShoppingStorageLocationModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<ShoppingStorageLocation>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<ShoppingStorageLocation>(list);
                } else {
                    list = (List<ShoppingStorageLocation>) QueryUtil.list(q,
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
     * Removes all the shopping storage locations from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (ShoppingStorageLocation shoppingStorageLocation : findAll()) {
            remove(shoppingStorageLocation);
        }
    }

    /**
     * Returns the number of shopping storage locations.
     *
     * @return the number of shopping storage locations
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

                Query q = session.createQuery(_SQL_COUNT_SHOPPINGSTORAGELOCATION);

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
     * Initializes the shopping storage location persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.fsquare.shopping.model.ShoppingStorageLocation")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<ShoppingStorageLocation>> listenersList = new ArrayList<ModelListener<ShoppingStorageLocation>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<ShoppingStorageLocation>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(ShoppingStorageLocationImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
