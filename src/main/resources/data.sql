

-- Colors
INSERT INTO gestboutik.colors(id, label) VALUES
(1, 'White'),
(2, 'Red'),
(3, 'Blue'),
(4, 'Green'),
(5, 'Black')

;

--Sizes
INSERT INTO gestboutik.sizes(id, label) VALUES
(1, 'XS'),
(2, 'S'),
(3, 'M'),
(4, 'L'),
(5, 'XL'),
(6, 'XXL')

;

--Brands
INSERT INTO gestboutik.brands(id, label) VALUES
(1, 'Nike'),
(2, 'Pumas')

;

--Stores
INSERT INTO gestboutik.stores(id, designation) VALUES
(1, 'Kiabi Paris 2eme');


--Shelves
INSERT INTO gestboutik.shelves(id, designation, store_id) VALUES
(1, 'Fashion', 1),
(2, 'Décalée', 1),
(3, 'Femme enceinte', 1),
(4, 'Homme', 1)

;

-- Items
INSERT INTO gestboutik.items(id, designation) VALUES
(1, 'Pantalon'),
(2, 'Veste'),
(3, 'T-shirt')

;

-- ItemStore
INSERT INTO gestboutik.items_store(id, designation, item_id, brand_id, color_id, shelve_id, size_id) VALUES
(1, 'Pantalon Nike Black XL', 1, 1, 5, 4, 5),
(2, 'Pantalon Nike Black XXL', 1, 1, 5, 4, 6)

;


-- ItemStore_stores
INSERT INTO gestboutik.items_store_stores(items_store_id, stores_id) VALUES
(1, 1),
(2, 1)

;


 -- shelves_items_store
-- INSERT INTO gestboutik.shelves_items_store(shelves_id, items_store_id) VALUES
 --(4, 1),
 --(4, 2)

 --;