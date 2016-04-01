package com.fsquare.shopping.service.base;

import com.fsquare.shopping.model.ShoppingShippingMethod;
import com.fsquare.shopping.service.ShoppingShippingMethodService;
import com.fsquare.shopping.service.persistence.ShoppingCouponPersistence;
import com.fsquare.shopping.service.persistence.ShoppingItemImagePersistence;
import com.fsquare.shopping.service.persistence.ShoppingItemPersistence;
import com.fsquare.shopping.service.persistence.ShoppingItemStorageLocationPersistence;
import com.fsquare.shopping.service.persistence.ShoppingItemTypePersistence;
import com.fsquare.shopping.service.persistence.ShoppingOrderItemPersistence;
import com.fsquare.shopping.service.persistence.ShoppingOrderPersistence;
import com.fsquare.shopping.service.persistence.ShoppingShippingMethodPersistence;
import com.fsquare.shopping.service.persistence.ShoppingStorageLocationPersistence;
import com.fsquare.shopping.service.persistence.ShoppingStorePersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.BaseServiceImpl;
import com.liferay.portal.service.persistence.UserPersistence;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the shopping shipping method remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.fsquare.shopping.service.impl.ShoppingShippingMethodServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.fsquare.shopping.service.impl.ShoppingShippingMethodServiceImpl
 * @see com.fsquare.shopping.service.ShoppingShippingMethodServiceUtil
 * @generated
 */
