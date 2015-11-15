package com.fsquare.shopping.service.messaging;

import com.fsquare.shopping.service.ClpSerializer;
import com.fsquare.shopping.service.ShoppingCouponLocalServiceUtil;
import com.fsquare.shopping.service.ShoppingCouponServiceUtil;
import com.fsquare.shopping.service.ShoppingOrderItemLocalServiceUtil;
import com.fsquare.shopping.service.ShoppingOrderItemServiceUtil;
import com.fsquare.shopping.service.ShoppingOrderLocalServiceUtil;
import com.fsquare.shopping.service.ShoppingOrderServiceUtil;
import com.fsquare.shopping.service.ShoppingPaymentLocalServiceUtil;
import com.fsquare.shopping.service.ShoppingPaymentServiceUtil;
import com.fsquare.shopping.service.ShoppingShippingMethodLocalServiceUtil;
import com.fsquare.shopping.service.ShoppingShippingMethodServiceUtil;
import com.fsquare.shopping.service.ShoppingStoreLocalServiceUtil;
import com.fsquare.shopping.service.ShoppingStoreServiceUtil;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;


public class ClpMessageListener extends BaseMessageListener {
    public static String getServletContextName() {
        return ClpSerializer.getServletContextName();
    }

    @Override
    protected void doReceive(Message message) throws Exception {
        String command = message.getString("command");
        String servletContextName = message.getString("servletContextName");

        if (command.equals("undeploy") &&
                servletContextName.equals(getServletContextName())) {
            ShoppingCouponLocalServiceUtil.clearService();

            ShoppingCouponServiceUtil.clearService();
            ShoppingOrderLocalServiceUtil.clearService();

            ShoppingOrderServiceUtil.clearService();
            ShoppingOrderItemLocalServiceUtil.clearService();

            ShoppingOrderItemServiceUtil.clearService();
            ShoppingPaymentLocalServiceUtil.clearService();

            ShoppingPaymentServiceUtil.clearService();
            ShoppingShippingMethodLocalServiceUtil.clearService();

            ShoppingShippingMethodServiceUtil.clearService();
            ShoppingStoreLocalServiceUtil.clearService();

            ShoppingStoreServiceUtil.clearService();
        }
    }
}
