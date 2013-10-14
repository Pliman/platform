package net.intellizone.coupon.admin.model;

public class Admin {
	private long id;
	private String adminname;
	private String password;
	private String nickname;
	private int privilege;
	public void setId(long id) {
		this.id = id;
	}
	public long getId() {
		return id;
	}
	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}
	public String getAdminname() {
		return adminname;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword() {
		return password;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getNickname() {
		return nickname;
	}
	public void setPrivilege(int privilege) {
		this.privilege = privilege;
	}
	public int getPrivilege() {
		return privilege;
	}

}
