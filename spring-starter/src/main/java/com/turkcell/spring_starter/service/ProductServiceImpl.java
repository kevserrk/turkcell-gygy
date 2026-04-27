package com.turkcell.spring_starter.service;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.turkcell.spring_starter.dto.CreateProductRequest;
import com.turkcell.spring_starter.dto.CreatedProductResponse;
import com.turkcell.spring_starter.dto.ListProductResponse;
import com.turkcell.spring_starter.dto.UpdateProductRequest;
import com.turkcell.spring_starter.entity.Category;
import com.turkcell.spring_starter.entity.Product;
import com.turkcell.spring_starter.entity.Tag;
import com.turkcell.spring_starter.repository.CategoryRepository;
import com.turkcell.spring_starter.repository.ProductRepository;
import com.turkcell.spring_starter.repository.TagRepository;

@Service
public class ProductServiceImpl {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final TagRepository tagRepository;

    public ProductServiceImpl(ProductRepository productRepository,
                              CategoryRepository categoryRepository,
                              TagRepository tagRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.tagRepository = tagRepository;
    }

    public CreatedProductResponse create(CreateProductRequest request) {
        Category category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Kategori bulunamadı"));

        List<Tag> tags = tagRepository.findAllById(request.getTagIds());

        Product product = new Product();
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setCategory(category);
        product.setTags(new HashSet<>(tags));

        product = productRepository.save(product);

        CreatedProductResponse response = new CreatedProductResponse();
        response.setId(product.getId());
        response.setName(product.getName());
        response.setDescription(product.getDescription());

        return response;
    }

    public List<ListProductResponse> getAll() {
        List<Product> products = productRepository.findAll();
        List<ListProductResponse> responseList = new ArrayList<>();

        for (Product product : products) {
            ListProductResponse response = new ListProductResponse();
            response.setId(product.getId());
            response.setName(product.getName());
            response.setDescription(product.getDescription());
            response.setCategoryName(product.getCategory().getName());

            responseList.add(response);
        }

        return responseList;
    }

    public ListProductResponse getById(UUID id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ürün bulunamadı"));

        ListProductResponse response = new ListProductResponse();
        response.setId(product.getId());
        response.setName(product.getName());
        response.setDescription(product.getDescription());
        response.setCategoryName(product.getCategory().getName());

        return response;
    }

    public CreatedProductResponse update(UpdateProductRequest request) {
        Product product = productRepository.findById(request.getId())
                .orElseThrow(() -> new RuntimeException("Ürün bulunamadı"));

        Category category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Kategori bulunamadı"));

        List<Tag> tags = tagRepository.findAllById(request.getTagIds());

        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setCategory(category);
        product.setTags(new HashSet<>(tags));

        product = productRepository.save(product);

        CreatedProductResponse response = new CreatedProductResponse();
        response.setId(product.getId());
        response.setName(product.getName());
        response.setDescription(product.getDescription());

        return response;
    }

    public void delete(UUID id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ürün bulunamadı"));

        productRepository.delete(product);
    }
}