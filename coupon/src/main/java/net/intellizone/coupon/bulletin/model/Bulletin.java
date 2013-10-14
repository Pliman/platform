/*
 * Bulletin.java 2012-1-19
 * 智域团队
 */
package net.intellizone.coupon.bulletin.model;

import org.nutz.dao.DB;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Prev;
import org.nutz.dao.entity.annotation.SQL;
import org.nutz.dao.entity.annotation.Table;

/**
 * 公告实体类
 * 
 * @author Pliman
 * @version 1.0 2012-1-19
 * @since coupon 1.0
 */
@Table("iz_bulletin")
public class Bulletin {
	// 主键id
	@Column("id")
	@Prev(@SQL(db = DB.MYSQL, value = "SELECT MAX(id) FROM iz_bulletin"))
	@Id(auto = false)
	private long id;

	@Column("content")
	private String content;

	@Column("pub_person")
	private int pubPerson;

	@Column("pub_time")
	private String pubTime;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getPubPerson() {
		return pubPerson;
	}

	public void setPubPerson(int pubPerson) {
		this.pubPerson = pubPerson;
	}

	public String getPubTime() {
		return pubTime;
	}

	public void setPubTime(String pubTime) {
		this.pubTime = pubTime;
	}
}
