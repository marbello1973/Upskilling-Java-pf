package ApiRestfull.AdminGastos.excepcion;

public class GastosNotFoundException extends RuntimeException {
    public GastosNotFoundException(String message){
        super(message);
    }
}
