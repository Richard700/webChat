-- CREATE SCHEMA CHAT_SCHEMA;
--
CREATE TABLE chat_user (
  id          BIGINT      NOT NULL PRIMARY KEY,
  first_name  VARCHAR(50) NOT NULL,
  second_name VARCHAR(50) NOT NULL,
  login       VARCHAR(50) NOT NULL,
  password    VARCHAR(50) NOT NULL,
  token       VARCHAR(50) NOT NULL
);

CREATE TABLE user_to_user (
  id           BIGINT NOT NULL PRIMARY KEY,
  user_from    BIGINT NOT NULL,
  user_to      BIGINT NOT NULL,
  confirm_from BINARY,
  confirm_to   BINARY,
  FOREIGN KEY (user_from) REFERENCES chat_user (id),
  FOREIGN KEY (user_to) REFERENCES chat_user (id)
);

INSERT INTO chat_user (id, first_name, second_name, login, password, token)
VALUES (1, 'Vlad', 'Maksjuta', 'richard', '1234', 'token');

INSERT INTO chat_user (id, first_name, second_name, login, password, token)
VALUES (2, 'Vlad', 'Maksjuta', 'richardTo', '1234', 'token');

INSERT INTO user_to_user (id, user_from, user_to, confirm_from, confirm_to)
VALUES (1, 1, 2, 0, 0);
