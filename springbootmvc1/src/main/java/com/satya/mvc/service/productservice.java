package com.satya.mvc.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.satya.mvc.entity.ProductEntity;
import com.satya.mvc.model.Productmodel;
import com.satya.mvc.repository.ProductRepository;

@Service
public class productservice {
@Autowired
ProductRepository productRepository;

public void saveProductDetails (Productmodel productModel) {
	
	double stockvalue;
	stockvalue=productModel.getPrice()*productModel.getQuantity();
	
	double discountprice;
	discountprice=(productModel.getDiscountRate()*productModel.getDiscountRate())/100;
	
	double offerprice;
	offerprice=productModel.getPrice()*productModel.getQuantity();
	
	double taxPrice;
	taxPrice=0.18*offerprice;
	
	double finalprice;
	finalprice=offerprice + taxPrice;
	
	ProductEntity productEntity=new ProductEntity();
	
	productEntity.setName(productModel.getName());
	productEntity.setBrand(productModel.getBrand());
	productEntity.setMadein(productModel.getMadein());
	productEntity.setPrice(productModel.getPrice());
	productEntity.setQuantity(productModel.getQuantity());
	productEntity.setDiscountRate(productModel.getDiscountRate());
	productEntity.setDiscountPrice(discountprice);
	productEntity.setStockValue(stockvalue);
	productEntity.setTaxPrice(taxPrice);
	productEntity.setDiscountPrice(finalprice);
	productEntity.setOfferPrice(offerprice)	;
	
	productRepository.save(productEntity);
}
public List<ProductEntity> Allproducts()
{
	List<ProductEntity> product=productRepository.findAll();
	return product;
}

public ProductEntity searchById(long id)
{
	Optional<ProductEntity>optionalData=productRepository.findById(id);
	if(optionalData.isPresent()) 
	{
		ProductEntity product=optionalData.get();
		return product;
	}
	else 
	{
		return null;
	}
}
public void deleteproductById(long id)
{
	productRepository.deleteById(id);
}
public Productmodel editById(long id) {
	Optional<ProductEntity>optionalData=productRepository.findById(id);
	Productmodel product=new Productmodel();
	if(optionalData.isPresent())
	{
		ProductEntity eproduct=optionalData.get();
		product.setName(eproduct.getName());
		product.setBrand(eproduct.getBrand());
		product.setMadein(eproduct.getMadein());
		product.setPrice(eproduct.getPrice());
		product.setQuantity(eproduct.getQuantity());
		product.setDiscountRate(eproduct.getDiscountRate());
		return  product;	
	}
	else
	{
		return null;
	}
}
public void updateproduct(long id,Productmodel productmodel ) 
{
	Optional<ProductEntity>optionalData=productRepository.findById(id);
	if(optionalData.isPresent());
	{
		ProductEntity entity=optionalData.get();
		entity.setName(productmodel.getName());
		entity.setBrand(productmodel.getBrand());
		entity.setMadein(productmodel.getMadein());
		entity.setPrice(productmodel.getPrice());
		entity.setQuantity(productmodel.getQuantity());
		entity.setDiscountRate(productmodel.getDiscountRate());
		
		double stockvalue;
		stockvalue=productmodel.getPrice()*productmodel.getQuantity();
		
		double discountprice;
		discountprice=productmodel.getDiscountRate()*productmodel.getDiscountRate()/100;
		
		double offerprice;
		offerprice=productmodel.getPrice()*productmodel.getQuantity();
		
		double taxPrice;
		taxPrice=0.18*offerprice;
		
		double finalprice;
		finalprice=offerprice + taxPrice;
		
		entity.setStockValue(stockvalue);
		entity.setTaxPrice(taxPrice);
		entity.setDiscountPrice(discountprice);
		entity.setFinalPrice(finalprice);
		entity.setOfferPrice(offerprice);
		productRepository.save(entity);
		
	}
	
}
}

