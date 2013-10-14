package net.intellizone.coupon.msg.mms.common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for MessageReference complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;MessageReference&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}anyType&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;messageIdentifier&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;messageServiceActivationNumber&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot;/&gt;
 *         &lt;element name=&quot;senderAddress&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}anyURI&quot;/&gt;
 *         &lt;element name=&quot;subject&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;priority&quot; type=&quot;{http://www.chinatelecom.com.cn/schema/ctcc/multimedia_messaging/v2_2}MessagePriority&quot;/&gt;
 *         &lt;element name=&quot;message&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MessageReference", namespace = "http://www.chinatelecom.com.cn/schema/ctcc/multimedia_messaging/v2_2", propOrder = {
		"messageIdentifier", "messageServiceActivationNumber", "senderAddress", "subject", "priority", "message" })
public class MessageReference {

	protected String messageIdentifier;
	@XmlElement(required = true)
	protected String messageServiceActivationNumber;
	@XmlElement(required = true)
	@XmlSchemaType(name = "anyURI")
	protected String senderAddress;
	protected String subject;
	@XmlElement(required = true)
	protected MessagePriority priority;
	protected String message;

	/**
	 * Gets the value of the messageIdentifier property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getMessageIdentifier() {
		return messageIdentifier;
	}

	/**
	 * Sets the value of the messageIdentifier property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setMessageIdentifier(String value) {
		this.messageIdentifier = value;
	}

	/**
	 * Gets the value of the messageServiceActivationNumber property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getMessageServiceActivationNumber() {
		return messageServiceActivationNumber;
	}

	/**
	 * Sets the value of the messageServiceActivationNumber property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setMessageServiceActivationNumber(String value) {
		this.messageServiceActivationNumber = value;
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
	 * Gets the value of the subject property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * Sets the value of the subject property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSubject(String value) {
		this.subject = value;
	}

	/**
	 * Gets the value of the priority property.
	 * 
	 * @return possible object is {@link MessagePriority }
	 * 
	 */
	public MessagePriority getPriority() {
		return priority;
	}

	/**
	 * Sets the value of the priority property.
	 * 
	 * @param value
	 *            allowed object is {@link MessagePriority }
	 * 
	 */
	public void setPriority(MessagePriority value) {
		this.priority = value;
	}

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

}
