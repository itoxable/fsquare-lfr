package com.fsquare.shopping.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ShoppingOrder}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingOrder
 * @generated
 */
public class ShoppingOrderWrapper implements ShoppingOrder,
    ModelWrapper<ShoppingOrder> {
    private ShoppingOrder _shoppingOrder;

    public ShoppingOrderWrapper(ShoppingOrder shoppingOrder) {
        _shoppingOrder = shoppingOrder;
    }

    @Override
    public Class<?> getModelClass() {
        return ShoppingOrder.class;
    }

    @Override
    public String getModelClassName() {
        return ShoppingOrder.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("shoppingOrderId", getShoppingOrderId());
        attributes.put("groupId", getGroupId());
        attributes.put("companyId", getCompanyId());
        attributes.put("userId", getUserId());
        attributes.put("userName", getUserName());
        attributes.put("createDate", getCreateDate());
        attributes.put("modifiedDate", getModifiedDate());
        attributes.put("status", getStatus());
        attributes.put("number", getNumber());
        attributes.put("tax", getTax());
        attributes.put("shipping", getShipping());
        attributes.put("totalPrice", getTotalPrice());
        attributes.put("altShipping", getAltShipping());
        attributes.put("requiresShipping", getRequiresShipping());
        attributes.put("insure", getInsure());
        attributes.put("insurance", getInsurance());
        attributes.put("couponCodes", getCouponCodes());
        attributes.put("couponDiscount", getCouponDiscount());
        attributes.put("paymentStatus", getPaymentStatus());
        attributes.put("billingFirstName", getBillingFirstName());
        attributes.put("billingLastName", getBillingLastName());
        attributes.put("billingEmailAddress", getBillingEmailAddress());
        attributes.put("billingCompany", getBillingCompany());
        attributes.put("billingStreet", getBillingStreet());
        attributes.put("billingCity", getBillingCity());
        attributes.put("billingState", getBillingState());
        attributes.put("billingZip", getBillingZip());
        attributes.put("billingCountry", getBillingCountry());
        attributes.put("billingPhone", getBillingPhone());
        attributes.put("shipToBilling", getShipToBilling());
        attributes.put("shippingFirstName", getShippingFirstName());
        attributes.put("shippingLastName", getShippingLastName());
        attributes.put("shippingEmailAddress", getShippingEmailAddress());
        attributes.put("shippingCompany", getShippingCompany());
        attributes.put("shippingStreet", getShippingStreet());
        attributes.put("shippingStreet2", getShippingStreet2());
        attributes.put("shippingCity", getShippingCity());
        attributes.put("shippingState", getShippingState());
        attributes.put("shippingPostCode", getShippingPostCode());
        attributes.put("shippingCountry", getShippingCountry());
        attributes.put("shippingPhone", getShippingPhone());
        attributes.put("comments", getComments());
        attributes.put("externalPaymentId", getExternalPaymentId());
        attributes.put("paymentType", getPaymentType());
        attributes.put("sendOrderEmail", getSendOrderEmail());
        attributes.put("sendShippingEmail", getSendShippingEmail());
        attributes.put("shippingMethodId", getShippingMethodId());
        attributes.put("international", getInternational());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long shoppingOrderId = (Long) attributes.get("shoppingOrderId");

        if (shoppingOrderId != null) {
            setShoppingOrderId(shoppingOrderId);
        }

        Long groupId = (Long) attributes.get("groupId");

        if (groupId != null) {
            setGroupId(groupId);
        }

        Long companyId = (Long) attributes.get("companyId");

        if (companyId != null) {
            setCompanyId(companyId);
        }

        Long userId = (Long) attributes.get("userId");

        if (userId != null) {
            setUserId(userId);
        }

        String userName = (String) attributes.get("userName");

        if (userName != null) {
            setUserName(userName);
        }

        Date createDate = (Date) attributes.get("createDate");

        if (createDate != null) {
            setCreateDate(createDate);
        }

        Date modifiedDate = (Date) attributes.get("modifiedDate");

        if (modifiedDate != null) {
            setModifiedDate(modifiedDate);
        }

        String status = (String) attributes.get("status");

        if (status != null) {
            setStatus(status);
        }

        String number = (String) attributes.get("number");

        if (number != null) {
            setNumber(number);
        }

        Double tax = (Double) attributes.get("tax");

        if (tax != null) {
            setTax(tax);
        }

        Double shipping = (Double) attributes.get("shipping");

        if (shipping != null) {
            setShipping(shipping);
        }

        Double totalPrice = (Double) attributes.get("totalPrice");

        if (totalPrice != null) {
            setTotalPrice(totalPrice);
        }

        String altShipping = (String) attributes.get("altShipping");

        if (altShipping != null) {
            setAltShipping(altShipping);
        }

        Boolean requiresShipping = (Boolean) attributes.get("requiresShipping");

        if (requiresShipping != null) {
            setRequiresShipping(requiresShipping);
        }

        Boolean insure = (Boolean) attributes.get("insure");

        if (insure != null) {
            setInsure(insure);
        }

        Double insurance = (Double) attributes.get("insurance");

        if (insurance != null) {
            setInsurance(insurance);
        }

        String couponCodes = (String) attributes.get("couponCodes");

        if (couponCodes != null) {
            setCouponCodes(couponCodes);
        }

        Double couponDiscount = (Double) attributes.get("couponDiscount");

        if (couponDiscount != null) {
            setCouponDiscount(couponDiscount);
        }

        String paymentStatus = (String) attributes.get("paymentStatus");

        if (paymentStatus != null) {
            setPaymentStatus(paymentStatus);
        }

        String billingFirstName = (String) attributes.get("billingFirstName");

        if (billingFirstName != null) {
            setBillingFirstName(billingFirstName);
        }

        String billingLastName = (String) attributes.get("billingLastName");

        if (billingLastName != null) {
            setBillingLastName(billingLastName);
        }

        String billingEmailAddress = (String) attributes.get(
                "billingEmailAddress");

        if (billingEmailAddress != null) {
            setBillingEmailAddress(billingEmailAddress);
        }

        String billingCompany = (String) attributes.get("billingCompany");

        if (billingCompany != null) {
            setBillingCompany(billingCompany);
        }

        String billingStreet = (String) attributes.get("billingStreet");

        if (billingStreet != null) {
            setBillingStreet(billingStreet);
        }

        String billingCity = (String) attributes.get("billingCity");

        if (billingCity != null) {
            setBillingCity(billingCity);
        }

        String billingState = (String) attributes.get("billingState");

        if (billingState != null) {
            setBillingState(billingState);
        }

        String billingZip = (String) attributes.get("billingZip");

        if (billingZip != null) {
            setBillingZip(billingZip);
        }

        String billingCountry = (String) attributes.get("billingCountry");

        if (billingCountry != null) {
            setBillingCountry(billingCountry);
        }

        String billingPhone = (String) attributes.get("billingPhone");

        if (billingPhone != null) {
            setBillingPhone(billingPhone);
        }

        Boolean shipToBilling = (Boolean) attributes.get("shipToBilling");

        if (shipToBilling != null) {
            setShipToBilling(shipToBilling);
        }

        String shippingFirstName = (String) attributes.get("shippingFirstName");

        if (shippingFirstName != null) {
            setShippingFirstName(shippingFirstName);
        }

        String shippingLastName = (String) attributes.get("shippingLastName");

        if (shippingLastName != null) {
            setShippingLastName(shippingLastName);
        }

        String shippingEmailAddress = (String) attributes.get(
                "shippingEmailAddress");

        if (shippingEmailAddress != null) {
            setShippingEmailAddress(shippingEmailAddress);
        }

        String shippingCompany = (String) attributes.get("shippingCompany");

        if (shippingCompany != null) {
            setShippingCompany(shippingCompany);
        }

        String shippingStreet = (String) attributes.get("shippingStreet");

        if (shippingStreet != null) {
            setShippingStreet(shippingStreet);
        }

        String shippingStreet2 = (String) attributes.get("shippingStreet2");

        if (shippingStreet2 != null) {
            setShippingStreet2(shippingStreet2);
        }

        String shippingCity = (String) attributes.get("shippingCity");

        if (shippingCity != null) {
            setShippingCity(shippingCity);
        }

        String shippingState = (String) attributes.get("shippingState");

        if (shippingState != null) {
            setShippingState(shippingState);
        }

        String shippingPostCode = (String) attributes.get("shippingPostCode");

        if (shippingPostCode != null) {
            setShippingPostCode(shippingPostCode);
        }

        String shippingCountry = (String) attributes.get("shippingCountry");

        if (shippingCountry != null) {
            setShippingCountry(shippingCountry);
        }

        String shippingPhone = (String) attributes.get("shippingPhone");

        if (shippingPhone != null) {
            setShippingPhone(shippingPhone);
        }

        String comments = (String) attributes.get("comments");

        if (comments != null) {
            setComments(comments);
        }

        String externalPaymentId = (String) attributes.get("externalPaymentId");

        if (externalPaymentId != null) {
            setExternalPaymentId(externalPaymentId);
        }

        String paymentType = (String) attributes.get("paymentType");

        if (paymentType != null) {
            setPaymentType(paymentType);
        }

        Boolean sendOrderEmail = (Boolean) attributes.get("sendOrderEmail");

        if (sendOrderEmail != null) {
            setSendOrderEmail(sendOrderEmail);
        }

        Boolean sendShippingEmail = (Boolean) attributes.get(
                "sendShippingEmail");

        if (sendShippingEmail != null) {
            setSendShippingEmail(sendShippingEmail);
        }

        Long shippingMethodId = (Long) attributes.get("shippingMethodId");

        if (shippingMethodId != null) {
            setShippingMethodId(shippingMethodId);
        }

        Boolean international = (Boolean) attributes.get("international");

        if (international != null) {
            setInternational(international);
        }
    }

    /**
    * Returns the primary key of this shopping order.
    *
    * @return the primary key of this shopping order
    */
    @Override
    public long getPrimaryKey() {
        return _shoppingOrder.getPrimaryKey();
    }

    /**
    * Sets the primary key of this shopping order.
    *
    * @param primaryKey the primary key of this shopping order
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _shoppingOrder.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the shopping order ID of this shopping order.
    *
    * @return the shopping order ID of this shopping order
    */
    @Override
    public long getShoppingOrderId() {
        return _shoppingOrder.getShoppingOrderId();
    }

    /**
    * Sets the shopping order ID of this shopping order.
    *
    * @param shoppingOrderId the shopping order ID of this shopping order
    */
    @Override
    public void setShoppingOrderId(long shoppingOrderId) {
        _shoppingOrder.setShoppingOrderId(shoppingOrderId);
    }

    /**
    * Returns the group ID of this shopping order.
    *
    * @return the group ID of this shopping order
    */
    @Override
    public long getGroupId() {
        return _shoppingOrder.getGroupId();
    }

    /**
    * Sets the group ID of this shopping order.
    *
    * @param groupId the group ID of this shopping order
    */
    @Override
    public void setGroupId(long groupId) {
        _shoppingOrder.setGroupId(groupId);
    }

    /**
    * Returns the company ID of this shopping order.
    *
    * @return the company ID of this shopping order
    */
    @Override
    public long getCompanyId() {
        return _shoppingOrder.getCompanyId();
    }

    /**
    * Sets the company ID of this shopping order.
    *
    * @param companyId the company ID of this shopping order
    */
    @Override
    public void setCompanyId(long companyId) {
        _shoppingOrder.setCompanyId(companyId);
    }

    /**
    * Returns the user ID of this shopping order.
    *
    * @return the user ID of this shopping order
    */
    @Override
    public long getUserId() {
        return _shoppingOrder.getUserId();
    }

    /**
    * Sets the user ID of this shopping order.
    *
    * @param userId the user ID of this shopping order
    */
    @Override
    public void setUserId(long userId) {
        _shoppingOrder.setUserId(userId);
    }

    /**
    * Returns the user uuid of this shopping order.
    *
    * @return the user uuid of this shopping order
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.lang.String getUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _shoppingOrder.getUserUuid();
    }

    /**
    * Sets the user uuid of this shopping order.
    *
    * @param userUuid the user uuid of this shopping order
    */
    @Override
    public void setUserUuid(java.lang.String userUuid) {
        _shoppingOrder.setUserUuid(userUuid);
    }

    /**
    * Returns the user name of this shopping order.
    *
    * @return the user name of this shopping order
    */
    @Override
    public java.lang.String getUserName() {
        return _shoppingOrder.getUserName();
    }

    /**
    * Sets the user name of this shopping order.
    *
    * @param userName the user name of this shopping order
    */
    @Override
    public void setUserName(java.lang.String userName) {
        _shoppingOrder.setUserName(userName);
    }

    /**
    * Returns the create date of this shopping order.
    *
    * @return the create date of this shopping order
    */
    @Override
    public java.util.Date getCreateDate() {
        return _shoppingOrder.getCreateDate();
    }

    /**
    * Sets the create date of this shopping order.
    *
    * @param createDate the create date of this shopping order
    */
    @Override
    public void setCreateDate(java.util.Date createDate) {
        _shoppingOrder.setCreateDate(createDate);
    }

    /**
    * Returns the modified date of this shopping order.
    *
    * @return the modified date of this shopping order
    */
    @Override
    public java.util.Date getModifiedDate() {
        return _shoppingOrder.getModifiedDate();
    }

    /**
    * Sets the modified date of this shopping order.
    *
    * @param modifiedDate the modified date of this shopping order
    */
    @Override
    public void setModifiedDate(java.util.Date modifiedDate) {
        _shoppingOrder.setModifiedDate(modifiedDate);
    }

    /**
    * Returns the status of this shopping order.
    *
    * @return the status of this shopping order
    */
    @Override
    public java.lang.String getStatus() {
        return _shoppingOrder.getStatus();
    }

    /**
    * Sets the status of this shopping order.
    *
    * @param status the status of this shopping order
    */
    @Override
    public void setStatus(java.lang.String status) {
        _shoppingOrder.setStatus(status);
    }

    /**
    * Returns the number of this shopping order.
    *
    * @return the number of this shopping order
    */
    @Override
    public java.lang.String getNumber() {
        return _shoppingOrder.getNumber();
    }

    /**
    * Sets the number of this shopping order.
    *
    * @param number the number of this shopping order
    */
    @Override
    public void setNumber(java.lang.String number) {
        _shoppingOrder.setNumber(number);
    }

    /**
    * Returns the tax of this shopping order.
    *
    * @return the tax of this shopping order
    */
    @Override
    public double getTax() {
        return _shoppingOrder.getTax();
    }

    /**
    * Sets the tax of this shopping order.
    *
    * @param tax the tax of this shopping order
    */
    @Override
    public void setTax(double tax) {
        _shoppingOrder.setTax(tax);
    }

    /**
    * Returns the shipping of this shopping order.
    *
    * @return the shipping of this shopping order
    */
    @Override
    public double getShipping() {
        return _shoppingOrder.getShipping();
    }

    /**
    * Sets the shipping of this shopping order.
    *
    * @param shipping the shipping of this shopping order
    */
    @Override
    public void setShipping(double shipping) {
        _shoppingOrder.setShipping(shipping);
    }

    /**
    * Returns the total price of this shopping order.
    *
    * @return the total price of this shopping order
    */
    @Override
    public double getTotalPrice() {
        return _shoppingOrder.getTotalPrice();
    }

    /**
    * Sets the total price of this shopping order.
    *
    * @param totalPrice the total price of this shopping order
    */
    @Override
    public void setTotalPrice(double totalPrice) {
        _shoppingOrder.setTotalPrice(totalPrice);
    }

    /**
    * Returns the alt shipping of this shopping order.
    *
    * @return the alt shipping of this shopping order
    */
    @Override
    public java.lang.String getAltShipping() {
        return _shoppingOrder.getAltShipping();
    }

    /**
    * Sets the alt shipping of this shopping order.
    *
    * @param altShipping the alt shipping of this shopping order
    */
    @Override
    public void setAltShipping(java.lang.String altShipping) {
        _shoppingOrder.setAltShipping(altShipping);
    }

    /**
    * Returns the requires shipping of this shopping order.
    *
    * @return the requires shipping of this shopping order
    */
    @Override
    public boolean getRequiresShipping() {
        return _shoppingOrder.getRequiresShipping();
    }

    /**
    * Returns <code>true</code> if this shopping order is requires shipping.
    *
    * @return <code>true</code> if this shopping order is requires shipping; <code>false</code> otherwise
    */
    @Override
    public boolean isRequiresShipping() {
        return _shoppingOrder.isRequiresShipping();
    }

    /**
    * Sets whether this shopping order is requires shipping.
    *
    * @param requiresShipping the requires shipping of this shopping order
    */
    @Override
    public void setRequiresShipping(boolean requiresShipping) {
        _shoppingOrder.setRequiresShipping(requiresShipping);
    }

    /**
    * Returns the insure of this shopping order.
    *
    * @return the insure of this shopping order
    */
    @Override
    public boolean getInsure() {
        return _shoppingOrder.getInsure();
    }

    /**
    * Returns <code>true</code> if this shopping order is insure.
    *
    * @return <code>true</code> if this shopping order is insure; <code>false</code> otherwise
    */
    @Override
    public boolean isInsure() {
        return _shoppingOrder.isInsure();
    }

    /**
    * Sets whether this shopping order is insure.
    *
    * @param insure the insure of this shopping order
    */
    @Override
    public void setInsure(boolean insure) {
        _shoppingOrder.setInsure(insure);
    }

    /**
    * Returns the insurance of this shopping order.
    *
    * @return the insurance of this shopping order
    */
    @Override
    public double getInsurance() {
        return _shoppingOrder.getInsurance();
    }

    /**
    * Sets the insurance of this shopping order.
    *
    * @param insurance the insurance of this shopping order
    */
    @Override
    public void setInsurance(double insurance) {
        _shoppingOrder.setInsurance(insurance);
    }

    /**
    * Returns the coupon codes of this shopping order.
    *
    * @return the coupon codes of this shopping order
    */
    @Override
    public java.lang.String getCouponCodes() {
        return _shoppingOrder.getCouponCodes();
    }

    /**
    * Sets the coupon codes of this shopping order.
    *
    * @param couponCodes the coupon codes of this shopping order
    */
    @Override
    public void setCouponCodes(java.lang.String couponCodes) {
        _shoppingOrder.setCouponCodes(couponCodes);
    }

    /**
    * Returns the coupon discount of this shopping order.
    *
    * @return the coupon discount of this shopping order
    */
    @Override
    public double getCouponDiscount() {
        return _shoppingOrder.getCouponDiscount();
    }

    /**
    * Sets the coupon discount of this shopping order.
    *
    * @param couponDiscount the coupon discount of this shopping order
    */
    @Override
    public void setCouponDiscount(double couponDiscount) {
        _shoppingOrder.setCouponDiscount(couponDiscount);
    }

    /**
    * Returns the payment status of this shopping order.
    *
    * @return the payment status of this shopping order
    */
    @Override
    public java.lang.String getPaymentStatus() {
        return _shoppingOrder.getPaymentStatus();
    }

    /**
    * Sets the payment status of this shopping order.
    *
    * @param paymentStatus the payment status of this shopping order
    */
    @Override
    public void setPaymentStatus(java.lang.String paymentStatus) {
        _shoppingOrder.setPaymentStatus(paymentStatus);
    }

    /**
    * Returns the billing first name of this shopping order.
    *
    * @return the billing first name of this shopping order
    */
    @Override
    public java.lang.String getBillingFirstName() {
        return _shoppingOrder.getBillingFirstName();
    }

    /**
    * Sets the billing first name of this shopping order.
    *
    * @param billingFirstName the billing first name of this shopping order
    */
    @Override
    public void setBillingFirstName(java.lang.String billingFirstName) {
        _shoppingOrder.setBillingFirstName(billingFirstName);
    }

    /**
    * Returns the billing last name of this shopping order.
    *
    * @return the billing last name of this shopping order
    */
    @Override
    public java.lang.String getBillingLastName() {
        return _shoppingOrder.getBillingLastName();
    }

    /**
    * Sets the billing last name of this shopping order.
    *
    * @param billingLastName the billing last name of this shopping order
    */
    @Override
    public void setBillingLastName(java.lang.String billingLastName) {
        _shoppingOrder.setBillingLastName(billingLastName);
    }

    /**
    * Returns the billing email address of this shopping order.
    *
    * @return the billing email address of this shopping order
    */
    @Override
    public java.lang.String getBillingEmailAddress() {
        return _shoppingOrder.getBillingEmailAddress();
    }

    /**
    * Sets the billing email address of this shopping order.
    *
    * @param billingEmailAddress the billing email address of this shopping order
    */
    @Override
    public void setBillingEmailAddress(java.lang.String billingEmailAddress) {
        _shoppingOrder.setBillingEmailAddress(billingEmailAddress);
    }

    /**
    * Returns the billing company of this shopping order.
    *
    * @return the billing company of this shopping order
    */
    @Override
    public java.lang.String getBillingCompany() {
        return _shoppingOrder.getBillingCompany();
    }

    /**
    * Sets the billing company of this shopping order.
    *
    * @param billingCompany the billing company of this shopping order
    */
    @Override
    public void setBillingCompany(java.lang.String billingCompany) {
        _shoppingOrder.setBillingCompany(billingCompany);
    }

    /**
    * Returns the billing street of this shopping order.
    *
    * @return the billing street of this shopping order
    */
    @Override
    public java.lang.String getBillingStreet() {
        return _shoppingOrder.getBillingStreet();
    }

    /**
    * Sets the billing street of this shopping order.
    *
    * @param billingStreet the billing street of this shopping order
    */
    @Override
    public void setBillingStreet(java.lang.String billingStreet) {
        _shoppingOrder.setBillingStreet(billingStreet);
    }

    /**
    * Returns the billing city of this shopping order.
    *
    * @return the billing city of this shopping order
    */
    @Override
    public java.lang.String getBillingCity() {
        return _shoppingOrder.getBillingCity();
    }

    /**
    * Sets the billing city of this shopping order.
    *
    * @param billingCity the billing city of this shopping order
    */
    @Override
    public void setBillingCity(java.lang.String billingCity) {
        _shoppingOrder.setBillingCity(billingCity);
    }

    /**
    * Returns the billing state of this shopping order.
    *
    * @return the billing state of this shopping order
    */
    @Override
    public java.lang.String getBillingState() {
        return _shoppingOrder.getBillingState();
    }

    /**
    * Sets the billing state of this shopping order.
    *
    * @param billingState the billing state of this shopping order
    */
    @Override
    public void setBillingState(java.lang.String billingState) {
        _shoppingOrder.setBillingState(billingState);
    }

    /**
    * Returns the billing zip of this shopping order.
    *
    * @return the billing zip of this shopping order
    */
    @Override
    public java.lang.String getBillingZip() {
        return _shoppingOrder.getBillingZip();
    }

    /**
    * Sets the billing zip of this shopping order.
    *
    * @param billingZip the billing zip of this shopping order
    */
    @Override
    public void setBillingZip(java.lang.String billingZip) {
        _shoppingOrder.setBillingZip(billingZip);
    }

    /**
    * Returns the billing country of this shopping order.
    *
    * @return the billing country of this shopping order
    */
    @Override
    public java.lang.String getBillingCountry() {
        return _shoppingOrder.getBillingCountry();
    }

    /**
    * Sets the billing country of this shopping order.
    *
    * @param billingCountry the billing country of this shopping order
    */
    @Override
    public void setBillingCountry(java.lang.String billingCountry) {
        _shoppingOrder.setBillingCountry(billingCountry);
    }

    /**
    * Returns the billing phone of this shopping order.
    *
    * @return the billing phone of this shopping order
    */
    @Override
    public java.lang.String getBillingPhone() {
        return _shoppingOrder.getBillingPhone();
    }

    /**
    * Sets the billing phone of this shopping order.
    *
    * @param billingPhone the billing phone of this shopping order
    */
    @Override
    public void setBillingPhone(java.lang.String billingPhone) {
        _shoppingOrder.setBillingPhone(billingPhone);
    }

    /**
    * Returns the ship to billing of this shopping order.
    *
    * @return the ship to billing of this shopping order
    */
    @Override
    public boolean getShipToBilling() {
        return _shoppingOrder.getShipToBilling();
    }

    /**
    * Returns <code>true</code> if this shopping order is ship to billing.
    *
    * @return <code>true</code> if this shopping order is ship to billing; <code>false</code> otherwise
    */
    @Override
    public boolean isShipToBilling() {
        return _shoppingOrder.isShipToBilling();
    }

    /**
    * Sets whether this shopping order is ship to billing.
    *
    * @param shipToBilling the ship to billing of this shopping order
    */
    @Override
    public void setShipToBilling(boolean shipToBilling) {
        _shoppingOrder.setShipToBilling(shipToBilling);
    }

    /**
    * Returns the shipping first name of this shopping order.
    *
    * @return the shipping first name of this shopping order
    */
    @Override
    public java.lang.String getShippingFirstName() {
        return _shoppingOrder.getShippingFirstName();
    }

    /**
    * Sets the shipping first name of this shopping order.
    *
    * @param shippingFirstName the shipping first name of this shopping order
    */
    @Override
    public void setShippingFirstName(java.lang.String shippingFirstName) {
        _shoppingOrder.setShippingFirstName(shippingFirstName);
    }

    /**
    * Returns the shipping last name of this shopping order.
    *
    * @return the shipping last name of this shopping order
    */
    @Override
    public java.lang.String getShippingLastName() {
        return _shoppingOrder.getShippingLastName();
    }

    /**
    * Sets the shipping last name of this shopping order.
    *
    * @param shippingLastName the shipping last name of this shopping order
    */
    @Override
    public void setShippingLastName(java.lang.String shippingLastName) {
        _shoppingOrder.setShippingLastName(shippingLastName);
    }

    /**
    * Returns the shipping email address of this shopping order.
    *
    * @return the shipping email address of this shopping order
    */
    @Override
    public java.lang.String getShippingEmailAddress() {
        return _shoppingOrder.getShippingEmailAddress();
    }

    /**
    * Sets the shipping email address of this shopping order.
    *
    * @param shippingEmailAddress the shipping email address of this shopping order
    */
    @Override
    public void setShippingEmailAddress(java.lang.String shippingEmailAddress) {
        _shoppingOrder.setShippingEmailAddress(shippingEmailAddress);
    }

    /**
    * Returns the shipping company of this shopping order.
    *
    * @return the shipping company of this shopping order
    */
    @Override
    public java.lang.String getShippingCompany() {
        return _shoppingOrder.getShippingCompany();
    }

    /**
    * Sets the shipping company of this shopping order.
    *
    * @param shippingCompany the shipping company of this shopping order
    */
    @Override
    public void setShippingCompany(java.lang.String shippingCompany) {
        _shoppingOrder.setShippingCompany(shippingCompany);
    }

    /**
    * Returns the shipping street of this shopping order.
    *
    * @return the shipping street of this shopping order
    */
    @Override
    public java.lang.String getShippingStreet() {
        return _shoppingOrder.getShippingStreet();
    }

    /**
    * Sets the shipping street of this shopping order.
    *
    * @param shippingStreet the shipping street of this shopping order
    */
    @Override
    public void setShippingStreet(java.lang.String shippingStreet) {
        _shoppingOrder.setShippingStreet(shippingStreet);
    }

    /**
    * Returns the shipping street2 of this shopping order.
    *
    * @return the shipping street2 of this shopping order
    */
    @Override
    public java.lang.String getShippingStreet2() {
        return _shoppingOrder.getShippingStreet2();
    }

    /**
    * Sets the shipping street2 of this shopping order.
    *
    * @param shippingStreet2 the shipping street2 of this shopping order
    */
    @Override
    public void setShippingStreet2(java.lang.String shippingStreet2) {
        _shoppingOrder.setShippingStreet2(shippingStreet2);
    }

    /**
    * Returns the shipping city of this shopping order.
    *
    * @return the shipping city of this shopping order
    */
    @Override
    public java.lang.String getShippingCity() {
        return _shoppingOrder.getShippingCity();
    }

    /**
    * Sets the shipping city of this shopping order.
    *
    * @param shippingCity the shipping city of this shopping order
    */
    @Override
    public void setShippingCity(java.lang.String shippingCity) {
        _shoppingOrder.setShippingCity(shippingCity);
    }

    /**
    * Returns the shipping state of this shopping order.
    *
    * @return the shipping state of this shopping order
    */
    @Override
    public java.lang.String getShippingState() {
        return _shoppingOrder.getShippingState();
    }

    /**
    * Sets the shipping state of this shopping order.
    *
    * @param shippingState the shipping state of this shopping order
    */
    @Override
    public void setShippingState(java.lang.String shippingState) {
        _shoppingOrder.setShippingState(shippingState);
    }

    /**
    * Returns the shipping post code of this shopping order.
    *
    * @return the shipping post code of this shopping order
    */
    @Override
    public java.lang.String getShippingPostCode() {
        return _shoppingOrder.getShippingPostCode();
    }

    /**
    * Sets the shipping post code of this shopping order.
    *
    * @param shippingPostCode the shipping post code of this shopping order
    */
    @Override
    public void setShippingPostCode(java.lang.String shippingPostCode) {
        _shoppingOrder.setShippingPostCode(shippingPostCode);
    }

    /**
    * Returns the shipping country of this shopping order.
    *
    * @return the shipping country of this shopping order
    */
    @Override
    public java.lang.String getShippingCountry() {
        return _shoppingOrder.getShippingCountry();
    }

    /**
    * Sets the shipping country of this shopping order.
    *
    * @param shippingCountry the shipping country of this shopping order
    */
    @Override
    public void setShippingCountry(java.lang.String shippingCountry) {
        _shoppingOrder.setShippingCountry(shippingCountry);
    }

    /**
    * Returns the shipping phone of this shopping order.
    *
    * @return the shipping phone of this shopping order
    */
    @Override
    public java.lang.String getShippingPhone() {
        return _shoppingOrder.getShippingPhone();
    }

    /**
    * Sets the shipping phone of this shopping order.
    *
    * @param shippingPhone the shipping phone of this shopping order
    */
    @Override
    public void setShippingPhone(java.lang.String shippingPhone) {
        _shoppingOrder.setShippingPhone(shippingPhone);
    }

    /**
    * Returns the comments of this shopping order.
    *
    * @return the comments of this shopping order
    */
    @Override
    public java.lang.String getComments() {
        return _shoppingOrder.getComments();
    }

    /**
    * Sets the comments of this shopping order.
    *
    * @param comments the comments of this shopping order
    */
    @Override
    public void setComments(java.lang.String comments) {
        _shoppingOrder.setComments(comments);
    }

    /**
    * Returns the external payment ID of this shopping order.
    *
    * @return the external payment ID of this shopping order
    */
    @Override
    public java.lang.String getExternalPaymentId() {
        return _shoppingOrder.getExternalPaymentId();
    }

    /**
    * Sets the external payment ID of this shopping order.
    *
    * @param externalPaymentId the external payment ID of this shopping order
    */
    @Override
    public void setExternalPaymentId(java.lang.String externalPaymentId) {
        _shoppingOrder.setExternalPaymentId(externalPaymentId);
    }

    /**
    * Returns the payment type of this shopping order.
    *
    * @return the payment type of this shopping order
    */
    @Override
    public java.lang.String getPaymentType() {
        return _shoppingOrder.getPaymentType();
    }

    /**
    * Sets the payment type of this shopping order.
    *
    * @param paymentType the payment type of this shopping order
    */
    @Override
    public void setPaymentType(java.lang.String paymentType) {
        _shoppingOrder.setPaymentType(paymentType);
    }

    /**
    * Returns the send order email of this shopping order.
    *
    * @return the send order email of this shopping order
    */
    @Override
    public boolean getSendOrderEmail() {
        return _shoppingOrder.getSendOrderEmail();
    }

    /**
    * Returns <code>true</code> if this shopping order is send order email.
    *
    * @return <code>true</code> if this shopping order is send order email; <code>false</code> otherwise
    */
    @Override
    public boolean isSendOrderEmail() {
        return _shoppingOrder.isSendOrderEmail();
    }

    /**
    * Sets whether this shopping order is send order email.
    *
    * @param sendOrderEmail the send order email of this shopping order
    */
    @Override
    public void setSendOrderEmail(boolean sendOrderEmail) {
        _shoppingOrder.setSendOrderEmail(sendOrderEmail);
    }

    /**
    * Returns the send shipping email of this shopping order.
    *
    * @return the send shipping email of this shopping order
    */
    @Override
    public boolean getSendShippingEmail() {
        return _shoppingOrder.getSendShippingEmail();
    }

    /**
    * Returns <code>true</code> if this shopping order is send shipping email.
    *
    * @return <code>true</code> if this shopping order is send shipping email; <code>false</code> otherwise
    */
    @Override
    public boolean isSendShippingEmail() {
        return _shoppingOrder.isSendShippingEmail();
    }

    /**
    * Sets whether this shopping order is send shipping email.
    *
    * @param sendShippingEmail the send shipping email of this shopping order
    */
    @Override
    public void setSendShippingEmail(boolean sendShippingEmail) {
        _shoppingOrder.setSendShippingEmail(sendShippingEmail);
    }

    /**
    * Returns the shipping method ID of this shopping order.
    *
    * @return the shipping method ID of this shopping order
    */
    @Override
    public long getShippingMethodId() {
        return _shoppingOrder.getShippingMethodId();
    }

    /**
    * Sets the shipping method ID of this shopping order.
    *
    * @param shippingMethodId the shipping method ID of this shopping order
    */
    @Override
    public void setShippingMethodId(long shippingMethodId) {
        _shoppingOrder.setShippingMethodId(shippingMethodId);
    }

    /**
    * Returns the international of this shopping order.
    *
    * @return the international of this shopping order
    */
    @Override
    public boolean getInternational() {
        return _shoppingOrder.getInternational();
    }

    /**
    * Returns <code>true</code> if this shopping order is international.
    *
    * @return <code>true</code> if this shopping order is international; <code>false</code> otherwise
    */
    @Override
    public boolean isInternational() {
        return _shoppingOrder.isInternational();
    }

    /**
    * Sets whether this shopping order is international.
    *
    * @param international the international of this shopping order
    */
    @Override
    public void setInternational(boolean international) {
        _shoppingOrder.setInternational(international);
    }

    @Override
    public boolean isNew() {
        return _shoppingOrder.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _shoppingOrder.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _shoppingOrder.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _shoppingOrder.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _shoppingOrder.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _shoppingOrder.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _shoppingOrder.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _shoppingOrder.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _shoppingOrder.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _shoppingOrder.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _shoppingOrder.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new ShoppingOrderWrapper((ShoppingOrder) _shoppingOrder.clone());
    }

    @Override
    public int compareTo(com.fsquare.shopping.model.ShoppingOrder shoppingOrder) {
        return _shoppingOrder.compareTo(shoppingOrder);
    }

    @Override
    public int hashCode() {
        return _shoppingOrder.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<com.fsquare.shopping.model.ShoppingOrder> toCacheModel() {
        return _shoppingOrder.toCacheModel();
    }

    @Override
    public com.fsquare.shopping.model.ShoppingOrder toEscapedModel() {
        return new ShoppingOrderWrapper(_shoppingOrder.toEscapedModel());
    }

    @Override
    public com.fsquare.shopping.model.ShoppingOrder toUnescapedModel() {
        return new ShoppingOrderWrapper(_shoppingOrder.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _shoppingOrder.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _shoppingOrder.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _shoppingOrder.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof ShoppingOrderWrapper)) {
            return false;
        }

        ShoppingOrderWrapper shoppingOrderWrapper = (ShoppingOrderWrapper) obj;

        if (Validator.equals(_shoppingOrder, shoppingOrderWrapper._shoppingOrder)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public ShoppingOrder getWrappedShoppingOrder() {
        return _shoppingOrder;
    }

    @Override
    public ShoppingOrder getWrappedModel() {
        return _shoppingOrder;
    }

    @Override
    public void resetOriginalValues() {
        _shoppingOrder.resetOriginalValues();
    }
}
