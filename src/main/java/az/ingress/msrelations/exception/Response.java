package az.ingress.msrelations.exception;

import org.springframework.http.HttpStatus;

public interface Response {
    String getKey();
    String getMessage();
    HttpStatus getHttpStatus();
}
