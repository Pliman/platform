package net.intellizone.coupon.admin.model;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;


@Table("iz_homepage_push")
public class HomePage {
	@Id
	private int id;
	@Column("title")
	private String title;
	@Column("description")
	private String description;
	@Column("link")
	private String link;
	@Column("imgurl")
	private String imgurl;
	@Column("type")
	private int type;
	@Column("sysflag")
	private byte sysflag;
	@Column("remarks")
	private String remarks;
	@Column("top")
	private int top;		//置顶
	@Column("orderHome")
	private int orderHome;//排序
	@Column("coupon_title")
	private String couponTitle; //优惠劵主题
	@Column("coupon_price")
	private String couponPrice;//优惠劵特价
	@Column("home_cityId")
	private int home_cityId;
	@Column("content_type")
	private String contentType;
	@Column("ref_id")
	private long refId;
	
	public int getHome_cityId() {
		return home_cityId;
	}
	public void setHome_cityId(int homeCityId) {
		home_cityId = homeCityId;
	}
	public String getCouponTitle() {
		return couponTitle;
	}
	public void setCouponTitle(String couponTitle) {
		this.couponTitle = couponTitle;
	}
	public String getCouponPrice() {
		return couponPrice;
	}
	public void setCouponPrice(String couponPrice) {
		this.couponPrice = couponPrice;
	}
	public int getOrderHome() {
		return orderHome;
	}
	public void setOrderHome(int orderHome) {
		this.orderHome = orderHome;
	}
	public int getTop() {
		return top;
	}
	public void setTop(int top) {
		this.top = top;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitle() {
		return title;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDescription() {
		return description;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getLink() {
		return link;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	public String getImgurl() {
		return imgurl;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getType() {
		return type;
	}
	public void setSysflag(byte sysflag) {
		this.sysflag = sysflag;
	}
	public byte getSysflag() {
		return sysflag;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getRemarks() {
		return remarks;
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

}
