package com.example.eshopweb.mapper;

import com.example.eshopweb.dto.ItemDto;
import com.example.eshopweb.entity.Item;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {

    Item toEntity(ItemDto dto);
    List<Item> toEntity(List<ItemDto> dto);

    ItemDto toDto(Item item);
    List<ItemDto> toDto(List<Item> item);

}
