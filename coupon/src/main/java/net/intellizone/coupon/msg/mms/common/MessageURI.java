package net.intellizone.coupon.msg.mms.common;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for MessageURI complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;MessageURI&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}anyType&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;bodyText&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;fileReferences&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}anyURI&quot; maxOccurs=&quot;unbounded&quot; minOccurs=&quot;0&quot;/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MessageURI", namespace = "http://www.chinatelecom.com.cn/schema/ctcc/multimedia_messaging/v2_2", propOrder = {
		"bodyText", "fileReferences" })
public class MessageURI {

	protected String bodyText;
	@XmlSchemaType(name = "anyURI")
	protected List<String> fileReferences;

	/**
	 * Gets the value of the bodyText property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getBodyText() {
		return bodyText;
	}

	/**
	 * Sets the value of the bodyText property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setBodyText(String value) {
		this.bodyText = value;
	}

	/**
	 * Gets the value of the fileReferences property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the fileReferences property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getFileReferences().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link String }
	 * 
	 * 
	 */
	public List<String> getFileReferences() {
		if (fileReferences == null) {
			fileReferences = new ArrayList<String>();
		}
		return this.fileReferences;
	}

}
