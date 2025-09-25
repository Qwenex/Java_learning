/*
INSERT INTO equationList(a,b,c) VALUES
    (1.0, 1.0, 1.0)
    ON CONFLICT DO NOTHING;

INSERT INTO rootList(x1, x2) VALUES
    (1.0, 1.0)
    ON CONFLICT DO NOTHING;

INSERT INTO solvedEquationList(equation_id, roots_id) VALUES
    (1, 1)
    ON CONFLICT DO NOTHING;

-- sequences
SELECT setval('equationList_id_seq', (SELECT MAX(id) FROM equationList));
SELECT setval('rootList_id_seq', (SELECT MAX(id) FROM rootList));
SELECT setval('solvedEquationList_id_seq', (SELECT MAX(id) FROM solvedEquationList));
*/