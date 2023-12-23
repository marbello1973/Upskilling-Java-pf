CREATE TABLE IF NOT EXISTS Gastos(
    id LONG PRIMARY KEY AUTO_INCREMENT NOT NULL,
    amount DOUBLE NOT NULL,
    category VARCHAR(100) NOT NULL,
    date VARCHAR(30),
    isActive BIT
)

--INSERT INTO Gastos (amount, category, date, isActive) VALUES(100.500, 'Alimentos', '2023/12/01', 1);


