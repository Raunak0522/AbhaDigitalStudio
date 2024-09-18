package com.example.digitalstore.services.imple;

import com.example.digitalstore.DTO.ProductDTO;
import com.example.digitalstore.entities.Product;
import com.example.digitalstore.repositories.ProductRepository;
import com.example.digitalstore.services.ProductService;
import jakarta.persistence.Entity;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductImple implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Override
    public ProductDTO createUser(ProductDTO productDTO) {

        String productID=UUID.randomUUID().toString();
        productDTO.setProduct_id(productID);
       Product product = DtOtoEntity(productDTO);
       Product saveUser=productRepository.save(product);
        ProductDTO newDTO=EntitytoDTO(saveUser);
        return newDTO;
    }

    private Product DtOtoEntity(ProductDTO productDTO) {
        Product product=Product.builder().product_id(productDTO.getProduct_id()).product_name(productDTO.getProduct_name())
                .product_price(productDTO.getProduct_price()).product_info(productDTO.getProduct_info()).build();
        return product;

    }

    private ProductDTO EntitytoDTO(Product product) {
        ProductDTO productDTO= ProductDTO.builder().product_id(product.getProduct_id()).product_name(product.getProduct_name())
                .product_price(product.getProduct_price()).product_info(product.getProduct_info()).build();
        return productDTO;
    }



    @Override
    public ProductDTO updateProduct(ProductDTO productDTO, String product_id) {

        Product product=productRepository.findById(product_id).orElseThrow(()-> new RuntimeException("Product not found"));
            product.setProduct_name(productDTO.getProduct_name());
            product.setProduct_info(productDTO.getProduct_info());
            product.setProduct_price(productDTO.getProduct_price());

            //save
            Product upadtedPro=productRepository.save(product);
            ProductDTO updatedDTO=EntitytoDTO(upadtedPro);
            return  updatedDTO;
    }





    @Override
    public ProductDTO getProduct(String product_id) {
        Product product=productRepository.findById(product_id).orElseThrow(()-> new RuntimeException("User not found"));
        return EntitytoDTO(product);
    }

    @Override
    public List<ProductDTO> getAllproduct() {
        List<Product> products=productRepository.findAll();
        List<ProductDTO> productDTOSList=products.stream().map(product -> EntitytoDTO(product)).collect(Collectors.toList());
        return productDTOSList;
    }

    @Override
    public void deleteProduct(String product_id) {

        Product product=productRepository.findById(product_id).orElseThrow(()-> new RuntimeException("user not found"));
        productRepository.delete(product);

    }
}
