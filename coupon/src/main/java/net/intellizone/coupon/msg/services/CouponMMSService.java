/*
 * CouponMMSService.java 2012-2-5
 * 智域工作室
 */
package net.intellizone.coupon.msg.services;

import javax.annotation.Resource;

import net.intellizone.coupon.coupon.model.Goods;
import net.intellizone.coupon.msg.helper.ContentHelper;
import net.intellizone.coupon.msg.mms.services.MMSService;
import net.intellizone.coupon.msg.model.MMS;
import net.intellizone.coupon.user.model.User;

import org.springframework.stereotype.Service;

/**
 * 优惠卷彩信发送服务
 * 
 * @author Pliman
 * @version 1.0 2012-2-5
 * @since coupon 1.0
 */
@Service
public class CouponMMSService {
	@Resource
	private MMSService mMSService;
	
	/**
	 * 发送优惠劵
	 * 
	 * @param user
	 *            发送使用的用户
	 * @param MMSTempleteCode
	 *            发送使用的彩信模板编码
	 * @return 是否成功
	 */
	public int sendCoupon(User user, String MMSTempleteCode,Goods coupon) {
		MMS mms = ContentHelper.getMMS(user, MMSTempleteCode,coupon);

		return mMSService.sendMMS(user.getUserNo(), mms.getContent(),mms.getAttachmentList());
	}
}
