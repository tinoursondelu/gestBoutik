package com.Shop.GestBoutik.itemstore;

import com.Shop.GestBoutik.models.ItemStore;
import com.Shop.GestBoutik.services.BrandServiceImpl;
import com.Shop.GestBoutik.services.ColorServiceImpl;
import com.Shop.GestBoutik.services.SizeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class ItemStoreServiceImpl implements ItemStoreService {

    @Autowired ItemStoreRepository itemStoreRepository;
    @Autowired ColorServiceImpl colorService;
    @Autowired SizeServiceImpl sizeService;
    @Autowired BrandServiceImpl brandService;;


    @Override
    public List<ItemStore> findAll() {
        return itemStoreRepository.findAll();
    }

    @Override
    public Optional<ItemStore> findById(Long id) {
        return itemStoreRepository.findById(id);
    }


    @Override
    public ItemStore parseDtoToModel(ItemStoreDto itemStoreDto) {
        ItemStore itemStore = new ItemStore();

        itemStore.setId(itemStoreDto.getId());
        itemStore.setDesignation(itemStoreDto.getDesignation());
        itemStore.setColor(colorService.findById(itemStoreDto.getIdColor()).get());
        itemStore.setSize(sizeService.findById(itemStoreDto.getIdSize()).get());
        itemStore.setBrand(brandService.findById(itemStoreDto.getIdBrand()).get());
        return itemStore;
    }

    @Override
    public Collection<ItemStoreDto> parseCollectionModelToDto(Collection<ItemStore> itemStores) {

        Collection<ItemStoreDto>itemStoreDtoCollection = new ArrayList<ItemStoreDto>();
        for(ItemStore itemStore: itemStores)
        {
            itemStoreDtoCollection.add(parseModelToDto(itemStore));
        }
        return itemStoreDtoCollection;
    }

    @Override
    public ItemStoreDto parseModelToDto(ItemStore itemStore) {

        ItemStoreDto itemStoreDto = new ItemStoreDto();
        itemStoreDto.setId(itemStore.getId());
        itemStoreDto.setDesignation(itemStore.getDesignation());
        itemStoreDto.setIdColor(itemStore.getColor().getId());
        itemStoreDto.setIdBrand(itemStore.getBrand().getId());
        itemStoreDto.setIdSize(itemStore.getSize().getId());
        itemStoreDto.setIdItem(itemStore.getItem().getId());

        return itemStoreDto;
    }
}