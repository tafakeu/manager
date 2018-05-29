package com.market.myapp.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Role implements Serializable {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long idrole;
	private String rolename;
	public long getIdrole() {
		return idrole;
	}
	public void setIdrole(long idrole) {
		this.idrole = idrole;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	
	
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Role(String rolename) {
		super();
		this.rolename = rolename;
	}
	

}
