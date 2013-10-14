package net.intellizone.coupon.ismp;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for OrderRelationUpdateNotifyReq complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;OrderRelationUpdateNotifyReq&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}anyType&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;OPType&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}int&quot;/&gt;
 *         &lt;element name=&quot;packageID&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot;/&gt;
 *         &lt;element name=&quot;productID&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot;/&gt;
 *         &lt;element name=&quot;streamingNo&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot;/&gt;
 *         &lt;element name=&quot;userID&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot;/&gt;
 *         &lt;element name=&quot;userIDType&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}int&quot;/&gt;
 *         &lt;element name=&quot;VerUserID&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; maxOccurs=&quot;unbounded&quot; minOccurs=&quot;0&quot;/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OrderRelationUpdateNotifyReq", propOrder = { "opType", "packageID", "productID", "streamingNo",
		"userID", "userIDType", "verUserID" })
public class OrderRelationUpdateNotifyReq {

	@XmlElement(name = "OPType")
	protected int opType;
	@XmlElement(required = true, nillable = true)
	protected String packageID;
	@XmlElement(required = true, nillable = true)
	protected String productID;
	@XmlElement(required = true, nillable = true)
	protected String streamingNo;
	@XmlElement(required = true, nillable = true)
	protected String userID;
	protected int userIDType;
	@XmlElement(name = "VerUserID", nillable = true)
	protected List<String> verUserID;

	/**
	 * Gets the value of the opType property.
	 * 
	 */
	public int getOPType() {
		return opType;
	}

	/**
	 * Sets the value of the opType property.
	 * 
	 */
	public void setOPType(int value) {
		this.opType = value;
	}

	/**
	 * Gets the value of the packageID property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getPackageID() {
		return packageID;
	}

	/**
	 * Sets the value of the packageID property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPackageID(String value) {
		this.packageID = value;
	}

	/**
	 * Gets the value of the productID property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getProductID() {
		return productID;
	}

	/**
	 * Sets the value of the productID property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setProductID(String value) {
		this.productID = value;
	}

	/**
	 * Gets the value of the streamingNo property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getStreamingNo() {
		return streamingNo;
	}

	/**
	 * Sets the value of the streamingNo property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setStreamingNo(String value) {
		this.streamingNo = value;
	}

	/**
	 * Gets the value of the userID property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getUserID() {
		return userID;
	}

	/**
	 * Sets the value of the userID property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setUserID(String value) {
		this.userID = value;
	}

	/**
	 * Gets the value of the userIDType property.
	 * 
	 */
	public int getUserIDType() {
		return userIDType;
	}

	/**
	 * Sets the value of the userIDType property.
	 * 
	 */
	public void setUserIDType(int value) {
		this.userIDType = value;
	}

	/**
	 * Gets the value of the verUserID property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the verUserID property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getVerUserID().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link String }
	 * 
	 * 
	 */
	public List<String> getVerUserID() {
		if (verUserID == null) {
			verUserID = new ArrayList<String>();
		}
		return this.verUserID;
	}

}
