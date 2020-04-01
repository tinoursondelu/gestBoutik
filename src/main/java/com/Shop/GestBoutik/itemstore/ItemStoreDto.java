package com.Shop.GestBoutik.itemstore;

import com.Shop.GestBoutik.models.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class ItemStoreDto {

    private long id ;

    private String designation ;

    private Long idColor ;

    private Long idSize;

    private Long idBrand;

    private Long idItem;


}
