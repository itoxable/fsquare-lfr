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
    public static final FinderPath FINDER_PATH_FETCH_BY_DEFAULTSHIPPING = new FinderPath(ShoppingShippingMethodModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingShippingMethodModelImpl.FINDER_CACHE_ENABLED,
            ShoppingShippingMethodImpl.class, FINDER_CLASS_NAME_ENTITY,
            "fetchBydefaultShipping", new String[] { Boolean.class.getName() },
            ShoppingShippingMethodModelImpl.DEFAULTSHIPPING_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_DEFAULTSHIPPING = new FinderPath(ShoppingShippingMethodModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingShippingMethodModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countBydefaultShipping", new String[] { Boolean.class.getName() });
    private static final String _FINDER_COLUMN_DEFAULTSHIPPING_DEFAULTSHIPPING_2 =
        "shoppingShippingMethod.defaultShipping = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID =
        new FinderPath(ShoppingShippingMethodModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingShippingMethodModelImpl.FINDER_CACHE_ENABLED,
            ShoppingShippingMethodImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompanyId",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID =
        new FinderPath(ShoppingShippingMethodModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingShippingMethodModelImpl.FINDER_CACHE_ENABLED,
            ShoppingShippingMethodImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyId",
            new String[] { Long.class.getName() },
            ShoppingShippingMethodModelImpl.COMPANYID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYID = new FinderPath(ShoppingShippingMethodModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingShippingMethodModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyId",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_COMPANYID_COMPANYID_2 = "shoppingShippingMethod.companyId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYIDANDENABLED =
        new FinderPath(ShoppingShippingMethodModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingShippingMethodModelImpl.FINDER_CACHE_ENABLED,
            ShoppingShippingMethodImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findByCompanyIdAndEnabled",
            new String[] {
                Long.class.getName(), Boolean.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYIDANDENABLED =
        new FinderPath(ShoppingShippingMethodModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingShippingMethodModelImpl.FINDER_CACHE_ENABLED,
            ShoppingShippingMethodImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findByCompanyIdAndEnabled",
            new String[] { Long.class.getName(), Boolean.class.getName() },
            ShoppingShippingMethodModelImpl.COMPANYID_COLUMN_BITMASK |
            ShoppingShippingMethodModelImpl.DISABLED_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYIDANDENABLED = new FinderPath(ShoppingShippingMethodModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingShippingMethodModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByCompanyIdAndEnabled",
            new String[] { Long.class.getName(), Boolean.class.getName() });
    private static final String _FINDER_COLUMN_COMPANYIDANDENABLED_COMPANYID_2 = "shoppingShippingMethod.companyId = ? AND ";
    private static final String _FINDER_COLUMN_COMPANYIDANDENABLED_DISABLED_2 = "shoppingShippingMethod.disabled = ?";
    private static final String _SQL_SELECT_SHOPPINGSHIPPINGMETHOD = "SELECT shoppingShippingMethod FROM ShoppingShippingMethod shoppingShippingMethod";
    private static final String _SQL_SELECT_SHOPPINGSHIPPINGMETHOD_WHERE = "SELECT shoppingShippingMethod FROM ShoppingShippingMethod shoppingShippingMethod WHERE ";
    private static final String _SQL_COUNT_SHOPPINGSHIPPINGMETHOD = "SELECT COUNT(shoppingShippingMethod) FROM ShoppingShippingMethod shoppingShippingMethod";
    private static final String _SQL_COUNT_SHOPPINGSHIPPINGMETHOD_WHERE = "SELECT COUNT(shoppingShippingMethod) FROM ShoppingShippingMethod shoppingShippingMethod WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "shoppingShippingMethod.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ShoppingShippingMethod exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ShoppingShippingMethod exists with the key {";
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
     * Returns the shopping shipping method where defaultShipping = &#63; or throws a {@link com.fsquare.shopping.NoSuchShoppingShippingMethodException} if it could not be found.
     *
     * @param defaultShipping the default shipping
     * @return the matching shopping shipping method
     * @throws com.fsquare.shopping.NoSuchShoppingShippingMethodException if a matching shopping shipping method could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingShippingMethod findBydefaultShipping(boolean defaultShipping)
        throws NoSuchShoppingShippingMethodException, SystemException {
        ShoppingShippingMethod shoppingShippingMethod = fetchBydefaultShipping(defaultShipping);

        if (shoppingShippingMethod == null) {
            StringBundler msg = new StringBundler(4);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("defaultShipping=");
            msg.append(defaultShipping);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchShoppingShippingMethodException(msg.toString());
        }

        return shoppingShippingMethod;
    }

    /**
     * Returns the shopping shipping method where defaultShipping = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param defaultShipping the default shipping
     * @return the matching shopping shipping method, or <code>null</code> if a matching shopping shipping method could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingShippingMethod fetchBydefaultShipping(
        boolean defaultShipping) throws SystemException {
        return fetchBydefaultShipping(defaultShipping, true);
    }

    /**
     * Returns the shopping shipping method where defaultShipping = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param defaultShipping the default shipping
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching shopping shipping method, or <code>null</code> if a matching shopping shipping method could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingShippingMethod fetchBydefaultShipping(
        boolean defaultShipping, boolean retrieveFromCache)
        throws SystemException {
        Object[] finderArgs = new Object[] { defaultShipping };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_DEFAULTSHIPPING,
                    finderArgs, this);
        }

        if (result instanceof ShoppingShippingMethod) {
            ShoppingShippingMethod shoppingShippingMethod = (ShoppingShippingMethod) result;

            if ((defaultShipping != shoppingShippingMethod.getDefaultShipping())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_SELECT_SHOPPINGSHIPPINGMETHOD_WHERE);

            query.append(_FINDER_COLUMN_DEFAULTSHIPPING_DEFAULTSHIPPING_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(defaultShipping);

                List<ShoppingShippingMethod> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_DEFAULTSHIPPING,
                        finderArgs, list);
                } else {
                    if ((list.size() > 1) && _log.isWarnEnabled()) {
                        _log.warn(
                            "ShoppingShippingMethodPersistenceImpl.fetchBydefaultShipping(boolean, boolean) with parameters (" +
                            StringUtil.merge(finderArgs) +
                            ") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
                    }

                    ShoppingShippingMethod shoppingShippingMethod = list.get(0);

                    result = shoppingShippingMethod;

                    cacheResult(shoppingShippingMethod);

                    if ((shoppingShippingMethod.getDefaultShipping() != defaultShipping)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_DEFAULTSHIPPING,
                            finderArgs, shoppingShippingMethod);
                    }
                }
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_DEFAULTSHIPPING,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        if (result instanceof List<?>) {
            return null;
        } else {
            return (ShoppingShippingMethod) result;
        }
    }

    /**
     * Removes the shopping shipping method where defaultShipping = &#63; from the database.
     *
     * @param defaultShipping the default shipping
     * @return the shopping shipping method that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingShippingMethod removeBydefaultShipping(
        boolean defaultShipping)
        throws NoSuchShoppingShippingMethodException, SystemException {
        ShoppingShippingMethod shoppingShippingMethod = findBydefaultShipping(defaultShipping);

        return remove(shoppingShippingMethod);
    }

    /**
     * Returns the number of shopping shipping methods where defaultShipping = &#63;.
     *
     * @param defaultShipping the default shipping
     * @return the number of matching shopping shipping methods
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countBydefaultShipping(boolean defaultShipping)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_DEFAULTSHIPPING;

        Object[] finderArgs = new Object[] { defaultShipping };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_SHOPPINGSHIPPINGMETHOD_WHERE);

            query.append(_FINDER_COLUMN_DEFAULTSHIPPING_DEFAULTSHIPPING_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(defaultShipping);

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
     * Returns all the shopping shipping methods where companyId = &#63;.
     *
     * @param companyId the company ID
     * @return the matching shopping shipping methods
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ShoppingShippingMethod> findByCompanyId(long companyId)
        throws SystemException {
        return findByCompanyId(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
    }

    /**
     * Returns a range of all the shopping shipping methods where companyId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingShippingMethodModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param companyId the company ID
     * @param start the lower bound of the range of shopping shipping methods
     * @param end the upper bound of the range of shopping shipping methods (not inclusive)
     * @return the range of matching shopping shipping methods
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ShoppingShippingMethod> findByCompanyId(long companyId,
        int start, int end) throws SystemException {
        return findByCompanyId(companyId, start, end, null);
    }

    /**
     * Returns an ordered range of all the shopping shipping methods where companyId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingShippingMethodModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param companyId the company ID
     * @param start the lower bound of the range of shopping shipping methods
     * @param end the upper bound of the range of shopping shipping methods (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching shopping shipping methods
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ShoppingShippingMethod> findByCompanyId(long companyId,
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

        List<ShoppingShippingMethod> list = (List<ShoppingShippingMethod>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (ShoppingShippingMethod shoppingShippingMethod : list) {
                if ((companyId != shoppingShippingMethod.getCompanyId())) {
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

            query.append(_SQL_SELECT_SHOPPINGSHIPPINGMETHOD_WHERE);

            query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(ShoppingShippingMethodModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyId);

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
     * Returns the first shopping shipping method in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching shopping shipping method
     * @throws com.fsquare.shopping.NoSuchShoppingShippingMethodException if a matching shopping shipping method could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingShippingMethod findByCompanyId_First(long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchShoppingShippingMethodException, SystemException {
        ShoppingShippingMethod shoppingShippingMethod = fetchByCompanyId_First(companyId,
                orderByComparator);

        if (shoppingShippingMethod != null) {
            return shoppingShippingMethod;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchShoppingShippingMethodException(msg.toString());
    }

    /**
     * Returns the first shopping shipping method in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching shopping shipping method, or <code>null</code> if a matching shopping shipping method could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingShippingMethod fetchByCompanyId_First(long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        List<ShoppingShippingMethod> list = findByCompanyId(companyId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last shopping shipping method in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching shopping shipping method
     * @throws com.fsquare.shopping.NoSuchShoppingShippingMethodException if a matching shopping shipping method could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingShippingMethod findByCompanyId_Last(long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchShoppingShippingMethodException, SystemException {
        ShoppingShippingMethod shoppingShippingMethod = fetchByCompanyId_Last(companyId,
                orderByComparator);

        if (shoppingShippingMethod != null) {
            return shoppingShippingMethod;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchShoppingShippingMethodException(msg.toString());
    }

    /**
     * Returns the last shopping shipping method in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching shopping shipping method, or <code>null</code> if a matching shopping shipping method could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingShippingMethod fetchByCompanyId_Last(long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByCompanyId(companyId);

        if (count == 0) {
            return null;
        }

        List<ShoppingShippingMethod> list = findByCompanyId(companyId,
                count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the shopping shipping methods before and after the current shopping shipping method in the ordered set where companyId = &#63;.
     *
     * @param shippingMethodId the primary key of the current shopping shipping method
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next shopping shipping method
     * @throws com.fsquare.shopping.NoSuchShoppingShippingMethodException if a shopping shipping method with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingShippingMethod[] findByCompanyId_PrevAndNext(
        long shippingMethodId, long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchShoppingShippingMethodException, SystemException {
        ShoppingShippingMethod shoppingShippingMethod = findByPrimaryKey(shippingMethodId);

        Session session = null;

        try {
            session = openSession();

            ShoppingShippingMethod[] array = new ShoppingShippingMethodImpl[3];

            array[0] = getByCompanyId_PrevAndNext(session,
                    shoppingShippingMethod, companyId, orderByComparator, true);

            array[1] = shoppingShippingMethod;

            array[2] = getByCompanyId_PrevAndNext(session,
                    shoppingShippingMethod, companyId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected ShoppingShippingMethod getByCompanyId_PrevAndNext(
        Session session, ShoppingShippingMethod shoppingShippingMethod,
        long companyId, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_SHOPPINGSHIPPINGMETHOD_WHERE);

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
            query.append(ShoppingShippingMethodModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(companyId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(shoppingShippingMethod);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<ShoppingShippingMethod> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the shopping shipping methods where companyId = &#63; from the database.
     *
     * @param companyId the company ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByCompanyId(long companyId) throws SystemException {
        for (ShoppingShippingMethod shoppingShippingMethod : findByCompanyId(
                companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(shoppingShippingMethod);
        }
    }

    /**
     * Returns the number of shopping shipping methods where companyId = &#63;.
     *
     * @param companyId the company ID
     * @return the number of matching shopping shipping methods
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

            query.append(_SQL_COUNT_SHOPPINGSHIPPINGMETHOD_WHERE);

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
     * Returns all the shopping shipping methods where companyId = &#63; and disabled = &#63;.
     *
     * @param companyId the company ID
     * @param disabled the disabled
     * @return the matching shopping shipping methods
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ShoppingShippingMethod> findByCompanyIdAndEnabled(
        long companyId, boolean disabled) throws SystemException {
        return findByCompanyIdAndEnabled(companyId, disabled,
            QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the shopping shipping methods where companyId = &#63; and disabled = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingShippingMethodModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param companyId the company ID
     * @param disabled the disabled
     * @param start the lower bound of the range of shopping shipping methods
     * @param end the upper bound of the range of shopping shipping methods (not inclusive)
     * @return the range of matching shopping shipping methods
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ShoppingShippingMethod> findByCompanyIdAndEnabled(
        long companyId, boolean disabled, int start, int end)
        throws SystemException {
        return findByCompanyIdAndEnabled(companyId, disabled, start, end, null);
    }

    /**
     * Returns an ordered range of all the shopping shipping methods where companyId = &#63; and disabled = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingShippingMethodModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param companyId the company ID
     * @param disabled the disabled
     * @param start the lower bound of the range of shopping shipping methods
     * @param end the upper bound of the range of shopping shipping methods (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching shopping shipping methods
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ShoppingShippingMethod> findByCompanyIdAndEnabled(
        long companyId, boolean disabled, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYIDANDENABLED;
            finderArgs = new Object[] { companyId, disabled };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYIDANDENABLED;
            finderArgs = new Object[] {
                    companyId, disabled,
                    
                    start, end, orderByComparator
                };
        }

        List<ShoppingShippingMethod> list = (List<ShoppingShippingMethod>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (ShoppingShippingMethod shoppingShippingMethod : list) {
                if ((companyId != shoppingShippingMethod.getCompanyId()) ||
                        (disabled != shoppingShippingMethod.getDisabled())) {
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

            query.append(_SQL_SELECT_SHOPPINGSHIPPINGMETHOD_WHERE);

            query.append(_FINDER_COLUMN_COMPANYIDANDENABLED_COMPANYID_2);

            query.append(_FINDER_COLUMN_COMPANYIDANDENABLED_DISABLED_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(ShoppingShippingMethodModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyId);

                qPos.add(disabled);

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
     * Returns the first shopping shipping method in the ordered set where companyId = &#63; and disabled = &#63;.
     *
     * @param companyId the company ID
     * @param disabled the disabled
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching shopping shipping method
     * @throws com.fsquare.shopping.NoSuchShoppingShippingMethodException if a matching shopping shipping method could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingShippingMethod findByCompanyIdAndEnabled_First(
        long companyId, boolean disabled, OrderByComparator orderByComparator)
        throws NoSuchShoppingShippingMethodException, SystemException {
        ShoppingShippingMethod shoppingShippingMethod = fetchByCompanyIdAndEnabled_First(companyId,
                disabled, orderByComparator);

        if (shoppingShippingMethod != null) {
            return shoppingShippingMethod;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(", disabled=");
        msg.append(disabled);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchShoppingShippingMethodException(msg.toString());
    }

    /**
     * Returns the first shopping shipping method in the ordered set where companyId = &#63; and disabled = &#63;.
     *
     * @param companyId the company ID
     * @param disabled the disabled
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching shopping shipping method, or <code>null</code> if a matching shopping shipping method could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingShippingMethod fetchByCompanyIdAndEnabled_First(
        long companyId, boolean disabled, OrderByComparator orderByComparator)
        throws SystemException {
        List<ShoppingShippingMethod> list = findByCompanyIdAndEnabled(companyId,
                disabled, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last shopping shipping method in the ordered set where companyId = &#63; and disabled = &#63;.
     *
     * @param companyId the company ID
     * @param disabled the disabled
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching shopping shipping method
     * @throws com.fsquare.shopping.NoSuchShoppingShippingMethodException if a matching shopping shipping method could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingShippingMethod findByCompanyIdAndEnabled_Last(
        long companyId, boolean disabled, OrderByComparator orderByComparator)
        throws NoSuchShoppingShippingMethodException, SystemException {
        ShoppingShippingMethod shoppingShippingMethod = fetchByCompanyIdAndEnabled_Last(companyId,
                disabled, orderByComparator);

        if (shoppingShippingMethod != null) {
            return shoppingShippingMethod;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(", disabled=");
        msg.append(disabled);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchShoppingShippingMethodException(msg.toString());
    }

    /**
     * Returns the last shopping shipping method in the ordered set where companyId = &#63; and disabled = &#63;.
     *
     * @param companyId the company ID
     * @param disabled the disabled
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching shopping shipping method, or <code>null</code> if a matching shopping shipping method could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingShippingMethod fetchByCompanyIdAndEnabled_Last(
        long companyId, boolean disabled, OrderByComparator orderByComparator)
        throws SystemException {
        int count = countByCompanyIdAndEnabled(companyId, disabled);

        if (count == 0) {
            return null;
        }

        List<ShoppingShippingMethod> list = findByCompanyIdAndEnabled(companyId,
                disabled, count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the shopping shipping methods before and after the current shopping shipping method in the ordered set where companyId = &#63; and disabled = &#63;.
     *
     * @param shippingMethodId the primary key of the current shopping shipping method
     * @param companyId the company ID
     * @param disabled the disabled
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next shopping shipping method
     * @throws com.fsquare.shopping.NoSuchShoppingShippingMethodException if a shopping shipping method with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingShippingMethod[] findByCompanyIdAndEnabled_PrevAndNext(
        long shippingMethodId, long companyId, boolean disabled,
        OrderByComparator orderByComparator)
        throws NoSuchShoppingShippingMethodException, SystemException {
        ShoppingShippingMethod shoppingShippingMethod = findByPrimaryKey(shippingMethodId);

        Session session = null;

        try {
            session = openSession();

            ShoppingShippingMethod[] array = new ShoppingShippingMethodImpl[3];

            array[0] = getByCompanyIdAndEnabled_PrevAndNext(session,
                    shoppingShippingMethod, companyId, disabled,
                    orderByComparator, true);

            array[1] = shoppingShippingMethod;

            array[2] = getByCompanyIdAndEnabled_PrevAndNext(session,
                    shoppingShippingMethod, companyId, disabled,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected ShoppingShippingMethod getByCompanyIdAndEnabled_PrevAndNext(
        Session session, ShoppingShippingMethod shoppingShippingMethod,
        long companyId, boolean disabled, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_SHOPPINGSHIPPINGMETHOD_WHERE);

        query.append(_FINDER_COLUMN_COMPANYIDANDENABLED_COMPANYID_2);

        query.append(_FINDER_COLUMN_COMPANYIDANDENABLED_DISABLED_2);

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
            query.append(ShoppingShippingMethodModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(companyId);

        qPos.add(disabled);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(shoppingShippingMethod);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<ShoppingShippingMethod> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the shopping shipping methods where companyId = &#63; and disabled = &#63; from the database.
     *
     * @param companyId the company ID
     * @param disabled the disabled
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByCompanyIdAndEnabled(long companyId, boolean disabled)
        throws SystemException {
        for (ShoppingShippingMethod shoppingShippingMethod : findByCompanyIdAndEnabled(
                companyId, disabled, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(shoppingShippingMethod);
        }
    }

    /**
     * Returns the number of shopping shipping methods where companyId = &#63; and disabled = &#63;.
     *
     * @param companyId the company ID
     * @param disabled the disabled
     * @return the number of matching shopping shipping methods
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByCompanyIdAndEnabled(long companyId, boolean disabled)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_COMPANYIDANDENABLED;

        Object[] finderArgs = new Object[] { companyId, disabled };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_SHOPPINGSHIPPINGMETHOD_WHERE);

            query.append(_FINDER_COLUMN_COMPANYIDANDENABLED_COMPANYID_2);

            query.append(_FINDER_COLUMN_COMPANYIDANDENABLED_DISABLED_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyId);

                qPos.add(disabled);

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
     * Caches the shopping shipping method in the entity cache if it is enabled.
     *
     * @param shoppingShippingMethod the shopping shipping method
     */
    @Override
    public void cacheResult(ShoppingShippingMethod shoppingShippingMethod) {
        EntityCacheUtil.putResult(ShoppingShippingMethodModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingShippingMethodImpl.class,
            shoppingShippingMethod.getPrimaryKey(), shoppingShippingMethod);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_DEFAULTSHIPPING,
            new Object[] { shoppingShippingMethod.getDefaultShipping() },
            shoppingShippingMethod);

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

        clearUniqueFindersCache(shoppingShippingMethod);
    }

    @Override
    public void clearCache(List<ShoppingShippingMethod> shoppingShippingMethods) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (ShoppingShippingMethod shoppingShippingMethod : shoppingShippingMethods) {
            EntityCacheUtil.removeResult(ShoppingShippingMethodModelImpl.ENTITY_CACHE_ENABLED,
                ShoppingShippingMethodImpl.class,
                shoppingShippingMethod.getPrimaryKey());

            clearUniqueFindersCache(shoppingShippingMethod);
        }
    }

    protected void cacheUniqueFindersCache(
        ShoppingShippingMethod shoppingShippingMethod) {
        if (shoppingShippingMethod.isNew()) {
            Object[] args = new Object[] {
                    shoppingShippingMethod.getDefaultShipping()
                };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_DEFAULTSHIPPING,
                args, Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_DEFAULTSHIPPING,
                args, shoppingShippingMethod);
        } else {
            ShoppingShippingMethodModelImpl shoppingShippingMethodModelImpl = (ShoppingShippingMethodModelImpl) shoppingShippingMethod;

            if ((shoppingShippingMethodModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_DEFAULTSHIPPING.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        shoppingShippingMethod.getDefaultShipping()
                    };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_DEFAULTSHIPPING,
                    args, Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_DEFAULTSHIPPING,
                    args, shoppingShippingMethod);
            }
        }
    }

    protected void clearUniqueFindersCache(
        ShoppingShippingMethod shoppingShippingMethod) {
        ShoppingShippingMethodModelImpl shoppingShippingMethodModelImpl = (ShoppingShippingMethodModelImpl) shoppingShippingMethod;

        Object[] args = new Object[] { shoppingShippingMethod.getDefaultShipping() };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DEFAULTSHIPPING, args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_DEFAULTSHIPPING, args);

        if ((shoppingShippingMethodModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_DEFAULTSHIPPING.getColumnBitmask()) != 0) {
            args = new Object[] {
                    shoppingShippingMethodModelImpl.getOriginalDefaultShipping()
                };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DEFAULTSHIPPING,
                args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_DEFAULTSHIPPING,
                args);
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

        ShoppingShippingMethodModelImpl shoppingShippingMethodModelImpl = (ShoppingShippingMethodModelImpl) shoppingShippingMethod;

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

        if (isNew || !ShoppingShippingMethodModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((shoppingShippingMethodModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        shoppingShippingMethodModelImpl.getOriginalCompanyId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
                    args);

                args = new Object[] {
                        shoppingShippingMethodModelImpl.getCompanyId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
                    args);
            }

            if ((shoppingShippingMethodModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYIDANDENABLED.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        shoppingShippingMethodModelImpl.getOriginalCompanyId(),
                        shoppingShippingMethodModelImpl.getOriginalDisabled()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYIDANDENABLED,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYIDANDENABLED,
                    args);

                args = new Object[] {
                        shoppingShippingMethodModelImpl.getCompanyId(),
                        shoppingShippingMethodModelImpl.getDisabled()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYIDANDENABLED,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYIDANDENABLED,
                    args);
            }
        }

        EntityCacheUtil.putResult(ShoppingShippingMethodModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingShippingMethodImpl.class,
            shoppingShippingMethod.getPrimaryKey(), shoppingShippingMethod);

        clearUniqueFindersCache(shoppingShippingMethod);
        cacheUniqueFindersCache(shoppingShippingMethod);

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
        shoppingShippingMethodImpl.setCompanyId(shoppingShippingMethod.getCompanyId());
        shoppingShippingMethodImpl.setUserId(shoppingShippingMethod.getUserId());
        shoppingShippingMethodImpl.setUserName(shoppingShippingMethod.getUserName());
        shoppingShippingMethodImpl.setCreateDate(shoppingShippingMethod.getCreateDate());
        shoppingShippingMethodImpl.setModifiedDate(shoppingShippingMethod.getModifiedDate());
        shoppingShippingMethodImpl.setPrice(shoppingShippingMethod.getPrice());
        shoppingShippingMethodImpl.setName(shoppingShippingMethod.getName());
        shoppingShippingMethodImpl.setDescription(shoppingShippingMethod.getDescription());
        shoppingShippingMethodImpl.setFreeQuantity(shoppingShippingMethod.getFreeQuantity());
        shoppingShippingMethodImpl.setFreeTotal(shoppingShippingMethod.getFreeTotal());
        shoppingShippingMethodImpl.setWeight(shoppingShippingMethod.getWeight());
        shoppingShippingMethodImpl.setDefaultShipping(shoppingShippingMethod.isDefaultShipping());
        shoppingShippingMethodImpl.setInternational(shoppingShippingMethod.isInternational());
        shoppingShippingMethodImpl.setDisabled(shoppingShippingMethod.isDisabled());
        shoppingShippingMethodImpl.setShippingType(shoppingShippingMethod.getShippingType());

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
