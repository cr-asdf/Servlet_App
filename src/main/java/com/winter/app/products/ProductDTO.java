package com.winter.app.products;

import java.sql.Date;

public class ProductDTO {

	private Long productnum;
	private String productname;
	private Double productrate;
	private Date productdate;
	private Long productdetail;
	
	
	public Long getProductnum() {
		return productnum;
	}
	public void setProductnum(Long productnum) {
		this.productnum = productnum;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public Double getProductrate() {
		return productrate;
	}
	public void setProductrate(Double productrate) {
		this.productrate = productrate;
	}
	public Date getProductdate() {
		return productdate;
	}
	public void setProductdate(Date productdate) {
		this.productdate = productdate;
	}
	public Long getProductdetail() {
		return productdetail;
	}
	public void setProductdetail(Long productdetail) {
		this.productdetail = productdetail;
	}
}
	