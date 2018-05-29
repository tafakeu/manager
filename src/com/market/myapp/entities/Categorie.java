package com.market.myapp.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

@Entity
public class Categorie implements Serializable {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY )
	private long idcategorie;
	private String nomcategorie;
	private String description;
	@Lob
	private byte [] photo;
	private String nomphoto;
	@OneToMany(mappedBy="categorie")
	private Collection<Produit> produits;

	
	public long getIdcategorie() {
		return idcategorie;
	}
	public void setIdcategorie(long idcategorie) {
		this.idcategorie = idcategorie;
	}
	public String getNomcategorie() {
		return nomcategorie;
	}
	public void setNomcategorie(String nomcategorie) {
		this.nomcategorie = nomcategorie;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	public String getNomphoto() {
		return nomphoto;
	}
	public void setNomphoto(String nomphoto) {
		this.nomphoto = nomphoto;
	}
	public Categorie() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Categorie(String nomcategorie, String description, byte[] photo, String nomphoto) {
		super();
		this.nomcategorie = nomcategorie;
		this.description = description;
		this.photo = photo;
		this.nomphoto = nomphoto;
	}
	
	
}
