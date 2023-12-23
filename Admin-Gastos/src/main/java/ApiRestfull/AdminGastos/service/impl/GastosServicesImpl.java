package ApiRestfull.AdminGastos.service.impl;


import ApiRestfull.AdminGastos.dto.request.GastosRequestDto;
import ApiRestfull.AdminGastos.dto.response.GastosResponseDto;
import ApiRestfull.AdminGastos.excepcion.GastosNotFoundException;
import ApiRestfull.AdminGastos.models.Gastos;
import ApiRestfull.AdminGastos.repository.GastosRepository;
import ApiRestfull.AdminGastos.service.GastosServices;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GastosServicesImpl implements GastosServices {

    private final GastosRepository gastosRepository;

    public GastosServicesImpl(GastosRepository gastosRepository) {
        this.gastosRepository = gastosRepository;
    }

    @Override
    public String createGastos(GastosRequestDto gastosRequestDto){
        String response = "Register ok";
        Gastos gastos = mapToGastos((gastosRequestDto));
        Integer resCreated = gastosRepository.createGasto(gastos);
        if(resCreated != null && resCreated.equals(0)){
            System.out.println("Not inserted register");
        }
        return response;
    }


    @Override
    public String updateGastos(Long id, GastosRequestDto gastosRequestDto){
        Gastos gastos = mapToGastos(gastosRequestDto);
        Integer responseUpdated = gastosRepository.updateGastos(id, gastos );
        if(responseUpdated.equals(0)) {
            System.out.println("Gastos id " + id + "not found");
        }
        System.out.println("Updated " + id);
        return "Updated...!";
    }

    @Override
    public void deleteGastos(Long id) throws GastosNotFoundException {
        gastosRepository.deleteGastos(id);
    }

    @Override
    public List<GastosResponseDto> getAllGastos(){
        List<Gastos> gastos = gastosRepository.getAllGastos();
        List<GastosResponseDto> gastosResponseDtos = gastos.stream()
                .map(this::mapToResponseDto)
                .collect(Collectors.toList());
        if(gastosResponseDtos.isEmpty()){
            throw new GastosNotFoundException("Not list");
        }
        return gastosResponseDtos;
    }

    private GastosResponseDto mapToResponseDto(Gastos gastos) {
        GastosResponseDto responseDto = new GastosResponseDto();
        responseDto.setAmount(gastos.getAmount());
        responseDto.setCategory(gastos.getCategory());
        responseDto.setDate(gastos.getDate());
        return responseDto;
    }

    private Gastos mapToGastos(GastosRequestDto gastosRequestDto){
        Gastos gastos = new Gastos();
        gastos.setAmount(gastosRequestDto.getAmount());
        gastos.setCategory(gastosRequestDto.getCategory());
        gastos.setDate(gastosRequestDto.getDate());
        return gastos;
    }


}
