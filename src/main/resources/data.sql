INSERT INTO Project (name, budget) VALUES ('Project Alpha', 50000.00);
INSERT INTO Project (name, budget) VALUES ('Project Beta', 100000.00);
INSERT INTO Project (name, budget) VALUES ('Project Gamma', 150000.00);
INSERT INTO Project (name, budget) VALUES ('Project Delta', 75000.00);

-- Populate Researcher Table
INSERT INTO Researcher (name, specialization) VALUES ('Marie Curie', 'Radioactivity');
INSERT INTO Researcher (name, specialization) VALUES ('Albert Einstein', 'Relativity');
INSERT INTO Researcher (name, specialization) VALUES ('Isaac Newton', 'Classical Mechanics');
INSERT INTO Researcher (name, specialization) VALUES ('Niels Bohr', 'Quantum Mechanics');

-- Populate Junction Table
INSERT INTO Researcher_Project (projectId, researcherId) VALUES (1, 1);
INSERT INTO Researcher_Project (projectId, researcherId) VALUES (2, 1);
INSERT INTO Researcher_Project (projectId, researcherId) VALUES (2, 2);
INSERT INTO Researcher_Project (projectId, researcherId) VALUES (3, 3);
INSERT INTO Researcher_Project (projectId, researcherId) VALUES (4, 3);
INSERT INTO Researcher_Project (projectId, researcherId) VALUES (4, 4);