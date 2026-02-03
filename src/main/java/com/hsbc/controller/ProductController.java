package com.hsbc.controller;


import com.hsbc.entity.Product;
import com.hsbc.exception.InvalidIdException;
import com.hsbc.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//which all endpoints should be handled '/student' endpoint
@RestController

@RequestMapping("/products")
@CrossOrigin(origins = "*")
//allows endpoints to be acccessed by others cors
public class ProductController {
    //it gets the data from the service,, include every service
    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

//    @GetMapping
    //sent business entity
    //   public List<Product> findAllProducts(){
    //        List<Product> products = productService.findAllProducts();
    //        return products;
    //    }

    @GetMapping
    public ResponseEntity<List<Product>> findAllProducts() {
        List<Product> products = productService.findAllProducts();
        return ResponseEntity.ok(products);
    }

    @PostMapping
    public String insertProduct(@RequestBody Product product){
        productService.saveProduct(product);
        return "Saved sucessfully";
    }
    /*
    findAll
    findById
    save
    update
    delete

     */

//    @GetMapping("/{id}")
//    public ResponseEntity<Doctor> getADoctorById(@PathVariable int id) throws InvalidDoctorIdException{
//        Doctor doctor = doctorService.findDoctorById(id);
//        return new ResponseEntity<Doctor>(doctor, HttpStatus.OK);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable int id) throws InvalidIdException {
            Product product = productService.findProduct(id);
            return ResponseEntity.ok(product);
    }
}
