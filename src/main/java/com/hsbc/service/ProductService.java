package com.hsbc.service;

import com.hsbc.entity.Product;
import com.hsbc.exception.InvalidIdException;
import com.hsbc.repo.ProductRepo;
import jdk.jshell.spi.ExecutionControlProvider;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    ProductRepo productRepo; //whatever interfces we create we declare them as member variable

    //all args constructor
    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }


    //invoke repo methods
    //refactoring, without chainging the logic enhancing
    public Product saveProduct(Product product){
//        System.out.println("Before saving:"+product);
//        Product saved = productRepo.save(product);
//        System.out.println("After saving:"+product);
//        if (product==saved){
//            System.out.println("Same objects");
//        }
//        else{
//            System.out.println("Diff objects");
//        }
//        return saved;
        //arg obj nd returned obj are same
        return productRepo.save(product);
    }

    public Product findProduct(int id) throws InvalidIdException {
        //return productRepo.findById(id); //this fails as optional<product>
        //therefore
        Optional<Product> optProduct = productRepo.findById(id);
        //if a given product doesnot exist throw
        // an exceptoin
        //lambda
        Product product = optProduct.orElseThrow(
                ()->new InvalidIdException("Id is not valid")
        );
        return product;
        //not a good practice to throw java defined exceptions, always bettwer to create business custom exceptions

    }

    public Product updateProduct(Product product) throws InvalidIdException {
        findProduct(product.getId());
        //top most layer only we should write try catch that is in main , here throw
        return productRepo.save(product);

    }


    public Product deleteProduct(int id) throws InvalidIdException {
        Product product = findProduct(id);
        productRepo.deleteById(id);
        System.out.println("Id"+id+" Deleted sucessfully");
        return product;
    }

    public List<Product> findAllProducts(){
        return productRepo.findAll();
    }

    //findbyName
    public List<Product> findProductsByName(String name){
        List<Product> p = productRepo.findByName(name);
        return p;
    }

    //findbyPartialName
    public List<Product> findProductsbyPartialName(String name){
        List<Product> p = productRepo.findByPartialName(name);
        return p;
    }


}
