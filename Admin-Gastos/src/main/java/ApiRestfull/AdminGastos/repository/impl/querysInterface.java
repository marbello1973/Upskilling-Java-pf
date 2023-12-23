package ApiRestfull.AdminGastos.repository.impl;

public interface querysInterface {
    String UPDATE_GASTOS_BY_ID = "UPDATE Gastos SET amount = ?, category = ?, date = ?, isActive = ? WHERE id = ?";
    String INSERT_INTO_GASTOS = "INSERT INTO Gastos (amount, category, date, isActive) VALUES (?, ?, ?, ?)";
    String DELETE_FROM_GASTOS_BY_ID = "DELETE FROM Gastos WHERE id = ?";
    String SELECT_ALL_GASTOS = "SELECT * FROM Gastos";
    String SELECT_GASTOS_BY_ID = "SELECT * FROM Gastos WHERE id = ?";
    String INSERT_INTO_CATEGORY_GASTOS = "INSERT INTO GastosCategory (name) VALUES (?)";
    String SELECT_FROM_GASTOS_CATEGORY_BY_NAME = "SELECT * FROM GastosCategory WHERE name = ?";
}
