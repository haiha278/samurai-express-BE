package lg.cns.restaurent_management_system.exception;

import jakarta.servlet.http.HttpServletRequest;

import lg.cns.restaurent_management_system.response.errorResponse.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handlerResourceNotFoundException(ResourceNotFoundException e, HttpServletRequest httpServletRequest) {
        return new ResponseEntity<>(new ErrorResponse(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase(), e.getMessage(), httpServletRequest.getRequestURI()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ResourceIsNotCreatedException.class)
    public ResponseEntity<Object> handlerResourceIsNotCreatedException(ResourceIsNotCreatedException e, HttpServletRequest httpServletRequest) {
        return new ResponseEntity<>(new ErrorResponse(LocalDateTime.now(), HttpStatus.EXPECTATION_FAILED.value(), HttpStatus.EXPECTATION_FAILED.getReasonPhrase(), e.getMessage(), httpServletRequest.getRequestURI()), HttpStatus.EXPECTATION_FAILED);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handlerOthersException(Exception e, HttpServletRequest httpServletRequest) {
        return new ResponseEntity<>(new ErrorResponse(LocalDateTime.now(), HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), e.getMessage(), httpServletRequest.getRequestURI()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
