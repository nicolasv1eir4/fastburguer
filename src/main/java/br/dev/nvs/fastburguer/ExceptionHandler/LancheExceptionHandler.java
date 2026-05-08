
package br.dev.nvs.fastburguer.ExceptionHandler;

import java.util.Map;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class LancheExceptionHandler {
    
   @ExceptionHandler(Exception.class) 
    public Map<String, String> erro(Exception e) {
        return Map.of("erro", e.getMessage());
    }
}