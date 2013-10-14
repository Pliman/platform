/*
 * IsmpSpEngineImpl.java 2011-1-14
 * 智域工作室
 */
package net.intellizone.coupon.ismp;

import javax.annotation.Resource; // import javax.jws.WebMethod;
// import javax.jws.WebParam;
// import javax.jws.WebResult;
// import javax.jws.WebService;
// import javax.jws.soap.SOAPBinding;

import org.apache.commons.codec.digest.DigestUtils;

import net.intellizone.coupon.user.model.User;
import net.intellizone.coupon.user.services.UserService;

/**
 * ismp用户同步接口
 * 
 * @author Pliman
 * @version 1.0 2011-1-14
 * @since coupon 1.0
 */
@javax.jws.WebService(endpointInterface = "net.intellizone.coupon.ismp.IsmpSpEngine", targetNamespace = "http://sp.ismp.chinatelecom.com", serviceName = "IsmpSpEngineService", portName = "IsmpSpEngine")
public class IsmpSpEngineImpl {

	@Resource
	private UserService userService;

	/**
	 * 订购关系更新
	 * 
	 * 0：定购 1：暂停 2：暂停恢复 3：退定 4：退定该 SP 的所有产品和套餐 5：暂停该 SP 的所有产品和套餐
	 * 
	 * @param orderRelationUpdateNotifyReq
	 * @return 平台响应
	 */
	public Response orderRelationUpdateNotify(OrderRelationUpdateNotifyReq orderRelationUpdateNotifyReq) {
		String userNo = orderRelationUpdateNotifyReq.getUserID();

		User user = new User();

		int oPType = orderRelationUpdateNotifyReq.getOPType();
		// 如果是订购和暂定恢复，插入账户
		if (oPType == 0 || oPType == 2) {
			user.setUserNo(userNo);
			user.setPassword(DigestUtils.md5Hex("888888"));
			// 插入用户
			userService.insertUser(user);
		} else {
			// 如果是其他关系，删除用户
			user = userService.getUserByUserNo(userNo);
			userService.deleteUser(user);
		}

		Response response = new Response();
		response.setStreamingNo(orderRelationUpdateNotifyReq.getStreamingNo());
		response.setResultCode(0);

		return response;
	}

	/**
	 * 业务执行通知消息
	 * 
	 * @param serviceConsumeNotifyReqPara
	 *            业务执行通知消息参数
	 * @return 平台响应
	 */
	public Response serviceConsumeNotify(ServiceConsumeNotifyReq serviceConsumeNotifyReqPara) {
		Response response = new Response();
		response.setStreamingNo(serviceConsumeNotifyReqPara.getStreamingNo());
		response.setResultCode(0);

		return response;
	}

	/**
	 * 管理信息通知接口
	 * 
	 * @param notifyManagementInfoReq
	 *            管理信息通知请求参数
	 * @return 管理信息通知平台响应
	 */
	public NotifyManagementInfoRsp notifyManagementInfo(NotifyManagementInfoReq notifyManagementInfoReq) {
		NotifyManagementInfoRsp nrsp = new NotifyManagementInfoRsp();
		nrsp.setStreamingNo(notifyManagementInfoReq.getStreamingNo());
		nrsp.setResultCode(0);

		return nrsp;
	}

}