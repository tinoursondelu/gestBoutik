package com.Shop.GestBoutik.itemstore;

import com.Shop.GestBoutik.models.ItemStore;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface ItemStoreService {

    public List<ItemStore> findAll();
    public Optional<ItemStore> findById(Long id);
    public ItemStore parseDtoToModel(ItemStoreDto itemStoreDto);
    public Collection<ItemStoreDto>parseCollectionModelToDto(Collection<ItemStore> itemStores);
    public ItemStoreDto parseModelToDto(ItemStore itemStore);
    public void create(ItemStoreDto itemStoreDto);
    public void delete(long id);
    public void update(long id , ItemStoreDto itemStoreDto);
}
