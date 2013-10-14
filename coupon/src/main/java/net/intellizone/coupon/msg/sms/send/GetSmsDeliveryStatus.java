package net.intellizone.coupon.msg.sms.send;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for getSmsDeliveryStatus complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;getSmsDeliveryStatus&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}anyType&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;requestIdentifier&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot;/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getSmsDeliveryStatus", namespace = "http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local", propOrder = { "requestIdentifier" })
public class GetSmsDeliveryStatus {

	@XmlElement(namespace = "http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local", required = true)
	protected String requestIdentifier;

	/**
	 * Gets the value of the requestIdentifier property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getRequestIdentifier() {
		return requestIdentifier;
	}

	/**
	 * Sets the value of the requestIdentifier property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setRequestIdentifier(String value) {
		this.requestIdentifier = value;
	}

}
