package in.boot.main.exception;


public class EmployeeAlreadyExistsException extends RuntimeException{
	
     public EmployeeAlreadyExistsException(String message)
     {
    	   super(message);
     }

}
