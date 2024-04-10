-- Create Project Table

CREATE TABLE project (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    name TEXT,
    budget DOUBLE
);


-- Create Researcher Table
CREATE TABLE researcher (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    name TEXT,
    specialization TEXT
);

-- Create Junction Table
CREATE TABLE researcher_project (
    projectid INTEGER,
    researcherid INTEGER,
    PRIMARY KEY (projectid, researcherid),
    FOREIGN KEY (projectid) REFERENCES project(id),
    FOREIGN KEY (researcherid) REFERENCES researcher(id)
);