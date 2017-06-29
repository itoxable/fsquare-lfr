package com.fsquare.shopping.service.persistence;

import com.fsquare.shopping.NoSuchShoppingItemException;
import com.fsquare.shopping.model.ShoppingItem;
import com.fsquare.shopping.model.impl.ShoppingItemImpl;
import com.fsquare.shopping.model.impl.ShoppingItemModelImpl;
import com.fsquare.shopping.service.persistence.ShoppingItemPersistence;

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
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the shopping item service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingItemPersistence
 * @see ShoppingItemUtil
 * @generated
 */
public class ShoppingItemPersistenceImpl extends BasePersistenceImpl<ShoppingItem>
    implements ShoppingItemPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link ShoppingItemUtil} to access the shopping item persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = ShoppingItemImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ShoppingItemModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingItemModelImpl.FINDER_CACHE_ENABLED, ShoppingItemImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ShoppingItemModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingItemModelImpl.FINDER_CACHE_ENABLED, ShoppingItemImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ShoppingItemModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingItemModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(ShoppingItemModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingItemModelImpl.FINDER_CACHE_ENABLED, ShoppingItemImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
            new String[] {
                String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(ShoppingItemModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingItemModelImpl.FINDER_CACHE_ENABLED, ShoppingItemImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
            new String[] { String.class.getName() },
            ShoppingItemModelImpl.UUID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(ShoppingItemModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingItemModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_UUID_UUID_1 = "shoppingItem.uuid IS NULL";
    private static final String _FINDER_COLUMN_UUID_UUID_2 = "shoppingItem.uuid = ?";
    private static final String _FINDER_COLUMN_UUID_UUID_3 = "(shoppingItem.uuid IS NULL OR shoppingItem.uuid = '')";
    public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(ShoppingItemModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingItemModelImpl.FINDER_CACHE_ENABLED, ShoppingItemImpl.class,
            FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
            new String[] { String.class.getName(), Long.class.getName() },
            ShoppingItemModelImpl.UUID_COLUMN_BITMASK |
            ShoppingItemModelImpl.GROUPID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(ShoppingItemModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingItemModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
            new String[] { String.class.getName(), Long.class.getName() });
    private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "shoppingItem.uuid IS NULL AND ";
    private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "shoppingItem.uuid = ? AND ";
    private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(shoppingItem.uuid IS NULL OR shoppingItem.uuid = '') AND ";
    private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "shoppingItem.groupId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(ShoppingItemModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingItemModelImpl.FINDER_CACHE_ENABLED, ShoppingItemImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
            new String[] {
                String.class.getName(), Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
        new FinderPath(ShoppingItemModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingItemModelImpl.FINDER_CACHE_ENABLED, ShoppingItemImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
            new String[] { String.class.getName(), Long.class.getName() },
            ShoppingItemModelImpl.UUID_COLUMN_BITMASK |
            ShoppingItemModelImpl.COMPANYID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(ShoppingItemModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingItemModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
            new String[] { String.class.getName(), Long.class.getName() });
    private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "shoppingItem.uuid IS NULL AND ";
    private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "shoppingItem.uuid = ? AND ";
    private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(shoppingItem.uuid IS NULL OR shoppingItem.uuid = '') AND ";
    private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "shoppingItem.companyId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID =
        new FinderPath(ShoppingItemModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingItemModelImpl.FINDER_CACHE_ENABLED, ShoppingItemImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompanyId",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID =
        new FinderPath(ShoppingItemModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingItemModelImpl.FINDER_CACHE_ENABLED, ShoppingItemImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyId",
            new String[] { Long.class.getName() },
            ShoppingItemModelImpl.COMPANYID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYID = new FinderPath(ShoppingItemModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingItemModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyId",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_COMPANYID_COMPANYID_2 = "shoppingItem.companyId = ?";
    private static final String _SQL_SELECT_SHOPPINGITEM = "SELECT shoppingItem FROM ShoppingItem shoppingItem";
    private static final String _SQL_SELECT_SHOPPINGITEM_WHERE = "SELECT shoppingItem FROM ShoppingItem shoppingItem WHERE ";
    private static final String _SQL_COUNT_SHOPPINGITEM = "SELECT COUNT(shoppingItem) FROM ShoppingItem shoppingItem";
    private static final String _SQL_COUNT_SHOPPINGITEM_WHERE = "SELECT COUNT(shoppingItem) FROM ShoppingItem shoppingItem WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "shoppingItem.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ShoppingItem exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ShoppingItem exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(ShoppingItemPersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "uuid"
            });
    private static ShoppingItem _nullShoppingItem = new ShoppingItemImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<ShoppingItem> toCacheModel() {
                return _nullShoppingItemCacheModel;
            }
        };

    private static CacheModel<ShoppingItem> _nullShoppingItemCacheModel = new CacheModel<ShoppingItem>() {
            @Override
            public ShoppingItem toEntityModel() {
                return _nullShoppingItem;
            }
        };

    public ShoppingItemPersistenceImpl() {
        setModelClass(ShoppingItem.class);
    }

    /**
     * Returns all the shopping items where uuid = &#63;.
     *
     * @param uuid the uuid
     * @return the matching shopping items
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ShoppingItem> findByUuid(String uuid) throws SystemException {
        return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the shopping items where uuid = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param uuid the uuid
     * @param start the lower bound of the range of shopping items
     * @param end the upper bound of the range of shopping items (not inclusive)
     * @return the range of matching shopping items
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ShoppingItem> findByUuid(String uuid, int start, int end)
        throws SystemException {
        return findByUuid(uuid, start, end, null);
    }

    /**
     * Returns an ordered range of all the shopping items where uuid = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param uuid the uuid
     * @param start the lower bound of the range of shopping items
     * @param end the upper bound of the range of shopping items (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching shopping items
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ShoppingItem> findByUuid(String uuid, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
            finderArgs = new Object[] { uuid };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
            finderArgs = new Object[] { uuid, start, end, orderByComparator };
        }

        List<ShoppingItem> list = (List<ShoppingItem>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (ShoppingItem shoppingItem : list) {
                if (!Validator.equals(uuid, shoppingItem.getUuid())) {
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

            query.append(_SQL_SELECT_SHOPPINGITEM_WHERE);

            boolean bindUuid = false;

            if (uuid == null) {
                query.append(_FINDER_COLUMN_UUID_UUID_1);
            } else if (uuid.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_UUID_UUID_3);
            } else {
                bindUuid = true;

                query.append(_FINDER_COLUMN_UUID_UUID_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(ShoppingItemModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindUuid) {
                    qPos.add(uuid);
                }

                if (!pagination) {
                    list = (List<ShoppingItem>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<ShoppingItem>(list);
                } else {
                    list = (List<ShoppingItem>) QueryUtil.list(q, getDialect(),
                            start, end);
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
     * Returns the first shopping item in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching shopping item
     * @throws com.fsquare.shopping.NoSuchShoppingItemException if a matching shopping item could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingItem findByUuid_First(String uuid,
        OrderByComparator orderByComparator)
        throws NoSuchShoppingItemException, SystemException {
        ShoppingItem shoppingItem = fetchByUuid_First(uuid, orderByComparator);

        if (shoppingItem != null) {
            return shoppingItem;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchShoppingItemException(msg.toString());
    }

    /**
     * Returns the first shopping item in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching shopping item, or <code>null</code> if a matching shopping item could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingItem fetchByUuid_First(String uuid,
        OrderByComparator orderByComparator) throws SystemException {
        List<ShoppingItem> list = findByUuid(uuid, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last shopping item in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching shopping item
     * @throws com.fsquare.shopping.NoSuchShoppingItemException if a matching shopping item could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingItem findByUuid_Last(String uuid,
        OrderByComparator orderByComparator)
        throws NoSuchShoppingItemException, SystemException {
        ShoppingItem shoppingItem = fetchByUuid_Last(uuid, orderByComparator);

        if (shoppingItem != null) {
            return shoppingItem;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchShoppingItemException(msg.toString());
    }

    /**
     * Returns the last shopping item in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching shopping item, or <code>null</code> if a matching shopping item could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingItem fetchByUuid_Last(String uuid,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByUuid(uuid);

        if (count == 0) {
            return null;
        }

        List<ShoppingItem> list = findByUuid(uuid, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the shopping items before and after the current shopping item in the ordered set where uuid = &#63;.
     *
     * @param itemId the primary key of the current shopping item
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next shopping item
     * @throws com.fsquare.shopping.NoSuchShoppingItemException if a shopping item with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingItem[] findByUuid_PrevAndNext(long itemId, String uuid,
        OrderByComparator orderByComparator)
        throws NoSuchShoppingItemException, SystemException {
        ShoppingItem shoppingItem = findByPrimaryKey(itemId);

        Session session = null;

        try {
            session = openSession();

            ShoppingItem[] array = new ShoppingItemImpl[3];

            array[0] = getByUuid_PrevAndNext(session, shoppingItem, uuid,
                    orderByComparator, true);

            array[1] = shoppingItem;

            array[2] = getByUuid_PrevAndNext(session, shoppingItem, uuid,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected ShoppingItem getByUuid_PrevAndNext(Session session,
        ShoppingItem shoppingItem, String uuid,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_SHOPPINGITEM_WHERE);

        boolean bindUuid = false;

        if (uuid == null) {
            query.append(_FINDER_COLUMN_UUID_UUID_1);
        } else if (uuid.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_UUID_UUID_3);
        } else {
            bindUuid = true;

            query.append(_FINDER_COLUMN_UUID_UUID_2);
        }

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
            query.append(ShoppingItemModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindUuid) {
            qPos.add(uuid);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(shoppingItem);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<ShoppingItem> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the shopping items where uuid = &#63; from the database.
     *
     * @param uuid the uuid
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByUuid(String uuid) throws SystemException {
        for (ShoppingItem shoppingItem : findByUuid(uuid, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(shoppingItem);
        }
    }

    /**
     * Returns the number of shopping items where uuid = &#63;.
     *
     * @param uuid the uuid
     * @return the number of matching shopping items
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByUuid(String uuid) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

        Object[] finderArgs = new Object[] { uuid };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_SHOPPINGITEM_WHERE);

            boolean bindUuid = false;

            if (uuid == null) {
                query.append(_FINDER_COLUMN_UUID_UUID_1);
            } else if (uuid.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_UUID_UUID_3);
            } else {
                bindUuid = true;

                query.append(_FINDER_COLUMN_UUID_UUID_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindUuid) {
                    qPos.add(uuid);
                }

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
     * Returns the shopping item where uuid = &#63; and groupId = &#63; or throws a {@link com.fsquare.shopping.NoSuchShoppingItemException} if it could not be found.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the matching shopping item
     * @throws com.fsquare.shopping.NoSuchShoppingItemException if a matching shopping item could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingItem findByUUID_G(String uuid, long groupId)
        throws NoSuchShoppingItemException, SystemException {
        ShoppingItem shoppingItem = fetchByUUID_G(uuid, groupId);

        if (shoppingItem == null) {
            StringBundler msg = new StringBundler(6);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("uuid=");
            msg.append(uuid);

            msg.append(", groupId=");
            msg.append(groupId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchShoppingItemException(msg.toString());
        }

        return shoppingItem;
    }

    /**
     * Returns the shopping item where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the matching shopping item, or <code>null</code> if a matching shopping item could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingItem fetchByUUID_G(String uuid, long groupId)
        throws SystemException {
        return fetchByUUID_G(uuid, groupId, true);
    }

    /**
     * Returns the shopping item where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching shopping item, or <code>null</code> if a matching shopping item could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingItem fetchByUUID_G(String uuid, long groupId,
        boolean retrieveFromCache) throws SystemException {
        Object[] finderArgs = new Object[] { uuid, groupId };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
                    finderArgs, this);
        }

        if (result instanceof ShoppingItem) {
            ShoppingItem shoppingItem = (ShoppingItem) result;

            if (!Validator.equals(uuid, shoppingItem.getUuid()) ||
                    (groupId != shoppingItem.getGroupId())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(4);

            query.append(_SQL_SELECT_SHOPPINGITEM_WHERE);

            boolean bindUuid = false;

            if (uuid == null) {
                query.append(_FINDER_COLUMN_UUID_G_UUID_1);
            } else if (uuid.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_UUID_G_UUID_3);
            } else {
                bindUuid = true;

                query.append(_FINDER_COLUMN_UUID_G_UUID_2);
            }

            query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindUuid) {
                    qPos.add(uuid);
                }

                qPos.add(groupId);

                List<ShoppingItem> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
                        finderArgs, list);
                } else {
                    ShoppingItem shoppingItem = list.get(0);

                    result = shoppingItem;

                    cacheResult(shoppingItem);

                    if ((shoppingItem.getUuid() == null) ||
                            !shoppingItem.getUuid().equals(uuid) ||
                            (shoppingItem.getGroupId() != groupId)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
                            finderArgs, shoppingItem);
                    }
                }
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        if (result instanceof List<?>) {
            return null;
        } else {
            return (ShoppingItem) result;
        }
    }

    /**
     * Removes the shopping item where uuid = &#63; and groupId = &#63; from the database.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the shopping item that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingItem removeByUUID_G(String uuid, long groupId)
        throws NoSuchShoppingItemException, SystemException {
        ShoppingItem shoppingItem = findByUUID_G(uuid, groupId);

        return remove(shoppingItem);
    }

    /**
     * Returns the number of shopping items where uuid = &#63; and groupId = &#63;.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the number of matching shopping items
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByUUID_G(String uuid, long groupId)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_G;

        Object[] finderArgs = new Object[] { uuid, groupId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_SHOPPINGITEM_WHERE);

            boolean bindUuid = false;

            if (uuid == null) {
                query.append(_FINDER_COLUMN_UUID_G_UUID_1);
            } else if (uuid.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_UUID_G_UUID_3);
            } else {
                bindUuid = true;

                query.append(_FINDER_COLUMN_UUID_G_UUID_2);
            }

            query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindUuid) {
                    qPos.add(uuid);
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
     * Returns all the shopping items where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @return the matching shopping items
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ShoppingItem> findByUuid_C(String uuid, long companyId)
        throws SystemException {
        return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the shopping items where uuid = &#63; and companyId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param start the lower bound of the range of shopping items
     * @param end the upper bound of the range of shopping items (not inclusive)
     * @return the range of matching shopping items
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ShoppingItem> findByUuid_C(String uuid, long companyId,
        int start, int end) throws SystemException {
        return findByUuid_C(uuid, companyId, start, end, null);
    }

    /**
     * Returns an ordered range of all the shopping items where uuid = &#63; and companyId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param start the lower bound of the range of shopping items
     * @param end the upper bound of the range of shopping items (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching shopping items
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ShoppingItem> findByUuid_C(String uuid, long companyId,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C;
            finderArgs = new Object[] { uuid, companyId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C;
            finderArgs = new Object[] {
                    uuid, companyId,
                    
                    start, end, orderByComparator
                };
        }

        List<ShoppingItem> list = (List<ShoppingItem>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (ShoppingItem shoppingItem : list) {
                if (!Validator.equals(uuid, shoppingItem.getUuid()) ||
                        (companyId != shoppingItem.getCompanyId())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(4 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(4);
            }

            query.append(_SQL_SELECT_SHOPPINGITEM_WHERE);

            boolean bindUuid = false;

            if (uuid == null) {
                query.append(_FINDER_COLUMN_UUID_C_UUID_1);
            } else if (uuid.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_UUID_C_UUID_3);
            } else {
                bindUuid = true;

                query.append(_FINDER_COLUMN_UUID_C_UUID_2);
            }

            query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(ShoppingItemModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindUuid) {
                    qPos.add(uuid);
                }

                qPos.add(companyId);

                if (!pagination) {
                    list = (List<ShoppingItem>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<ShoppingItem>(list);
                } else {
                    list = (List<ShoppingItem>) QueryUtil.list(q, getDialect(),
                            start, end);
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
     * Returns the first shopping item in the ordered set where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching shopping item
     * @throws com.fsquare.shopping.NoSuchShoppingItemException if a matching shopping item could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingItem findByUuid_C_First(String uuid, long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchShoppingItemException, SystemException {
        ShoppingItem shoppingItem = fetchByUuid_C_First(uuid, companyId,
                orderByComparator);

        if (shoppingItem != null) {
            return shoppingItem;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(", companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchShoppingItemException(msg.toString());
    }

    /**
     * Returns the first shopping item in the ordered set where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching shopping item, or <code>null</code> if a matching shopping item could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingItem fetchByUuid_C_First(String uuid, long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        List<ShoppingItem> list = findByUuid_C(uuid, companyId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last shopping item in the ordered set where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching shopping item
     * @throws com.fsquare.shopping.NoSuchShoppingItemException if a matching shopping item could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingItem findByUuid_C_Last(String uuid, long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchShoppingItemException, SystemException {
        ShoppingItem shoppingItem = fetchByUuid_C_Last(uuid, companyId,
                orderByComparator);

        if (shoppingItem != null) {
            return shoppingItem;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(", companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchShoppingItemException(msg.toString());
    }

    /**
     * Returns the last shopping item in the ordered set where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching shopping item, or <code>null</code> if a matching shopping item could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingItem fetchByUuid_C_Last(String uuid, long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByUuid_C(uuid, companyId);

        if (count == 0) {
            return null;
        }

        List<ShoppingItem> list = findByUuid_C(uuid, companyId, count - 1,
                count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the shopping items before and after the current shopping item in the ordered set where uuid = &#63; and companyId = &#63;.
     *
     * @param itemId the primary key of the current shopping item
     * @param uuid the uuid
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next shopping item
     * @throws com.fsquare.shopping.NoSuchShoppingItemException if a shopping item with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingItem[] findByUuid_C_PrevAndNext(long itemId, String uuid,
        long companyId, OrderByComparator orderByComparator)
        throws NoSuchShoppingItemException, SystemException {
        ShoppingItem shoppingItem = findByPrimaryKey(itemId);

        Session session = null;

        try {
            session = openSession();

            ShoppingItem[] array = new ShoppingItemImpl[3];

            array[0] = getByUuid_C_PrevAndNext(session, shoppingItem, uuid,
                    companyId, orderByComparator, true);

            array[1] = shoppingItem;

            array[2] = getByUuid_C_PrevAndNext(session, shoppingItem, uuid,
                    companyId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected ShoppingItem getByUuid_C_PrevAndNext(Session session,
        ShoppingItem shoppingItem, String uuid, long companyId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_SHOPPINGITEM_WHERE);

        boolean bindUuid = false;

        if (uuid == null) {
            query.append(_FINDER_COLUMN_UUID_C_UUID_1);
        } else if (uuid.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_UUID_C_UUID_3);
        } else {
            bindUuid = true;

            query.append(_FINDER_COLUMN_UUID_C_UUID_2);
        }

        query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

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
            query.append(ShoppingItemModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindUuid) {
            qPos.add(uuid);
        }

        qPos.add(companyId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(shoppingItem);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<ShoppingItem> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the shopping items where uuid = &#63; and companyId = &#63; from the database.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByUuid_C(String uuid, long companyId)
        throws SystemException {
        for (ShoppingItem shoppingItem : findByUuid_C(uuid, companyId,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(shoppingItem);
        }
    }

    /**
     * Returns the number of shopping items where uuid = &#63; and companyId = &#63;.
     *
     * @param uuid the uuid
     * @param companyId the company ID
     * @return the number of matching shopping items
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByUuid_C(String uuid, long companyId)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

        Object[] finderArgs = new Object[] { uuid, companyId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_SHOPPINGITEM_WHERE);

            boolean bindUuid = false;

            if (uuid == null) {
                query.append(_FINDER_COLUMN_UUID_C_UUID_1);
            } else if (uuid.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_UUID_C_UUID_3);
            } else {
                bindUuid = true;

                query.append(_FINDER_COLUMN_UUID_C_UUID_2);
            }

            query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindUuid) {
                    qPos.add(uuid);
                }

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
     * Returns all the shopping items where companyId = &#63;.
     *
     * @param companyId the company ID
     * @return the matching shopping items
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ShoppingItem> findByCompanyId(long companyId)
        throws SystemException {
        return findByCompanyId(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
    }

    /**
     * Returns a range of all the shopping items where companyId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param companyId the company ID
     * @param start the lower bound of the range of shopping items
     * @param end the upper bound of the range of shopping items (not inclusive)
     * @return the range of matching shopping items
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ShoppingItem> findByCompanyId(long companyId, int start, int end)
        throws SystemException {
        return findByCompanyId(companyId, start, end, null);
    }

    /**
     * Returns an ordered range of all the shopping items where companyId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param companyId the company ID
     * @param start the lower bound of the range of shopping items
     * @param end the upper bound of the range of shopping items (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching shopping items
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ShoppingItem> findByCompanyId(long companyId, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
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

        List<ShoppingItem> list = (List<ShoppingItem>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (ShoppingItem shoppingItem : list) {
                if ((companyId != shoppingItem.getCompanyId())) {
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

            query.append(_SQL_SELECT_SHOPPINGITEM_WHERE);

            query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(ShoppingItemModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyId);

                if (!pagination) {
                    list = (List<ShoppingItem>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<ShoppingItem>(list);
                } else {
                    list = (List<ShoppingItem>) QueryUtil.list(q, getDialect(),
                            start, end);
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
     * Returns the first shopping item in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching shopping item
     * @throws com.fsquare.shopping.NoSuchShoppingItemException if a matching shopping item could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingItem findByCompanyId_First(long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchShoppingItemException, SystemException {
        ShoppingItem shoppingItem = fetchByCompanyId_First(companyId,
                orderByComparator);

        if (shoppingItem != null) {
            return shoppingItem;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchShoppingItemException(msg.toString());
    }

    /**
     * Returns the first shopping item in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching shopping item, or <code>null</code> if a matching shopping item could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingItem fetchByCompanyId_First(long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        List<ShoppingItem> list = findByCompanyId(companyId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last shopping item in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching shopping item
     * @throws com.fsquare.shopping.NoSuchShoppingItemException if a matching shopping item could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingItem findByCompanyId_Last(long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchShoppingItemException, SystemException {
        ShoppingItem shoppingItem = fetchByCompanyId_Last(companyId,
                orderByComparator);

        if (shoppingItem != null) {
            return shoppingItem;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchShoppingItemException(msg.toString());
    }

    /**
     * Returns the last shopping item in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching shopping item, or <code>null</code> if a matching shopping item could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingItem fetchByCompanyId_Last(long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByCompanyId(companyId);

        if (count == 0) {
            return null;
        }

        List<ShoppingItem> list = findByCompanyId(companyId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the shopping items before and after the current shopping item in the ordered set where companyId = &#63;.
     *
     * @param itemId the primary key of the current shopping item
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next shopping item
     * @throws com.fsquare.shopping.NoSuchShoppingItemException if a shopping item with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingItem[] findByCompanyId_PrevAndNext(long itemId,
        long companyId, OrderByComparator orderByComparator)
        throws NoSuchShoppingItemException, SystemException {
        ShoppingItem shoppingItem = findByPrimaryKey(itemId);

        Session session = null;

        try {
            session = openSession();

            ShoppingItem[] array = new ShoppingItemImpl[3];

            array[0] = getByCompanyId_PrevAndNext(session, shoppingItem,
                    companyId, orderByComparator, true);

            array[1] = shoppingItem;

            array[2] = getByCompanyId_PrevAndNext(session, shoppingItem,
                    companyId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected ShoppingItem getByCompanyId_PrevAndNext(Session session,
        ShoppingItem shoppingItem, long companyId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_SHOPPINGITEM_WHERE);

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
            query.append(ShoppingItemModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(companyId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(shoppingItem);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<ShoppingItem> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the shopping items where companyId = &#63; from the database.
     *
     * @param companyId the company ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByCompanyId(long companyId) throws SystemException {
        for (ShoppingItem shoppingItem : findByCompanyId(companyId,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(shoppingItem);
        }
    }

    /**
     * Returns the number of shopping items where companyId = &#63;.
     *
     * @param companyId the company ID
     * @return the number of matching shopping items
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

            query.append(_SQL_COUNT_SHOPPINGITEM_WHERE);

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
     * Caches the shopping item in the entity cache if it is enabled.
     *
     * @param shoppingItem the shopping item
     */
    @Override
    public void cacheResult(ShoppingItem shoppingItem) {
        EntityCacheUtil.putResult(ShoppingItemModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingItemImpl.class, shoppingItem.getPrimaryKey(), shoppingItem);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
            new Object[] { shoppingItem.getUuid(), shoppingItem.getGroupId() },
            shoppingItem);

        shoppingItem.resetOriginalValues();
    }

    /**
     * Caches the shopping items in the entity cache if it is enabled.
     *
     * @param shoppingItems the shopping items
     */
    @Override
    public void cacheResult(List<ShoppingItem> shoppingItems) {
        for (ShoppingItem shoppingItem : shoppingItems) {
            if (EntityCacheUtil.getResult(
                        ShoppingItemModelImpl.ENTITY_CACHE_ENABLED,
                        ShoppingItemImpl.class, shoppingItem.getPrimaryKey()) == null) {
                cacheResult(shoppingItem);
            } else {
                shoppingItem.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all shopping items.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(ShoppingItemImpl.class.getName());
        }

        EntityCacheUtil.clearCache(ShoppingItemImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the shopping item.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(ShoppingItem shoppingItem) {
        EntityCacheUtil.removeResult(ShoppingItemModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingItemImpl.class, shoppingItem.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(shoppingItem);
    }

    @Override
    public void clearCache(List<ShoppingItem> shoppingItems) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (ShoppingItem shoppingItem : shoppingItems) {
            EntityCacheUtil.removeResult(ShoppingItemModelImpl.ENTITY_CACHE_ENABLED,
                ShoppingItemImpl.class, shoppingItem.getPrimaryKey());

            clearUniqueFindersCache(shoppingItem);
        }
    }

    protected void cacheUniqueFindersCache(ShoppingItem shoppingItem) {
        if (shoppingItem.isNew()) {
            Object[] args = new Object[] {
                    shoppingItem.getUuid(), shoppingItem.getGroupId()
                };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
                Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
                shoppingItem);
        } else {
            ShoppingItemModelImpl shoppingItemModelImpl = (ShoppingItemModelImpl) shoppingItem;

            if ((shoppingItemModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        shoppingItem.getUuid(), shoppingItem.getGroupId()
                    };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
                    Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
                    shoppingItem);
            }
        }
    }

    protected void clearUniqueFindersCache(ShoppingItem shoppingItem) {
        ShoppingItemModelImpl shoppingItemModelImpl = (ShoppingItemModelImpl) shoppingItem;

        Object[] args = new Object[] {
                shoppingItem.getUuid(), shoppingItem.getGroupId()
            };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

        if ((shoppingItemModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
            args = new Object[] {
                    shoppingItemModelImpl.getOriginalUuid(),
                    shoppingItemModelImpl.getOriginalGroupId()
                };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
        }
    }

    /**
     * Creates a new shopping item with the primary key. Does not add the shopping item to the database.
     *
     * @param itemId the primary key for the new shopping item
     * @return the new shopping item
     */
    @Override
    public ShoppingItem create(long itemId) {
        ShoppingItem shoppingItem = new ShoppingItemImpl();

        shoppingItem.setNew(true);
        shoppingItem.setPrimaryKey(itemId);

        String uuid = PortalUUIDUtil.generate();

        shoppingItem.setUuid(uuid);

        return shoppingItem;
    }

    /**
     * Removes the shopping item with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param itemId the primary key of the shopping item
     * @return the shopping item that was removed
     * @throws com.fsquare.shopping.NoSuchShoppingItemException if a shopping item with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingItem remove(long itemId)
        throws NoSuchShoppingItemException, SystemException {
        return remove((Serializable) itemId);
    }

    /**
     * Removes the shopping item with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the shopping item
     * @return the shopping item that was removed
     * @throws com.fsquare.shopping.NoSuchShoppingItemException if a shopping item with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingItem remove(Serializable primaryKey)
        throws NoSuchShoppingItemException, SystemException {
        Session session = null;

        try {
            session = openSession();

            ShoppingItem shoppingItem = (ShoppingItem) session.get(ShoppingItemImpl.class,
                    primaryKey);

            if (shoppingItem == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchShoppingItemException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(shoppingItem);
        } catch (NoSuchShoppingItemException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected ShoppingItem removeImpl(ShoppingItem shoppingItem)
        throws SystemException {
        shoppingItem = toUnwrappedModel(shoppingItem);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(shoppingItem)) {
                shoppingItem = (ShoppingItem) session.get(ShoppingItemImpl.class,
                        shoppingItem.getPrimaryKeyObj());
            }

            if (shoppingItem != null) {
                session.delete(shoppingItem);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (shoppingItem != null) {
            clearCache(shoppingItem);
        }

        return shoppingItem;
    }

    @Override
    public ShoppingItem updateImpl(
        com.fsquare.shopping.model.ShoppingItem shoppingItem)
        throws SystemException {
        shoppingItem = toUnwrappedModel(shoppingItem);

        boolean isNew = shoppingItem.isNew();

        ShoppingItemModelImpl shoppingItemModelImpl = (ShoppingItemModelImpl) shoppingItem;

        if (Validator.isNull(shoppingItem.getUuid())) {
            String uuid = PortalUUIDUtil.generate();

            shoppingItem.setUuid(uuid);
        }

        Session session = null;

        try {
            session = openSession();

            if (shoppingItem.isNew()) {
                session.save(shoppingItem);

                shoppingItem.setNew(false);
            } else {
                session.merge(shoppingItem);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !ShoppingItemModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((shoppingItemModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        shoppingItemModelImpl.getOriginalUuid()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
                    args);

                args = new Object[] { shoppingItemModelImpl.getUuid() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
                    args);
            }

            if ((shoppingItemModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        shoppingItemModelImpl.getOriginalUuid(),
                        shoppingItemModelImpl.getOriginalCompanyId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
                    args);

                args = new Object[] {
                        shoppingItemModelImpl.getUuid(),
                        shoppingItemModelImpl.getCompanyId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
                    args);
            }

            if ((shoppingItemModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        shoppingItemModelImpl.getOriginalCompanyId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
                    args);

                args = new Object[] { shoppingItemModelImpl.getCompanyId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
                    args);
            }
        }

        EntityCacheUtil.putResult(ShoppingItemModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingItemImpl.class, shoppingItem.getPrimaryKey(), shoppingItem);

        clearUniqueFindersCache(shoppingItem);
        cacheUniqueFindersCache(shoppingItem);

        return shoppingItem;
    }

    protected ShoppingItem toUnwrappedModel(ShoppingItem shoppingItem) {
        if (shoppingItem instanceof ShoppingItemImpl) {
            return shoppingItem;
        }

        ShoppingItemImpl shoppingItemImpl = new ShoppingItemImpl();

        shoppingItemImpl.setNew(shoppingItem.isNew());
        shoppingItemImpl.setPrimaryKey(shoppingItem.getPrimaryKey());

        shoppingItemImpl.setUuid(shoppingItem.getUuid());
        shoppingItemImpl.setItemId(shoppingItem.getItemId());
        shoppingItemImpl.setGroupId(shoppingItem.getGroupId());
        shoppingItemImpl.setCompanyId(shoppingItem.getCompanyId());
        shoppingItemImpl.setUserId(shoppingItem.getUserId());
        shoppingItemImpl.setUserName(shoppingItem.getUserName());
        shoppingItemImpl.setCreateDate(shoppingItem.getCreateDate());
        shoppingItemImpl.setModifiedDate(shoppingItem.getModifiedDate());
        shoppingItemImpl.setClassNameId(shoppingItem.getClassNameId());
        shoppingItemImpl.setClassPK(shoppingItem.getClassPK());
        shoppingItemImpl.setTitle(shoppingItem.getTitle());
        shoppingItemImpl.setDescription(shoppingItem.getDescription());
        shoppingItemImpl.setPrice(shoppingItem.getPrice());
        shoppingItemImpl.setDiscountPrice(shoppingItem.getDiscountPrice());
        shoppingItemImpl.setSku(shoppingItem.getSku());
        shoppingItemImpl.setItemTypeId(shoppingItem.getItemTypeId());
        shoppingItemImpl.setStatus(shoppingItem.getStatus());
        shoppingItemImpl.setStatusByUserId(shoppingItem.getStatusByUserId());
        shoppingItemImpl.setStatusByUserName(shoppingItem.getStatusByUserName());
        shoppingItemImpl.setStatusDate(shoppingItem.getStatusDate());

        return shoppingItemImpl;
    }

    /**
     * Returns the shopping item with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the shopping item
     * @return the shopping item
     * @throws com.fsquare.shopping.NoSuchShoppingItemException if a shopping item with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingItem findByPrimaryKey(Serializable primaryKey)
        throws NoSuchShoppingItemException, SystemException {
        ShoppingItem shoppingItem = fetchByPrimaryKey(primaryKey);

        if (shoppingItem == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchShoppingItemException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return shoppingItem;
    }

    /**
     * Returns the shopping item with the primary key or throws a {@link com.fsquare.shopping.NoSuchShoppingItemException} if it could not be found.
     *
     * @param itemId the primary key of the shopping item
     * @return the shopping item
     * @throws com.fsquare.shopping.NoSuchShoppingItemException if a shopping item with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingItem findByPrimaryKey(long itemId)
        throws NoSuchShoppingItemException, SystemException {
        return findByPrimaryKey((Serializable) itemId);
    }

    /**
     * Returns the shopping item with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the shopping item
     * @return the shopping item, or <code>null</code> if a shopping item with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingItem fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        ShoppingItem shoppingItem = (ShoppingItem) EntityCacheUtil.getResult(ShoppingItemModelImpl.ENTITY_CACHE_ENABLED,
                ShoppingItemImpl.class, primaryKey);

        if (shoppingItem == _nullShoppingItem) {
            return null;
        }

        if (shoppingItem == null) {
            Session session = null;

            try {
                session = openSession();

                shoppingItem = (ShoppingItem) session.get(ShoppingItemImpl.class,
                        primaryKey);

                if (shoppingItem != null) {
                    cacheResult(shoppingItem);
                } else {
                    EntityCacheUtil.putResult(ShoppingItemModelImpl.ENTITY_CACHE_ENABLED,
                        ShoppingItemImpl.class, primaryKey, _nullShoppingItem);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(ShoppingItemModelImpl.ENTITY_CACHE_ENABLED,
                    ShoppingItemImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return shoppingItem;
    }

    /**
     * Returns the shopping item with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param itemId the primary key of the shopping item
     * @return the shopping item, or <code>null</code> if a shopping item with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingItem fetchByPrimaryKey(long itemId)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) itemId);
    }

    /**
     * Returns all the shopping items.
     *
     * @return the shopping items
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ShoppingItem> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the shopping items.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of shopping items
     * @param end the upper bound of the range of shopping items (not inclusive)
     * @return the range of shopping items
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ShoppingItem> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the shopping items.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of shopping items
     * @param end the upper bound of the range of shopping items (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of shopping items
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ShoppingItem> findAll(int start, int end,
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

        List<ShoppingItem> list = (List<ShoppingItem>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_SHOPPINGITEM);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_SHOPPINGITEM;

                if (pagination) {
                    sql = sql.concat(ShoppingItemModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<ShoppingItem>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<ShoppingItem>(list);
                } else {
                    list = (List<ShoppingItem>) QueryUtil.list(q, getDialect(),
                            start, end);
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
     * Removes all the shopping items from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (ShoppingItem shoppingItem : findAll()) {
            remove(shoppingItem);
        }
    }

    /**
     * Returns the number of shopping items.
     *
     * @return the number of shopping items
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

                Query q = session.createQuery(_SQL_COUNT_SHOPPINGITEM);

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
     * Initializes the shopping item persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.fsquare.shopping.model.ShoppingItem")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<ShoppingItem>> listenersList = new ArrayList<ModelListener<ShoppingItem>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<ShoppingItem>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(ShoppingItemImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
