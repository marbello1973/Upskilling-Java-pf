package ApiRestfull.AdminGastos.repository.impl;

import ApiRestfull.AdminGastos.excepcion.GastosNotFoundException;
import ApiRestfull.AdminGastos.models.Gastos;
import ApiRestfull.AdminGastos.repository.GastosRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public class GastosRepositoryImpl implements GastosRepository, querysInterface {

    private final JdbcTemplate jdbcTemplate;

    public GastosRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

//    private boolean existsById(Long id){
//        String sql = SELECT_GASTOS_BY_ID;
//        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, id);
//        return count != null && count > 0;
//    }

    @Override
    public Integer createGasto(Gastos gastos) {
        return jdbcTemplate.update(INSERT_INTO_GASTOS,
            gastos.getAmount(),
            gastos.getCategory(),
            gastos.getDate(),
            gastos.getActive()
            );
    }

    @Override
    public Integer updateGastos(Long id, Gastos gastos) {
         return jdbcTemplate.update(UPDATE_GASTOS_BY_ID,
             gastos.getAmount(),
             gastos.getCategory(),
             gastos.getDate(),
             gastos.getActive(),
             id
         );
    }

    @Override
    public void deleteGastos(Long id) {
//        if(!existsById(id)){
//            throw new GastosNotFoundException("Not found " + id);
//        }
        String sql = DELETE_FROM_GASTOS_BY_ID;
        int rowsAffected = jdbcTemplate.update(sql, id);
        if(rowsAffected == 0){
            throw new GastosNotFoundException("Not found " + id);
        }
    }

    @Override
    public List<Gastos> getAllGastos() {
        String sql = SELECT_ALL_GASTOS;
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Gastos.class));
    }

    @Override
    public Gastos selectGastos(Long id) {
        return null;
    }
}
