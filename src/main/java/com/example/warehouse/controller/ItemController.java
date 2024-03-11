package com.example.warehouse.controller;

import com.example.warehouse.model.Brand;
import com.example.warehouse.model.Item;
import com.example.warehouse.repository.ItemRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ItemController {

    private final ItemRepository repository;

    public ItemController(ItemRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/addItem")
    public String addItem(Model model) {
        model.addAttribute("brands", Brand.values());
        model.addAttribute("item", new Item());
        return "addItem";
    }

    @PostMapping("/addItem")
    public String addItem(Item item) {
        repository.save(item);
        return "redirect:/items";
    }

    @GetMapping("/items")
    public String listItems(Model model, @RequestParam(defaultValue = "0") int page) {
        Page<Item> items = repository.findAll(PageRequest.of(page, 5));
        model.addAttribute("items", items);
        return "items";
    }

    @GetMapping("/itemsByBrandAndYear")
    public String listItemsByBrandAndYear(@RequestParam Brand brand, @RequestParam int year, Model model) {
        Page<Item> items = repository.findByBrandAndYearOfCreation(brand, year, PageRequest.of(0, 5));
        model.addAttribute("items", items);
        return "items";
    }
}
