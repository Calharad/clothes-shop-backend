create table product
(
    id             bigserial      not null,
    description    text           not null,
    is_bestseller  boolean        not null,
    name           text           not null,
    price          numeric(19, 2) not null,
    category_id    int8           not null,
    subcategory_id int8           not null,
    primary key (id)
);
create table product_category
(
    id   bigserial not null,
    name text      not null,
    primary key (id)
);
create table product_detail
(
    id         bigserial not null,
    value      text      not null,
    product_id int8      not null,
    primary key (id)
);
create table product_image
(
    id            bigserial not null,
    is_main_image boolean   not null,
    src           text      not null,
    product_id    int8      not null,
    primary key (id)
);
create table product_size
(
    id         bigserial not null,
    size       text      not null,
    product_id int8      not null,
    primary key (id)
);
create table product_subcategory
(
    id          bigserial not null,
    name        text      not null,
    category_id int8      not null,
    primary key (id)
);
alter table if exists product_category
    add constraint UK_9qvug0bmpkmxkkx33q51m7do7 unique (name);
alter table if exists product
    add constraint FK5cypb0k23bovo3rn1a5jqs6j4 foreign key (category_id) references product_category;
alter table if exists product
    add constraint FKsr70ejjwg81m9xvu5fguxugu9 foreign key (subcategory_id) references product_subcategory;
alter table if exists product_detail
    add constraint FKilxoi77ctyin6jn9robktb16c foreign key (product_id) references product;
alter table if exists product_image
    add constraint FK6oo0cvcdtb6qmwsga468uuukk foreign key (product_id) references product;
alter table if exists product_size
    add constraint FK8i3jm2ctt0lsyeik2wt76yvv0 foreign key (product_id) references product;
alter table if exists product_subcategory
    add constraint FK7jpe03gy08dje48g90x91pcpc foreign key (category_id) references product_category;