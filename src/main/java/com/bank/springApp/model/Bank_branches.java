package com.bank.springApp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bank_branches")
public class Bank_branches  {
private static final long serialVersionUID = 1L;
@Id
@Column(name = "ifsc")
private String ifsc;

public String getIfsc() {
	return ifsc;
}
public void setIfsc(String ifsc) {
	this.ifsc = ifsc;
}
public long getBank_id() {
	return bank_id;
}
public void setBank_id(long bank_id) {
	this.bank_id = bank_id;
}
public String getBranch() {
	return branch;
}
public void setBranch(String branch) {
	this.branch = branch;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getDistrict() {
	return district;
}
public void setDistrict(String district) {
	this.district = district;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
@Column(name="bank_name")
public String getBankName() {
	//String bankName;
	return bankName;
}
public void setBankName(String bank_name) {
	this.bankName = bank_name;
}
public static long getSerialversionuid() {
	return serialVersionUID;
}
@Column
private long bank_id;
@Column
private String branch;
@Column
private String address;
@Column
private String city;
@Column
private String district;
@Column
private String state;
@Column
private String bankName;

}
