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
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(ShoppingItemStorageLocationModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingItemStorageLocationModelImpl.FINDER_CACHE_ENABLED,
            ShoppingItemStorageLocationImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
        new FinderPath(ShoppingItemStorageLocationModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingItemStorageLocationModelImpl.FINDER_CACHE_ENABLED,
            ShoppingItemStorageLocationImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
            new String[] { Long.class.getName() },
            ShoppingItemStorageLocationModelImpl.GROUPID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(ShoppingItemStorageLocationModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingItemStorageLocationModelImpl.FINDER_CACHE_ENABLED,
            Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByGroupId", new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "shoppingItemStorageLocation.groupId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STORAGELOCATIONID =
        new FinderPath(ShoppingItemStorageLocationModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingItemStorageLocationModelImpl.FINDER_CACHE_ENABLED,
            ShoppingItemStorageLocationImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStorageLocationId",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STORAGELOCATIONID =
        new FinderPath(ShoppingItemStorageLocationModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingItemStorageLocationModelImpl.FINDER_CACHE_ENABLED,
            ShoppingItemStorageLocationImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findByStorageLocationId", new String[] { Long.class.getName() },
            ShoppingItemStorageLocationModelImpl.STORAGELOCATIONID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_STORAGELOCATIONID = new FinderPath(ShoppingItemStorageLocationModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingItemStorageLocationModelImpl.FINDER_CACHE_ENABLED,
            Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByStorageLocationId", new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_STORAGELOCATIONID_STORAGELOCATIONID_2 =
        "shoppingItemStorageLocation.storageLocationId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ITEMID = new FinderPath(ShoppingItemStorageLocationModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingItemStorageLocationModelImpl.FINDER_CACHE_ENABLED,
            ShoppingItemStorageLocationImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByItemId",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ITEMID =
        new FinderPath(ShoppingItemStorageLocationModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingItemStorageLocationModelImpl.FINDER_CACHE_ENABLED,
            ShoppingItemStorageLocationImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByItemId",
            new String[] { Long.class.getName() },
            ShoppingItemStorageLocationModelImpl.ITEMID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_ITEMID = new FinderPath(ShoppingItemStorageLocationModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingItemStorageLocationModelImpl.FINDER_CACHE_ENABLED,
            Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByItemId", new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_ITEMID_ITEMID_2 = "shoppingItemStorageLocation.itemId = ?";
    public static final FinderPath FINDER_PATH_FETCH_BY_ITEMIDANDSTORAGELOCATIONID =
        new FinderPath(ShoppingItemStorageLocationModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingItemStorageLocationModelImpl.FINDER_CACHE_ENABLED,
            ShoppingItemStorageLocationImpl.class, FINDER_CLASS_NAME_ENTITY,
            "fetchByItemIdAndStorageLocationId",
            new String[] { Long.class.getName(), Long.class.getName() },
            ShoppingItemStorageLocationModelImpl.ITEMID_COLUMN_BITMASK |
            ShoppingItemStorageLocationModelImpl.STORAGELOCATIONID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_ITEMIDANDSTORAGELOCATIONID =
        new FinderPath(ShoppingItemStorageLocationModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingItemStorageLocationModelImpl.FINDER_CACHE_ENABLED,
            Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByItemIdAndStorageLocationId",
            new String[] { Long.class.getName(), Long.class.getName() });
    private static final String _FINDER_COLUMN_ITEMIDANDSTORAGELOCATIONID_ITEMID_2 =
        "shoppingItemStorageLocation.itemId = ? AND ";
    private static final String _FINDER_COLUMN_ITEMIDANDSTORAGELOCATIONID_STORAGELOCATIONID_2 =
        "shoppingItemStorageLocation.storageLocationId = ?";
    private static final String _SQL_SELECT_SHOPPINGITEMSTORAGELOCATION = "SELECT shoppingItemStorageLocation FROM ShoppingItemStorageLocation shoppingItemStorageLocation";
    private static final String _SQL_SELECT_SHOPPINGITEMSTORAGELOCATION_WHERE = "SELECT shoppingItemStorageLocation FROM ShoppingItemStorageLocation shoppingItemStorageLocation WHERE ";
    private static final String _SQL_COUNT_SHOPPINGITEMSTORAGELOCATION = "SELECT COUNT(shoppingItemStorageLocation) FROM ShoppingItemStorageLocation shoppingItemStorageLocation";
    private static final String _SQL_COUNT_SHOPPINGITEMSTORAGELOCATION_WHERE = "SELECT COUNT(shoppingItemStorageLocation) FROM ShoppingItemStorageLocation shoppingItemStorageLocation WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "shoppingItemStorageLocation.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ShoppingItemStorageLocation exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ShoppingItemStorageLocation exists with the key {";
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
     * Returns all the shopping item storage locations where groupId = &#63;.
     *
     * @param groupId the group ID
     * @return the matching shopping item storage locations
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ShoppingItemStorageLocation> findByGroupId(long groupId)
        throws SystemException {
        return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the shopping item storage locations where groupId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingItemStorageLocationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param groupId the group ID
     * @param start the lower bound of the range of shopping item storage locations
     * @param end the upper bound of the range of shopping item storage locations (not inclusive)
     * @return the range of matching shopping item storage locations
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ShoppingItemStorageLocation> findByGroupId(long groupId,
        int start, int end) throws SystemException {
        return findByGroupId(groupId, start, end, null);
    }

    /**
     * Returns an ordered range of all the shopping item storage locations where groupId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingItemStorageLocationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param groupId the group ID
     * @param start the lower bound of the range of shopping item storage locations
     * @param end the upper bound of the range of shopping item storage locations (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching shopping item storage locations
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ShoppingItemStorageLocation> findByGroupId(long groupId,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID;
            finderArgs = new Object[] { groupId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID;
            finderArgs = new Object[] { groupId, start, end, orderByComparator };
        }

        List<ShoppingItemStorageLocation> list = (List<ShoppingItemStorageLocation>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (ShoppingItemStorageLocation shoppingItemStorageLocation : list) {
                if ((groupId != shoppingItemStorageLocation.getGroupId())) {
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

            query.append(_SQL_SELECT_SHOPPINGITEMSTORAGELOCATION_WHERE);

            query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(ShoppingItemStorageLocationModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(groupId);

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
     * Returns the first shopping item storage location in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching shopping item storage location
     * @throws com.fsquare.shopping.NoSuchShoppingItemStorageLocationException if a matching shopping item storage location could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingItemStorageLocation findByGroupId_First(long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchShoppingItemStorageLocationException, SystemException {
        ShoppingItemStorageLocation shoppingItemStorageLocation = fetchByGroupId_First(groupId,
                orderByComparator);

        if (shoppingItemStorageLocation != null) {
            return shoppingItemStorageLocation;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("groupId=");
        msg.append(groupId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchShoppingItemStorageLocationException(msg.toString());
    }

    /**
     * Returns the first shopping item storage location in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching shopping item storage location, or <code>null</code> if a matching shopping item storage location could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingItemStorageLocation fetchByGroupId_First(long groupId,
        OrderByComparator orderByComparator) throws SystemException {
        List<ShoppingItemStorageLocation> list = findByGroupId(groupId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last shopping item storage location in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching shopping item storage location
     * @throws com.fsquare.shopping.NoSuchShoppingItemStorageLocationException if a matching shopping item storage location could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingItemStorageLocation findByGroupId_Last(long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchShoppingItemStorageLocationException, SystemException {
        ShoppingItemStorageLocation shoppingItemStorageLocation = fetchByGroupId_Last(groupId,
                orderByComparator);

        if (shoppingItemStorageLocation != null) {
            return shoppingItemStorageLocation;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("groupId=");
        msg.append(groupId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchShoppingItemStorageLocationException(msg.toString());
    }

    /**
     * Returns the last shopping item storage location in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching shopping item storage location, or <code>null</code> if a matching shopping item storage location could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingItemStorageLocation fetchByGroupId_Last(long groupId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByGroupId(groupId);

        if (count == 0) {
            return null;
        }

        List<ShoppingItemStorageLocation> list = findByGroupId(groupId,
                count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the shopping item storage locations before and after the current shopping item storage location in the ordered set where groupId = &#63;.
     *
     * @param itemStorageLocationId the primary key of the current shopping item storage location
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next shopping item storage location
     * @throws com.fsquare.shopping.NoSuchShoppingItemStorageLocationException if a shopping item storage location with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingItemStorageLocation[] findByGroupId_PrevAndNext(
        long itemStorageLocationId, long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchShoppingItemStorageLocationException, SystemException {
        ShoppingItemStorageLocation shoppingItemStorageLocation = findByPrimaryKey(itemStorageLocationId);

        Session session = null;

        try {
            session = openSession();

            ShoppingItemStorageLocation[] array = new ShoppingItemStorageLocationImpl[3];

            array[0] = getByGroupId_PrevAndNext(session,
                    shoppingItemStorageLocation, groupId, orderByComparator,
                    true);

            array[1] = shoppingItemStorageLocation;

            array[2] = getByGroupId_PrevAndNext(session,
                    shoppingItemStorageLocation, groupId, orderByComparator,
                    false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected ShoppingItemStorageLocation getByGroupId_PrevAndNext(
        Session session,
        ShoppingItemStorageLocation shoppingItemStorageLocation, long groupId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_SHOPPINGITEMSTORAGELOCATION_WHERE);

        query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

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
            query.append(ShoppingItemStorageLocationModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(groupId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(shoppingItemStorageLocation);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<ShoppingItemStorageLocation> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the shopping item storage locations where groupId = &#63; from the database.
     *
     * @param groupId the group ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByGroupId(long groupId) throws SystemException {
        for (ShoppingItemStorageLocation shoppingItemStorageLocation : findByGroupId(
                groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(shoppingItemStorageLocation);
        }
    }

    /**
     * Returns the number of shopping item storage locations where groupId = &#63;.
     *
     * @param groupId the group ID
     * @return the number of matching shopping item storage locations
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByGroupId(long groupId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPID;

        Object[] finderArgs = new Object[] { groupId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_SHOPPINGITEMSTORAGELOCATION_WHERE);

            query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(groupId);

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
     * Returns all the shopping item storage locations where storageLocationId = &#63;.
     *
     * @param storageLocationId the storage location ID
     * @return the matching shopping item storage locations
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ShoppingItemStorageLocation> findByStorageLocationId(
        long storageLocationId) throws SystemException {
        return findByStorageLocationId(storageLocationId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the shopping item storage locations where storageLocationId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingItemStorageLocationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param storageLocationId the storage location ID
     * @param start the lower bound of the range of shopping item storage locations
     * @param end the upper bound of the range of shopping item storage locations (not inclusive)
     * @return the range of matching shopping item storage locations
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ShoppingItemStorageLocation> findByStorageLocationId(
        long storageLocationId, int start, int end) throws SystemException {
        return findByStorageLocationId(storageLocationId, start, end, null);
    }

    /**
     * Returns an ordered range of all the shopping item storage locations where storageLocationId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingItemStorageLocationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param storageLocationId the storage location ID
     * @param start the lower bound of the range of shopping item storage locations
     * @param end the upper bound of the range of shopping item storage locations (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching shopping item storage locations
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ShoppingItemStorageLocation> findByStorageLocationId(
        long storageLocationId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STORAGELOCATIONID;
            finderArgs = new Object[] { storageLocationId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STORAGELOCATIONID;
            finderArgs = new Object[] {
                    storageLocationId,
                    
                    start, end, orderByComparator
                };
        }

        List<ShoppingItemStorageLocation> list = (List<ShoppingItemStorageLocation>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (ShoppingItemStorageLocation shoppingItemStorageLocation : list) {
                if ((storageLocationId != shoppingItemStorageLocation.getStorageLocationId())) {
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

            query.append(_SQL_SELECT_SHOPPINGITEMSTORAGELOCATION_WHERE);

            query.append(_FINDER_COLUMN_STORAGELOCATIONID_STORAGELOCATIONID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(ShoppingItemStorageLocationModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(storageLocationId);

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
     * Returns the first shopping item storage location in the ordered set where storageLocationId = &#63;.
     *
     * @param storageLocationId the storage location ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching shopping item storage location
     * @throws com.fsquare.shopping.NoSuchShoppingItemStorageLocationException if a matching shopping item storage location could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingItemStorageLocation findByStorageLocationId_First(
        long storageLocationId, OrderByComparator orderByComparator)
        throws NoSuchShoppingItemStorageLocationException, SystemException {
        ShoppingItemStorageLocation shoppingItemStorageLocation = fetchByStorageLocationId_First(storageLocationId,
                orderByComparator);

        if (shoppingItemStorageLocation != null) {
            return shoppingItemStorageLocation;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("storageLocationId=");
        msg.append(storageLocationId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchShoppingItemStorageLocationException(msg.toString());
    }

    /**
     * Returns the first shopping item storage location in the ordered set where storageLocationId = &#63;.
     *
     * @param storageLocationId the storage location ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching shopping item storage location, or <code>null</code> if a matching shopping item storage location could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingItemStorageLocation fetchByStorageLocationId_First(
        long storageLocationId, OrderByComparator orderByComparator)
        throws SystemException {
        List<ShoppingItemStorageLocation> list = findByStorageLocationId(storageLocationId,
                0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last shopping item storage location in the ordered set where storageLocationId = &#63;.
     *
     * @param storageLocationId the storage location ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching shopping item storage location
     * @throws com.fsquare.shopping.NoSuchShoppingItemStorageLocationException if a matching shopping item storage location could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingItemStorageLocation findByStorageLocationId_Last(
        long storageLocationId, OrderByComparator orderByComparator)
        throws NoSuchShoppingItemStorageLocationException, SystemException {
        ShoppingItemStorageLocation shoppingItemStorageLocation = fetchByStorageLocationId_Last(storageLocationId,
                orderByComparator);

        if (shoppingItemStorageLocation != null) {
            return shoppingItemStorageLocation;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("storageLocationId=");
        msg.append(storageLocationId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchShoppingItemStorageLocationException(msg.toString());
    }

    /**
     * Returns the last shopping item storage location in the ordered set where storageLocationId = &#63;.
     *
     * @param storageLocationId the storage location ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching shopping item storage location, or <code>null</code> if a matching shopping item storage location could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingItemStorageLocation fetchByStorageLocationId_Last(
        long storageLocationId, OrderByComparator orderByComparator)
        throws SystemException {
        int count = countByStorageLocationId(storageLocationId);

        if (count == 0) {
            return null;
        }

        List<ShoppingItemStorageLocation> list = findByStorageLocationId(storageLocationId,
                count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the shopping item storage locations before and after the current shopping item storage location in the ordered set where storageLocationId = &#63;.
     *
     * @param itemStorageLocationId the primary key of the current shopping item storage location
     * @param storageLocationId the storage location ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next shopping item storage location
     * @throws com.fsquare.shopping.NoSuchShoppingItemStorageLocationException if a shopping item storage location with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingItemStorageLocation[] findByStorageLocationId_PrevAndNext(
        long itemStorageLocationId, long storageLocationId,
        OrderByComparator orderByComparator)
        throws NoSuchShoppingItemStorageLocationException, SystemException {
        ShoppingItemStorageLocation shoppingItemStorageLocation = findByPrimaryKey(itemStorageLocationId);

        Session session = null;

        try {
            session = openSession();

            ShoppingItemStorageLocation[] array = new ShoppingItemStorageLocationImpl[3];

            array[0] = getByStorageLocationId_PrevAndNext(session,
                    shoppingItemStorageLocation, storageLocationId,
                    orderByComparator, true);

            array[1] = shoppingItemStorageLocation;

            array[2] = getByStorageLocationId_PrevAndNext(session,
                    shoppingItemStorageLocation, storageLocationId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected ShoppingItemStorageLocation getByStorageLocationId_PrevAndNext(
        Session session,
        ShoppingItemStorageLocation shoppingItemStorageLocation,
        long storageLocationId, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_SHOPPINGITEMSTORAGELOCATION_WHERE);

        query.append(_FINDER_COLUMN_STORAGELOCATIONID_STORAGELOCATIONID_2);

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
            query.append(ShoppingItemStorageLocationModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(storageLocationId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(shoppingItemStorageLocation);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<ShoppingItemStorageLocation> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the shopping item storage locations where storageLocationId = &#63; from the database.
     *
     * @param storageLocationId the storage location ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByStorageLocationId(long storageLocationId)
        throws SystemException {
        for (ShoppingItemStorageLocation shoppingItemStorageLocation : findByStorageLocationId(
                storageLocationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(shoppingItemStorageLocation);
        }
    }

    /**
     * Returns the number of shopping item storage locations where storageLocationId = &#63;.
     *
     * @param storageLocationId the storage location ID
     * @return the number of matching shopping item storage locations
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByStorageLocationId(long storageLocationId)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_STORAGELOCATIONID;

        Object[] finderArgs = new Object[] { storageLocationId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_SHOPPINGITEMSTORAGELOCATION_WHERE);

            query.append(_FINDER_COLUMN_STORAGELOCATIONID_STORAGELOCATIONID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(storageLocationId);

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
     * Returns all the shopping item storage locations where itemId = &#63;.
     *
     * @param itemId the item ID
     * @return the matching shopping item storage locations
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ShoppingItemStorageLocation> findByItemId(long itemId)
        throws SystemException {
        return findByItemId(itemId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the shopping item storage locations where itemId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingItemStorageLocationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param itemId the item ID
     * @param start the lower bound of the range of shopping item storage locations
     * @param end the upper bound of the range of shopping item storage locations (not inclusive)
     * @return the range of matching shopping item storage locations
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ShoppingItemStorageLocation> findByItemId(long itemId,
        int start, int end) throws SystemException {
        return findByItemId(itemId, start, end, null);
    }

    /**
     * Returns an ordered range of all the shopping item storage locations where itemId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingItemStorageLocationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param itemId the item ID
     * @param start the lower bound of the range of shopping item storage locations
     * @param end the upper bound of the range of shopping item storage locations (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching shopping item storage locations
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ShoppingItemStorageLocation> findByItemId(long itemId,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ITEMID;
            finderArgs = new Object[] { itemId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ITEMID;
            finderArgs = new Object[] { itemId, start, end, orderByComparator };
        }

        List<ShoppingItemStorageLocation> list = (List<ShoppingItemStorageLocation>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (ShoppingItemStorageLocation shoppingItemStorageLocation : list) {
                if ((itemId != shoppingItemStorageLocation.getItemId())) {
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

            query.append(_SQL_SELECT_SHOPPINGITEMSTORAGELOCATION_WHERE);

            query.append(_FINDER_COLUMN_ITEMID_ITEMID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(ShoppingItemStorageLocationModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(itemId);

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
     * Returns the first shopping item storage location in the ordered set where itemId = &#63;.
     *
     * @param itemId the item ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching shopping item storage location
     * @throws com.fsquare.shopping.NoSuchShoppingItemStorageLocationException if a matching shopping item storage location could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingItemStorageLocation findByItemId_First(long itemId,
        OrderByComparator orderByComparator)
        throws NoSuchShoppingItemStorageLocationException, SystemException {
        ShoppingItemStorageLocation shoppingItemStorageLocation = fetchByItemId_First(itemId,
                orderByComparator);

        if (shoppingItemStorageLocation != null) {
            return shoppingItemStorageLocation;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("itemId=");
        msg.append(itemId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchShoppingItemStorageLocationException(msg.toString());
    }

    /**
     * Returns the first shopping item storage location in the ordered set where itemId = &#63;.
     *
     * @param itemId the item ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching shopping item storage location, or <code>null</code> if a matching shopping item storage location could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingItemStorageLocation fetchByItemId_First(long itemId,
        OrderByComparator orderByComparator) throws SystemException {
        List<ShoppingItemStorageLocation> list = findByItemId(itemId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last shopping item storage location in the ordered set where itemId = &#63;.
     *
     * @param itemId the item ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching shopping item storage location
     * @throws com.fsquare.shopping.NoSuchShoppingItemStorageLocationException if a matching shopping item storage location could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingItemStorageLocation findByItemId_Last(long itemId,
        OrderByComparator orderByComparator)
        throws NoSuchShoppingItemStorageLocationException, SystemException {
        ShoppingItemStorageLocation shoppingItemStorageLocation = fetchByItemId_Last(itemId,
                orderByComparator);

        if (shoppingItemStorageLocation != null) {
            return shoppingItemStorageLocation;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("itemId=");
        msg.append(itemId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchShoppingItemStorageLocationException(msg.toString());
    }

    /**
     * Returns the last shopping item storage location in the ordered set where itemId = &#63;.
     *
     * @param itemId the item ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching shopping item storage location, or <code>null</code> if a matching shopping item storage location could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingItemStorageLocation fetchByItemId_Last(long itemId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByItemId(itemId);

        if (count == 0) {
            return null;
        }

        List<ShoppingItemStorageLocation> list = findByItemId(itemId,
                count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the shopping item storage locations before and after the current shopping item storage location in the ordered set where itemId = &#63;.
     *
     * @param itemStorageLocationId the primary key of the current shopping item storage location
     * @param itemId the item ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next shopping item storage location
     * @throws com.fsquare.shopping.NoSuchShoppingItemStorageLocationException if a shopping item storage location with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingItemStorageLocation[] findByItemId_PrevAndNext(
        long itemStorageLocationId, long itemId,
        OrderByComparator orderByComparator)
        throws NoSuchShoppingItemStorageLocationException, SystemException {
        ShoppingItemStorageLocation shoppingItemStorageLocation = findByPrimaryKey(itemStorageLocationId);

        Session session = null;

        try {
            session = openSession();

            ShoppingItemStorageLocation[] array = new ShoppingItemStorageLocationImpl[3];

            array[0] = getByItemId_PrevAndNext(session,
                    shoppingItemStorageLocation, itemId, orderByComparator, true);

            array[1] = shoppingItemStorageLocation;

            array[2] = getByItemId_PrevAndNext(session,
                    shoppingItemStorageLocation, itemId, orderByComparator,
                    false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected ShoppingItemStorageLocation getByItemId_PrevAndNext(
        Session session,
        ShoppingItemStorageLocation shoppingItemStorageLocation, long itemId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_SHOPPINGITEMSTORAGELOCATION_WHERE);

        query.append(_FINDER_COLUMN_ITEMID_ITEMID_2);

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
            query.append(ShoppingItemStorageLocationModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(itemId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(shoppingItemStorageLocation);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<ShoppingItemStorageLocation> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the shopping item storage locations where itemId = &#63; from the database.
     *
     * @param itemId the item ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByItemId(long itemId) throws SystemException {
        for (ShoppingItemStorageLocation shoppingItemStorageLocation : findByItemId(
                itemId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(shoppingItemStorageLocation);
        }
    }

    /**
     * Returns the number of shopping item storage locations where itemId = &#63;.
     *
     * @param itemId the item ID
     * @return the number of matching shopping item storage locations
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByItemId(long itemId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_ITEMID;

        Object[] finderArgs = new Object[] { itemId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_SHOPPINGITEMSTORAGELOCATION_WHERE);

            query.append(_FINDER_COLUMN_ITEMID_ITEMID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(itemId);

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
     * Returns the shopping item storage location where itemId = &#63; and storageLocationId = &#63; or throws a {@link com.fsquare.shopping.NoSuchShoppingItemStorageLocationException} if it could not be found.
     *
     * @param itemId the item ID
     * @param storageLocationId the storage location ID
     * @return the matching shopping item storage location
     * @throws com.fsquare.shopping.NoSuchShoppingItemStorageLocationException if a matching shopping item storage location could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingItemStorageLocation findByItemIdAndStorageLocationId(
        long itemId, long storageLocationId)
        throws NoSuchShoppingItemStorageLocationException, SystemException {
        ShoppingItemStorageLocation shoppingItemStorageLocation = fetchByItemIdAndStorageLocationId(itemId,
                storageLocationId);

        if (shoppingItemStorageLocation == null) {
            StringBundler msg = new StringBundler(6);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("itemId=");
            msg.append(itemId);

            msg.append(", storageLocationId=");
            msg.append(storageLocationId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchShoppingItemStorageLocationException(msg.toString());
        }

        return shoppingItemStorageLocation;
    }

    /**
     * Returns the shopping item storage location where itemId = &#63; and storageLocationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param itemId the item ID
     * @param storageLocationId the storage location ID
     * @return the matching shopping item storage location, or <code>null</code> if a matching shopping item storage location could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingItemStorageLocation fetchByItemIdAndStorageLocationId(
        long itemId, long storageLocationId) throws SystemException {
        return fetchByItemIdAndStorageLocationId(itemId, storageLocationId, true);
    }

    /**
     * Returns the shopping item storage location where itemId = &#63; and storageLocationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param itemId the item ID
     * @param storageLocationId the storage location ID
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching shopping item storage location, or <code>null</code> if a matching shopping item storage location could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingItemStorageLocation fetchByItemIdAndStorageLocationId(
        long itemId, long storageLocationId, boolean retrieveFromCache)
        throws SystemException {
        Object[] finderArgs = new Object[] { itemId, storageLocationId };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_ITEMIDANDSTORAGELOCATIONID,
                    finderArgs, this);
        }

        if (result instanceof ShoppingItemStorageLocation) {
            ShoppingItemStorageLocation shoppingItemStorageLocation = (ShoppingItemStorageLocation) result;

            if ((itemId != shoppingItemStorageLocation.getItemId()) ||
                    (storageLocationId != shoppingItemStorageLocation.getStorageLocationId())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(4);

            query.append(_SQL_SELECT_SHOPPINGITEMSTORAGELOCATION_WHERE);

            query.append(_FINDER_COLUMN_ITEMIDANDSTORAGELOCATIONID_ITEMID_2);

            query.append(_FINDER_COLUMN_ITEMIDANDSTORAGELOCATIONID_STORAGELOCATIONID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(itemId);

                qPos.add(storageLocationId);

                List<ShoppingItemStorageLocation> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ITEMIDANDSTORAGELOCATIONID,
                        finderArgs, list);
                } else {
                    ShoppingItemStorageLocation shoppingItemStorageLocation = list.get(0);

                    result = shoppingItemStorageLocation;

                    cacheResult(shoppingItemStorageLocation);

                    if ((shoppingItemStorageLocation.getItemId() != itemId) ||
                            (shoppingItemStorageLocation.getStorageLocationId() != storageLocationId)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ITEMIDANDSTORAGELOCATIONID,
                            finderArgs, shoppingItemStorageLocation);
                    }
                }
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ITEMIDANDSTORAGELOCATIONID,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        if (result instanceof List<?>) {
            return null;
        } else {
            return (ShoppingItemStorageLocation) result;
        }
    }

    /**
     * Removes the shopping item storage location where itemId = &#63; and storageLocationId = &#63; from the database.
     *
     * @param itemId the item ID
     * @param storageLocationId the storage location ID
     * @return the shopping item storage location that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingItemStorageLocation removeByItemIdAndStorageLocationId(
        long itemId, long storageLocationId)
        throws NoSuchShoppingItemStorageLocationException, SystemException {
        ShoppingItemStorageLocation shoppingItemStorageLocation = findByItemIdAndStorageLocationId(itemId,
                storageLocationId);

        return remove(shoppingItemStorageLocation);
    }

    /**
     * Returns the number of shopping item storage locations where itemId = &#63; and storageLocationId = &#63;.
     *
     * @param itemId the item ID
     * @param storageLocationId the storage location ID
     * @return the number of matching shopping item storage locations
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByItemIdAndStorageLocationId(long itemId,
        long storageLocationId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_ITEMIDANDSTORAGELOCATIONID;

        Object[] finderArgs = new Object[] { itemId, storageLocationId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_SHOPPINGITEMSTORAGELOCATION_WHERE);

            query.append(_FINDER_COLUMN_ITEMIDANDSTORAGELOCATIONID_ITEMID_2);

            query.append(_FINDER_COLUMN_ITEMIDANDSTORAGELOCATIONID_STORAGELOCATIONID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(itemId);

                qPos.add(storageLocationId);

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

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ITEMIDANDSTORAGELOCATIONID,
            new Object[] {
                shoppingItemStorageLocation.getItemId(),
                shoppingItemStorageLocation.getStorageLocationId()
            }, shoppingItemStorageLocation);

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

        clearUniqueFindersCache(shoppingItemStorageLocation);
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

            clearUniqueFindersCache(shoppingItemStorageLocation);
        }
    }

    protected void cacheUniqueFindersCache(
        ShoppingItemStorageLocation shoppingItemStorageLocation) {
        if (shoppingItemStorageLocation.isNew()) {
            Object[] args = new Object[] {
                    shoppingItemStorageLocation.getItemId(),
                    shoppingItemStorageLocation.getStorageLocationId()
                };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ITEMIDANDSTORAGELOCATIONID,
                args, Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ITEMIDANDSTORAGELOCATIONID,
                args, shoppingItemStorageLocation);
        } else {
            ShoppingItemStorageLocationModelImpl shoppingItemStorageLocationModelImpl =
                (ShoppingItemStorageLocationModelImpl) shoppingItemStorageLocation;

            if ((shoppingItemStorageLocationModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_ITEMIDANDSTORAGELOCATIONID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        shoppingItemStorageLocation.getItemId(),
                        shoppingItemStorageLocation.getStorageLocationId()
                    };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ITEMIDANDSTORAGELOCATIONID,
                    args, Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ITEMIDANDSTORAGELOCATIONID,
                    args, shoppingItemStorageLocation);
            }
        }
    }

    protected void clearUniqueFindersCache(
        ShoppingItemStorageLocation shoppingItemStorageLocation) {
        ShoppingItemStorageLocationModelImpl shoppingItemStorageLocationModelImpl =
            (ShoppingItemStorageLocationModelImpl) shoppingItemStorageLocation;

        Object[] args = new Object[] {
                shoppingItemStorageLocation.getItemId(),
                shoppingItemStorageLocation.getStorageLocationId()
            };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ITEMIDANDSTORAGELOCATIONID,
            args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ITEMIDANDSTORAGELOCATIONID,
            args);

        if ((shoppingItemStorageLocationModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_ITEMIDANDSTORAGELOCATIONID.getColumnBitmask()) != 0) {
            args = new Object[] {
                    shoppingItemStorageLocationModelImpl.getOriginalItemId(),
                    shoppingItemStorageLocationModelImpl.getOriginalStorageLocationId()
                };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ITEMIDANDSTORAGELOCATIONID,
                args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ITEMIDANDSTORAGELOCATIONID,
                args);
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

        ShoppingItemStorageLocationModelImpl shoppingItemStorageLocationModelImpl =
            (ShoppingItemStorageLocationModelImpl) shoppingItemStorageLocation;

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

        if (isNew ||
                !ShoppingItemStorageLocationModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((shoppingItemStorageLocationModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        shoppingItemStorageLocationModelImpl.getOriginalGroupId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
                    args);

                args = new Object[] {
                        shoppingItemStorageLocationModelImpl.getGroupId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
                    args);
            }

            if ((shoppingItemStorageLocationModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STORAGELOCATIONID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        shoppingItemStorageLocationModelImpl.getOriginalStorageLocationId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STORAGELOCATIONID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STORAGELOCATIONID,
                    args);

                args = new Object[] {
                        shoppingItemStorageLocationModelImpl.getStorageLocationId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STORAGELOCATIONID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STORAGELOCATIONID,
                    args);
            }

            if ((shoppingItemStorageLocationModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ITEMID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        shoppingItemStorageLocationModelImpl.getOriginalItemId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ITEMID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ITEMID,
                    args);

                args = new Object[] {
                        shoppingItemStorageLocationModelImpl.getItemId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ITEMID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ITEMID,
                    args);
            }
        }

        EntityCacheUtil.putResult(ShoppingItemStorageLocationModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingItemStorageLocationImpl.class,
            shoppingItemStorageLocation.getPrimaryKey(),
            shoppingItemStorageLocation);

        clearUniqueFindersCache(shoppingItemStorageLocation);
        cacheUniqueFindersCache(shoppingItemStorageLocation);

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
