package com.example.digitalstore.services;

import com.example.digitalstore.DTO.ProductDTO;

import java.util.List;

public interface ProductService {

    //create product

    ProductDTO createUser(ProductDTO productDTO);

    //update product

    ProductDTO updateProduct(ProductDTO productDTO,String product_id);

    //getproductbyID
    ProductDTO getProduct(String product_id);

    //getallproduct
    List<ProductDTO> getAllproduct();

    //deleteproduct
    void deleteProduct(String product_id);



}
