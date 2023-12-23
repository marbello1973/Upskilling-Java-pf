package ApiRestfull.AdminGastos.repository;

import ApiRestfull.AdminGastos.excepcion.GastosNotFoundException;
import ApiRestfull.AdminGastos.models.Gastos;

import java.util.List;

public interface GastosRepository {
    Integer createGasto(Gastos gastos);
    Integer updateGastos(Long id, Gastos gastos);
    void deleteGastos(Long id) throws GastosNotFoundException;
    List<Gastos> getAllGastos();
    Gastos selectGastos(Long id);


}

