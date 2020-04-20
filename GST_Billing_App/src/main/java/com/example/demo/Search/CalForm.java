package com.example.demo.Search;

import javax.persistence.Column;

public class CalForm {
	private String product_code;
	private String product_name;
	private String product_price;
	private String product_GST;
	private String Quantity;
	private Long id;
	private String TotalPrice;
	private String Gross;
	public CalForm(String product_code, String product_name, String product_price, String product_GST, String quantity,
			Long id,String TotalPrice,String Gross) {
		super();
		this.product_code = product_code;
		this.product_name = product_name;
		this.product_price = product_price;
		this.product_GST = product_GST;
		Quantity = quantity;
		this.TotalPrice=TotalPrice;
		this.Gross=Gross;
		this.id = id;
	}
	public String getGross() {
		return Gross;
	}
	public void setGross(String gross) {
		Gross = gross;
	}
	public String getTotalPrice() {
		return TotalPrice;
	}
	public void setTotalPrice(String totalPrice) {
		TotalPrice = totalPrice;
	}
	public String getProduct_code() {
		return product_code;
	}
	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getProduct_price() {
		return product_price;
	}
	public void setProduct_price(String product_price) {
		this.product_price = product_price;
	}
	public String getProduct_GST() {
		return product_GST;
	}
	public void setProduct_GST(String product_GST) {
		this.product_GST = product_GST;
	}
	public String getQuantity() {
		return Quantity;
	}
	public void setQuantity(String quantity) {
		Quantity = quantity;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

}
