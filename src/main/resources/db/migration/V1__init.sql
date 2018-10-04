CREATE TABLE employees (
  employee_id        BIGINT    NOT NULL    AUTO_INCREMENT,
  first_name         VARCHAR   NOT NULL,
  last_name          VARCHAR   NOT NULL,
  want_communication BIT       NULL,
  origin_country     VARCHAR   NOT NULL,
  email              VARCHAR   NULL,
  age                INT       NOT NULL,
  join_date          DATETIME2 NOT NULL,
  expiration_date    DATETIME2 NOT NULL,
  PRIMARY KEY (employee_id)
);