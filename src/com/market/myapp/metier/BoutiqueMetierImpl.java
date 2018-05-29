package com.market.myapp.metier;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.market.myapp.dao.IBoutiqueDAO;
import com.market.myapp.entities.Categorie;
import com.market.myapp.entities.Client;
import com.market.myapp.entities.Commande;
import com.market.myapp.entities.Panier;
import com.market.myapp.entities.Produit;
import com.market.myapp.entities.Role;
import com.market.myapp.entities.User;

@Transactional
public class BoutiqueMetierImpl implements IAdminCategoriesMetier {
		private IBoutiqueDAO dao;
		
	public void setDao(IBoutiqueDAO dao) {
			this.dao = dao;
		}

	@Override
	public Long ajouterProduit(Produit p, Long idcat) {
		// TODO Auto-generated method stub
		return dao.ajouterProduit(p, idcat) ;
	}

	@Override
	public void supprimerProduit(Long idp) {
		dao.supprimerProduit(idp);
		
	}

	@Override
	public void modifierProduit(Produit p) {
		dao.modifierProduit(p);
		
	}

	@Override
	public List<Categorie> listCategories() {
		return dao.listCategories();
	}

	@Override
	public Categorie getCategorie(Long idcat) {
		// TODO Auto-generated method stub
		return dao.getCategorie(idcat);
	}

	@Override
	public List<Produit> listproduits() {
		// TODO Auto-generated method stub
		return dao.listproduits();
	}

	@Override
	public List<Produit> produitsParMotCle(String mc) {
		// TODO Auto-generated method stub
		return dao.produitsParMotCle(mc);
	}

	@Override
	public List<Produit> produitParCategorie(Long idcat) {
		// TODO Auto-generated method stub
		return dao.produitParCategorie(idcat);
	}

	@Override
	public List<Produit> produitsSelectionnes() {
		// TODO Auto-generated method stub
		return dao.produitsSelectionnes();
	}

	@Override
	public Produit getProduit(Long idp) {
		// TODO Auto-generated method stub
		return dao.getProduit(idp);
	}

	@Override
	public Commande enregistrerCommande(Panier p, Client c) {
		// TODO Auto-generated method stub
		return dao.enregistrerCommande(p, c);
	}

	@Override
	public Long ajouterCategorie(Categorie c) {
		// TODO Auto-generated method stub
		return dao.ajouterCategorie(c);
	}

	@Override
	public void supprimerCategorie(Long idcat) {
		dao.supprimerCategorie(idcat);
		
	}

	@Override
	public void modifierCategorie(Categorie c) {
		dao.modifierCategorie(c);
		
	}

	@Override
	public void ajouterUser(User u) {
		dao.ajouterUser(u);
		
	}

	@Override
	public void attribuerRole(Role r, Long user_id) {
		dao.attribuerRole(r, user_id);
	}

}
