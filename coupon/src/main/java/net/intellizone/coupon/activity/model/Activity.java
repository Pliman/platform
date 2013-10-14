package net.intellizone.coupon.activity.model;

import org.nutz.dao.DB;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Prev;
import org.nutz.dao.entity.annotation.SQL;
import org.nutz.dao.entity.annotation.Table;

@Table("iz_activity")
public class Activity {
	@Id
	@Prev(@SQL(db = DB.MYSQL, value = "select MAX(id) from iz_activity"))
	private int id;
	private String title;
	private String content;
	private String proman;
	private long begin_time;
	private long end_time;
	private long create_time;

	private long modify_time;
	private String keyword;
	private String pic_url;
	private byte sysflag;
	private String belong_shops;//活动所属店铺多选
	private byte isverified;
	private String act_address;
	private int belong_bc;
	private int belong_cat;
	private String audit_reason;//审核不通过理由

	private int is_recommend;
	
	private String belong_citys;//活动所属城市，多选
	private String target_group;//活动参与人群，多选,例如1翼支付，2爱优惠，3普通会员
	

	private int is_hot;
	
	private String act_article;
	
	private int freeze; //是否冻结：0-正常状态    1-冻结状态

	private int activty_status;
	
	
	public int getFreeze() {
		return freeze;
	}
	public void setFreeze(int freeze) {
		this.freeze = freeze;
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

	public void setProman(String proman) {
		this.proman = proman;
	}
	public String getProman() {
		return proman;
	}
	public void setCreate_time(long create_time) {
		this.create_time = create_time;
	}
	public long getCreate_time() {
		return create_time;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setSysflag(byte sysflag) {
		this.sysflag = sysflag;
	}
	public byte getSysflag() {
		return sysflag;
	}
	public void setIsverified(byte isverified) {
		this.isverified = isverified;
	}
	public byte getIsverified() {
		return isverified;
	}

	public void setBegin_time(long begin_time) {
		this.begin_time = begin_time;
	}
	public long getBegin_time() {
		return begin_time;
	}
	public void setEnd_time(long end_time) {
		this.end_time = end_time;
	}
	public long getEnd_time() {
		return end_time;
	}
	public void setPic_url(String pic_url) {
		this.pic_url = pic_url;
	}
	public String getPic_url() {
		return pic_url;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getContent() {
		return content;
	}
	public void setAct_address(String act_address) {
		this.act_address = act_address;
	}
	public String getAct_address() {
		return act_address;
	}
	public void setBelong_bc(int belong_bc) {
		this.belong_bc = belong_bc;
	}
	public int getBelong_bc() {
		return belong_bc;
	}
	public void setBelong_cat(int belong_cat) {
		this.belong_cat = belong_cat;
	}
	public int getBelong_cat() {
		return belong_cat;
	}
	public void setModify_time(long modify_time) {
		this.modify_time = modify_time;
	}
	public long getModify_time() {
		return modify_time;
	}

	public void setIs_recommend(int is_recommend) {
		this.is_recommend = is_recommend;
	}
	public int getIs_recommend() {
		return is_recommend;
	}

	public void setIs_hot(int is_hot) {
		this.is_hot = is_hot;
	}
	public int getIs_hot() {
		return is_hot;
	}
	public String getAct_article() {
		return act_article;
	}
	public void setAct_article(String act_article) {
		this.act_article = act_article;
	}
	public String getAudit_reason() {
		return audit_reason;
	}
	public void setAudit_reason(String auditReason) {
		audit_reason = auditReason;
	}
	public void setBelong_shops(String belong_shops) {
		this.belong_shops = belong_shops;
	}
	public String getBelong_shops() {
		return belong_shops;
	}
	public void setBelong_citys(String belong_citys) {
		this.belong_citys = belong_citys;
	}
	public String getBelong_citys() {
		return belong_citys;
	}
	public void setTarget_group(String target_group) {
		this.target_group = target_group;
	}
	public String getTarget_group() {
		return target_group;
	}
	public void setActivty_status(int activty_status) {
		this.activty_status = activty_status;
	}
	public int getActivty_status() {
		return activty_status;
	}


}
