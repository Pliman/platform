package net.intellizone.coupon.msg.sms.common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DeliveryInformation complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;DeliveryInformation&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}anyType&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;address&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}anyURI&quot;/&gt;
 *         &lt;element name=&quot;deliveryStatus&quot; type=&quot;{http://www.chinatelecom.com.cn/schema/ctcc/sms/v2_1}DeliveryStatus&quot;/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DeliveryInformation", namespace = "http://www.chinatelecom.com.cn/schema/ctcc/sms/v2_1", propOrder = {
		"address", "deliveryStatus" })
public class DeliveryInformation {

	@XmlElement(required = true)
	@XmlSchemaType(name = "anyURI")
	protected String address;
	@XmlElement(required = true)
	protected DeliveryStatus deliveryStatus;

	/**
	 * Gets the value of the address property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Sets the value of the address property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setAddress(String value) {
		this.address = value;
	}

	/**
	 * Gets the value of the deliveryStatus property.
	 * 
	 * @return possible object is {@link DeliveryStatus }
	 * 
	 */
	public DeliveryStatus getDeliveryStatus() {
		return deliveryStatus;
	}

	/**
	 * Sets the value of the deliveryStatus property.
	 * 
	 * @param value
	 *            allowed object is {@link DeliveryStatus }
	 * 
	 */
	public void setDeliveryStatus(DeliveryStatus value) {
		this.deliveryStatus = value;
	}

}
