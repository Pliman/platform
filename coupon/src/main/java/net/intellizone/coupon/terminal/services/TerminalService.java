/*
 * TerminalService.java 2012-1-10
 * 智域工作室
 */
package net.intellizone.coupon.terminal.services;

import javax.sql.DataSource;

import net.intellizone.coupon.terminal.model.Terminal;
import net.intellizone.db.MysqlDataSourceManager;

import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.dao.impl.NutDao;
import org.springframework.stereotype.Service;

/**
 * 终端服务
 * 
 * @author Pliman
 * @version 1.0 2012-1-10
 * @since coupon 1.0
 */
@Service
public class TerminalService {
	Dao dao;

	TerminalService() {
		DataSource ds = MysqlDataSourceManager.INSTANCE.getDataSource();

		dao = new NutDao(ds);
	}

	/**
	 * 验证终端是否存在 如果存在，则返回0，如果不存在，则返回-3
	 * 
	 * @param terminalId
	 *            终端id
	 * @return 如果存在，则返回0，如果不存在，则返回-3
	 */
	public Terminal getTerminalReturnCode(String terminalId) {
		return dao.fetch(Terminal.class, Cnd.where("terminalId", "=", terminalId));
	}

	/**
	 * 根据终端条码和终端Id获取终端
	 * 
	 * @param code
	 *            条码
	 * @param Id
	 *            id
	 * @return 终端
	 */
	public Terminal getTerminalByCodeAndId(String code, String Id) {
		return dao.fetch(Terminal.class, Cnd.where("terminalId", "=", Id).and("code", "=", code));
	}
}
