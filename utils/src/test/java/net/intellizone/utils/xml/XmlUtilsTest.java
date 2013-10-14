/*
 * XmlUtilsTest.java 2011-1-10
 * 智域工作室
 */
package net.intellizone.utils.xml;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.xml.bind.annotation.XmlRootElement;

import net.intellizone.utils.xml.XmlUtils;

import org.junit.Test;

/**
 * Xml帮助类测试类
 * 
 * @author Pliman
 * @version 1.0 2011-1-10
 * @since Utils 1.0
 */
public class XmlUtilsTest {
	@Test
	public void TestObjectToXml() {
		PlainObject po = new PlainObject();
		po.setAge(1);
		po.setName("Tom");

		assertNotNull(XmlUtils.ObjectToXml(po));
	}

	@Test
	public void TestXmlToObject() {
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><plainObject><age>1</age><name>Tom</name></plainObject>";

		PlainObject po = XmlUtils.XmlToObject(PlainObject.class, xml);

		assertEquals(po.getAge(), 1);
	}

	// 用于测试的类
	@XmlRootElement
	private static class PlainObject {
		private String name;

		private int age;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}
	}
}
