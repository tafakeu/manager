package com.market.myapp.metier;

import com.market.myapp.entities.Categorie;
import com.market.myapp.entities.Role;
import com.market.myapp.entities.User;

public interface IAdminCategoriesMetier extends IAdminProduitsMetier  {
	public Long ajouterCategorie(Categorie c);
	public void supprimerCategorie(Long idcat);
	public void modifierCategorie(Categorie c);
	public void ajouterUser(User u);
	public void attribuerRole(Role r, Long user_id);
	


}
