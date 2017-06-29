package com.fsquare.shopping.model.impl;

import com.fsquare.shopping.model.ShoppingShippingMethod;
import com.fsquare.shopping.model.ShoppingShippingMethodModel;
import com.fsquare.shopping.model.ShoppingShippingMethodSoap;

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
 * The base model implementation for the ShoppingShippingMethod service. Represents a row in the &quot;FsquareShopping_ShoppingShippingMethod&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.fsquare.shopping.model.ShoppingShippingMethodModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ShoppingShippingMethodImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingShippingMethodImpl
 * @see com.fsquare.shopping.model.ShoppingShippingMethod
 * @see com.fsquare.shopping.model.ShoppingShippingMethodModel
 * @generated
 */
@JSON(strict = true)
public class ShoppingShippingMethodModelImpl extends BaseModelImpl<ShoppingShippingMethod>
    implements ShoppingShippingMethodModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a shopping shipping method model instance should use the {@link com.fsquare.shopping.model.ShoppingShippingMethod} interface instead.
     */
    public static final String TABLE_NAME = "FsquareShopping_ShoppingShippingMethod";
    public static final Object[][] TABLE_COLUMNS = {
            { "shippingMethodId", Types.BIGINT },
            { "companyId", Types.BIGINT },
            { "userId", Types.BIGINT },
            { "userName", Types.VARCHAR },
            { "createDate", Types.TIMESTAMP },
            { "modifiedDate", Types.TIMESTAMP },
            { "price", Types.DOUBLE },
            { "name", Types.VARCHAR },
            { "description", Types.VARCHAR },
            { "freeQuantity", Types.BIGINT },
            { "freeTotal", Types.DOUBLE },
            { "weight", Types.DOUBLE },
            { "defaultShipping", Types.BOOLEAN },
            { "international", Types.BOOLEAN },
            { "disabled", Types.BOOLEAN },
            { "shippingType", Types.VARCHAR }
        };
    public static final String TABLE_SQL_CREATE = "create table FsquareShopping_ShoppingShippingMethod (shippingMethodId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,price DOUBLE,name VARCHAR(75) null,description VARCHAR(2000) null,freeQuantity LONG,freeTotal DOUBLE,weight DOUBLE,defaultShipping BOOLEAN,international BOOLEAN,disabled BOOLEAN,shippingType VARCHAR(75) null)";
    public static final String TABLE_SQL_DROP = "drop table FsquareShopping_ShoppingShippingMethod";
    public static final String ORDER_BY_JPQL = " ORDER BY shoppingShippingMethod.shippingMethodId ASC";
    public static final String ORDER_BY_SQL = " ORDER BY FsquareShopping_ShoppingShippingMethod.shippingMethodId ASC";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.com.fsquare.shopping.model.ShoppingShippingMethod"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.com.fsquare.shopping.model.ShoppingShippingMethod"),
            true);
    public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.column.bitmask.enabled.com.fsquare.shopping.model.ShoppingShippingMethod"),
            true);
    public static long COMPANYID_COLUMN_BITMASK = 1L;
    public static long DEFAULTSHIPPING_COLUMN_BITMASK = 2L;
    public static long DISABLED_COLUMN_BITMASK = 4L;
    public static long SHIPPINGMETHODID_COLUMN_BITMASK = 8L;
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.com.fsquare.shopping.model.ShoppingShippingMethod"));
    private static ClassLoader _classLoader = ShoppingShippingMethod.class.getClassLoader();
    private static Class<?>[] _escapedModelInterfaces = new Class[] {
            ShoppingShippingMethod.class
        };
    private long _shippingMethodId;
    private long _companyId;
    private long _originalCompanyId;
    private boolean _setOriginalCompanyId;
    private long _userId;
    private String _userUuid;
    private String _userName;
    private Date _createDate;
    private Date _modifiedDate;
    private double _price;
    private String _name;
    private String _description;
    private long _freeQuantity;
    private double _freeTotal;
    private double _weight;
    private boolean _defaultShipping;
    private boolean _originalDefaultShipping;
    private boolean _setOriginalDefaultShipping;
    private boolean _international;
    private boolean _disabled;
    private boolean _originalDisabled;
    private boolean _setOriginalDisabled;
    private String _shippingType;
    private long _columnBitmask;
    private ShoppingShippingMethod _escapedModel;

    public ShoppingShippingMethodModelImpl() {
    }

    /**
     * Converts the soap model instance into a normal model instance.
     *
     * @param soapModel the soap model instance to convert
     * @return the normal model instance
     */
    public static ShoppingShippingMethod toModel(
        ShoppingShippingMethodSoap soapModel) {
        if (soapModel == null) {
            return null;
        }

        ShoppingShippingMethod model = new ShoppingShippingMethodImpl();

        model.setShippingMethodId(soapModel.getShippingMethodId());
        model.setCompanyId(soapModel.getCompanyId());
        model.setUserId(soapModel.getUserId());
        model.setUserName(soapModel.getUserName());
        model.setCreateDate(soapModel.getCreateDate());
        model.setModifiedDate(soapModel.getModifiedDate());
        model.setPrice(soapModel.getPrice());
        model.setName(soapModel.getName());
        model.setDescription(soapModel.getDescription());
        model.setFreeQuantity(soapModel.getFreeQuantity());
        model.setFreeTotal(soapModel.getFreeTotal());
        model.setWeight(soapModel.getWeight());
        model.setDefaultShipping(soapModel.getDefaultShipping());
        model.setInternational(soapModel.getInternational());
        model.setDisabled(soapModel.getDisabled());
        model.setShippingType(soapModel.getShippingType());

        return model;
    }

    /**
     * Converts the soap model instances into normal model instances.
     *
     * @param soapModels the soap model instances to convert
     * @return the normal model instances
     */
    public static List<ShoppingShippingMethod> toModels(
        ShoppingShippingMethodSoap[] soapModels) {
        if (soapModels == null) {
            return null;
        }

        List<ShoppingShippingMethod> models = new ArrayList<ShoppingShippingMethod>(soapModels.length);

        for (ShoppingShippingMethodSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    @Override
    public long getPrimaryKey() {
        return _shippingMethodId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setShippingMethodId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _shippingMethodId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Class<?> getModelClass() {
        return ShoppingShippingMethod.class;
    }

    @Override
    public String getModelClassName() {
        return ShoppingShippingMethod.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("shippingMethodId", getShippingMethodId());
        attributes.put("companyId", getCompanyId());
        attributes.put("userId", getUserId());
        attributes.put("userName", getUserName());
        attributes.put("createDate", getCreateDate());
        attributes.put("modifiedDate", getModifiedDate());
        attributes.put("price", getPrice());
        attributes.put("name", getName());
        attributes.put("description", getDescription());
        attributes.put("freeQuantity", getFreeQuantity());
        attributes.put("freeTotal", getFreeTotal());
        attributes.put("weight", getWeight());
        attributes.put("defaultShipping", getDefaultShipping());
        attributes.put("international", getInternational());
        attributes.put("disabled", getDisabled());
        attributes.put("shippingType", getShippingType());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long shippingMethodId = (Long) attributes.get("shippingMethodId");

        if (shippingMethodId != null) {
            setShippingMethodId(shippingMethodId);
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

        Double price = (Double) attributes.get("price");

        if (price != null) {
            setPrice(price);
        }

        String name = (String) attributes.get("name");

        if (name != null) {
            setName(name);
        }

        String description = (String) attributes.get("description");

        if (description != null) {
            setDescription(description);
        }

        Long freeQuantity = (Long) attributes.get("freeQuantity");

        if (freeQuantity != null) {
            setFreeQuantity(freeQuantity);
        }

        Double freeTotal = (Double) attributes.get("freeTotal");

        if (freeTotal != null) {
            setFreeTotal(freeTotal);
        }

        Double weight = (Double) attributes.get("weight");

        if (weight != null) {
            setWeight(weight);
        }

        Boolean defaultShipping = (Boolean) attributes.get("defaultShipping");

        if (defaultShipping != null) {
            setDefaultShipping(defaultShipping);
        }

        Boolean international = (Boolean) attributes.get("international");

        if (international != null) {
            setInternational(international);
        }

        Boolean disabled = (Boolean) attributes.get("disabled");

        if (disabled != null) {
            setDisabled(disabled);
        }

        String shippingType = (String) attributes.get("shippingType");

        if (shippingType != null) {
            setShippingType(shippingType);
        }
    }

    @JSON
    @Override
    public long getShippingMethodId() {
        return _shippingMethodId;
    }

    @Override
    public void setShippingMethodId(long shippingMethodId) {
        _shippingMethodId = shippingMethodId;
    }

    @JSON
    @Override
    public long getCompanyId() {
        return _companyId;
    }

    @Override
    public void setCompanyId(long companyId) {
        _columnBitmask |= COMPANYID_COLUMN_BITMASK;

        if (!_setOriginalCompanyId) {
            _setOriginalCompanyId = true;

            _originalCompanyId = _companyId;
        }

        _companyId = companyId;
    }

    public long getOriginalCompanyId() {
        return _originalCompanyId;
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
    public double getPrice() {
        return _price;
    }

    @Override
    public void setPrice(double price) {
        _price = price;
    }

    @JSON
    @Override
    public String getName() {
        if (_name == null) {
            return StringPool.BLANK;
        } else {
            return _name;
        }
    }

    @Override
    public void setName(String name) {
        _name = name;
    }

    @JSON
    @Override
    public String getDescription() {
        if (_description == null) {
            return StringPool.BLANK;
        } else {
            return _description;
        }
    }

    @Override
    public void setDescription(String description) {
        _description = description;
    }

    @JSON
    @Override
    public long getFreeQuantity() {
        return _freeQuantity;
    }

    @Override
    public void setFreeQuantity(long freeQuantity) {
        _freeQuantity = freeQuantity;
    }

    @JSON
    @Override
    public double getFreeTotal() {
        return _freeTotal;
    }

    @Override
    public void setFreeTotal(double freeTotal) {
        _freeTotal = freeTotal;
    }

    @JSON
    @Override
    public double getWeight() {
        return _weight;
    }

    @Override
    public void setWeight(double weight) {
        _weight = weight;
    }

    @JSON
    @Override
    public boolean getDefaultShipping() {
        return _defaultShipping;
    }

    @Override
    public boolean isDefaultShipping() {
        return _defaultShipping;
    }

    @Override
    public void setDefaultShipping(boolean defaultShipping) {
        _columnBitmask |= DEFAULTSHIPPING_COLUMN_BITMASK;

        if (!_setOriginalDefaultShipping) {
            _setOriginalDefaultShipping = true;

            _originalDefaultShipping = _defaultShipping;
        }

        _defaultShipping = defaultShipping;
    }

    public boolean getOriginalDefaultShipping() {
        return _originalDefaultShipping;
    }

    @JSON
    @Override
    public boolean getInternational() {
        return _international;
    }

    @Override
    public boolean isInternational() {
        return _international;
    }

    @Override
    public void setInternational(boolean international) {
        _international = international;
    }

    @JSON
    @Override
    public boolean getDisabled() {
        return _disabled;
    }

    @Override
    public boolean isDisabled() {
        return _disabled;
    }

    @Override
    public void setDisabled(boolean disabled) {
        _columnBitmask |= DISABLED_COLUMN_BITMASK;

        if (!_setOriginalDisabled) {
            _setOriginalDisabled = true;

            _originalDisabled = _disabled;
        }

        _disabled = disabled;
    }

    public boolean getOriginalDisabled() {
        return _originalDisabled;
    }

    @JSON
    @Override
    public String getShippingType() {
        if (_shippingType == null) {
            return StringPool.BLANK;
        } else {
            return _shippingType;
        }
    }

    @Override
    public void setShippingType(String shippingType) {
        _shippingType = shippingType;
    }

    public long getColumnBitmask() {
        return _columnBitmask;
    }

    @Override
    public ExpandoBridge getExpandoBridge() {
        return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
            ShoppingShippingMethod.class.getName(), getPrimaryKey());
    }

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
        ExpandoBridge expandoBridge = getExpandoBridge();

        expandoBridge.setAttributes(serviceContext);
    }

    @Override
    public ShoppingShippingMethod toEscapedModel() {
        if (_escapedModel == null) {
            _escapedModel = (ShoppingShippingMethod) ProxyUtil.newProxyInstance(_classLoader,
                    _escapedModelInterfaces, new AutoEscapeBeanHandler(this));
        }

        return _escapedModel;
    }

    @Override
    public Object clone() {
        ShoppingShippingMethodImpl shoppingShippingMethodImpl = new ShoppingShippingMethodImpl();

        shoppingShippingMethodImpl.setShippingMethodId(getShippingMethodId());
        shoppingShippingMethodImpl.setCompanyId(getCompanyId());
        shoppingShippingMethodImpl.setUserId(getUserId());
        shoppingShippingMethodImpl.setUserName(getUserName());
        shoppingShippingMethodImpl.setCreateDate(getCreateDate());
        shoppingShippingMethodImpl.setModifiedDate(getModifiedDate());
        shoppingShippingMethodImpl.setPrice(getPrice());
        shoppingShippingMethodImpl.setName(getName());
        shoppingShippingMethodImpl.setDescription(getDescription());
        shoppingShippingMethodImpl.setFreeQuantity(getFreeQuantity());
        shoppingShippingMethodImpl.setFreeTotal(getFreeTotal());
        shoppingShippingMethodImpl.setWeight(getWeight());
        shoppingShippingMethodImpl.setDefaultShipping(getDefaultShipping());
        shoppingShippingMethodImpl.setInternational(getInternational());
        shoppingShippingMethodImpl.setDisabled(getDisabled());
        shoppingShippingMethodImpl.setShippingType(getShippingType());

        shoppingShippingMethodImpl.resetOriginalValues();

        return shoppingShippingMethodImpl;
    }

    @Override
    public int compareTo(ShoppingShippingMethod shoppingShippingMethod) {
        long primaryKey = shoppingShippingMethod.getPrimaryKey();

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

        if (!(obj instanceof ShoppingShippingMethod)) {
            return false;
        }

        ShoppingShippingMethod shoppingShippingMethod = (ShoppingShippingMethod) obj;

        long primaryKey = shoppingShippingMethod.getPrimaryKey();

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
        ShoppingShippingMethodModelImpl shoppingShippingMethodModelImpl = this;

        shoppingShippingMethodModelImpl._originalCompanyId = shoppingShippingMethodModelImpl._companyId;

        shoppingShippingMethodModelImpl._setOriginalCompanyId = false;

        shoppingShippingMethodModelImpl._originalDefaultShipping = shoppingShippingMethodModelImpl._defaultShipping;

        shoppingShippingMethodModelImpl._setOriginalDefaultShipping = false;

        shoppingShippingMethodModelImpl._originalDisabled = shoppingShippingMethodModelImpl._disabled;

        shoppingShippingMethodModelImpl._setOriginalDisabled = false;

        shoppingShippingMethodModelImpl._columnBitmask = 0;
    }

    @Override
    public CacheModel<ShoppingShippingMethod> toCacheModel() {
        ShoppingShippingMethodCacheModel shoppingShippingMethodCacheModel = new ShoppingShippingMethodCacheModel();

        shoppingShippingMethodCacheModel.shippingMethodId = getShippingMethodId();

        shoppingShippingMethodCacheModel.companyId = getCompanyId();

        shoppingShippingMethodCacheModel.userId = getUserId();

        shoppingShippingMethodCacheModel.userName = getUserName();

        String userName = shoppingShippingMethodCacheModel.userName;

        if ((userName != null) && (userName.length() == 0)) {
            shoppingShippingMethodCacheModel.userName = null;
        }

        Date createDate = getCreateDate();

        if (createDate != null) {
            shoppingShippingMethodCacheModel.createDate = createDate.getTime();
        } else {
            shoppingShippingMethodCacheModel.createDate = Long.MIN_VALUE;
        }

        Date modifiedDate = getModifiedDate();

        if (modifiedDate != null) {
            shoppingShippingMethodCacheModel.modifiedDate = modifiedDate.getTime();
        } else {
            shoppingShippingMethodCacheModel.modifiedDate = Long.MIN_VALUE;
        }

        shoppingShippingMethodCacheModel.price = getPrice();

        shoppingShippingMethodCacheModel.name = getName();

        String name = shoppingShippingMethodCacheModel.name;

        if ((name != null) && (name.length() == 0)) {
            shoppingShippingMethodCacheModel.name = null;
        }

        shoppingShippingMethodCacheModel.description = getDescription();

        String description = shoppingShippingMethodCacheModel.description;

        if ((description != null) && (description.length() == 0)) {
            shoppingShippingMethodCacheModel.description = null;
        }

        shoppingShippingMethodCacheModel.freeQuantity = getFreeQuantity();

        shoppingShippingMethodCacheModel.freeTotal = getFreeTotal();

        shoppingShippingMethodCacheModel.weight = getWeight();

        shoppingShippingMethodCacheModel.defaultShipping = getDefaultShipping();

        shoppingShippingMethodCacheModel.international = getInternational();

        shoppingShippingMethodCacheModel.disabled = getDisabled();

        shoppingShippingMethodCacheModel.shippingType = getShippingType();

        String shippingType = shoppingShippingMethodCacheModel.shippingType;

        if ((shippingType != null) && (shippingType.length() == 0)) {
            shoppingShippingMethodCacheModel.shippingType = null;
        }

        return shoppingShippingMethodCacheModel;
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(33);

        sb.append("{shippingMethodId=");
        sb.append(getShippingMethodId());
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
        sb.append(", price=");
        sb.append(getPrice());
        sb.append(", name=");
        sb.append(getName());
        sb.append(", description=");
        sb.append(getDescription());
        sb.append(", freeQuantity=");
        sb.append(getFreeQuantity());
        sb.append(", freeTotal=");
        sb.append(getFreeTotal());
        sb.append(", weight=");
        sb.append(getWeight());
        sb.append(", defaultShipping=");
        sb.append(getDefaultShipping());
        sb.append(", international=");
        sb.append(getInternational());
        sb.append(", disabled=");
        sb.append(getDisabled());
        sb.append(", shippingType=");
        sb.append(getShippingType());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(52);

        sb.append("<model><model-name>");
        sb.append("com.fsquare.shopping.model.ShoppingShippingMethod");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>shippingMethodId</column-name><column-value><![CDATA[");
        sb.append(getShippingMethodId());
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
            "<column><column-name>price</column-name><column-value><![CDATA[");
        sb.append(getPrice());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>name</column-name><column-value><![CDATA[");
        sb.append(getName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>description</column-name><column-value><![CDATA[");
        sb.append(getDescription());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>freeQuantity</column-name><column-value><![CDATA[");
        sb.append(getFreeQuantity());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>freeTotal</column-name><column-value><![CDATA[");
        sb.append(getFreeTotal());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>weight</column-name><column-value><![CDATA[");
        sb.append(getWeight());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>defaultShipping</column-name><column-value><![CDATA[");
        sb.append(getDefaultShipping());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>international</column-name><column-value><![CDATA[");
        sb.append(getInternational());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>disabled</column-name><column-value><![CDATA[");
        sb.append(getDisabled());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>shippingType</column-name><column-value><![CDATA[");
        sb.append(getShippingType());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
