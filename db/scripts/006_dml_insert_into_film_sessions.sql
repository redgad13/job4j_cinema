INSERT INTO film_sessions (film_id, halls_id, start_time, end_time, price) VALUES
((SELECT id FROM films WHERE name = 'AceVentura'), (SELECT id FROM halls WHERE name = 'A'), '2024-04-10 15:30:00', '2024-04-10 17:30:00', 750);
INSERT INTO film_sessions (film_id, halls_id, start_time, end_time, price) VALUES
((SELECT id FROM films WHERE name = 'AceVentura'), (SELECT id FROM halls WHERE name = 'B'), '2024-05-10 10:30:00', '2024-04-10 12:30:00', 450);
INSERT INTO film_sessions (film_id, halls_id, start_time, end_time, price) VALUES
((SELECT id FROM films WHERE name = 'Chucky'), (SELECT id FROM halls WHERE name = 'A'), '2024-04-10 22:00:00', '2024-04-11 00:05:00', 750);
INSERT INTO film_sessions (film_id, halls_id, start_time, end_time, price) VALUES
((SELECT id FROM films WHERE name = 'Chucky'), (SELECT id FROM halls WHERE name = 'B'), '2024-04-10 22:00:00', '2024-04-11 00:05:00', 750);
INSERT INTO film_sessions (film_id, halls_id, start_time, end_time, price) VALUES
((SELECT id FROM films WHERE name = 'Chucky'), (SELECT id FROM halls WHERE name = 'C'), '2024-04-10 22:00:00', '2024-04-11 00:05:00', 550);
INSERT INTO film_sessions (film_id, halls_id, start_time, end_time, price) VALUES
((SELECT id FROM films WHERE name = 'OnePlusOne'), (SELECT id FROM halls WHERE name = 'A'), '2024-04-10 18:00:00', '2024-04-10 19:50:00', 650);
INSERT INTO film_sessions (film_id, halls_id, start_time, end_time, price) VALUES
((SELECT id FROM films WHERE name = 'OnePlusOne'), (SELECT id FROM halls WHERE name = 'C'), '2024-04-12 18:00:00', '2024-04-10 19:50:00', 700);
INSERT INTO film_sessions (film_id, halls_id, start_time, end_time, price) VALUES
((SELECT id FROM films WHERE name = 'Scream'), (SELECT id FROM halls WHERE name = 'A'), '2024-04-11 22:00:00', '2024-04-12 00:20:00', 750);
INSERT INTO film_sessions (film_id, halls_id, start_time, end_time, price) VALUES
((SELECT id FROM films WHERE name = 'Scream'), (SELECT id FROM halls WHERE name = 'B'), '2024-04-11 22:00:00', '2024-04-12 00:20:00', 750);
INSERT INTO film_sessions (film_id, halls_id, start_time, end_time, price) VALUES
((SELECT id FROM films WHERE name = 'Scream'), (SELECT id FROM halls WHERE name = 'C'), '2024-04-11 22:00:00', '2024-04-12 00:20:00', 750);
INSERT INTO film_sessions (film_id, halls_id, start_time, end_time, price) VALUES
((SELECT id FROM films WHERE name = 'Seven'), (SELECT id FROM halls WHERE name = 'A'), '2024-04-20 15:00:00', '2024-04-20 17:01:00', 500);
INSERT INTO film_sessions (film_id, halls_id, start_time, end_time, price) VALUES
((SELECT id FROM films WHERE name = 'Seven'), (SELECT id FROM halls WHERE name = 'B'), '2024-04-20 15:00:00', '2024-04-20 17:01:00', 500);
INSERT INTO film_sessions (film_id, halls_id, start_time, end_time, price) VALUES
((SELECT id FROM films WHERE name = 'SilenceOfTheLambs'), (SELECT id FROM halls WHERE name = 'C'), '2024-04-20 15:00:00', '2024-04-20 17:06:00', 500);
