package com.example.warehouse.repository;


import com.example.warehouse.model.Brand;
import com.example.warehouse.model.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ItemRepository extends JpaRepository<Item, Long> {
    Page<Item> findByBrandAndYearOfCreation(Brand brand, int year, Pageable pageable);
}
