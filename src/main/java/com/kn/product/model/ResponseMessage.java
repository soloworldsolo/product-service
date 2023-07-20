package com.kn.product.model;



public class ResponseMessage {

  private String responseStatus;



  public ResponseMessage() {



  }



  public ResponseMessage(String msg) {

    this.responseStatus = msg;

  }



  public String getResponseStatus() {

    return responseStatus;

  }



  public void setResponseStatus(String responseStatus) {

    this.responseStatus = responseStatus;

  }



}