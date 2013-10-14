package net.intellizone.coupon.msg.common;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DeliveryConfirmStatus.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p>
 * 
 * <pre>
 * &lt;simpleType name=&quot;DeliveryConfirmStatus&quot;&gt;
 *   &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}string&quot;&gt;
 *     &lt;enumeration value=&quot;Success&quot;/&gt;
 *     &lt;enumeration value=&quot;Fail&quot;/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "DeliveryConfirmStatus")
@XmlEnum
public enum DeliveryConfirmStatus {

	@XmlEnumValue("Success")
	SUCCESS("Success"), @XmlEnumValue("Fail")
	FAIL("Fail");
	private final String value;

	DeliveryConfirmStatus(String v) {
		value = v;
	}

	public String value() {
		return value;
	}

	public static DeliveryConfirmStatus fromValue(String v) {
		for (DeliveryConfirmStatus c : DeliveryConfirmStatus.values()) {
			if (c.value.equals(v)) {
				return c;
			}
		}
		throw new IllegalArgumentException(v);
	}

}
