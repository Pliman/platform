package net.intellizone.coupon.msg.mms.common;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for MessagePriority.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p>
 * 
 * <pre>
 * &lt;simpleType name=&quot;MessagePriority&quot;&gt;
 *   &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}string&quot;&gt;
 *     &lt;enumeration value=&quot;Default&quot;/&gt;
 *     &lt;enumeration value=&quot;Low&quot;/&gt;
 *     &lt;enumeration value=&quot;Normal&quot;/&gt;
 *     &lt;enumeration value=&quot;High&quot;/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "MessagePriority", namespace = "http://www.chinatelecom.com.cn/schema/ctcc/multimedia_messaging/v2_2")
@XmlEnum
public enum MessagePriority {

	@XmlEnumValue("Default")
	DEFAULT("Default"), @XmlEnumValue("Low")
	LOW("Low"), @XmlEnumValue("Normal")
	NORMAL("Normal"), @XmlEnumValue("High")
	HIGH("High");
	private final String value;

	MessagePriority(String v) {
		value = v;
	}

	public String value() {
		return value;
	}

	public static MessagePriority fromValue(String v) {
		for (MessagePriority c : MessagePriority.values()) {
			if (c.value.equals(v)) {
				return c;
			}
		}
		throw new IllegalArgumentException(v);
	}

}
