package net.intellizone.coupon.msg.sms.common;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for SmsFormat.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p>
 * 
 * <pre>
 * &lt;simpleType name=&quot;SmsFormat&quot;&gt;
 *   &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}string&quot;&gt;
 *     &lt;enumeration value=&quot;Ems&quot;/&gt;
 *     &lt;enumeration value=&quot;SmartMessaging&quot;/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "SmsFormat", namespace = "http://www.chinatelecom.com.cn/schema/ctcc/sms/v2_1")
@XmlEnum
public enum SmsFormat {

	@XmlEnumValue("Ems")
	EMS("Ems"), @XmlEnumValue("SmartMessaging")
	SMART_MESSAGING("SmartMessaging");
	private final String value;

	SmsFormat(String v) {
		value = v;
	}

	public String value() {
		return value;
	}

	public static SmsFormat fromValue(String v) {
		for (SmsFormat c : SmsFormat.values()) {
			if (c.value.equals(v)) {
				return c;
			}
		}
		throw new IllegalArgumentException(v);
	}

}
