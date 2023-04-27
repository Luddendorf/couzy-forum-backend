CREATE TABLE IF NOT EXISTS post (
    post_id          BIGINT PRIMARY KEY AUTO_INCREMENT,
    user_id          BIGINT NOT NULL,
    title            VARCHAR(300) NULL,
    text             TEXT(65535) NOT NULL,
    parent_post_id   BIGINT NULL,
    subcategory_id   BIGINT NULL,
    is_poll          BOOL DEFAULT false,
    state            TINYINT NULL,
    source           TINYINT NULL,
    ip               TEXT(50) NOT NULL,
    created_datetime TIMESTAMP,
    updated_datetime TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS likes (
    like_id  BIGINT PRIMARY KEY AUTO_INCREMENT,
    user_id  BIGINT NOT NULL,
    post_id  BIGINT NOT NULL,
    icon     VARCHAR(200),
    created_datetime TIMESTAMP,
    updated_datetime TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS user (
    user_id          BIGINT PRIMARY KEY AUTO_INCREMENT,
    nick             VARCHAR(200),
    password         VARCHAR(200),
    email            VARCHAR(200),
    karma            FLOAT(9,2),
    ip               TEXT(50) NOT NULL,
    created_datetime TIMESTAMP,
    updated_datetime TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS poll_option (
    poll_option_id   BIGINT PRIMARY KEY AUTO_INCREMENT,
    post_id          BIGINT NOT NULL,
    title            VARCHAR(300),
    created_datetime TIMESTAMP,
    updated_datetime TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS vote (
    vote_id          BIGINT PRIMARY KEY AUTO_INCREMENT,
    poll_option_id   BIGINT NOT NULL,
    user_id          BIGINT NOT NULL,
    ip               VARCHAR(50),
    created_datetime TIMESTAMP,
    updated_datetime TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS category (
    category_id      BIGINT PRIMARY KEY AUTO_INCREMENT,
    title            VARCHAR(200),
    description      VARCHAR(6000),
    ip               VARCHAR(50),
    created_datetime TIMESTAMP,
    updated_datetime TIMESTAMP DEFAULT CURRENT_TIMESTAMP  
);

CREATE TABLE IF NOT EXISTS subcategory (
    subcategory_id   BIGINT PRIMARY KEY AUTO_INCREMENT,
    category_id      BIGINT,
    title            VARCHAR(200),
    description      VARCHAR(6000),
    ip               VARCHAR(50),
    created_datetime TIMESTAMP,
    updated_datetime TIMESTAMP DEFAULT CURRENT_TIMESTAMP  
);
