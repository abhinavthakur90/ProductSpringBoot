package com.wellsfargo.simplewebapp.service;

import com.wellsfargo.simplewebapp.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

@Slf4j
@Service
public class ProductService {
    List<Product> products = new ArrayList<>(Arrays.asList(
            new Product(101, "Iphone", 50_000.00f),
            new Product(102, "Galaxy S12", 60_000.00f),
            new Product(103, "Pixel 10", 50_000.00f),
            new Product(104, "Xiomi M12", 20_000.00f),
            new Product(105, "One Plus Nord", 35_000.00f)));

    public Stream<Product> getProducts(){
        return products.stream().sorted((p1,p2)->p1.getProductId().compareTo(p2.getProductId()));
    }
    public Object getProductById(Integer productId) {
        for(Product product:products){
            if(product.getProductId()==productId){
                return product;
            }
        }
        return new IllegalArgumentException();
    }
    public String addProduct(Product product)
    {
        products.add(product);
        return "Product added successfully to database!!!";
    }
    public String updateProduct(Integer productId, Product prod){
        Iterator<Product> iterator = products.iterator();
        boolean flag = false;
        while(iterator.hasNext()) {
            Product currentProduct = iterator.next();
            if (currentProduct.getProductId().equals(prod.getProductId())) {
                currentProduct.setProductId(prod.getProductId());
                currentProduct.setProductName(prod.getProductName());
                currentProduct.setPrice(prod.getPrice());
                flag=true;
                break;
            }
            else {
                flag=false;
            }
        }
        if(flag)
        {
            log.info("Product Found in DataBase.... Updating the product Information");
            return ("Product updated Successfully");
        }
        else{
            return("Product not found in database");
        }
    }
    public String deleteProduct(Integer productId){
          Iterator<Product> iterator = products.iterator();
          boolean flag=false;
          while (iterator.hasNext()) {
            Product currentProduct = iterator.next();
            if (productId.equals(currentProduct.getProductId())) {
                products.remove(currentProduct);
                flag=true;
            }
            else{
                flag=false;
            }
        }
        if(flag) {
            return "Record removed successfully from Database";
        }
        else {
            return "record not found in Database";
        }
    }
}