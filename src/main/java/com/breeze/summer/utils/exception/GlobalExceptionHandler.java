package com.breeze.summer.utils.exception;

import com.breeze.summer.utils.log.Loggable;
import org.slf4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static com.breeze.summer.utils.exception.ErrorResponseUtil.badRequestResponse;

@RestControllerAdvice
@Loggable
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
  private Logger logger;
  /*
   * @ExceptionHandler({ RuntimeException.class })
   * public ResponseEntity<ErrorResponse> handleRuntimeException(RuntimeException
   * e) {
   * log(e);
   * return internalServerErrorResponse();
   * }
   * 
   * @ExceptionHandler({ NotFoundException.class })
   * public ResponseEntity<ErrorResponse> handleNotFoundException(Exception e) {
   * log(e);
   * return notFoundResponse();
   * }
   * 
   * @ExceptionHandler({ ServiceUnavailableException.class })
   * public ResponseEntity<ErrorResponse>
   * handleServiceUnavailableException(ServiceUnavailableException e) {
   * log(e);
   * return integrationErrorResponse(e.getMessage());
   * }
   */

  @Override
  @ResponseStatus
  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException e, HttpHeaders headers,
      HttpStatus status, WebRequest request) {
    /*
     * for (ObjectError methodArgumentNotValidException :
     * ex.getBindingResult().getAllErrors()){
     * localerrorEntitiesList.add(new
     * ErrorEntity(methodArgumentNotValidException.getDefaultMessage(),
     * methodArgumentNotValidException.getCode()));
     * }
     */

    try {
      log(e);
      return badRequestResponse();
    } catch (Exception ex) {
      log(ex);
      return badRequestResponse();
    }

  }
  /*
   * @Override
   * 
   * @ExceptionHandler({ MethodArgumentNotValidException.class })
   * public ResponseEntity<Object>
   * validationException(MethodArgumentNotValidException e) {
   * log(e);
   * return badRequestResponse();
   * }
   */

  private void log(Exception e) {
    logger.warn("Exception while processing REST call: {} "
        + "To see full stacktrace enable DEBUG logging level.", e.getMessage());
    logger.debug("Exception details: ", e);
  }
}
