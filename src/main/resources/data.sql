CREATE TABLE IF NOT EXISTS todos(
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    description VARCHAR(255),
    completed BOOLEAN NOT NULL DEFAULT false
    );

INSERT INTO todos(id, title, description, completed) VALUES
    (1, 'Придумать задачу', '', TRUE),
    (2, 'Выполнить хотя бы одну задачу', '', TRUE),
    (3, 'Радоваться что уже 2 задачи выполнены', '', TRUE),
    (4, 'Отдохнуть от проделанной работы', '', FALSE),
    (5, 'Изучить Spring', 'Это очень полезный и мощный фраймворк', FALSE),
    (6, 'Плакать 2 часа', 'Spring к тому же еще и очень сложный', TRUE);

SELECT setval('todos_id_seq', (SELECT MAX(id) FROM todos));