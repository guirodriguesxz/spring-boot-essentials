package br.com.guilherme.spring_boot_essentials.handler;

import br.com.guilherme.spring_boot_essentials.exception.ErrorResponse;
import br.com.guilherme.spring_boot_essentials.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFoundException(NotFoundException ex) {
        // Criando o objeto de erro usando o Builder do Lombok
        ErrorResponse errorResponse = ErrorResponse.builder()
                .message(ex.getMessage())           // A mensagem que você definiu na Exception
                .status(HttpStatus.NOT_FOUND.value()) // Código 404/
                .build();

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    // DICA: É bom ter um handler genérico para outros erros (500)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneralException(Exception ex) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .message("Ocorreu um erro interno no servidor.")
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .build();

        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}