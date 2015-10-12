package com.fsquare.messaging;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

public class AssetImageProcessorMessageListener extends BaseMessageListener{

	
	private static Log _log = LogFactoryUtil.getLog(AssetImageProcessorMessageListener.class);
	
	@Override
	protected void doReceive(Message message) throws Exception {
		// TODO Auto-generated method stub
		Object[] array = (Object[])message.getPayload();
		
	}

}
