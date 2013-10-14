package net.intellizone.coupon.msg.common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for TimeMetric complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name=&quot;TimeMetric&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}anyType&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;metric&quot; type=&quot;{http://www.chinatelecom.com.cn/schema/ctcc/common/v2_1}TimeMetrics&quot;/&gt;
 *         &lt;element name=&quot;units&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}int&quot;/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TimeMetric", propOrder = { "metric", "units" })
public class TimeMetric {

	@XmlElement(required = true)
	protected TimeMetrics metric;
	protected int units;

	/**
	 * Gets the value of the metric property.
	 * 
	 * @return possible object is {@link TimeMetrics }
	 * 
	 */
	public TimeMetrics getMetric() {
		return metric;
	}

	/**
	 * Sets the value of the metric property.
	 * 
	 * @param value
	 *            allowed object is {@link TimeMetrics }
	 * 
	 */
	public void setMetric(TimeMetrics value) {
		this.metric = value;
	}

	/**
	 * Gets the value of the units property.
	 * 
	 */
	public int getUnits() {
		return units;
	}

	/**
	 * Sets the value of the units property.
	 * 
	 */
	public void setUnits(int value) {
		this.units = value;
	}

}
