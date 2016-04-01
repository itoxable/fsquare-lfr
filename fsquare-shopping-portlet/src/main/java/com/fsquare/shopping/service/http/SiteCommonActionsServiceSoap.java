package com.fsquare.shopping.service.http;

import com.fsquare.shopping.service.SiteCommonActionsServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;

import java.rmi.RemoteException;

import java.util.Locale;
import java.util.Map;

/**
 * Provides the SOAP utility for the
 * {@link com.fsquare.shopping.service.SiteCommonActionsServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SiteCommonActionsServiceHttp
 * @see com.fsquare.shopping.service.SiteCommonActionsServiceUtil
 * @generated
 */
public class SiteCommonActionsServiceSoap {
    private static Log _log = LogFactoryUtil.getLog(SiteCommonActionsServiceSoap.class);

    public static com.liferay.portal.model.Layout updateLayout(long groupId,
        boolean privateLayout, long layoutId, long parentLayoutId,
        java.lang.String[] localeNamesMapLanguageIds,
        java.lang.String[] localeNamesMapValues,
        java.lang.String[] localeTitlesMapLanguageIds,
        java.lang.String[] localeTitlesMapValues,
        java.lang.String[] descriptionMapLanguageIds,
        java.lang.String[] descriptionMapValues,
        java.lang.String[] keywordsMapLanguageIds,
        java.lang.String[] keywordsMapValues,
        java.lang.String[] robotsMapLanguageIds,
        java.lang.String[] robotsMapValues, java.lang.String type,
        boolean hidden, java.lang.String[] friendlyURLMapLanguageIds,
        java.lang.String[] friendlyURLMapValues, java.lang.Boolean iconImage,
        byte[] iconBytes,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws RemoteException {
        try {
            Map<Locale, String> localeNamesMap = LocalizationUtil.getLocalizationMap(localeNamesMapLanguageIds,
                    localeNamesMapValues);
            Map<Locale, String> localeTitlesMap = LocalizationUtil.getLocalizationMap(localeTitlesMapLanguageIds,
                    localeTitlesMapValues);
            Map<Locale, String> descriptionMap = LocalizationUtil.getLocalizationMap(descriptionMapLanguageIds,
                    descriptionMapValues);
            Map<Locale, String> keywordsMap = LocalizationUtil.getLocalizationMap(keywordsMapLanguageIds,
                    keywordsMapValues);
            Map<Locale, String> robotsMap = LocalizationUtil.getLocalizationMap(robotsMapLanguageIds,
                    robotsMapValues);
            Map<Locale, String> friendlyURLMap = LocalizationUtil.getLocalizationMap(friendlyURLMapLanguageIds,
                    friendlyURLMapValues);

            com.liferay.portal.model.Layout returnValue = SiteCommonActionsServiceUtil.updateLayout(groupId,
                    privateLayout, layoutId, parentLayoutId, localeNamesMap,
                    localeTitlesMap, descriptionMap, keywordsMap, robotsMap,
                    type, hidden, friendlyURLMap, iconImage, iconBytes,
                    serviceContext);

            return returnValue;
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.liferay.portal.model.Group updateGroup(long groupId,
        long parentGroupId, java.lang.String name,
        java.lang.String description, int type, boolean manualMembership,
        int membershipRestriction, java.lang.String friendlyURL,
        boolean active, com.liferay.portal.service.ServiceContext serviceContext)
        throws RemoteException {
        try {
            com.liferay.portal.model.Group returnValue = SiteCommonActionsServiceUtil.updateGroup(groupId,
                    parentGroupId, name, description, type, manualMembership,
                    membershipRestriction, friendlyURL, active, serviceContext);

            return returnValue;
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.liferay.portal.model.User updatePassword(long userId,
        java.lang.String oldPassword, java.lang.String password1,
        java.lang.String password2) throws RemoteException {
        try {
            com.liferay.portal.model.User returnValue = SiteCommonActionsServiceUtil.updatePassword(userId,
                    oldPassword, password1, password2);

            return returnValue;
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static java.lang.String getUserPortraitUrl(boolean male,
        long portraitId) throws RemoteException {
        try {
            java.lang.String returnValue = SiteCommonActionsServiceUtil.getUserPortraitUrl(male,
                    portraitId);

            return returnValue;
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static java.util.Map[] getAccountsPaged(int start, int end)
        throws RemoteException {
        try {
            java.util.List<java.util.Map> returnValue = SiteCommonActionsServiceUtil.getAccountsPaged(start,
                    end);

            return returnValue.toArray(new java.util.Map[returnValue.size()]);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static java.util.Map[] getAccounts() throws RemoteException {
        try {
            java.util.List<java.util.Map> returnValue = SiteCommonActionsServiceUtil.getAccounts();

            return returnValue.toArray(new java.util.Map[returnValue.size()]);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.liferay.portal.model.Company[] getCompanies()
        throws RemoteException {
        try {
            java.util.List<com.liferay.portal.model.Company> returnValue = SiteCommonActionsServiceUtil.getCompanies();

            return returnValue.toArray(new com.liferay.portal.model.Company[returnValue.size()]);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static void testFilesUpload(java.util.List<java.io.File> files)
        throws RemoteException {
        try {
            SiteCommonActionsServiceUtil.testFilesUpload(files);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }
}
