package net.intellizone.coupon.msg.sms.send;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import net.intellizone.coupon.msg.sms.common.DeliveryInformation;

/**
 * <p>
 * Java class for getSmsDeliveryStatusResponse complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;getSmsDeliveryStatusResponse&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}anyType&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;result&quot; type=&quot;{http://www.chinatelecom.com.cn/schema/ctcc/sms/v2_1}DeliveryInformation&quot; maxOccurs=&quot;unbounded&quot; minOccurs=&quot;0&quot;/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getSmsDeliveryStatusResponse", namespace = "http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local", propOrder = { "result" })
public class GetSmsDeliveryStatusResponse {

	@XmlElement(namespace = "http://www.chinatelecom.com.cn/schema/ctcc/sms/send/v2_1/local")
	protected List<DeliveryInformation> result;

	/**
	 * Gets the value of the result property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the result property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getResult().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DeliveryInformation }
	 * 
	 * 
	 */
	public List<DeliveryInformation> getResult() {
		if (result == null) {
			result = new ArrayList<DeliveryInformation>();
		}
		return this.result;
	}

}
