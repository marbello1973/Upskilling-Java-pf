package ApiRestfull.AdminGastos.controller;

import ApiRestfull.AdminGastos.dto.request.GastosRequestDto;
import ApiRestfull.AdminGastos.dto.response.GastosResponseDto;
import ApiRestfull.AdminGastos.excepcion.GastosNotFoundException;
import ApiRestfull.AdminGastos.service.GastosServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/gastos")
public class GastosController {

    private final GastosServices gastosServices;

    public GastosController(GastosServices gastosServices){
        this.gastosServices = gastosServices;
    }

    @PostMapping()
    public ResponseEntity<String> createGastos(@RequestBody GastosRequestDto gastosRequestDto){
        String response = gastosServices.createGastos(gastosRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("{id}")
    public ResponseEntity<String> updateGastos(
            @PathVariable Long id,
            @RequestBody GastosRequestDto gastosRequestDto ){
       String response = gastosServices.updateGastos(id, gastosRequestDto);
       return ResponseEntity
               .status(HttpStatus.ACCEPTED)
               .body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteGastos(@PathVariable Long id) throws GastosNotFoundException{
        gastosServices.deleteGastos(id);
        return ResponseEntity.status(HttpStatus.GONE).body("Deleted " +id);
    }

    @GetMapping()
    public ResponseEntity<List<GastosResponseDto>> getGastos(){
        List<GastosResponseDto> response = gastosServices.getAllGastos();
        if(response.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }




}
