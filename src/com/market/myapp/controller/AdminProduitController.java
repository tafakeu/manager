package com.market.myapp.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.market.myapp.entities.Categorie;
import com.market.myapp.entities.Produit;
import com.market.myapp.metier.IAdminProduitsMetier;

@Controller
@RequestMapping(value="/adminprod")
public class AdminProduitController {

//@Autowired permet la gestion des dependences
	@Autowired
	private IAdminProduitsMetier metier;
	
	@RequestMapping(value="/index")
	public String index(Model model){
		model.addAttribute("produit", new Produit());
//chargement de la liste des produits
			model.addAttribute("categories",metier.listCategories());
			model.addAttribute("produits", metier.listproduits());

		return "produits";
	}
	// enregistrer une categorie
			@RequestMapping(value="/saveprod")
			public String saveCat(@Valid Produit p,BindingResult bindingResult,Model model,MultipartFile file)throws IOException{
				if(bindingResult.hasErrors()) {
					model.addAttribute("produits",metier.listCategories());
					model.addAttribute("categories",metier.listCategories());						
					return "produits";
				}
				
				if(!file.isEmpty()) {
					String path=System.getProperty("java.io.tmpdir");
					p.setPhoto(file.getOriginalFilename());
					Long idp=null;
					if(p.getIdproduit()==0){
						idp=metier.ajouterProduit(p, p.getCategorie().getIdcategorie());
					}else{
						metier.modifierProduit(p);
						idp=p.getIdproduit();
					}
					
					file.transferTo(new File(path+"/"+"PROD_"+idp+"_" +file.getOriginalFilename()));
				}else{
					if(p.getIdproduit()==0){
					metier.ajouterProduit(p, p.getCategorie().getIdcategorie());
					}
				}
				
				model.addAttribute("produit", new Produit());
				model.addAttribute("produits", metier.listproduits());
				model.addAttribute("categories",metier.listCategories());
				return "produits";
			}
			@RequestMapping(value="photoprod",produces=MediaType.IMAGE_JPEG_VALUE)
			@ResponseBody
			public byte[] photprod(Long idprod)throws IOException{
				Produit p =metier.getProduit(idprod);
				File f= new File(System.getProperty("java.io.temdir")+"/PROD_"+idprod+"_"+p.getPhoto());
				return IOUtils.toByteArray(new FileInputStream(f));
				
			}
			
			
			//supprimer une categorie
				@RequestMapping(value="/suppprod")
				public String supp (Long idprod, Model model) {
					metier.supprimerProduit(idprod);
					model.addAttribute("produit", new Produit());
					model.addAttribute("produits", metier.listproduits());
					model.addAttribute("categories", metier.listCategories());
					return "produits";
				}
				
			//editer une categorie
				@RequestMapping(value="/editprod")
				public String edit (Long idprod, Model model){
					Produit p=metier.getProduit(idprod);
			//creation d'une session pour garder la photo lors de l'edition
					model.addAttribute("produit",p);
					model.addAttribute("produits", metier.listproduits());
					model.addAttribute("categories", metier.listCategories());
					return "produits";
				}
				
}
