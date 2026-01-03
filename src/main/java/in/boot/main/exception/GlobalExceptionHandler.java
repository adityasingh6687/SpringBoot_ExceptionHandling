package in.boot.main.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value=NoSuchEmpExistsException.class)
//	@ResponseStatus(HttpStatus.CONFLICT)
//	@ResponseBody
     public ResponseEntity<ErrorResponse> handleNoSuchEmpExistException(NoSuchEmpExistsException ex)
     {
		ErrorResponse error = new ErrorResponse(HttpStatus.NOT_FOUND.value(),ex.getMessage());
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
     }
	  
	@ExceptionHandler(value=EmployeeAlreadyExistsException.class)
//	@ResponseStatus(HttpStatus.CONFLICT)
//	@ResponseBody
    public  ResponseEntity<ErrorResponse>handleEmployeeAlreadyExistsException(EmployeeAlreadyExistsException ex)
    {
		ErrorResponse error = new ErrorResponse(HttpStatus.NOT_FOUND.value(),ex.getMessage());
		return new ResponseEntity<>(error,HttpStatus.CONFLICT);
    }  
}
