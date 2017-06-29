package com.fsquare.shopping.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.AuditedModel;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the ShoppingCoupon service. Represents a row in the &quot;FsquareShopping_ShoppingCoupon&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.fsquare.shopping.model.impl.ShoppingCouponModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.fsquare.shopping.model.impl.ShoppingCouponImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingCoupon
 * @see com.fsquare.shopping.model.impl.ShoppingCouponImpl
 * @see com.fsquare.shopping.model.impl.ShoppingCouponModelImpl
 * @generated
 */
public interface ShoppingCouponModel extends AuditedModel,
    BaseModel<ShoppingCoupon> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a shopping coupon model instance should use the {@link ShoppingCoupon} interface instead.
     */

    /**
     * Returns the primary key of this shopping coupon.
     *
     * @return the primary key of this shopping coupon
     */
    public long getPrimaryKey();

    /**
     * Sets the primary key of this shopping coupon.
     *
     * @param primaryKey the primary key of this shopping coupon
     */
    public void setPrimaryKey(long primaryKey);

    /**
     * Returns the coupon ID of this shopping coupon.
     *
     * @return the coupon ID of this shopping coupon
     */
    public long getCouponId();

    /**
     * Sets the coupon ID of this shopping coupon.
     *
     * @param couponId the coupon ID of this shopping coupon
     */
    public void setCouponId(long couponId);

    /**
     * Returns the company ID of this shopping coupon.
     *
     * @return the company ID of this shopping coupon
     */
    @Override
    public long getCompanyId();

    /**
     * Sets the company ID of this shopping coupon.
     *
     * @param companyId the company ID of this shopping coupon
     */
    @Override
    public void setCompanyId(long companyId);

    /**
     * Returns the user ID of this shopping coupon.
     *
     * @return the user ID of this shopping coupon
     */
    @Override
    public long getUserId();

    /**
     * Sets the user ID of this shopping coupon.
     *
     * @param userId the user ID of this shopping coupon
     */
    @Override
    public void setUserId(long userId);

    /**
     * Returns the user uuid of this shopping coupon.
     *
     * @return the user uuid of this shopping coupon
     * @throws SystemException if a system exception occurred
     */
    @Override
    public String getUserUuid() throws SystemException;

    /**
     * Sets the user uuid of this shopping coupon.
     *
     * @param userUuid the user uuid of this shopping coupon
     */
    @Override
    public void setUserUuid(String userUuid);

    /**
     * Returns the user name of this shopping coupon.
     *
     * @return the user name of this shopping coupon
     */
    @AutoEscape
    @Override
    public String getUserName();

    /**
     * Sets the user name of this shopping coupon.
     *
     * @param userName the user name of this shopping coupon
     */
    @Override
    public void setUserName(String userName);

    /**
     * Returns the create date of this shopping coupon.
     *
     * @return the create date of this shopping coupon
     */
    @Override
    public Date getCreateDate();

    /**
     * Sets the create date of this shopping coupon.
     *
     * @param createDate the create date of this shopping coupon
     */
    @Override
    public void setCreateDate(Date createDate);

    /**
     * Returns the modified date of this shopping coupon.
     *
     * @return the modified date of this shopping coupon
     */
    @Override
    public Date getModifiedDate();

    /**
     * Sets the modified date of this shopping coupon.
     *
     * @param modifiedDate the modified date of this shopping coupon
     */
    @Override
    public void setModifiedDate(Date modifiedDate);

    /**
     * Returns the code of this shopping coupon.
     *
     * @return the code of this shopping coupon
     */
    @AutoEscape
    public String getCode();

    /**
     * Sets the code of this shopping coupon.
     *
     * @param code the code of this shopping coupon
     */
    public void setCode(String code);

    /**
     * Returns the name of this shopping coupon.
     *
     * @return the name of this shopping coupon
     */
    @AutoEscape
    public String getName();

    /**
     * Sets the name of this shopping coupon.
     *
     * @param name the name of this shopping coupon
     */
    public void setName(String name);

    /**
     * Returns the description of this shopping coupon.
     *
     * @return the description of this shopping coupon
     */
    @AutoEscape
    public String getDescription();

    /**
     * Sets the description of this shopping coupon.
     *
     * @param description the description of this shopping coupon
     */
    public void setDescription(String description);

    /**
     * Returns the start date of this shopping coupon.
     *
     * @return the start date of this shopping coupon
     */
    public Date getStartDate();

    /**
     * Sets the start date of this shopping coupon.
     *
     * @param startDate the start date of this shopping coupon
     */
    public void setStartDate(Date startDate);

    /**
     * Returns the end date of this shopping coupon.
     *
     * @return the end date of this shopping coupon
     */
    public Date getEndDate();

    /**
     * Sets the end date of this shopping coupon.
     *
     * @param endDate the end date of this shopping coupon
     */
    public void setEndDate(Date endDate);

    /**
     * Returns the active of this shopping coupon.
     *
     * @return the active of this shopping coupon
     */
    public boolean getActive();

    /**
     * Returns <code>true</code> if this shopping coupon is active.
     *
     * @return <code>true</code> if this shopping coupon is active; <code>false</code> otherwise
     */
    public boolean isActive();

    /**
     * Sets whether this shopping coupon is active.
     *
     * @param active the active of this shopping coupon
     */
    public void setActive(boolean active);

    /**
     * Returns the limit categories of this shopping coupon.
     *
     * @return the limit categories of this shopping coupon
     */
    @AutoEscape
    public String getLimitCategories();

    /**
     * Sets the limit categories of this shopping coupon.
     *
     * @param limitCategories the limit categories of this shopping coupon
     */
    public void setLimitCategories(String limitCategories);

    /**
     * Returns the limit skus of this shopping coupon.
     *
     * @return the limit skus of this shopping coupon
     */
    @AutoEscape
    public String getLimitSkus();

    /**
     * Sets the limit skus of this shopping coupon.
     *
     * @param limitSkus the limit skus of this shopping coupon
     */
    public void setLimitSkus(String limitSkus);

    /**
     * Returns the min order of this shopping coupon.
     *
     * @return the min order of this shopping coupon
     */
    public double getMinOrder();

    /**
     * Sets the min order of this shopping coupon.
     *
     * @param minOrder the min order of this shopping coupon
     */
    public void setMinOrder(double minOrder);

    /**
     * Returns the discount of this shopping coupon.
     *
     * @return the discount of this shopping coupon
     */
    public double getDiscount();

    /**
     * Sets the discount of this shopping coupon.
     *
     * @param discount the discount of this shopping coupon
     */
    public void setDiscount(double discount);

    /**
     * Returns the discount type of this shopping coupon.
     *
     * @return the discount type of this shopping coupon
     */
    @AutoEscape
    public String getDiscountType();

    /**
     * Sets the discount type of this shopping coupon.
     *
     * @param discountType the discount type of this shopping coupon
     */
    public void setDiscountType(String discountType);

    /**
     * Returns the max uses of this shopping coupon.
     *
     * @return the max uses of this shopping coupon
     */
    public long getMaxUses();

    /**
     * Sets the max uses of this shopping coupon.
     *
     * @param maxUses the max uses of this shopping coupon
     */
    public void setMaxUses(long maxUses);

    @Override
    public boolean isNew();

    @Override
    public void setNew(boolean n);

    @Override
    public boolean isCachedModel();

    @Override
    public void setCachedModel(boolean cachedModel);

    @Override
    public boolean isEscapedModel();

    @Override
    public Serializable getPrimaryKeyObj();

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj);

    @Override
    public ExpandoBridge getExpandoBridge();

    @Override
    public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

    @Override
    public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext);

    @Override
    public Object clone();

    @Override
    public int compareTo(
        com.fsquare.shopping.model.ShoppingCoupon shoppingCoupon);

    @Override
    public int hashCode();

    @Override
    public CacheModel<com.fsquare.shopping.model.ShoppingCoupon> toCacheModel();

    @Override
    public com.fsquare.shopping.model.ShoppingCoupon toEscapedModel();

    @Override
    public com.fsquare.shopping.model.ShoppingCoupon toUnescapedModel();

    @Override
    public String toString();

    @Override
    public String toXmlString();
}
