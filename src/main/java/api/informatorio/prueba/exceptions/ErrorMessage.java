package api.informatorio.prueba.exceptions;
public class ErrorMessage {
    private String type;
    private String message;

    public ErrorMessage() {
    }
    public ErrorMessage(String type, String message) {
        this.type = type;
        this.message = message;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
