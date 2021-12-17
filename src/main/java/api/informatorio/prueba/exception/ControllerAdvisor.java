package api.informatorio.prueba.exception;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@RestControllerAdvice

public class ControllerAdvisor {
    @ExceptionHandler(CustomException.class)
    public ErrorMessage customException(CustomException exception){
        return new ErrorMessage("CustomException", exception.getMessage());
    }
}
