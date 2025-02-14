package com.winter.app.accounts;

import java.sql.Date;

public class AccountDTO {
	
	private String accountnum;
	private String username;
	private Long productnum;
	private Long accountbalance;
	private Date accoutdate;
	
	public String getAccountnum() {
		return accountnum;
	}
	public void setAccountnum(String accountnum) {
		this.accountnum = accountnum;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Long getProductnum() {
		return productnum;
	}
	public void setProductnum(Long productnum) {
		this.productnum = productnum;
	}
	public Long getAccountbalance() {
		return accountbalance;
	}
	public void setAccountbalance(Long accountbalance) {
		this.accountbalance = accountbalance;
	}
	public Date getAccoutdate() {
		return accoutdate;
	}
	public void setAccoutdate(Date accoutdate) {
		this.accoutdate = accoutdate;
	}
}
