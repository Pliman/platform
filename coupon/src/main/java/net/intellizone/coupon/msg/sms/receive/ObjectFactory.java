package net.intellizone.coupon.msg.sms.receive;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

import net.intellizone.coupon.msg.common.ChargingInformation;
import net.intellizone.coupon.msg.common.NotifySOAPHeader;
import net.intellizone.coupon.msg.common.PolicyException;
import net.intellizone.coupon.msg.common.RequestSOAPHeader;
import net.intellizone.coupon.msg.common.ServiceError;
import net.intellizone.coupon.msg.common.ServiceException;
import net.intellizone.coupon.msg.common.SimpleReference;
import net.intellizone.coupon.msg.common.TimeMetric;
import net.intellizone.coupon.msg.sms.common.DeliveryInformation;
import net.intellizone.coupon.msg.sms.common.SmsMessage;

/**
 * This object contains factory methods for each Java content interface and Java
 * element interface generated in the net.intellizone.coupon.msg.sms.receive
 * package.
 * <p>
 * An ObjectFactory allows you to programatically construct new instances of the
 * Java representation for XML content. The Java representation of XML content
 * can consist of schema derived interfaces and classes representing the binding
 * of schema type definitions, element declarations and model groups. Factory
 * methods for each of these are provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

	private final static QName _NotifySmsReception_QNAME = new QName(
			"http://www.chinatelecom.com.cn/schema/ctcc/sms/notification/v2_1/local", "notifySmsReception");
	private final static QName _RequestSOAPHeader_QNAME = new QName(
			"http://www.chinatelecom.com.cn/schema/ctcc/common/v2_1", "RequestSOAPHeader");
	private final static QName _NotifySOAPHeader_QNAME = new QName(
			"http://www.chinatelecom.com.cn/schema/ctcc/common/v2_1", "NotifySOAPHeader");
	private final static QName _NotifySmsDeliveryReceipt_QNAME = new QName(
			"http://www.chinatelecom.com.cn/schema/ctcc/sms/notification/v2_1/local", "notifySmsDeliveryReceipt");
	private final static QName _ServiceException_QNAME = new QName(
			"http://www.chinatelecom.com.cn/schema/ctcc/common/v2_1", "ServiceException");
	private final static QName _NotifySmsReceptionResponse_QNAME = new QName(
			"http://www.chinatelecom.com.cn/schema/ctcc/sms/notification/v2_1/local", "notifySmsReceptionResponse");
	private final static QName _PolicyException_QNAME = new QName(
			"http://www.chinatelecom.com.cn/schema/ctcc/common/v2_1", "PolicyException");
	private final static QName _NotifySmsDeliveryReceiptResponse_QNAME = new QName(
			"http://www.chinatelecom.com.cn/schema/ctcc/sms/notification/v2_1/local",
			"notifySmsDeliveryReceiptResponse");

	/**
	 * Create a new ObjectFactory that can be used to create new instances of
	 * schema derived classes for package:
	 * net.intellizone.coupon.msg.sms.receive
	 * 
	 */
	public ObjectFactory() {
	}

	/**
	 * Create an instance of {@link ServiceError }
	 * 
	 */
	public ServiceError createServiceError() {
		return new ServiceError();
	}

	/**
	 * Create an instance of {@link SimpleReference }
	 * 
	 */
	public SimpleReference createSimpleReference() {
		return new SimpleReference();
	}

	/**
	 * Create an instance of {@link TimeMetric }
	 * 
	 */
	public TimeMetric createTimeMetric() {
		return new TimeMetric();
	}

	/**
	 * Create an instance of {@link NotifySmsReceptionResponse }
	 * 
	 */
	public NotifySmsReceptionResponse createNotifySmsReceptionResponse() {
		return new NotifySmsReceptionResponse();
	}

	/**
	 * Create an instance of {@link NotifySmsDeliveryReceiptResponse }
	 * 
	 */
	public NotifySmsDeliveryReceiptResponse createNotifySmsDeliveryReceiptResponse() {
		return new NotifySmsDeliveryReceiptResponse();
	}

	/**
	 * Create an instance of {@link SmsMessage }
	 * 
	 */
	public SmsMessage createSmsMessage() {
		return new SmsMessage();
	}

	/**
	 * Create an instance of {@link ChargingInformation }
	 * 
	 */
	public ChargingInformation createChargingInformation() {
		return new ChargingInformation();
	}

	/**
	 * Create an instance of {@link NotifySmsDeliveryReceipt }
	 * 
	 */
	public NotifySmsDeliveryReceipt createNotifySmsDeliveryReceipt() {
		return new NotifySmsDeliveryReceipt();
	}

	/**
	 * Create an instance of {@link PolicyException }
	 * 
	 */
	public PolicyException createPolicyException() {
		return new PolicyException();
	}

	/**
	 * Create an instance of {@link RequestSOAPHeader }
	 * 
	 */
	public RequestSOAPHeader createRequestSOAPHeader() {
		return new RequestSOAPHeader();
	}

	/**
	 * Create an instance of {@link NotifySmsReception }
	 * 
	 */
	public NotifySmsReception createNotifySmsReception() {
		return new NotifySmsReception();
	}

	/**
	 * Create an instance of {@link ServiceException }
	 * 
	 */
	public ServiceException createServiceException() {
		return new ServiceException();
	}

	/**
	 * Create an instance of {@link NotifySOAPHeader }
	 * 
	 */
	public NotifySOAPHeader createNotifySOAPHeader() {
		return new NotifySOAPHeader();
	}

	/**
	 * Create an instance of {@link DeliveryInformation }
	 * 
	 */
	public DeliveryInformation createDeliveryInformation() {
		return new DeliveryInformation();
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link NotifySmsReception }{@code >}}
	 * 
	 */
	@XmlElementDecl(namespace = "http://www.chinatelecom.com.cn/schema/ctcc/sms/notification/v2_1/local", name = "notifySmsReception")
	public JAXBElement<NotifySmsReception> createNotifySmsReception(NotifySmsReception value) {
		return new JAXBElement<NotifySmsReception>(_NotifySmsReception_QNAME, NotifySmsReception.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link RequestSOAPHeader }{@code >}}
	 * 
	 */
	@XmlElementDecl(namespace = "http://www.chinatelecom.com.cn/schema/ctcc/common/v2_1", name = "RequestSOAPHeader")
	public JAXBElement<RequestSOAPHeader> createRequestSOAPHeader(RequestSOAPHeader value) {
		return new JAXBElement<RequestSOAPHeader>(_RequestSOAPHeader_QNAME, RequestSOAPHeader.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link NotifySOAPHeader }{@code >}}
	 * 
	 */
	@XmlElementDecl(namespace = "http://www.chinatelecom.com.cn/schema/ctcc/common/v2_1", name = "NotifySOAPHeader")
	public JAXBElement<NotifySOAPHeader> createNotifySOAPHeader(NotifySOAPHeader value) {
		return new JAXBElement<NotifySOAPHeader>(_NotifySOAPHeader_QNAME, NotifySOAPHeader.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link NotifySmsDeliveryReceipt }{@code >}}
	 * 
	 */
	@XmlElementDecl(namespace = "http://www.chinatelecom.com.cn/schema/ctcc/sms/notification/v2_1/local", name = "notifySmsDeliveryReceipt")
	public JAXBElement<NotifySmsDeliveryReceipt> createNotifySmsDeliveryReceipt(NotifySmsDeliveryReceipt value) {
		return new JAXBElement<NotifySmsDeliveryReceipt>(_NotifySmsDeliveryReceipt_QNAME,
				NotifySmsDeliveryReceipt.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link ServiceException }{@code >}}
	 * 
	 */
	@XmlElementDecl(namespace = "http://www.chinatelecom.com.cn/schema/ctcc/common/v2_1", name = "ServiceException")
	public JAXBElement<ServiceException> createServiceException(ServiceException value) {
		return new JAXBElement<ServiceException>(_ServiceException_QNAME, ServiceException.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link NotifySmsReceptionResponse }{@code >}}
	 * 
	 */
	@XmlElementDecl(namespace = "http://www.chinatelecom.com.cn/schema/ctcc/sms/notification/v2_1/local", name = "notifySmsReceptionResponse")
	public JAXBElement<NotifySmsReceptionResponse> createNotifySmsReceptionResponse(NotifySmsReceptionResponse value) {
		return new JAXBElement<NotifySmsReceptionResponse>(_NotifySmsReceptionResponse_QNAME,
				NotifySmsReceptionResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link PolicyException }{@code >}}
	 * 
	 */
	@XmlElementDecl(namespace = "http://www.chinatelecom.com.cn/schema/ctcc/common/v2_1", name = "PolicyException")
	public JAXBElement<PolicyException> createPolicyException(PolicyException value) {
		return new JAXBElement<PolicyException>(_PolicyException_QNAME, PolicyException.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link NotifySmsDeliveryReceiptResponse }{@code >}}
	 * 
	 */
	@XmlElementDecl(namespace = "http://www.chinatelecom.com.cn/schema/ctcc/sms/notification/v2_1/local", name = "notifySmsDeliveryReceiptResponse")
	public JAXBElement<NotifySmsDeliveryReceiptResponse> createNotifySmsDeliveryReceiptResponse(
			NotifySmsDeliveryReceiptResponse value) {
		return new JAXBElement<NotifySmsDeliveryReceiptResponse>(_NotifySmsDeliveryReceiptResponse_QNAME,
				NotifySmsDeliveryReceiptResponse.class, null, value);
	}

}
