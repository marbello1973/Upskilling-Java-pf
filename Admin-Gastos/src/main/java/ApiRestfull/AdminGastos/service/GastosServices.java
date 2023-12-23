package ApiRestfull.AdminGastos.service;

import ApiRestfull.AdminGastos.dto.request.GastosRequestDto;
import ApiRestfull.AdminGastos.dto.response.GastosResponseDto;
import ApiRestfull.AdminGastos.excepcion.GastosNotFoundException;

import java.util.List;

public interface GastosServices {

    String createGastos(GastosRequestDto gastosRequestDto);
    String updateGastos(Long id, GastosRequestDto gastosRequestDto);
    void deleteGastos(Long id) throws GastosNotFoundException;
    List<GastosResponseDto> getAllGastos();




}
