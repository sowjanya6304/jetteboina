package com.satya.mvc.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.satya.mvc.entity.ProductEntity;
import com.satya.mvc.model.Productmodel;
import com.satya.mvc.service.productservice;

@Controller
public class TestController {
	@Autowired
	productservice productservice;
	
	
	//get the form
@GetMapping("/productform")
public String getproductform()
{
	return "add-product";
}

	//to send the data
@PostMapping("/saveproduct")
public String saveproduct(Productmodel productmodel)
{
	productservice.saveProductDetails(productmodel);
	System.out.println(productmodel);
	return "prodone";
}

@GetMapping("/getAllproducts")
public String Allproducts(Model model)
{	
	List<ProductEntity> products=productservice.Allproducts();
	model.addAttribute("products",products);
	return "product-list";	
}

 @GetMapping("/getsearchform")
 public String getsearchform() {
	return "search-product";
 }

@PostMapping("/searchbyid")
public String searchById(@RequestParam long id,Model model) 
{
	ProductEntity product=productservice.searchById(id);
	model.addAttribute("product",product);
	return "search-product";	
}
		//delete by id
@GetMapping("/delete/{id}")
public String deleteproductById(@PathVariable ("id")long Id)
{
	productservice.deleteproductById(Id);
	return "redirect:/getAllproducts";
}
@GetMapping("/edit/{id}")
public String editById(@PathVariable long id,Model model) 
{
	Productmodel product=productservice.editById(id);
	model.addAttribute("product",product);
	return "edit-product";
}
@PostMapping("/editproductsave/{id}")
public String updateproduct(@PathVariable long id,Productmodel productmodel) 
{
	productservice.updateproduct(id,productmodel);
	return "redirect:/getAllproducts";
}

}

