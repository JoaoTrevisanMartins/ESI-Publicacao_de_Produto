package Cadastrador;

public class Response {
    String message,status;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Response(String message, String status) {
        this.message = message;
        this.status = status;
    }

    public Response() {
    }
}
