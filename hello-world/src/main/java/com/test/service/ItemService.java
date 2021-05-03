package com.test.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.test.repository.ItemRepository;

@Service
//@RequiredArgsConstructor // alternativa psani konstruktoru (anotace je z Lomboku)
public class ItemService {

    private final ItemRepository itemRepository;

    // constructor injection: TOTO JE BEST PRACTICE!!! (dalsi: field, setter injection)
    public ItemService(/*@Qualifier("jdbcItemRepository") */ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public String getHello() {
        return "Hello world " + itemRepository.count();
    }

}
