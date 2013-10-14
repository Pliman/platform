package net.intellizone.coupon.admin.services;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;


import net.intellizone.coupon.city.model.City;


import net.intellizone.coupon.shop.model.CityShopCategory;
import net.intellizone.coupon.shop.model.ShopCategroy;
import net.intellizone.db.MysqlDataSourceManager;
import net.intellizone.utils.NumberUtils;

import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.dao.impl.NutDao;
import org.springframework.stereotype.Service;
@Service
public class AdminShopCategoryService {
	// nutz dao
	private Dao dao;

	// 初始化数据源
	public AdminShopCategoryService() {
		DataSource ds = MysqlDataSourceManager.INSTANCE.getDataSource();

		dao = new NutDao(ds);
	}
	
	
	 public  List<ShopCategroy> getSortList(List<ShopCategroy> sortList, Long parentId,int level,int cat_type){  

		  ShopCategroy bean = null;  
		  List<ShopCategroy> list = new ArrayList<ShopCategroy>();  
		//  String sql = "Select * from iz_shop_categorie s where s.p_category_id = ?";
		  try{  
		   list = (List<ShopCategroy>)dao.query(ShopCategroy.class, Cnd.where("category_type", "=",cat_type).and("p_category_id","=",parentId), null);//每次查询出上级为的分类
		   if(list != null && list.size() > 0){  
		    for(int i=0;i<list.size();i++){  
		     bean = (ShopCategroy)list.get(i); 
		     sortList.add(bean);  
		     getSortList(sortList,(long)bean.getCategory_id(),level+1,cat_type);   //递归查询
		    }  
		   }else{  
		    level--;
		   }
		  }catch(Exception e){  
		   e.printStackTrace();  
		  } 
		  return sortList;
		 } 
	 
	  /**
	   * 装配树方法
	   * @param pid
	   * @param cat_type
	   */
	    public  List<ShopCategroy> selectShopCategoryList(int pid) {
	        List<ShopCategroy> list = this.getShopListCategoryByPId(pid);
	        List<ShopCategroy> listreturn=selectNode(list);
	        return listreturn;
	    }

	    /**
	     * 递归调用遍历出所有符合条件的节点名称
	     * @param list List
	     */
	    public List<ShopCategroy>  selectNode(List<ShopCategroy> list) {
	    	List<ShopCategroy> catList=new ArrayList<ShopCategroy>();
	        for (ShopCategroy shopCategory : list) {
	            //自己调用自己
	        	List<ShopCategroy> subList =getShopListCategoryByPId(shopCategory.getCategory_id());
	        	shopCategory.setShopCategoryList(subList);
	        	catList.add(shopCategory);
	            selectNode(subList);
	        }
	        return catList;
	    }

	    
	    public static void main(String[] args) {

			//AdminShopCategoryService adminShopCategoryService=new AdminShopCategoryService();
			 //List<ShopCategroy> list=adminShopCategoryService.selectShopCategoryList(0,1);

			//WaterMark.createMarkLogo(localPath);
		}
	 
	/**
	 * 查询所有分类
	 * @param cat_type,1代表商户 2代表优惠券 3代表活动
	 * @return
	 */
	public List<ShopCategroy> getAllShopCategory(int cat_type){
		
		List<ShopCategroy> shopCategoryList = new ArrayList<ShopCategroy>();  
		return this.getSortList(shopCategoryList, (long)0, 0, cat_type);
		//return Daos.queryWithLinks(dao, ShopCategroy.class, Cnd.where("category_type", "=",cat_type), null, null);
		//return dao.query(ShopCategroy.class, Cnd.where("category_type", "=",cat_type), null);	
	}
	
	
	
	


	/**根据ID 查询分类
	 * @param id
	 * @return
	 */
	public ShopCategroy getShopCategroyId(int id) {
		ShopCategroy shopCategroy = dao.fetch(ShopCategroy.class, id);
		return shopCategroy;
	}
	/**
	 * 删除分类
	 * @param l
	 * @return
	 */
	public int deleteShopCategroyById(long l){
		
		return dao.delete(ShopCategroy.class, l);
		
	}
	/**
	 * 根据父ID查询子分类
	 * @param pid
	 * @param cat_type
	 * @return
	 */
	public List<ShopCategroy> getShopListCategoryByPId(int pid){
		return dao.query(ShopCategroy.class, Cnd.where("p_category_id","=",pid), null);
		
	}
	/**
	 * 添加分类
	 * @param shopCategroy
	 * @return
	 */
	public ShopCategroy insertObj(ShopCategroy shopCategroy,String[] idList){
		if(!"".equals(idList) && idList != null){
			CityShopCategory cityShopCategory = new CityShopCategory();
			for(String cityId : idList){
				dao.clear(CityShopCategory.class,Cnd.where("city_id","in",cityId).and("shop_category_id","in",shopCategroy.getCategory_id()));
				cityShopCategory.setCity_id(NumberUtils.convertToInteger(cityId));
				cityShopCategory.setShop_category_id(shopCategroy.getCategory_id());
				dao.insert(cityShopCategory);
			}
		}
		return dao.insert(shopCategroy);
	}
	/**
	 * 更新分类
	 * @param shopCategroy
	 * @return
	 */
	public int updateObj(ShopCategroy shopCategroy,String[] idList){
		if(!"".equals(idList) && idList != null){
			CityShopCategory cityShopCategory = new CityShopCategory();
			for(String cityId : idList){ //添加中间表信息，且不重复
				dao.clear(CityShopCategory.class,Cnd.where("city_id","in",cityId).and("shop_category_id","in",shopCategroy.getCategory_id()));
				cityShopCategory.setCity_id(NumberUtils.convertToInteger(cityId));
				cityShopCategory.setShop_category_id(shopCategroy.getCategory_id());
				dao.insert(cityShopCategory);
			}
			//删除，保证中间表与分类中的belongCity的值一致
			dao.clear(CityShopCategory.class,Cnd.where("city_id","not in",idList).and("shop_category_id","=",shopCategroy.getCategory_id()));
			
		}
		return dao.update(shopCategroy);
	}
	
	/**
	 * 批量删除分类
	 * 
	 * */
	public int deleteAllCategroy(int[] id_type){
		return dao.clear(ShopCategroy.class,Cnd.where("category_id","in",id_type));
	}


	public List<City> getCityByIdList(List<String> idList) {
		if(idList==null)return null;
		return dao.query(City.class, Cnd.where("id","in",idList),null);
	}
}
