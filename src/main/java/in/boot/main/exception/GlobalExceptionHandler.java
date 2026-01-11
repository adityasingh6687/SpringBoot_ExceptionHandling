package in.boot.main.exception;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

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
	
	@ExceptionHandler(value=MethodArgumentNotValidException.class)
     public ResponseEntity<Map<String,String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex)
     {
		Map<String,String> errors = new HashMap<>();
        BindingResult bindingResult = ex.getBindingResult();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        for(FieldError error : fieldErrors)
        {
        	    errors.put(error.getField(), error.getDefaultMessage());
        }
		return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
     }
	
	@ExceptionHandler(value=Exception.class)
     public ResponseEntity<ErrorResponse> handleException(Exception ex)
     {
		ErrorResponse error = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),ex.getMessage());
		return new ResponseEntity<>(error,HttpStatus.INTERNAL_SERVER_ERROR);
     }
	
	
}
