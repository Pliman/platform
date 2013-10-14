package net.intellizone.coupon.msg.sms.send;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

import net.intellizone.coupon.msg.common.ChargingInformation;
import net.intellizone.coupon.msg.common.SimpleReference;

/**
 * <p>
 * Java class for sendSms complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;sendSms&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}anyType&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;addresses&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}anyURI&quot; maxOccurs=&quot;unbounded&quot;/&gt;
 *         &lt;element name=&quot;senderName&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;charging&quot; type=&quot;{http://www.chinatelecom.com.cn/schema/ctcc/common/v2_1}ChargingInformation&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;message&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot;/&gt;
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
@XmlType(name = "sendSms", namespace = "http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local", propOrder = {
		"addresses", "senderName", "charging", "message", "receiptRequest" })
public class SendSms_Type {

	@XmlElement(namespace = "http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local", required = true)
	@XmlSchemaType(name = "anyURI")
	protected List<String> addresses;
	@XmlElement(namespace = "http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local")
	protected String senderName;
	@XmlElement(namespace = "http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local")
	protected ChargingInformation charging;
	@XmlElement(namespace = "http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local", required = true)
	protected String message;
	@XmlElement(namespace = "http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local")
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
	 * Gets the value of the senderName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSenderName() {
		return senderName;
	}

	/**
	 * Sets the value of the senderName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSenderName(String value) {
		this.senderName = value;
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
