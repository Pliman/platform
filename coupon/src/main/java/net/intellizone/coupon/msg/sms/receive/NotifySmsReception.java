package net.intellizone.coupon.msg.sms.receive;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import net.intellizone.coupon.msg.sms.common.SmsMessage;

/**
 * <p>
 * Java class for notifySmsReception complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;notifySmsReception&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}anyType&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;registrationIdentifier&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot;/&gt;
 *         &lt;element name=&quot;message&quot; type=&quot;{http://www.chinatelecom.com.cn/schema/ctcc/sms/v2_1}SmsMessage&quot;/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "notifySmsReception", namespace = "http://www.chinatelecom.com.cn/schema/ctcc/sms/notification/v2_1/local", propOrder = {
		"registrationIdentifier", "message" })
public class NotifySmsReception {

	@XmlElement(namespace = "http://www.chinatelecom.com.cn/schema/ctcc/sms/notification/v2_1/local", required = true)
	protected String registrationIdentifier;
	@XmlElement(namespace = "http://www.chinatelecom.com.cn/schema/ctcc/sms/notification/v2_1/local", required = true)
	protected SmsMessage message;

	/**
	 * Gets the value of the registrationIdentifier property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getRegistrationIdentifier() {
		return registrationIdentifier;
	}

	/**
	 * Sets the value of the registrationIdentifier property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setRegistrationIdentifier(String value) {
		this.registrationIdentifier = value;
	}

	/**
	 * Gets the value of the message property.
	 * 
	 * @return possible object is {@link SmsMessage }
	 * 
	 */
	public SmsMessage getMessage() {
		return message;
	}

	/**
	 * Sets the value of the message property.
	 * 
	 * @param value
	 *            allowed object is {@link SmsMessage }
	 * 
	 */
	public void setMessage(SmsMessage value) {
		this.message = value;
	}

}
