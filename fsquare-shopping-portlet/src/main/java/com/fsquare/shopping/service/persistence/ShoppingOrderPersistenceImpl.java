package com.fsquare.shopping.service.persistence;

import com.fsquare.shopping.NoSuchShoppingOrderException;
import com.fsquare.shopping.model.ShoppingOrder;
import com.fsquare.shopping.model.impl.ShoppingOrderImpl;
import com.fsquare.shopping.model.impl.ShoppingOrderModelImpl;
import com.fsquare.shopping.service.persistence.ShoppingOrderPersistence;

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
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the shopping order service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingOrderPersistence
 * @see ShoppingOrderUtil
 * @generated
 */
public class ShoppingOrderPersistenceImpl extends BasePersistenceImpl<ShoppingOrder>
    implements ShoppingOrderPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link ShoppingOrderUtil} to access the shopping order persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = ShoppingOrderImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ShoppingOrderModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingOrderModelImpl.FINDER_CACHE_ENABLED,
            ShoppingOrderImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ShoppingOrderModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingOrderModelImpl.FINDER_CACHE_ENABLED,
            ShoppingOrderImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ShoppingOrderModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingOrderModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID =
        new FinderPath(ShoppingOrderModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingOrderModelImpl.FINDER_CACHE_ENABLED,
            ShoppingOrderImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findByCompanyId",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID =
        new FinderPath(ShoppingOrderModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingOrderModelImpl.FINDER_CACHE_ENABLED,
            ShoppingOrderImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findByCompanyId", new String[] { Long.class.getName() },
            ShoppingOrderModelImpl.COMPANYID_COLUMN_BITMASK |
            ShoppingOrderModelImpl.CREATEDATE_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYID = new FinderPath(ShoppingOrderModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingOrderModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyId",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_COMPANYID_COMPANYID_2 = "shoppingOrder.companyId = ?";
    public static final FinderPath FINDER_PATH_FETCH_BY_NUMBER = new FinderPath(ShoppingOrderModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingOrderModelImpl.FINDER_CACHE_ENABLED,
            ShoppingOrderImpl.class, FINDER_CLASS_NAME_ENTITY, "fetchByNumber",
            new String[] { String.class.getName() },
            ShoppingOrderModelImpl.NUMBER_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_NUMBER = new FinderPath(ShoppingOrderModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingOrderModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByNumber",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_NUMBER_NUMBER_1 = "shoppingOrder.number IS NULL";
    private static final String _FINDER_COLUMN_NUMBER_NUMBER_2 = "shoppingOrder.number = ?";
    private static final String _FINDER_COLUMN_NUMBER_NUMBER_3 = "(shoppingOrder.number IS NULL OR shoppingOrder.number = '')";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PAYMENTTYPE =
        new FinderPath(ShoppingOrderModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingOrderModelImpl.FINDER_CACHE_ENABLED,
            ShoppingOrderImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findByPaymentType",
            new String[] {
                String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PAYMENTTYPE =
        new FinderPath(ShoppingOrderModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingOrderModelImpl.FINDER_CACHE_ENABLED,
            ShoppingOrderImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findByPaymentType", new String[] { String.class.getName() },
            ShoppingOrderModelImpl.PAYMENTTYPE_COLUMN_BITMASK |
            ShoppingOrderModelImpl.CREATEDATE_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_PAYMENTTYPE = new FinderPath(ShoppingOrderModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingOrderModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPaymentType",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_PAYMENTTYPE_PAYMENTTYPE_1 = "shoppingOrder.paymentType IS NULL";
    private static final String _FINDER_COLUMN_PAYMENTTYPE_PAYMENTTYPE_2 = "shoppingOrder.paymentType = ?";
    private static final String _FINDER_COLUMN_PAYMENTTYPE_PAYMENTTYPE_3 = "(shoppingOrder.paymentType IS NULL OR shoppingOrder.paymentType = '')";
    public static final FinderPath FINDER_PATH_FETCH_BY_EXTERNALPAYMENTID = new FinderPath(ShoppingOrderModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingOrderModelImpl.FINDER_CACHE_ENABLED,
            ShoppingOrderImpl.class, FINDER_CLASS_NAME_ENTITY,
            "fetchByExternalPaymentId",
            new String[] { String.class.getName() },
            ShoppingOrderModelImpl.EXTERNALPAYMENTID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_EXTERNALPAYMENTID = new FinderPath(ShoppingOrderModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingOrderModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByExternalPaymentId", new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_EXTERNALPAYMENTID_EXTERNALPAYMENTID_1 =
        "shoppingOrder.externalPaymentId IS NULL";
    private static final String _FINDER_COLUMN_EXTERNALPAYMENTID_EXTERNALPAYMENTID_2 =
        "shoppingOrder.externalPaymentId = ?";
    private static final String _FINDER_COLUMN_EXTERNALPAYMENTID_EXTERNALPAYMENTID_3 =
        "(shoppingOrder.externalPaymentId IS NULL OR shoppingOrder.externalPaymentId = '')";
    public static final FinderPath FINDER_PATH_FETCH_BY_STATUS = new FinderPath(ShoppingOrderModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingOrderModelImpl.FINDER_CACHE_ENABLED,
            ShoppingOrderImpl.class, FINDER_CLASS_NAME_ENTITY, "fetchByStatus",
            new String[] { String.class.getName() },
            ShoppingOrderModelImpl.STATUS_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_STATUS = new FinderPath(ShoppingOrderModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingOrderModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStatus",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_STATUS_STATUS_1 = "shoppingOrder.status IS NULL";
    private static final String _FINDER_COLUMN_STATUS_STATUS_2 = "shoppingOrder.status = ?";
    private static final String _FINDER_COLUMN_STATUS_STATUS_3 = "(shoppingOrder.status IS NULL OR shoppingOrder.status = '')";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYIDANDUSERID =
        new FinderPath(ShoppingOrderModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingOrderModelImpl.FINDER_CACHE_ENABLED,
            ShoppingOrderImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findBycompanyIdAndUserId",
            new String[] {
                Long.class.getName(), Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYIDANDUSERID =
        new FinderPath(ShoppingOrderModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingOrderModelImpl.FINDER_CACHE_ENABLED,
            ShoppingOrderImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findBycompanyIdAndUserId",
            new String[] { Long.class.getName(), Long.class.getName() },
            ShoppingOrderModelImpl.COMPANYID_COLUMN_BITMASK |
            ShoppingOrderModelImpl.USERID_COLUMN_BITMASK |
            ShoppingOrderModelImpl.CREATEDATE_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYIDANDUSERID = new FinderPath(ShoppingOrderModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingOrderModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countBycompanyIdAndUserId",
            new String[] { Long.class.getName(), Long.class.getName() });
    private static final String _FINDER_COLUMN_COMPANYIDANDUSERID_COMPANYID_2 = "shoppingOrder.companyId = ? AND ";
    private static final String _FINDER_COLUMN_COMPANYIDANDUSERID_USERID_2 = "shoppingOrder.userId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYIDANDEMAIL =
        new FinderPath(ShoppingOrderModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingOrderModelImpl.FINDER_CACHE_ENABLED,
            ShoppingOrderImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findBycompanyIdAndEmail",
            new String[] {
                Long.class.getName(), String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYIDANDEMAIL =
        new FinderPath(ShoppingOrderModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingOrderModelImpl.FINDER_CACHE_ENABLED,
            ShoppingOrderImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findBycompanyIdAndEmail",
            new String[] { Long.class.getName(), String.class.getName() },
            ShoppingOrderModelImpl.COMPANYID_COLUMN_BITMASK |
            ShoppingOrderModelImpl.SHIPPINGEMAILADDRESS_COLUMN_BITMASK |
            ShoppingOrderModelImpl.CREATEDATE_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYIDANDEMAIL = new FinderPath(ShoppingOrderModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingOrderModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countBycompanyIdAndEmail",
            new String[] { Long.class.getName(), String.class.getName() });
    private static final String _FINDER_COLUMN_COMPANYIDANDEMAIL_COMPANYID_2 = "shoppingOrder.companyId = ? AND ";
    private static final String _FINDER_COLUMN_COMPANYIDANDEMAIL_SHIPPINGEMAILADDRESS_1 =
        "shoppingOrder.shippingEmailAddress IS NULL";
    private static final String _FINDER_COLUMN_COMPANYIDANDEMAIL_SHIPPINGEMAILADDRESS_2 =
        "shoppingOrder.shippingEmailAddress = ?";
    private static final String _FINDER_COLUMN_COMPANYIDANDEMAIL_SHIPPINGEMAILADDRESS_3 =
        "(shoppingOrder.shippingEmailAddress IS NULL OR shoppingOrder.shippingEmailAddress = '')";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SHIPPINGMETHODID =
        new FinderPath(ShoppingOrderModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingOrderModelImpl.FINDER_CACHE_ENABLED,
            ShoppingOrderImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findByShippingMethodId",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SHIPPINGMETHODID =
        new FinderPath(ShoppingOrderModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingOrderModelImpl.FINDER_CACHE_ENABLED,
            ShoppingOrderImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findByShippingMethodId", new String[] { Long.class.getName() },
            ShoppingOrderModelImpl.SHIPPINGMETHODID_COLUMN_BITMASK |
            ShoppingOrderModelImpl.CREATEDATE_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_SHIPPINGMETHODID = new FinderPath(ShoppingOrderModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingOrderModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByShippingMethodId", new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_SHIPPINGMETHODID_SHIPPINGMETHODID_2 =
        "shoppingOrder.shippingMethodId = ?";
    private static final String _SQL_SELECT_SHOPPINGORDER = "SELECT shoppingOrder FROM ShoppingOrder shoppingOrder";
    private static final String _SQL_SELECT_SHOPPINGORDER_WHERE = "SELECT shoppingOrder FROM ShoppingOrder shoppingOrder WHERE ";
    private static final String _SQL_COUNT_SHOPPINGORDER = "SELECT COUNT(shoppingOrder) FROM ShoppingOrder shoppingOrder";
    private static final String _SQL_COUNT_SHOPPINGORDER_WHERE = "SELECT COUNT(shoppingOrder) FROM ShoppingOrder shoppingOrder WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "shoppingOrder.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ShoppingOrder exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ShoppingOrder exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(ShoppingOrderPersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "number"
            });
    private static ShoppingOrder _nullShoppingOrder = new ShoppingOrderImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<ShoppingOrder> toCacheModel() {
                return _nullShoppingOrderCacheModel;
            }
        };

    private static CacheModel<ShoppingOrder> _nullShoppingOrderCacheModel = new CacheModel<ShoppingOrder>() {
            @Override
            public ShoppingOrder toEntityModel() {
                return _nullShoppingOrder;
            }
        };

    public ShoppingOrderPersistenceImpl() {
        setModelClass(ShoppingOrder.class);
    }

    /**
     * Returns all the shopping orders where companyId = &#63;.
     *
     * @param companyId the company ID
     * @return the matching shopping orders
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ShoppingOrder> findByCompanyId(long companyId)
        throws SystemException {
        return findByCompanyId(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
    }

    /**
     * Returns a range of all the shopping orders where companyId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param companyId the company ID
     * @param start the lower bound of the range of shopping orders
     * @param end the upper bound of the range of shopping orders (not inclusive)
     * @return the range of matching shopping orders
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ShoppingOrder> findByCompanyId(long companyId, int start,
        int end) throws SystemException {
        return findByCompanyId(companyId, start, end, null);
    }

    /**
     * Returns an ordered range of all the shopping orders where companyId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param companyId the company ID
     * @param start the lower bound of the range of shopping orders
     * @param end the upper bound of the range of shopping orders (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching shopping orders
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ShoppingOrder> findByCompanyId(long companyId, int start,
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

        List<ShoppingOrder> list = (List<ShoppingOrder>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (ShoppingOrder shoppingOrder : list) {
                if ((companyId != shoppingOrder.getCompanyId())) {
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

            query.append(_SQL_SELECT_SHOPPINGORDER_WHERE);

            query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(ShoppingOrderModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyId);

                if (!pagination) {
                    list = (List<ShoppingOrder>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<ShoppingOrder>(list);
                } else {
                    list = (List<ShoppingOrder>) QueryUtil.list(q,
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
     * Returns the first shopping order in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching shopping order
     * @throws com.fsquare.shopping.NoSuchShoppingOrderException if a matching shopping order could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingOrder findByCompanyId_First(long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchShoppingOrderException, SystemException {
        ShoppingOrder shoppingOrder = fetchByCompanyId_First(companyId,
                orderByComparator);

        if (shoppingOrder != null) {
            return shoppingOrder;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchShoppingOrderException(msg.toString());
    }

    /**
     * Returns the first shopping order in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching shopping order, or <code>null</code> if a matching shopping order could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingOrder fetchByCompanyId_First(long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        List<ShoppingOrder> list = findByCompanyId(companyId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last shopping order in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching shopping order
     * @throws com.fsquare.shopping.NoSuchShoppingOrderException if a matching shopping order could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingOrder findByCompanyId_Last(long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchShoppingOrderException, SystemException {
        ShoppingOrder shoppingOrder = fetchByCompanyId_Last(companyId,
                orderByComparator);

        if (shoppingOrder != null) {
            return shoppingOrder;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchShoppingOrderException(msg.toString());
    }

    /**
     * Returns the last shopping order in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching shopping order, or <code>null</code> if a matching shopping order could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingOrder fetchByCompanyId_Last(long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByCompanyId(companyId);

        if (count == 0) {
            return null;
        }

        List<ShoppingOrder> list = findByCompanyId(companyId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the shopping orders before and after the current shopping order in the ordered set where companyId = &#63;.
     *
     * @param shoppingOrderId the primary key of the current shopping order
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next shopping order
     * @throws com.fsquare.shopping.NoSuchShoppingOrderException if a shopping order with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingOrder[] findByCompanyId_PrevAndNext(long shoppingOrderId,
        long companyId, OrderByComparator orderByComparator)
        throws NoSuchShoppingOrderException, SystemException {
        ShoppingOrder shoppingOrder = findByPrimaryKey(shoppingOrderId);

        Session session = null;

        try {
            session = openSession();

            ShoppingOrder[] array = new ShoppingOrderImpl[3];

            array[0] = getByCompanyId_PrevAndNext(session, shoppingOrder,
                    companyId, orderByComparator, true);

            array[1] = shoppingOrder;

            array[2] = getByCompanyId_PrevAndNext(session, shoppingOrder,
                    companyId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected ShoppingOrder getByCompanyId_PrevAndNext(Session session,
        ShoppingOrder shoppingOrder, long companyId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_SHOPPINGORDER_WHERE);

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
            query.append(ShoppingOrderModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(companyId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(shoppingOrder);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<ShoppingOrder> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the shopping orders where companyId = &#63; from the database.
     *
     * @param companyId the company ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByCompanyId(long companyId) throws SystemException {
        for (ShoppingOrder shoppingOrder : findByCompanyId(companyId,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(shoppingOrder);
        }
    }

    /**
     * Returns the number of shopping orders where companyId = &#63;.
     *
     * @param companyId the company ID
     * @return the number of matching shopping orders
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

            query.append(_SQL_COUNT_SHOPPINGORDER_WHERE);

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
     * Returns the shopping order where number = &#63; or throws a {@link com.fsquare.shopping.NoSuchShoppingOrderException} if it could not be found.
     *
     * @param number the number
     * @return the matching shopping order
     * @throws com.fsquare.shopping.NoSuchShoppingOrderException if a matching shopping order could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingOrder findByNumber(String number)
        throws NoSuchShoppingOrderException, SystemException {
        ShoppingOrder shoppingOrder = fetchByNumber(number);

        if (shoppingOrder == null) {
            StringBundler msg = new StringBundler(4);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("number=");
            msg.append(number);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchShoppingOrderException(msg.toString());
        }

        return shoppingOrder;
    }

    /**
     * Returns the shopping order where number = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param number the number
     * @return the matching shopping order, or <code>null</code> if a matching shopping order could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingOrder fetchByNumber(String number) throws SystemException {
        return fetchByNumber(number, true);
    }

    /**
     * Returns the shopping order where number = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param number the number
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching shopping order, or <code>null</code> if a matching shopping order could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingOrder fetchByNumber(String number, boolean retrieveFromCache)
        throws SystemException {
        Object[] finderArgs = new Object[] { number };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_NUMBER,
                    finderArgs, this);
        }

        if (result instanceof ShoppingOrder) {
            ShoppingOrder shoppingOrder = (ShoppingOrder) result;

            if (!Validator.equals(number, shoppingOrder.getNumber())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_SELECT_SHOPPINGORDER_WHERE);

            boolean bindNumber = false;

            if (number == null) {
                query.append(_FINDER_COLUMN_NUMBER_NUMBER_1);
            } else if (number.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_NUMBER_NUMBER_3);
            } else {
                bindNumber = true;

                query.append(_FINDER_COLUMN_NUMBER_NUMBER_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindNumber) {
                    qPos.add(number);
                }

                List<ShoppingOrder> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NUMBER,
                        finderArgs, list);
                } else {
                    ShoppingOrder shoppingOrder = list.get(0);

                    result = shoppingOrder;

                    cacheResult(shoppingOrder);

                    if ((shoppingOrder.getNumber() == null) ||
                            !shoppingOrder.getNumber().equals(number)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NUMBER,
                            finderArgs, shoppingOrder);
                    }
                }
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NUMBER,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        if (result instanceof List<?>) {
            return null;
        } else {
            return (ShoppingOrder) result;
        }
    }

    /**
     * Removes the shopping order where number = &#63; from the database.
     *
     * @param number the number
     * @return the shopping order that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingOrder removeByNumber(String number)
        throws NoSuchShoppingOrderException, SystemException {
        ShoppingOrder shoppingOrder = findByNumber(number);

        return remove(shoppingOrder);
    }

    /**
     * Returns the number of shopping orders where number = &#63;.
     *
     * @param number the number
     * @return the number of matching shopping orders
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByNumber(String number) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_NUMBER;

        Object[] finderArgs = new Object[] { number };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_SHOPPINGORDER_WHERE);

            boolean bindNumber = false;

            if (number == null) {
                query.append(_FINDER_COLUMN_NUMBER_NUMBER_1);
            } else if (number.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_NUMBER_NUMBER_3);
            } else {
                bindNumber = true;

                query.append(_FINDER_COLUMN_NUMBER_NUMBER_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindNumber) {
                    qPos.add(number);
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
     * Returns all the shopping orders where paymentType = &#63;.
     *
     * @param paymentType the payment type
     * @return the matching shopping orders
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ShoppingOrder> findByPaymentType(String paymentType)
        throws SystemException {
        return findByPaymentType(paymentType, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the shopping orders where paymentType = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param paymentType the payment type
     * @param start the lower bound of the range of shopping orders
     * @param end the upper bound of the range of shopping orders (not inclusive)
     * @return the range of matching shopping orders
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ShoppingOrder> findByPaymentType(String paymentType, int start,
        int end) throws SystemException {
        return findByPaymentType(paymentType, start, end, null);
    }

    /**
     * Returns an ordered range of all the shopping orders where paymentType = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param paymentType the payment type
     * @param start the lower bound of the range of shopping orders
     * @param end the upper bound of the range of shopping orders (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching shopping orders
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ShoppingOrder> findByPaymentType(String paymentType, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PAYMENTTYPE;
            finderArgs = new Object[] { paymentType };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PAYMENTTYPE;
            finderArgs = new Object[] { paymentType, start, end, orderByComparator };
        }

        List<ShoppingOrder> list = (List<ShoppingOrder>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (ShoppingOrder shoppingOrder : list) {
                if (!Validator.equals(paymentType,
                            shoppingOrder.getPaymentType())) {
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

            query.append(_SQL_SELECT_SHOPPINGORDER_WHERE);

            boolean bindPaymentType = false;

            if (paymentType == null) {
                query.append(_FINDER_COLUMN_PAYMENTTYPE_PAYMENTTYPE_1);
            } else if (paymentType.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_PAYMENTTYPE_PAYMENTTYPE_3);
            } else {
                bindPaymentType = true;

                query.append(_FINDER_COLUMN_PAYMENTTYPE_PAYMENTTYPE_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(ShoppingOrderModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindPaymentType) {
                    qPos.add(paymentType);
                }

                if (!pagination) {
                    list = (List<ShoppingOrder>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<ShoppingOrder>(list);
                } else {
                    list = (List<ShoppingOrder>) QueryUtil.list(q,
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
     * Returns the first shopping order in the ordered set where paymentType = &#63;.
     *
     * @param paymentType the payment type
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching shopping order
     * @throws com.fsquare.shopping.NoSuchShoppingOrderException if a matching shopping order could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingOrder findByPaymentType_First(String paymentType,
        OrderByComparator orderByComparator)
        throws NoSuchShoppingOrderException, SystemException {
        ShoppingOrder shoppingOrder = fetchByPaymentType_First(paymentType,
                orderByComparator);

        if (shoppingOrder != null) {
            return shoppingOrder;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("paymentType=");
        msg.append(paymentType);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchShoppingOrderException(msg.toString());
    }

    /**
     * Returns the first shopping order in the ordered set where paymentType = &#63;.
     *
     * @param paymentType the payment type
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching shopping order, or <code>null</code> if a matching shopping order could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingOrder fetchByPaymentType_First(String paymentType,
        OrderByComparator orderByComparator) throws SystemException {
        List<ShoppingOrder> list = findByPaymentType(paymentType, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last shopping order in the ordered set where paymentType = &#63;.
     *
     * @param paymentType the payment type
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching shopping order
     * @throws com.fsquare.shopping.NoSuchShoppingOrderException if a matching shopping order could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingOrder findByPaymentType_Last(String paymentType,
        OrderByComparator orderByComparator)
        throws NoSuchShoppingOrderException, SystemException {
        ShoppingOrder shoppingOrder = fetchByPaymentType_Last(paymentType,
                orderByComparator);

        if (shoppingOrder != null) {
            return shoppingOrder;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("paymentType=");
        msg.append(paymentType);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchShoppingOrderException(msg.toString());
    }

    /**
     * Returns the last shopping order in the ordered set where paymentType = &#63;.
     *
     * @param paymentType the payment type
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching shopping order, or <code>null</code> if a matching shopping order could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingOrder fetchByPaymentType_Last(String paymentType,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByPaymentType(paymentType);

        if (count == 0) {
            return null;
        }

        List<ShoppingOrder> list = findByPaymentType(paymentType, count - 1,
                count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the shopping orders before and after the current shopping order in the ordered set where paymentType = &#63;.
     *
     * @param shoppingOrderId the primary key of the current shopping order
     * @param paymentType the payment type
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next shopping order
     * @throws com.fsquare.shopping.NoSuchShoppingOrderException if a shopping order with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingOrder[] findByPaymentType_PrevAndNext(long shoppingOrderId,
        String paymentType, OrderByComparator orderByComparator)
        throws NoSuchShoppingOrderException, SystemException {
        ShoppingOrder shoppingOrder = findByPrimaryKey(shoppingOrderId);

        Session session = null;

        try {
            session = openSession();

            ShoppingOrder[] array = new ShoppingOrderImpl[3];

            array[0] = getByPaymentType_PrevAndNext(session, shoppingOrder,
                    paymentType, orderByComparator, true);

            array[1] = shoppingOrder;

            array[2] = getByPaymentType_PrevAndNext(session, shoppingOrder,
                    paymentType, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected ShoppingOrder getByPaymentType_PrevAndNext(Session session,
        ShoppingOrder shoppingOrder, String paymentType,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_SHOPPINGORDER_WHERE);

        boolean bindPaymentType = false;

        if (paymentType == null) {
            query.append(_FINDER_COLUMN_PAYMENTTYPE_PAYMENTTYPE_1);
        } else if (paymentType.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_PAYMENTTYPE_PAYMENTTYPE_3);
        } else {
            bindPaymentType = true;

            query.append(_FINDER_COLUMN_PAYMENTTYPE_PAYMENTTYPE_2);
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
            query.append(ShoppingOrderModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindPaymentType) {
            qPos.add(paymentType);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(shoppingOrder);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<ShoppingOrder> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the shopping orders where paymentType = &#63; from the database.
     *
     * @param paymentType the payment type
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByPaymentType(String paymentType)
        throws SystemException {
        for (ShoppingOrder shoppingOrder : findByPaymentType(paymentType,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(shoppingOrder);
        }
    }

    /**
     * Returns the number of shopping orders where paymentType = &#63;.
     *
     * @param paymentType the payment type
     * @return the number of matching shopping orders
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByPaymentType(String paymentType) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_PAYMENTTYPE;

        Object[] finderArgs = new Object[] { paymentType };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_SHOPPINGORDER_WHERE);

            boolean bindPaymentType = false;

            if (paymentType == null) {
                query.append(_FINDER_COLUMN_PAYMENTTYPE_PAYMENTTYPE_1);
            } else if (paymentType.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_PAYMENTTYPE_PAYMENTTYPE_3);
            } else {
                bindPaymentType = true;

                query.append(_FINDER_COLUMN_PAYMENTTYPE_PAYMENTTYPE_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindPaymentType) {
                    qPos.add(paymentType);
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
     * Returns the shopping order where externalPaymentId = &#63; or throws a {@link com.fsquare.shopping.NoSuchShoppingOrderException} if it could not be found.
     *
     * @param externalPaymentId the external payment ID
     * @return the matching shopping order
     * @throws com.fsquare.shopping.NoSuchShoppingOrderException if a matching shopping order could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingOrder findByExternalPaymentId(String externalPaymentId)
        throws NoSuchShoppingOrderException, SystemException {
        ShoppingOrder shoppingOrder = fetchByExternalPaymentId(externalPaymentId);

        if (shoppingOrder == null) {
            StringBundler msg = new StringBundler(4);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("externalPaymentId=");
            msg.append(externalPaymentId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchShoppingOrderException(msg.toString());
        }

        return shoppingOrder;
    }

    /**
     * Returns the shopping order where externalPaymentId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param externalPaymentId the external payment ID
     * @return the matching shopping order, or <code>null</code> if a matching shopping order could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingOrder fetchByExternalPaymentId(String externalPaymentId)
        throws SystemException {
        return fetchByExternalPaymentId(externalPaymentId, true);
    }

    /**
     * Returns the shopping order where externalPaymentId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param externalPaymentId the external payment ID
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching shopping order, or <code>null</code> if a matching shopping order could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingOrder fetchByExternalPaymentId(String externalPaymentId,
        boolean retrieveFromCache) throws SystemException {
        Object[] finderArgs = new Object[] { externalPaymentId };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_EXTERNALPAYMENTID,
                    finderArgs, this);
        }

        if (result instanceof ShoppingOrder) {
            ShoppingOrder shoppingOrder = (ShoppingOrder) result;

            if (!Validator.equals(externalPaymentId,
                        shoppingOrder.getExternalPaymentId())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_SELECT_SHOPPINGORDER_WHERE);

            boolean bindExternalPaymentId = false;

            if (externalPaymentId == null) {
                query.append(_FINDER_COLUMN_EXTERNALPAYMENTID_EXTERNALPAYMENTID_1);
            } else if (externalPaymentId.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_EXTERNALPAYMENTID_EXTERNALPAYMENTID_3);
            } else {
                bindExternalPaymentId = true;

                query.append(_FINDER_COLUMN_EXTERNALPAYMENTID_EXTERNALPAYMENTID_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindExternalPaymentId) {
                    qPos.add(externalPaymentId);
                }

                List<ShoppingOrder> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EXTERNALPAYMENTID,
                        finderArgs, list);
                } else {
                    if ((list.size() > 1) && _log.isWarnEnabled()) {
                        _log.warn(
                            "ShoppingOrderPersistenceImpl.fetchByExternalPaymentId(String, boolean) with parameters (" +
                            StringUtil.merge(finderArgs) +
                            ") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
                    }

                    ShoppingOrder shoppingOrder = list.get(0);

                    result = shoppingOrder;

                    cacheResult(shoppingOrder);

                    if ((shoppingOrder.getExternalPaymentId() == null) ||
                            !shoppingOrder.getExternalPaymentId()
                                              .equals(externalPaymentId)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EXTERNALPAYMENTID,
                            finderArgs, shoppingOrder);
                    }
                }
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EXTERNALPAYMENTID,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        if (result instanceof List<?>) {
            return null;
        } else {
            return (ShoppingOrder) result;
        }
    }

    /**
     * Removes the shopping order where externalPaymentId = &#63; from the database.
     *
     * @param externalPaymentId the external payment ID
     * @return the shopping order that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingOrder removeByExternalPaymentId(String externalPaymentId)
        throws NoSuchShoppingOrderException, SystemException {
        ShoppingOrder shoppingOrder = findByExternalPaymentId(externalPaymentId);

        return remove(shoppingOrder);
    }

    /**
     * Returns the number of shopping orders where externalPaymentId = &#63;.
     *
     * @param externalPaymentId the external payment ID
     * @return the number of matching shopping orders
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByExternalPaymentId(String externalPaymentId)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_EXTERNALPAYMENTID;

        Object[] finderArgs = new Object[] { externalPaymentId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_SHOPPINGORDER_WHERE);

            boolean bindExternalPaymentId = false;

            if (externalPaymentId == null) {
                query.append(_FINDER_COLUMN_EXTERNALPAYMENTID_EXTERNALPAYMENTID_1);
            } else if (externalPaymentId.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_EXTERNALPAYMENTID_EXTERNALPAYMENTID_3);
            } else {
                bindExternalPaymentId = true;

                query.append(_FINDER_COLUMN_EXTERNALPAYMENTID_EXTERNALPAYMENTID_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindExternalPaymentId) {
                    qPos.add(externalPaymentId);
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
     * Returns the shopping order where status = &#63; or throws a {@link com.fsquare.shopping.NoSuchShoppingOrderException} if it could not be found.
     *
     * @param status the status
     * @return the matching shopping order
     * @throws com.fsquare.shopping.NoSuchShoppingOrderException if a matching shopping order could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingOrder findByStatus(String status)
        throws NoSuchShoppingOrderException, SystemException {
        ShoppingOrder shoppingOrder = fetchByStatus(status);

        if (shoppingOrder == null) {
            StringBundler msg = new StringBundler(4);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("status=");
            msg.append(status);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchShoppingOrderException(msg.toString());
        }

        return shoppingOrder;
    }

    /**
     * Returns the shopping order where status = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param status the status
     * @return the matching shopping order, or <code>null</code> if a matching shopping order could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingOrder fetchByStatus(String status) throws SystemException {
        return fetchByStatus(status, true);
    }

    /**
     * Returns the shopping order where status = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param status the status
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching shopping order, or <code>null</code> if a matching shopping order could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingOrder fetchByStatus(String status, boolean retrieveFromCache)
        throws SystemException {
        Object[] finderArgs = new Object[] { status };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_STATUS,
                    finderArgs, this);
        }

        if (result instanceof ShoppingOrder) {
            ShoppingOrder shoppingOrder = (ShoppingOrder) result;

            if (!Validator.equals(status, shoppingOrder.getStatus())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_SELECT_SHOPPINGORDER_WHERE);

            boolean bindStatus = false;

            if (status == null) {
                query.append(_FINDER_COLUMN_STATUS_STATUS_1);
            } else if (status.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_STATUS_STATUS_3);
            } else {
                bindStatus = true;

                query.append(_FINDER_COLUMN_STATUS_STATUS_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindStatus) {
                    qPos.add(status);
                }

                List<ShoppingOrder> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STATUS,
                        finderArgs, list);
                } else {
                    if ((list.size() > 1) && _log.isWarnEnabled()) {
                        _log.warn(
                            "ShoppingOrderPersistenceImpl.fetchByStatus(String, boolean) with parameters (" +
                            StringUtil.merge(finderArgs) +
                            ") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
                    }

                    ShoppingOrder shoppingOrder = list.get(0);

                    result = shoppingOrder;

                    cacheResult(shoppingOrder);

                    if ((shoppingOrder.getStatus() == null) ||
                            !shoppingOrder.getStatus().equals(status)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STATUS,
                            finderArgs, shoppingOrder);
                    }
                }
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_STATUS,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        if (result instanceof List<?>) {
            return null;
        } else {
            return (ShoppingOrder) result;
        }
    }

    /**
     * Removes the shopping order where status = &#63; from the database.
     *
     * @param status the status
     * @return the shopping order that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingOrder removeByStatus(String status)
        throws NoSuchShoppingOrderException, SystemException {
        ShoppingOrder shoppingOrder = findByStatus(status);

        return remove(shoppingOrder);
    }

    /**
     * Returns the number of shopping orders where status = &#63;.
     *
     * @param status the status
     * @return the number of matching shopping orders
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByStatus(String status) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_STATUS;

        Object[] finderArgs = new Object[] { status };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_SHOPPINGORDER_WHERE);

            boolean bindStatus = false;

            if (status == null) {
                query.append(_FINDER_COLUMN_STATUS_STATUS_1);
            } else if (status.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_STATUS_STATUS_3);
            } else {
                bindStatus = true;

                query.append(_FINDER_COLUMN_STATUS_STATUS_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindStatus) {
                    qPos.add(status);
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
     * Returns all the shopping orders where companyId = &#63; and userId = &#63;.
     *
     * @param companyId the company ID
     * @param userId the user ID
     * @return the matching shopping orders
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ShoppingOrder> findBycompanyIdAndUserId(long companyId,
        long userId) throws SystemException {
        return findBycompanyIdAndUserId(companyId, userId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the shopping orders where companyId = &#63; and userId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param companyId the company ID
     * @param userId the user ID
     * @param start the lower bound of the range of shopping orders
     * @param end the upper bound of the range of shopping orders (not inclusive)
     * @return the range of matching shopping orders
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ShoppingOrder> findBycompanyIdAndUserId(long companyId,
        long userId, int start, int end) throws SystemException {
        return findBycompanyIdAndUserId(companyId, userId, start, end, null);
    }

    /**
     * Returns an ordered range of all the shopping orders where companyId = &#63; and userId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param companyId the company ID
     * @param userId the user ID
     * @param start the lower bound of the range of shopping orders
     * @param end the upper bound of the range of shopping orders (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching shopping orders
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ShoppingOrder> findBycompanyIdAndUserId(long companyId,
        long userId, int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYIDANDUSERID;
            finderArgs = new Object[] { companyId, userId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYIDANDUSERID;
            finderArgs = new Object[] {
                    companyId, userId,
                    
                    start, end, orderByComparator
                };
        }

        List<ShoppingOrder> list = (List<ShoppingOrder>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (ShoppingOrder shoppingOrder : list) {
                if ((companyId != shoppingOrder.getCompanyId()) ||
                        (userId != shoppingOrder.getUserId())) {
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

            query.append(_SQL_SELECT_SHOPPINGORDER_WHERE);

            query.append(_FINDER_COLUMN_COMPANYIDANDUSERID_COMPANYID_2);

            query.append(_FINDER_COLUMN_COMPANYIDANDUSERID_USERID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(ShoppingOrderModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyId);

                qPos.add(userId);

                if (!pagination) {
                    list = (List<ShoppingOrder>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<ShoppingOrder>(list);
                } else {
                    list = (List<ShoppingOrder>) QueryUtil.list(q,
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
     * Returns the first shopping order in the ordered set where companyId = &#63; and userId = &#63;.
     *
     * @param companyId the company ID
     * @param userId the user ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching shopping order
     * @throws com.fsquare.shopping.NoSuchShoppingOrderException if a matching shopping order could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingOrder findBycompanyIdAndUserId_First(long companyId,
        long userId, OrderByComparator orderByComparator)
        throws NoSuchShoppingOrderException, SystemException {
        ShoppingOrder shoppingOrder = fetchBycompanyIdAndUserId_First(companyId,
                userId, orderByComparator);

        if (shoppingOrder != null) {
            return shoppingOrder;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(", userId=");
        msg.append(userId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchShoppingOrderException(msg.toString());
    }

    /**
     * Returns the first shopping order in the ordered set where companyId = &#63; and userId = &#63;.
     *
     * @param companyId the company ID
     * @param userId the user ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching shopping order, or <code>null</code> if a matching shopping order could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingOrder fetchBycompanyIdAndUserId_First(long companyId,
        long userId, OrderByComparator orderByComparator)
        throws SystemException {
        List<ShoppingOrder> list = findBycompanyIdAndUserId(companyId, userId,
                0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last shopping order in the ordered set where companyId = &#63; and userId = &#63;.
     *
     * @param companyId the company ID
     * @param userId the user ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching shopping order
     * @throws com.fsquare.shopping.NoSuchShoppingOrderException if a matching shopping order could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingOrder findBycompanyIdAndUserId_Last(long companyId,
        long userId, OrderByComparator orderByComparator)
        throws NoSuchShoppingOrderException, SystemException {
        ShoppingOrder shoppingOrder = fetchBycompanyIdAndUserId_Last(companyId,
                userId, orderByComparator);

        if (shoppingOrder != null) {
            return shoppingOrder;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(", userId=");
        msg.append(userId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchShoppingOrderException(msg.toString());
    }

    /**
     * Returns the last shopping order in the ordered set where companyId = &#63; and userId = &#63;.
     *
     * @param companyId the company ID
     * @param userId the user ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching shopping order, or <code>null</code> if a matching shopping order could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingOrder fetchBycompanyIdAndUserId_Last(long companyId,
        long userId, OrderByComparator orderByComparator)
        throws SystemException {
        int count = countBycompanyIdAndUserId(companyId, userId);

        if (count == 0) {
            return null;
        }

        List<ShoppingOrder> list = findBycompanyIdAndUserId(companyId, userId,
                count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the shopping orders before and after the current shopping order in the ordered set where companyId = &#63; and userId = &#63;.
     *
     * @param shoppingOrderId the primary key of the current shopping order
     * @param companyId the company ID
     * @param userId the user ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next shopping order
     * @throws com.fsquare.shopping.NoSuchShoppingOrderException if a shopping order with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingOrder[] findBycompanyIdAndUserId_PrevAndNext(
        long shoppingOrderId, long companyId, long userId,
        OrderByComparator orderByComparator)
        throws NoSuchShoppingOrderException, SystemException {
        ShoppingOrder shoppingOrder = findByPrimaryKey(shoppingOrderId);

        Session session = null;

        try {
            session = openSession();

            ShoppingOrder[] array = new ShoppingOrderImpl[3];

            array[0] = getBycompanyIdAndUserId_PrevAndNext(session,
                    shoppingOrder, companyId, userId, orderByComparator, true);

            array[1] = shoppingOrder;

            array[2] = getBycompanyIdAndUserId_PrevAndNext(session,
                    shoppingOrder, companyId, userId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected ShoppingOrder getBycompanyIdAndUserId_PrevAndNext(
        Session session, ShoppingOrder shoppingOrder, long companyId,
        long userId, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_SHOPPINGORDER_WHERE);

        query.append(_FINDER_COLUMN_COMPANYIDANDUSERID_COMPANYID_2);

        query.append(_FINDER_COLUMN_COMPANYIDANDUSERID_USERID_2);

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
            query.append(ShoppingOrderModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(companyId);

        qPos.add(userId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(shoppingOrder);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<ShoppingOrder> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the shopping orders where companyId = &#63; and userId = &#63; from the database.
     *
     * @param companyId the company ID
     * @param userId the user ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeBycompanyIdAndUserId(long companyId, long userId)
        throws SystemException {
        for (ShoppingOrder shoppingOrder : findBycompanyIdAndUserId(companyId,
                userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(shoppingOrder);
        }
    }

    /**
     * Returns the number of shopping orders where companyId = &#63; and userId = &#63;.
     *
     * @param companyId the company ID
     * @param userId the user ID
     * @return the number of matching shopping orders
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countBycompanyIdAndUserId(long companyId, long userId)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_COMPANYIDANDUSERID;

        Object[] finderArgs = new Object[] { companyId, userId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_SHOPPINGORDER_WHERE);

            query.append(_FINDER_COLUMN_COMPANYIDANDUSERID_COMPANYID_2);

            query.append(_FINDER_COLUMN_COMPANYIDANDUSERID_USERID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyId);

                qPos.add(userId);

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
     * Returns all the shopping orders where companyId = &#63; and shippingEmailAddress = &#63;.
     *
     * @param companyId the company ID
     * @param shippingEmailAddress the shipping email address
     * @return the matching shopping orders
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ShoppingOrder> findBycompanyIdAndEmail(long companyId,
        String shippingEmailAddress) throws SystemException {
        return findBycompanyIdAndEmail(companyId, shippingEmailAddress,
            QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the shopping orders where companyId = &#63; and shippingEmailAddress = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param companyId the company ID
     * @param shippingEmailAddress the shipping email address
     * @param start the lower bound of the range of shopping orders
     * @param end the upper bound of the range of shopping orders (not inclusive)
     * @return the range of matching shopping orders
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ShoppingOrder> findBycompanyIdAndEmail(long companyId,
        String shippingEmailAddress, int start, int end)
        throws SystemException {
        return findBycompanyIdAndEmail(companyId, shippingEmailAddress, start,
            end, null);
    }

    /**
     * Returns an ordered range of all the shopping orders where companyId = &#63; and shippingEmailAddress = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param companyId the company ID
     * @param shippingEmailAddress the shipping email address
     * @param start the lower bound of the range of shopping orders
     * @param end the upper bound of the range of shopping orders (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching shopping orders
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ShoppingOrder> findBycompanyIdAndEmail(long companyId,
        String shippingEmailAddress, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYIDANDEMAIL;
            finderArgs = new Object[] { companyId, shippingEmailAddress };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYIDANDEMAIL;
            finderArgs = new Object[] {
                    companyId, shippingEmailAddress,
                    
                    start, end, orderByComparator
                };
        }

        List<ShoppingOrder> list = (List<ShoppingOrder>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (ShoppingOrder shoppingOrder : list) {
                if ((companyId != shoppingOrder.getCompanyId()) ||
                        !Validator.equals(shippingEmailAddress,
                            shoppingOrder.getShippingEmailAddress())) {
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

            query.append(_SQL_SELECT_SHOPPINGORDER_WHERE);

            query.append(_FINDER_COLUMN_COMPANYIDANDEMAIL_COMPANYID_2);

            boolean bindShippingEmailAddress = false;

            if (shippingEmailAddress == null) {
                query.append(_FINDER_COLUMN_COMPANYIDANDEMAIL_SHIPPINGEMAILADDRESS_1);
            } else if (shippingEmailAddress.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_COMPANYIDANDEMAIL_SHIPPINGEMAILADDRESS_3);
            } else {
                bindShippingEmailAddress = true;

                query.append(_FINDER_COLUMN_COMPANYIDANDEMAIL_SHIPPINGEMAILADDRESS_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(ShoppingOrderModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyId);

                if (bindShippingEmailAddress) {
                    qPos.add(shippingEmailAddress);
                }

                if (!pagination) {
                    list = (List<ShoppingOrder>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<ShoppingOrder>(list);
                } else {
                    list = (List<ShoppingOrder>) QueryUtil.list(q,
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
     * Returns the first shopping order in the ordered set where companyId = &#63; and shippingEmailAddress = &#63;.
     *
     * @param companyId the company ID
     * @param shippingEmailAddress the shipping email address
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching shopping order
     * @throws com.fsquare.shopping.NoSuchShoppingOrderException if a matching shopping order could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingOrder findBycompanyIdAndEmail_First(long companyId,
        String shippingEmailAddress, OrderByComparator orderByComparator)
        throws NoSuchShoppingOrderException, SystemException {
        ShoppingOrder shoppingOrder = fetchBycompanyIdAndEmail_First(companyId,
                shippingEmailAddress, orderByComparator);

        if (shoppingOrder != null) {
            return shoppingOrder;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(", shippingEmailAddress=");
        msg.append(shippingEmailAddress);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchShoppingOrderException(msg.toString());
    }

    /**
     * Returns the first shopping order in the ordered set where companyId = &#63; and shippingEmailAddress = &#63;.
     *
     * @param companyId the company ID
     * @param shippingEmailAddress the shipping email address
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching shopping order, or <code>null</code> if a matching shopping order could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingOrder fetchBycompanyIdAndEmail_First(long companyId,
        String shippingEmailAddress, OrderByComparator orderByComparator)
        throws SystemException {
        List<ShoppingOrder> list = findBycompanyIdAndEmail(companyId,
                shippingEmailAddress, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last shopping order in the ordered set where companyId = &#63; and shippingEmailAddress = &#63;.
     *
     * @param companyId the company ID
     * @param shippingEmailAddress the shipping email address
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching shopping order
     * @throws com.fsquare.shopping.NoSuchShoppingOrderException if a matching shopping order could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingOrder findBycompanyIdAndEmail_Last(long companyId,
        String shippingEmailAddress, OrderByComparator orderByComparator)
        throws NoSuchShoppingOrderException, SystemException {
        ShoppingOrder shoppingOrder = fetchBycompanyIdAndEmail_Last(companyId,
                shippingEmailAddress, orderByComparator);

        if (shoppingOrder != null) {
            return shoppingOrder;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(", shippingEmailAddress=");
        msg.append(shippingEmailAddress);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchShoppingOrderException(msg.toString());
    }

    /**
     * Returns the last shopping order in the ordered set where companyId = &#63; and shippingEmailAddress = &#63;.
     *
     * @param companyId the company ID
     * @param shippingEmailAddress the shipping email address
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching shopping order, or <code>null</code> if a matching shopping order could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingOrder fetchBycompanyIdAndEmail_Last(long companyId,
        String shippingEmailAddress, OrderByComparator orderByComparator)
        throws SystemException {
        int count = countBycompanyIdAndEmail(companyId, shippingEmailAddress);

        if (count == 0) {
            return null;
        }

        List<ShoppingOrder> list = findBycompanyIdAndEmail(companyId,
                shippingEmailAddress, count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the shopping orders before and after the current shopping order in the ordered set where companyId = &#63; and shippingEmailAddress = &#63;.
     *
     * @param shoppingOrderId the primary key of the current shopping order
     * @param companyId the company ID
     * @param shippingEmailAddress the shipping email address
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next shopping order
     * @throws com.fsquare.shopping.NoSuchShoppingOrderException if a shopping order with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingOrder[] findBycompanyIdAndEmail_PrevAndNext(
        long shoppingOrderId, long companyId, String shippingEmailAddress,
        OrderByComparator orderByComparator)
        throws NoSuchShoppingOrderException, SystemException {
        ShoppingOrder shoppingOrder = findByPrimaryKey(shoppingOrderId);

        Session session = null;

        try {
            session = openSession();

            ShoppingOrder[] array = new ShoppingOrderImpl[3];

            array[0] = getBycompanyIdAndEmail_PrevAndNext(session,
                    shoppingOrder, companyId, shippingEmailAddress,
                    orderByComparator, true);

            array[1] = shoppingOrder;

            array[2] = getBycompanyIdAndEmail_PrevAndNext(session,
                    shoppingOrder, companyId, shippingEmailAddress,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected ShoppingOrder getBycompanyIdAndEmail_PrevAndNext(
        Session session, ShoppingOrder shoppingOrder, long companyId,
        String shippingEmailAddress, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_SHOPPINGORDER_WHERE);

        query.append(_FINDER_COLUMN_COMPANYIDANDEMAIL_COMPANYID_2);

        boolean bindShippingEmailAddress = false;

        if (shippingEmailAddress == null) {
            query.append(_FINDER_COLUMN_COMPANYIDANDEMAIL_SHIPPINGEMAILADDRESS_1);
        } else if (shippingEmailAddress.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_COMPANYIDANDEMAIL_SHIPPINGEMAILADDRESS_3);
        } else {
            bindShippingEmailAddress = true;

            query.append(_FINDER_COLUMN_COMPANYIDANDEMAIL_SHIPPINGEMAILADDRESS_2);
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
            query.append(ShoppingOrderModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(companyId);

        if (bindShippingEmailAddress) {
            qPos.add(shippingEmailAddress);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(shoppingOrder);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<ShoppingOrder> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the shopping orders where companyId = &#63; and shippingEmailAddress = &#63; from the database.
     *
     * @param companyId the company ID
     * @param shippingEmailAddress the shipping email address
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeBycompanyIdAndEmail(long companyId,
        String shippingEmailAddress) throws SystemException {
        for (ShoppingOrder shoppingOrder : findBycompanyIdAndEmail(companyId,
                shippingEmailAddress, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(shoppingOrder);
        }
    }

    /**
     * Returns the number of shopping orders where companyId = &#63; and shippingEmailAddress = &#63;.
     *
     * @param companyId the company ID
     * @param shippingEmailAddress the shipping email address
     * @return the number of matching shopping orders
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countBycompanyIdAndEmail(long companyId,
        String shippingEmailAddress) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_COMPANYIDANDEMAIL;

        Object[] finderArgs = new Object[] { companyId, shippingEmailAddress };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_SHOPPINGORDER_WHERE);

            query.append(_FINDER_COLUMN_COMPANYIDANDEMAIL_COMPANYID_2);

            boolean bindShippingEmailAddress = false;

            if (shippingEmailAddress == null) {
                query.append(_FINDER_COLUMN_COMPANYIDANDEMAIL_SHIPPINGEMAILADDRESS_1);
            } else if (shippingEmailAddress.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_COMPANYIDANDEMAIL_SHIPPINGEMAILADDRESS_3);
            } else {
                bindShippingEmailAddress = true;

                query.append(_FINDER_COLUMN_COMPANYIDANDEMAIL_SHIPPINGEMAILADDRESS_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyId);

                if (bindShippingEmailAddress) {
                    qPos.add(shippingEmailAddress);
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
     * Returns all the shopping orders where shippingMethodId = &#63;.
     *
     * @param shippingMethodId the shipping method ID
     * @return the matching shopping orders
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ShoppingOrder> findByShippingMethodId(long shippingMethodId)
        throws SystemException {
        return findByShippingMethodId(shippingMethodId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the shopping orders where shippingMethodId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param shippingMethodId the shipping method ID
     * @param start the lower bound of the range of shopping orders
     * @param end the upper bound of the range of shopping orders (not inclusive)
     * @return the range of matching shopping orders
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ShoppingOrder> findByShippingMethodId(long shippingMethodId,
        int start, int end) throws SystemException {
        return findByShippingMethodId(shippingMethodId, start, end, null);
    }

    /**
     * Returns an ordered range of all the shopping orders where shippingMethodId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param shippingMethodId the shipping method ID
     * @param start the lower bound of the range of shopping orders
     * @param end the upper bound of the range of shopping orders (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching shopping orders
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ShoppingOrder> findByShippingMethodId(long shippingMethodId,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SHIPPINGMETHODID;
            finderArgs = new Object[] { shippingMethodId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SHIPPINGMETHODID;
            finderArgs = new Object[] {
                    shippingMethodId,
                    
                    start, end, orderByComparator
                };
        }

        List<ShoppingOrder> list = (List<ShoppingOrder>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (ShoppingOrder shoppingOrder : list) {
                if ((shippingMethodId != shoppingOrder.getShippingMethodId())) {
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

            query.append(_SQL_SELECT_SHOPPINGORDER_WHERE);

            query.append(_FINDER_COLUMN_SHIPPINGMETHODID_SHIPPINGMETHODID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(ShoppingOrderModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(shippingMethodId);

                if (!pagination) {
                    list = (List<ShoppingOrder>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<ShoppingOrder>(list);
                } else {
                    list = (List<ShoppingOrder>) QueryUtil.list(q,
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
     * Returns the first shopping order in the ordered set where shippingMethodId = &#63;.
     *
     * @param shippingMethodId the shipping method ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching shopping order
     * @throws com.fsquare.shopping.NoSuchShoppingOrderException if a matching shopping order could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingOrder findByShippingMethodId_First(long shippingMethodId,
        OrderByComparator orderByComparator)
        throws NoSuchShoppingOrderException, SystemException {
        ShoppingOrder shoppingOrder = fetchByShippingMethodId_First(shippingMethodId,
                orderByComparator);

        if (shoppingOrder != null) {
            return shoppingOrder;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("shippingMethodId=");
        msg.append(shippingMethodId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchShoppingOrderException(msg.toString());
    }

    /**
     * Returns the first shopping order in the ordered set where shippingMethodId = &#63;.
     *
     * @param shippingMethodId the shipping method ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching shopping order, or <code>null</code> if a matching shopping order could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingOrder fetchByShippingMethodId_First(long shippingMethodId,
        OrderByComparator orderByComparator) throws SystemException {
        List<ShoppingOrder> list = findByShippingMethodId(shippingMethodId, 0,
                1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last shopping order in the ordered set where shippingMethodId = &#63;.
     *
     * @param shippingMethodId the shipping method ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching shopping order
     * @throws com.fsquare.shopping.NoSuchShoppingOrderException if a matching shopping order could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingOrder findByShippingMethodId_Last(long shippingMethodId,
        OrderByComparator orderByComparator)
        throws NoSuchShoppingOrderException, SystemException {
        ShoppingOrder shoppingOrder = fetchByShippingMethodId_Last(shippingMethodId,
                orderByComparator);

        if (shoppingOrder != null) {
            return shoppingOrder;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("shippingMethodId=");
        msg.append(shippingMethodId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchShoppingOrderException(msg.toString());
    }

    /**
     * Returns the last shopping order in the ordered set where shippingMethodId = &#63;.
     *
     * @param shippingMethodId the shipping method ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching shopping order, or <code>null</code> if a matching shopping order could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingOrder fetchByShippingMethodId_Last(long shippingMethodId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByShippingMethodId(shippingMethodId);

        if (count == 0) {
            return null;
        }

        List<ShoppingOrder> list = findByShippingMethodId(shippingMethodId,
                count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the shopping orders before and after the current shopping order in the ordered set where shippingMethodId = &#63;.
     *
     * @param shoppingOrderId the primary key of the current shopping order
     * @param shippingMethodId the shipping method ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next shopping order
     * @throws com.fsquare.shopping.NoSuchShoppingOrderException if a shopping order with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingOrder[] findByShippingMethodId_PrevAndNext(
        long shoppingOrderId, long shippingMethodId,
        OrderByComparator orderByComparator)
        throws NoSuchShoppingOrderException, SystemException {
        ShoppingOrder shoppingOrder = findByPrimaryKey(shoppingOrderId);

        Session session = null;

        try {
            session = openSession();

            ShoppingOrder[] array = new ShoppingOrderImpl[3];

            array[0] = getByShippingMethodId_PrevAndNext(session,
                    shoppingOrder, shippingMethodId, orderByComparator, true);

            array[1] = shoppingOrder;

            array[2] = getByShippingMethodId_PrevAndNext(session,
                    shoppingOrder, shippingMethodId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected ShoppingOrder getByShippingMethodId_PrevAndNext(Session session,
        ShoppingOrder shoppingOrder, long shippingMethodId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_SHOPPINGORDER_WHERE);

        query.append(_FINDER_COLUMN_SHIPPINGMETHODID_SHIPPINGMETHODID_2);

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
            query.append(ShoppingOrderModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(shippingMethodId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(shoppingOrder);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<ShoppingOrder> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the shopping orders where shippingMethodId = &#63; from the database.
     *
     * @param shippingMethodId the shipping method ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByShippingMethodId(long shippingMethodId)
        throws SystemException {
        for (ShoppingOrder shoppingOrder : findByShippingMethodId(
                shippingMethodId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(shoppingOrder);
        }
    }

    /**
     * Returns the number of shopping orders where shippingMethodId = &#63;.
     *
     * @param shippingMethodId the shipping method ID
     * @return the number of matching shopping orders
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByShippingMethodId(long shippingMethodId)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_SHIPPINGMETHODID;

        Object[] finderArgs = new Object[] { shippingMethodId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_SHOPPINGORDER_WHERE);

            query.append(_FINDER_COLUMN_SHIPPINGMETHODID_SHIPPINGMETHODID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(shippingMethodId);

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
     * Caches the shopping order in the entity cache if it is enabled.
     *
     * @param shoppingOrder the shopping order
     */
    @Override
    public void cacheResult(ShoppingOrder shoppingOrder) {
        EntityCacheUtil.putResult(ShoppingOrderModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingOrderImpl.class, shoppingOrder.getPrimaryKey(),
            shoppingOrder);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NUMBER,
            new Object[] { shoppingOrder.getNumber() }, shoppingOrder);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EXTERNALPAYMENTID,
            new Object[] { shoppingOrder.getExternalPaymentId() }, shoppingOrder);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STATUS,
            new Object[] { shoppingOrder.getStatus() }, shoppingOrder);

        shoppingOrder.resetOriginalValues();
    }

    /**
     * Caches the shopping orders in the entity cache if it is enabled.
     *
     * @param shoppingOrders the shopping orders
     */
    @Override
    public void cacheResult(List<ShoppingOrder> shoppingOrders) {
        for (ShoppingOrder shoppingOrder : shoppingOrders) {
            if (EntityCacheUtil.getResult(
                        ShoppingOrderModelImpl.ENTITY_CACHE_ENABLED,
                        ShoppingOrderImpl.class, shoppingOrder.getPrimaryKey()) == null) {
                cacheResult(shoppingOrder);
            } else {
                shoppingOrder.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all shopping orders.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(ShoppingOrderImpl.class.getName());
        }

        EntityCacheUtil.clearCache(ShoppingOrderImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the shopping order.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(ShoppingOrder shoppingOrder) {
        EntityCacheUtil.removeResult(ShoppingOrderModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingOrderImpl.class, shoppingOrder.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(shoppingOrder);
    }

    @Override
    public void clearCache(List<ShoppingOrder> shoppingOrders) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (ShoppingOrder shoppingOrder : shoppingOrders) {
            EntityCacheUtil.removeResult(ShoppingOrderModelImpl.ENTITY_CACHE_ENABLED,
                ShoppingOrderImpl.class, shoppingOrder.getPrimaryKey());

            clearUniqueFindersCache(shoppingOrder);
        }
    }

    protected void cacheUniqueFindersCache(ShoppingOrder shoppingOrder) {
        if (shoppingOrder.isNew()) {
            Object[] args = new Object[] { shoppingOrder.getNumber() };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NUMBER, args,
                Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NUMBER, args,
                shoppingOrder);

            args = new Object[] { shoppingOrder.getExternalPaymentId() };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_EXTERNALPAYMENTID,
                args, Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EXTERNALPAYMENTID,
                args, shoppingOrder);

            args = new Object[] { shoppingOrder.getStatus() };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_STATUS, args,
                Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STATUS, args,
                shoppingOrder);
        } else {
            ShoppingOrderModelImpl shoppingOrderModelImpl = (ShoppingOrderModelImpl) shoppingOrder;

            if ((shoppingOrderModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_NUMBER.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { shoppingOrder.getNumber() };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NUMBER, args,
                    Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NUMBER, args,
                    shoppingOrder);
            }

            if ((shoppingOrderModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_EXTERNALPAYMENTID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        shoppingOrder.getExternalPaymentId()
                    };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_EXTERNALPAYMENTID,
                    args, Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EXTERNALPAYMENTID,
                    args, shoppingOrder);
            }

            if ((shoppingOrderModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_STATUS.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { shoppingOrder.getStatus() };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_STATUS, args,
                    Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STATUS, args,
                    shoppingOrder);
            }
        }
    }

    protected void clearUniqueFindersCache(ShoppingOrder shoppingOrder) {
        ShoppingOrderModelImpl shoppingOrderModelImpl = (ShoppingOrderModelImpl) shoppingOrder;

        Object[] args = new Object[] { shoppingOrder.getNumber() };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NUMBER, args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NUMBER, args);

        if ((shoppingOrderModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_NUMBER.getColumnBitmask()) != 0) {
            args = new Object[] { shoppingOrderModelImpl.getOriginalNumber() };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NUMBER, args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NUMBER, args);
        }

        args = new Object[] { shoppingOrder.getExternalPaymentId() };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EXTERNALPAYMENTID,
            args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EXTERNALPAYMENTID,
            args);

        if ((shoppingOrderModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_EXTERNALPAYMENTID.getColumnBitmask()) != 0) {
            args = new Object[] {
                    shoppingOrderModelImpl.getOriginalExternalPaymentId()
                };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EXTERNALPAYMENTID,
                args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EXTERNALPAYMENTID,
                args);
        }

        args = new Object[] { shoppingOrder.getStatus() };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_STATUS, args);

        if ((shoppingOrderModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_STATUS.getColumnBitmask()) != 0) {
            args = new Object[] { shoppingOrderModelImpl.getOriginalStatus() };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_STATUS, args);
        }
    }

    /**
     * Creates a new shopping order with the primary key. Does not add the shopping order to the database.
     *
     * @param shoppingOrderId the primary key for the new shopping order
     * @return the new shopping order
     */
    @Override
    public ShoppingOrder create(long shoppingOrderId) {
        ShoppingOrder shoppingOrder = new ShoppingOrderImpl();

        shoppingOrder.setNew(true);
        shoppingOrder.setPrimaryKey(shoppingOrderId);

        return shoppingOrder;
    }

    /**
     * Removes the shopping order with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param shoppingOrderId the primary key of the shopping order
     * @return the shopping order that was removed
     * @throws com.fsquare.shopping.NoSuchShoppingOrderException if a shopping order with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingOrder remove(long shoppingOrderId)
        throws NoSuchShoppingOrderException, SystemException {
        return remove((Serializable) shoppingOrderId);
    }

    /**
     * Removes the shopping order with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the shopping order
     * @return the shopping order that was removed
     * @throws com.fsquare.shopping.NoSuchShoppingOrderException if a shopping order with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingOrder remove(Serializable primaryKey)
        throws NoSuchShoppingOrderException, SystemException {
        Session session = null;

        try {
            session = openSession();

            ShoppingOrder shoppingOrder = (ShoppingOrder) session.get(ShoppingOrderImpl.class,
                    primaryKey);

            if (shoppingOrder == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchShoppingOrderException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(shoppingOrder);
        } catch (NoSuchShoppingOrderException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected ShoppingOrder removeImpl(ShoppingOrder shoppingOrder)
        throws SystemException {
        shoppingOrder = toUnwrappedModel(shoppingOrder);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(shoppingOrder)) {
                shoppingOrder = (ShoppingOrder) session.get(ShoppingOrderImpl.class,
                        shoppingOrder.getPrimaryKeyObj());
            }

            if (shoppingOrder != null) {
                session.delete(shoppingOrder);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (shoppingOrder != null) {
            clearCache(shoppingOrder);
        }

        return shoppingOrder;
    }

    @Override
    public ShoppingOrder updateImpl(
        com.fsquare.shopping.model.ShoppingOrder shoppingOrder)
        throws SystemException {
        shoppingOrder = toUnwrappedModel(shoppingOrder);

        boolean isNew = shoppingOrder.isNew();

        ShoppingOrderModelImpl shoppingOrderModelImpl = (ShoppingOrderModelImpl) shoppingOrder;

        Session session = null;

        try {
            session = openSession();

            if (shoppingOrder.isNew()) {
                session.save(shoppingOrder);

                shoppingOrder.setNew(false);
            } else {
                session.merge(shoppingOrder);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !ShoppingOrderModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((shoppingOrderModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        shoppingOrderModelImpl.getOriginalCompanyId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
                    args);

                args = new Object[] { shoppingOrderModelImpl.getCompanyId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
                    args);
            }

            if ((shoppingOrderModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PAYMENTTYPE.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        shoppingOrderModelImpl.getOriginalPaymentType()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PAYMENTTYPE,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PAYMENTTYPE,
                    args);

                args = new Object[] { shoppingOrderModelImpl.getPaymentType() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PAYMENTTYPE,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PAYMENTTYPE,
                    args);
            }

            if ((shoppingOrderModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYIDANDUSERID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        shoppingOrderModelImpl.getOriginalCompanyId(),
                        shoppingOrderModelImpl.getOriginalUserId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYIDANDUSERID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYIDANDUSERID,
                    args);

                args = new Object[] {
                        shoppingOrderModelImpl.getCompanyId(),
                        shoppingOrderModelImpl.getUserId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYIDANDUSERID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYIDANDUSERID,
                    args);
            }

            if ((shoppingOrderModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYIDANDEMAIL.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        shoppingOrderModelImpl.getOriginalCompanyId(),
                        shoppingOrderModelImpl.getOriginalShippingEmailAddress()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYIDANDEMAIL,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYIDANDEMAIL,
                    args);

                args = new Object[] {
                        shoppingOrderModelImpl.getCompanyId(),
                        shoppingOrderModelImpl.getShippingEmailAddress()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYIDANDEMAIL,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYIDANDEMAIL,
                    args);
            }

            if ((shoppingOrderModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SHIPPINGMETHODID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        shoppingOrderModelImpl.getOriginalShippingMethodId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SHIPPINGMETHODID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SHIPPINGMETHODID,
                    args);

                args = new Object[] { shoppingOrderModelImpl.getShippingMethodId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SHIPPINGMETHODID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SHIPPINGMETHODID,
                    args);
            }
        }

        EntityCacheUtil.putResult(ShoppingOrderModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingOrderImpl.class, shoppingOrder.getPrimaryKey(),
            shoppingOrder);

        clearUniqueFindersCache(shoppingOrder);
        cacheUniqueFindersCache(shoppingOrder);

        return shoppingOrder;
    }

    protected ShoppingOrder toUnwrappedModel(ShoppingOrder shoppingOrder) {
        if (shoppingOrder instanceof ShoppingOrderImpl) {
            return shoppingOrder;
        }

        ShoppingOrderImpl shoppingOrderImpl = new ShoppingOrderImpl();

        shoppingOrderImpl.setNew(shoppingOrder.isNew());
        shoppingOrderImpl.setPrimaryKey(shoppingOrder.getPrimaryKey());

        shoppingOrderImpl.setShoppingOrderId(shoppingOrder.getShoppingOrderId());
        shoppingOrderImpl.setCompanyId(shoppingOrder.getCompanyId());
        shoppingOrderImpl.setUserId(shoppingOrder.getUserId());
        shoppingOrderImpl.setUserName(shoppingOrder.getUserName());
        shoppingOrderImpl.setCreateDate(shoppingOrder.getCreateDate());
        shoppingOrderImpl.setModifiedDate(shoppingOrder.getModifiedDate());
        shoppingOrderImpl.setStatus(shoppingOrder.getStatus());
        shoppingOrderImpl.setNumber(shoppingOrder.getNumber());
        shoppingOrderImpl.setTax(shoppingOrder.getTax());
        shoppingOrderImpl.setShipping(shoppingOrder.getShipping());
        shoppingOrderImpl.setTotalPrice(shoppingOrder.getTotalPrice());
        shoppingOrderImpl.setAltShipping(shoppingOrder.getAltShipping());
        shoppingOrderImpl.setRequiresShipping(shoppingOrder.isRequiresShipping());
        shoppingOrderImpl.setInsure(shoppingOrder.isInsure());
        shoppingOrderImpl.setInsurance(shoppingOrder.getInsurance());
        shoppingOrderImpl.setCouponCodes(shoppingOrder.getCouponCodes());
        shoppingOrderImpl.setCouponDiscount(shoppingOrder.getCouponDiscount());
        shoppingOrderImpl.setPaymentStatus(shoppingOrder.getPaymentStatus());
        shoppingOrderImpl.setBillingFirstName(shoppingOrder.getBillingFirstName());
        shoppingOrderImpl.setBillingLastName(shoppingOrder.getBillingLastName());
        shoppingOrderImpl.setBillingEmailAddress(shoppingOrder.getBillingEmailAddress());
        shoppingOrderImpl.setBillingCompany(shoppingOrder.getBillingCompany());
        shoppingOrderImpl.setBillingStreet(shoppingOrder.getBillingStreet());
        shoppingOrderImpl.setBillingCity(shoppingOrder.getBillingCity());
        shoppingOrderImpl.setBillingState(shoppingOrder.getBillingState());
        shoppingOrderImpl.setBillingZip(shoppingOrder.getBillingZip());
        shoppingOrderImpl.setBillingCountry(shoppingOrder.getBillingCountry());
        shoppingOrderImpl.setBillingPhone(shoppingOrder.getBillingPhone());
        shoppingOrderImpl.setShipToBilling(shoppingOrder.isShipToBilling());
        shoppingOrderImpl.setShippingFirstName(shoppingOrder.getShippingFirstName());
        shoppingOrderImpl.setShippingLastName(shoppingOrder.getShippingLastName());
        shoppingOrderImpl.setShippingEmailAddress(shoppingOrder.getShippingEmailAddress());
        shoppingOrderImpl.setShippingCompany(shoppingOrder.getShippingCompany());
        shoppingOrderImpl.setShippingStreet(shoppingOrder.getShippingStreet());
        shoppingOrderImpl.setShippingStreet2(shoppingOrder.getShippingStreet2());
        shoppingOrderImpl.setShippingCity(shoppingOrder.getShippingCity());
        shoppingOrderImpl.setShippingState(shoppingOrder.getShippingState());
        shoppingOrderImpl.setShippingPostCode(shoppingOrder.getShippingPostCode());
        shoppingOrderImpl.setShippingCountry(shoppingOrder.getShippingCountry());
        shoppingOrderImpl.setShippingPhone(shoppingOrder.getShippingPhone());
        shoppingOrderImpl.setComments(shoppingOrder.getComments());
        shoppingOrderImpl.setExternalPaymentId(shoppingOrder.getExternalPaymentId());
        shoppingOrderImpl.setPaymentType(shoppingOrder.getPaymentType());
        shoppingOrderImpl.setSendOrderEmail(shoppingOrder.isSendOrderEmail());
        shoppingOrderImpl.setSendShippingEmail(shoppingOrder.isSendShippingEmail());
        shoppingOrderImpl.setShippingMethodId(shoppingOrder.getShippingMethodId());
        shoppingOrderImpl.setInternational(shoppingOrder.isInternational());

        return shoppingOrderImpl;
    }

    /**
     * Returns the shopping order with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the shopping order
     * @return the shopping order
     * @throws com.fsquare.shopping.NoSuchShoppingOrderException if a shopping order with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingOrder findByPrimaryKey(Serializable primaryKey)
        throws NoSuchShoppingOrderException, SystemException {
        ShoppingOrder shoppingOrder = fetchByPrimaryKey(primaryKey);

        if (shoppingOrder == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchShoppingOrderException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return shoppingOrder;
    }

    /**
     * Returns the shopping order with the primary key or throws a {@link com.fsquare.shopping.NoSuchShoppingOrderException} if it could not be found.
     *
     * @param shoppingOrderId the primary key of the shopping order
     * @return the shopping order
     * @throws com.fsquare.shopping.NoSuchShoppingOrderException if a shopping order with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingOrder findByPrimaryKey(long shoppingOrderId)
        throws NoSuchShoppingOrderException, SystemException {
        return findByPrimaryKey((Serializable) shoppingOrderId);
    }

    /**
     * Returns the shopping order with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the shopping order
     * @return the shopping order, or <code>null</code> if a shopping order with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingOrder fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        ShoppingOrder shoppingOrder = (ShoppingOrder) EntityCacheUtil.getResult(ShoppingOrderModelImpl.ENTITY_CACHE_ENABLED,
                ShoppingOrderImpl.class, primaryKey);

        if (shoppingOrder == _nullShoppingOrder) {
            return null;
        }

        if (shoppingOrder == null) {
            Session session = null;

            try {
                session = openSession();

                shoppingOrder = (ShoppingOrder) session.get(ShoppingOrderImpl.class,
                        primaryKey);

                if (shoppingOrder != null) {
                    cacheResult(shoppingOrder);
                } else {
                    EntityCacheUtil.putResult(ShoppingOrderModelImpl.ENTITY_CACHE_ENABLED,
                        ShoppingOrderImpl.class, primaryKey, _nullShoppingOrder);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(ShoppingOrderModelImpl.ENTITY_CACHE_ENABLED,
                    ShoppingOrderImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return shoppingOrder;
    }

    /**
     * Returns the shopping order with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param shoppingOrderId the primary key of the shopping order
     * @return the shopping order, or <code>null</code> if a shopping order with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingOrder fetchByPrimaryKey(long shoppingOrderId)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) shoppingOrderId);
    }

    /**
     * Returns all the shopping orders.
     *
     * @return the shopping orders
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ShoppingOrder> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the shopping orders.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of shopping orders
     * @param end the upper bound of the range of shopping orders (not inclusive)
     * @return the range of shopping orders
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ShoppingOrder> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the shopping orders.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of shopping orders
     * @param end the upper bound of the range of shopping orders (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of shopping orders
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ShoppingOrder> findAll(int start, int end,
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

        List<ShoppingOrder> list = (List<ShoppingOrder>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_SHOPPINGORDER);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_SHOPPINGORDER;

                if (pagination) {
                    sql = sql.concat(ShoppingOrderModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<ShoppingOrder>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<ShoppingOrder>(list);
                } else {
                    list = (List<ShoppingOrder>) QueryUtil.list(q,
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
     * Removes all the shopping orders from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (ShoppingOrder shoppingOrder : findAll()) {
            remove(shoppingOrder);
        }
    }

    /**
     * Returns the number of shopping orders.
     *
     * @return the number of shopping orders
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

                Query q = session.createQuery(_SQL_COUNT_SHOPPINGORDER);

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
     * Initializes the shopping order persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.fsquare.shopping.model.ShoppingOrder")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<ShoppingOrder>> listenersList = new ArrayList<ModelListener<ShoppingOrder>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<ShoppingOrder>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(ShoppingOrderImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
