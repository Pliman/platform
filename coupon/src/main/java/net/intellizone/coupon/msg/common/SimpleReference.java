package net.intellizone.coupon.msg.common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for SimpleReference complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;SimpleReference&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}anyType&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;endpoint&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}anyURI&quot;/&gt;
 *         &lt;element name=&quot;interfaceName&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot;/&gt;
 *         &lt;element name=&quot;correlator&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot;/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SimpleReference", propOrder = { "endpoint", "interfaceName", "correlator" })
public class SimpleReference {

	@XmlElement(required = true)
	@XmlSchemaType(name = "anyURI")
	protected String endpoint;
	@XmlElement(required = true)
	protected String interfaceName;
	@XmlElement(required = true)
	protected String correlator;

	/**
	 * Gets the value of the endpoint property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getEndpoint() {
		return endpoint;
	}

	/**
	 * Sets the value of the endpoint property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setEndpoint(String value) {
		this.endpoint = value;
	}

	/**
	 * Gets the value of the interfaceName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getInterfaceName() {
		return interfaceName;
	}

	/**
	 * Sets the value of the interfaceName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setInterfaceName(String value) {
		this.interfaceName = value;
	}

	/**
	 * Gets the value of the correlator property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCorrelator() {
		return correlator;
	}

	/**
	 * Sets the value of the correlator property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCorrelator(String value) {
		this.correlator = value;
	}

}
