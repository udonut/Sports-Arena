CREATE TABLE Arena (
    arena_name VARCHAR(100) PRIMARY KEY,
    capacity INT NOT NULL,
    location VARCHAR(255) NOT NULL,
    phone_number VARCHAR(20)
);

CREATE TABLE Sponsors (
    sponsor_name VARCHAR(100) PRIMARY KEY,
    phone_number VARCHAR(20),
    amount DECIMAL(10,2) NOT NULL
);

CREATE TABLE Teams (
    team_name VARCHAR(100) PRIMARY KEY,
    hometown VARCHAR(100) NOT NULL,
    player_count INT CHECK (player_count >= 0)
);

CREATE TABLE Players (
    player_name VARCHAR(100) PRIMARY KEY,
    player_address VARCHAR(255),
    sport_type VARCHAR(50),
    phone_number VARCHAR(20),
    player_type VARCHAR(20) CHECK (player_type IN ('single', 'team')) NOT NULL
);

CREATE TABLE Coach (
    coach_name VARCHAR(100) PRIMARY KEY,
    phone_number VARCHAR(20),
    team_name VARCHAR(100),
    player_name VARCHAR(100),
    CONSTRAINT fk_team FOREIGN KEY (team_name) REFERENCES Teams(team_name) ON DELETE SET NULL,
    CONSTRAINT fk_player FOREIGN KEY (player_name) REFERENCES Players(player_name) ON DELETE SET NULL
);

CREATE TABLE Managers (
    manager_name VARCHAR(100) PRIMARY KEY,
    phone_number VARCHAR(20),
    coach_name VARCHAR(100),
    email VARCHAR(255) UNIQUE NOT NULL,
    CONSTRAINT fk_coach FOREIGN KEY (coach_name) REFERENCES Coach(coach_name) ON DELETE SET NULL
);

CREATE TABLE Player_Team (
    player_team_name SERIAL PRIMARY KEY,
    player_name VARCHAR(100),
    team_name VARCHAR(100),
    CONSTRAINT fk_player FOREIGN KEY (player_name) REFERENCES Players(player_name) ON DELETE CASCADE,
    CONSTRAINT fk_team FOREIGN KEY (team_name) REFERENCES Teams(team_name) ON DELETE CASCADE
);

CREATE TABLE Staff (
    staff_name VARCHAR(100) PRIMARY KEY,
    staff_role VARCHAR(50) NOT NULL,
    phone_number VARCHAR(20),
    arena_name VARCHAR(100),
    CONSTRAINT fk_arena FOREIGN KEY (arena_name) REFERENCES Arena(arena_name) ON DELETE CASCADE
);

CREATE TABLE Event (
    event_name VARCHAR(100) PRIMARY KEY,
    event_type VARCHAR(50) NOT NULL,
    arena_name VARCHAR(100),
    manager_name VARCHAR(100),
    ticket_id INT,
    CONSTRAINT fk_arena FOREIGN KEY (arena_name) REFERENCES Arena(arena_name) ON DELETE CASCADE,
    CONSTRAINT fk_manager FOREIGN KEY (manager_name) REFERENCES Managers(manager_name) ON DELETE SET NULL
);

CREATE TABLE Ticket (
    ticket_id SERIAL PRIMARY KEY,
    ticket_owner VARCHAR(100),
    price DECIMAL(10,2) NOT NULL,
    event_name VARCHAR(100),
    seat_number VARCHAR(10) NOT NULL,
    CONSTRAINT fk_event FOREIGN KEY (event_name) REFERENCES Event(event_name) ON DELETE CASCADE
);

CREATE INDEX idx_arena_name ON Event(arena_name);