package com.breeze.summer.dto.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ErrorResponse {
  private String message;
  private String stringCode;

  public ErrorResponse(String message, String stringCode) {
    this.message = message;
    this.stringCode = stringCode;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getStringCode() {
    return stringCode;
  }

  public void setStringCode(String stringCode) {
    this.stringCode = stringCode;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((message == null) ? 0 : message.hashCode());
    result = prime * result + ((stringCode == null) ? 0 : stringCode.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    ErrorResponse other = (ErrorResponse) obj;
    if (message == null) {
      if (other.message != null)
        return false;
    } else if (!message.equals(other.message))
      return false;
    if (stringCode == null) {
      if (other.stringCode != null)
        return false;
    } else if (!stringCode.equals(other.stringCode))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "ErrorResponse [message=" + message + ", stringCode=" + stringCode + "]";
  }
}
