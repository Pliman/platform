/*
 * SysParam.java 2012-2-15
 * 智域工作室
 */
package net.intellizone.sysparam.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.intellizone.sysparam.model.SystemParam;

/**
 * 系统参数服务类
 * 
 * @author Pliman
 * @version 1.0
 * @since sys_param 1.0
 */
public enum SysParam {
	INSTANCE;

	// 系统参数服务
	SystemParamService systemParamService = new SystemParamService();

	private Map<String, SystemParam> sysParamMap = new HashMap<String, SystemParam>();

	SysParam() {
		refreshSysParam();
	}

	/**
	 * 刷新系统参数
	 */
	public void refreshSysParam() {
		sysParamMap.clear();

		List<SystemParam> systemParamList = systemParamService.getSysParam();

		for (SystemParam systemParam : systemParamList) {
			sysParamMap.put(systemParam.getCode(), systemParam);
		}
	}

	/**
	 * 根据编码获取系统参数
	 * 
	 * @param code
	 *            编码
	 * @return 系统参数
	 */
	public SystemParam getSysParamByCode(String code) {
		return sysParamMap.get(code);
	}

	/**
	 * 根据编码获取系统参数的值
	 * 
	 * @param code
	 *            编码
	 * @return 系统参数的值
	 */
	public String getSysParamValueByCode(String code) {
		SystemParam systemParam = sysParamMap.get(code);

		if (systemParam != null) {
			return systemParam.getValue();
		}

		return "";
	}
}
