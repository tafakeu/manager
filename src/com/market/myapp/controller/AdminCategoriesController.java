package com.market.myapp.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.market.myapp.entities.Categorie;
import com.market.myapp.metier.IAdminCategoriesMetier;

@Controller
@RequestMapping("/admincat")
//la methode implementé est un gestionnaire d'execption et redefinit la methode resolveException
public class AdminCategoriesController implements HandlerExceptionResolver{
	@Autowired
	private IAdminCategoriesMetier metier;
	@RequestMapping(value="/index")
	public String index (Model model) {
		model.addAttribute("categories", new Categorie());
		model.addAttribute("categorie", metier.listCategories());
		return "categories";
	}
// enregistrer une categorie
	@RequestMapping(value="/saveCat")
	public String saveCat(@Valid Categorie c,BindingResult bindingResult,Model model,MultipartFile file)throws IOException{
		if(bindingResult.hasErrors()) {
			model.addAttribute("categories",metier.listCategories());
			return "categories";
		}
		
		if(!file.isEmpty()) {
			BufferedImage bi=ImageIO.read(file.getInputStream());
			c.setPhoto(file.getBytes());
			c.setNomphoto(file.getOriginalFilename());
		}
		
		if(c.getIdcategorie()!=0){
			if(file.isEmpty()){
				Categorie cat=metier.getCategorie(c.getIdcategorie());
				c.setPhoto(cat.getPhoto());
			}
			metier.modifierCategorie(c);
		}else
		metier.ajouterCategorie(c);
		model.addAttribute("categories", new Categorie());
		model.addAttribute("categorie", metier.listCategories());
		return "categories";
	}
	@RequestMapping(value="photoCat",produces=MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] photoCat(Long idCat)throws IOException{
		Categorie c=metier.getCategorie(idCat);
		return IOUtils.toByteArray(new ByteArrayInputStream(c.getPhoto()));
		
	}
	
//supprimer une categorie
	@RequestMapping(value="/suppCat")
	public String supp (Long idCat, Model model) {
		metier.supprimerCategorie(idCat);
		model.addAttribute("categories", new Categorie());
		model.addAttribute("categorie", metier.listCategories());
		return "categories";
	}
	
//editer une categorie
	@RequestMapping(value="/editCat")
	public String edit (Long idCat, Model model){
		Categorie c=metier.getCategorie(idCat);
//creation d'une session pour garder la photo lors de l'edition
		model.addAttribute("editedcat",c);
		model.addAttribute("categories", c);
		model.addAttribute("categorie", metier.listCategories());
		return "categories";
	}
	
//gestion des exceptions
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object arg2,Exception ex) {
		ModelAndView mv= new ModelAndView();
		mv.addObject("categories", new Categorie());
		mv.addObject("categorie", metier.listCategories());
		mv.addObject("exception", ex.getMessage());
		mv.setViewName("categories");
		return mv;
	}
	
}
