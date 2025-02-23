package com.product.resource;

import com.product.entity.Product;
import com.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductResource {

    @Autowired
    ProductService productService;

    //Seller can add a product by using this API
    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        try {
            Product savedProduct = productService.addProduct(product);
            return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // A particular product can be fetched using this API
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") String id) {
        try {
            Product product = productService.getById(id);
            return new ResponseEntity<>(product, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // All products can be fetched using this API
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        try {
            List<Product> products = productService.getProducts();
            return new ResponseEntity<>(products, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


}
