package sa.m.ntd.calculator.repo;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import lombok.Builder;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.data.repository.support.QueryMethodParameterConversionException;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.Set;

/**
 *
 * @author msa
 */
@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {

    @Builder
    private record InvalidatedParams (String cause, String attribute) {}

    @ExceptionHandler(ConstraintViolationException.class)
    ProblemDetail handleConstraintViolationException(ConstraintViolationException e) {
        Set<ConstraintViolation<?>> errors = e.getConstraintViolations();
        List<InvalidatedParams> validationResponse = errors.stream()
                .map(err -> InvalidatedParams.builder()
                        .cause(err.getMessage())
                        .attribute(err.getPropertyPath().toString())
                        .build()
                ).toList();

        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(400), "Request validation failed");
        problemDetail.setTitle("Validation Failed");
        problemDetail.setProperty("invalidParams", validationResponse);
        return problemDetail;
    }
    
    // security: do not leak error info! QueryMethodParameterConversionException
    @ExceptionHandler(IllegalArgumentException.class)
    protected ResponseEntity<Exception> handleIllegalArgumentException(IllegalArgumentException ex) {
        return new ResponseEntity<>(new Exception("invalid request"), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
        
    @ExceptionHandler(QueryMethodParameterConversionException.class)
    protected ResponseEntity<Exception> handleQueryMethodParameterConversionException(QueryMethodParameterConversionException ex) {
        return new ResponseEntity<>(new Exception("invalid request"), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
    
}
