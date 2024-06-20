INSERT INTO films (name, description, "year", genre_id, minimal_age,  duration_in_minutes, file_id) VALUES
('AceVentura', 'Funny film about pet detective', 1990, (SELECT id FROM genres WHERE name = 'comedy'), 6, 120, (SELECT id FROM files WHERE name = 'AceVentura'));
INSERT INTO films (name, description, "year", genre_id, minimal_age,  duration_in_minutes, file_id) VALUES
('Chucky', 'Scary movie about grim toy', 1995, (SELECT id FROM genres WHERE name = 'horror'), 18, 125, (SELECT id FROM files WHERE name = 'Chucky'));
INSERT INTO films (name, description, "year", genre_id, minimal_age,  duration_in_minutes, file_id) VALUES
('OnePlusOne', 'Joyful film about a millionaire ', 2018, (SELECT id FROM genres WHERE name = 'comedy'), 12, 110, (SELECT id FROM files WHERE name = 'OnePlusOne'));
INSERT INTO films (name, description, "year", genre_id, minimal_age,  duration_in_minutes, file_id) VALUES
('Scream', 'Old scary movie about a maniac in a mask', 1991, (SELECT id FROM genres WHERE name = 'horror'), 18, 140, (SELECT id FROM files WHERE name = 'Scream'));
INSERT INTO films (name, description, "year", genre_id, minimal_age,  duration_in_minutes, file_id) VALUES
('Seven', 'Movie about detective', 1995, (SELECT id FROM genres WHERE name = 'thriller'), 18, 121, (SELECT id FROM files WHERE name = 'Seven'));
INSERT INTO films (name, description, "year", genre_id, minimal_age,  duration_in_minutes, file_id) VALUES
('SilenceOfTheLambs', 'Movie about serial maniac and young FBI agent', 1991, (SELECT id FROM genres WHERE name = 'thriller'), 18, 126, (SELECT id FROM files WHERE name = 'SilenceOfTheLambs'));