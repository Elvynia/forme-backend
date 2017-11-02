use forme;

INSERT INTO Role (id, name) values
(1, 'ADMIN'),
(2, 'CLIENT'),
(3, 'GUEST');

INSERT INTO Account (username, password, roleId) values
('admin', '$2a$10$gc6l/XrvDtDhz389wYo92.3vHhLzz0KxEU3OjBA1TqxbtZ/00.q5C', 1),
('katylie', '$2a$10$6Nugq3CuUM3vr681YWpeR.Wtzbql2Ep58ceZImgLLklromfbfx.Ae', 2),
('demo', '$2a$10$c8/7PRUr9BzWOiUFh6rj0uj4myl3I3UCyC25LCtloQFBMMh/dvTDG', 3);
