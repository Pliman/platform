package net.intellizone.coupon.msg.sms.common;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DeliveryStatus.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p>
 * 
 * <pre>
 * &lt;simpleType name=&quot;DeliveryStatus&quot;&gt;
 *   &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}string&quot;&gt;
 *     &lt;enumeration value=&quot;DeliveredToNetwork&quot;/&gt;
 *     &lt;enumeration value=&quot;DeliveryUncertain&quot;/&gt;
 *     &lt;enumeration value=&quot;DeliveryImpossible&quot;/&gt;
 *     &lt;enumeration value=&quot;MessageWaiting&quot;/&gt;
 *     &lt;enumeration value=&quot;DeliveredToTerminal&quot;/&gt;
 *     &lt;enumeration value=&quot;DeliveryNotificationNotSupported&quot;/&gt;
 *     &lt;enumeration value=&quot;AuthPriceFailed&quot;/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "DeliveryStatus", namespace = "http://www.chinatelecom.com.cn/schema/ctcc/sms/v2_1")
@XmlEnum
public enum DeliveryStatus {

	@XmlEnumValue("DeliveredToNetwork")
	DELIVERED_TO_NETWORK("DeliveredToNetwork"), @XmlEnumValue("DeliveryUncertain")
	DELIVERY_UNCERTAIN("DeliveryUncertain"), @XmlEnumValue("DeliveryImpossible")
	DELIVERY_IMPOSSIBLE("DeliveryImpossible"), @XmlEnumValue("MessageWaiting")
	MESSAGE_WAITING("MessageWaiting"), @XmlEnumValue("DeliveredToTerminal")
	DELIVERED_TO_TERMINAL("DeliveredToTerminal"), @XmlEnumValue("DeliveryNotificationNotSupported")
	DELIVERY_NOTIFICATION_NOT_SUPPORTED("DeliveryNotificationNotSupported"), @XmlEnumValue("AuthPriceFailed")
	AUTH_PRICE_FAILED("AuthPriceFailed");
	private final String value;

	DeliveryStatus(String v) {
		value = v;
	}

	public String value() {
		return value;
	}

	public static DeliveryStatus fromValue(String v) {
		for (DeliveryStatus c : DeliveryStatus.values()) {
			if (c.value.equals(v)) {
				return c;
			}
		}
		throw new IllegalArgumentException(v);
	}

}
