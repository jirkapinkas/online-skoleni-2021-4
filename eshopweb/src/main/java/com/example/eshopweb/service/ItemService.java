package com.example.eshopweb.service;

import com.example.eshopweb.dto.ItemDto;
import com.example.eshopweb.entity.Item;
import com.example.eshopweb.exception.NotFoundException;
import com.example.eshopweb.mapper.ItemMapper;
import com.example.eshopweb.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ItemMapper itemMapper;

    public List<ItemDto> findAll(String orderBy, String direction) {
        Sort sort = Sort.by(Sort.Direction.fromString(direction.toUpperCase()), orderBy);
        List<Item> items = itemRepository.findAll(sort);
        return itemMapper.toDto(items);
    }

    public /*Optional<ItemDto>*/ ItemDto findById(int id) {
        return itemRepository.findById(id)
                .map(itemMapper::toDto)
                .orElseThrow(() -> new NotFoundException("Item with id: '" + id + "' does not exist!"));
    }

    public void deleteById(int id) {
        itemRepository.deleteById(id);
    }

    public ItemDto save(ItemDto itemDto) {
        Item entity = itemMapper.toEntity(itemDto);
        Item managedEntity = itemRepository.save(entity);
        return itemMapper.toDto(managedEntity);
    }

}
