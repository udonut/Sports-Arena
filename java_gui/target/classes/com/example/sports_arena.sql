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

-- Example data made using ChatGPT for video demonstration

INSERT INTO Arena (arena_name, capacity, location, phone_number) VALUES
('Helsinki Ice Hall', 8200, 'Helsinki, Finland', '09123456'),
('Tampere Deck Arena', 13500, 'Tampere, Finland', '03654321'),
('Oulun Energia Areena', 6614, 'Oulu, Finland', '08987654'),
('Olympic Stadium', 36000, 'Helsinki, Finland', '09555555');

INSERT INTO Sponsors (sponsor_name, phone_number, amount) VALUES
('Nike', '5036716453', 500000.00),
('Red Bull', '662658200', 350000.00),
('Finnair', '098180800', 200000.00),
('Veikkaus', '0943701111', 150000.00);

INSERT INTO Teams (team_name, hometown, player_count) VALUES
('HIFK', 'Helsinki, Finland', 25),
('Tampere Ilves', 'Tampere, Finland', 23),
('Los Angeles Lakers', 'Los Angeles, USA', 15),
('Manchester United', 'Manchester, UK', 30);

INSERT INTO Players (player_name, player_address, sport_type, phone_number, player_type) VALUES
('Teemu Selänne', 'Helsinki, Finland', 'Ice Hockey', '401122334', 'team'),
('Patrik Laine', 'Tampere, Finland', 'Ice Hockey', '402233445', 'team'),
('LeBron James', 'Los Angeles, USA', 'Basketball', '3105551234', 'team'),
('Cristiano Ronaldo', 'Lisbon, Portugal', 'Football', '215556789', 'team');

INSERT INTO Coach (coach_name, phone_number, team_name, player_name) VALUES
('Kari Jalonen', '50987654', 'HIFK', 'Teemu Selänne'),
('Jukka Jalonen', '40876543', 'Tampere Ilves', 'Patrik Laine'),
('Darvin Ham', '3234567890', 'Los Angeles Lakers', 'LeBron James'),
('Erik ten Hag', '1615557890', 'Manchester United', 'Cristiano Ronaldo');

INSERT INTO Managers (manager_name, phone_number, coach_name, email) VALUES
('Jarmo Kekäläinen', '501234567', 'Jukka Jalonen', 'xyz@gmail.com'),
('Tommi Kerttula', '503456789', 'Kari Jalonen', 'abc@gmail.com'),
('Rob Pelinka', '3239876543', 'Darvin Ham', 'def@gmail.com'),
('John Murtough', '1612349876', 'Erik ten Hag', 'ghi@gmail.com');

INSERT INTO Staff (staff_name, staff_role, phone_number, arena_name) VALUES
('Markus Lehtinen', 'Physiotherapist', '505555555', 'HIFK'),
('Matti Virtanen', 'Equipment Manager', '506666666', 'Tampere Ilves'),
('Mike Penberthy', 'Assistant Coach', '3237778888', 'Los Angeles Lakers'),
('Darren Fletcher', 'Technical Director', '1619990000', 'Manchester United');

INSERT INTO Ticket (ticket_id, ticket_owner, price, event_name, seat_number) VALUES
(101, 'John Doe', 10.00, 'HIFK vs Tampere Ilves', 12),
(103, 'Avaneep', 10.00, 'Manchester United vs Liverpool', 13),
(103, 'Miruna', 10.00, 'Manchester United vs Liverpool', 22),
(103, 'Dana', 10.00, 'Manchester United vs Liverpool', 25);

INSERT INTO Event (event_name, arena_name, manager_name, ticket_id) VALUES
('HIFK vs Tampere Ilves', 'Helsinki Ice Hall', 'Jarmo Kekäläinen', 101),
('Los Angeles Lakers vs Golden State Warriors', 'Tampere Deck Arena', 'Rob Pelinka', 102),
('Manchester United vs Liverpool', 'Olympic Stadium', 'John Murtough', 103);

INSERT INTO Player_Team (player_team_name, player_name, team_name) VALUES
('Finnish club', 'Teemu Selänne', 'HIFK'),
('Tampere club ry', 'Patrik Laine', 'Tampere Ilves'),
('LA club', 'LeBron James', 'Los Angeles Lakers'),
('MU club', 'Cristiano Ronaldo', 'Manchester United');
