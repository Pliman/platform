package net.intellizone.coupon.msg.sms.receive;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import net.intellizone.coupon.msg.sms.common.DeliveryInformation;
import net.intellizone.coupon.msg.sms.common.SmsMessage;

@javax.jws.WebService(endpointInterface = "net.intellizone.coupon.msg.sms.receive.SmsNotification", targetNamespace = "http://www.chinatelecom.com.cn/wsdl/ctcc/sms/notification/v2_1/service", serviceName = "SmsNotificationService", portName = "SmsNotification")
public class SmsNotificationImpl {

	public void notifySmsReception(String registrationIdentifier, SmsMessage message) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	public void notifySmsDeliveryReceipt(String correlator, DeliveryInformation deliveryStatus) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet.");
	}

}