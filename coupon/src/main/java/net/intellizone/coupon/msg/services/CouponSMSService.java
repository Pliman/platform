/*
 * CouponSMSService.java 2012-2-5
 * 智域工作室
 */
package net.intellizone.coupon.msg.services;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import net.intellizone.coupon.coupon.model.Goods;
import net.intellizone.coupon.msg.helper.ContentHelper;
import net.intellizone.coupon.msg.sms.services.SMSService;
import net.intellizone.coupon.user.model.User;

/**
 * 优惠卷短信发送服务
 * 
 * @author Pliman
 * @version 1.0 2012-2-5
 * @since coupon 1.0
 */
@Service
public class CouponSMSService {
	@Resource
	private SMSService sMSService;

	/**
	 * 发送优惠劵
	 * @param user 发送使用的用户
	 * @param SMSTempleteCode 发送使用的短信模板编码
	 * @return 是否成功
	 */
	public int sendCoupon(User user, String SMSTempleteCode,Goods coupon) {
		String content = ContentHelper.getSMSContent(user, SMSTempleteCode,coupon);
		
		return sMSService.sendSMS(user.getUserNo(), content);
	}
}
