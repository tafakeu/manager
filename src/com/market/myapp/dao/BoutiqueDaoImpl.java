package com.market.myapp.dao;

import java.util.Date;
 
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.market.myapp.dao.IBoutiqueDAO;
import com.market.myapp.entities.Categorie;
import com.market.myapp.entities.Client;
import com.market.myapp.entities.Commande;
import com.market.myapp.entities.LigneCommande;
import com.market.myapp.entities.Panier;
import com.market.myapp.entities.Produit;
import com.market.myapp.entities.Role;
import com.market.myapp.entities.User;

public class BoutiqueDaoImpl implements IBoutiqueDAO{
	@PersistenceContext
	private EntityManager em;
	

	@Override
	public Long ajouterCategorie(Categorie c) {
		em.persist(c);
		return c.getIdcategorie();
	}

	@Override
	public List<Categorie> listCategories() {
		Query req=em.createQuery("select c from Categorie c");
		return req.getResultList() ;
	}

	@Override
	public Categorie getCategorie(Long idcat) {
		return em.find(Categorie.class, idcat);
	}

	@Override
	public void supprimerCategorie(Long idcat) {
		Categorie c=em.find(Categorie.class ,idcat);
		em.remove(c);
		
	}

	@Override
	public void modifierCategorie(Categorie c) {
		em.merge(c);
		
	}

	@Override
	public Long ajouterProduit(Produit p, Long idcat) {
		Categorie c= getCategorie(idcat);
		p.setCategorie(c);
		em.persist(p);
		return p.getIdproduit();
	}

	@Override
	public List<Produit> listproduits() {
		Query req=em.createQuery("select p from Produit p");
		return req.getResultList() ;
	}

	@Override
	public List<Produit> produitsParMotCle(String mc) {
		Query req=em.createQuery("select p from Produit p where p.designation like x: or p.description");
		req.setParameter("x","%"+mc+"%");
		return req.getResultList() ;
	}

	@Override
	public List<Produit> produitParCategorie(Long idcat) {
		Query req=em.createQuery("select p from Produit p where p.Categorie.idcategorie=:x");
		req.setParameter("x", idcat);
		return req.getResultList() ;
	}

	@Override
	public List<Produit> produitsSelectionnes() {
		Query req=em.createQuery("select p from Produit p where p.selected=true");
		return req.getResultList() ;
	}

	@Override
	public Produit getProduit(Long idp) {
		return em.find(Produit.class, idp);
	}

	@Override
	public void supprimerProduit(Long idp) {
		Produit p =getProduit(idp);
		em.remove(p);
		
	}

	@Override
	public void modifierProduit(Produit p) {
		em.merge(p);
		
	}

	@Override
	public void ajouterUser(User u) {
		em.persist(u);
		
		
	}

	@Override
	public void attribuerRole(Role r, Long user_id) {
		User u= em.find(User.class, user_id);
		u.getRole().add(r);
		em.persist(r);
	}

	@Override
	public Commande enregistrerCommande(Panier p, Client c) {
		em.persist(c);
		Commande cmd= new Commande();
		cmd.setDatecommande(new Date());
		cmd.setItem(p.getItems());
		for(LigneCommande lc:p.getItems()) {
			em.persist(lc);
		}
		em.persist(cmd);
		return cmd;
	}

}
