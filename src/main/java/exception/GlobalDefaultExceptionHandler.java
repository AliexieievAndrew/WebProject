package exception;

import org.springframework.security.web.access.ExceptionTranslationFilter;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.nio.file.AccessDeniedException;

// in the WebConfig added to @ComponentScan
@ControllerAdvice
public class GlobalDefaultExceptionHandler {

    // catching 404 error
    @ExceptionHandler(NoHandlerFoundException.class)
    public String handlerNoHandlerFoundException(Model model){
        model.addAttribute("errorTitle", "Page is not constructed");
        model.addAttribute("errorDescription","The page you are looking for is not available now :(");
        model.addAttribute("title", "404 error page");
        return "error";
    }

    // catching ProductNotFoundException
    @ExceptionHandler(ProductNotFoundException.class)
    public String handlerProductNotFoundException(Model model){
        model.addAttribute("errorTitle", "Product not found");
        model.addAttribute("errorDescription","The product you are looking for is not available now :(");
        model.addAttribute("title", "Product not found");
        return "error";
    }

    // catching other Exceptions
    @ExceptionHandler(Exception.class)
    public String handlerException(Model model, Exception ex){
        model.addAttribute("errorTitle", "Something was wrong!");
        model.addAttribute("errorDescription",
                "something went wrong and we will fix it soon :("
                + ex.toString());
        model.addAttribute("title", "Error");
        return "error";
    }
}
