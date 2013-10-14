package net.intellizone.coupon.msg.sms.receive;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import net.intellizone.coupon.msg.sms.common.DeliveryInformation;

/**
 * <p>
 * Java class for notifySmsDeliveryReceipt complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;notifySmsDeliveryReceipt&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}anyType&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;correlator&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot;/&gt;
 *         &lt;element name=&quot;deliveryStatus&quot; type=&quot;{http://www.chinatelecom.com.cn/schema/ctcc/sms/v2_1}DeliveryInformation&quot;/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "notifySmsDeliveryReceipt", namespace = "http://www.chinatelecom.com.cn/schema/ctcc/sms/notification/v2_1/local", propOrder = {
		"correlator", "deliveryStatus" })
public class NotifySmsDeliveryReceipt {

	@XmlElement(namespace = "http://www.chinatelecom.com.cn/schema/ctcc/sms/notification/v2_1/local", required = true)
	protected String correlator;
	@XmlElement(namespace = "http://www.chinatelecom.com.cn/schema/ctcc/sms/notification/v2_1/local", required = true)
	protected DeliveryInformation deliveryStatus;

	/**
	 * Gets the value of the correlator property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCorrelator() {
		return correlator;
	}

	/**
	 * Sets the value of the correlator property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCorrelator(String value) {
		this.correlator = value;
	}

	/**
	 * Gets the value of the deliveryStatus property.
	 * 
	 * @return possible object is {@link DeliveryInformation }
	 * 
	 */
	public DeliveryInformation getDeliveryStatus() {
		return deliveryStatus;
	}

	/**
	 * Sets the value of the deliveryStatus property.
	 * 
	 * @param value
	 *            allowed object is {@link DeliveryInformation }
	 * 
	 */
	public void setDeliveryStatus(DeliveryInformation value) {
		this.deliveryStatus = value;
	}

}
