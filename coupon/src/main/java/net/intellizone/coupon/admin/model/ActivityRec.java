package net.intellizone.coupon.admin.model;

import org.nutz.dao.entity.annotation.Column;

public class ActivityRec {
	@Column("h.id")
	private int id;
	@Column("h.description")
	private String description;
	@Column("h.link")
	private String link;
	@Column("h.imgurl")
	private String imgurl;
	@Column("h.type")
	private int type;
	@Column("h.top")
	private int top; // 置顶
	@Column("h.orderHome")
	private int orderHome;// 排序
	@Column("h.home_cityId")
	private int home_cityId;
	@Column("h.content_type")
	private String contentType;
	@Column("h.ref_id")
	private long refId;

	@Column("s.id")
	private long activityId;
	@Column("s.TITLE")
	private String activityName;
	@Column("s.CREATE_TIME")
	private long activityTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getTop() {
		return top;
	}

	public void setTop(int top) {
		this.top = top;
	}

	public int getOrderHome() {
		return orderHome;
	}

	public void setOrderHome(int orderHome) {
		this.orderHome = orderHome;
	}

	public int getHome_cityId() {
		return home_cityId;
	}

	public void setHome_cityId(int home_cityId) {
		this.home_cityId = home_cityId;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public long getRefId() {
		return refId;
	}

	public void setRefId(long refId) {
		this.refId = refId;
	}

	public long getActivityId() {
		return activityId;
	}

	public void setActivityId(long activityId) {
		this.activityId = activityId;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public long getActivityTime() {
		return activityTime;
	}

	public void setActivityTime(long activityTime) {
		this.activityTime = activityTime;
	}
}
