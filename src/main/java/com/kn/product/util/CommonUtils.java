package com.kn.product.util;

import java.sql.Blob;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.serial.SerialBlob;

public class CommonUtils {

  public static Blob convertBytesToBlob(byte[] byteArr) {
    Blob blob = null;
    try {
      blob = new SerialBlob(byteArr);

    } catch (SQLException e) {
      e.printStackTrace();
    }
    return blob;
  }


  /**
   * This method will return the application URL with context path.
   * 
   * @param request the HttpServletRequest object
   * 
   * @return String the application URL
   */
  public static String getAppUrl(HttpServletRequest request) {
    return "https://" + request.getServerName() + ":" + request.getServerPort()
        + request.getContextPath();
  }

}