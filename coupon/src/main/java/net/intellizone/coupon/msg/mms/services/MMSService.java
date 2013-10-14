/*
 * MMSService.java 2012-2-6
 * 智域工作室
 */
package net.intellizone.coupon.msg.mms.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.ws.Binding;

import net.intellizone.core.constants.Constants;
import net.intellizone.coupon.msg.common.ChargingInformation;
import net.intellizone.coupon.msg.common.RequestSOAPHeader;
import net.intellizone.coupon.msg.common.SimpleReference;
import net.intellizone.coupon.msg.config.MsgConfig;
import net.intellizone.coupon.msg.mms.common.MessagePriority;
import net.intellizone.coupon.msg.mms.send.ClientSOAPHandler;
import net.intellizone.coupon.msg.mms.send.PolicyException_Exception;
import net.intellizone.coupon.msg.mms.send.SendMessage;
import net.intellizone.coupon.msg.mms.send.SendMessageService;
import net.intellizone.coupon.msg.mms.send.ServiceException_Exception;
import net.intellizone.coupon.msg.sms.MD5;
import net.intellizone.utils.DateUtils;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.sun.xml.ws.api.message.Headers;
import com.sun.xml.ws.developer.WSBindingProvider;

/**
 * 彩信服务
 * 
 * @author Pliman
 * @version 1.0
 * @since izwebservices 1.0
 */
@Service
public class MMSService {
	// 日志记录器
	private static final Logger logger = Logger.getLogger(MMSService.class.getSimpleName());

	// 消息配置
	MsgConfig config = MsgConfig.INSTANCE;

	private final String webserviceurl = config.getConfig("webserviceurl");
	private final String SPID = config.getConfig("SPID"); // SPID
	private final String Token = config.getConfig("Token"); // 密钥
	private final String DestNum = config.getConfig("DestNum"); // 发送号码
	private final String ProductID = config.getConfig("ProductID"); // 产品编号
	private final String ServiceID = config.getConfig("ServiceID"); // 业务编号
	private final String senderName = config.getConfig("senderName"); // 短信主叫号码，在浙江ISAG实际无效，ISAG会读取业务部署时候的接入号

	/**
	 * 发送彩信
	 * 
	 * @param number
	 *            电话号码
	 * @param subject
	 *            主题
	 * @param attachments
	 *            彩信附件
	 * @return 是否成功
	 */
	@SuppressWarnings("unchecked")
	public int sendMMS(String number, String subject, List<String> attachments) {
		List<String> addresses = new ArrayList<String>();
		String TimeStamp = DateUtils.formatCurrentDate("MMddHHmmss"); // 当前时间

		RequestSOAPHeader SoapHeader = new RequestSOAPHeader();
		try {
			/* 初始化Web Service Client */
			SendMessageService ss = new SendMessageService();
			SendMessage sendMsg = ss.getSendMessage();
			/* 设置SOAP Header */
			SoapHeader.setSpId(SPID);
			SoapHeader.setTimeStamp(TimeStamp);
			SoapHeader.setSpPassword(MD5.compile(SPID + Token + TimeStamp).toUpperCase());
			SoapHeader.setProductId(ProductID);
			SoapHeader.setOA(DestNum);
			SoapHeader.setFA(DestNum);
			SoapHeader.setMulticastMessaging(false);

			WSBindingProvider sendSmsbp = (WSBindingProvider) sendMsg;
			try {
				sendSmsbp.setOutboundHeaders(Headers.create(JAXBContext
						.newInstance(new Class[] { SoapHeader.getClass() }), SoapHeader));
				Binding bd = sendSmsbp.getBinding();

				List handlerChain = bd.getHandlerChain();
				ClientSOAPHandler handler = new ClientSOAPHandler();
				handler.setAttachments(attachments);
				
				handlerChain.add(handler);
			} catch (JAXBException e) {
				logger.warn("创建JAXBContext时失败", e);
			}

			/* 设置被叫号码 */
			addresses.add(number);

			// 设置优先级
			// MessagePriority priority = MessagePriority.NORMAL;

			/* 设置ChargingInformation */
			ChargingInformation charging = new ChargingInformation();
			charging.setDescription("gm");// 描述
			charging.setAmount(new BigDecimal(1));// 扣费数目
			charging.setCode(ServiceID);// 业务代码
			charging.setCurrency("0");

			/* 设置SimpleReference */
			SimpleReference receiptRequest = new SimpleReference();
			receiptRequest.setCorrelator("1001559"); // 序号自己随机增加
			receiptRequest.setInterfaceName("MessageNotification");
			receiptRequest.setEndpoint(webserviceurl);

			if (logger.isDebugEnabled()) {
				logger.debug("发送彩信：\n" + "彩信...");
			}

			/* 发送短信 */
			String result = sendMsg.sendMessage(addresses, senderName, subject,
					MessagePriority.NORMAL, charging, receiptRequest);

			System.out.println("result:" + result);

			return Constants.SUCCESS;
		} catch (PolicyException_Exception e) {
			logger.error("发送彩信时，规则失败", e);
		} catch (ServiceException_Exception e) {
			logger.error("发送彩信时，鉴权失败", e);
		}

		return Constants.FAILURE;
	}

	public int receiveMMS() {

		return 0;
	}
}