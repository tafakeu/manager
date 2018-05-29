package com.market.myapp.metier;

import com.market.myapp.entities.Produit;


public interface IAdminProduitsMetier extends InternauteMetier {
	
	public Long ajouterProduit(Produit p, Long idcat);
	public void supprimerProduit(Long idp);
	public void modifierProduit(Produit p);
	

}
