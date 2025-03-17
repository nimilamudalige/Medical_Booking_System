package lk.ijse.medicalbookingsystem.advisor;


import lk.ijse.medicalbookingsystem.util.Response;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@CrossOrigin
public class AppWideExceptionHandler {
    @ExceptionHandler(Exception.class)
    public Response exceptionHandler(Exception ex) {
        return new Response(
                500,
                ex.getMessage(),
                null );
    }
}
