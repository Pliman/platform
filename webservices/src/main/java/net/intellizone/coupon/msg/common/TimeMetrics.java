package net.intellizone.coupon.msg.common;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for TimeMetrics.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p>
 * 
 * <pre>
 * &lt;simpleType name=&quot;TimeMetrics&quot;&gt;
 *   &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}string&quot;&gt;
 *     &lt;enumeration value=&quot;Millisecond&quot;/&gt;
 *     &lt;enumeration value=&quot;Second&quot;/&gt;
 *     &lt;enumeration value=&quot;Minute&quot;/&gt;
 *     &lt;enumeration value=&quot;Hour&quot;/&gt;
 *     &lt;enumeration value=&quot;Day&quot;/&gt;
 *     &lt;enumeration value=&quot;Week&quot;/&gt;
 *     &lt;enumeration value=&quot;Month&quot;/&gt;
 *     &lt;enumeration value=&quot;Year&quot;/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "TimeMetrics")
@XmlEnum
public enum TimeMetrics {

	@XmlEnumValue("Millisecond")
	MILLISECOND("Millisecond"), @XmlEnumValue("Second")
	SECOND("Second"), @XmlEnumValue("Minute")
	MINUTE("Minute"), @XmlEnumValue("Hour")
	HOUR("Hour"), @XmlEnumValue("Day")
	DAY("Day"), @XmlEnumValue("Week")
	WEEK("Week"), @XmlEnumValue("Month")
	MONTH("Month"), @XmlEnumValue("Year")
	YEAR("Year");
	private final String value;

	TimeMetrics(String v) {
		value = v;
	}

	public String value() {
		return value;
	}

	public static TimeMetrics fromValue(String v) {
		for (TimeMetrics c : TimeMetrics.values()) {
			if (c.value.equals(v)) {
				return c;
			}
		}
		throw new IllegalArgumentException(v);
	}

}
