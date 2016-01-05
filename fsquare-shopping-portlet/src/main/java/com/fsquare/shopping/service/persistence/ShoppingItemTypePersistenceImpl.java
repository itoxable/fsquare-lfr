package com.fsquare.shopping.service.persistence;

import com.fsquare.shopping.NoSuchShoppingItemTypeException;
import com.fsquare.shopping.model.ShoppingItemType;
import com.fsquare.shopping.model.impl.ShoppingItemTypeImpl;
import com.fsquare.shopping.model.impl.ShoppingItemTypeModelImpl;
import com.fsquare.shopping.service.persistence.ShoppingItemTypePersistence;

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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the shopping item type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingItemTypePersistence
 * @see ShoppingItemTypeUtil
 * @generated
 */
public class ShoppingItemTypePersistenceImpl extends BasePersistenceImpl<ShoppingItemType>
    implements ShoppingItemTypePersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link ShoppingItemTypeUtil} to access the shopping item type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = ShoppingItemTypeImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ShoppingItemTypeModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingItemTypeModelImpl.FINDER_CACHE_ENABLED,
            ShoppingItemTypeImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ShoppingItemTypeModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingItemTypeModelImpl.FINDER_CACHE_ENABLED,
            ShoppingItemTypeImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ShoppingItemTypeModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingItemTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(ShoppingItemTypeModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingItemTypeModelImpl.FINDER_CACHE_ENABLED,
            ShoppingItemTypeImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findByGroupId",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
        new FinderPath(ShoppingItemTypeModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingItemTypeModelImpl.FINDER_CACHE_ENABLED,
            ShoppingItemTypeImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
            new String[] { Long.class.getName() },
            ShoppingItemTypeModelImpl.GROUPID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(ShoppingItemTypeModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingItemTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "shoppingItemType.groupId = ?";
    public static final FinderPath FINDER_PATH_FETCH_BY_NAMEANDGROUPID = new FinderPath(ShoppingItemTypeModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingItemTypeModelImpl.FINDER_CACHE_ENABLED,
            ShoppingItemTypeImpl.class, FINDER_CLASS_NAME_ENTITY,
            "fetchByNameAndGroupId",
            new String[] { String.class.getName(), Long.class.getName() },
            ShoppingItemTypeModelImpl.NAME_COLUMN_BITMASK |
            ShoppingItemTypeModelImpl.GROUPID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_NAMEANDGROUPID = new FinderPath(ShoppingItemTypeModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingItemTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByNameAndGroupId",
            new String[] { String.class.getName(), Long.class.getName() });
    private static final String _FINDER_COLUMN_NAMEANDGROUPID_NAME_1 = "shoppingItemType.name IS NULL AND ";
    private static final String _FINDER_COLUMN_NAMEANDGROUPID_NAME_2 = "shoppingItemType.name = ? AND ";
    private static final String _FINDER_COLUMN_NAMEANDGROUPID_NAME_3 = "(shoppingItemType.name IS NULL OR shoppingItemType.name = '') AND ";
    private static final String _FINDER_COLUMN_NAMEANDGROUPID_GROUPID_2 = "shoppingItemType.groupId = ?";
    private static final String _SQL_SELECT_SHOPPINGITEMTYPE = "SELECT shoppingItemType FROM ShoppingItemType shoppingItemType";
    private static final String _SQL_SELECT_SHOPPINGITEMTYPE_WHERE = "SELECT shoppingItemType FROM ShoppingItemType shoppingItemType WHERE ";
    private static final String _SQL_COUNT_SHOPPINGITEMTYPE = "SELECT COUNT(shoppingItemType) FROM ShoppingItemType shoppingItemType";
    private static final String _SQL_COUNT_SHOPPINGITEMTYPE_WHERE = "SELECT COUNT(shoppingItemType) FROM ShoppingItemType shoppingItemType WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "shoppingItemType.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ShoppingItemType exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ShoppingItemType exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(ShoppingItemTypePersistenceImpl.class);
    private static ShoppingItemType _nullShoppingItemType = new ShoppingItemTypeImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<ShoppingItemType> toCacheModel() {
                return _nullShoppingItemTypeCacheModel;
            }
        };

    private static CacheModel<ShoppingItemType> _nullShoppingItemTypeCacheModel = new CacheModel<ShoppingItemType>() {
            @Override
            public ShoppingItemType toEntityModel() {
                return _nullShoppingItemType;
            }
        };

    public ShoppingItemTypePersistenceImpl() {
        setModelClass(ShoppingItemType.class);
    }

    /**
     * Returns all the shopping item types where groupId = &#63;.
     *
     * @param groupId the group ID
     * @return the matching shopping item types
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ShoppingItemType> findByGroupId(long groupId)
        throws SystemException {
        return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the shopping item types where groupId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingItemTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param groupId the group ID
     * @param start the lower bound of the range of shopping item types
     * @param end the upper bound of the range of shopping item types (not inclusive)
     * @return the range of matching shopping item types
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ShoppingItemType> findByGroupId(long groupId, int start, int end)
        throws SystemException {
        return findByGroupId(groupId, start, end, null);
    }

    /**
     * Returns an ordered range of all the shopping item types where groupId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingItemTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param groupId the group ID
     * @param start the lower bound of the range of shopping item types
     * @param end the upper bound of the range of shopping item types (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching shopping item types
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ShoppingItemType> findByGroupId(long groupId, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
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

        List<ShoppingItemType> list = (List<ShoppingItemType>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (ShoppingItemType shoppingItemType : list) {
                if ((groupId != shoppingItemType.getGroupId())) {
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

            query.append(_SQL_SELECT_SHOPPINGITEMTYPE_WHERE);

            query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(ShoppingItemTypeModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(groupId);

                if (!pagination) {
                    list = (List<ShoppingItemType>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<ShoppingItemType>(list);
                } else {
                    list = (List<ShoppingItemType>) QueryUtil.list(q,
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
     * Returns the first shopping item type in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching shopping item type
     * @throws com.fsquare.shopping.NoSuchShoppingItemTypeException if a matching shopping item type could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingItemType findByGroupId_First(long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchShoppingItemTypeException, SystemException {
        ShoppingItemType shoppingItemType = fetchByGroupId_First(groupId,
                orderByComparator);

        if (shoppingItemType != null) {
            return shoppingItemType;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("groupId=");
        msg.append(groupId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchShoppingItemTypeException(msg.toString());
    }

    /**
     * Returns the first shopping item type in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching shopping item type, or <code>null</code> if a matching shopping item type could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingItemType fetchByGroupId_First(long groupId,
        OrderByComparator orderByComparator) throws SystemException {
        List<ShoppingItemType> list = findByGroupId(groupId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last shopping item type in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching shopping item type
     * @throws com.fsquare.shopping.NoSuchShoppingItemTypeException if a matching shopping item type could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingItemType findByGroupId_Last(long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchShoppingItemTypeException, SystemException {
        ShoppingItemType shoppingItemType = fetchByGroupId_Last(groupId,
                orderByComparator);

        if (shoppingItemType != null) {
            return shoppingItemType;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("groupId=");
        msg.append(groupId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchShoppingItemTypeException(msg.toString());
    }

    /**
     * Returns the last shopping item type in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching shopping item type, or <code>null</code> if a matching shopping item type could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingItemType fetchByGroupId_Last(long groupId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByGroupId(groupId);

        if (count == 0) {
            return null;
        }

        List<ShoppingItemType> list = findByGroupId(groupId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the shopping item types before and after the current shopping item type in the ordered set where groupId = &#63;.
     *
     * @param itemTypeId the primary key of the current shopping item type
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next shopping item type
     * @throws com.fsquare.shopping.NoSuchShoppingItemTypeException if a shopping item type with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingItemType[] findByGroupId_PrevAndNext(long itemTypeId,
        long groupId, OrderByComparator orderByComparator)
        throws NoSuchShoppingItemTypeException, SystemException {
        ShoppingItemType shoppingItemType = findByPrimaryKey(itemTypeId);

        Session session = null;

        try {
            session = openSession();

            ShoppingItemType[] array = new ShoppingItemTypeImpl[3];

            array[0] = getByGroupId_PrevAndNext(session, shoppingItemType,
                    groupId, orderByComparator, true);

            array[1] = shoppingItemType;

            array[2] = getByGroupId_PrevAndNext(session, shoppingItemType,
                    groupId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected ShoppingItemType getByGroupId_PrevAndNext(Session session,
        ShoppingItemType shoppingItemType, long groupId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_SHOPPINGITEMTYPE_WHERE);

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
            query.append(ShoppingItemTypeModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(groupId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(shoppingItemType);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<ShoppingItemType> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the shopping item types where groupId = &#63; from the database.
     *
     * @param groupId the group ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByGroupId(long groupId) throws SystemException {
        for (ShoppingItemType shoppingItemType : findByGroupId(groupId,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(shoppingItemType);
        }
    }

    /**
     * Returns the number of shopping item types where groupId = &#63;.
     *
     * @param groupId the group ID
     * @return the number of matching shopping item types
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

            query.append(_SQL_COUNT_SHOPPINGITEMTYPE_WHERE);

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
     * Returns the shopping item type where name = &#63; and groupId = &#63; or throws a {@link com.fsquare.shopping.NoSuchShoppingItemTypeException} if it could not be found.
     *
     * @param name the name
     * @param groupId the group ID
     * @return the matching shopping item type
     * @throws com.fsquare.shopping.NoSuchShoppingItemTypeException if a matching shopping item type could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingItemType findByNameAndGroupId(String name, long groupId)
        throws NoSuchShoppingItemTypeException, SystemException {
        ShoppingItemType shoppingItemType = fetchByNameAndGroupId(name, groupId);

        if (shoppingItemType == null) {
            StringBundler msg = new StringBundler(6);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("name=");
            msg.append(name);

            msg.append(", groupId=");
            msg.append(groupId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchShoppingItemTypeException(msg.toString());
        }

        return shoppingItemType;
    }

    /**
     * Returns the shopping item type where name = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param name the name
     * @param groupId the group ID
     * @return the matching shopping item type, or <code>null</code> if a matching shopping item type could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingItemType fetchByNameAndGroupId(String name, long groupId)
        throws SystemException {
        return fetchByNameAndGroupId(name, groupId, true);
    }

    /**
     * Returns the shopping item type where name = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param name the name
     * @param groupId the group ID
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching shopping item type, or <code>null</code> if a matching shopping item type could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingItemType fetchByNameAndGroupId(String name, long groupId,
        boolean retrieveFromCache) throws SystemException {
        Object[] finderArgs = new Object[] { name, groupId };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_NAMEANDGROUPID,
                    finderArgs, this);
        }

        if (result instanceof ShoppingItemType) {
            ShoppingItemType shoppingItemType = (ShoppingItemType) result;

            if (!Validator.equals(name, shoppingItemType.getName()) ||
                    (groupId != shoppingItemType.getGroupId())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(4);

            query.append(_SQL_SELECT_SHOPPINGITEMTYPE_WHERE);

            boolean bindName = false;

            if (name == null) {
                query.append(_FINDER_COLUMN_NAMEANDGROUPID_NAME_1);
            } else if (name.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_NAMEANDGROUPID_NAME_3);
            } else {
                bindName = true;

                query.append(_FINDER_COLUMN_NAMEANDGROUPID_NAME_2);
            }

            query.append(_FINDER_COLUMN_NAMEANDGROUPID_GROUPID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindName) {
                    qPos.add(name);
                }

                qPos.add(groupId);

                List<ShoppingItemType> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAMEANDGROUPID,
                        finderArgs, list);
                } else {
                    ShoppingItemType shoppingItemType = list.get(0);

                    result = shoppingItemType;

                    cacheResult(shoppingItemType);

                    if ((shoppingItemType.getName() == null) ||
                            !shoppingItemType.getName().equals(name) ||
                            (shoppingItemType.getGroupId() != groupId)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAMEANDGROUPID,
                            finderArgs, shoppingItemType);
                    }
                }
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAMEANDGROUPID,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        if (result instanceof List<?>) {
            return null;
        } else {
            return (ShoppingItemType) result;
        }
    }

    /**
     * Removes the shopping item type where name = &#63; and groupId = &#63; from the database.
     *
     * @param name the name
     * @param groupId the group ID
     * @return the shopping item type that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingItemType removeByNameAndGroupId(String name, long groupId)
        throws NoSuchShoppingItemTypeException, SystemException {
        ShoppingItemType shoppingItemType = findByNameAndGroupId(name, groupId);

        return remove(shoppingItemType);
    }

    /**
     * Returns the number of shopping item types where name = &#63; and groupId = &#63;.
     *
     * @param name the name
     * @param groupId the group ID
     * @return the number of matching shopping item types
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByNameAndGroupId(String name, long groupId)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_NAMEANDGROUPID;

        Object[] finderArgs = new Object[] { name, groupId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_SHOPPINGITEMTYPE_WHERE);

            boolean bindName = false;

            if (name == null) {
                query.append(_FINDER_COLUMN_NAMEANDGROUPID_NAME_1);
            } else if (name.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_NAMEANDGROUPID_NAME_3);
            } else {
                bindName = true;

                query.append(_FINDER_COLUMN_NAMEANDGROUPID_NAME_2);
            }

            query.append(_FINDER_COLUMN_NAMEANDGROUPID_GROUPID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindName) {
                    qPos.add(name);
                }

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
     * Caches the shopping item type in the entity cache if it is enabled.
     *
     * @param shoppingItemType the shopping item type
     */
    @Override
    public void cacheResult(ShoppingItemType shoppingItemType) {
        EntityCacheUtil.putResult(ShoppingItemTypeModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingItemTypeImpl.class, shoppingItemType.getPrimaryKey(),
            shoppingItemType);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAMEANDGROUPID,
            new Object[] {
                shoppingItemType.getName(), shoppingItemType.getGroupId()
            }, shoppingItemType);

        shoppingItemType.resetOriginalValues();
    }

    /**
     * Caches the shopping item types in the entity cache if it is enabled.
     *
     * @param shoppingItemTypes the shopping item types
     */
    @Override
    public void cacheResult(List<ShoppingItemType> shoppingItemTypes) {
        for (ShoppingItemType shoppingItemType : shoppingItemTypes) {
            if (EntityCacheUtil.getResult(
                        ShoppingItemTypeModelImpl.ENTITY_CACHE_ENABLED,
                        ShoppingItemTypeImpl.class,
                        shoppingItemType.getPrimaryKey()) == null) {
                cacheResult(shoppingItemType);
            } else {
                shoppingItemType.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all shopping item types.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(ShoppingItemTypeImpl.class.getName());
        }

        EntityCacheUtil.clearCache(ShoppingItemTypeImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the shopping item type.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(ShoppingItemType shoppingItemType) {
        EntityCacheUtil.removeResult(ShoppingItemTypeModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingItemTypeImpl.class, shoppingItemType.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(shoppingItemType);
    }

    @Override
    public void clearCache(List<ShoppingItemType> shoppingItemTypes) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (ShoppingItemType shoppingItemType : shoppingItemTypes) {
            EntityCacheUtil.removeResult(ShoppingItemTypeModelImpl.ENTITY_CACHE_ENABLED,
                ShoppingItemTypeImpl.class, shoppingItemType.getPrimaryKey());

            clearUniqueFindersCache(shoppingItemType);
        }
    }

    protected void cacheUniqueFindersCache(ShoppingItemType shoppingItemType) {
        if (shoppingItemType.isNew()) {
            Object[] args = new Object[] {
                    shoppingItemType.getName(), shoppingItemType.getGroupId()
                };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NAMEANDGROUPID,
                args, Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAMEANDGROUPID,
                args, shoppingItemType);
        } else {
            ShoppingItemTypeModelImpl shoppingItemTypeModelImpl = (ShoppingItemTypeModelImpl) shoppingItemType;

            if ((shoppingItemTypeModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_NAMEANDGROUPID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        shoppingItemType.getName(),
                        shoppingItemType.getGroupId()
                    };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NAMEANDGROUPID,
                    args, Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAMEANDGROUPID,
                    args, shoppingItemType);
            }
        }
    }

    protected void clearUniqueFindersCache(ShoppingItemType shoppingItemType) {
        ShoppingItemTypeModelImpl shoppingItemTypeModelImpl = (ShoppingItemTypeModelImpl) shoppingItemType;

        Object[] args = new Object[] {
                shoppingItemType.getName(), shoppingItemType.getGroupId()
            };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAMEANDGROUPID, args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAMEANDGROUPID, args);

        if ((shoppingItemTypeModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_NAMEANDGROUPID.getColumnBitmask()) != 0) {
            args = new Object[] {
                    shoppingItemTypeModelImpl.getOriginalName(),
                    shoppingItemTypeModelImpl.getOriginalGroupId()
                };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAMEANDGROUPID,
                args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAMEANDGROUPID,
                args);
        }
    }

    /**
     * Creates a new shopping item type with the primary key. Does not add the shopping item type to the database.
     *
     * @param itemTypeId the primary key for the new shopping item type
     * @return the new shopping item type
     */
    @Override
    public ShoppingItemType create(long itemTypeId) {
        ShoppingItemType shoppingItemType = new ShoppingItemTypeImpl();

        shoppingItemType.setNew(true);
        shoppingItemType.setPrimaryKey(itemTypeId);

        return shoppingItemType;
    }

    /**
     * Removes the shopping item type with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param itemTypeId the primary key of the shopping item type
     * @return the shopping item type that was removed
     * @throws com.fsquare.shopping.NoSuchShoppingItemTypeException if a shopping item type with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingItemType remove(long itemTypeId)
        throws NoSuchShoppingItemTypeException, SystemException {
        return remove((Serializable) itemTypeId);
    }

    /**
     * Removes the shopping item type with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the shopping item type
     * @return the shopping item type that was removed
     * @throws com.fsquare.shopping.NoSuchShoppingItemTypeException if a shopping item type with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingItemType remove(Serializable primaryKey)
        throws NoSuchShoppingItemTypeException, SystemException {
        Session session = null;

        try {
            session = openSession();

            ShoppingItemType shoppingItemType = (ShoppingItemType) session.get(ShoppingItemTypeImpl.class,
                    primaryKey);

            if (shoppingItemType == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchShoppingItemTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(shoppingItemType);
        } catch (NoSuchShoppingItemTypeException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected ShoppingItemType removeImpl(ShoppingItemType shoppingItemType)
        throws SystemException {
        shoppingItemType = toUnwrappedModel(shoppingItemType);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(shoppingItemType)) {
                shoppingItemType = (ShoppingItemType) session.get(ShoppingItemTypeImpl.class,
                        shoppingItemType.getPrimaryKeyObj());
            }

            if (shoppingItemType != null) {
                session.delete(shoppingItemType);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (shoppingItemType != null) {
            clearCache(shoppingItemType);
        }

        return shoppingItemType;
    }

    @Override
    public ShoppingItemType updateImpl(
        com.fsquare.shopping.model.ShoppingItemType shoppingItemType)
        throws SystemException {
        shoppingItemType = toUnwrappedModel(shoppingItemType);

        boolean isNew = shoppingItemType.isNew();

        ShoppingItemTypeModelImpl shoppingItemTypeModelImpl = (ShoppingItemTypeModelImpl) shoppingItemType;

        Session session = null;

        try {
            session = openSession();

            if (shoppingItemType.isNew()) {
                session.save(shoppingItemType);

                shoppingItemType.setNew(false);
            } else {
                session.merge(shoppingItemType);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !ShoppingItemTypeModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((shoppingItemTypeModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        shoppingItemTypeModelImpl.getOriginalGroupId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
                    args);

                args = new Object[] { shoppingItemTypeModelImpl.getGroupId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
                    args);
            }
        }

        EntityCacheUtil.putResult(ShoppingItemTypeModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingItemTypeImpl.class, shoppingItemType.getPrimaryKey(),
            shoppingItemType);

        clearUniqueFindersCache(shoppingItemType);
        cacheUniqueFindersCache(shoppingItemType);

        return shoppingItemType;
    }

    protected ShoppingItemType toUnwrappedModel(
        ShoppingItemType shoppingItemType) {
        if (shoppingItemType instanceof ShoppingItemTypeImpl) {
            return shoppingItemType;
        }

        ShoppingItemTypeImpl shoppingItemTypeImpl = new ShoppingItemTypeImpl();

        shoppingItemTypeImpl.setNew(shoppingItemType.isNew());
        shoppingItemTypeImpl.setPrimaryKey(shoppingItemType.getPrimaryKey());

        shoppingItemTypeImpl.setItemTypeId(shoppingItemType.getItemTypeId());
        shoppingItemTypeImpl.setGroupId(shoppingItemType.getGroupId());
        shoppingItemTypeImpl.setCompanyId(shoppingItemType.getCompanyId());
        shoppingItemTypeImpl.setUserId(shoppingItemType.getUserId());
        shoppingItemTypeImpl.setUserName(shoppingItemType.getUserName());
        shoppingItemTypeImpl.setCreateDate(shoppingItemType.getCreateDate());
        shoppingItemTypeImpl.setModifiedDate(shoppingItemType.getModifiedDate());
        shoppingItemTypeImpl.setName(shoppingItemType.getName());
        shoppingItemTypeImpl.setDescription(shoppingItemType.getDescription());

        return shoppingItemTypeImpl;
    }

    /**
     * Returns the shopping item type with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the shopping item type
     * @return the shopping item type
     * @throws com.fsquare.shopping.NoSuchShoppingItemTypeException if a shopping item type with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingItemType findByPrimaryKey(Serializable primaryKey)
        throws NoSuchShoppingItemTypeException, SystemException {
        ShoppingItemType shoppingItemType = fetchByPrimaryKey(primaryKey);

        if (shoppingItemType == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchShoppingItemTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return shoppingItemType;
    }

    /**
     * Returns the shopping item type with the primary key or throws a {@link com.fsquare.shopping.NoSuchShoppingItemTypeException} if it could not be found.
     *
     * @param itemTypeId the primary key of the shopping item type
     * @return the shopping item type
     * @throws com.fsquare.shopping.NoSuchShoppingItemTypeException if a shopping item type with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingItemType findByPrimaryKey(long itemTypeId)
        throws NoSuchShoppingItemTypeException, SystemException {
        return findByPrimaryKey((Serializable) itemTypeId);
    }

    /**
     * Returns the shopping item type with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the shopping item type
     * @return the shopping item type, or <code>null</code> if a shopping item type with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingItemType fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        ShoppingItemType shoppingItemType = (ShoppingItemType) EntityCacheUtil.getResult(ShoppingItemTypeModelImpl.ENTITY_CACHE_ENABLED,
                ShoppingItemTypeImpl.class, primaryKey);

        if (shoppingItemType == _nullShoppingItemType) {
            return null;
        }

        if (shoppingItemType == null) {
            Session session = null;

            try {
                session = openSession();

                shoppingItemType = (ShoppingItemType) session.get(ShoppingItemTypeImpl.class,
                        primaryKey);

                if (shoppingItemType != null) {
                    cacheResult(shoppingItemType);
                } else {
                    EntityCacheUtil.putResult(ShoppingItemTypeModelImpl.ENTITY_CACHE_ENABLED,
                        ShoppingItemTypeImpl.class, primaryKey,
                        _nullShoppingItemType);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(ShoppingItemTypeModelImpl.ENTITY_CACHE_ENABLED,
                    ShoppingItemTypeImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return shoppingItemType;
    }

    /**
     * Returns the shopping item type with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param itemTypeId the primary key of the shopping item type
     * @return the shopping item type, or <code>null</code> if a shopping item type with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingItemType fetchByPrimaryKey(long itemTypeId)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) itemTypeId);
    }

    /**
     * Returns all the shopping item types.
     *
     * @return the shopping item types
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ShoppingItemType> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the shopping item types.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingItemTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of shopping item types
     * @param end the upper bound of the range of shopping item types (not inclusive)
     * @return the range of shopping item types
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ShoppingItemType> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the shopping item types.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingItemTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of shopping item types
     * @param end the upper bound of the range of shopping item types (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of shopping item types
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ShoppingItemType> findAll(int start, int end,
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

        List<ShoppingItemType> list = (List<ShoppingItemType>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_SHOPPINGITEMTYPE);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_SHOPPINGITEMTYPE;

                if (pagination) {
                    sql = sql.concat(ShoppingItemTypeModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<ShoppingItemType>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<ShoppingItemType>(list);
                } else {
                    list = (List<ShoppingItemType>) QueryUtil.list(q,
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
     * Removes all the shopping item types from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (ShoppingItemType shoppingItemType : findAll()) {
            remove(shoppingItemType);
        }
    }

    /**
     * Returns the number of shopping item types.
     *
     * @return the number of shopping item types
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

                Query q = session.createQuery(_SQL_COUNT_SHOPPINGITEMTYPE);

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
     * Initializes the shopping item type persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.fsquare.shopping.model.ShoppingItemType")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<ShoppingItemType>> listenersList = new ArrayList<ModelListener<ShoppingItemType>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<ShoppingItemType>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(ShoppingItemTypeImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