public abstract class ShoppingShippingMethodServiceBaseImpl
    extends BaseServiceImpl implements ShoppingShippingMethodService,
        IdentifiableBean {
    @BeanReference(type = com.fsquare.shopping.service.ShoppingCouponLocalService.class)
    protected com.fsquare.shopping.service.ShoppingCouponLocalService shoppingCouponLocalService;
    @BeanReference(type = com.fsquare.shopping.service.ShoppingCouponService.class)
    protected com.fsquare.shopping.service.ShoppingCouponService shoppingCouponService;
    @BeanReference(type = ShoppingCouponPersistence.class)
    protected ShoppingCouponPersistence shoppingCouponPersistence;
    @BeanReference(type = com.fsquare.shopping.service.ShoppingItemLocalService.class)
    protected com.fsquare.shopping.service.ShoppingItemLocalService shoppingItemLocalService;
    @BeanReference(type = com.fsquare.shopping.service.ShoppingItemService.class)
    protected com.fsquare.shopping.service.ShoppingItemService shoppingItemService;
    @BeanReference(type = ShoppingItemPersistence.class)
    protected ShoppingItemPersistence shoppingItemPersistence;
    @BeanReference(type = com.fsquare.shopping.service.ShoppingItemImageLocalService.class)
    protected com.fsquare.shopping.service.ShoppingItemImageLocalService shoppingItemImageLocalService;
    @BeanReference(type = ShoppingItemImagePersistence.class)
    protected ShoppingItemImagePersistence shoppingItemImagePersistence;
    @BeanReference(type = com.fsquare.shopping.service.ShoppingItemStorageLocationLocalService.class)
    protected com.fsquare.shopping.service.ShoppingItemStorageLocationLocalService shoppingItemStorageLocationLocalService;
    @BeanReference(type = com.fsquare.shopping.service.ShoppingItemStorageLocationService.class)
    protected com.fsquare.shopping.service.ShoppingItemStorageLocationService shoppingItemStorageLocationService;
    @BeanReference(type = ShoppingItemStorageLocationPersistence.class)
    protected ShoppingItemStorageLocationPersistence shoppingItemStorageLocationPersistence;
    @BeanReference(type = com.fsquare.shopping.service.ShoppingItemTypeLocalService.class)
    protected com.fsquare.shopping.service.ShoppingItemTypeLocalService shoppingItemTypeLocalService;
    @BeanReference(type = com.fsquare.shopping.service.ShoppingItemTypeService.class)
    protected com.fsquare.shopping.service.ShoppingItemTypeService shoppingItemTypeService;
    @BeanReference(type = ShoppingItemTypePersistence.class)
    protected ShoppingItemTypePersistence shoppingItemTypePersistence;
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
    @BeanReference(type = com.fsquare.shopping.service.ShoppingStorageLocationLocalService.class)
    protected com.fsquare.shopping.service.ShoppingStorageLocationLocalService shoppingStorageLocationLocalService;
    @BeanReference(type = com.fsquare.shopping.service.ShoppingStorageLocationService.class)
    protected com.fsquare.shopping.service.ShoppingStorageLocationService shoppingStorageLocationService;
    @BeanReference(type = ShoppingStorageLocationPersistence.class)
    protected ShoppingStorageLocationPersistence shoppingStorageLocationPersistence;
    @BeanReference(type = com.fsquare.shopping.service.ShoppingStoreLocalService.class)
    protected com.fsquare.shopping.service.ShoppingStoreLocalService shoppingStoreLocalService;
    @BeanReference(type = com.fsquare.shopping.service.ShoppingStoreService.class)
    protected com.fsquare.shopping.service.ShoppingStoreService shoppingStoreService;
    @BeanReference(type = ShoppingStorePersistence.class)
    protected ShoppingStorePersistence shoppingStorePersistence;
    @BeanReference(type = com.fsquare.shopping.service.SiteCommonActionsLocalService.class)
    protected com.fsquare.shopping.service.SiteCommonActionsLocalService siteCommonActionsLocalService;
    @BeanReference(type = com.fsquare.shopping.service.SiteCommonActionsService.class)
    protected com.fsquare.shopping.service.SiteCommonActionsService siteCommonActionsService;
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
    private ShoppingShippingMethodServiceClpInvoker _clpInvoker = new ShoppingShippingMethodServiceClpInvoker();

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link com.fsquare.shopping.service.ShoppingShippingMethodServiceUtil} to access the shopping shipping method remote service.
     */

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
     * Returns the shopping item local service.
     *
     * @return the shopping item local service
     */
    public com.fsquare.shopping.service.ShoppingItemLocalService getShoppingItemLocalService() {
        return shoppingItemLocalService;
    }

    /**
     * Sets the shopping item local service.
     *
     * @param shoppingItemLocalService the shopping item local service
     */
    public void setShoppingItemLocalService(
        com.fsquare.shopping.service.ShoppingItemLocalService shoppingItemLocalService) {
        this.shoppingItemLocalService = shoppingItemLocalService;
    }

    /**
     * Returns the shopping item remote service.
     *
     * @return the shopping item remote service
     */
    public com.fsquare.shopping.service.ShoppingItemService getShoppingItemService() {
        return shoppingItemService;
    }

    /**
     * Sets the shopping item remote service.
     *
     * @param shoppingItemService the shopping item remote service
     */
    public void setShoppingItemService(
        com.fsquare.shopping.service.ShoppingItemService shoppingItemService) {
        this.shoppingItemService = shoppingItemService;
    }

    /**
     * Returns the shopping item persistence.
     *
     * @return the shopping item persistence
     */
    public ShoppingItemPersistence getShoppingItemPersistence() {
        return shoppingItemPersistence;
    }

    /**
     * Sets the shopping item persistence.
     *
     * @param shoppingItemPersistence the shopping item persistence
     */
    public void setShoppingItemPersistence(
        ShoppingItemPersistence shoppingItemPersistence) {
        this.shoppingItemPersistence = shoppingItemPersistence;
    }

    /**
     * Returns the shopping item image local service.
     *
     * @return the shopping item image local service
     */
    public com.fsquare.shopping.service.ShoppingItemImageLocalService getShoppingItemImageLocalService() {
        return shoppingItemImageLocalService;
    }

    /**
     * Sets the shopping item image local service.
     *
     * @param shoppingItemImageLocalService the shopping item image local service
     */
    public void setShoppingItemImageLocalService(
        com.fsquare.shopping.service.ShoppingItemImageLocalService shoppingItemImageLocalService) {
        this.shoppingItemImageLocalService = shoppingItemImageLocalService;
    }

    /**
     * Returns the shopping item image persistence.
     *
     * @return the shopping item image persistence
     */
    public ShoppingItemImagePersistence getShoppingItemImagePersistence() {
        return shoppingItemImagePersistence;
    }

    /**
     * Sets the shopping item image persistence.
     *
     * @param shoppingItemImagePersistence the shopping item image persistence
     */
    public void setShoppingItemImagePersistence(
        ShoppingItemImagePersistence shoppingItemImagePersistence) {
        this.shoppingItemImagePersistence = shoppingItemImagePersistence;
    }

    /**
     * Returns the shopping item storage location local service.
     *
     * @return the shopping item storage location local service
     */
    public com.fsquare.shopping.service.ShoppingItemStorageLocationLocalService getShoppingItemStorageLocationLocalService() {
        return shoppingItemStorageLocationLocalService;
    }

    /**
     * Sets the shopping item storage location local service.
     *
     * @param shoppingItemStorageLocationLocalService the shopping item storage location local service
     */
    public void setShoppingItemStorageLocationLocalService(
        com.fsquare.shopping.service.ShoppingItemStorageLocationLocalService shoppingItemStorageLocationLocalService) {
        this.shoppingItemStorageLocationLocalService = shoppingItemStorageLocationLocalService;
    }

    /**
     * Returns the shopping item storage location remote service.
     *
     * @return the shopping item storage location remote service
     */
    public com.fsquare.shopping.service.ShoppingItemStorageLocationService getShoppingItemStorageLocationService() {
        return shoppingItemStorageLocationService;
    }

    /**
     * Sets the shopping item storage location remote service.
     *
     * @param shoppingItemStorageLocationService the shopping item storage location remote service
     */
    public void setShoppingItemStorageLocationService(
        com.fsquare.shopping.service.ShoppingItemStorageLocationService shoppingItemStorageLocationService) {
        this.shoppingItemStorageLocationService = shoppingItemStorageLocationService;
    }

    /**
     * Returns the shopping item storage location persistence.
     *
     * @return the shopping item storage location persistence
     */
    public ShoppingItemStorageLocationPersistence getShoppingItemStorageLocationPersistence() {
        return shoppingItemStorageLocationPersistence;
    }

    /**
     * Sets the shopping item storage location persistence.
     *
     * @param shoppingItemStorageLocationPersistence the shopping item storage location persistence
     */
    public void setShoppingItemStorageLocationPersistence(
        ShoppingItemStorageLocationPersistence shoppingItemStorageLocationPersistence) {
        this.shoppingItemStorageLocationPersistence = shoppingItemStorageLocationPersistence;
    }

    /**
     * Returns the shopping item type local service.
     *
     * @return the shopping item type local service
     */
    public com.fsquare.shopping.service.ShoppingItemTypeLocalService getShoppingItemTypeLocalService() {
        return shoppingItemTypeLocalService;
    }

    /**
     * Sets the shopping item type local service.
     *
     * @param shoppingItemTypeLocalService the shopping item type local service
     */
    public void setShoppingItemTypeLocalService(
        com.fsquare.shopping.service.ShoppingItemTypeLocalService shoppingItemTypeLocalService) {
        this.shoppingItemTypeLocalService = shoppingItemTypeLocalService;
    }

    /**
     * Returns the shopping item type remote service.
     *
     * @return the shopping item type remote service
     */
    public com.fsquare.shopping.service.ShoppingItemTypeService getShoppingItemTypeService() {
        return shoppingItemTypeService;
    }

    /**
     * Sets the shopping item type remote service.
     *
     * @param shoppingItemTypeService the shopping item type remote service
     */
    public void setShoppingItemTypeService(
        com.fsquare.shopping.service.ShoppingItemTypeService shoppingItemTypeService) {
        this.shoppingItemTypeService = shoppingItemTypeService;
    }

    /**
     * Returns the shopping item type persistence.
     *
     * @return the shopping item type persistence
     */
    public ShoppingItemTypePersistence getShoppingItemTypePersistence() {
        return shoppingItemTypePersistence;
    }

    /**
     * Sets the shopping item type persistence.
     *
     * @param shoppingItemTypePersistence the shopping item type persistence
     */
    public void setShoppingItemTypePersistence(
        ShoppingItemTypePersistence shoppingItemTypePersistence) {
        this.shoppingItemTypePersistence = shoppingItemTypePersistence;
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
     * Returns the shopping storage location local service.
     *
     * @return the shopping storage location local service
     */
    public com.fsquare.shopping.service.ShoppingStorageLocationLocalService getShoppingStorageLocationLocalService() {
        return shoppingStorageLocationLocalService;
    }

    /**
     * Sets the shopping storage location local service.
     *
     * @param shoppingStorageLocationLocalService the shopping storage location local service
     */
    public void setShoppingStorageLocationLocalService(
        com.fsquare.shopping.service.ShoppingStorageLocationLocalService shoppingStorageLocationLocalService) {
        this.shoppingStorageLocationLocalService = shoppingStorageLocationLocalService;
    }

    /**
     * Returns the shopping storage location remote service.
     *
     * @return the shopping storage location remote service
     */
    public com.fsquare.shopping.service.ShoppingStorageLocationService getShoppingStorageLocationService() {
        return shoppingStorageLocationService;
    }

    /**
     * Sets the shopping storage location remote service.
     *
     * @param shoppingStorageLocationService the shopping storage location remote service
     */
    public void setShoppingStorageLocationService(
        com.fsquare.shopping.service.ShoppingStorageLocationService shoppingStorageLocationService) {
        this.shoppingStorageLocationService = shoppingStorageLocationService;
    }

    /**
     * Returns the shopping storage location persistence.
     *
     * @return the shopping storage location persistence
     */
    public ShoppingStorageLocationPersistence getShoppingStorageLocationPersistence() {
        return shoppingStorageLocationPersistence;
    }

    /**
     * Sets the shopping storage location persistence.
     *
     * @param shoppingStorageLocationPersistence the shopping storage location persistence
     */
    public void setShoppingStorageLocationPersistence(
        ShoppingStorageLocationPersistence shoppingStorageLocationPersistence) {
        this.shoppingStorageLocationPersistence = shoppingStorageLocationPersistence;
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
     * Returns the site common actions local service.
     *
     * @return the site common actions local service
     */
    public com.fsquare.shopping.service.SiteCommonActionsLocalService getSiteCommonActionsLocalService() {
        return siteCommonActionsLocalService;
    }

    /**
     * Sets the site common actions local service.
     *
     * @param siteCommonActionsLocalService the site common actions local service
     */
    public void setSiteCommonActionsLocalService(
        com.fsquare.shopping.service.SiteCommonActionsLocalService siteCommonActionsLocalService) {
        this.siteCommonActionsLocalService = siteCommonActionsLocalService;
    }

    /**
     * Returns the site common actions remote service.
     *
     * @return the site common actions remote service
     */
    public com.fsquare.shopping.service.SiteCommonActionsService getSiteCommonActionsService() {
        return siteCommonActionsService;
    }

    /**
     * Sets the site common actions remote service.
     *
     * @param siteCommonActionsService the site common actions remote service
     */
    public void setSiteCommonActionsService(
        com.fsquare.shopping.service.SiteCommonActionsService siteCommonActionsService) {
        this.siteCommonActionsService = siteCommonActionsService;
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
    }

    public void destroy() {
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
