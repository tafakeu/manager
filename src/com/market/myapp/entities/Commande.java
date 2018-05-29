package com.market.myapp.entities;

import java.io.Serializable;

import java.util.Collection;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Commande implements Serializable{
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long idcommande;
	private Date datecommande;
	@OneToMany(mappedBy="commande")
	private Collection<LigneCommande> item;
	@ManyToOne
	@JoinColumn(name="idclient")
	private Client client;
	public long getIdcommande() {
		return idcommande;
	}
	public void setIdcommande(long idcommande) {
		this.idcommande = idcommande;
	}
	public Date getDatecommande() {
		return datecommande;
	}
	public void setDatecommande(Date datecommande) {
		this.datecommande = datecommande;
	}
	public Collection<LigneCommande> getItem() {
		return item;
	}
	public void setItem(Collection<LigneCommande> item) {
		this.item = item;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Commande() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
