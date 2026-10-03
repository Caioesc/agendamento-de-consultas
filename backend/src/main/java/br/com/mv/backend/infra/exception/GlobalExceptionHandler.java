package br.com.mv.backend.infra.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity tratarErro404(){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(RegraDeNegocioException.class)
    public ResponseEntity<String> tratarErroRegraDeNegocio(RegraDeNegocioException exception) {
        return ResponseEntity.badRequest().body(exception.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity tratarErroValidacao(MethodArgumentNotValidException exception){
        var erros = exception.getFieldErrors();

        var dadosErroValidacao = erros.stream().map(DadosErroValidacao::new).toList();

        return ResponseEntity.badRequest().body(dadosErroValidacao);
    }

    private record DadosErroValidacao(String campo, String mensagem){

        public DadosErroValidacao(FieldError erro){
            this(erro.getField(), erro.getDefaultMessage());
        }
    }
}
