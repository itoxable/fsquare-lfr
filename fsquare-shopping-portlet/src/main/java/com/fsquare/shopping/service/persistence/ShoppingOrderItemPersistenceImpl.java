package com.fsquare.shopping.service.persistence;

import com.fsquare.shopping.NoSuchShoppingOrderItemException;
import com.fsquare.shopping.model.ShoppingOrderItem;
import com.fsquare.shopping.model.impl.ShoppingOrderItemImpl;
import com.fsquare.shopping.model.impl.ShoppingOrderItemModelImpl;
import com.fsquare.shopping.service.persistence.ShoppingOrderItemPersistence;

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
 * The persistence implementation for the shopping order item service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingOrderItemPersistence
 * @see ShoppingOrderItemUtil
 * @generated
 */
public class ShoppingOrderItemPersistenceImpl extends BasePersistenceImpl<ShoppingOrderItem>
    implements ShoppingOrderItemPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link ShoppingOrderItemUtil} to access the shopping order item persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = ShoppingOrderItemImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ShoppingOrderItemModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingOrderItemModelImpl.FINDER_CACHE_ENABLED,
            ShoppingOrderItemImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ShoppingOrderItemModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingOrderItemModelImpl.FINDER_CACHE_ENABLED,
            ShoppingOrderItemImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ShoppingOrderItemModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingOrderItemModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SHOPPINGORDERID =
        new FinderPath(ShoppingOrderItemModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingOrderItemModelImpl.FINDER_CACHE_ENABLED,
            ShoppingOrderItemImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByShoppingOrderId",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SHOPPINGORDERID =
        new FinderPath(ShoppingOrderItemModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingOrderItemModelImpl.FINDER_CACHE_ENABLED,
            ShoppingOrderItemImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByShoppingOrderId",
            new String[] { Long.class.getName() },
            ShoppingOrderItemModelImpl.SHOPPINGORDERID_COLUMN_BITMASK |
            ShoppingOrderItemModelImpl.NAME_COLUMN_BITMASK |
            ShoppingOrderItemModelImpl.DESCRIPTION_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_SHOPPINGORDERID = new FinderPath(ShoppingOrderItemModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingOrderItemModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByShoppingOrderId", new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_SHOPPINGORDERID_SHOPPINGORDERID_2 =
        "shoppingOrderItem.shoppingOrderId = ?";
    public static final FinderPath FINDER_PATH_FETCH_BY_SHOPPINGORDERITEMID = new FinderPath(ShoppingOrderItemModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingOrderItemModelImpl.FINDER_CACHE_ENABLED,
            ShoppingOrderItemImpl.class, FINDER_CLASS_NAME_ENTITY,
            "fetchByShoppingOrderItemId",
            new String[] { Long.class.getName() },
            ShoppingOrderItemModelImpl.SHOPPINGORDERITEMID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_SHOPPINGORDERITEMID = new FinderPath(ShoppingOrderItemModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingOrderItemModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByShoppingOrderItemId", new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_SHOPPINGORDERITEMID_SHOPPINGORDERITEMID_2 =
        "shoppingOrderItem.shoppingOrderItemId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ARTICLEID =
        new FinderPath(ShoppingOrderItemModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingOrderItemModelImpl.FINDER_CACHE_ENABLED,
            ShoppingOrderItemImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByArticleId",
            new String[] {
                String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ARTICLEID =
        new FinderPath(ShoppingOrderItemModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingOrderItemModelImpl.FINDER_CACHE_ENABLED,
            ShoppingOrderItemImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByArticleId",
            new String[] { String.class.getName() },
            ShoppingOrderItemModelImpl.ARTICLEID_COLUMN_BITMASK |
            ShoppingOrderItemModelImpl.NAME_COLUMN_BITMASK |
            ShoppingOrderItemModelImpl.DESCRIPTION_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_ARTICLEID = new FinderPath(ShoppingOrderItemModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingOrderItemModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByArticleId",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_ARTICLEID_ARTICLEID_1 = "shoppingOrderItem.articleId IS NULL";
    private static final String _FINDER_COLUMN_ARTICLEID_ARTICLEID_2 = "shoppingOrderItem.articleId = ?";
    private static final String _FINDER_COLUMN_ARTICLEID_ARTICLEID_3 = "(shoppingOrderItem.articleId IS NULL OR shoppingOrderItem.articleId = '')";
    private static final String _SQL_SELECT_SHOPPINGORDERITEM = "SELECT shoppingOrderItem FROM ShoppingOrderItem shoppingOrderItem";
    private static final String _SQL_SELECT_SHOPPINGORDERITEM_WHERE = "SELECT shoppingOrderItem FROM ShoppingOrderItem shoppingOrderItem WHERE ";
    private static final String _SQL_COUNT_SHOPPINGORDERITEM = "SELECT COUNT(shoppingOrderItem) FROM ShoppingOrderItem shoppingOrderItem";
    private static final String _SQL_COUNT_SHOPPINGORDERITEM_WHERE = "SELECT COUNT(shoppingOrderItem) FROM ShoppingOrderItem shoppingOrderItem WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "shoppingOrderItem.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ShoppingOrderItem exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ShoppingOrderItem exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(ShoppingOrderItemPersistenceImpl.class);
    private static ShoppingOrderItem _nullShoppingOrderItem = new ShoppingOrderItemImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<ShoppingOrderItem> toCacheModel() {
                return _nullShoppingOrderItemCacheModel;
            }
        };

    private static CacheModel<ShoppingOrderItem> _nullShoppingOrderItemCacheModel =
        new CacheModel<ShoppingOrderItem>() {
            @Override
            public ShoppingOrderItem toEntityModel() {
                return _nullShoppingOrderItem;
            }
        };

    public ShoppingOrderItemPersistenceImpl() {
        setModelClass(ShoppingOrderItem.class);
    }

    /**
     * Returns all the shopping order items where shoppingOrderId = &#63;.
     *
     * @param shoppingOrderId the shopping order ID
     * @return the matching shopping order items
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ShoppingOrderItem> findByShoppingOrderId(long shoppingOrderId)
        throws SystemException {
        return findByShoppingOrderId(shoppingOrderId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the shopping order items where shoppingOrderId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingOrderItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param shoppingOrderId the shopping order ID
     * @param start the lower bound of the range of shopping order items
     * @param end the upper bound of the range of shopping order items (not inclusive)
     * @return the range of matching shopping order items
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ShoppingOrderItem> findByShoppingOrderId(long shoppingOrderId,
        int start, int end) throws SystemException {
        return findByShoppingOrderId(shoppingOrderId, start, end, null);
    }

    /**
     * Returns an ordered range of all the shopping order items where shoppingOrderId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingOrderItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param shoppingOrderId the shopping order ID
     * @param start the lower bound of the range of shopping order items
     * @param end the upper bound of the range of shopping order items (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching shopping order items
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ShoppingOrderItem> findByShoppingOrderId(long shoppingOrderId,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SHOPPINGORDERID;
            finderArgs = new Object[] { shoppingOrderId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SHOPPINGORDERID;
            finderArgs = new Object[] {
                    shoppingOrderId,
                    
                    start, end, orderByComparator
                };
        }

        List<ShoppingOrderItem> list = (List<ShoppingOrderItem>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (ShoppingOrderItem shoppingOrderItem : list) {
                if ((shoppingOrderId != shoppingOrderItem.getShoppingOrderId())) {
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

            query.append(_SQL_SELECT_SHOPPINGORDERITEM_WHERE);

            query.append(_FINDER_COLUMN_SHOPPINGORDERID_SHOPPINGORDERID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(ShoppingOrderItemModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(shoppingOrderId);

                if (!pagination) {
                    list = (List<ShoppingOrderItem>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<ShoppingOrderItem>(list);
                } else {
                    list = (List<ShoppingOrderItem>) QueryUtil.list(q,
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
     * Returns the first shopping order item in the ordered set where shoppingOrderId = &#63;.
     *
     * @param shoppingOrderId the shopping order ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching shopping order item
     * @throws com.fsquare.shopping.NoSuchShoppingOrderItemException if a matching shopping order item could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingOrderItem findByShoppingOrderId_First(long shoppingOrderId,
        OrderByComparator orderByComparator)
        throws NoSuchShoppingOrderItemException, SystemException {
        ShoppingOrderItem shoppingOrderItem = fetchByShoppingOrderId_First(shoppingOrderId,
                orderByComparator);

        if (shoppingOrderItem != null) {
            return shoppingOrderItem;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("shoppingOrderId=");
        msg.append(shoppingOrderId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchShoppingOrderItemException(msg.toString());
    }

    /**
     * Returns the first shopping order item in the ordered set where shoppingOrderId = &#63;.
     *
     * @param shoppingOrderId the shopping order ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching shopping order item, or <code>null</code> if a matching shopping order item could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingOrderItem fetchByShoppingOrderId_First(
        long shoppingOrderId, OrderByComparator orderByComparator)
        throws SystemException {
        List<ShoppingOrderItem> list = findByShoppingOrderId(shoppingOrderId,
                0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last shopping order item in the ordered set where shoppingOrderId = &#63;.
     *
     * @param shoppingOrderId the shopping order ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching shopping order item
     * @throws com.fsquare.shopping.NoSuchShoppingOrderItemException if a matching shopping order item could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingOrderItem findByShoppingOrderId_Last(long shoppingOrderId,
        OrderByComparator orderByComparator)
        throws NoSuchShoppingOrderItemException, SystemException {
        ShoppingOrderItem shoppingOrderItem = fetchByShoppingOrderId_Last(shoppingOrderId,
                orderByComparator);

        if (shoppingOrderItem != null) {
            return shoppingOrderItem;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("shoppingOrderId=");
        msg.append(shoppingOrderId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchShoppingOrderItemException(msg.toString());
    }

    /**
     * Returns the last shopping order item in the ordered set where shoppingOrderId = &#63;.
     *
     * @param shoppingOrderId the shopping order ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching shopping order item, or <code>null</code> if a matching shopping order item could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingOrderItem fetchByShoppingOrderId_Last(long shoppingOrderId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByShoppingOrderId(shoppingOrderId);

        if (count == 0) {
            return null;
        }

        List<ShoppingOrderItem> list = findByShoppingOrderId(shoppingOrderId,
                count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the shopping order items before and after the current shopping order item in the ordered set where shoppingOrderId = &#63;.
     *
     * @param shoppingOrderItemId the primary key of the current shopping order item
     * @param shoppingOrderId the shopping order ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next shopping order item
     * @throws com.fsquare.shopping.NoSuchShoppingOrderItemException if a shopping order item with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingOrderItem[] findByShoppingOrderId_PrevAndNext(
        long shoppingOrderItemId, long shoppingOrderId,
        OrderByComparator orderByComparator)
        throws NoSuchShoppingOrderItemException, SystemException {
        ShoppingOrderItem shoppingOrderItem = findByPrimaryKey(shoppingOrderItemId);

        Session session = null;

        try {
            session = openSession();

            ShoppingOrderItem[] array = new ShoppingOrderItemImpl[3];

            array[0] = getByShoppingOrderId_PrevAndNext(session,
                    shoppingOrderItem, shoppingOrderId, orderByComparator, true);

            array[1] = shoppingOrderItem;

            array[2] = getByShoppingOrderId_PrevAndNext(session,
                    shoppingOrderItem, shoppingOrderId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected ShoppingOrderItem getByShoppingOrderId_PrevAndNext(
        Session session, ShoppingOrderItem shoppingOrderItem,
        long shoppingOrderId, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_SHOPPINGORDERITEM_WHERE);

        query.append(_FINDER_COLUMN_SHOPPINGORDERID_SHOPPINGORDERID_2);

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
            query.append(ShoppingOrderItemModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(shoppingOrderId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(shoppingOrderItem);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<ShoppingOrderItem> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the shopping order items where shoppingOrderId = &#63; from the database.
     *
     * @param shoppingOrderId the shopping order ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByShoppingOrderId(long shoppingOrderId)
        throws SystemException {
        for (ShoppingOrderItem shoppingOrderItem : findByShoppingOrderId(
                shoppingOrderId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(shoppingOrderItem);
        }
    }

    /**
     * Returns the number of shopping order items where shoppingOrderId = &#63;.
     *
     * @param shoppingOrderId the shopping order ID
     * @return the number of matching shopping order items
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByShoppingOrderId(long shoppingOrderId)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_SHOPPINGORDERID;

        Object[] finderArgs = new Object[] { shoppingOrderId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_SHOPPINGORDERITEM_WHERE);

            query.append(_FINDER_COLUMN_SHOPPINGORDERID_SHOPPINGORDERID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(shoppingOrderId);

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
     * Returns the shopping order item where shoppingOrderItemId = &#63; or throws a {@link com.fsquare.shopping.NoSuchShoppingOrderItemException} if it could not be found.
     *
     * @param shoppingOrderItemId the shopping order item ID
     * @return the matching shopping order item
     * @throws com.fsquare.shopping.NoSuchShoppingOrderItemException if a matching shopping order item could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingOrderItem findByShoppingOrderItemId(long shoppingOrderItemId)
        throws NoSuchShoppingOrderItemException, SystemException {
        ShoppingOrderItem shoppingOrderItem = fetchByShoppingOrderItemId(shoppingOrderItemId);

        if (shoppingOrderItem == null) {
            StringBundler msg = new StringBundler(4);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("shoppingOrderItemId=");
            msg.append(shoppingOrderItemId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchShoppingOrderItemException(msg.toString());
        }

        return shoppingOrderItem;
    }

    /**
     * Returns the shopping order item where shoppingOrderItemId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param shoppingOrderItemId the shopping order item ID
     * @return the matching shopping order item, or <code>null</code> if a matching shopping order item could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingOrderItem fetchByShoppingOrderItemId(
        long shoppingOrderItemId) throws SystemException {
        return fetchByShoppingOrderItemId(shoppingOrderItemId, true);
    }

    /**
     * Returns the shopping order item where shoppingOrderItemId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param shoppingOrderItemId the shopping order item ID
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching shopping order item, or <code>null</code> if a matching shopping order item could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingOrderItem fetchByShoppingOrderItemId(
        long shoppingOrderItemId, boolean retrieveFromCache)
        throws SystemException {
        Object[] finderArgs = new Object[] { shoppingOrderItemId };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_SHOPPINGORDERITEMID,
                    finderArgs, this);
        }

        if (result instanceof ShoppingOrderItem) {
            ShoppingOrderItem shoppingOrderItem = (ShoppingOrderItem) result;

            if ((shoppingOrderItemId != shoppingOrderItem.getShoppingOrderItemId())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_SELECT_SHOPPINGORDERITEM_WHERE);

            query.append(_FINDER_COLUMN_SHOPPINGORDERITEMID_SHOPPINGORDERITEMID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(shoppingOrderItemId);

                List<ShoppingOrderItem> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SHOPPINGORDERITEMID,
                        finderArgs, list);
                } else {
                    if ((list.size() > 1) && _log.isWarnEnabled()) {
                        _log.warn(
                            "ShoppingOrderItemPersistenceImpl.fetchByShoppingOrderItemId(long, boolean) with parameters (" +
                            StringUtil.merge(finderArgs) +
                            ") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
                    }

                    ShoppingOrderItem shoppingOrderItem = list.get(0);

                    result = shoppingOrderItem;

                    cacheResult(shoppingOrderItem);

                    if ((shoppingOrderItem.getShoppingOrderItemId() != shoppingOrderItemId)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SHOPPINGORDERITEMID,
                            finderArgs, shoppingOrderItem);
                    }
                }
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_SHOPPINGORDERITEMID,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        if (result instanceof List<?>) {
            return null;
        } else {
            return (ShoppingOrderItem) result;
        }
    }

    /**
     * Removes the shopping order item where shoppingOrderItemId = &#63; from the database.
     *
     * @param shoppingOrderItemId the shopping order item ID
     * @return the shopping order item that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingOrderItem removeByShoppingOrderItemId(
        long shoppingOrderItemId)
        throws NoSuchShoppingOrderItemException, SystemException {
        ShoppingOrderItem shoppingOrderItem = findByShoppingOrderItemId(shoppingOrderItemId);

        return remove(shoppingOrderItem);
    }

    /**
     * Returns the number of shopping order items where shoppingOrderItemId = &#63;.
     *
     * @param shoppingOrderItemId the shopping order item ID
     * @return the number of matching shopping order items
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByShoppingOrderItemId(long shoppingOrderItemId)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_SHOPPINGORDERITEMID;

        Object[] finderArgs = new Object[] { shoppingOrderItemId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_SHOPPINGORDERITEM_WHERE);

            query.append(_FINDER_COLUMN_SHOPPINGORDERITEMID_SHOPPINGORDERITEMID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(shoppingOrderItemId);

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
     * Returns all the shopping order items where articleId = &#63;.
     *
     * @param articleId the article ID
     * @return the matching shopping order items
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ShoppingOrderItem> findByArticleId(String articleId)
        throws SystemException {
        return findByArticleId(articleId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
    }

    /**
     * Returns a range of all the shopping order items where articleId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingOrderItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param articleId the article ID
     * @param start the lower bound of the range of shopping order items
     * @param end the upper bound of the range of shopping order items (not inclusive)
     * @return the range of matching shopping order items
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ShoppingOrderItem> findByArticleId(String articleId, int start,
        int end) throws SystemException {
        return findByArticleId(articleId, start, end, null);
    }

    /**
     * Returns an ordered range of all the shopping order items where articleId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingOrderItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param articleId the article ID
     * @param start the lower bound of the range of shopping order items
     * @param end the upper bound of the range of shopping order items (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching shopping order items
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ShoppingOrderItem> findByArticleId(String articleId, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ARTICLEID;
            finderArgs = new Object[] { articleId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ARTICLEID;
            finderArgs = new Object[] { articleId, start, end, orderByComparator };
        }

        List<ShoppingOrderItem> list = (List<ShoppingOrderItem>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (ShoppingOrderItem shoppingOrderItem : list) {
                if (!Validator.equals(articleId,
                            shoppingOrderItem.getArticleId())) {
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

            query.append(_SQL_SELECT_SHOPPINGORDERITEM_WHERE);

            boolean bindArticleId = false;

            if (articleId == null) {
                query.append(_FINDER_COLUMN_ARTICLEID_ARTICLEID_1);
            } else if (articleId.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_ARTICLEID_ARTICLEID_3);
            } else {
                bindArticleId = true;

                query.append(_FINDER_COLUMN_ARTICLEID_ARTICLEID_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(ShoppingOrderItemModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindArticleId) {
                    qPos.add(articleId);
                }

                if (!pagination) {
                    list = (List<ShoppingOrderItem>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<ShoppingOrderItem>(list);
                } else {
                    list = (List<ShoppingOrderItem>) QueryUtil.list(q,
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
     * Returns the first shopping order item in the ordered set where articleId = &#63;.
     *
     * @param articleId the article ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching shopping order item
     * @throws com.fsquare.shopping.NoSuchShoppingOrderItemException if a matching shopping order item could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingOrderItem findByArticleId_First(String articleId,
        OrderByComparator orderByComparator)
        throws NoSuchShoppingOrderItemException, SystemException {
        ShoppingOrderItem shoppingOrderItem = fetchByArticleId_First(articleId,
                orderByComparator);

        if (shoppingOrderItem != null) {
            return shoppingOrderItem;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("articleId=");
        msg.append(articleId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchShoppingOrderItemException(msg.toString());
    }

    /**
     * Returns the first shopping order item in the ordered set where articleId = &#63;.
     *
     * @param articleId the article ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching shopping order item, or <code>null</code> if a matching shopping order item could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingOrderItem fetchByArticleId_First(String articleId,
        OrderByComparator orderByComparator) throws SystemException {
        List<ShoppingOrderItem> list = findByArticleId(articleId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last shopping order item in the ordered set where articleId = &#63;.
     *
     * @param articleId the article ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching shopping order item
     * @throws com.fsquare.shopping.NoSuchShoppingOrderItemException if a matching shopping order item could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingOrderItem findByArticleId_Last(String articleId,
        OrderByComparator orderByComparator)
        throws NoSuchShoppingOrderItemException, SystemException {
        ShoppingOrderItem shoppingOrderItem = fetchByArticleId_Last(articleId,
                orderByComparator);

        if (shoppingOrderItem != null) {
            return shoppingOrderItem;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("articleId=");
        msg.append(articleId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchShoppingOrderItemException(msg.toString());
    }

    /**
     * Returns the last shopping order item in the ordered set where articleId = &#63;.
     *
     * @param articleId the article ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching shopping order item, or <code>null</code> if a matching shopping order item could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingOrderItem fetchByArticleId_Last(String articleId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByArticleId(articleId);

        if (count == 0) {
            return null;
        }

        List<ShoppingOrderItem> list = findByArticleId(articleId, count - 1,
                count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the shopping order items before and after the current shopping order item in the ordered set where articleId = &#63;.
     *
     * @param shoppingOrderItemId the primary key of the current shopping order item
     * @param articleId the article ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next shopping order item
     * @throws com.fsquare.shopping.NoSuchShoppingOrderItemException if a shopping order item with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingOrderItem[] findByArticleId_PrevAndNext(
        long shoppingOrderItemId, String articleId,
        OrderByComparator orderByComparator)
        throws NoSuchShoppingOrderItemException, SystemException {
        ShoppingOrderItem shoppingOrderItem = findByPrimaryKey(shoppingOrderItemId);

        Session session = null;

        try {
            session = openSession();

            ShoppingOrderItem[] array = new ShoppingOrderItemImpl[3];

            array[0] = getByArticleId_PrevAndNext(session, shoppingOrderItem,
                    articleId, orderByComparator, true);

            array[1] = shoppingOrderItem;

            array[2] = getByArticleId_PrevAndNext(session, shoppingOrderItem,
                    articleId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected ShoppingOrderItem getByArticleId_PrevAndNext(Session session,
        ShoppingOrderItem shoppingOrderItem, String articleId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_SHOPPINGORDERITEM_WHERE);

        boolean bindArticleId = false;

        if (articleId == null) {
            query.append(_FINDER_COLUMN_ARTICLEID_ARTICLEID_1);
        } else if (articleId.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_ARTICLEID_ARTICLEID_3);
        } else {
            bindArticleId = true;

            query.append(_FINDER_COLUMN_ARTICLEID_ARTICLEID_2);
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
            query.append(ShoppingOrderItemModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindArticleId) {
            qPos.add(articleId);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(shoppingOrderItem);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<ShoppingOrderItem> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the shopping order items where articleId = &#63; from the database.
     *
     * @param articleId the article ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByArticleId(String articleId) throws SystemException {
        for (ShoppingOrderItem shoppingOrderItem : findByArticleId(articleId,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(shoppingOrderItem);
        }
    }

    /**
     * Returns the number of shopping order items where articleId = &#63;.
     *
     * @param articleId the article ID
     * @return the number of matching shopping order items
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByArticleId(String articleId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_ARTICLEID;

        Object[] finderArgs = new Object[] { articleId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_SHOPPINGORDERITEM_WHERE);

            boolean bindArticleId = false;

            if (articleId == null) {
                query.append(_FINDER_COLUMN_ARTICLEID_ARTICLEID_1);
            } else if (articleId.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_ARTICLEID_ARTICLEID_3);
            } else {
                bindArticleId = true;

                query.append(_FINDER_COLUMN_ARTICLEID_ARTICLEID_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindArticleId) {
                    qPos.add(articleId);
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
     * Caches the shopping order item in the entity cache if it is enabled.
     *
     * @param shoppingOrderItem the shopping order item
     */
    @Override
    public void cacheResult(ShoppingOrderItem shoppingOrderItem) {
        EntityCacheUtil.putResult(ShoppingOrderItemModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingOrderItemImpl.class, shoppingOrderItem.getPrimaryKey(),
            shoppingOrderItem);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SHOPPINGORDERITEMID,
            new Object[] { shoppingOrderItem.getShoppingOrderItemId() },
            shoppingOrderItem);

        shoppingOrderItem.resetOriginalValues();
    }

    /**
     * Caches the shopping order items in the entity cache if it is enabled.
     *
     * @param shoppingOrderItems the shopping order items
     */
    @Override
    public void cacheResult(List<ShoppingOrderItem> shoppingOrderItems) {
        for (ShoppingOrderItem shoppingOrderItem : shoppingOrderItems) {
            if (EntityCacheUtil.getResult(
                        ShoppingOrderItemModelImpl.ENTITY_CACHE_ENABLED,
                        ShoppingOrderItemImpl.class,
                        shoppingOrderItem.getPrimaryKey()) == null) {
                cacheResult(shoppingOrderItem);
            } else {
                shoppingOrderItem.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all shopping order items.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(ShoppingOrderItemImpl.class.getName());
        }

        EntityCacheUtil.clearCache(ShoppingOrderItemImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the shopping order item.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(ShoppingOrderItem shoppingOrderItem) {
        EntityCacheUtil.removeResult(ShoppingOrderItemModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingOrderItemImpl.class, shoppingOrderItem.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(shoppingOrderItem);
    }

    @Override
    public void clearCache(List<ShoppingOrderItem> shoppingOrderItems) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (ShoppingOrderItem shoppingOrderItem : shoppingOrderItems) {
            EntityCacheUtil.removeResult(ShoppingOrderItemModelImpl.ENTITY_CACHE_ENABLED,
                ShoppingOrderItemImpl.class, shoppingOrderItem.getPrimaryKey());

            clearUniqueFindersCache(shoppingOrderItem);
        }
    }

    protected void cacheUniqueFindersCache(ShoppingOrderItem shoppingOrderItem) {
        if (shoppingOrderItem.isNew()) {
            Object[] args = new Object[] {
                    shoppingOrderItem.getShoppingOrderItemId()
                };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_SHOPPINGORDERITEMID,
                args, Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SHOPPINGORDERITEMID,
                args, shoppingOrderItem);
        } else {
            ShoppingOrderItemModelImpl shoppingOrderItemModelImpl = (ShoppingOrderItemModelImpl) shoppingOrderItem;

            if ((shoppingOrderItemModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_SHOPPINGORDERITEMID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        shoppingOrderItem.getShoppingOrderItemId()
                    };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_SHOPPINGORDERITEMID,
                    args, Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SHOPPINGORDERITEMID,
                    args, shoppingOrderItem);
            }
        }
    }

    protected void clearUniqueFindersCache(ShoppingOrderItem shoppingOrderItem) {
        ShoppingOrderItemModelImpl shoppingOrderItemModelImpl = (ShoppingOrderItemModelImpl) shoppingOrderItem;

        Object[] args = new Object[] { shoppingOrderItem.getShoppingOrderItemId() };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SHOPPINGORDERITEMID,
            args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_SHOPPINGORDERITEMID,
            args);

        if ((shoppingOrderItemModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_SHOPPINGORDERITEMID.getColumnBitmask()) != 0) {
            args = new Object[] {
                    shoppingOrderItemModelImpl.getOriginalShoppingOrderItemId()
                };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SHOPPINGORDERITEMID,
                args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_SHOPPINGORDERITEMID,
                args);
        }
    }

    /**
     * Creates a new shopping order item with the primary key. Does not add the shopping order item to the database.
     *
     * @param shoppingOrderItemId the primary key for the new shopping order item
     * @return the new shopping order item
     */
    @Override
    public ShoppingOrderItem create(long shoppingOrderItemId) {
        ShoppingOrderItem shoppingOrderItem = new ShoppingOrderItemImpl();

        shoppingOrderItem.setNew(true);
        shoppingOrderItem.setPrimaryKey(shoppingOrderItemId);

        return shoppingOrderItem;
    }

    /**
     * Removes the shopping order item with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param shoppingOrderItemId the primary key of the shopping order item
     * @return the shopping order item that was removed
     * @throws com.fsquare.shopping.NoSuchShoppingOrderItemException if a shopping order item with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingOrderItem remove(long shoppingOrderItemId)
        throws NoSuchShoppingOrderItemException, SystemException {
        return remove((Serializable) shoppingOrderItemId);
    }

    /**
     * Removes the shopping order item with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the shopping order item
     * @return the shopping order item that was removed
     * @throws com.fsquare.shopping.NoSuchShoppingOrderItemException if a shopping order item with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingOrderItem remove(Serializable primaryKey)
        throws NoSuchShoppingOrderItemException, SystemException {
        Session session = null;

        try {
            session = openSession();

            ShoppingOrderItem shoppingOrderItem = (ShoppingOrderItem) session.get(ShoppingOrderItemImpl.class,
                    primaryKey);

            if (shoppingOrderItem == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchShoppingOrderItemException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(shoppingOrderItem);
        } catch (NoSuchShoppingOrderItemException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected ShoppingOrderItem removeImpl(ShoppingOrderItem shoppingOrderItem)
        throws SystemException {
        shoppingOrderItem = toUnwrappedModel(shoppingOrderItem);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(shoppingOrderItem)) {
                shoppingOrderItem = (ShoppingOrderItem) session.get(ShoppingOrderItemImpl.class,
                        shoppingOrderItem.getPrimaryKeyObj());
            }

            if (shoppingOrderItem != null) {
                session.delete(shoppingOrderItem);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (shoppingOrderItem != null) {
            clearCache(shoppingOrderItem);
        }

        return shoppingOrderItem;
    }

    @Override
    public ShoppingOrderItem updateImpl(
        com.fsquare.shopping.model.ShoppingOrderItem shoppingOrderItem)
        throws SystemException {
        shoppingOrderItem = toUnwrappedModel(shoppingOrderItem);

        boolean isNew = shoppingOrderItem.isNew();

        ShoppingOrderItemModelImpl shoppingOrderItemModelImpl = (ShoppingOrderItemModelImpl) shoppingOrderItem;

        Session session = null;

        try {
            session = openSession();

            if (shoppingOrderItem.isNew()) {
                session.save(shoppingOrderItem);

                shoppingOrderItem.setNew(false);
            } else {
                session.merge(shoppingOrderItem);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !ShoppingOrderItemModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((shoppingOrderItemModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SHOPPINGORDERID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        shoppingOrderItemModelImpl.getOriginalShoppingOrderId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SHOPPINGORDERID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SHOPPINGORDERID,
                    args);

                args = new Object[] {
                        shoppingOrderItemModelImpl.getShoppingOrderId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SHOPPINGORDERID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SHOPPINGORDERID,
                    args);
            }

            if ((shoppingOrderItemModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ARTICLEID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        shoppingOrderItemModelImpl.getOriginalArticleId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ARTICLEID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ARTICLEID,
                    args);

                args = new Object[] { shoppingOrderItemModelImpl.getArticleId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ARTICLEID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ARTICLEID,
                    args);
            }
        }

        EntityCacheUtil.putResult(ShoppingOrderItemModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingOrderItemImpl.class, shoppingOrderItem.getPrimaryKey(),
            shoppingOrderItem);

        clearUniqueFindersCache(shoppingOrderItem);
        cacheUniqueFindersCache(shoppingOrderItem);

        return shoppingOrderItem;
    }

    protected ShoppingOrderItem toUnwrappedModel(
        ShoppingOrderItem shoppingOrderItem) {
        if (shoppingOrderItem instanceof ShoppingOrderItemImpl) {
            return shoppingOrderItem;
        }

        ShoppingOrderItemImpl shoppingOrderItemImpl = new ShoppingOrderItemImpl();

        shoppingOrderItemImpl.setNew(shoppingOrderItem.isNew());
        shoppingOrderItemImpl.setPrimaryKey(shoppingOrderItem.getPrimaryKey());

        shoppingOrderItemImpl.setShoppingOrderItemId(shoppingOrderItem.getShoppingOrderItemId());
        shoppingOrderItemImpl.setShoppingOrderId(shoppingOrderItem.getShoppingOrderId());
        shoppingOrderItemImpl.setArticleId(shoppingOrderItem.getArticleId());
        shoppingOrderItemImpl.setSku(shoppingOrderItem.getSku());
        shoppingOrderItemImpl.setName(shoppingOrderItem.getName());
        shoppingOrderItemImpl.setDescription(shoppingOrderItem.getDescription());
        shoppingOrderItemImpl.setProperties(shoppingOrderItem.getProperties());
        shoppingOrderItemImpl.setPrice(shoppingOrderItem.getPrice());
        shoppingOrderItemImpl.setQuantity(shoppingOrderItem.getQuantity());
        shoppingOrderItemImpl.setShippedDate(shoppingOrderItem.getShippedDate());

        return shoppingOrderItemImpl;
    }

    /**
     * Returns the shopping order item with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the shopping order item
     * @return the shopping order item
     * @throws com.fsquare.shopping.NoSuchShoppingOrderItemException if a shopping order item with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingOrderItem findByPrimaryKey(Serializable primaryKey)
        throws NoSuchShoppingOrderItemException, SystemException {
        ShoppingOrderItem shoppingOrderItem = fetchByPrimaryKey(primaryKey);

        if (shoppingOrderItem == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchShoppingOrderItemException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return shoppingOrderItem;
    }

    /**
     * Returns the shopping order item with the primary key or throws a {@link com.fsquare.shopping.NoSuchShoppingOrderItemException} if it could not be found.
     *
     * @param shoppingOrderItemId the primary key of the shopping order item
     * @return the shopping order item
     * @throws com.fsquare.shopping.NoSuchShoppingOrderItemException if a shopping order item with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingOrderItem findByPrimaryKey(long shoppingOrderItemId)
        throws NoSuchShoppingOrderItemException, SystemException {
        return findByPrimaryKey((Serializable) shoppingOrderItemId);
    }

    /**
     * Returns the shopping order item with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the shopping order item
     * @return the shopping order item, or <code>null</code> if a shopping order item with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingOrderItem fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        ShoppingOrderItem shoppingOrderItem = (ShoppingOrderItem) EntityCacheUtil.getResult(ShoppingOrderItemModelImpl.ENTITY_CACHE_ENABLED,
                ShoppingOrderItemImpl.class, primaryKey);

        if (shoppingOrderItem == _nullShoppingOrderItem) {
            return null;
        }

        if (shoppingOrderItem == null) {
            Session session = null;

            try {
                session = openSession();

                shoppingOrderItem = (ShoppingOrderItem) session.get(ShoppingOrderItemImpl.class,
                        primaryKey);

                if (shoppingOrderItem != null) {
                    cacheResult(shoppingOrderItem);
                } else {
                    EntityCacheUtil.putResult(ShoppingOrderItemModelImpl.ENTITY_CACHE_ENABLED,
                        ShoppingOrderItemImpl.class, primaryKey,
                        _nullShoppingOrderItem);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(ShoppingOrderItemModelImpl.ENTITY_CACHE_ENABLED,
                    ShoppingOrderItemImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return shoppingOrderItem;
    }

    /**
     * Returns the shopping order item with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param shoppingOrderItemId the primary key of the shopping order item
     * @return the shopping order item, or <code>null</code> if a shopping order item with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingOrderItem fetchByPrimaryKey(long shoppingOrderItemId)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) shoppingOrderItemId);
    }

    /**
     * Returns all the shopping order items.
     *
     * @return the shopping order items
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ShoppingOrderItem> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the shopping order items.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingOrderItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of shopping order items
     * @param end the upper bound of the range of shopping order items (not inclusive)
     * @return the range of shopping order items
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ShoppingOrderItem> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the shopping order items.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingOrderItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of shopping order items
     * @param end the upper bound of the range of shopping order items (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of shopping order items
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ShoppingOrderItem> findAll(int start, int end,
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

        List<ShoppingOrderItem> list = (List<ShoppingOrderItem>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_SHOPPINGORDERITEM);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_SHOPPINGORDERITEM;

                if (pagination) {
                    sql = sql.concat(ShoppingOrderItemModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<ShoppingOrderItem>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<ShoppingOrderItem>(list);
                } else {
                    list = (List<ShoppingOrderItem>) QueryUtil.list(q,
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
     * Removes all the shopping order items from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (ShoppingOrderItem shoppingOrderItem : findAll()) {
            remove(shoppingOrderItem);
        }
    }

    /**
     * Returns the number of shopping order items.
     *
     * @return the number of shopping order items
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

                Query q = session.createQuery(_SQL_COUNT_SHOPPINGORDERITEM);

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
     * Initializes the shopping order item persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.fsquare.shopping.model.ShoppingOrderItem")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<ShoppingOrderItem>> listenersList = new ArrayList<ModelListener<ShoppingOrderItem>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<ShoppingOrderItem>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(ShoppingOrderItemImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
