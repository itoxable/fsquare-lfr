package com.fsquare.shopping.model.impl;

import com.fsquare.shopping.model.ShoppingStore;
import com.fsquare.shopping.model.ShoppingStoreModel;
import com.fsquare.shopping.model.ShoppingStoreSoap;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the ShoppingStore service. Represents a row in the &quot;FsquareShopping_ShoppingStore&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.fsquare.shopping.model.ShoppingStoreModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ShoppingStoreImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingStoreImpl
 * @see com.fsquare.shopping.model.ShoppingStore
 * @see com.fsquare.shopping.model.ShoppingStoreModel
 * @generated
 */
@JSON(strict = true)
public class ShoppingStoreModelImpl extends BaseModelImpl<ShoppingStore>
    implements ShoppingStoreModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a shopping store model instance should use the {@link com.fsquare.shopping.model.ShoppingStore} interface instead.
     */
    public static final String TABLE_NAME = "FsquareShopping_ShoppingStore";
    public static final Object[][] TABLE_COLUMNS = {
            { "groupId", Types.BIGINT },
            { "companyId", Types.BIGINT },
            { "userId", Types.BIGINT },
            { "userName", Types.VARCHAR },
            { "createDate", Types.TIMESTAMP },
            { "modifiedDate", Types.TIMESTAMP },
            { "cartPageUuid", Types.VARCHAR },
            { "checkoutPageUuid", Types.VARCHAR },
            { "onAddToCart", Types.VARCHAR },
            { "currency_", Types.VARCHAR },
            { "country", Types.VARCHAR },
            { "userTypes", Types.VARCHAR },
            { "integrateWithStripe", Types.BOOLEAN },
            { "stripeTestSecretKey", Types.VARCHAR },
            { "stripeTestPublishableKey", Types.VARCHAR },
            { "stripeTesting", Types.BOOLEAN },
            { "stripeLiveSecretKey", Types.VARCHAR },
            { "stripeLivePublishableKey", Types.VARCHAR },
            { "stripeApiVersion", Types.VARCHAR }
        };
    public static final String TABLE_SQL_CREATE = "create table FsquareShopping_ShoppingStore (groupId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,cartPageUuid VARCHAR(75) null,checkoutPageUuid VARCHAR(75) null,onAddToCart VARCHAR(75) null,currency_ VARCHAR(75) null,country VARCHAR(75) null,userTypes VARCHAR(75) null,integrateWithStripe BOOLEAN,stripeTestSecretKey VARCHAR(75) null,stripeTestPublishableKey VARCHAR(75) null,stripeTesting BOOLEAN,stripeLiveSecretKey VARCHAR(75) null,stripeLivePublishableKey VARCHAR(75) null,stripeApiVersion VARCHAR(75) null)";
    public static final String TABLE_SQL_DROP = "drop table FsquareShopping_ShoppingStore";
    public static final String ORDER_BY_JPQL = " ORDER BY shoppingStore.groupId ASC";
    public static final String ORDER_BY_SQL = " ORDER BY FsquareShopping_ShoppingStore.groupId ASC";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.com.fsquare.shopping.model.ShoppingStore"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.com.fsquare.shopping.model.ShoppingStore"),
            true);
    public static final boolean COLUMN_BITMASK_ENABLED = false;
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.com.fsquare.shopping.model.ShoppingStore"));
    private static ClassLoader _classLoader = ShoppingStore.class.getClassLoader();
    private static Class<?>[] _escapedModelInterfaces = new Class[] {
            ShoppingStore.class
        };
    private long _groupId;
    private long _companyId;
    private long _userId;
    private String _userUuid;
    private String _userName;
    private Date _createDate;
    private Date _modifiedDate;
    private String _cartPageUuid;
    private String _checkoutPageUuid;
    private String _onAddToCart;
    private String _currency;
    private String _country;
    private String _userTypes;
    private boolean _integrateWithStripe;
    private String _stripeTestSecretKey;
    private String _stripeTestPublishableKey;
    private boolean _stripeTesting;
    private String _stripeLiveSecretKey;
    private String _stripeLivePublishableKey;
    private String _stripeApiVersion;
    private ShoppingStore _escapedModel;

    public ShoppingStoreModelImpl() {
    }

    /**
     * Converts the soap model instance into a normal model instance.
     *
     * @param soapModel the soap model instance to convert
     * @return the normal model instance
     */
    public static ShoppingStore toModel(ShoppingStoreSoap soapModel) {
        if (soapModel == null) {
            return null;
        }

        ShoppingStore model = new ShoppingStoreImpl();

        model.setGroupId(soapModel.getGroupId());
        model.setCompanyId(soapModel.getCompanyId());
        model.setUserId(soapModel.getUserId());
        model.setUserName(soapModel.getUserName());
        model.setCreateDate(soapModel.getCreateDate());
        model.setModifiedDate(soapModel.getModifiedDate());
        model.setCartPageUuid(soapModel.getCartPageUuid());
        model.setCheckoutPageUuid(soapModel.getCheckoutPageUuid());
        model.setOnAddToCart(soapModel.getOnAddToCart());
        model.setCurrency(soapModel.getCurrency());
        model.setCountry(soapModel.getCountry());
        model.setUserTypes(soapModel.getUserTypes());
        model.setIntegrateWithStripe(soapModel.getIntegrateWithStripe());
        model.setStripeTestSecretKey(soapModel.getStripeTestSecretKey());
        model.setStripeTestPublishableKey(soapModel.getStripeTestPublishableKey());
        model.setStripeTesting(soapModel.getStripeTesting());
        model.setStripeLiveSecretKey(soapModel.getStripeLiveSecretKey());
        model.setStripeLivePublishableKey(soapModel.getStripeLivePublishableKey());
        model.setStripeApiVersion(soapModel.getStripeApiVersion());

        return model;
    }

    /**
     * Converts the soap model instances into normal model instances.
     *
     * @param soapModels the soap model instances to convert
     * @return the normal model instances
     */
    public static List<ShoppingStore> toModels(ShoppingStoreSoap[] soapModels) {
        if (soapModels == null) {
            return null;
        }

        List<ShoppingStore> models = new ArrayList<ShoppingStore>(soapModels.length);

        for (ShoppingStoreSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    @Override
    public long getPrimaryKey() {
        return _groupId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setGroupId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _groupId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Class<?> getModelClass() {
        return ShoppingStore.class;
    }

    @Override
    public String getModelClassName() {
        return ShoppingStore.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("groupId", getGroupId());
        attributes.put("companyId", getCompanyId());
        attributes.put("userId", getUserId());
        attributes.put("userName", getUserName());
        attributes.put("createDate", getCreateDate());
        attributes.put("modifiedDate", getModifiedDate());
        attributes.put("cartPageUuid", getCartPageUuid());
        attributes.put("checkoutPageUuid", getCheckoutPageUuid());
        attributes.put("onAddToCart", getOnAddToCart());
        attributes.put("currency", getCurrency());
        attributes.put("country", getCountry());
        attributes.put("userTypes", getUserTypes());
        attributes.put("integrateWithStripe", getIntegrateWithStripe());
        attributes.put("stripeTestSecretKey", getStripeTestSecretKey());
        attributes.put("stripeTestPublishableKey", getStripeTestPublishableKey());
        attributes.put("stripeTesting", getStripeTesting());
        attributes.put("stripeLiveSecretKey", getStripeLiveSecretKey());
        attributes.put("stripeLivePublishableKey", getStripeLivePublishableKey());
        attributes.put("stripeApiVersion", getStripeApiVersion());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
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

        String cartPageUuid = (String) attributes.get("cartPageUuid");

        if (cartPageUuid != null) {
            setCartPageUuid(cartPageUuid);
        }

        String checkoutPageUuid = (String) attributes.get("checkoutPageUuid");

        if (checkoutPageUuid != null) {
            setCheckoutPageUuid(checkoutPageUuid);
        }

        String onAddToCart = (String) attributes.get("onAddToCart");

        if (onAddToCart != null) {
            setOnAddToCart(onAddToCart);
        }

        String currency = (String) attributes.get("currency");

        if (currency != null) {
            setCurrency(currency);
        }

        String country = (String) attributes.get("country");

        if (country != null) {
            setCountry(country);
        }

        String userTypes = (String) attributes.get("userTypes");

        if (userTypes != null) {
            setUserTypes(userTypes);
        }

        Boolean integrateWithStripe = (Boolean) attributes.get(
                "integrateWithStripe");

        if (integrateWithStripe != null) {
            setIntegrateWithStripe(integrateWithStripe);
        }

        String stripeTestSecretKey = (String) attributes.get(
                "stripeTestSecretKey");

        if (stripeTestSecretKey != null) {
            setStripeTestSecretKey(stripeTestSecretKey);
        }

        String stripeTestPublishableKey = (String) attributes.get(
                "stripeTestPublishableKey");

        if (stripeTestPublishableKey != null) {
            setStripeTestPublishableKey(stripeTestPublishableKey);
        }

        Boolean stripeTesting = (Boolean) attributes.get("stripeTesting");

        if (stripeTesting != null) {
            setStripeTesting(stripeTesting);
        }

        String stripeLiveSecretKey = (String) attributes.get(
                "stripeLiveSecretKey");

        if (stripeLiveSecretKey != null) {
            setStripeLiveSecretKey(stripeLiveSecretKey);
        }

        String stripeLivePublishableKey = (String) attributes.get(
                "stripeLivePublishableKey");

        if (stripeLivePublishableKey != null) {
            setStripeLivePublishableKey(stripeLivePublishableKey);
        }

        String stripeApiVersion = (String) attributes.get("stripeApiVersion");

        if (stripeApiVersion != null) {
            setStripeApiVersion(stripeApiVersion);
        }
    }

    @JSON
    @Override
    public long getGroupId() {
        return _groupId;
    }

    @Override
    public void setGroupId(long groupId) {
        _groupId = groupId;
    }

    @JSON
    @Override
    public long getCompanyId() {
        return _companyId;
    }

    @Override
    public void setCompanyId(long companyId) {
        _companyId = companyId;
    }

    @JSON
    @Override
    public long getUserId() {
        return _userId;
    }

    @Override
    public void setUserId(long userId) {
        _userId = userId;
    }

    @Override
    public String getUserUuid() throws SystemException {
        return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
    }

    @Override
    public void setUserUuid(String userUuid) {
        _userUuid = userUuid;
    }

    @JSON
    @Override
    public String getUserName() {
        if (_userName == null) {
            return StringPool.BLANK;
        } else {
            return _userName;
        }
    }

    @Override
    public void setUserName(String userName) {
        _userName = userName;
    }

    @JSON
    @Override
    public Date getCreateDate() {
        return _createDate;
    }

    @Override
    public void setCreateDate(Date createDate) {
        _createDate = createDate;
    }

    @JSON
    @Override
    public Date getModifiedDate() {
        return _modifiedDate;
    }

    @Override
    public void setModifiedDate(Date modifiedDate) {
        _modifiedDate = modifiedDate;
    }

    @JSON
    @Override
    public String getCartPageUuid() {
        if (_cartPageUuid == null) {
            return StringPool.BLANK;
        } else {
            return _cartPageUuid;
        }
    }

    @Override
    public void setCartPageUuid(String cartPageUuid) {
        _cartPageUuid = cartPageUuid;
    }

    @JSON
    @Override
    public String getCheckoutPageUuid() {
        if (_checkoutPageUuid == null) {
            return StringPool.BLANK;
        } else {
            return _checkoutPageUuid;
        }
    }

    @Override
    public void setCheckoutPageUuid(String checkoutPageUuid) {
        _checkoutPageUuid = checkoutPageUuid;
    }

    @JSON
    @Override
    public String getOnAddToCart() {
        if (_onAddToCart == null) {
            return StringPool.BLANK;
        } else {
            return _onAddToCart;
        }
    }

    @Override
    public void setOnAddToCart(String onAddToCart) {
        _onAddToCart = onAddToCart;
    }

    @JSON
    @Override
    public String getCurrency() {
        if (_currency == null) {
            return StringPool.BLANK;
        } else {
            return _currency;
        }
    }

    @Override
    public void setCurrency(String currency) {
        _currency = currency;
    }

    @JSON
    @Override
    public String getCountry() {
        if (_country == null) {
            return StringPool.BLANK;
        } else {
            return _country;
        }
    }

    @Override
    public void setCountry(String country) {
        _country = country;
    }

    @JSON
    @Override
    public String getUserTypes() {
        if (_userTypes == null) {
            return StringPool.BLANK;
        } else {
            return _userTypes;
        }
    }

    @Override
    public void setUserTypes(String userTypes) {
        _userTypes = userTypes;
    }

    @JSON
    @Override
    public boolean getIntegrateWithStripe() {
        return _integrateWithStripe;
    }

    @Override
    public boolean isIntegrateWithStripe() {
        return _integrateWithStripe;
    }

    @Override
    public void setIntegrateWithStripe(boolean integrateWithStripe) {
        _integrateWithStripe = integrateWithStripe;
    }

    @JSON
    @Override
    public String getStripeTestSecretKey() {
        if (_stripeTestSecretKey == null) {
            return StringPool.BLANK;
        } else {
            return _stripeTestSecretKey;
        }
    }

    @Override
    public void setStripeTestSecretKey(String stripeTestSecretKey) {
        _stripeTestSecretKey = stripeTestSecretKey;
    }

    @JSON
    @Override
    public String getStripeTestPublishableKey() {
        if (_stripeTestPublishableKey == null) {
            return StringPool.BLANK;
        } else {
            return _stripeTestPublishableKey;
        }
    }

    @Override
    public void setStripeTestPublishableKey(String stripeTestPublishableKey) {
        _stripeTestPublishableKey = stripeTestPublishableKey;
    }

    @JSON
    @Override
    public boolean getStripeTesting() {
        return _stripeTesting;
    }

    @Override
    public boolean isStripeTesting() {
        return _stripeTesting;
    }

    @Override
    public void setStripeTesting(boolean stripeTesting) {
        _stripeTesting = stripeTesting;
    }

    @JSON
    @Override
    public String getStripeLiveSecretKey() {
        if (_stripeLiveSecretKey == null) {
            return StringPool.BLANK;
        } else {
            return _stripeLiveSecretKey;
        }
    }

    @Override
    public void setStripeLiveSecretKey(String stripeLiveSecretKey) {
        _stripeLiveSecretKey = stripeLiveSecretKey;
    }

    @JSON
    @Override
    public String getStripeLivePublishableKey() {
        if (_stripeLivePublishableKey == null) {
            return StringPool.BLANK;
        } else {
            return _stripeLivePublishableKey;
        }
    }

    @Override
    public void setStripeLivePublishableKey(String stripeLivePublishableKey) {
        _stripeLivePublishableKey = stripeLivePublishableKey;
    }

    @JSON
    @Override
    public String getStripeApiVersion() {
        if (_stripeApiVersion == null) {
            return StringPool.BLANK;
        } else {
            return _stripeApiVersion;
        }
    }

    @Override
    public void setStripeApiVersion(String stripeApiVersion) {
        _stripeApiVersion = stripeApiVersion;
    }

    @Override
    public ExpandoBridge getExpandoBridge() {
        return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
            ShoppingStore.class.getName(), getPrimaryKey());
    }

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
        ExpandoBridge expandoBridge = getExpandoBridge();

        expandoBridge.setAttributes(serviceContext);
    }

    @Override
    public ShoppingStore toEscapedModel() {
        if (_escapedModel == null) {
            _escapedModel = (ShoppingStore) ProxyUtil.newProxyInstance(_classLoader,
                    _escapedModelInterfaces, new AutoEscapeBeanHandler(this));
        }

        return _escapedModel;
    }

    @Override
    public Object clone() {
        ShoppingStoreImpl shoppingStoreImpl = new ShoppingStoreImpl();

        shoppingStoreImpl.setGroupId(getGroupId());
        shoppingStoreImpl.setCompanyId(getCompanyId());
        shoppingStoreImpl.setUserId(getUserId());
        shoppingStoreImpl.setUserName(getUserName());
        shoppingStoreImpl.setCreateDate(getCreateDate());
        shoppingStoreImpl.setModifiedDate(getModifiedDate());
        shoppingStoreImpl.setCartPageUuid(getCartPageUuid());
        shoppingStoreImpl.setCheckoutPageUuid(getCheckoutPageUuid());
        shoppingStoreImpl.setOnAddToCart(getOnAddToCart());
        shoppingStoreImpl.setCurrency(getCurrency());
        shoppingStoreImpl.setCountry(getCountry());
        shoppingStoreImpl.setUserTypes(getUserTypes());
        shoppingStoreImpl.setIntegrateWithStripe(getIntegrateWithStripe());
        shoppingStoreImpl.setStripeTestSecretKey(getStripeTestSecretKey());
        shoppingStoreImpl.setStripeTestPublishableKey(getStripeTestPublishableKey());
        shoppingStoreImpl.setStripeTesting(getStripeTesting());
        shoppingStoreImpl.setStripeLiveSecretKey(getStripeLiveSecretKey());
        shoppingStoreImpl.setStripeLivePublishableKey(getStripeLivePublishableKey());
        shoppingStoreImpl.setStripeApiVersion(getStripeApiVersion());

        shoppingStoreImpl.resetOriginalValues();

        return shoppingStoreImpl;
    }

    @Override
    public int compareTo(ShoppingStore shoppingStore) {
        long primaryKey = shoppingStore.getPrimaryKey();

        if (getPrimaryKey() < primaryKey) {
            return -1;
        } else if (getPrimaryKey() > primaryKey) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof ShoppingStore)) {
            return false;
        }

        ShoppingStore shoppingStore = (ShoppingStore) obj;

        long primaryKey = shoppingStore.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public void resetOriginalValues() {
    }

    @Override
    public CacheModel<ShoppingStore> toCacheModel() {
        ShoppingStoreCacheModel shoppingStoreCacheModel = new ShoppingStoreCacheModel();

        shoppingStoreCacheModel.groupId = getGroupId();

        shoppingStoreCacheModel.companyId = getCompanyId();

        shoppingStoreCacheModel.userId = getUserId();

        shoppingStoreCacheModel.userName = getUserName();

        String userName = shoppingStoreCacheModel.userName;

        if ((userName != null) && (userName.length() == 0)) {
            shoppingStoreCacheModel.userName = null;
        }

        Date createDate = getCreateDate();

        if (createDate != null) {
            shoppingStoreCacheModel.createDate = createDate.getTime();
        } else {
            shoppingStoreCacheModel.createDate = Long.MIN_VALUE;
        }

        Date modifiedDate = getModifiedDate();

        if (modifiedDate != null) {
            shoppingStoreCacheModel.modifiedDate = modifiedDate.getTime();
        } else {
            shoppingStoreCacheModel.modifiedDate = Long.MIN_VALUE;
        }

        shoppingStoreCacheModel.cartPageUuid = getCartPageUuid();

        String cartPageUuid = shoppingStoreCacheModel.cartPageUuid;

        if ((cartPageUuid != null) && (cartPageUuid.length() == 0)) {
            shoppingStoreCacheModel.cartPageUuid = null;
        }

        shoppingStoreCacheModel.checkoutPageUuid = getCheckoutPageUuid();

        String checkoutPageUuid = shoppingStoreCacheModel.checkoutPageUuid;

        if ((checkoutPageUuid != null) && (checkoutPageUuid.length() == 0)) {
            shoppingStoreCacheModel.checkoutPageUuid = null;
        }

        shoppingStoreCacheModel.onAddToCart = getOnAddToCart();

        String onAddToCart = shoppingStoreCacheModel.onAddToCart;

        if ((onAddToCart != null) && (onAddToCart.length() == 0)) {
            shoppingStoreCacheModel.onAddToCart = null;
        }

        shoppingStoreCacheModel.currency = getCurrency();

        String currency = shoppingStoreCacheModel.currency;

        if ((currency != null) && (currency.length() == 0)) {
            shoppingStoreCacheModel.currency = null;
        }

        shoppingStoreCacheModel.country = getCountry();

        String country = shoppingStoreCacheModel.country;

        if ((country != null) && (country.length() == 0)) {
            shoppingStoreCacheModel.country = null;
        }

        shoppingStoreCacheModel.userTypes = getUserTypes();

        String userTypes = shoppingStoreCacheModel.userTypes;

        if ((userTypes != null) && (userTypes.length() == 0)) {
            shoppingStoreCacheModel.userTypes = null;
        }

        shoppingStoreCacheModel.integrateWithStripe = getIntegrateWithStripe();

        shoppingStoreCacheModel.stripeTestSecretKey = getStripeTestSecretKey();

        String stripeTestSecretKey = shoppingStoreCacheModel.stripeTestSecretKey;

        if ((stripeTestSecretKey != null) &&
                (stripeTestSecretKey.length() == 0)) {
            shoppingStoreCacheModel.stripeTestSecretKey = null;
        }

        shoppingStoreCacheModel.stripeTestPublishableKey = getStripeTestPublishableKey();

        String stripeTestPublishableKey = shoppingStoreCacheModel.stripeTestPublishableKey;

        if ((stripeTestPublishableKey != null) &&
                (stripeTestPublishableKey.length() == 0)) {
            shoppingStoreCacheModel.stripeTestPublishableKey = null;
        }

        shoppingStoreCacheModel.stripeTesting = getStripeTesting();

        shoppingStoreCacheModel.stripeLiveSecretKey = getStripeLiveSecretKey();

        String stripeLiveSecretKey = shoppingStoreCacheModel.stripeLiveSecretKey;

        if ((stripeLiveSecretKey != null) &&
                (stripeLiveSecretKey.length() == 0)) {
            shoppingStoreCacheModel.stripeLiveSecretKey = null;
        }

        shoppingStoreCacheModel.stripeLivePublishableKey = getStripeLivePublishableKey();

        String stripeLivePublishableKey = shoppingStoreCacheModel.stripeLivePublishableKey;

        if ((stripeLivePublishableKey != null) &&
                (stripeLivePublishableKey.length() == 0)) {
            shoppingStoreCacheModel.stripeLivePublishableKey = null;
        }

        shoppingStoreCacheModel.stripeApiVersion = getStripeApiVersion();

        String stripeApiVersion = shoppingStoreCacheModel.stripeApiVersion;

        if ((stripeApiVersion != null) && (stripeApiVersion.length() == 0)) {
            shoppingStoreCacheModel.stripeApiVersion = null;
        }

        return shoppingStoreCacheModel;
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(39);

        sb.append("{groupId=");
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
        sb.append(", cartPageUuid=");
        sb.append(getCartPageUuid());
        sb.append(", checkoutPageUuid=");
        sb.append(getCheckoutPageUuid());
        sb.append(", onAddToCart=");
        sb.append(getOnAddToCart());
        sb.append(", currency=");
        sb.append(getCurrency());
        sb.append(", country=");
        sb.append(getCountry());
        sb.append(", userTypes=");
        sb.append(getUserTypes());
        sb.append(", integrateWithStripe=");
        sb.append(getIntegrateWithStripe());
        sb.append(", stripeTestSecretKey=");
        sb.append(getStripeTestSecretKey());
        sb.append(", stripeTestPublishableKey=");
        sb.append(getStripeTestPublishableKey());
        sb.append(", stripeTesting=");
        sb.append(getStripeTesting());
        sb.append(", stripeLiveSecretKey=");
        sb.append(getStripeLiveSecretKey());
        sb.append(", stripeLivePublishableKey=");
        sb.append(getStripeLivePublishableKey());
        sb.append(", stripeApiVersion=");
        sb.append(getStripeApiVersion());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(61);

        sb.append("<model><model-name>");
        sb.append("com.fsquare.shopping.model.ShoppingStore");
        sb.append("</model-name>");

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
            "<column><column-name>cartPageUuid</column-name><column-value><![CDATA[");
        sb.append(getCartPageUuid());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>checkoutPageUuid</column-name><column-value><![CDATA[");
        sb.append(getCheckoutPageUuid());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>onAddToCart</column-name><column-value><![CDATA[");
        sb.append(getOnAddToCart());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>currency</column-name><column-value><![CDATA[");
        sb.append(getCurrency());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>country</column-name><column-value><![CDATA[");
        sb.append(getCountry());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userTypes</column-name><column-value><![CDATA[");
        sb.append(getUserTypes());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>integrateWithStripe</column-name><column-value><![CDATA[");
        sb.append(getIntegrateWithStripe());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>stripeTestSecretKey</column-name><column-value><![CDATA[");
        sb.append(getStripeTestSecretKey());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>stripeTestPublishableKey</column-name><column-value><![CDATA[");
        sb.append(getStripeTestPublishableKey());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>stripeTesting</column-name><column-value><![CDATA[");
        sb.append(getStripeTesting());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>stripeLiveSecretKey</column-name><column-value><![CDATA[");
        sb.append(getStripeLiveSecretKey());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>stripeLivePublishableKey</column-name><column-value><![CDATA[");
        sb.append(getStripeLivePublishableKey());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>stripeApiVersion</column-name><column-value><![CDATA[");
        sb.append(getStripeApiVersion());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
