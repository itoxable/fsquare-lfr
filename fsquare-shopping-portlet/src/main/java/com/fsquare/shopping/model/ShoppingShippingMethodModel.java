package com.fsquare.shopping.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.GroupedModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the ShoppingShippingMethod service. Represents a row in the &quot;FsquareShopping_ShoppingShippingMethod&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.fsquare.shopping.model.impl.ShoppingShippingMethodModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.fsquare.shopping.model.impl.ShoppingShippingMethodImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingShippingMethod
 * @see com.fsquare.shopping.model.impl.ShoppingShippingMethodImpl
 * @see com.fsquare.shopping.model.impl.ShoppingShippingMethodModelImpl
 * @generated
 */
public interface ShoppingShippingMethodModel extends BaseModel<ShoppingShippingMethod>,
    GroupedModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a shopping shipping method model instance should use the {@link ShoppingShippingMethod} interface instead.
     */

    /**
     * Returns the primary key of this shopping shipping method.
     *
     * @return the primary key of this shopping shipping method
     */
    public long getPrimaryKey();

    /**
     * Sets the primary key of this shopping shipping method.
     *
     * @param primaryKey the primary key of this shopping shipping method
     */
    public void setPrimaryKey(long primaryKey);

    /**
     * Returns the shipping method ID of this shopping shipping method.
     *
     * @return the shipping method ID of this shopping shipping method
     */
    public long getShippingMethodId();

    /**
     * Sets the shipping method ID of this shopping shipping method.
     *
     * @param shippingMethodId the shipping method ID of this shopping shipping method
     */
    public void setShippingMethodId(long shippingMethodId);

    /**
     * Returns the group ID of this shopping shipping method.
     *
     * @return the group ID of this shopping shipping method
     */
    @Override
    public long getGroupId();

    /**
     * Sets the group ID of this shopping shipping method.
     *
     * @param groupId the group ID of this shopping shipping method
     */
    @Override
    public void setGroupId(long groupId);

    /**
     * Returns the company ID of this shopping shipping method.
     *
     * @return the company ID of this shopping shipping method
     */
    @Override
    public long getCompanyId();

    /**
     * Sets the company ID of this shopping shipping method.
     *
     * @param companyId the company ID of this shopping shipping method
     */
    @Override
    public void setCompanyId(long companyId);

    /**
     * Returns the user ID of this shopping shipping method.
     *
     * @return the user ID of this shopping shipping method
     */
    @Override
    public long getUserId();

    /**
     * Sets the user ID of this shopping shipping method.
     *
     * @param userId the user ID of this shopping shipping method
     */
    @Override
    public void setUserId(long userId);

    /**
     * Returns the user uuid of this shopping shipping method.
     *
     * @return the user uuid of this shopping shipping method
     * @throws SystemException if a system exception occurred
     */
    @Override
    public String getUserUuid() throws SystemException;

    /**
     * Sets the user uuid of this shopping shipping method.
     *
     * @param userUuid the user uuid of this shopping shipping method
     */
    @Override
    public void setUserUuid(String userUuid);

    /**
     * Returns the user name of this shopping shipping method.
     *
     * @return the user name of this shopping shipping method
     */
    @AutoEscape
    @Override
    public String getUserName();

    /**
     * Sets the user name of this shopping shipping method.
     *
     * @param userName the user name of this shopping shipping method
     */
    @Override
    public void setUserName(String userName);

    /**
     * Returns the create date of this shopping shipping method.
     *
     * @return the create date of this shopping shipping method
     */
    @Override
    public Date getCreateDate();

    /**
     * Sets the create date of this shopping shipping method.
     *
     * @param createDate the create date of this shopping shipping method
     */
    @Override
    public void setCreateDate(Date createDate);

    /**
     * Returns the modified date of this shopping shipping method.
     *
     * @return the modified date of this shopping shipping method
     */
    @Override
    public Date getModifiedDate();

    /**
     * Sets the modified date of this shopping shipping method.
     *
     * @param modifiedDate the modified date of this shopping shipping method
     */
    @Override
    public void setModifiedDate(Date modifiedDate);

    /**
     * Returns the price of this shopping shipping method.
     *
     * @return the price of this shopping shipping method
     */
    public double getPrice();

    /**
     * Sets the price of this shopping shipping method.
     *
     * @param price the price of this shopping shipping method
     */
    public void setPrice(double price);

    /**
     * Returns the name of this shopping shipping method.
     *
     * @return the name of this shopping shipping method
     */
    @AutoEscape
    public String getName();

    /**
     * Sets the name of this shopping shipping method.
     *
     * @param name the name of this shopping shipping method
     */
    public void setName(String name);

    /**
     * Returns the method name of this shopping shipping method.
     *
     * @return the method name of this shopping shipping method
     */
    @AutoEscape
    public String getMethodName();

    /**
     * Sets the method name of this shopping shipping method.
     *
     * @param methodName the method name of this shopping shipping method
     */
    public void setMethodName(String methodName);

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
        com.fsquare.shopping.model.ShoppingShippingMethod shoppingShippingMethod);

    @Override
    public int hashCode();

    @Override
    public CacheModel<com.fsquare.shopping.model.ShoppingShippingMethod> toCacheModel();

    @Override
    public com.fsquare.shopping.model.ShoppingShippingMethod toEscapedModel();

    @Override
    public com.fsquare.shopping.model.ShoppingShippingMethod toUnescapedModel();

    @Override
    public String toString();

    @Override
    public String toXmlString();
}
