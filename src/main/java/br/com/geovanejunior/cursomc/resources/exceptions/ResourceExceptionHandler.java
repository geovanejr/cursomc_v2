package br.com.geovanejunior.cursomc.resources.exceptions;

import br.com.geovanejunior.cursomc.service.exceptions.AutorizationException;
import br.com.geovanejunior.cursomc.service.exceptions.DataIntegrityException;
import br.com.geovanejunior.cursomc.service.exceptions.FileS3Exception;
import br.com.geovanejunior.cursomc.service.exceptions.ObjectNotFoundException;
import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {

        HttpStatus status = HttpStatus.NOT_FOUND;

        StandardError err = new StandardError(Instant.now(), status.value(), e.getMessage());

        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(DataIntegrityException.class)
    public ResponseEntity<StandardError> dataIntegrity(DataIntegrityException e, HttpServletRequest request) {

        HttpStatus status = HttpStatus.BAD_REQUEST;

        StandardError err = new StandardError(Instant.now(), status.value(), e.getMessage());

        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> validation(MethodArgumentNotValidException e, HttpServletRequest request) {

        HttpStatus status = HttpStatus.BAD_REQUEST;

        ValidationError err = new ValidationError(Instant.now(), status.value(), "Erro de validação");

        for (FieldError x : e.getBindingResult().getFieldErrors() ) {
            err.addError(x.getField(), x.getDefaultMessage());
        }

        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(AutorizationException.class)
    public ResponseEntity<StandardError> autorizationException(AutorizationException e, HttpServletRequest request) {

        HttpStatus status = HttpStatus.FORBIDDEN;

        StandardError err = new StandardError(Instant.now(), status.value(), e.getMessage());

        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(FileS3Exception.class)
    public ResponseEntity<StandardError> autorizationException(FileS3Exception e, HttpServletRequest request) {

        HttpStatus status = HttpStatus.BAD_REQUEST;

        StandardError err = new StandardError(Instant.now(), status.value(), e.getMessage());

        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(AmazonServiceException.class)
    public ResponseEntity<StandardError> amazonServiceException(AmazonServiceException e, HttpServletRequest request) {

        HttpStatus status = HttpStatus.valueOf(e.getErrorCode());

        StandardError err = new StandardError(Instant.now(), status.value(), e.getMessage());

        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(AmazonClientException.class)
    public ResponseEntity<StandardError> amazonClientException(AmazonClientException e, HttpServletRequest request) {

        HttpStatus status = HttpStatus.BAD_REQUEST;

        StandardError err = new StandardError(Instant.now(), status.value(), e.getMessage());

        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(AmazonS3Exception.class)
    public ResponseEntity<StandardError> amazonS3Exception(AmazonS3Exception e, HttpServletRequest request) {

        HttpStatus status = HttpStatus.BAD_REQUEST;

        StandardError err = new StandardError(Instant.now(), status.value(), e.getMessage());

        return ResponseEntity.status(status).body(err);
    }
}
