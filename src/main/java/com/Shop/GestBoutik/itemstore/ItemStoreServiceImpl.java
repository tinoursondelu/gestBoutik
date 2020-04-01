package com.Shop.GestBoutik.itemstore;

import com.Shop.GestBoutik.models.ItemStore;
import com.Shop.GestBoutik.services.BrandServiceImpl;
import com.Shop.GestBoutik.services.ColorServiceImpl;
import com.Shop.GestBoutik.services.SizeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public ItemStoreDto findOne(Long id) {
        ItemStoreDto itemStoreDto = new ItemStoreDto();
        itemStoreDto = parseModelToDto(itemStoreRepository.getOne(id));
        return itemStoreDto;
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
    public List<ItemStoreDto> parseListModelToDto(List<ItemStore> itemStores) {

        List<ItemStoreDto> itemStoreDtoList = new ArrayList<>();

        for(ItemStore itemStore: itemStores)
        {
            itemStoreDtoList.add(parseModelToDto(itemStore));
        }
        return itemStoreDtoList;
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

    @Override
    public void create(ItemStoreDto itemStoreDto) {

        ItemStore itemStore = new ItemStore();
        itemStore = parseDtoToModel(itemStoreDto);
        itemStoreRepository.save(itemStore);
    }

    @Override
    public void delete(long id) {
        Optional<ItemStore> itemStoreDel = findById(id);
        itemStoreDel.ifPresent(itemStore -> itemStoreRepository.delete(itemStore));
    }

    @Override
    public void update(long id, ItemStoreDto itemStoreDto) {

        ItemStore itemStore = new ItemStore();
        Optional<ItemStore> itemStoreUpd = findById(id);

        if(itemStoreUpd.isPresent()) {
            itemStore = parseDtoToModel(itemStoreDto);
            itemStoreRepository.save(itemStore);
        }
    }
}
