/*
 * ClientSOAPHandler.java 2012-2-28
 * 智域工作室
 */
package net.intellizone.coupon.msg.mms.send;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.xml.soap.AttachmentPart;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

/**
 * SOAP附件处理类
 * 
 * @author Pliman
 * @version 1.0
 * @since coupon 1.0
 */
@SuppressWarnings("unchecked")
public class ClientSOAPHandler implements SOAPHandler {
	private List<String> attachments;

	public void setAttachments(List<String> attachments) {
		this.attachments = attachments;
	}

	@Override
	public Set getHeaders() {
		return null;
	}

	@Override
	public void close(MessageContext context) {
	}

	@Override
	public boolean handleFault(MessageContext context) {
		return true;
	}

	/**
	 * 处理消息上下文，添加附件
	 * 
	 * @param arg0
	 *            消息上下文
	 */
	@Override
	@SuppressWarnings("unchecked")
	public boolean handleMessage(MessageContext arg0) {
		SOAPMessageContext smc = (SOAPMessageContext) arg0;
		Boolean outboundProperty = (Boolean) smc.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);

		if (outboundProperty.booleanValue()) {
			Map<String, DataHandler> attachmentMap = (Map<String, DataHandler>) smc
					.get(MessageContext.OUTBOUND_MESSAGE_ATTACHMENTS);
			if (attachmentMap == null) {
				attachmentMap = new HashMap<String, DataHandler>();
				smc.put(MessageContext.OUTBOUND_MESSAGE_ATTACHMENTS, attachmentMap);
			}
			try {
				for (int i = 0, length = attachments.size(); i < length; i++) {
					DataHandler dh = new DataHandler(new FileDataSource(attachments.get(i)));
					attachmentMap.put("Attachment" + i, dh);
				}
			} catch (Exception ex) {
				System.out.println("*****Adding attachment has exception!!!*****");
				ex.printStackTrace();
			}
			System.out.println("Attachment sending...");
		} else {
			SOAPMessage sm = smc.getMessage();
			Iterator attachments1 = sm.getAttachments();
			while (attachments1.hasNext()) {
				AttachmentPart attachment1 = (AttachmentPart) attachments1.next();
				System.out.println("The attachment ContentId:" + attachment1.getContentId());
			}
		}

		return true;
	}
}
