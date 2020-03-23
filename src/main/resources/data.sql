

-- Colors
INSERT INTO gestboutik.colors(id, label) VALUES
(1, 'White'),
(2, 'Red'),
(3, 'Blue'),
(4, 'Green'),
(5, 'Black')

;
-- SELECT setval(pg_get_serial_sequence('colors', 'id'), 5);

--Sizes
INSERT INTO gestboutik.sizes(id, label) VALUES
(1, 'XS'),
(2, 'S'),
(3, 'M'),
(4, 'L'),
(5, 'XL'),
(6, 'XXL')

;
-- SELECT setval(pg_get_serial_sequence('sizes', 'id'), 6);

--Brands
INSERT INTO gestboutik.brands(id, label) VALUES
(1, 'Nike'),
(2, 'Pumas')

;
-- SELECT setval(pg_get_serial_sequence('brands', 'id'), 2);
