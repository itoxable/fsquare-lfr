package com.fsquare.shopping.model.impl;

import com.fsquare.shopping.model.ShoppingOrder;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ShoppingOrder in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingOrder
 * @generated
 */
public class ShoppingOrderCacheModel implements CacheModel<ShoppingOrder>,
    Externalizable {
    public long shoppingOrderId;
    public long groupId;
    public long companyId;
    public long userId;
    public String userName;
    public long createDate;
    public long modifiedDate;
    public String status;
    public String number;
    public double tax;
    public double shipping;
    public double totalPrice;
    public String altShipping;
    public boolean requiresShipping;
    public boolean insure;
    public double insurance;
    public String couponCodes;
    public double couponDiscount;
    public String paymentStatus;
    public String billingFirstName;
    public String billingLastName;
    public String billingEmailAddress;
    public String billingCompany;
    public String billingStreet;
    public String billingCity;
    public String billingState;
    public String billingZip;
    public String billingCountry;
    public String billingPhone;
    public boolean shipToBilling;
    public String shippingFirstName;
    public String shippingLastName;
    public String shippingEmailAddress;
    public String shippingCompany;
    public String shippingStreet;
    public String shippingStreet2;
    public String shippingCity;
    public String shippingState;
    public String shippingPostCode;
    public String shippingCountry;
    public String shippingPhone;
    public String ccName;
    public String ccType;
    public String ccNumber;
    public int ccExpMonth;
    public int ccExpYear;
    public String ccVerNumber;
    public String comments;
    public String externalPaymentId;
    public String ppTxnId;
    public String ppPaymentStatus;
    public double ppPaymentGross;
    public String ppReceiverEmail;
    public String ppPayerEmail;
    public boolean sendOrderEmail;
    public boolean sendShippingEmail;
    public long shippingMethodId;
    public boolean international;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(117);

        sb.append("{shoppingOrderId=");
        sb.append(shoppingOrderId);
        sb.append(", groupId=");
        sb.append(groupId);
        sb.append(", companyId=");
        sb.append(companyId);
        sb.append(", userId=");
        sb.append(userId);
        sb.append(", userName=");
        sb.append(userName);
        sb.append(", createDate=");
        sb.append(createDate);
        sb.append(", modifiedDate=");
        sb.append(modifiedDate);
        sb.append(", status=");
        sb.append(status);
        sb.append(", number=");
        sb.append(number);
        sb.append(", tax=");
        sb.append(tax);
        sb.append(", shipping=");
        sb.append(shipping);
        sb.append(", totalPrice=");
        sb.append(totalPrice);
        sb.append(", altShipping=");
        sb.append(altShipping);
        sb.append(", requiresShipping=");
        sb.append(requiresShipping);
        sb.append(", insure=");
        sb.append(insure);
        sb.append(", insurance=");
        sb.append(insurance);
        sb.append(", couponCodes=");
        sb.append(couponCodes);
        sb.append(", couponDiscount=");
        sb.append(couponDiscount);
        sb.append(", paymentStatus=");
        sb.append(paymentStatus);
        sb.append(", billingFirstName=");
        sb.append(billingFirstName);
        sb.append(", billingLastName=");
        sb.append(billingLastName);
        sb.append(", billingEmailAddress=");
        sb.append(billingEmailAddress);
        sb.append(", billingCompany=");
        sb.append(billingCompany);
        sb.append(", billingStreet=");
        sb.append(billingStreet);
        sb.append(", billingCity=");
        sb.append(billingCity);
        sb.append(", billingState=");
        sb.append(billingState);
        sb.append(", billingZip=");
        sb.append(billingZip);
        sb.append(", billingCountry=");
        sb.append(billingCountry);
        sb.append(", billingPhone=");
        sb.append(billingPhone);
        sb.append(", shipToBilling=");
        sb.append(shipToBilling);
        sb.append(", shippingFirstName=");
        sb.append(shippingFirstName);
        sb.append(", shippingLastName=");
        sb.append(shippingLastName);
        sb.append(", shippingEmailAddress=");
        sb.append(shippingEmailAddress);
        sb.append(", shippingCompany=");
        sb.append(shippingCompany);
        sb.append(", shippingStreet=");
        sb.append(shippingStreet);
        sb.append(", shippingStreet2=");
        sb.append(shippingStreet2);
        sb.append(", shippingCity=");
        sb.append(shippingCity);
        sb.append(", shippingState=");
        sb.append(shippingState);
        sb.append(", shippingPostCode=");
        sb.append(shippingPostCode);
        sb.append(", shippingCountry=");
        sb.append(shippingCountry);
        sb.append(", shippingPhone=");
        sb.append(shippingPhone);
        sb.append(", ccName=");
        sb.append(ccName);
        sb.append(", ccType=");
        sb.append(ccType);
        sb.append(", ccNumber=");
        sb.append(ccNumber);
        sb.append(", ccExpMonth=");
        sb.append(ccExpMonth);
        sb.append(", ccExpYear=");
        sb.append(ccExpYear);
        sb.append(", ccVerNumber=");
        sb.append(ccVerNumber);
        sb.append(", comments=");
        sb.append(comments);
        sb.append(", externalPaymentId=");
        sb.append(externalPaymentId);
        sb.append(", ppTxnId=");
        sb.append(ppTxnId);
        sb.append(", ppPaymentStatus=");
        sb.append(ppPaymentStatus);
        sb.append(", ppPaymentGross=");
        sb.append(ppPaymentGross);
        sb.append(", ppReceiverEmail=");
        sb.append(ppReceiverEmail);
        sb.append(", ppPayerEmail=");
        sb.append(ppPayerEmail);
        sb.append(", sendOrderEmail=");
        sb.append(sendOrderEmail);
        sb.append(", sendShippingEmail=");
        sb.append(sendShippingEmail);
        sb.append(", shippingMethodId=");
        sb.append(shippingMethodId);
        sb.append(", international=");
        sb.append(international);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public ShoppingOrder toEntityModel() {
        ShoppingOrderImpl shoppingOrderImpl = new ShoppingOrderImpl();

        shoppingOrderImpl.setShoppingOrderId(shoppingOrderId);
        shoppingOrderImpl.setGroupId(groupId);
        shoppingOrderImpl.setCompanyId(companyId);
        shoppingOrderImpl.setUserId(userId);

        if (userName == null) {
            shoppingOrderImpl.setUserName(StringPool.BLANK);
        } else {
            shoppingOrderImpl.setUserName(userName);
        }

        if (createDate == Long.MIN_VALUE) {
            shoppingOrderImpl.setCreateDate(null);
        } else {
            shoppingOrderImpl.setCreateDate(new Date(createDate));
        }

        if (modifiedDate == Long.MIN_VALUE) {
            shoppingOrderImpl.setModifiedDate(null);
        } else {
            shoppingOrderImpl.setModifiedDate(new Date(modifiedDate));
        }

        if (status == null) {
            shoppingOrderImpl.setStatus(StringPool.BLANK);
        } else {
            shoppingOrderImpl.setStatus(status);
        }

        if (number == null) {
            shoppingOrderImpl.setNumber(StringPool.BLANK);
        } else {
            shoppingOrderImpl.setNumber(number);
        }

        shoppingOrderImpl.setTax(tax);
        shoppingOrderImpl.setShipping(shipping);
        shoppingOrderImpl.setTotalPrice(totalPrice);

        if (altShipping == null) {
            shoppingOrderImpl.setAltShipping(StringPool.BLANK);
        } else {
            shoppingOrderImpl.setAltShipping(altShipping);
        }

        shoppingOrderImpl.setRequiresShipping(requiresShipping);
        shoppingOrderImpl.setInsure(insure);
        shoppingOrderImpl.setInsurance(insurance);

        if (couponCodes == null) {
            shoppingOrderImpl.setCouponCodes(StringPool.BLANK);
        } else {
            shoppingOrderImpl.setCouponCodes(couponCodes);
        }

        shoppingOrderImpl.setCouponDiscount(couponDiscount);

        if (paymentStatus == null) {
            shoppingOrderImpl.setPaymentStatus(StringPool.BLANK);
        } else {
            shoppingOrderImpl.setPaymentStatus(paymentStatus);
        }

        if (billingFirstName == null) {
            shoppingOrderImpl.setBillingFirstName(StringPool.BLANK);
        } else {
            shoppingOrderImpl.setBillingFirstName(billingFirstName);
        }

        if (billingLastName == null) {
            shoppingOrderImpl.setBillingLastName(StringPool.BLANK);
        } else {
            shoppingOrderImpl.setBillingLastName(billingLastName);
        }

        if (billingEmailAddress == null) {
            shoppingOrderImpl.setBillingEmailAddress(StringPool.BLANK);
        } else {
            shoppingOrderImpl.setBillingEmailAddress(billingEmailAddress);
        }

        if (billingCompany == null) {
            shoppingOrderImpl.setBillingCompany(StringPool.BLANK);
        } else {
            shoppingOrderImpl.setBillingCompany(billingCompany);
        }

        if (billingStreet == null) {
            shoppingOrderImpl.setBillingStreet(StringPool.BLANK);
        } else {
            shoppingOrderImpl.setBillingStreet(billingStreet);
        }

        if (billingCity == null) {
            shoppingOrderImpl.setBillingCity(StringPool.BLANK);
        } else {
            shoppingOrderImpl.setBillingCity(billingCity);
        }

        if (billingState == null) {
            shoppingOrderImpl.setBillingState(StringPool.BLANK);
        } else {
            shoppingOrderImpl.setBillingState(billingState);
        }

        if (billingZip == null) {
            shoppingOrderImpl.setBillingZip(StringPool.BLANK);
        } else {
            shoppingOrderImpl.setBillingZip(billingZip);
        }

        if (billingCountry == null) {
            shoppingOrderImpl.setBillingCountry(StringPool.BLANK);
        } else {
            shoppingOrderImpl.setBillingCountry(billingCountry);
        }

        if (billingPhone == null) {
            shoppingOrderImpl.setBillingPhone(StringPool.BLANK);
        } else {
            shoppingOrderImpl.setBillingPhone(billingPhone);
        }

        shoppingOrderImpl.setShipToBilling(shipToBilling);

        if (shippingFirstName == null) {
            shoppingOrderImpl.setShippingFirstName(StringPool.BLANK);
        } else {
            shoppingOrderImpl.setShippingFirstName(shippingFirstName);
        }

        if (shippingLastName == null) {
            shoppingOrderImpl.setShippingLastName(StringPool.BLANK);
        } else {
            shoppingOrderImpl.setShippingLastName(shippingLastName);
        }

        if (shippingEmailAddress == null) {
            shoppingOrderImpl.setShippingEmailAddress(StringPool.BLANK);
        } else {
            shoppingOrderImpl.setShippingEmailAddress(shippingEmailAddress);
        }

        if (shippingCompany == null) {
            shoppingOrderImpl.setShippingCompany(StringPool.BLANK);
        } else {
            shoppingOrderImpl.setShippingCompany(shippingCompany);
        }

        if (shippingStreet == null) {
            shoppingOrderImpl.setShippingStreet(StringPool.BLANK);
        } else {
            shoppingOrderImpl.setShippingStreet(shippingStreet);
        }

        if (shippingStreet2 == null) {
            shoppingOrderImpl.setShippingStreet2(StringPool.BLANK);
        } else {
            shoppingOrderImpl.setShippingStreet2(shippingStreet2);
        }

        if (shippingCity == null) {
            shoppingOrderImpl.setShippingCity(StringPool.BLANK);
        } else {
            shoppingOrderImpl.setShippingCity(shippingCity);
        }

        if (shippingState == null) {
            shoppingOrderImpl.setShippingState(StringPool.BLANK);
        } else {
            shoppingOrderImpl.setShippingState(shippingState);
        }

        if (shippingPostCode == null) {
            shoppingOrderImpl.setShippingPostCode(StringPool.BLANK);
        } else {
            shoppingOrderImpl.setShippingPostCode(shippingPostCode);
        }

        if (shippingCountry == null) {
            shoppingOrderImpl.setShippingCountry(StringPool.BLANK);
        } else {
            shoppingOrderImpl.setShippingCountry(shippingCountry);
        }

        if (shippingPhone == null) {
            shoppingOrderImpl.setShippingPhone(StringPool.BLANK);
        } else {
            shoppingOrderImpl.setShippingPhone(shippingPhone);
        }

        if (ccName == null) {
            shoppingOrderImpl.setCcName(StringPool.BLANK);
        } else {
            shoppingOrderImpl.setCcName(ccName);
        }

        if (ccType == null) {
            shoppingOrderImpl.setCcType(StringPool.BLANK);
        } else {
            shoppingOrderImpl.setCcType(ccType);
        }

        if (ccNumber == null) {
            shoppingOrderImpl.setCcNumber(StringPool.BLANK);
        } else {
            shoppingOrderImpl.setCcNumber(ccNumber);
        }

        shoppingOrderImpl.setCcExpMonth(ccExpMonth);
        shoppingOrderImpl.setCcExpYear(ccExpYear);

        if (ccVerNumber == null) {
            shoppingOrderImpl.setCcVerNumber(StringPool.BLANK);
        } else {
            shoppingOrderImpl.setCcVerNumber(ccVerNumber);
        }

        if (comments == null) {
            shoppingOrderImpl.setComments(StringPool.BLANK);
        } else {
            shoppingOrderImpl.setComments(comments);
        }

        if (externalPaymentId == null) {
            shoppingOrderImpl.setExternalPaymentId(StringPool.BLANK);
        } else {
            shoppingOrderImpl.setExternalPaymentId(externalPaymentId);
        }

        if (ppTxnId == null) {
            shoppingOrderImpl.setPpTxnId(StringPool.BLANK);
        } else {
            shoppingOrderImpl.setPpTxnId(ppTxnId);
        }

        if (ppPaymentStatus == null) {
            shoppingOrderImpl.setPpPaymentStatus(StringPool.BLANK);
        } else {
            shoppingOrderImpl.setPpPaymentStatus(ppPaymentStatus);
        }

        shoppingOrderImpl.setPpPaymentGross(ppPaymentGross);

        if (ppReceiverEmail == null) {
            shoppingOrderImpl.setPpReceiverEmail(StringPool.BLANK);
        } else {
            shoppingOrderImpl.setPpReceiverEmail(ppReceiverEmail);
        }

        if (ppPayerEmail == null) {
            shoppingOrderImpl.setPpPayerEmail(StringPool.BLANK);
        } else {
            shoppingOrderImpl.setPpPayerEmail(ppPayerEmail);
        }

        shoppingOrderImpl.setSendOrderEmail(sendOrderEmail);
        shoppingOrderImpl.setSendShippingEmail(sendShippingEmail);
        shoppingOrderImpl.setShippingMethodId(shippingMethodId);
        shoppingOrderImpl.setInternational(international);

        shoppingOrderImpl.resetOriginalValues();

        return shoppingOrderImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        shoppingOrderId = objectInput.readLong();
        groupId = objectInput.readLong();
        companyId = objectInput.readLong();
        userId = objectInput.readLong();
        userName = objectInput.readUTF();
        createDate = objectInput.readLong();
        modifiedDate = objectInput.readLong();
        status = objectInput.readUTF();
        number = objectInput.readUTF();
        tax = objectInput.readDouble();
        shipping = objectInput.readDouble();
        totalPrice = objectInput.readDouble();
        altShipping = objectInput.readUTF();
        requiresShipping = objectInput.readBoolean();
        insure = objectInput.readBoolean();
        insurance = objectInput.readDouble();
        couponCodes = objectInput.readUTF();
        couponDiscount = objectInput.readDouble();
        paymentStatus = objectInput.readUTF();
        billingFirstName = objectInput.readUTF();
        billingLastName = objectInput.readUTF();
        billingEmailAddress = objectInput.readUTF();
        billingCompany = objectInput.readUTF();
        billingStreet = objectInput.readUTF();
        billingCity = objectInput.readUTF();
        billingState = objectInput.readUTF();
        billingZip = objectInput.readUTF();
        billingCountry = objectInput.readUTF();
        billingPhone = objectInput.readUTF();
        shipToBilling = objectInput.readBoolean();
        shippingFirstName = objectInput.readUTF();
        shippingLastName = objectInput.readUTF();
        shippingEmailAddress = objectInput.readUTF();
        shippingCompany = objectInput.readUTF();
        shippingStreet = objectInput.readUTF();
        shippingStreet2 = objectInput.readUTF();
        shippingCity = objectInput.readUTF();
        shippingState = objectInput.readUTF();
        shippingPostCode = objectInput.readUTF();
        shippingCountry = objectInput.readUTF();
        shippingPhone = objectInput.readUTF();
        ccName = objectInput.readUTF();
        ccType = objectInput.readUTF();
        ccNumber = objectInput.readUTF();
        ccExpMonth = objectInput.readInt();
        ccExpYear = objectInput.readInt();
        ccVerNumber = objectInput.readUTF();
        comments = objectInput.readUTF();
        externalPaymentId = objectInput.readUTF();
        ppTxnId = objectInput.readUTF();
        ppPaymentStatus = objectInput.readUTF();
        ppPaymentGross = objectInput.readDouble();
        ppReceiverEmail = objectInput.readUTF();
        ppPayerEmail = objectInput.readUTF();
        sendOrderEmail = objectInput.readBoolean();
        sendShippingEmail = objectInput.readBoolean();
        shippingMethodId = objectInput.readLong();
        international = objectInput.readBoolean();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(shoppingOrderId);
        objectOutput.writeLong(groupId);
        objectOutput.writeLong(companyId);
        objectOutput.writeLong(userId);

        if (userName == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(userName);
        }

        objectOutput.writeLong(createDate);
        objectOutput.writeLong(modifiedDate);

        if (status == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(status);
        }

        if (number == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(number);
        }

        objectOutput.writeDouble(tax);
        objectOutput.writeDouble(shipping);
        objectOutput.writeDouble(totalPrice);

        if (altShipping == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(altShipping);
        }

        objectOutput.writeBoolean(requiresShipping);
        objectOutput.writeBoolean(insure);
        objectOutput.writeDouble(insurance);

        if (couponCodes == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(couponCodes);
        }

        objectOutput.writeDouble(couponDiscount);

        if (paymentStatus == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(paymentStatus);
        }

        if (billingFirstName == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(billingFirstName);
        }

        if (billingLastName == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(billingLastName);
        }

        if (billingEmailAddress == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(billingEmailAddress);
        }

        if (billingCompany == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(billingCompany);
        }

        if (billingStreet == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(billingStreet);
        }

        if (billingCity == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(billingCity);
        }

        if (billingState == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(billingState);
        }

        if (billingZip == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(billingZip);
        }

        if (billingCountry == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(billingCountry);
        }

        if (billingPhone == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(billingPhone);
        }

        objectOutput.writeBoolean(shipToBilling);

        if (shippingFirstName == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(shippingFirstName);
        }

        if (shippingLastName == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(shippingLastName);
        }

        if (shippingEmailAddress == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(shippingEmailAddress);
        }

        if (shippingCompany == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(shippingCompany);
        }

        if (shippingStreet == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(shippingStreet);
        }

        if (shippingStreet2 == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(shippingStreet2);
        }

        if (shippingCity == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(shippingCity);
        }

        if (shippingState == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(shippingState);
        }

        if (shippingPostCode == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(shippingPostCode);
        }

        if (shippingCountry == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(shippingCountry);
        }

        if (shippingPhone == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(shippingPhone);
        }

        if (ccName == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(ccName);
        }

        if (ccType == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(ccType);
        }

        if (ccNumber == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(ccNumber);
        }

        objectOutput.writeInt(ccExpMonth);
        objectOutput.writeInt(ccExpYear);

        if (ccVerNumber == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(ccVerNumber);
        }

        if (comments == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(comments);
        }

        if (externalPaymentId == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(externalPaymentId);
        }

        if (ppTxnId == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(ppTxnId);
        }

        if (ppPaymentStatus == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(ppPaymentStatus);
        }

        objectOutput.writeDouble(ppPaymentGross);

        if (ppReceiverEmail == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(ppReceiverEmail);
        }

        if (ppPayerEmail == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(ppPayerEmail);
        }

        objectOutput.writeBoolean(sendOrderEmail);
        objectOutput.writeBoolean(sendShippingEmail);
        objectOutput.writeLong(shippingMethodId);
        objectOutput.writeBoolean(international);
    }
}
