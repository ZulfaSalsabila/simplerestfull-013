/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PWS.Project3;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author ROG
 */
@ControllerAdvice
public class ProductExceptionController extends RuntimeException {
    private static final long serialVersionUID=1L;
    
    //fungsi memunculkan pesan exception
    @ExceptionHandler(value=ProductNotfoundException.class)
    public ResponseEntity<Object>exception(ProductNotfoundException exception){
        return new ResponseEntity<>("Product not found",HttpStatus.NOT_FOUND);
    }
}
