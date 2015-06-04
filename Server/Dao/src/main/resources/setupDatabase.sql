CREATE SCHEMA CHAT_SCHEMA;
CREATE TABLE CHAT_SCHEMA.user (
  id          BIGINT      NOT NULL auto_increment,
  first_name  VARCHAR(50) NOT NULL,
  second_name VARCHAR(50) NOT NULL,
  login       VARCHAR(50) NOT NULL,
  password    VARCHAR(50),
  token       VARCHAR(50)
);