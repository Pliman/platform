/*
 * MsgTemplateService.java 2012-2-6
 * 智域工作室
 */
package net.intellizone.coupon.msg.template.services;

import java.util.List;

import javax.sql.DataSource;

import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.dao.impl.NutDao;
import org.nutz.dao.pager.Pager;
import org.springframework.stereotype.Service;

import net.intellizone.core.constants.Constants;
import net.intellizone.coupon.msg.template.model.MsgTemplate;
import net.intellizone.db.MysqlDataSourceManager;

/**
 * 信息模板服务
 * 
 * @author Pliman
 * @version 1.0
 * @since coupon 1.0
 */
@Service
public class MsgTemplateService {
	private Dao dao;

	public MsgTemplateService() {
		DataSource ds = MysqlDataSourceManager.INSTANCE.getDataSource();

		dao = new NutDao(ds);
	}

	/**
	 * 根据模板id，获取模板对象
	 * 
	 * @param id
	 *            模板id
	 * @return 模板对象
	 */
	public MsgTemplate getMsgTemplateById(long id) {
		return dao.fetch(MsgTemplate.class, id);
	}
	
	/**
	 * 根据模板编码，获取模板对象
	 * 
	 * @param templateCode
	 *            模板编码
	 * @return 模板对象
	 */
	public MsgTemplate getMsgTemplateByCode(String templateCode) {
		return dao.fetch(MsgTemplate.class, Cnd.where("templateCode", "=", templateCode));
	}

	/**
	 * 按页获取当页模板
	 * 
	 * @param page
	 *            页码
	 * @return 当页模板
	 */
	public List<MsgTemplate> getMsgTemplates(int page) {
		Pager pager = dao.createPager(page, Constants.DEFAULT_PAGESIZE);

		return dao.query(MsgTemplate.class, null, pager);
	}

	/**
	 * 更新消息模板
	 * 
	 * @param msgTemplate
	 *            消息模板对象
	 * @return 更新结果
	 */
	public int updateMsgTemplate(MsgTemplate msgTemplate) {
		return dao.update(msgTemplate);
	}

	/**
	 * 删除消息模板
	 * 
	 * @param msgTemplate
	 *            消息模板
	 * @return 删除结果
	 */
	public int deleteMsgTemplate(MsgTemplate msgTemplate) {
		return dao.delete(msgTemplate);
	}
	
	public static void main(String[] args){
		MsgTemplateService service = new MsgTemplateService();
		MsgTemplate mt = service.getMsgTemplateById(1);
		System.out.println(mt.getDescription());
	}
}
