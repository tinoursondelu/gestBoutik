package com.Shop.GestBoutik.itemstore;

import com.Shop.GestBoutik.models.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Collection;

@Getter
@Setter
@ToString
public class ItemStoreDto {

    private long id ;

    private String designation ;

    private Color color ;

    private Size size ;

    private Brand brand ;

    private Collection<Store> stores ;

    private Item item ;

}
