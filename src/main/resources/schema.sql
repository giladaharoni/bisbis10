CREATE TABLE IF NOT EXISTS Restaurants (
  id SERIAL PRIMARY KEY,
  name VARCHAR(64),
  rating DECIMAL,
  isKosher BIT);

CREATE TABLE IF NOT EXISTS Cuisines (
  id SERIAL PRIMARY KEY,
  id_rest INTEGER REFERENCES Restaurants(id),
  name_cuisine VARCHAR(255));

CREATE TABLE IF NOT EXISTS Dish (
  id SERIAL PRIMARY KEY,
  name VARCHAR(255),
  description VARCHAR(255),
  price INTEGER);