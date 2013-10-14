package net.intellizone.coupon.msg.mms.receive;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import net.intellizone.coupon.msg.mms.common.DeliveryInformation;
import net.intellizone.coupon.msg.mms.common.MessageReference;

@javax.jws.WebService(endpointInterface = "net.intellizone.coupon.msg.mms.receive.MessageNotification", targetNamespace = "http://www.chinatelecom.com.cn/wsdl/ctcc/multimedia_messaging/notification/v2_2/service", serviceName = "MessageNotificationService", portName = "MessageNotification")
public class MessageNotificationImpl {

	public void notifyMessageReception(String registrationIdentifier, MessageReference message) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	public void notifyMessageDeliveryReceipt(String correlator, DeliveryInformation deliveryStatus) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet.");
	}

}