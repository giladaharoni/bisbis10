INSERT INTO Restaurants ( id, name, rating, isKosher) VALUES
  ( 1, 'Taizu', 4.83,  B'1')
  ON CONFLICT (id) DO NOTHING;
