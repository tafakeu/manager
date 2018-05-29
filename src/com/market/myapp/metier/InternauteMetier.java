package com.market.myapp.metier;

import java.util.List;

import com.market.myapp.entities.Categorie;
import com.market.myapp.entities.Client;
import com.market.myapp.entities.Commande;
import com.market.myapp.entities.Panier;
import com.market.myapp.entities.Produit;

public interface InternauteMetier {
	public List<Categorie> listCategories();
	public Categorie getCategorie(Long idcat);
	public List<Produit> listproduits();
	public List<Produit> produitsParMotCle(String mc);
	public List<Produit> produitParCategorie(Long idcat);
	public List<Produit> produitsSelectionnes();
	public Produit getProduit(Long idp);
	public Commande enregistrerCommande(Panier p, Client c);



}
