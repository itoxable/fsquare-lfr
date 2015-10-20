package com.fsquare.shopping.model;

import com.fsquare.shopping.service.ClpSerializer;
import com.fsquare.shopping.service.ShoppingOrderLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class ShoppingOrderClp extends BaseModelImpl<ShoppingOrder>
    implements ShoppingOrder {
    private long _shoppingOrderId;
    private long _groupId;
    private long _companyId;
    private long _userId;
    private String _userUuid;
    private String _userName;
    private Date _createDate;
    private Date _modifiedDate;
    private String _status;
    private String _number;
    private double _tax;
    private double _shipping;
    private String _altShipping;
    private boolean _requiresShipping;
    private boolean _insure;
    private double _insurance;
    private String _couponCodes;
    private double _couponDiscount;
    private String _billingFirstName;
    private String _billingLastName;
    private String _billingEmailAddress;
    private String _billingCompany;
    private String _billingStreet;
    private String _billingCity;
    private String _billingState;
    private String _billingZip;
    private String _billingCountry;
    private String _billingPhone;
    private boolean _shipToBilling;
    private String _shippingFirstName;
    private String _shippingLastName;
    private String _shippingEmailAddress;
    private String _shippingCompany;
    private String _shippingStreet;
    private String _shippingCity;
    private String _shippingState;
    private String _shippingZip;
    private String _shippingCountry;
    private String _shippingPhone;
    private String _ccName;
    private String _ccType;
    private String _ccNumber;
    private int _ccExpMonth;
    private int _ccExpYear;
    private String _ccVerNumber;
    private String _comments;
    private String _ppTxnId;
    private String _ppPaymentStatus;
    private double _ppPaymentGross;
    private String _ppReceiverEmail;
    private String _ppPayerEmail;
    private boolean _sendOrderEmail;
    private boolean _sendShippingEmail;
    private long _shippingMethodId;
    private BaseModel<?> _shoppingOrderRemoteModel;
    private Class<?> _clpSerializerClass = com.fsquare.shopping.service.ClpSerializer.class;

    public ShoppingOrderClp() {
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
    public long getPrimaryKey() {
        return _shoppingOrderId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setShoppingOrderId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _shoppingOrderId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
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
        attributes.put("altShipping", getAltShipping());
        attributes.put("requiresShipping", getRequiresShipping());
        attributes.put("insure", getInsure());
        attributes.put("insurance", getInsurance());
        attributes.put("couponCodes", getCouponCodes());
        attributes.put("couponDiscount", getCouponDiscount());
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
        attributes.put("shippingCity", getShippingCity());
        attributes.put("shippingState", getShippingState());
        attributes.put("shippingZip", getShippingZip());
        attributes.put("shippingCountry", getShippingCountry());
        attributes.put("shippingPhone", getShippingPhone());
        attributes.put("ccName", getCcName());
        attributes.put("ccType", getCcType());
        attributes.put("ccNumber", getCcNumber());
        attributes.put("ccExpMonth", getCcExpMonth());
        attributes.put("ccExpYear", getCcExpYear());
        attributes.put("ccVerNumber", getCcVerNumber());
        attributes.put("comments", getComments());
        attributes.put("ppTxnId", getPpTxnId());
        attributes.put("ppPaymentStatus", getPpPaymentStatus());
        attributes.put("ppPaymentGross", getPpPaymentGross());
        attributes.put("ppReceiverEmail", getPpReceiverEmail());
        attributes.put("ppPayerEmail", getPpPayerEmail());
        attributes.put("sendOrderEmail", getSendOrderEmail());
        attributes.put("sendShippingEmail", getSendShippingEmail());
        attributes.put("shippingMethodId", getShippingMethodId());

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

        String shippingCity = (String) attributes.get("shippingCity");

        if (shippingCity != null) {
            setShippingCity(shippingCity);
        }

        String shippingState = (String) attributes.get("shippingState");

        if (shippingState != null) {
            setShippingState(shippingState);
        }

        String shippingZip = (String) attributes.get("shippingZip");

        if (shippingZip != null) {
            setShippingZip(shippingZip);
        }

        String shippingCountry = (String) attributes.get("shippingCountry");

        if (shippingCountry != null) {
            setShippingCountry(shippingCountry);
        }

        String shippingPhone = (String) attributes.get("shippingPhone");

        if (shippingPhone != null) {
            setShippingPhone(shippingPhone);
        }

        String ccName = (String) attributes.get("ccName");

        if (ccName != null) {
            setCcName(ccName);
        }

        String ccType = (String) attributes.get("ccType");

        if (ccType != null) {
            setCcType(ccType);
        }

        String ccNumber = (String) attributes.get("ccNumber");

        if (ccNumber != null) {
            setCcNumber(ccNumber);
        }

        Integer ccExpMonth = (Integer) attributes.get("ccExpMonth");

        if (ccExpMonth != null) {
            setCcExpMonth(ccExpMonth);
        }

        Integer ccExpYear = (Integer) attributes.get("ccExpYear");

        if (ccExpYear != null) {
            setCcExpYear(ccExpYear);
        }

        String ccVerNumber = (String) attributes.get("ccVerNumber");

        if (ccVerNumber != null) {
            setCcVerNumber(ccVerNumber);
        }

        String comments = (String) attributes.get("comments");

        if (comments != null) {
            setComments(comments);
        }

        String ppTxnId = (String) attributes.get("ppTxnId");

        if (ppTxnId != null) {
            setPpTxnId(ppTxnId);
        }

        String ppPaymentStatus = (String) attributes.get("ppPaymentStatus");

        if (ppPaymentStatus != null) {
            setPpPaymentStatus(ppPaymentStatus);
        }

        Double ppPaymentGross = (Double) attributes.get("ppPaymentGross");

        if (ppPaymentGross != null) {
            setPpPaymentGross(ppPaymentGross);
        }

        String ppReceiverEmail = (String) attributes.get("ppReceiverEmail");

        if (ppReceiverEmail != null) {
            setPpReceiverEmail(ppReceiverEmail);
        }

        String ppPayerEmail = (String) attributes.get("ppPayerEmail");

        if (ppPayerEmail != null) {
            setPpPayerEmail(ppPayerEmail);
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
    }

    @Override
    public long getShoppingOrderId() {
        return _shoppingOrderId;
    }

    @Override
    public void setShoppingOrderId(long shoppingOrderId) {
        _shoppingOrderId = shoppingOrderId;

        if (_shoppingOrderRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingOrderRemoteModel.getClass();

                Method method = clazz.getMethod("setShoppingOrderId", long.class);

                method.invoke(_shoppingOrderRemoteModel, shoppingOrderId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getGroupId() {
        return _groupId;
    }

    @Override
    public void setGroupId(long groupId) {
        _groupId = groupId;

        if (_shoppingOrderRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingOrderRemoteModel.getClass();

                Method method = clazz.getMethod("setGroupId", long.class);

                method.invoke(_shoppingOrderRemoteModel, groupId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getCompanyId() {
        return _companyId;
    }

    @Override
    public void setCompanyId(long companyId) {
        _companyId = companyId;

        if (_shoppingOrderRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingOrderRemoteModel.getClass();

                Method method = clazz.getMethod("setCompanyId", long.class);

                method.invoke(_shoppingOrderRemoteModel, companyId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getUserId() {
        return _userId;
    }

    @Override
    public void setUserId(long userId) {
        _userId = userId;

        if (_shoppingOrderRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingOrderRemoteModel.getClass();

                Method method = clazz.getMethod("setUserId", long.class);

                method.invoke(_shoppingOrderRemoteModel, userId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getUserUuid() throws SystemException {
        return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
    }

    @Override
    public void setUserUuid(String userUuid) {
        _userUuid = userUuid;
    }

    @Override
    public String getUserName() {
        return _userName;
    }

    @Override
    public void setUserName(String userName) {
        _userName = userName;

        if (_shoppingOrderRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingOrderRemoteModel.getClass();

                Method method = clazz.getMethod("setUserName", String.class);

                method.invoke(_shoppingOrderRemoteModel, userName);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getCreateDate() {
        return _createDate;
    }

    @Override
    public void setCreateDate(Date createDate) {
        _createDate = createDate;

        if (_shoppingOrderRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingOrderRemoteModel.getClass();

                Method method = clazz.getMethod("setCreateDate", Date.class);

                method.invoke(_shoppingOrderRemoteModel, createDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getModifiedDate() {
        return _modifiedDate;
    }

    @Override
    public void setModifiedDate(Date modifiedDate) {
        _modifiedDate = modifiedDate;

        if (_shoppingOrderRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingOrderRemoteModel.getClass();

                Method method = clazz.getMethod("setModifiedDate", Date.class);

                method.invoke(_shoppingOrderRemoteModel, modifiedDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getStatus() {
        return _status;
    }

    @Override
    public void setStatus(String status) {
        _status = status;

        if (_shoppingOrderRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingOrderRemoteModel.getClass();

                Method method = clazz.getMethod("setStatus", String.class);

                method.invoke(_shoppingOrderRemoteModel, status);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getNumber() {
        return _number;
    }

    @Override
    public void setNumber(String number) {
        _number = number;

        if (_shoppingOrderRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingOrderRemoteModel.getClass();

                Method method = clazz.getMethod("setNumber", String.class);

                method.invoke(_shoppingOrderRemoteModel, number);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public double getTax() {
        return _tax;
    }

    @Override
    public void setTax(double tax) {
        _tax = tax;

        if (_shoppingOrderRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingOrderRemoteModel.getClass();

                Method method = clazz.getMethod("setTax", double.class);

                method.invoke(_shoppingOrderRemoteModel, tax);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public double getShipping() {
        return _shipping;
    }

    @Override
    public void setShipping(double shipping) {
        _shipping = shipping;

        if (_shoppingOrderRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingOrderRemoteModel.getClass();

                Method method = clazz.getMethod("setShipping", double.class);

                method.invoke(_shoppingOrderRemoteModel, shipping);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getAltShipping() {
        return _altShipping;
    }

    @Override
    public void setAltShipping(String altShipping) {
        _altShipping = altShipping;

        if (_shoppingOrderRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingOrderRemoteModel.getClass();

                Method method = clazz.getMethod("setAltShipping", String.class);

                method.invoke(_shoppingOrderRemoteModel, altShipping);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public boolean getRequiresShipping() {
        return _requiresShipping;
    }

    @Override
    public boolean isRequiresShipping() {
        return _requiresShipping;
    }

    @Override
    public void setRequiresShipping(boolean requiresShipping) {
        _requiresShipping = requiresShipping;

        if (_shoppingOrderRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingOrderRemoteModel.getClass();

                Method method = clazz.getMethod("setRequiresShipping",
                        boolean.class);

                method.invoke(_shoppingOrderRemoteModel, requiresShipping);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public boolean getInsure() {
        return _insure;
    }

    @Override
    public boolean isInsure() {
        return _insure;
    }

    @Override
    public void setInsure(boolean insure) {
        _insure = insure;

        if (_shoppingOrderRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingOrderRemoteModel.getClass();

                Method method = clazz.getMethod("setInsure", boolean.class);

                method.invoke(_shoppingOrderRemoteModel, insure);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public double getInsurance() {
        return _insurance;
    }

    @Override
    public void setInsurance(double insurance) {
        _insurance = insurance;

        if (_shoppingOrderRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingOrderRemoteModel.getClass();

                Method method = clazz.getMethod("setInsurance", double.class);

                method.invoke(_shoppingOrderRemoteModel, insurance);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getCouponCodes() {
        return _couponCodes;
    }

    @Override
    public void setCouponCodes(String couponCodes) {
        _couponCodes = couponCodes;

        if (_shoppingOrderRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingOrderRemoteModel.getClass();

                Method method = clazz.getMethod("setCouponCodes", String.class);

                method.invoke(_shoppingOrderRemoteModel, couponCodes);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public double getCouponDiscount() {
        return _couponDiscount;
    }

    @Override
    public void setCouponDiscount(double couponDiscount) {
        _couponDiscount = couponDiscount;

        if (_shoppingOrderRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingOrderRemoteModel.getClass();

                Method method = clazz.getMethod("setCouponDiscount",
                        double.class);

                method.invoke(_shoppingOrderRemoteModel, couponDiscount);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getBillingFirstName() {
        return _billingFirstName;
    }

    @Override
    public void setBillingFirstName(String billingFirstName) {
        _billingFirstName = billingFirstName;

        if (_shoppingOrderRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingOrderRemoteModel.getClass();

                Method method = clazz.getMethod("setBillingFirstName",
                        String.class);

                method.invoke(_shoppingOrderRemoteModel, billingFirstName);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getBillingLastName() {
        return _billingLastName;
    }

    @Override
    public void setBillingLastName(String billingLastName) {
        _billingLastName = billingLastName;

        if (_shoppingOrderRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingOrderRemoteModel.getClass();

                Method method = clazz.getMethod("setBillingLastName",
                        String.class);

                method.invoke(_shoppingOrderRemoteModel, billingLastName);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getBillingEmailAddress() {
        return _billingEmailAddress;
    }

    @Override
    public void setBillingEmailAddress(String billingEmailAddress) {
        _billingEmailAddress = billingEmailAddress;

        if (_shoppingOrderRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingOrderRemoteModel.getClass();

                Method method = clazz.getMethod("setBillingEmailAddress",
                        String.class);

                method.invoke(_shoppingOrderRemoteModel, billingEmailAddress);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getBillingCompany() {
        return _billingCompany;
    }

    @Override
    public void setBillingCompany(String billingCompany) {
        _billingCompany = billingCompany;

        if (_shoppingOrderRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingOrderRemoteModel.getClass();

                Method method = clazz.getMethod("setBillingCompany",
                        String.class);

                method.invoke(_shoppingOrderRemoteModel, billingCompany);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getBillingStreet() {
        return _billingStreet;
    }

    @Override
    public void setBillingStreet(String billingStreet) {
        _billingStreet = billingStreet;

        if (_shoppingOrderRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingOrderRemoteModel.getClass();

                Method method = clazz.getMethod("setBillingStreet", String.class);

                method.invoke(_shoppingOrderRemoteModel, billingStreet);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getBillingCity() {
        return _billingCity;
    }

    @Override
    public void setBillingCity(String billingCity) {
        _billingCity = billingCity;

        if (_shoppingOrderRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingOrderRemoteModel.getClass();

                Method method = clazz.getMethod("setBillingCity", String.class);

                method.invoke(_shoppingOrderRemoteModel, billingCity);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getBillingState() {
        return _billingState;
    }

    @Override
    public void setBillingState(String billingState) {
        _billingState = billingState;

        if (_shoppingOrderRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingOrderRemoteModel.getClass();

                Method method = clazz.getMethod("setBillingState", String.class);

                method.invoke(_shoppingOrderRemoteModel, billingState);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getBillingZip() {
        return _billingZip;
    }

    @Override
    public void setBillingZip(String billingZip) {
        _billingZip = billingZip;

        if (_shoppingOrderRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingOrderRemoteModel.getClass();

                Method method = clazz.getMethod("setBillingZip", String.class);

                method.invoke(_shoppingOrderRemoteModel, billingZip);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getBillingCountry() {
        return _billingCountry;
    }

    @Override
    public void setBillingCountry(String billingCountry) {
        _billingCountry = billingCountry;

        if (_shoppingOrderRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingOrderRemoteModel.getClass();

                Method method = clazz.getMethod("setBillingCountry",
                        String.class);

                method.invoke(_shoppingOrderRemoteModel, billingCountry);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getBillingPhone() {
        return _billingPhone;
    }

    @Override
    public void setBillingPhone(String billingPhone) {
        _billingPhone = billingPhone;

        if (_shoppingOrderRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingOrderRemoteModel.getClass();

                Method method = clazz.getMethod("setBillingPhone", String.class);

                method.invoke(_shoppingOrderRemoteModel, billingPhone);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public boolean getShipToBilling() {
        return _shipToBilling;
    }

    @Override
    public boolean isShipToBilling() {
        return _shipToBilling;
    }

    @Override
    public void setShipToBilling(boolean shipToBilling) {
        _shipToBilling = shipToBilling;

        if (_shoppingOrderRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingOrderRemoteModel.getClass();

                Method method = clazz.getMethod("setShipToBilling",
                        boolean.class);

                method.invoke(_shoppingOrderRemoteModel, shipToBilling);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getShippingFirstName() {
        return _shippingFirstName;
    }

    @Override
    public void setShippingFirstName(String shippingFirstName) {
        _shippingFirstName = shippingFirstName;

        if (_shoppingOrderRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingOrderRemoteModel.getClass();

                Method method = clazz.getMethod("setShippingFirstName",
                        String.class);

                method.invoke(_shoppingOrderRemoteModel, shippingFirstName);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getShippingLastName() {
        return _shippingLastName;
    }

    @Override
    public void setShippingLastName(String shippingLastName) {
        _shippingLastName = shippingLastName;

        if (_shoppingOrderRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingOrderRemoteModel.getClass();

                Method method = clazz.getMethod("setShippingLastName",
                        String.class);

                method.invoke(_shoppingOrderRemoteModel, shippingLastName);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getShippingEmailAddress() {
        return _shippingEmailAddress;
    }

    @Override
    public void setShippingEmailAddress(String shippingEmailAddress) {
        _shippingEmailAddress = shippingEmailAddress;

        if (_shoppingOrderRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingOrderRemoteModel.getClass();

                Method method = clazz.getMethod("setShippingEmailAddress",
                        String.class);

                method.invoke(_shoppingOrderRemoteModel, shippingEmailAddress);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getShippingCompany() {
        return _shippingCompany;
    }

    @Override
    public void setShippingCompany(String shippingCompany) {
        _shippingCompany = shippingCompany;

        if (_shoppingOrderRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingOrderRemoteModel.getClass();

                Method method = clazz.getMethod("setShippingCompany",
                        String.class);

                method.invoke(_shoppingOrderRemoteModel, shippingCompany);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getShippingStreet() {
        return _shippingStreet;
    }

    @Override
    public void setShippingStreet(String shippingStreet) {
        _shippingStreet = shippingStreet;

        if (_shoppingOrderRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingOrderRemoteModel.getClass();

                Method method = clazz.getMethod("setShippingStreet",
                        String.class);

                method.invoke(_shoppingOrderRemoteModel, shippingStreet);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getShippingCity() {
        return _shippingCity;
    }

    @Override
    public void setShippingCity(String shippingCity) {
        _shippingCity = shippingCity;

        if (_shoppingOrderRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingOrderRemoteModel.getClass();

                Method method = clazz.getMethod("setShippingCity", String.class);

                method.invoke(_shoppingOrderRemoteModel, shippingCity);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getShippingState() {
        return _shippingState;
    }

    @Override
    public void setShippingState(String shippingState) {
        _shippingState = shippingState;

        if (_shoppingOrderRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingOrderRemoteModel.getClass();

                Method method = clazz.getMethod("setShippingState", String.class);

                method.invoke(_shoppingOrderRemoteModel, shippingState);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getShippingZip() {
        return _shippingZip;
    }

    @Override
    public void setShippingZip(String shippingZip) {
        _shippingZip = shippingZip;

        if (_shoppingOrderRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingOrderRemoteModel.getClass();

                Method method = clazz.getMethod("setShippingZip", String.class);

                method.invoke(_shoppingOrderRemoteModel, shippingZip);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getShippingCountry() {
        return _shippingCountry;
    }

    @Override
    public void setShippingCountry(String shippingCountry) {
        _shippingCountry = shippingCountry;

        if (_shoppingOrderRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingOrderRemoteModel.getClass();

                Method method = clazz.getMethod("setShippingCountry",
                        String.class);

                method.invoke(_shoppingOrderRemoteModel, shippingCountry);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getShippingPhone() {
        return _shippingPhone;
    }

    @Override
    public void setShippingPhone(String shippingPhone) {
        _shippingPhone = shippingPhone;

        if (_shoppingOrderRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingOrderRemoteModel.getClass();

                Method method = clazz.getMethod("setShippingPhone", String.class);

                method.invoke(_shoppingOrderRemoteModel, shippingPhone);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getCcName() {
        return _ccName;
    }

    @Override
    public void setCcName(String ccName) {
        _ccName = ccName;

        if (_shoppingOrderRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingOrderRemoteModel.getClass();

                Method method = clazz.getMethod("setCcName", String.class);

                method.invoke(_shoppingOrderRemoteModel, ccName);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getCcType() {
        return _ccType;
    }

    @Override
    public void setCcType(String ccType) {
        _ccType = ccType;

        if (_shoppingOrderRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingOrderRemoteModel.getClass();

                Method method = clazz.getMethod("setCcType", String.class);

                method.invoke(_shoppingOrderRemoteModel, ccType);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getCcNumber() {
        return _ccNumber;
    }

    @Override
    public void setCcNumber(String ccNumber) {
        _ccNumber = ccNumber;

        if (_shoppingOrderRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingOrderRemoteModel.getClass();

                Method method = clazz.getMethod("setCcNumber", String.class);

                method.invoke(_shoppingOrderRemoteModel, ccNumber);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getCcExpMonth() {
        return _ccExpMonth;
    }

    @Override
    public void setCcExpMonth(int ccExpMonth) {
        _ccExpMonth = ccExpMonth;

        if (_shoppingOrderRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingOrderRemoteModel.getClass();

                Method method = clazz.getMethod("setCcExpMonth", int.class);

                method.invoke(_shoppingOrderRemoteModel, ccExpMonth);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getCcExpYear() {
        return _ccExpYear;
    }

    @Override
    public void setCcExpYear(int ccExpYear) {
        _ccExpYear = ccExpYear;

        if (_shoppingOrderRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingOrderRemoteModel.getClass();

                Method method = clazz.getMethod("setCcExpYear", int.class);

                method.invoke(_shoppingOrderRemoteModel, ccExpYear);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getCcVerNumber() {
        return _ccVerNumber;
    }

    @Override
    public void setCcVerNumber(String ccVerNumber) {
        _ccVerNumber = ccVerNumber;

        if (_shoppingOrderRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingOrderRemoteModel.getClass();

                Method method = clazz.getMethod("setCcVerNumber", String.class);

                method.invoke(_shoppingOrderRemoteModel, ccVerNumber);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getComments() {
        return _comments;
    }

    @Override
    public void setComments(String comments) {
        _comments = comments;

        if (_shoppingOrderRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingOrderRemoteModel.getClass();

                Method method = clazz.getMethod("setComments", String.class);

                method.invoke(_shoppingOrderRemoteModel, comments);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getPpTxnId() {
        return _ppTxnId;
    }

    @Override
    public void setPpTxnId(String ppTxnId) {
        _ppTxnId = ppTxnId;

        if (_shoppingOrderRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingOrderRemoteModel.getClass();

                Method method = clazz.getMethod("setPpTxnId", String.class);

                method.invoke(_shoppingOrderRemoteModel, ppTxnId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getPpPaymentStatus() {
        return _ppPaymentStatus;
    }

    @Override
    public void setPpPaymentStatus(String ppPaymentStatus) {
        _ppPaymentStatus = ppPaymentStatus;

        if (_shoppingOrderRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingOrderRemoteModel.getClass();

                Method method = clazz.getMethod("setPpPaymentStatus",
                        String.class);

                method.invoke(_shoppingOrderRemoteModel, ppPaymentStatus);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public double getPpPaymentGross() {
        return _ppPaymentGross;
    }

    @Override
    public void setPpPaymentGross(double ppPaymentGross) {
        _ppPaymentGross = ppPaymentGross;

        if (_shoppingOrderRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingOrderRemoteModel.getClass();

                Method method = clazz.getMethod("setPpPaymentGross",
                        double.class);

                method.invoke(_shoppingOrderRemoteModel, ppPaymentGross);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getPpReceiverEmail() {
        return _ppReceiverEmail;
    }

    @Override
    public void setPpReceiverEmail(String ppReceiverEmail) {
        _ppReceiverEmail = ppReceiverEmail;

        if (_shoppingOrderRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingOrderRemoteModel.getClass();

                Method method = clazz.getMethod("setPpReceiverEmail",
                        String.class);

                method.invoke(_shoppingOrderRemoteModel, ppReceiverEmail);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getPpPayerEmail() {
        return _ppPayerEmail;
    }

    @Override
    public void setPpPayerEmail(String ppPayerEmail) {
        _ppPayerEmail = ppPayerEmail;

        if (_shoppingOrderRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingOrderRemoteModel.getClass();

                Method method = clazz.getMethod("setPpPayerEmail", String.class);

                method.invoke(_shoppingOrderRemoteModel, ppPayerEmail);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public boolean getSendOrderEmail() {
        return _sendOrderEmail;
    }

    @Override
    public boolean isSendOrderEmail() {
        return _sendOrderEmail;
    }

    @Override
    public void setSendOrderEmail(boolean sendOrderEmail) {
        _sendOrderEmail = sendOrderEmail;

        if (_shoppingOrderRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingOrderRemoteModel.getClass();

                Method method = clazz.getMethod("setSendOrderEmail",
                        boolean.class);

                method.invoke(_shoppingOrderRemoteModel, sendOrderEmail);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public boolean getSendShippingEmail() {
        return _sendShippingEmail;
    }

    @Override
    public boolean isSendShippingEmail() {
        return _sendShippingEmail;
    }

    @Override
    public void setSendShippingEmail(boolean sendShippingEmail) {
        _sendShippingEmail = sendShippingEmail;

        if (_shoppingOrderRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingOrderRemoteModel.getClass();

                Method method = clazz.getMethod("setSendShippingEmail",
                        boolean.class);

                method.invoke(_shoppingOrderRemoteModel, sendShippingEmail);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getShippingMethodId() {
        return _shippingMethodId;
    }

    @Override
    public void setShippingMethodId(long shippingMethodId) {
        _shippingMethodId = shippingMethodId;

        if (_shoppingOrderRemoteModel != null) {
            try {
                Class<?> clazz = _shoppingOrderRemoteModel.getClass();

                Method method = clazz.getMethod("setShippingMethodId",
                        long.class);

                method.invoke(_shoppingOrderRemoteModel, shippingMethodId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getShoppingOrderRemoteModel() {
        return _shoppingOrderRemoteModel;
    }

    public void setShoppingOrderRemoteModel(
        BaseModel<?> shoppingOrderRemoteModel) {
        _shoppingOrderRemoteModel = shoppingOrderRemoteModel;
    }

    public Object invokeOnRemoteModel(String methodName,
        Class<?>[] parameterTypes, Object[] parameterValues)
        throws Exception {
        Object[] remoteParameterValues = new Object[parameterValues.length];

        for (int i = 0; i < parameterValues.length; i++) {
            if (parameterValues[i] != null) {
                remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
            }
        }

        Class<?> remoteModelClass = _shoppingOrderRemoteModel.getClass();

        ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

        Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

        for (int i = 0; i < parameterTypes.length; i++) {
            if (parameterTypes[i].isPrimitive()) {
                remoteParameterTypes[i] = parameterTypes[i];
            } else {
                String parameterTypeName = parameterTypes[i].getName();

                remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
            }
        }

        Method method = remoteModelClass.getMethod(methodName,
                remoteParameterTypes);

        Object returnValue = method.invoke(_shoppingOrderRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            ShoppingOrderLocalServiceUtil.addShoppingOrder(this);
        } else {
            ShoppingOrderLocalServiceUtil.updateShoppingOrder(this);
        }
    }

    @Override
    public ShoppingOrder toEscapedModel() {
        return (ShoppingOrder) ProxyUtil.newProxyInstance(ShoppingOrder.class.getClassLoader(),
            new Class[] { ShoppingOrder.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        ShoppingOrderClp clone = new ShoppingOrderClp();

        clone.setShoppingOrderId(getShoppingOrderId());
        clone.setGroupId(getGroupId());
        clone.setCompanyId(getCompanyId());
        clone.setUserId(getUserId());
        clone.setUserName(getUserName());
        clone.setCreateDate(getCreateDate());
        clone.setModifiedDate(getModifiedDate());
        clone.setStatus(getStatus());
        clone.setNumber(getNumber());
        clone.setTax(getTax());
        clone.setShipping(getShipping());
        clone.setAltShipping(getAltShipping());
        clone.setRequiresShipping(getRequiresShipping());
        clone.setInsure(getInsure());
        clone.setInsurance(getInsurance());
        clone.setCouponCodes(getCouponCodes());
        clone.setCouponDiscount(getCouponDiscount());
        clone.setBillingFirstName(getBillingFirstName());
        clone.setBillingLastName(getBillingLastName());
        clone.setBillingEmailAddress(getBillingEmailAddress());
        clone.setBillingCompany(getBillingCompany());
        clone.setBillingStreet(getBillingStreet());
        clone.setBillingCity(getBillingCity());
        clone.setBillingState(getBillingState());
        clone.setBillingZip(getBillingZip());
        clone.setBillingCountry(getBillingCountry());
        clone.setBillingPhone(getBillingPhone());
        clone.setShipToBilling(getShipToBilling());
        clone.setShippingFirstName(getShippingFirstName());
        clone.setShippingLastName(getShippingLastName());
        clone.setShippingEmailAddress(getShippingEmailAddress());
        clone.setShippingCompany(getShippingCompany());
        clone.setShippingStreet(getShippingStreet());
        clone.setShippingCity(getShippingCity());
        clone.setShippingState(getShippingState());
        clone.setShippingZip(getShippingZip());
        clone.setShippingCountry(getShippingCountry());
        clone.setShippingPhone(getShippingPhone());
        clone.setCcName(getCcName());
        clone.setCcType(getCcType());
        clone.setCcNumber(getCcNumber());
        clone.setCcExpMonth(getCcExpMonth());
        clone.setCcExpYear(getCcExpYear());
        clone.setCcVerNumber(getCcVerNumber());
        clone.setComments(getComments());
        clone.setPpTxnId(getPpTxnId());
        clone.setPpPaymentStatus(getPpPaymentStatus());
        clone.setPpPaymentGross(getPpPaymentGross());
        clone.setPpReceiverEmail(getPpReceiverEmail());
        clone.setPpPayerEmail(getPpPayerEmail());
        clone.setSendOrderEmail(getSendOrderEmail());
        clone.setSendShippingEmail(getSendShippingEmail());
        clone.setShippingMethodId(getShippingMethodId());

        return clone;
    }

    @Override
    public int compareTo(ShoppingOrder shoppingOrder) {
        int value = 0;

        value = DateUtil.compareTo(getCreateDate(),
                shoppingOrder.getCreateDate());

        value = value * -1;

        if (value != 0) {
            return value;
        }

        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof ShoppingOrderClp)) {
            return false;
        }

        ShoppingOrderClp shoppingOrder = (ShoppingOrderClp) obj;

        long primaryKey = shoppingOrder.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    public Class<?> getClpSerializerClass() {
        return _clpSerializerClass;
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(107);

        sb.append("{shoppingOrderId=");
        sb.append(getShoppingOrderId());
        sb.append(", groupId=");
        sb.append(getGroupId());
        sb.append(", companyId=");
        sb.append(getCompanyId());
        sb.append(", userId=");
        sb.append(getUserId());
        sb.append(", userName=");
        sb.append(getUserName());
        sb.append(", createDate=");
        sb.append(getCreateDate());
        sb.append(", modifiedDate=");
        sb.append(getModifiedDate());
        sb.append(", status=");
        sb.append(getStatus());
        sb.append(", number=");
        sb.append(getNumber());
        sb.append(", tax=");
        sb.append(getTax());
        sb.append(", shipping=");
        sb.append(getShipping());
        sb.append(", altShipping=");
        sb.append(getAltShipping());
        sb.append(", requiresShipping=");
        sb.append(getRequiresShipping());
        sb.append(", insure=");
        sb.append(getInsure());
        sb.append(", insurance=");
        sb.append(getInsurance());
        sb.append(", couponCodes=");
        sb.append(getCouponCodes());
        sb.append(", couponDiscount=");
        sb.append(getCouponDiscount());
        sb.append(", billingFirstName=");
        sb.append(getBillingFirstName());
        sb.append(", billingLastName=");
        sb.append(getBillingLastName());
        sb.append(", billingEmailAddress=");
        sb.append(getBillingEmailAddress());
        sb.append(", billingCompany=");
        sb.append(getBillingCompany());
        sb.append(", billingStreet=");
        sb.append(getBillingStreet());
        sb.append(", billingCity=");
        sb.append(getBillingCity());
        sb.append(", billingState=");
        sb.append(getBillingState());
        sb.append(", billingZip=");
        sb.append(getBillingZip());
        sb.append(", billingCountry=");
        sb.append(getBillingCountry());
        sb.append(", billingPhone=");
        sb.append(getBillingPhone());
        sb.append(", shipToBilling=");
        sb.append(getShipToBilling());
        sb.append(", shippingFirstName=");
        sb.append(getShippingFirstName());
        sb.append(", shippingLastName=");
        sb.append(getShippingLastName());
        sb.append(", shippingEmailAddress=");
        sb.append(getShippingEmailAddress());
        sb.append(", shippingCompany=");
        sb.append(getShippingCompany());
        sb.append(", shippingStreet=");
        sb.append(getShippingStreet());
        sb.append(", shippingCity=");
        sb.append(getShippingCity());
        sb.append(", shippingState=");
        sb.append(getShippingState());
        sb.append(", shippingZip=");
        sb.append(getShippingZip());
        sb.append(", shippingCountry=");
        sb.append(getShippingCountry());
        sb.append(", shippingPhone=");
        sb.append(getShippingPhone());
        sb.append(", ccName=");
        sb.append(getCcName());
        sb.append(", ccType=");
        sb.append(getCcType());
        sb.append(", ccNumber=");
        sb.append(getCcNumber());
        sb.append(", ccExpMonth=");
        sb.append(getCcExpMonth());
        sb.append(", ccExpYear=");
        sb.append(getCcExpYear());
        sb.append(", ccVerNumber=");
        sb.append(getCcVerNumber());
        sb.append(", comments=");
        sb.append(getComments());
        sb.append(", ppTxnId=");
        sb.append(getPpTxnId());
        sb.append(", ppPaymentStatus=");
        sb.append(getPpPaymentStatus());
        sb.append(", ppPaymentGross=");
        sb.append(getPpPaymentGross());
        sb.append(", ppReceiverEmail=");
        sb.append(getPpReceiverEmail());
        sb.append(", ppPayerEmail=");
        sb.append(getPpPayerEmail());
        sb.append(", sendOrderEmail=");
        sb.append(getSendOrderEmail());
        sb.append(", sendShippingEmail=");
        sb.append(getSendShippingEmail());
        sb.append(", shippingMethodId=");
        sb.append(getShippingMethodId());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(163);

        sb.append("<model><model-name>");
        sb.append("com.fsquare.shopping.model.ShoppingOrder");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>shoppingOrderId</column-name><column-value><![CDATA[");
        sb.append(getShoppingOrderId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>groupId</column-name><column-value><![CDATA[");
        sb.append(getGroupId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>companyId</column-name><column-value><![CDATA[");
        sb.append(getCompanyId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userId</column-name><column-value><![CDATA[");
        sb.append(getUserId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userName</column-name><column-value><![CDATA[");
        sb.append(getUserName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>createDate</column-name><column-value><![CDATA[");
        sb.append(getCreateDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
        sb.append(getModifiedDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>status</column-name><column-value><![CDATA[");
        sb.append(getStatus());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>number</column-name><column-value><![CDATA[");
        sb.append(getNumber());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>tax</column-name><column-value><![CDATA[");
        sb.append(getTax());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>shipping</column-name><column-value><![CDATA[");
        sb.append(getShipping());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>altShipping</column-name><column-value><![CDATA[");
        sb.append(getAltShipping());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>requiresShipping</column-name><column-value><![CDATA[");
        sb.append(getRequiresShipping());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>insure</column-name><column-value><![CDATA[");
        sb.append(getInsure());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>insurance</column-name><column-value><![CDATA[");
        sb.append(getInsurance());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>couponCodes</column-name><column-value><![CDATA[");
        sb.append(getCouponCodes());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>couponDiscount</column-name><column-value><![CDATA[");
        sb.append(getCouponDiscount());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>billingFirstName</column-name><column-value><![CDATA[");
        sb.append(getBillingFirstName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>billingLastName</column-name><column-value><![CDATA[");
        sb.append(getBillingLastName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>billingEmailAddress</column-name><column-value><![CDATA[");
        sb.append(getBillingEmailAddress());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>billingCompany</column-name><column-value><![CDATA[");
        sb.append(getBillingCompany());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>billingStreet</column-name><column-value><![CDATA[");
        sb.append(getBillingStreet());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>billingCity</column-name><column-value><![CDATA[");
        sb.append(getBillingCity());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>billingState</column-name><column-value><![CDATA[");
        sb.append(getBillingState());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>billingZip</column-name><column-value><![CDATA[");
        sb.append(getBillingZip());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>billingCountry</column-name><column-value><![CDATA[");
        sb.append(getBillingCountry());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>billingPhone</column-name><column-value><![CDATA[");
        sb.append(getBillingPhone());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>shipToBilling</column-name><column-value><![CDATA[");
        sb.append(getShipToBilling());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>shippingFirstName</column-name><column-value><![CDATA[");
        sb.append(getShippingFirstName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>shippingLastName</column-name><column-value><![CDATA[");
        sb.append(getShippingLastName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>shippingEmailAddress</column-name><column-value><![CDATA[");
        sb.append(getShippingEmailAddress());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>shippingCompany</column-name><column-value><![CDATA[");
        sb.append(getShippingCompany());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>shippingStreet</column-name><column-value><![CDATA[");
        sb.append(getShippingStreet());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>shippingCity</column-name><column-value><![CDATA[");
        sb.append(getShippingCity());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>shippingState</column-name><column-value><![CDATA[");
        sb.append(getShippingState());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>shippingZip</column-name><column-value><![CDATA[");
        sb.append(getShippingZip());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>shippingCountry</column-name><column-value><![CDATA[");
        sb.append(getShippingCountry());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>shippingPhone</column-name><column-value><![CDATA[");
        sb.append(getShippingPhone());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>ccName</column-name><column-value><![CDATA[");
        sb.append(getCcName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>ccType</column-name><column-value><![CDATA[");
        sb.append(getCcType());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>ccNumber</column-name><column-value><![CDATA[");
        sb.append(getCcNumber());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>ccExpMonth</column-name><column-value><![CDATA[");
        sb.append(getCcExpMonth());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>ccExpYear</column-name><column-value><![CDATA[");
        sb.append(getCcExpYear());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>ccVerNumber</column-name><column-value><![CDATA[");
        sb.append(getCcVerNumber());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>comments</column-name><column-value><![CDATA[");
        sb.append(getComments());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>ppTxnId</column-name><column-value><![CDATA[");
        sb.append(getPpTxnId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>ppPaymentStatus</column-name><column-value><![CDATA[");
        sb.append(getPpPaymentStatus());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>ppPaymentGross</column-name><column-value><![CDATA[");
        sb.append(getPpPaymentGross());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>ppReceiverEmail</column-name><column-value><![CDATA[");
        sb.append(getPpReceiverEmail());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>ppPayerEmail</column-name><column-value><![CDATA[");
        sb.append(getPpPayerEmail());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>sendOrderEmail</column-name><column-value><![CDATA[");
        sb.append(getSendOrderEmail());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>sendShippingEmail</column-name><column-value><![CDATA[");
        sb.append(getSendShippingEmail());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>shippingMethodId</column-name><column-value><![CDATA[");
        sb.append(getShippingMethodId());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
