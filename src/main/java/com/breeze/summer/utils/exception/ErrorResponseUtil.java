package com.breeze.summer.utils.exception;

import com.breeze.summer.dto.exception.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ErrorResponseUtil {
  public ErrorResponseUtil() {
  }

  public static ResponseEntity<Object> badRequestResponse() {
    return buildErrorResponse(HttpStatus.BAD_REQUEST, "One of parameters is missing or invalid", "REQUEST_ERROR");
  }

  public static ResponseEntity<Object> badRequestResponse(String errorMessage) {
    return buildErrorResponse(HttpStatus.BAD_REQUEST, errorMessage, "REQUEST_ERROR");
  }

  public static ResponseEntity<Object> unauthorizedResponse() {
    return buildErrorResponse(HttpStatus.UNAUTHORIZED, "Authorization header missing or " + "invalid", "AUTH_ERROR");
  }

  public static ResponseEntity<Object> forbiddenResponse() {
    return buildErrorResponse(HttpStatus.FORBIDDEN, "Current user is not permitted to "
        + "access this functionality", "ACCESS_ERROR");
  }

  public static ResponseEntity<Object> notFoundResponse() {
    return buildErrorResponse(HttpStatus.NOT_FOUND, "Requested result cannot be found by"
        + " given parameters", "NOT_FOUND");
  }

  public static ResponseEntity<Object> integrationErrorResponse(String message) {
    return buildErrorResponse(HttpStatus.CONFLICT, message, "SERVICE_ERROR");
  }

  public static ResponseEntity<Object> internalServerErrorResponse() {
    return buildErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Unexpected internal seriver error"
        + " when processing the request", "INTERNAL_SERVER_ERROR");
  }

  public static ResponseEntity<Object> serviceUnavailableResponse() {
    return buildErrorResponse(HttpStatus.SERVICE_UNAVAILABLE, "Service temporary unavailable",
        "SERVICE_TEMPORARY_UNAVAILABLE");
  }

  private static ResponseEntity<Object> buildErrorResponse(HttpStatus httpStatus, String message,
      String stringCode) {
    return ResponseEntity.status(httpStatus.value()).body(new ErrorResponse(message, stringCode));
  }
}
