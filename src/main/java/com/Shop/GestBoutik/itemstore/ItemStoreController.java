package com.Shop.GestBoutik.itemstore;

import com.Shop.GestBoutik.models.ItemStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/itemstore")
public class ItemStoreController {

    @Autowired ItemStoreService itemStoreService ;

    @GetMapping("/")
    public List<ItemStore> listItemStore() {
        return itemStoreService.findAll();
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
