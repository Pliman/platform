/*
 * PersonDao.java 2011-12-28
 * 智域工作室
 */
package net.intellizone.demo.services;

import java.util.List;

import javax.sql.DataSource;

import net.intellizone.db.MysqlDataSourceManager;
import net.intellizone.demo.model.Person;

import org.nutz.dao.Dao;
import org.nutz.dao.impl.NutDao;
import org.springframework.stereotype.Service;

/**
 * 人员数据库访问层
 * 
 * @author Pliman
 * @version 1.0
 * @since demo 1.0
 */
@Service
public class PersonService {
	// nutz dao
	private Dao dao;

	// 初始化数据源
	public PersonService() {
		DataSource ds = MysqlDataSourceManager.INSTANCE.getDataSource();

		dao = new NutDao(ds);
	}

	/**
	 * 添加人员
	 * 
	 * @param person
	 *            需要添加的人员
	 * @return 被添加后的人员
	 */
	public Person addPerson(Person person) {
		return dao.insert(person);
	}

	/**
	 * 根据人员id，获取人员
	 * 
	 * @param id
	 *            人员id
	 * @return 人员
	 */
	public Person getPersonById(long id) {
		return dao.fetch(Person.class, id);
	}

	/**
	 * 获取所有人员
	 * 
	 * @return 所有人员
	 */
	public List<Person> getAllPerson() {
		return dao.query(Person.class, null, null);
	}

	/**
	 * 更新人员
	 * 
	 * @param person
	 *            需要更新的人员
	 * @return 更新是否成功
	 */
	public int updatePerson(Person person) {
		return dao.update(person);
	}

	/**
	 * 删除人员
	 * 
	 * @param person
	 *            需要删除的人员
	 * @return 删除是否成功
	 */
	public int deletePerson(Person person) {
		return dao.delete(person);
	}
}
