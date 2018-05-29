package com.market.myapp.entities;

import java.io.Serializable;

import java.util.Collection;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Client implements Serializable{
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long idclient;
	private String noclient;
	private String adresse;
	private String email;
	private String tel;
	@OneToMany(mappedBy="client")
	private Collection<Commande> commande;
	public long getIdclient() {
		return idclient;
	}
	public void setIdclient(long idclient) {
		this.idclient = idclient;
	}
	public String getNoclient() {
		return noclient;
	}
	public void setNoclient(String noclient) {
		this.noclient = noclient;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Collection<Commande> getCommande() {
		return commande;
	}
	public void setCommande(Collection<Commande> commande) {
		this.commande = commande;
	}
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Client(String noclient, String adresse, String email, String tel) {
		super();
		this.noclient = noclient;
		this.adresse = adresse;
		this.email = email;
		this.tel = tel;
	}
	
}
