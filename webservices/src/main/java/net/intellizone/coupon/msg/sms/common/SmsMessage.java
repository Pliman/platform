package net.intellizone.coupon.msg.sms.common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for SmsMessage complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;SmsMessage&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}anyType&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;message&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot;/&gt;
 *         &lt;element name=&quot;senderAddress&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}anyURI&quot;/&gt;
 *         &lt;element name=&quot;smsServiceActivationNumber&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}anyURI&quot;/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SmsMessage", namespace = "http://www.chinatelecom.com.cn/schema/ctcc/sms/v2_1", propOrder = {
		"message", "senderAddress", "smsServiceActivationNumber" })
public class SmsMessage {

	@XmlElement(required = true)
	protected String message;
	@XmlElement(required = true)
	@XmlSchemaType(name = "anyURI")
	protected String senderAddress;
	@XmlElement(required = true)
	@XmlSchemaType(name = "anyURI")
	protected String smsServiceActivationNumber;

	/**
	 * Gets the value of the message property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Sets the value of the message property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setMessage(String value) {
		this.message = value;
	}

	/**
	 * Gets the value of the senderAddress property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSenderAddress() {
		return senderAddress;
	}

	/**
	 * Sets the value of the senderAddress property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSenderAddress(String value) {
		this.senderAddress = value;
	}

	/**
	 * Gets the value of the smsServiceActivationNumber property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSmsServiceActivationNumber() {
		return smsServiceActivationNumber;
	}

	/**
	 * Sets the value of the smsServiceActivationNumber property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSmsServiceActivationNumber(String value) {
		this.smsServiceActivationNumber = value;
	}

}
