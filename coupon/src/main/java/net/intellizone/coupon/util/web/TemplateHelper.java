/*
 * TemplateHelper.java 2012-3-13
 * 智域工作室
 */
package net.intellizone.coupon.util.web;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import net.intellizone.coupon.user.model.User;

import org.apache.log4j.Logger;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.context.InternalContextAdapterImpl;
import org.apache.velocity.runtime.RuntimeSingleton;
import org.apache.velocity.runtime.parser.ParseException;
import org.apache.velocity.runtime.parser.node.SimpleNode;

/**
 * 文字模板帮组类
 * 
 * @author Pliman
 * @version 1.0
 * @since coupon 1.0
 */
public enum TemplateHelper {
	INSTANCE;

	// 日志记录器
	private static final Logger logger = Logger.getLogger(TemplateHelper.class.getSimpleName());

	// velocity上下文
	private VelocityContext context = new VelocityContext();

	/**
	 * 合并模板和上下文
	 * 
	 * @param strTemplate
	 * @param contextValues
	 * @return 替换结果
	 */
	public String merge(String strTemplate, Map<String, Object> contextValues) {
		try {
			for (Entry<String, Object> entry : contextValues.entrySet()) {
				context.put(entry.getKey(), entry.getValue());
			}
			StringReader reader = new StringReader(strTemplate);
			StringWriter writer = new StringWriter();

			SimpleNode nodeTree = RuntimeSingleton.parse(reader, "MsgTemplate", false);

			if (nodeTree != null) {
				InternalContextAdapterImpl ica = new InternalContextAdapterImpl(context);
				ica.pushCurrentTemplateName("MsgTemplate");
				nodeTree.init(ica, RuntimeSingleton.getRuntimeServices());
				nodeTree.render(ica, writer);
				ica.popCurrentTemplateName();
			}

			return writer.toString();
		} catch (ParseException pex) {
			logger.warn("解析文字模板出错", pex);
		} catch (IOException e) {
			logger.warn("输出解析后的模板出错", e);
		}

		return "";
	}

	public static void main(String[] args) throws IOException {
		Map<String, Object> contextValues = new HashMap<String, Object>();
		User user = new User();
		user.setName("张三");
		contextValues.put("user", user);

		System.out.println(INSTANCE.merge("你好,$!{user.name}", contextValues));
	}
}
