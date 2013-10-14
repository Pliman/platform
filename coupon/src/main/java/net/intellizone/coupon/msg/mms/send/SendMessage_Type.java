package net.intellizone.coupon.msg.mms.send;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

import net.intellizone.coupon.msg.common.ChargingInformation;
import net.intellizone.coupon.msg.common.SimpleReference;
import net.intellizone.coupon.msg.mms.common.MessagePriority;

/**
 * <p>
 * Java class for sendMessage complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;sendMessage&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}anyType&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;addresses&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}anyURI&quot; maxOccurs=&quot;unbounded&quot;/&gt;
 *         &lt;element name=&quot;senderAddress&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;subject&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;priority&quot; type=&quot;{http://www.chinatelecom.com.cn/schema/ctcc/multimedia_messaging/v2_2}MessagePriority&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;charging&quot; type=&quot;{http://www.chinatelecom.com.cn/schema/ctcc/common/v2_1}ChargingInformation&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;receiptRequest&quot; type=&quot;{http://www.chinatelecom.com.cn/schema/ctcc/common/v2_1}SimpleReference&quot; minOccurs=&quot;0&quot;/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sendMessage", namespace = "http://www.chinatelecom.com.cn/schema/ctcc/multimedia_messaging/send/v2_2/local", propOrder = {
		"addresses", "senderAddress", "subject", "priority", "charging", "receiptRequest" })
public class SendMessage_Type {

	@XmlElement(namespace = "http://www.chinatelecom.com.cn/schema/ctcc/multimedia_messaging/send/v2_2/local", required = true)
	@XmlSchemaType(name = "anyURI")
	protected List<String> addresses;
	@XmlElement(namespace = "http://www.chinatelecom.com.cn/schema/ctcc/multimedia_messaging/send/v2_2/local")
	protected String senderAddress;
	@XmlElement(namespace = "http://www.chinatelecom.com.cn/schema/ctcc/multimedia_messaging/send/v2_2/local")
	protected String subject;
	@XmlElement(namespace = "http://www.chinatelecom.com.cn/schema/ctcc/multimedia_messaging/send/v2_2/local")
	protected MessagePriority priority;
	@XmlElement(namespace = "http://www.chinatelecom.com.cn/schema/ctcc/multimedia_messaging/send/v2_2/local")
	protected ChargingInformation charging;
	@XmlElement(namespace = "http://www.chinatelecom.com.cn/schema/ctcc/multimedia_messaging/send/v2_2/local")
	protected SimpleReference receiptRequest;

	/**
	 * Gets the value of the addresses property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the addresses property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getAddresses().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link String }
	 * 
	 * 
	 */
	public List<String> getAddresses() {
		if (addresses == null) {
			addresses = new ArrayList<String>();
		}
		return this.addresses;
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
	 * Gets the value of the charging property.
	 * 
	 * @return possible object is {@link ChargingInformation }
	 * 
	 */
	public ChargingInformation getCharging() {
		return charging;
	}

	/**
	 * Sets the value of the charging property.
	 * 
	 * @param value
	 *            allowed object is {@link ChargingInformation }
	 * 
	 */
	public void setCharging(ChargingInformation value) {
		this.charging = value;
	}

	/**
	 * Gets the value of the receiptRequest property.
	 * 
	 * @return possible object is {@link SimpleReference }
	 * 
	 */
	public SimpleReference getReceiptRequest() {
		return receiptRequest;
	}

	/**
	 * Sets the value of the receiptRequest property.
	 * 
	 * @param value
	 *            allowed object is {@link SimpleReference }
	 * 
	 */
	public void setReceiptRequest(SimpleReference value) {
		this.receiptRequest = value;
	}

}
