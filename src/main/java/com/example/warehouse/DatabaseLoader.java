package com.example.warehouse;



import com.example.warehouse.model.Item;
import com.example.warehouse.repository.ItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DatabaseLoader implements CommandLineRunner {

    private final ItemRepository repository;

    public DatabaseLoader(ItemRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... strings) throws Exception {
        repository.saveAll(Arrays.asList(
                new Item(),
                new Item(),
                new Item()
        ));
    }
}
