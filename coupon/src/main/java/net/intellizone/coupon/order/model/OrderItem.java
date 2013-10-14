package net.intellizone.coupon.order.model;

import java.util.List;

import net.intellizone.coupon.city.model.City;
import net.intellizone.coupon.coupon.model.Goods;
import net.intellizone.coupon.coupon.model.GoodsImages;
import net.intellizone.coupon.shop.model.Shop;

import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Many;
import org.nutz.dao.entity.annotation.One;
import org.nutz.dao.entity.annotation.Table;

@Table("iz_orderitem")
public class OrderItem {
	@Id
	private int id;
	
	private long order_id;
	
	private long goods_id;
	
	@One(target=Goods.class,field = "goods_id")
	private Goods goods;
	
	private int goods_number;//订单商品数量
	
	
	
	private String name;
	private String description;
	
	private String use_intro;
	private String ercode;
	private String yq_img;    //优惠卷打印图
	private String audit_reason; //不通过审核理由

	private int cat_type;
	private int belong_bc;
	private int belong_cat;
	private double price;
	private int number;



	private long create_time;
	private long modify_time;
	
	private byte isvalid;
	private byte sysflag;

	private double x;
	private double y;

	private long begin_time;
	private long end_time;
	private String use_addr;

	private int belong_shop;
	private String default_pic;

	private byte is_recommend;
	
	
	private int belong_city;
	
	private int coupon_type;//1为折扣券 2为代金券
    private int use_obj;//1为翼支付用户 2为爱优惠用户
    private String use_branchshop;


	//private int haserwei;//是否有二维码
	
	private byte is_hot;
	
	private double discount;
	private int code;
	

	
	private long erwei_id;

	private byte isverified;
	
	private long invalid_time;

	@Many(target = GoodsImages.class, field = "goods_id")
	private List<GoodsImages> goodsImages;
	
	@One(target = Order.class, field = "order_id")
	private Order belongOrder;
	
	@One(target = Shop.class, field = "belong_shop")
	private Shop belongShopObj;
	
	@One(target = City.class, field = "belong_city")
	private City belongCityObj;
	
	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public byte getIsvalid() {
		return isvalid;
	}

	public void setIsvalid(byte isvalid) {
		this.isvalid = isvalid;
	}

	public byte getSysflag() {
		return sysflag;
	}

	public void setSysflag(byte sysflag) {
		this.sysflag = sysflag;
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

	public long getBegin_time() {
		return begin_time;
	}

	public void setBegin_time(long begin_time) {
		this.begin_time = begin_time;
	}

	public long getEnd_time() {
		return end_time;
	}

	public void setEnd_time(long end_time) {
		this.end_time = end_time;
	}

	public String getUse_addr() {
		return use_addr;
	}

	public void setUse_addr(String use_addr) {
		this.use_addr = use_addr;
	}

	public int getBelong_shop() {
		return belong_shop;
	}

	public void setBelong_shop(int belong_shop) {
		this.belong_shop = belong_shop;
	}

	public String getDefault_pic() {
		return default_pic;
	}

	public void setDefault_pic(String default_pic) {
		this.default_pic = default_pic;
	}

	public byte getIs_recommend() {
		return is_recommend;
	}

	public void setIs_recommend(byte is_recommend) {
		this.is_recommend = is_recommend;
	}

	public byte getIs_hot() {
		return is_hot;
	}

	public void setIs_hot(byte is_hot) {
		this.is_hot = is_hot;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public String getUse_intro() {
		return use_intro;
	}

	public void setUse_intro(String use_intro) {
		this.use_intro = use_intro;
	}

	public String getErcode() {
		return ercode;
	}

	public void setErcode(String ercode) {
		this.ercode = ercode;
	}

	public int getCat_type() {
		return cat_type;
	}

	public void setCat_type(int cat_type) {
		this.cat_type = cat_type;
	}

	public int getBelong_bc() {
		return belong_bc;
	}

	public void setBelong_bc(int belong_bc) {
		this.belong_bc = belong_bc;
	}

	public int getBelong_cat() {
		return belong_cat;
	}

	public void setBelong_cat(int belong_cat) {
		this.belong_cat = belong_cat;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public long getCreate_time() {
		return create_time;
	}

	public void setCreate_time(long create_time) {
		this.create_time = create_time;
	}

	public long getModify_time() {
		return modify_time;
	}

	public void setModify_time(long modify_time) {
		this.modify_time = modify_time;
	}



	public long getErwei_id() {
		return erwei_id;
	}

	public void setErwei_id(long erwei_id) {
		this.erwei_id = erwei_id;
	}

	public byte getIsverified() {
		return isverified;
	}


	public void setIsverified(byte isverified) {
		this.isverified = isverified;
	}

	public List<GoodsImages> getGoodsImages() {
		return goodsImages;
	}

	public void setGoodsImages(List<GoodsImages> goodsImages) {
		this.goodsImages = goodsImages;
	}


	public String getYq_img() {
		return yq_img;
	}

	public void setYq_img(String yqImg) {
		yq_img = yqImg;
	}



	/**public void setHaserwei(int haserwei) {
		if(null==ercode||"".equals(ercode)){
			this.haserwei =0;
		}else{
			this.haserwei =1;
		}
	}

	public int getHaserwei() {
		return haserwei;
	}**/


	public long getInvalid_time() {
		return invalid_time;
	}

	public void setInvalid_time(long invalid_time) {
		this.invalid_time = invalid_time;
	}

	public void setBelongShopObj(Shop belongShopObj) {
		this.belongShopObj = belongShopObj;
	}

	public Shop getBelongShopObj() {
		return belongShopObj;
	}

	public String getAudit_reason() {
		return audit_reason;
	}

	public void setAudit_reason(String auditReason) {
		audit_reason = auditReason;
	}

	public void setCoupon_type(int coupon_type) {
		this.coupon_type = coupon_type;
	}

	public int getCoupon_type() {
		return coupon_type;
	}

	public void setUse_obj(int use_obj) {
		this.use_obj = use_obj;
	}

	public int getUse_obj() {
		return use_obj;
	}

	public void setUse_branchshop(String use_branchshop) {
		this.use_branchshop = use_branchshop;
	}

	public String getUse_branchshop() {
		return use_branchshop;
	}



	public void setBelong_city(int belong_city) {
		this.belong_city = belong_city;
	}

	public int getBelong_city() {
		return belong_city;
	}

	public void setBelongCityObj(City belongCityObj) {
		this.belongCityObj = belongCityObj;
	}

	public City getBelongCityObj() {
		return belongCityObj;
	}

	public void setOrder_id(long order_id) {
		this.order_id = order_id;
	}

	public long getOrder_id() {
		return order_id;
	}

	public void setGoods_number(int goods_number) {
		this.goods_number = goods_number;
	}

	public int getGoods_number() {
		return goods_number;
	}

	public Order getBelongOrder() {
		return belongOrder;
	}

	public void setBelongOrder(Order belongOrder) {
		this.belongOrder = belongOrder;
	}

	public long getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(long goods_id) {
		this.goods_id = goods_id;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}



}
