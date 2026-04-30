CREATE TABLE categories
(
    id            BIGSERIAL PRIMARY KEY,
    created_at    timestamp    NOT NULL,
    updated_at    timestamp    NOT NULL,
    name          VARCHAR(255) NOT NULL,
    description VARCHAR(255) NULL
);

CREATE TABLE products
(
    id            BIGSERIAL primary key,
    created_at    timestamp                                         NOT NULL,
    updated_at    timestamp                                         NOT NULL,
    name          VARCHAR(255)                                      NOT NULL,
    description VARCHAR(255),
    price         NUMERIC(19, 2)                                    NOT NULL,
    quantity      INTEGER                                           NOT NULL,
    category_id   BIGINT references categories (id) on delete cascade NOT NULL
);