insert into product_category (name)
VALUES ('Buty'),
       ('Koszulki'),
       ('Koszule'),
       ('Bluzy'),
       ('Kurtki'),
       ('Szorty'),
       ('Spodnie'),
       ('Czapki'),
       ('Plecaki/Torby'),
       ('Akcesoria');
insert into product_category (id, name)
values (0, 'Domyślna');
INSERT INTO product_subcategory (name, category_id)
VALUES ('Klapki', 1),
       ('Buty sportowe', 1),
       ('Buty zimowe', 1),
       ('T-shirty', 2),
       ('Tank top', 2),
       ('Bluzy z kapturem', 4),
       ('Bluzy bez kaptura', 4),
       ('Bluzy zapinane', 4),
       ('Kurtki zimowe', 5),
       ('Przejściówki', 5),
       ('Szorty materiałowe', 6),
       ('Boardshorty', 6),
       ('Jeans', 6),
       ('Spodnie materiałowe', 7),
       ('Jeansy', 7),
       ('Spodnie dresowe', 7),
       ('Kapelusze', 8),
       ('Czapki z daszkiem', 8),
       ('Czapki zimowe', 8),
       ('Plecaki', 9),
       ('Torby', 9),
       ('Nerki', 9),
       ('Inne', 10),
       ('Przypinki', 10),
       ('Skarpety', 10),
       ('Paski', 10),
       ('Okulary przeciwsłoneczne', 10),
       ('Zegarki', 10);
insert into product_subcategory (id, name, category_id)
    VALUES (0, 'Domyślna', 0);