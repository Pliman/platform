package net.intellizone.coupon.system.common;
/**
 * 
 * @author： ljt 
 * @since： 2009-11-10 上午09:31:48
 * @modify: 
 * @主要功能：
 * @see 
 * @version 1.0
 */
public final class SysConstants {
	/**系统模块公共状态码*/
	public static final int EXCUTE_OK=0;
	public static final int NAME_EXIST=-1;
	//登录用户
	public static String SESSION_USER="sessionUser";
	//用户权限资源集
	public static  String SESSION_USER_RESOURCE_LIST="sessionUserResourceList";
		
	/**用户状态*/
	public static final int USER_NOT_EXIST=-2;
	public static final int INVALID_PASSWORD=-3;
	public static final int USER_NAME_EXI=-4;
	public static final int INVALID_USER=-5;
	public static final int USER_LOCKED=-6;

	/**功能类型*/
	public static final String FUNCTION_TYPE_FOLDER = "FOLDER";
	public static final String FUNCTION_TYPE_MENU = "MENU";
	public static final String FUNCTION_TYPE_RESOURCE = "RESOURCE";

	
}
