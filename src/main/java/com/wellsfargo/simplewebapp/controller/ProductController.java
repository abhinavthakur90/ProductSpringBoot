package com.wellsfargo.simplewebapp.controller;

import com.wellsfargo.simplewebapp.model.Product;
import com.wellsfargo.simplewebapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
public class ProductController {
    @Autowired
    ProductService pser;

    @RequestMapping(value="/products", method=RequestMethod.GET)
    @ResponseBody
    public Stream<Product> getProducts(){
    return pser.getProducts();
    }

    @RequestMapping(value="/products/{productId}",method = RequestMethod.GET)
    @ResponseBody
    public Object getProductById(@PathVariable("productId") Integer productId){
        return pser.getProductById(productId);
    }

    @RequestMapping(value="/addProduct",method=RequestMethod.POST)
    @ResponseBody
    public String addProducts(@RequestBody Product prod)
    {
        return (pser.addProduct(prod));
    }

    @RequestMapping(value="/updateProduct/{productId}",method=RequestMethod.PUT)
    public String updateProduct(@PathVariable ("productId") Integer productId ,@RequestBody Product prod){
        return pser.updateProduct(productId, prod);
    }
    @RequestMapping(value="/deleteProduct/{productId}",method=RequestMethod.DELETE)
    public String deleteProduct(@PathVariable("productId") Integer productId){
        return pser.deleteProduct(productId);
    }

}
