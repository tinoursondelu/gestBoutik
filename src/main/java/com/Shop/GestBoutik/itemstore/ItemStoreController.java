package com.Shop.GestBoutik.itemstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/itemstore")
public class ItemStoreController {

    @Autowired ItemStoreService itemStoreService ;

    @GetMapping("/")
    public List<ItemStoreDto> listItemStore() {
        return itemStoreService.parseListModelToDto(itemStoreService.findAll());
    }

    @GetMapping("/{itemStoreId}")
    public ItemStoreDto ItemStoreDetail(@PathVariable("itemStoreId") Long id) {
        return itemStoreService.findOne(id);
    }

    @PostMapping("/create")
    public void createItemStore(@RequestBody ItemStoreDto itemStoreDto){
        itemStoreService.create(itemStoreDto);
    }

    @PostMapping("/update")
    public void updateItemStore(@RequestBody ItemStoreDto itemStoreDto) {
        itemStoreService.update(itemStoreDto.getId(), itemStoreDto);
    }

    @PostMapping("/delete")
    public void deleteItemStore(@RequestBody ItemStoreDto itemStoreDto) {
        itemStoreService.delete(itemStoreDto.getId());
    }
}
