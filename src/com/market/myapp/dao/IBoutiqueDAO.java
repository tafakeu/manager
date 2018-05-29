package com.market.myapp.dao;


import java.util.List;

import com.market.myapp.entities.Categorie;
import com.market.myapp.entities.Client;
import com.market.myapp.entities.Commande;
import com.market.myapp.entities.Panier;
import com.market.myapp.entities.Produit;
import com.market.myapp.entities.Role;
import com.market.myapp.entities.User;

/**
 * @author FOZO
 *
 */ 
public interface IBoutiqueDAO {
	public Long ajouterCategorie(Categorie c);
	public List<Categorie> listCategories();
	public Categorie getCategorie(Long idcat);
	public void supprimerCategorie(Long idcat);
	public void modifierCategorie(Categorie c);
	
	public Long ajouterProduit(Produit p, Long idcat);
	public List<Produit> listproduits();
	public List<Produit> produitsParMotCle(String mc);
	public List<Produit> produitParCategorie(Long idcat);
	public List<Produit> produitsSelectionnes();
	public Produit getProduit(Long idp);
	public void supprimerProduit(Long idp);
	public void modifierProduit(Produit p);
	
	public void ajouterUser(User u);
	public void attribuerRole(Role r, Long user_id);
	public Commande enregistrerCommande(Panier p, Client c);

}
