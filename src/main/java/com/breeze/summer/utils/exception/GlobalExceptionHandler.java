package com.breeze.summer.utils.exception;

import com.breeze.summer.dto.exception.ErrorResponse;
import com.breeze.summer.dto.exception.NotFoundException;
import com.breeze.summer.dto.exception.ServiceUnavailableException;
import com.breeze.summer.utils.log.Loggable;
import org.slf4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static com.breeze.summer.utils.exception.ErrorResponseUtil.badRequestResponse;
import static com.breeze.summer.utils.exception.ErrorResponseUtil.integrationErrorResponse;
import static com.breeze.summer.utils.exception.ErrorResponseUtil.internalServerErrorResponse;
import static com.breeze.summer.utils.exception.ErrorResponseUtil.notFoundResponse;

@ControllerAdvice
@Loggable
public class GlobalExceptionHandler {
  private Logger logger;

  @ExceptionHandler({ RuntimeException.class })
  public ResponseEntity<ErrorResponse> handleRuntimeException(RuntimeException e) {
    log(e);
    return internalServerErrorResponse();
  }

  @ExceptionHandler({ NotFoundException.class })
  public ResponseEntity<ErrorResponse> handleNotFoundException(Exception e) {
    log(e);
    return notFoundResponse();
  }

  @ExceptionHandler({ ServiceUnavailableException.class })
  public ResponseEntity<ErrorResponse> handleServiceUnavailableException(ServiceUnavailableException e) {
    log(e);
    return integrationErrorResponse(e.getMessage());
  }

  @ExceptionHandler({ MethodArgumentNotValidException.class })
  public ResponseEntity<ErrorResponse> validationException(MethodArgumentNotValidException e) {
    log(e);
    return badRequestResponse();
  }

  private void log(Exception e) {
    logger.warn("Exception while processing REST call: {} "
        + "To see full stacktrace enable DEBUG logging level.", e.getMessage());
    logger.debug("Exception details: ", e);
  }
}
