/**
 * FileUtils.java 2011-4-16
 * 智域工作室
 */
package net.intellizone.utils.xml;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import net.intellizone.utils.FileUtils;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class XmlEditor {

	/**
	 * 日志记录器
	 */
	protected static final Logger logger = Logger.getLogger(XmlEditor.class.getName());

	/**
	 * 读取xml文件
	 * 
	 * @return xml文档
	 */
	public static Document readXML(String filePath) {
		try {
			File file = new File(filePath);
			SAXReader reader = new SAXReader();

			return reader.read(file);
		} catch (DocumentException e) {
			logger.debug("未读取文件 " + filePath);
		}
		return null;
	}

	/**
	 * 读取xml文件
	 * 
	 * @return xml字符串
	 */
	public static String readXMLToString(String filePath) {
		Document doc = XmlEditor.readXML(filePath);
		if (doc == null) {
			return "";
		}
		String xmlString = XmlEditor.xmlDocToString(doc);
		return xmlString;
	}

	/**
	 * 从doc对象写xml文件
	 * 
	 * @return 写入的文件路径
	 */
	public static String writeXML(Document doc, String filePath) {
		try {
			File file = new File(filePath);

			FileUtils.ensurePath(file);

			FileOutputStream fileOutputStream = new FileOutputStream(file);
			OutputFormat xmlFormat = OutputFormat.createPrettyPrint();
			xmlFormat.setEncoding("UTF-8");

			XMLWriter xmlWriter = new XMLWriter(fileOutputStream, xmlFormat);
			xmlWriter.write(doc);
			xmlWriter.close();
			fileOutputStream.close();
		} catch (Exception e) {
			logger.error("写入文件失败! " + e.getMessage(), e);
		}
		return filePath;
	}

	/**
	 * 从字符串写xml文件
	 * 
	 * @return 写入的文件路径
	 */
	public static String writeStringToXML(String xmlString, String filePath) {
		Document doc = XmlEditor.stringToXmlDoc(xmlString);
		String writenPath = XmlEditor.writeXML(doc, filePath);

		return writenPath;
	}

	/**
	 * 更新xml元素的属性值
	 * 
	 * @param filePath
	 *            需要更新文档的路径
	 * @param nodeXPath
	 *            需要更新的节点xpath路径
	 * @param value
	 *            新的节点值
	 * @return 更新成功与否
	 */
	public static boolean updateXmlFileByNodeXPath(String filePath, String nodeXPath, String value) {
		Document doc = XmlEditor.readXML(filePath);

		Node node = doc.selectSingleNode(nodeXPath);
		node.setText(value);

		String xmlString = xmlDocToString(doc);
		writeStringToXML(xmlString, filePath);

		return true;
	}

	/**
	 * 插入xml节点
	 * 
	 * @param filePath
	 *            需要更新文档的路径
	 * @param nodeStr
	 *            需要插入节点的父节点xpath路径
	 * @param node
	 *            新的借点只值
	 * @return 更新信息
	 */
	public static boolean insertNodeIntoXml(String filePath, String parentNodeStr, Element node) {
		Document doc = XmlEditor.readXML(filePath);

		Node parentNode = doc.selectSingleNode(parentNodeStr);
		if (parentNode.getNodeTypeName().equals("Element")) {
			Element el = (Element) parentNode;
			el.add(node);
		}

		XmlEditor.writeXML(doc, filePath);

		return true;
	}

	/**
	 * 将Document对象转为String
	 * 
	 * @param doc
	 *            需要转换的Document对象
	 * @return xmlString 转换后的String
	 */
	public static String xmlDocToString(Document doc) {
		java.io.StringWriter out = new java.io.StringWriter();
		XMLWriter xw = new XMLWriter(out, new OutputFormat(" ", true, "UTF-8"));
		try {
			xw.write(doc);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String xmlString = out.toString();
		return xmlString;
	}

	/**
	 * 将String转为Document对象
	 * 
	 * @param xmlString
	 *            需要转换的xmlString
	 * @return doc 转换后的document
	 */
	public static Document stringToXmlDoc(String xmlString) {
		Document doc;
		try {
			doc = DocumentHelper.parseText(xmlString);
			return doc;
		} catch (DocumentException e) {
			e.printStackTrace();
			logger.warn("从字符串解析xml失败！");
		}

		return null;
	}

	/**
	 * 根据XPath路径，获取节点的值
	 * 
	 * @param doc
	 *            文档
	 * @param XPath
	 *            路径
	 * @return 节点值
	 */
	public static String getValueByXPath(Document doc, String XPath) {
		return doc.selectSingleNode(XPath).getText();
	}

	/**
	 * 根据XPath路径，获取节点的值
	 * 
	 * @param doc
	 *            文档
	 * @param XPath
	 *            路径
	 * @return 节点值
	 */
	public static String getValueByXPath(String xmlString, String XPath) {
		return getValueByXPath(stringToXmlDoc(xmlString), XPath);
	}

	public static void main(String[] args) {
		String xmlString = XmlUtils.XML_HEADER + "<root><a><b><c>ccc</c></b></a></root>";
		System.out.println(getValueByXPath(stringToXmlDoc(xmlString), "/root/a/b/c"));
	}
}