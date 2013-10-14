package net.intellizone.coupon.shop.model;

import java.util.List;

import net.intellizone.coupon.city.model.City;
import net.intellizone.coupon.coupon.model.Goods;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Many;
import org.nutz.dao.entity.annotation.ManyMany;
import org.nutz.dao.entity.annotation.One;
import org.nutz.dao.entity.annotation.Table;

@Table("iz_shop")
public class Shop {
	// 主键id
	@Id(auto = true)
	private long id;
	@Column("name")
	private String name;
	@Column("description")
	private String description;
	@Column("belong_bc")
	private int belong_bc;
	@Column("belong_shopcat")
	private int belong_shopcat;
	@Column("isvalid")
	private int isvalid;
	@Column("isremmend")
	private int isremmend;
	@Column("sysflag")
	private int sysflag;
	@Column("address")
	private String address;
	@Column("default_pic")
	private String default_pic;

	@Column("shop_logo")
	private String shop_logo;

	@Column("p_id")
	private int p_id;

	@Column("is_hot")
	private int is_hot;



	@Column("telephone")
	private String telephone;
	@Column("isverified")
	private byte isverified;
	@Column("create_time")
	private long create_time;
	@Column("modify_time")
	private long modify_time;
	@Column("audit_reason")
	private String audit_reason;// 审核不通过理由
	@ManyMany(target = ShopCategroy.class, relation = "iz_shop_shop_category", from = "SHOP_ID", to = "CATEGORY_ID")
	private List<ShopCategroy> shopCategroysList;

	@Many(target = ShopPic.class, field = "shop_id")
	private List<ShopPic> shopPicList;

	@One(target = Shop.class, field = "p_id")
	private Shop pshop;// 所属总店

	@Many(target = Shop.class, field = "p_id")
	// 所属分店
	private List<Shop> branchShopList;

	
	//商户优惠劵
	@Many(target = Goods.class, field = "belong_shop")
	private List<Goods> couponList;

	//商户详细介绍
	@Column("shop_detail")
	private String shopDetail;
	
	/** 新增字段 */
	@Column("SHOP_TYPE")
	private int shop_type; // 商户类型 （翼支付商户、积分商户、优惠券商户）
	@Column("legal_person")
	private String legal_person;// 法人代表
	@Column("corporation")
	private String corporation; // 公司名称
	@Column("contact")
	private String contact;// 商户联系人
	@Column("shopProperties")
	private int shopProperties;// 商户性质（线上/线下）
	@Column("service")
	private String service; // 提供服务（刷卡/代泊车等）
	
	@Column("belong_city")
	private long belongCity; // 所属城市
	@One(target = City.class, field = "belongCity")
	private City city; // 所属城市
	
	@Column("promote_info")
	private String promoteInfo; // 优惠信息
	
	//经纬度
	@Column("X")
	private double x;   
	@Column("Y")
	private double y;

	
	
	
	
	public String getShopDetail() {
		return shopDetail;
	}

	public void setShopDetail(String shopDetail) {
		this.shopDetail = shopDetail;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public long getBelongCity() {
		return belongCity;
	}

	public void setBelongCity(long belongCity) {
		this.belongCity = belongCity;
	}

	public String getPromoteInfo() {
		return promoteInfo;
	}

	public void setPromoteInfo(String promoteInfo) {
		this.promoteInfo = promoteInfo;
	}

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getBelong_bc() {
		return belong_bc;
	}

	public void setBelong_bc(int belongBc) {
		belong_bc = belongBc;
	}

	public int getBelong_shopcat() {
		return belong_shopcat;
	}

	public void setBelong_shopcat(int belongShopcat) {
		belong_shopcat = belongShopcat;
	}

	public int getIsvalid() {
		return isvalid;
	}

	public void setIsvalid(int isvalid) {
		this.isvalid = isvalid;
	}

	public int getIsremmend() {
		return isremmend;
	}

	public void setIsremmend(int isremmend) {
		this.isremmend = isremmend;
	}

	public int getSysflag() {
		return sysflag;
	}

	public void setSysflag(int sysflag) {
		this.sysflag = sysflag;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDefault_pic() {
		return default_pic;
	}

	public void setDefault_pic(String defaultPic) {
		default_pic = defaultPic;
	}

	public void setCouponList(List<Goods> couponList) {
		this.couponList = couponList;
	}

	public List<Goods> getCouponList() {
		return couponList;
	}

	public void setShopPicList(List<ShopPic> shopPicList) {
		this.shopPicList = shopPicList;
	}

	public List<ShopPic> getShopPicList() {
		return shopPicList;
	}

	public void setIs_hot(int is_hot) {
		this.is_hot = is_hot;
	}

	public int getIs_hot() {
		return is_hot;
	}

	public void setCreate_time(long create_time) {
		this.create_time = create_time;
	}

	public long getCreate_time() {
		return create_time;
	}

	public void setModify_time(long modify_time) {
		this.modify_time = modify_time;
	}

	public long getModify_time() {
		return modify_time;
	}

	public void setIsverified(byte isverified) {
		this.isverified = isverified;
	}

	public byte getIsverified() {
		return isverified;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setShopCategroysList(List<ShopCategroy> shopCategroysList) {
		this.shopCategroysList = shopCategroysList;
	}

	public List<ShopCategroy> getShopCategroysList() {
		return shopCategroysList;
	}

	public void setShop_logo(String shop_logo) {
		this.shop_logo = shop_logo;
	}

	public String getShop_logo() {
		return shop_logo;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}

	public int getP_id() {
		return p_id;
	}

	public void setPshop(Shop pshop) {
		this.pshop = pshop;
	}

	public Shop getPshop() {
		return pshop;
	}

	public void setBranchShopList(List<Shop> branchShopList) {
		this.branchShopList = branchShopList;
	}

	public List<Shop> getBranchShopList() {
		return branchShopList;
	}

	public String getAudit_reason() {
		return audit_reason;
	}

	public void setAudit_reason(String auditReason) {
		audit_reason = auditReason;
	}
	
	public int getShop_type() {
		return shop_type;
	}

	public void setShop_type(int shopType) {
		shop_type = shopType;
	}

	public String getLegal_person() {
		return legal_person;
	}

	public void setLegal_person(String legalPerson) {
		legal_person = legalPerson;
	}

	public String getCorporation() {
		return corporation;
	}

	public void setCorporation(String corporation) {
		this.corporation = corporation;
	}

	public String getShopLinkman() {
		return contact;
	}

	public void setShopLinkman(String shopLinkman) {
		this.contact = shopLinkman;
	}

	public int getShopProperties() {
		return shopProperties;
	}

	public void setShopProperties(int shopProperties) {
		this.shopProperties = shopProperties;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}


	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	

}
