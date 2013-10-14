/*
 * Person.java 2011-12-28
 * 智域工作室
 */
package net.intellizone.demo.model;

import org.nutz.dao.DB;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Prev;
import org.nutz.dao.entity.annotation.SQL;
import org.nutz.dao.entity.annotation.Table;

/**
 * Person实体类
 * 
 * @author Pliman
 * @version 1.0
 * @since demo 1.0
 */
@Table("person")
public class Person {
	// 主键id
	@Column("id")
	@Prev(@SQL(db = DB.MYSQL, value = "select MAX(person_id) from person"))
	@Id(auto = false)
	private long id;

	// 名称
	@Column("name")
	private String name;

	// 年龄
	@Column("age")
	private int age;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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
