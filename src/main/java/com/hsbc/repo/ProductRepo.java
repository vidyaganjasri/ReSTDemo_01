package com.hsbc.repo;

import com.hsbc.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
//handles the database operations

@Repository
public interface ProductRepo extends JpaRepository<Product,Integer> {
    //abs method it is a custom method, no predefined method hence
    //without any implementation this will work, bc of the field name(
    List<Product> findByName(String name);


    //pattern matching
    //if this is executed it will throw wrror as there is no member varible with title Partial Name
    //hence we need to support a little, where we provide the query which will work on the obj

    //we mention the entiti name(Product) not the table name (product)
    //sine we are suppose to find partially whether name exist we use :name in the sql query
    @Query("SELECT prod FROM com.hsbc.entity.Product prod  WHERE prod.name LIKE %:name%")
    List<Product> findByPartialName(String name);

}