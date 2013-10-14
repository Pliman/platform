package net.intellizone.coupon.msg.mms.receive;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import net.intellizone.coupon.msg.mms.common.MessageReference;

/**
 * <p>
 * Java class for notifyMessageReception complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;notifyMessageReception&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}anyType&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;registrationIdentifier&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot;/&gt;
 *         &lt;element name=&quot;message&quot; type=&quot;{http://www.chinatelecom.com.cn/schema/ctcc/multimedia_messaging/v2_2}MessageReference&quot;/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "notifyMessageReception", namespace = "http://www.chinatelecom.com.cn/schema/ctcc/multimedia_messaging/notification/v2_2/local", propOrder = {
		"registrationIdentifier", "message" })
public class NotifyMessageReception {

	@XmlElement(namespace = "http://www.chinatelecom.com.cn/schema/ctcc/multimedia_messaging/notification/v2_2/local", required = true)
	protected String registrationIdentifier;
	@XmlElement(namespace = "http://www.chinatelecom.com.cn/schema/ctcc/multimedia_messaging/notification/v2_2/local", required = true)
	protected MessageReference message;

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
	 * @return possible object is {@link MessageReference }
	 * 
	 */
	public MessageReference getMessage() {
		return message;
	}

	/**
	 * Sets the value of the message property.
	 * 
	 * @param value
	 *            allowed object is {@link MessageReference }
	 * 
	 */
	public void setMessage(MessageReference value) {
		this.message = value;
	}

}
