package com.fsquare.shopping.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.AttachedModel;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.StagedGroupedModel;
import com.liferay.portal.model.WorkflowedModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the ShoppingItem service. Represents a row in the &quot;FsquareShopping_ShoppingItem&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.fsquare.shopping.model.impl.ShoppingItemModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.fsquare.shopping.model.impl.ShoppingItemImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingItem
 * @see com.fsquare.shopping.model.impl.ShoppingItemImpl
 * @see com.fsquare.shopping.model.impl.ShoppingItemModelImpl
 * @generated
 */
public interface ShoppingItemModel extends AttachedModel, BaseModel<ShoppingItem>,
    StagedGroupedModel, WorkflowedModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a shopping item model instance should use the {@link ShoppingItem} interface instead.
     */

    /**
     * Returns the primary key of this shopping item.
     *
     * @return the primary key of this shopping item
     */
    public long getPrimaryKey();

    /**
     * Sets the primary key of this shopping item.
     *
     * @param primaryKey the primary key of this shopping item
     */
    public void setPrimaryKey(long primaryKey);

    /**
     * Returns the uuid of this shopping item.
     *
     * @return the uuid of this shopping item
     */
    @AutoEscape
    @Override
    public String getUuid();

    /**
     * Sets the uuid of this shopping item.
     *
     * @param uuid the uuid of this shopping item
     */
    @Override
    public void setUuid(String uuid);

    /**
     * Returns the item ID of this shopping item.
     *
     * @return the item ID of this shopping item
     */
    public long getItemId();

    /**
     * Sets the item ID of this shopping item.
     *
     * @param itemId the item ID of this shopping item
     */
    public void setItemId(long itemId);

    /**
     * Returns the group ID of this shopping item.
     *
     * @return the group ID of this shopping item
     */
    @Override
    public long getGroupId();

    /**
     * Sets the group ID of this shopping item.
     *
     * @param groupId the group ID of this shopping item
     */
    @Override
    public void setGroupId(long groupId);

    /**
     * Returns the company ID of this shopping item.
     *
     * @return the company ID of this shopping item
     */
    @Override
    public long getCompanyId();

    /**
     * Sets the company ID of this shopping item.
     *
     * @param companyId the company ID of this shopping item
     */
    @Override
    public void setCompanyId(long companyId);

    /**
     * Returns the user ID of this shopping item.
     *
     * @return the user ID of this shopping item
     */
    @Override
    public long getUserId();

    /**
     * Sets the user ID of this shopping item.
     *
     * @param userId the user ID of this shopping item
     */
    @Override
    public void setUserId(long userId);

    /**
     * Returns the user uuid of this shopping item.
     *
     * @return the user uuid of this shopping item
     * @throws SystemException if a system exception occurred
     */
    @Override
    public String getUserUuid() throws SystemException;

    /**
     * Sets the user uuid of this shopping item.
     *
     * @param userUuid the user uuid of this shopping item
     */
    @Override
    public void setUserUuid(String userUuid);

    /**
     * Returns the user name of this shopping item.
     *
     * @return the user name of this shopping item
     */
    @AutoEscape
    @Override
    public String getUserName();

    /**
     * Sets the user name of this shopping item.
     *
     * @param userName the user name of this shopping item
     */
    @Override
    public void setUserName(String userName);

    /**
     * Returns the create date of this shopping item.
     *
     * @return the create date of this shopping item
     */
    @Override
    public Date getCreateDate();

    /**
     * Sets the create date of this shopping item.
     *
     * @param createDate the create date of this shopping item
     */
    @Override
    public void setCreateDate(Date createDate);

    /**
     * Returns the modified date of this shopping item.
     *
     * @return the modified date of this shopping item
     */
    @Override
    public Date getModifiedDate();

    /**
     * Sets the modified date of this shopping item.
     *
     * @param modifiedDate the modified date of this shopping item
     */
    @Override
    public void setModifiedDate(Date modifiedDate);

    /**
     * Returns the fully qualified class name of this shopping item.
     *
     * @return the fully qualified class name of this shopping item
     */
    @Override
    public String getClassName();

    public void setClassName(String className);

    /**
     * Returns the class name ID of this shopping item.
     *
     * @return the class name ID of this shopping item
     */
    @Override
    public long getClassNameId();

    /**
     * Sets the class name ID of this shopping item.
     *
     * @param classNameId the class name ID of this shopping item
     */
    @Override
    public void setClassNameId(long classNameId);

    /**
     * Returns the class p k of this shopping item.
     *
     * @return the class p k of this shopping item
     */
    @Override
    public long getClassPK();

    /**
     * Sets the class p k of this shopping item.
     *
     * @param classPK the class p k of this shopping item
     */
    @Override
    public void setClassPK(long classPK);

    /**
     * Returns the title of this shopping item.
     *
     * @return the title of this shopping item
     */
    @AutoEscape
    public String getTitle();

    /**
     * Sets the title of this shopping item.
     *
     * @param title the title of this shopping item
     */
    public void setTitle(String title);

    /**
     * Returns the description of this shopping item.
     *
     * @return the description of this shopping item
     */
    @AutoEscape
    public String getDescription();

    /**
     * Sets the description of this shopping item.
     *
     * @param description the description of this shopping item
     */
    public void setDescription(String description);

    /**
     * Returns the price of this shopping item.
     *
     * @return the price of this shopping item
     */
    public double getPrice();

    /**
     * Sets the price of this shopping item.
     *
     * @param price the price of this shopping item
     */
    public void setPrice(double price);

    /**
     * Returns the discount price of this shopping item.
     *
     * @return the discount price of this shopping item
     */
    public double getDiscountPrice();

    /**
     * Sets the discount price of this shopping item.
     *
     * @param discountPrice the discount price of this shopping item
     */
    public void setDiscountPrice(double discountPrice);

    /**
     * Returns the sku of this shopping item.
     *
     * @return the sku of this shopping item
     */
    @AutoEscape
    public String getSku();

    /**
     * Sets the sku of this shopping item.
     *
     * @param sku the sku of this shopping item
     */
    public void setSku(String sku);

    /**
     * Returns the item type ID of this shopping item.
     *
     * @return the item type ID of this shopping item
     */
    public long getItemTypeId();

    /**
     * Sets the item type ID of this shopping item.
     *
     * @param itemTypeId the item type ID of this shopping item
     */
    public void setItemTypeId(long itemTypeId);

    /**
     * Returns the status of this shopping item.
     *
     * @return the status of this shopping item
     */
    @Override
    public int getStatus();

    /**
     * Sets the status of this shopping item.
     *
     * @param status the status of this shopping item
     */
    @Override
    public void setStatus(int status);

    /**
     * Returns the status by user ID of this shopping item.
     *
     * @return the status by user ID of this shopping item
     */
    @Override
    public long getStatusByUserId();

    /**
     * Sets the status by user ID of this shopping item.
     *
     * @param statusByUserId the status by user ID of this shopping item
     */
    @Override
    public void setStatusByUserId(long statusByUserId);

    /**
     * Returns the status by user uuid of this shopping item.
     *
     * @return the status by user uuid of this shopping item
     * @throws SystemException if a system exception occurred
     */
    @Override
    public String getStatusByUserUuid() throws SystemException;

    /**
     * Sets the status by user uuid of this shopping item.
     *
     * @param statusByUserUuid the status by user uuid of this shopping item
     */
    @Override
    public void setStatusByUserUuid(String statusByUserUuid);

    /**
     * Returns the status by user name of this shopping item.
     *
     * @return the status by user name of this shopping item
     */
    @AutoEscape
    @Override
    public String getStatusByUserName();

    /**
     * Sets the status by user name of this shopping item.
     *
     * @param statusByUserName the status by user name of this shopping item
     */
    @Override
    public void setStatusByUserName(String statusByUserName);

    /**
     * Returns the status date of this shopping item.
     *
     * @return the status date of this shopping item
     */
    @Override
    public Date getStatusDate();

    /**
     * Sets the status date of this shopping item.
     *
     * @param statusDate the status date of this shopping item
     */
    @Override
    public void setStatusDate(Date statusDate);

    /**
     * @deprecated As of 6.1.0, replaced by {@link #isApproved()}
     */
    @Override
    public boolean getApproved();

    /**
     * Returns <code>true</code> if this shopping item is approved.
     *
     * @return <code>true</code> if this shopping item is approved; <code>false</code> otherwise
     */
    @Override
    public boolean isApproved();

    /**
     * Returns <code>true</code> if this shopping item is denied.
     *
     * @return <code>true</code> if this shopping item is denied; <code>false</code> otherwise
     */
    @Override
    public boolean isDenied();

    /**
     * Returns <code>true</code> if this shopping item is a draft.
     *
     * @return <code>true</code> if this shopping item is a draft; <code>false</code> otherwise
     */
    @Override
    public boolean isDraft();

    /**
     * Returns <code>true</code> if this shopping item is expired.
     *
     * @return <code>true</code> if this shopping item is expired; <code>false</code> otherwise
     */
    @Override
    public boolean isExpired();

    /**
     * Returns <code>true</code> if this shopping item is inactive.
     *
     * @return <code>true</code> if this shopping item is inactive; <code>false</code> otherwise
     */
    @Override
    public boolean isInactive();

    /**
     * Returns <code>true</code> if this shopping item is incomplete.
     *
     * @return <code>true</code> if this shopping item is incomplete; <code>false</code> otherwise
     */
    @Override
    public boolean isIncomplete();

    /**
     * Returns <code>true</code> if this shopping item is pending.
     *
     * @return <code>true</code> if this shopping item is pending; <code>false</code> otherwise
     */
    @Override
    public boolean isPending();

    /**
     * Returns <code>true</code> if this shopping item is scheduled.
     *
     * @return <code>true</code> if this shopping item is scheduled; <code>false</code> otherwise
     */
    @Override
    public boolean isScheduled();

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
    public int compareTo(com.fsquare.shopping.model.ShoppingItem shoppingItem);

    @Override
    public int hashCode();

    @Override
    public CacheModel<com.fsquare.shopping.model.ShoppingItem> toCacheModel();

    @Override
    public com.fsquare.shopping.model.ShoppingItem toEscapedModel();

    @Override
    public com.fsquare.shopping.model.ShoppingItem toUnescapedModel();

    @Override
    public String toString();

    @Override
    public String toXmlString();
}
