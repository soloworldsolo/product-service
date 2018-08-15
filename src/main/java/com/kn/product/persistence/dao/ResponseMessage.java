package com.kn.product.persistence.dao;


//TODO move this to dto directory
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