package com.example.demo.MysqlModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class product_info {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(name="product_code")
	private String product_code;
@Column(name="product_name")
	private String product_name;
@Column(name="product_price")
	private String product_price;
@Column(name="product_gst")
	private String product_GST;
protected product_info()
{
	
}
public product_info(String product_code, String product_name, String product_price, String product_GST) {
	//super();
	this.product_code = product_code;
	this.product_name = product_name;
	this.product_price = product_price;
	this.product_GST = product_GST;
}

@Override
public String toString()
{
	return String.format("Customer[code='%d', name='%s', price='%s', gst='%s']",product_code,product_name,product_price,product_GST);
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


}

