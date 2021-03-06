package com.fsquare.shopping.service.persistence;

import com.fsquare.shopping.NoSuchShoppingItemImageException;
import com.fsquare.shopping.model.ShoppingItemImage;
import com.fsquare.shopping.model.impl.ShoppingItemImageImpl;
import com.fsquare.shopping.model.impl.ShoppingItemImageModelImpl;
import com.fsquare.shopping.service.persistence.ShoppingItemImagePersistence;

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
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the shopping item image service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingItemImagePersistence
 * @see ShoppingItemImageUtil
 * @generated
 */
public class ShoppingItemImagePersistenceImpl extends BasePersistenceImpl<ShoppingItemImage>
    implements ShoppingItemImagePersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link ShoppingItemImageUtil} to access the shopping item image persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = ShoppingItemImageImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ShoppingItemImageModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingItemImageModelImpl.FINDER_CACHE_ENABLED,
            ShoppingItemImageImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ShoppingItemImageModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingItemImageModelImpl.FINDER_CACHE_ENABLED,
            ShoppingItemImageImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ShoppingItemImageModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingItemImageModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID =
        new FinderPath(ShoppingItemImageModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingItemImageModelImpl.FINDER_CACHE_ENABLED,
            ShoppingItemImageImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompanyId",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID =
        new FinderPath(ShoppingItemImageModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingItemImageModelImpl.FINDER_CACHE_ENABLED,
            ShoppingItemImageImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyId",
            new String[] { Long.class.getName() },
            ShoppingItemImageModelImpl.COMPANYID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYID = new FinderPath(ShoppingItemImageModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingItemImageModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyId",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_COMPANYID_COMPANYID_2 = "shoppingItemImage.companyId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYIDANDITEMID =
        new FinderPath(ShoppingItemImageModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingItemImageModelImpl.FINDER_CACHE_ENABLED,
            ShoppingItemImageImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompanyIdAndItemId",
            new String[] {
                Long.class.getName(), Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYIDANDITEMID =
        new FinderPath(ShoppingItemImageModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingItemImageModelImpl.FINDER_CACHE_ENABLED,
            ShoppingItemImageImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findByCompanyIdAndItemId",
            new String[] { Long.class.getName(), Long.class.getName() },
            ShoppingItemImageModelImpl.COMPANYID_COLUMN_BITMASK |
            ShoppingItemImageModelImpl.ITEMID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYIDANDITEMID = new FinderPath(ShoppingItemImageModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingItemImageModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByCompanyIdAndItemId",
            new String[] { Long.class.getName(), Long.class.getName() });
    private static final String _FINDER_COLUMN_COMPANYIDANDITEMID_COMPANYID_2 = "shoppingItemImage.companyId = ? AND ";
    private static final String _FINDER_COLUMN_COMPANYIDANDITEMID_ITEMID_2 = "shoppingItemImage.itemId = ?";
    public static final FinderPath FINDER_PATH_FETCH_BY_COMPANYIDANDITEMANDMAIN = new FinderPath(ShoppingItemImageModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingItemImageModelImpl.FINDER_CACHE_ENABLED,
            ShoppingItemImageImpl.class, FINDER_CLASS_NAME_ENTITY,
            "fetchByCompanyIdAndItemAndMain",
            new String[] {
                Long.class.getName(), Long.class.getName(),
                Boolean.class.getName()
            },
            ShoppingItemImageModelImpl.COMPANYID_COLUMN_BITMASK |
            ShoppingItemImageModelImpl.ITEMID_COLUMN_BITMASK |
            ShoppingItemImageModelImpl.MAINIMAGE_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYIDANDITEMANDMAIN = new FinderPath(ShoppingItemImageModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingItemImageModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByCompanyIdAndItemAndMain",
            new String[] {
                Long.class.getName(), Long.class.getName(),
                Boolean.class.getName()
            });
    private static final String _FINDER_COLUMN_COMPANYIDANDITEMANDMAIN_COMPANYID_2 =
        "shoppingItemImage.companyId = ? AND ";
    private static final String _FINDER_COLUMN_COMPANYIDANDITEMANDMAIN_ITEMID_2 = "shoppingItemImage.itemId = ? AND ";
    private static final String _FINDER_COLUMN_COMPANYIDANDITEMANDMAIN_MAINIMAGE_2 =
        "shoppingItemImage.mainImage = ?";
    private static final String _SQL_SELECT_SHOPPINGITEMIMAGE = "SELECT shoppingItemImage FROM ShoppingItemImage shoppingItemImage";
    private static final String _SQL_SELECT_SHOPPINGITEMIMAGE_WHERE = "SELECT shoppingItemImage FROM ShoppingItemImage shoppingItemImage WHERE ";
    private static final String _SQL_COUNT_SHOPPINGITEMIMAGE = "SELECT COUNT(shoppingItemImage) FROM ShoppingItemImage shoppingItemImage";
    private static final String _SQL_COUNT_SHOPPINGITEMIMAGE_WHERE = "SELECT COUNT(shoppingItemImage) FROM ShoppingItemImage shoppingItemImage WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "shoppingItemImage.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ShoppingItemImage exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ShoppingItemImage exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(ShoppingItemImagePersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "order"
            });
    private static ShoppingItemImage _nullShoppingItemImage = new ShoppingItemImageImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<ShoppingItemImage> toCacheModel() {
                return _nullShoppingItemImageCacheModel;
            }
        };

    private static CacheModel<ShoppingItemImage> _nullShoppingItemImageCacheModel =
        new CacheModel<ShoppingItemImage>() {
            @Override
            public ShoppingItemImage toEntityModel() {
                return _nullShoppingItemImage;
            }
        };

    public ShoppingItemImagePersistenceImpl() {
        setModelClass(ShoppingItemImage.class);
    }

    /**
     * Returns all the shopping item images where companyId = &#63;.
     *
     * @param companyId the company ID
     * @return the matching shopping item images
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ShoppingItemImage> findByCompanyId(long companyId)
        throws SystemException {
        return findByCompanyId(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
    }

    /**
     * Returns a range of all the shopping item images where companyId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingItemImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param companyId the company ID
     * @param start the lower bound of the range of shopping item images
     * @param end the upper bound of the range of shopping item images (not inclusive)
     * @return the range of matching shopping item images
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ShoppingItemImage> findByCompanyId(long companyId, int start,
        int end) throws SystemException {
        return findByCompanyId(companyId, start, end, null);
    }

    /**
     * Returns an ordered range of all the shopping item images where companyId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingItemImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param companyId the company ID
     * @param start the lower bound of the range of shopping item images
     * @param end the upper bound of the range of shopping item images (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching shopping item images
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ShoppingItemImage> findByCompanyId(long companyId, int start,
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

        List<ShoppingItemImage> list = (List<ShoppingItemImage>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (ShoppingItemImage shoppingItemImage : list) {
                if ((companyId != shoppingItemImage.getCompanyId())) {
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

            query.append(_SQL_SELECT_SHOPPINGITEMIMAGE_WHERE);

            query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(ShoppingItemImageModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyId);

                if (!pagination) {
                    list = (List<ShoppingItemImage>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<ShoppingItemImage>(list);
                } else {
                    list = (List<ShoppingItemImage>) QueryUtil.list(q,
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
     * Returns the first shopping item image in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching shopping item image
     * @throws com.fsquare.shopping.NoSuchShoppingItemImageException if a matching shopping item image could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingItemImage findByCompanyId_First(long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchShoppingItemImageException, SystemException {
        ShoppingItemImage shoppingItemImage = fetchByCompanyId_First(companyId,
                orderByComparator);

        if (shoppingItemImage != null) {
            return shoppingItemImage;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchShoppingItemImageException(msg.toString());
    }

    /**
     * Returns the first shopping item image in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching shopping item image, or <code>null</code> if a matching shopping item image could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingItemImage fetchByCompanyId_First(long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        List<ShoppingItemImage> list = findByCompanyId(companyId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last shopping item image in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching shopping item image
     * @throws com.fsquare.shopping.NoSuchShoppingItemImageException if a matching shopping item image could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingItemImage findByCompanyId_Last(long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchShoppingItemImageException, SystemException {
        ShoppingItemImage shoppingItemImage = fetchByCompanyId_Last(companyId,
                orderByComparator);

        if (shoppingItemImage != null) {
            return shoppingItemImage;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchShoppingItemImageException(msg.toString());
    }

    /**
     * Returns the last shopping item image in the ordered set where companyId = &#63;.
     *
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching shopping item image, or <code>null</code> if a matching shopping item image could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingItemImage fetchByCompanyId_Last(long companyId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByCompanyId(companyId);

        if (count == 0) {
            return null;
        }

        List<ShoppingItemImage> list = findByCompanyId(companyId, count - 1,
                count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the shopping item images before and after the current shopping item image in the ordered set where companyId = &#63;.
     *
     * @param shoppingItemImageId the primary key of the current shopping item image
     * @param companyId the company ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next shopping item image
     * @throws com.fsquare.shopping.NoSuchShoppingItemImageException if a shopping item image with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingItemImage[] findByCompanyId_PrevAndNext(
        long shoppingItemImageId, long companyId,
        OrderByComparator orderByComparator)
        throws NoSuchShoppingItemImageException, SystemException {
        ShoppingItemImage shoppingItemImage = findByPrimaryKey(shoppingItemImageId);

        Session session = null;

        try {
            session = openSession();

            ShoppingItemImage[] array = new ShoppingItemImageImpl[3];

            array[0] = getByCompanyId_PrevAndNext(session, shoppingItemImage,
                    companyId, orderByComparator, true);

            array[1] = shoppingItemImage;

            array[2] = getByCompanyId_PrevAndNext(session, shoppingItemImage,
                    companyId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected ShoppingItemImage getByCompanyId_PrevAndNext(Session session,
        ShoppingItemImage shoppingItemImage, long companyId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_SHOPPINGITEMIMAGE_WHERE);

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
            query.append(ShoppingItemImageModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(companyId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(shoppingItemImage);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<ShoppingItemImage> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the shopping item images where companyId = &#63; from the database.
     *
     * @param companyId the company ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByCompanyId(long companyId) throws SystemException {
        for (ShoppingItemImage shoppingItemImage : findByCompanyId(companyId,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(shoppingItemImage);
        }
    }

    /**
     * Returns the number of shopping item images where companyId = &#63;.
     *
     * @param companyId the company ID
     * @return the number of matching shopping item images
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

            query.append(_SQL_COUNT_SHOPPINGITEMIMAGE_WHERE);

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
     * Returns all the shopping item images where companyId = &#63; and itemId = &#63;.
     *
     * @param companyId the company ID
     * @param itemId the item ID
     * @return the matching shopping item images
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ShoppingItemImage> findByCompanyIdAndItemId(long companyId,
        long itemId) throws SystemException {
        return findByCompanyIdAndItemId(companyId, itemId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the shopping item images where companyId = &#63; and itemId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingItemImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param companyId the company ID
     * @param itemId the item ID
     * @param start the lower bound of the range of shopping item images
     * @param end the upper bound of the range of shopping item images (not inclusive)
     * @return the range of matching shopping item images
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ShoppingItemImage> findByCompanyIdAndItemId(long companyId,
        long itemId, int start, int end) throws SystemException {
        return findByCompanyIdAndItemId(companyId, itemId, start, end, null);
    }

    /**
     * Returns an ordered range of all the shopping item images where companyId = &#63; and itemId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingItemImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param companyId the company ID
     * @param itemId the item ID
     * @param start the lower bound of the range of shopping item images
     * @param end the upper bound of the range of shopping item images (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching shopping item images
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ShoppingItemImage> findByCompanyIdAndItemId(long companyId,
        long itemId, int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYIDANDITEMID;
            finderArgs = new Object[] { companyId, itemId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYIDANDITEMID;
            finderArgs = new Object[] {
                    companyId, itemId,
                    
                    start, end, orderByComparator
                };
        }

        List<ShoppingItemImage> list = (List<ShoppingItemImage>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (ShoppingItemImage shoppingItemImage : list) {
                if ((companyId != shoppingItemImage.getCompanyId()) ||
                        (itemId != shoppingItemImage.getItemId())) {
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

            query.append(_SQL_SELECT_SHOPPINGITEMIMAGE_WHERE);

            query.append(_FINDER_COLUMN_COMPANYIDANDITEMID_COMPANYID_2);

            query.append(_FINDER_COLUMN_COMPANYIDANDITEMID_ITEMID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(ShoppingItemImageModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyId);

                qPos.add(itemId);

                if (!pagination) {
                    list = (List<ShoppingItemImage>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<ShoppingItemImage>(list);
                } else {
                    list = (List<ShoppingItemImage>) QueryUtil.list(q,
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
     * Returns the first shopping item image in the ordered set where companyId = &#63; and itemId = &#63;.
     *
     * @param companyId the company ID
     * @param itemId the item ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching shopping item image
     * @throws com.fsquare.shopping.NoSuchShoppingItemImageException if a matching shopping item image could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingItemImage findByCompanyIdAndItemId_First(long companyId,
        long itemId, OrderByComparator orderByComparator)
        throws NoSuchShoppingItemImageException, SystemException {
        ShoppingItemImage shoppingItemImage = fetchByCompanyIdAndItemId_First(companyId,
                itemId, orderByComparator);

        if (shoppingItemImage != null) {
            return shoppingItemImage;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(", itemId=");
        msg.append(itemId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchShoppingItemImageException(msg.toString());
    }

    /**
     * Returns the first shopping item image in the ordered set where companyId = &#63; and itemId = &#63;.
     *
     * @param companyId the company ID
     * @param itemId the item ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching shopping item image, or <code>null</code> if a matching shopping item image could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingItemImage fetchByCompanyIdAndItemId_First(long companyId,
        long itemId, OrderByComparator orderByComparator)
        throws SystemException {
        List<ShoppingItemImage> list = findByCompanyIdAndItemId(companyId,
                itemId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last shopping item image in the ordered set where companyId = &#63; and itemId = &#63;.
     *
     * @param companyId the company ID
     * @param itemId the item ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching shopping item image
     * @throws com.fsquare.shopping.NoSuchShoppingItemImageException if a matching shopping item image could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingItemImage findByCompanyIdAndItemId_Last(long companyId,
        long itemId, OrderByComparator orderByComparator)
        throws NoSuchShoppingItemImageException, SystemException {
        ShoppingItemImage shoppingItemImage = fetchByCompanyIdAndItemId_Last(companyId,
                itemId, orderByComparator);

        if (shoppingItemImage != null) {
            return shoppingItemImage;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(", itemId=");
        msg.append(itemId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchShoppingItemImageException(msg.toString());
    }

    /**
     * Returns the last shopping item image in the ordered set where companyId = &#63; and itemId = &#63;.
     *
     * @param companyId the company ID
     * @param itemId the item ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching shopping item image, or <code>null</code> if a matching shopping item image could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingItemImage fetchByCompanyIdAndItemId_Last(long companyId,
        long itemId, OrderByComparator orderByComparator)
        throws SystemException {
        int count = countByCompanyIdAndItemId(companyId, itemId);

        if (count == 0) {
            return null;
        }

        List<ShoppingItemImage> list = findByCompanyIdAndItemId(companyId,
                itemId, count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the shopping item images before and after the current shopping item image in the ordered set where companyId = &#63; and itemId = &#63;.
     *
     * @param shoppingItemImageId the primary key of the current shopping item image
     * @param companyId the company ID
     * @param itemId the item ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next shopping item image
     * @throws com.fsquare.shopping.NoSuchShoppingItemImageException if a shopping item image with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingItemImage[] findByCompanyIdAndItemId_PrevAndNext(
        long shoppingItemImageId, long companyId, long itemId,
        OrderByComparator orderByComparator)
        throws NoSuchShoppingItemImageException, SystemException {
        ShoppingItemImage shoppingItemImage = findByPrimaryKey(shoppingItemImageId);

        Session session = null;

        try {
            session = openSession();

            ShoppingItemImage[] array = new ShoppingItemImageImpl[3];

            array[0] = getByCompanyIdAndItemId_PrevAndNext(session,
                    shoppingItemImage, companyId, itemId, orderByComparator,
                    true);

            array[1] = shoppingItemImage;

            array[2] = getByCompanyIdAndItemId_PrevAndNext(session,
                    shoppingItemImage, companyId, itemId, orderByComparator,
                    false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected ShoppingItemImage getByCompanyIdAndItemId_PrevAndNext(
        Session session, ShoppingItemImage shoppingItemImage, long companyId,
        long itemId, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_SHOPPINGITEMIMAGE_WHERE);

        query.append(_FINDER_COLUMN_COMPANYIDANDITEMID_COMPANYID_2);

        query.append(_FINDER_COLUMN_COMPANYIDANDITEMID_ITEMID_2);

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
            query.append(ShoppingItemImageModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(companyId);

        qPos.add(itemId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(shoppingItemImage);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<ShoppingItemImage> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the shopping item images where companyId = &#63; and itemId = &#63; from the database.
     *
     * @param companyId the company ID
     * @param itemId the item ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByCompanyIdAndItemId(long companyId, long itemId)
        throws SystemException {
        for (ShoppingItemImage shoppingItemImage : findByCompanyIdAndItemId(
                companyId, itemId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(shoppingItemImage);
        }
    }

    /**
     * Returns the number of shopping item images where companyId = &#63; and itemId = &#63;.
     *
     * @param companyId the company ID
     * @param itemId the item ID
     * @return the number of matching shopping item images
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByCompanyIdAndItemId(long companyId, long itemId)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_COMPANYIDANDITEMID;

        Object[] finderArgs = new Object[] { companyId, itemId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_SHOPPINGITEMIMAGE_WHERE);

            query.append(_FINDER_COLUMN_COMPANYIDANDITEMID_COMPANYID_2);

            query.append(_FINDER_COLUMN_COMPANYIDANDITEMID_ITEMID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyId);

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
     * Returns the shopping item image where companyId = &#63; and itemId = &#63; and mainImage = &#63; or throws a {@link com.fsquare.shopping.NoSuchShoppingItemImageException} if it could not be found.
     *
     * @param companyId the company ID
     * @param itemId the item ID
     * @param mainImage the main image
     * @return the matching shopping item image
     * @throws com.fsquare.shopping.NoSuchShoppingItemImageException if a matching shopping item image could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingItemImage findByCompanyIdAndItemAndMain(long companyId,
        long itemId, boolean mainImage)
        throws NoSuchShoppingItemImageException, SystemException {
        ShoppingItemImage shoppingItemImage = fetchByCompanyIdAndItemAndMain(companyId,
                itemId, mainImage);

        if (shoppingItemImage == null) {
            StringBundler msg = new StringBundler(8);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("companyId=");
            msg.append(companyId);

            msg.append(", itemId=");
            msg.append(itemId);

            msg.append(", mainImage=");
            msg.append(mainImage);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchShoppingItemImageException(msg.toString());
        }

        return shoppingItemImage;
    }

    /**
     * Returns the shopping item image where companyId = &#63; and itemId = &#63; and mainImage = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param companyId the company ID
     * @param itemId the item ID
     * @param mainImage the main image
     * @return the matching shopping item image, or <code>null</code> if a matching shopping item image could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingItemImage fetchByCompanyIdAndItemAndMain(long companyId,
        long itemId, boolean mainImage) throws SystemException {
        return fetchByCompanyIdAndItemAndMain(companyId, itemId, mainImage, true);
    }

    /**
     * Returns the shopping item image where companyId = &#63; and itemId = &#63; and mainImage = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param companyId the company ID
     * @param itemId the item ID
     * @param mainImage the main image
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching shopping item image, or <code>null</code> if a matching shopping item image could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingItemImage fetchByCompanyIdAndItemAndMain(long companyId,
        long itemId, boolean mainImage, boolean retrieveFromCache)
        throws SystemException {
        Object[] finderArgs = new Object[] { companyId, itemId, mainImage };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_COMPANYIDANDITEMANDMAIN,
                    finderArgs, this);
        }

        if (result instanceof ShoppingItemImage) {
            ShoppingItemImage shoppingItemImage = (ShoppingItemImage) result;

            if ((companyId != shoppingItemImage.getCompanyId()) ||
                    (itemId != shoppingItemImage.getItemId()) ||
                    (mainImage != shoppingItemImage.getMainImage())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(5);

            query.append(_SQL_SELECT_SHOPPINGITEMIMAGE_WHERE);

            query.append(_FINDER_COLUMN_COMPANYIDANDITEMANDMAIN_COMPANYID_2);

            query.append(_FINDER_COLUMN_COMPANYIDANDITEMANDMAIN_ITEMID_2);

            query.append(_FINDER_COLUMN_COMPANYIDANDITEMANDMAIN_MAINIMAGE_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyId);

                qPos.add(itemId);

                qPos.add(mainImage);

                List<ShoppingItemImage> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COMPANYIDANDITEMANDMAIN,
                        finderArgs, list);
                } else {
                    ShoppingItemImage shoppingItemImage = list.get(0);

                    result = shoppingItemImage;

                    cacheResult(shoppingItemImage);

                    if ((shoppingItemImage.getCompanyId() != companyId) ||
                            (shoppingItemImage.getItemId() != itemId) ||
                            (shoppingItemImage.getMainImage() != mainImage)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COMPANYIDANDITEMANDMAIN,
                            finderArgs, shoppingItemImage);
                    }
                }
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_COMPANYIDANDITEMANDMAIN,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        if (result instanceof List<?>) {
            return null;
        } else {
            return (ShoppingItemImage) result;
        }
    }

    /**
     * Removes the shopping item image where companyId = &#63; and itemId = &#63; and mainImage = &#63; from the database.
     *
     * @param companyId the company ID
     * @param itemId the item ID
     * @param mainImage the main image
     * @return the shopping item image that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingItemImage removeByCompanyIdAndItemAndMain(long companyId,
        long itemId, boolean mainImage)
        throws NoSuchShoppingItemImageException, SystemException {
        ShoppingItemImage shoppingItemImage = findByCompanyIdAndItemAndMain(companyId,
                itemId, mainImage);

        return remove(shoppingItemImage);
    }

    /**
     * Returns the number of shopping item images where companyId = &#63; and itemId = &#63; and mainImage = &#63;.
     *
     * @param companyId the company ID
     * @param itemId the item ID
     * @param mainImage the main image
     * @return the number of matching shopping item images
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByCompanyIdAndItemAndMain(long companyId, long itemId,
        boolean mainImage) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_COMPANYIDANDITEMANDMAIN;

        Object[] finderArgs = new Object[] { companyId, itemId, mainImage };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(4);

            query.append(_SQL_COUNT_SHOPPINGITEMIMAGE_WHERE);

            query.append(_FINDER_COLUMN_COMPANYIDANDITEMANDMAIN_COMPANYID_2);

            query.append(_FINDER_COLUMN_COMPANYIDANDITEMANDMAIN_ITEMID_2);

            query.append(_FINDER_COLUMN_COMPANYIDANDITEMANDMAIN_MAINIMAGE_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyId);

                qPos.add(itemId);

                qPos.add(mainImage);

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
     * Caches the shopping item image in the entity cache if it is enabled.
     *
     * @param shoppingItemImage the shopping item image
     */
    @Override
    public void cacheResult(ShoppingItemImage shoppingItemImage) {
        EntityCacheUtil.putResult(ShoppingItemImageModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingItemImageImpl.class, shoppingItemImage.getPrimaryKey(),
            shoppingItemImage);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COMPANYIDANDITEMANDMAIN,
            new Object[] {
                shoppingItemImage.getCompanyId(), shoppingItemImage.getItemId(),
                shoppingItemImage.getMainImage()
            }, shoppingItemImage);

        shoppingItemImage.resetOriginalValues();
    }

    /**
     * Caches the shopping item images in the entity cache if it is enabled.
     *
     * @param shoppingItemImages the shopping item images
     */
    @Override
    public void cacheResult(List<ShoppingItemImage> shoppingItemImages) {
        for (ShoppingItemImage shoppingItemImage : shoppingItemImages) {
            if (EntityCacheUtil.getResult(
                        ShoppingItemImageModelImpl.ENTITY_CACHE_ENABLED,
                        ShoppingItemImageImpl.class,
                        shoppingItemImage.getPrimaryKey()) == null) {
                cacheResult(shoppingItemImage);
            } else {
                shoppingItemImage.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all shopping item images.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(ShoppingItemImageImpl.class.getName());
        }

        EntityCacheUtil.clearCache(ShoppingItemImageImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the shopping item image.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(ShoppingItemImage shoppingItemImage) {
        EntityCacheUtil.removeResult(ShoppingItemImageModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingItemImageImpl.class, shoppingItemImage.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(shoppingItemImage);
    }

    @Override
    public void clearCache(List<ShoppingItemImage> shoppingItemImages) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (ShoppingItemImage shoppingItemImage : shoppingItemImages) {
            EntityCacheUtil.removeResult(ShoppingItemImageModelImpl.ENTITY_CACHE_ENABLED,
                ShoppingItemImageImpl.class, shoppingItemImage.getPrimaryKey());

            clearUniqueFindersCache(shoppingItemImage);
        }
    }

    protected void cacheUniqueFindersCache(ShoppingItemImage shoppingItemImage) {
        if (shoppingItemImage.isNew()) {
            Object[] args = new Object[] {
                    shoppingItemImage.getCompanyId(),
                    shoppingItemImage.getItemId(),
                    shoppingItemImage.getMainImage()
                };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COMPANYIDANDITEMANDMAIN,
                args, Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COMPANYIDANDITEMANDMAIN,
                args, shoppingItemImage);
        } else {
            ShoppingItemImageModelImpl shoppingItemImageModelImpl = (ShoppingItemImageModelImpl) shoppingItemImage;

            if ((shoppingItemImageModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_COMPANYIDANDITEMANDMAIN.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        shoppingItemImage.getCompanyId(),
                        shoppingItemImage.getItemId(),
                        shoppingItemImage.getMainImage()
                    };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COMPANYIDANDITEMANDMAIN,
                    args, Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_COMPANYIDANDITEMANDMAIN,
                    args, shoppingItemImage);
            }
        }
    }

    protected void clearUniqueFindersCache(ShoppingItemImage shoppingItemImage) {
        ShoppingItemImageModelImpl shoppingItemImageModelImpl = (ShoppingItemImageModelImpl) shoppingItemImage;

        Object[] args = new Object[] {
                shoppingItemImage.getCompanyId(), shoppingItemImage.getItemId(),
                shoppingItemImage.getMainImage()
            };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYIDANDITEMANDMAIN,
            args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_COMPANYIDANDITEMANDMAIN,
            args);

        if ((shoppingItemImageModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_COMPANYIDANDITEMANDMAIN.getColumnBitmask()) != 0) {
            args = new Object[] {
                    shoppingItemImageModelImpl.getOriginalCompanyId(),
                    shoppingItemImageModelImpl.getOriginalItemId(),
                    shoppingItemImageModelImpl.getOriginalMainImage()
                };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYIDANDITEMANDMAIN,
                args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_COMPANYIDANDITEMANDMAIN,
                args);
        }
    }

    /**
     * Creates a new shopping item image with the primary key. Does not add the shopping item image to the database.
     *
     * @param shoppingItemImageId the primary key for the new shopping item image
     * @return the new shopping item image
     */
    @Override
    public ShoppingItemImage create(long shoppingItemImageId) {
        ShoppingItemImage shoppingItemImage = new ShoppingItemImageImpl();

        shoppingItemImage.setNew(true);
        shoppingItemImage.setPrimaryKey(shoppingItemImageId);

        return shoppingItemImage;
    }

    /**
     * Removes the shopping item image with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param shoppingItemImageId the primary key of the shopping item image
     * @return the shopping item image that was removed
     * @throws com.fsquare.shopping.NoSuchShoppingItemImageException if a shopping item image with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingItemImage remove(long shoppingItemImageId)
        throws NoSuchShoppingItemImageException, SystemException {
        return remove((Serializable) shoppingItemImageId);
    }

    /**
     * Removes the shopping item image with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the shopping item image
     * @return the shopping item image that was removed
     * @throws com.fsquare.shopping.NoSuchShoppingItemImageException if a shopping item image with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingItemImage remove(Serializable primaryKey)
        throws NoSuchShoppingItemImageException, SystemException {
        Session session = null;

        try {
            session = openSession();

            ShoppingItemImage shoppingItemImage = (ShoppingItemImage) session.get(ShoppingItemImageImpl.class,
                    primaryKey);

            if (shoppingItemImage == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchShoppingItemImageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(shoppingItemImage);
        } catch (NoSuchShoppingItemImageException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected ShoppingItemImage removeImpl(ShoppingItemImage shoppingItemImage)
        throws SystemException {
        shoppingItemImage = toUnwrappedModel(shoppingItemImage);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(shoppingItemImage)) {
                shoppingItemImage = (ShoppingItemImage) session.get(ShoppingItemImageImpl.class,
                        shoppingItemImage.getPrimaryKeyObj());
            }

            if (shoppingItemImage != null) {
                session.delete(shoppingItemImage);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (shoppingItemImage != null) {
            clearCache(shoppingItemImage);
        }

        return shoppingItemImage;
    }

    @Override
    public ShoppingItemImage updateImpl(
        com.fsquare.shopping.model.ShoppingItemImage shoppingItemImage)
        throws SystemException {
        shoppingItemImage = toUnwrappedModel(shoppingItemImage);

        boolean isNew = shoppingItemImage.isNew();

        ShoppingItemImageModelImpl shoppingItemImageModelImpl = (ShoppingItemImageModelImpl) shoppingItemImage;

        Session session = null;

        try {
            session = openSession();

            if (shoppingItemImage.isNew()) {
                session.save(shoppingItemImage);

                shoppingItemImage.setNew(false);
            } else {
                session.merge(shoppingItemImage);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !ShoppingItemImageModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((shoppingItemImageModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        shoppingItemImageModelImpl.getOriginalCompanyId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
                    args);

                args = new Object[] { shoppingItemImageModelImpl.getCompanyId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
                    args);
            }

            if ((shoppingItemImageModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYIDANDITEMID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        shoppingItemImageModelImpl.getOriginalCompanyId(),
                        shoppingItemImageModelImpl.getOriginalItemId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYIDANDITEMID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYIDANDITEMID,
                    args);

                args = new Object[] {
                        shoppingItemImageModelImpl.getCompanyId(),
                        shoppingItemImageModelImpl.getItemId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYIDANDITEMID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYIDANDITEMID,
                    args);
            }
        }

        EntityCacheUtil.putResult(ShoppingItemImageModelImpl.ENTITY_CACHE_ENABLED,
            ShoppingItemImageImpl.class, shoppingItemImage.getPrimaryKey(),
            shoppingItemImage);

        clearUniqueFindersCache(shoppingItemImage);
        cacheUniqueFindersCache(shoppingItemImage);

        return shoppingItemImage;
    }

    protected ShoppingItemImage toUnwrappedModel(
        ShoppingItemImage shoppingItemImage) {
        if (shoppingItemImage instanceof ShoppingItemImageImpl) {
            return shoppingItemImage;
        }

        ShoppingItemImageImpl shoppingItemImageImpl = new ShoppingItemImageImpl();

        shoppingItemImageImpl.setNew(shoppingItemImage.isNew());
        shoppingItemImageImpl.setPrimaryKey(shoppingItemImage.getPrimaryKey());

        shoppingItemImageImpl.setShoppingItemImageId(shoppingItemImage.getShoppingItemImageId());
        shoppingItemImageImpl.setCompanyId(shoppingItemImage.getCompanyId());
        shoppingItemImageImpl.setItemId(shoppingItemImage.getItemId());
        shoppingItemImageImpl.setImageId(shoppingItemImage.getImageId());
        shoppingItemImageImpl.setMainImage(shoppingItemImage.isMainImage());
        shoppingItemImageImpl.setOrder(shoppingItemImage.getOrder());

        return shoppingItemImageImpl;
    }

    /**
     * Returns the shopping item image with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the shopping item image
     * @return the shopping item image
     * @throws com.fsquare.shopping.NoSuchShoppingItemImageException if a shopping item image with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingItemImage findByPrimaryKey(Serializable primaryKey)
        throws NoSuchShoppingItemImageException, SystemException {
        ShoppingItemImage shoppingItemImage = fetchByPrimaryKey(primaryKey);

        if (shoppingItemImage == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchShoppingItemImageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return shoppingItemImage;
    }

    /**
     * Returns the shopping item image with the primary key or throws a {@link com.fsquare.shopping.NoSuchShoppingItemImageException} if it could not be found.
     *
     * @param shoppingItemImageId the primary key of the shopping item image
     * @return the shopping item image
     * @throws com.fsquare.shopping.NoSuchShoppingItemImageException if a shopping item image with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingItemImage findByPrimaryKey(long shoppingItemImageId)
        throws NoSuchShoppingItemImageException, SystemException {
        return findByPrimaryKey((Serializable) shoppingItemImageId);
    }

    /**
     * Returns the shopping item image with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the shopping item image
     * @return the shopping item image, or <code>null</code> if a shopping item image with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingItemImage fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        ShoppingItemImage shoppingItemImage = (ShoppingItemImage) EntityCacheUtil.getResult(ShoppingItemImageModelImpl.ENTITY_CACHE_ENABLED,
                ShoppingItemImageImpl.class, primaryKey);

        if (shoppingItemImage == _nullShoppingItemImage) {
            return null;
        }

        if (shoppingItemImage == null) {
            Session session = null;

            try {
                session = openSession();

                shoppingItemImage = (ShoppingItemImage) session.get(ShoppingItemImageImpl.class,
                        primaryKey);

                if (shoppingItemImage != null) {
                    cacheResult(shoppingItemImage);
                } else {
                    EntityCacheUtil.putResult(ShoppingItemImageModelImpl.ENTITY_CACHE_ENABLED,
                        ShoppingItemImageImpl.class, primaryKey,
                        _nullShoppingItemImage);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(ShoppingItemImageModelImpl.ENTITY_CACHE_ENABLED,
                    ShoppingItemImageImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return shoppingItemImage;
    }

    /**
     * Returns the shopping item image with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param shoppingItemImageId the primary key of the shopping item image
     * @return the shopping item image, or <code>null</code> if a shopping item image with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingItemImage fetchByPrimaryKey(long shoppingItemImageId)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) shoppingItemImageId);
    }

    /**
     * Returns all the shopping item images.
     *
     * @return the shopping item images
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ShoppingItemImage> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the shopping item images.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingItemImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of shopping item images
     * @param end the upper bound of the range of shopping item images (not inclusive)
     * @return the range of shopping item images
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ShoppingItemImage> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the shopping item images.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingItemImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of shopping item images
     * @param end the upper bound of the range of shopping item images (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of shopping item images
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ShoppingItemImage> findAll(int start, int end,
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

        List<ShoppingItemImage> list = (List<ShoppingItemImage>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_SHOPPINGITEMIMAGE);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_SHOPPINGITEMIMAGE;

                if (pagination) {
                    sql = sql.concat(ShoppingItemImageModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<ShoppingItemImage>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<ShoppingItemImage>(list);
                } else {
                    list = (List<ShoppingItemImage>) QueryUtil.list(q,
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
     * Removes all the shopping item images from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (ShoppingItemImage shoppingItemImage : findAll()) {
            remove(shoppingItemImage);
        }
    }

    /**
     * Returns the number of shopping item images.
     *
     * @return the number of shopping item images
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

                Query q = session.createQuery(_SQL_COUNT_SHOPPINGITEMIMAGE);

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
     * Initializes the shopping item image persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.fsquare.shopping.model.ShoppingItemImage")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<ShoppingItemImage>> listenersList = new ArrayList<ModelListener<ShoppingItemImage>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<ShoppingItemImage>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(ShoppingItemImageImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
