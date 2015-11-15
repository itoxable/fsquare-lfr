package com.fsquare.shopping.service.base;

import com.fsquare.shopping.model.ShoppingShippingMethod;
import com.fsquare.shopping.service.ShoppingShippingMethodLocalService;
import com.fsquare.shopping.service.persistence.ShoppingCouponPersistence;
import com.fsquare.shopping.service.persistence.ShoppingOrderItemPersistence;
import com.fsquare.shopping.service.persistence.ShoppingOrderPersistence;
import com.fsquare.shopping.service.persistence.ShoppingShippingMethodPersistence;
import com.fsquare.shopping.service.persistence.ShoppingStorePersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.persistence.UserPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the shopping shipping method local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.fsquare.shopping.service.impl.ShoppingShippingMethodLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.fsquare.shopping.service.impl.ShoppingShippingMethodLocalServiceImpl
 * @see com.fsquare.shopping.service.ShoppingShippingMethodLocalServiceUtil
 * @generated
 */
public abstract class ShoppingShippingMethodLocalServiceBaseImpl
    extends BaseLocalServiceImpl implements ShoppingShippingMethodLocalService,
        IdentifiableBean {
    @BeanReference(type = com.fsquare.shopping.service.ShoppingCouponLocalService.class)
    protected com.fsquare.shopping.service.ShoppingCouponLocalService shoppingCouponLocalService;
    @BeanReference(type = com.fsquare.shopping.service.ShoppingCouponService.class)
    protected com.fsquare.shopping.service.ShoppingCouponService shoppingCouponService;
    @BeanReference(type = ShoppingCouponPersistence.class)
    protected ShoppingCouponPersistence shoppingCouponPersistence;
    @BeanReference(type = com.fsquare.shopping.service.ShoppingOrderLocalService.class)
    protected com.fsquare.shopping.service.ShoppingOrderLocalService shoppingOrderLocalService;
    @BeanReference(type = com.fsquare.shopping.service.ShoppingOrderService.class)
    protected com.fsquare.shopping.service.ShoppingOrderService shoppingOrderService;
    @BeanReference(type = ShoppingOrderPersistence.class)
    protected ShoppingOrderPersistence shoppingOrderPersistence;
    @BeanReference(type = com.fsquare.shopping.service.ShoppingOrderItemLocalService.class)
    protected com.fsquare.shopping.service.ShoppingOrderItemLocalService shoppingOrderItemLocalService;
    @BeanReference(type = com.fsquare.shopping.service.ShoppingOrderItemService.class)
    protected com.fsquare.shopping.service.ShoppingOrderItemService shoppingOrderItemService;
    @BeanReference(type = ShoppingOrderItemPersistence.class)
    protected ShoppingOrderItemPersistence shoppingOrderItemPersistence;
    @BeanReference(type = com.fsquare.shopping.service.ShoppingPaymentLocalService.class)
    protected com.fsquare.shopping.service.ShoppingPaymentLocalService shoppingPaymentLocalService;
    @BeanReference(type = com.fsquare.shopping.service.ShoppingPaymentService.class)
    protected com.fsquare.shopping.service.ShoppingPaymentService shoppingPaymentService;
    @BeanReference(type = com.fsquare.shopping.service.ShoppingShippingMethodLocalService.class)
    protected com.fsquare.shopping.service.ShoppingShippingMethodLocalService shoppingShippingMethodLocalService;
    @BeanReference(type = com.fsquare.shopping.service.ShoppingShippingMethodService.class)
    protected com.fsquare.shopping.service.ShoppingShippingMethodService shoppingShippingMethodService;
    @BeanReference(type = ShoppingShippingMethodPersistence.class)
    protected ShoppingShippingMethodPersistence shoppingShippingMethodPersistence;
    @BeanReference(type = com.fsquare.shopping.service.ShoppingStoreLocalService.class)
    protected com.fsquare.shopping.service.ShoppingStoreLocalService shoppingStoreLocalService;
    @BeanReference(type = com.fsquare.shopping.service.ShoppingStoreService.class)
    protected com.fsquare.shopping.service.ShoppingStoreService shoppingStoreService;
    @BeanReference(type = ShoppingStorePersistence.class)
    protected ShoppingStorePersistence shoppingStorePersistence;
    @BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
    protected com.liferay.counter.service.CounterLocalService counterLocalService;
    @BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
    protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
    @BeanReference(type = com.liferay.portal.service.UserLocalService.class)
    protected com.liferay.portal.service.UserLocalService userLocalService;
    @BeanReference(type = com.liferay.portal.service.UserService.class)
    protected com.liferay.portal.service.UserService userService;
    @BeanReference(type = UserPersistence.class)
    protected UserPersistence userPersistence;
    private String _beanIdentifier;
    private ClassLoader _classLoader;
    private ShoppingShippingMethodLocalServiceClpInvoker _clpInvoker = new ShoppingShippingMethodLocalServiceClpInvoker();

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link com.fsquare.shopping.service.ShoppingShippingMethodLocalServiceUtil} to access the shopping shipping method local service.
     */

    /**
     * Adds the shopping shipping method to the database. Also notifies the appropriate model listeners.
     *
     * @param shoppingShippingMethod the shopping shipping method
     * @return the shopping shipping method that was added
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.REINDEX)
    @Override
    public ShoppingShippingMethod addShoppingShippingMethod(
        ShoppingShippingMethod shoppingShippingMethod)
        throws SystemException {
        shoppingShippingMethod.setNew(true);

        return shoppingShippingMethodPersistence.update(shoppingShippingMethod);
    }

    /**
     * Creates a new shopping shipping method with the primary key. Does not add the shopping shipping method to the database.
     *
     * @param shippingMethodId the primary key for the new shopping shipping method
     * @return the new shopping shipping method
     */
    @Override
    public ShoppingShippingMethod createShoppingShippingMethod(
        long shippingMethodId) {
        return shoppingShippingMethodPersistence.create(shippingMethodId);
    }

    /**
     * Deletes the shopping shipping method with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param shippingMethodId the primary key of the shopping shipping method
     * @return the shopping shipping method that was removed
     * @throws PortalException if a shopping shipping method with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.DELETE)
    @Override
    public ShoppingShippingMethod deleteShoppingShippingMethod(
        long shippingMethodId) throws PortalException, SystemException {
        return shoppingShippingMethodPersistence.remove(shippingMethodId);
    }

    /**
     * Deletes the shopping shipping method from the database. Also notifies the appropriate model listeners.
     *
     * @param shoppingShippingMethod the shopping shipping method
     * @return the shopping shipping method that was removed
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.DELETE)
    @Override
    public ShoppingShippingMethod deleteShoppingShippingMethod(
        ShoppingShippingMethod shoppingShippingMethod)
        throws SystemException {
        return shoppingShippingMethodPersistence.remove(shoppingShippingMethod);
    }

    @Override
    public DynamicQuery dynamicQuery() {
        Class<?> clazz = getClass();

        return DynamicQueryFactoryUtil.forClass(ShoppingShippingMethod.class,
            clazz.getClassLoader());
    }

    /**
     * Performs a dynamic query on the database and returns the matching rows.
     *
     * @param dynamicQuery the dynamic query
     * @return the matching rows
     * @throws SystemException if a system exception occurred
     */
    @Override
    @SuppressWarnings("rawtypes")
    public List dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return shoppingShippingMethodPersistence.findWithDynamicQuery(dynamicQuery);
    }

    /**
     * Performs a dynamic query on the database and returns a range of the matching rows.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingShippingMethodModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param dynamicQuery the dynamic query
     * @param start the lower bound of the range of model instances
     * @param end the upper bound of the range of model instances (not inclusive)
     * @return the range of matching rows
     * @throws SystemException if a system exception occurred
     */
    @Override
    @SuppressWarnings("rawtypes")
    public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return shoppingShippingMethodPersistence.findWithDynamicQuery(dynamicQuery,
            start, end);
    }

    /**
     * Performs a dynamic query on the database and returns an ordered range of the matching rows.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fsquare.shopping.model.impl.ShoppingShippingMethodModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param dynamicQuery the dynamic query
     * @param start the lower bound of the range of model instances
     * @param end the upper bound of the range of model instances (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching rows
     * @throws SystemException if a system exception occurred
     */
    @Override
    @SuppressWarnings("rawtypes")
    public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return shoppingShippingMethodPersistence.findWithDynamicQuery(dynamicQuery,
            start, end, orderByComparator);
    }

    /**
     * Returns the number of rows that match the dynamic query.
     *
     * @param dynamicQuery the dynamic query
     * @return the number of rows that match the dynamic query
     * @throws SystemException if a system exception occurred
     */
    @Override
    public long dynamicQueryCount(DynamicQuery dynamicQuery)
        throws SystemException {
        return shoppingShippingMethodPersistence.countWithDynamicQuery(dynamicQuery);
    }

    /**
     * Returns the number of rows that match the dynamic query.
     *
     * @param dynamicQuery the dynamic query
     * @param projection the projection to apply to the query
     * @return the number of rows that match the dynamic query
     * @throws SystemException if a system exception occurred
     */
    @Override
    public long dynamicQueryCount(DynamicQuery dynamicQuery,
        Projection projection) throws SystemException {
        return shoppingShippingMethodPersistence.countWithDynamicQuery(dynamicQuery,
            projection);
    }

    @Override
    public ShoppingShippingMethod fetchShoppingShippingMethod(
        long shippingMethodId) throws SystemException {
        return shoppingShippingMethodPersistence.fetchByPrimaryKey(shippingMethodId);
    }

    /**
     * Returns the shopping shipping method with the primary key.
     *
     * @param shippingMethodId the primary key of the shopping shipping method
     * @return the shopping shipping method
     * @throws PortalException if a shopping shipping method with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ShoppingShippingMethod getShoppingShippingMethod(
        long shippingMethodId) throws PortalException, SystemException {
        return shoppingShippingMethodPersistence.findByPrimaryKey(shippingMethodId);
    }

    @Override
    public PersistedModel getPersistedModel(Serializable primaryKeyObj)
        throws PortalException, SystemException {
        return shoppingShippingMethodPersistence.findByPrimaryKey(primaryKeyObj);
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
    public List<ShoppingShippingMethod> getShoppingShippingMethods(int start,
        int end) throws SystemException {
        return shoppingShippingMethodPersistence.findAll(start, end);
    }

    /**
     * Returns the number of shopping shipping methods.
     *
     * @return the number of shopping shipping methods
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int getShoppingShippingMethodsCount() throws SystemException {
        return shoppingShippingMethodPersistence.countAll();
    }

    /**
     * Updates the shopping shipping method in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
     *
     * @param shoppingShippingMethod the shopping shipping method
     * @return the shopping shipping method that was updated
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.REINDEX)
    @Override
    public ShoppingShippingMethod updateShoppingShippingMethod(
        ShoppingShippingMethod shoppingShippingMethod)
        throws SystemException {
        return shoppingShippingMethodPersistence.update(shoppingShippingMethod);
    }

    /**
     * Returns the shopping coupon local service.
     *
     * @return the shopping coupon local service
     */
    public com.fsquare.shopping.service.ShoppingCouponLocalService getShoppingCouponLocalService() {
        return shoppingCouponLocalService;
    }

    /**
     * Sets the shopping coupon local service.
     *
     * @param shoppingCouponLocalService the shopping coupon local service
     */
    public void setShoppingCouponLocalService(
        com.fsquare.shopping.service.ShoppingCouponLocalService shoppingCouponLocalService) {
        this.shoppingCouponLocalService = shoppingCouponLocalService;
    }

    /**
     * Returns the shopping coupon remote service.
     *
     * @return the shopping coupon remote service
     */
    public com.fsquare.shopping.service.ShoppingCouponService getShoppingCouponService() {
        return shoppingCouponService;
    }

    /**
     * Sets the shopping coupon remote service.
     *
     * @param shoppingCouponService the shopping coupon remote service
     */
    public void setShoppingCouponService(
        com.fsquare.shopping.service.ShoppingCouponService shoppingCouponService) {
        this.shoppingCouponService = shoppingCouponService;
    }

    /**
     * Returns the shopping coupon persistence.
     *
     * @return the shopping coupon persistence
     */
    public ShoppingCouponPersistence getShoppingCouponPersistence() {
        return shoppingCouponPersistence;
    }

    /**
     * Sets the shopping coupon persistence.
     *
     * @param shoppingCouponPersistence the shopping coupon persistence
     */
    public void setShoppingCouponPersistence(
        ShoppingCouponPersistence shoppingCouponPersistence) {
        this.shoppingCouponPersistence = shoppingCouponPersistence;
    }

    /**
     * Returns the shopping order local service.
     *
     * @return the shopping order local service
     */
    public com.fsquare.shopping.service.ShoppingOrderLocalService getShoppingOrderLocalService() {
        return shoppingOrderLocalService;
    }

    /**
     * Sets the shopping order local service.
     *
     * @param shoppingOrderLocalService the shopping order local service
     */
    public void setShoppingOrderLocalService(
        com.fsquare.shopping.service.ShoppingOrderLocalService shoppingOrderLocalService) {
        this.shoppingOrderLocalService = shoppingOrderLocalService;
    }

    /**
     * Returns the shopping order remote service.
     *
     * @return the shopping order remote service
     */
    public com.fsquare.shopping.service.ShoppingOrderService getShoppingOrderService() {
        return shoppingOrderService;
    }

    /**
     * Sets the shopping order remote service.
     *
     * @param shoppingOrderService the shopping order remote service
     */
    public void setShoppingOrderService(
        com.fsquare.shopping.service.ShoppingOrderService shoppingOrderService) {
        this.shoppingOrderService = shoppingOrderService;
    }

    /**
     * Returns the shopping order persistence.
     *
     * @return the shopping order persistence
     */
    public ShoppingOrderPersistence getShoppingOrderPersistence() {
        return shoppingOrderPersistence;
    }

    /**
     * Sets the shopping order persistence.
     *
     * @param shoppingOrderPersistence the shopping order persistence
     */
    public void setShoppingOrderPersistence(
        ShoppingOrderPersistence shoppingOrderPersistence) {
        this.shoppingOrderPersistence = shoppingOrderPersistence;
    }

    /**
     * Returns the shopping order item local service.
     *
     * @return the shopping order item local service
     */
    public com.fsquare.shopping.service.ShoppingOrderItemLocalService getShoppingOrderItemLocalService() {
        return shoppingOrderItemLocalService;
    }

    /**
     * Sets the shopping order item local service.
     *
     * @param shoppingOrderItemLocalService the shopping order item local service
     */
    public void setShoppingOrderItemLocalService(
        com.fsquare.shopping.service.ShoppingOrderItemLocalService shoppingOrderItemLocalService) {
        this.shoppingOrderItemLocalService = shoppingOrderItemLocalService;
    }

    /**
     * Returns the shopping order item remote service.
     *
     * @return the shopping order item remote service
     */
    public com.fsquare.shopping.service.ShoppingOrderItemService getShoppingOrderItemService() {
        return shoppingOrderItemService;
    }

    /**
     * Sets the shopping order item remote service.
     *
     * @param shoppingOrderItemService the shopping order item remote service
     */
    public void setShoppingOrderItemService(
        com.fsquare.shopping.service.ShoppingOrderItemService shoppingOrderItemService) {
        this.shoppingOrderItemService = shoppingOrderItemService;
    }

    /**
     * Returns the shopping order item persistence.
     *
     * @return the shopping order item persistence
     */
    public ShoppingOrderItemPersistence getShoppingOrderItemPersistence() {
        return shoppingOrderItemPersistence;
    }

    /**
     * Sets the shopping order item persistence.
     *
     * @param shoppingOrderItemPersistence the shopping order item persistence
     */
    public void setShoppingOrderItemPersistence(
        ShoppingOrderItemPersistence shoppingOrderItemPersistence) {
        this.shoppingOrderItemPersistence = shoppingOrderItemPersistence;
    }

    /**
     * Returns the shopping payment local service.
     *
     * @return the shopping payment local service
     */
    public com.fsquare.shopping.service.ShoppingPaymentLocalService getShoppingPaymentLocalService() {
        return shoppingPaymentLocalService;
    }

    /**
     * Sets the shopping payment local service.
     *
     * @param shoppingPaymentLocalService the shopping payment local service
     */
    public void setShoppingPaymentLocalService(
        com.fsquare.shopping.service.ShoppingPaymentLocalService shoppingPaymentLocalService) {
        this.shoppingPaymentLocalService = shoppingPaymentLocalService;
    }

    /**
     * Returns the shopping payment remote service.
     *
     * @return the shopping payment remote service
     */
    public com.fsquare.shopping.service.ShoppingPaymentService getShoppingPaymentService() {
        return shoppingPaymentService;
    }

    /**
     * Sets the shopping payment remote service.
     *
     * @param shoppingPaymentService the shopping payment remote service
     */
    public void setShoppingPaymentService(
        com.fsquare.shopping.service.ShoppingPaymentService shoppingPaymentService) {
        this.shoppingPaymentService = shoppingPaymentService;
    }

    /**
     * Returns the shopping shipping method local service.
     *
     * @return the shopping shipping method local service
     */
    public com.fsquare.shopping.service.ShoppingShippingMethodLocalService getShoppingShippingMethodLocalService() {
        return shoppingShippingMethodLocalService;
    }

    /**
     * Sets the shopping shipping method local service.
     *
     * @param shoppingShippingMethodLocalService the shopping shipping method local service
     */
    public void setShoppingShippingMethodLocalService(
        com.fsquare.shopping.service.ShoppingShippingMethodLocalService shoppingShippingMethodLocalService) {
        this.shoppingShippingMethodLocalService = shoppingShippingMethodLocalService;
    }

    /**
     * Returns the shopping shipping method remote service.
     *
     * @return the shopping shipping method remote service
     */
    public com.fsquare.shopping.service.ShoppingShippingMethodService getShoppingShippingMethodService() {
        return shoppingShippingMethodService;
    }

    /**
     * Sets the shopping shipping method remote service.
     *
     * @param shoppingShippingMethodService the shopping shipping method remote service
     */
    public void setShoppingShippingMethodService(
        com.fsquare.shopping.service.ShoppingShippingMethodService shoppingShippingMethodService) {
        this.shoppingShippingMethodService = shoppingShippingMethodService;
    }

    /**
     * Returns the shopping shipping method persistence.
     *
     * @return the shopping shipping method persistence
     */
    public ShoppingShippingMethodPersistence getShoppingShippingMethodPersistence() {
        return shoppingShippingMethodPersistence;
    }

    /**
     * Sets the shopping shipping method persistence.
     *
     * @param shoppingShippingMethodPersistence the shopping shipping method persistence
     */
    public void setShoppingShippingMethodPersistence(
        ShoppingShippingMethodPersistence shoppingShippingMethodPersistence) {
        this.shoppingShippingMethodPersistence = shoppingShippingMethodPersistence;
    }

    /**
     * Returns the shopping store local service.
     *
     * @return the shopping store local service
     */
    public com.fsquare.shopping.service.ShoppingStoreLocalService getShoppingStoreLocalService() {
        return shoppingStoreLocalService;
    }

    /**
     * Sets the shopping store local service.
     *
     * @param shoppingStoreLocalService the shopping store local service
     */
    public void setShoppingStoreLocalService(
        com.fsquare.shopping.service.ShoppingStoreLocalService shoppingStoreLocalService) {
        this.shoppingStoreLocalService = shoppingStoreLocalService;
    }

    /**
     * Returns the shopping store remote service.
     *
     * @return the shopping store remote service
     */
    public com.fsquare.shopping.service.ShoppingStoreService getShoppingStoreService() {
        return shoppingStoreService;
    }

    /**
     * Sets the shopping store remote service.
     *
     * @param shoppingStoreService the shopping store remote service
     */
    public void setShoppingStoreService(
        com.fsquare.shopping.service.ShoppingStoreService shoppingStoreService) {
        this.shoppingStoreService = shoppingStoreService;
    }

    /**
     * Returns the shopping store persistence.
     *
     * @return the shopping store persistence
     */
    public ShoppingStorePersistence getShoppingStorePersistence() {
        return shoppingStorePersistence;
    }

    /**
     * Sets the shopping store persistence.
     *
     * @param shoppingStorePersistence the shopping store persistence
     */
    public void setShoppingStorePersistence(
        ShoppingStorePersistence shoppingStorePersistence) {
        this.shoppingStorePersistence = shoppingStorePersistence;
    }

    /**
     * Returns the counter local service.
     *
     * @return the counter local service
     */
    public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
        return counterLocalService;
    }

    /**
     * Sets the counter local service.
     *
     * @param counterLocalService the counter local service
     */
    public void setCounterLocalService(
        com.liferay.counter.service.CounterLocalService counterLocalService) {
        this.counterLocalService = counterLocalService;
    }

    /**
     * Returns the resource local service.
     *
     * @return the resource local service
     */
    public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
        return resourceLocalService;
    }

    /**
     * Sets the resource local service.
     *
     * @param resourceLocalService the resource local service
     */
    public void setResourceLocalService(
        com.liferay.portal.service.ResourceLocalService resourceLocalService) {
        this.resourceLocalService = resourceLocalService;
    }

    /**
     * Returns the user local service.
     *
     * @return the user local service
     */
    public com.liferay.portal.service.UserLocalService getUserLocalService() {
        return userLocalService;
    }

    /**
     * Sets the user local service.
     *
     * @param userLocalService the user local service
     */
    public void setUserLocalService(
        com.liferay.portal.service.UserLocalService userLocalService) {
        this.userLocalService = userLocalService;
    }

    /**
     * Returns the user remote service.
     *
     * @return the user remote service
     */
    public com.liferay.portal.service.UserService getUserService() {
        return userService;
    }

    /**
     * Sets the user remote service.
     *
     * @param userService the user remote service
     */
    public void setUserService(
        com.liferay.portal.service.UserService userService) {
        this.userService = userService;
    }

    /**
     * Returns the user persistence.
     *
     * @return the user persistence
     */
    public UserPersistence getUserPersistence() {
        return userPersistence;
    }

    /**
     * Sets the user persistence.
     *
     * @param userPersistence the user persistence
     */
    public void setUserPersistence(UserPersistence userPersistence) {
        this.userPersistence = userPersistence;
    }

    public void afterPropertiesSet() {
        Class<?> clazz = getClass();

        _classLoader = clazz.getClassLoader();

        PersistedModelLocalServiceRegistryUtil.register("com.fsquare.shopping.model.ShoppingShippingMethod",
            shoppingShippingMethodLocalService);
    }

    public void destroy() {
        PersistedModelLocalServiceRegistryUtil.unregister(
            "com.fsquare.shopping.model.ShoppingShippingMethod");
    }

    /**
     * Returns the Spring bean ID for this bean.
     *
     * @return the Spring bean ID for this bean
     */
    @Override
    public String getBeanIdentifier() {
        return _beanIdentifier;
    }

    /**
     * Sets the Spring bean ID for this bean.
     *
     * @param beanIdentifier the Spring bean ID for this bean
     */
    @Override
    public void setBeanIdentifier(String beanIdentifier) {
        _beanIdentifier = beanIdentifier;
    }

    @Override
    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        Thread currentThread = Thread.currentThread();

        ClassLoader contextClassLoader = currentThread.getContextClassLoader();

        if (contextClassLoader != _classLoader) {
            currentThread.setContextClassLoader(_classLoader);
        }

        try {
            return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
        } finally {
            if (contextClassLoader != _classLoader) {
                currentThread.setContextClassLoader(contextClassLoader);
            }
        }
    }

    protected Class<?> getModelClass() {
        return ShoppingShippingMethod.class;
    }

    protected String getModelClassName() {
        return ShoppingShippingMethod.class.getName();
    }

    /**
     * Performs an SQL query.
     *
     * @param sql the sql query
     */
    protected void runSQL(String sql) throws SystemException {
        try {
            DataSource dataSource = shoppingShippingMethodPersistence.getDataSource();

            SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
                    sql, new int[0]);

            sqlUpdate.update();
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}
