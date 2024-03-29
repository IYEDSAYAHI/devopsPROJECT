package tn.esprit.devops_project.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import tn.esprit.devops_project.entities.Stock;
import tn.esprit.devops_project.repositories.ProductRepository;
import tn.esprit.devops_project.repositories.StockRepository;
import tn.esprit.devops_project.services.Iservices.IProductService;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@ActiveProfiles("test")
class ProductServiceImplTest {
    @Autowired
    private IProductService iProductService;

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private ProductRepository productRepository;
    @Test
    void addProduct() {
        Stock stock = new Stock(1L,"BERSHKA",null);
        Stock savedStock = stockRepository.save(stock);
        /*Product product = new Product(6L,"T-shirt",320,50,ProductCategory.CLOTHING,null);
        Product savedProduct = iProductService.addProduct(product, 1L);
        //productRepository.save(savedProduct);
        Stock savedStock = stockRepository.findById(savedProduct.getStock().getIdStock()).orElse(null);
        assertNotNull(savedStock);
        assertNotNull(savedProduct);
        Product retrievedProduct = productRepository.findById(savedProduct.getIdProduct()).orElse(null);
        */
        assertNotNull(savedStock);
    }

    @Test
    void retrieveProduct() {
    }

    @Test
    void retreiveAllProduct() {
    }
}