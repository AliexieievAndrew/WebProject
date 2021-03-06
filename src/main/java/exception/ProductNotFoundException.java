package exception;

public class ProductNotFoundException extends Exception {

    private static final long serialVersionUID = 1L;
    private String message;

    public ProductNotFoundException(String message) {
        this.message = System.currentTimeMillis() +": " + message;
    }

    public ProductNotFoundException() {
        this("product is not available");
    }

    @Override
    public String getMessage() {
        return message;
    }
}
