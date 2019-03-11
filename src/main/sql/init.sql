CREATE DATABASE IF NOT EXISTS shorturl;
USE shorturl;

CREATE TABLE IF NOT EXISTS url_mapper(
      origin_url VARCHAR(400) NOT NULL COMMENT 'original url',
      short_url VARCHAR (50) NOT NULL comment 'short url',
      unique index mapper_index(short_url)
)ENGINE =innodb;