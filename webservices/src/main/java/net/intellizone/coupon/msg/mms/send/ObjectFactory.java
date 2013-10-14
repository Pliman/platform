package net.intellizone.coupon.msg.mms.send;

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
import net.intellizone.coupon.msg.mms.common.DeliveryInformation;
import net.intellizone.coupon.msg.mms.common.MessageReference;
import net.intellizone.coupon.msg.mms.common.MessageURI;

/**
 * This object contains factory methods for each Java content interface and Java
 * element interface generated in the net.intellizone.coupon.msg.mms.send
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

	private final static QName _RequestSOAPHeader_QNAME = new QName(
			"http://www.chinatelecom.com.cn/schema/ctcc/common/v2_1", "RequestSOAPHeader");
	private final static QName _SendMessageResponse_QNAME = new QName(
			"http://www.chinatelecom.com.cn/schema/ctcc/multimedia_messaging/send/v2_2/local", "sendMessageResponse");
	private final static QName _SendMessage_QNAME = new QName(
			"http://www.chinatelecom.com.cn/schema/ctcc/multimedia_messaging/send/v2_2/local", "sendMessage");
	private final static QName _NotifySOAPHeader_QNAME = new QName(
			"http://www.chinatelecom.com.cn/schema/ctcc/common/v2_1", "NotifySOAPHeader");
	private final static QName _GetMessageDeliveryStatus_QNAME = new QName(
			"http://www.chinatelecom.com.cn/schema/ctcc/multimedia_messaging/send/v2_2/local",
			"getMessageDeliveryStatus");
	private final static QName _ServiceException_QNAME = new QName(
			"http://www.chinatelecom.com.cn/schema/ctcc/common/v2_1", "ServiceException");
	private final static QName _GetMessageDeliveryStatusResponse_QNAME = new QName(
			"http://www.chinatelecom.com.cn/schema/ctcc/multimedia_messaging/send/v2_2/local",
			"getMessageDeliveryStatusResponse");
	private final static QName _PolicyException_QNAME = new QName(
			"http://www.chinatelecom.com.cn/schema/ctcc/common/v2_1", "PolicyException");

	/**
	 * Create a new ObjectFactory that can be used to create new instances of
	 * schema derived classes for package: net.intellizone.coupon.msg.mms.send
	 * 
	 */
	public ObjectFactory() {
	}

	/**
	 * Create an instance of {@link DeliveryInformation }
	 * 
	 */
	public DeliveryInformation createDeliveryInformation() {
		return new DeliveryInformation();
	}

	/**
	 * Create an instance of {@link SendMessage_Type }
	 * 
	 */
	public SendMessage_Type createSendMessage_Type() {
		return new SendMessage_Type();
	}

	/**
	 * Create an instance of {@link ChargingInformation }
	 * 
	 */
	public ChargingInformation createChargingInformation() {
		return new ChargingInformation();
	}

	/**
	 * Create an instance of {@link SendMessageResponse }
	 * 
	 */
	public SendMessageResponse createSendMessageResponse() {
		return new SendMessageResponse();
	}

	/**
	 * Create an instance of {@link MessageReference }
	 * 
	 */
	public MessageReference createMessageReference() {
		return new MessageReference();
	}

	/**
	 * Create an instance of {@link RequestSOAPHeader }
	 * 
	 */
	public RequestSOAPHeader createRequestSOAPHeader() {
		return new RequestSOAPHeader();
	}

	/**
	 * Create an instance of {@link NotifySOAPHeader }
	 * 
	 */
	public NotifySOAPHeader createNotifySOAPHeader() {
		return new NotifySOAPHeader();
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
	 * Create an instance of {@link GetMessageDeliveryStatus }
	 * 
	 */
	public GetMessageDeliveryStatus createGetMessageDeliveryStatus() {
		return new GetMessageDeliveryStatus();
	}

	/**
	 * Create an instance of {@link ServiceException }
	 * 
	 */
	public ServiceException createServiceException() {
		return new ServiceException();
	}

	/**
	 * Create an instance of {@link GetMessageDeliveryStatusResponse }
	 * 
	 */
	public GetMessageDeliveryStatusResponse createGetMessageDeliveryStatusResponse() {
		return new GetMessageDeliveryStatusResponse();
	}

	/**
	 * Create an instance of {@link MessageURI }
	 * 
	 */
	public MessageURI createMessageURI() {
		return new MessageURI();
	}

	/**
	 * Create an instance of {@link TimeMetric }
	 * 
	 */
	public TimeMetric createTimeMetric() {
		return new TimeMetric();
	}

	/**
	 * Create an instance of {@link PolicyException }
	 * 
	 */
	public PolicyException createPolicyException() {
		return new PolicyException();
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
	 * Create an instance of {@link JAXBElement }{@code <}{@link SendMessageResponse }{@code >}}
	 * 
	 */
	@XmlElementDecl(namespace = "http://www.chinatelecom.com.cn/schema/ctcc/multimedia_messaging/send/v2_2/local", name = "sendMessageResponse")
	public JAXBElement<SendMessageResponse> createSendMessageResponse(SendMessageResponse value) {
		return new JAXBElement<SendMessageResponse>(_SendMessageResponse_QNAME, SendMessageResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link SendMessage_Type }{@code >}}
	 * 
	 */
	@XmlElementDecl(namespace = "http://www.chinatelecom.com.cn/schema/ctcc/multimedia_messaging/send/v2_2/local", name = "sendMessage")
	public JAXBElement<SendMessage_Type> createSendMessage(SendMessage_Type value) {
		return new JAXBElement<SendMessage_Type>(_SendMessage_QNAME, SendMessage_Type.class, null, value);
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
	 * Create an instance of {@link JAXBElement }{@code <}{@link GetMessageDeliveryStatus }{@code >}}
	 * 
	 */
	@XmlElementDecl(namespace = "http://www.chinatelecom.com.cn/schema/ctcc/multimedia_messaging/send/v2_2/local", name = "getMessageDeliveryStatus")
	public JAXBElement<GetMessageDeliveryStatus> createGetMessageDeliveryStatus(GetMessageDeliveryStatus value) {
		return new JAXBElement<GetMessageDeliveryStatus>(_GetMessageDeliveryStatus_QNAME,
				GetMessageDeliveryStatus.class, null, value);
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
	 * Create an instance of {@link JAXBElement }{@code <}{@link GetMessageDeliveryStatusResponse }{@code >}}
	 * 
	 */
	@XmlElementDecl(namespace = "http://www.chinatelecom.com.cn/schema/ctcc/multimedia_messaging/send/v2_2/local", name = "getMessageDeliveryStatusResponse")
	public JAXBElement<GetMessageDeliveryStatusResponse> createGetMessageDeliveryStatusResponse(
			GetMessageDeliveryStatusResponse value) {
		return new JAXBElement<GetMessageDeliveryStatusResponse>(_GetMessageDeliveryStatusResponse_QNAME,
				GetMessageDeliveryStatusResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link PolicyException }{@code >}}
	 * 
	 */
	@XmlElementDecl(namespace = "http://www.chinatelecom.com.cn/schema/ctcc/common/v2_1", name = "PolicyException")
	public JAXBElement<PolicyException> createPolicyException(PolicyException value) {
		return new JAXBElement<PolicyException>(_PolicyException_QNAME, PolicyException.class, null, value);
	}

}
