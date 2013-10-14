/*
 * XmlUtils.java 2011-1-10
 * 智域工作室
 */
package net.intellizone.utils.xml;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.Logger;

/**
 * xml帮助类
 * 
 * @author Pliman
 * @version 1.0 2011-1-10
 * @since Utils 1.0
 */
public class XmlUtils {

	// 日志记录器
	private static final Logger logger = Logger.getLogger(XmlUtils.class
			.getSimpleName());

	// xml通用头部
	public static final String XML_HEADER = "<?xml version=\"1.0\" encoding=\"utf-8\"?>";

	/**
	 * 将对象转为xml
	 * 
	 * @param obj
	 *            需要转换的对象
	 * @return 带缩进的xml字符串
	 */
	public static String ObjectToXml(Object obj) {
		StringWriter sw = new StringWriter();
		try {
			JAXBContext context = JAXBContext.newInstance(new Class[] { obj
					.getClass() });

			Marshaller marshaller = context.createMarshaller();

			marshaller.setProperty("jaxb.encoding", "UTF-8");
			marshaller.setProperty("jaxb.formatted.output", Boolean
					.valueOf(true));
			marshaller.marshal(obj, sw);

			return sw.toString();
		} catch (JAXBException e) {
			logger.warn("将对象 " + obj.getClass().getName() + "转为xml出错", e);
		}

		return "";
	}

	/**
	 * 将xml字符串转为对象
	 * 
	 * @param <T>
	 *            对象类型
	 * @param obj
	 *            对象
	 * @param xml
	 * @return
	 */
	public static <T> T XmlToObject(Class<T> clz, String xml) {
		StringReader sr = new StringReader(xml);

		try {
			JAXBContext context = JAXBContext.newInstance(new Class[] { clz });

			Unmarshaller unMarshaller = context.createUnmarshaller();

			@SuppressWarnings("unchecked")
			T result = (T) unMarshaller.unmarshal(sr);
			return result;
		} catch (JAXBException e) {
			logger.warn("将xml字符串反解析为对象的时候失败", e);
		}

		return null;
	}
}