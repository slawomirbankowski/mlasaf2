/*
  Author(s): Slawomir Bankowski
  Project: mlasaf
*/
package com.mlasaf.rest

import java.io.{BufferedReader, BufferedWriter, InputStreamReader, OutputStreamWriter}

/** client for REST servers */
class RestClient(address : String) {


  def sendRequest(reqMethod : String, reqBody : String, timeout : Int) : String = {
    var url : java.net.URL = new java.net.URL(address);
    val conn : java.net.HttpURLConnection = url.openConnection().asInstanceOf[java.net.HttpURLConnection];
    conn.setReadTimeout(timeout);
    conn.setDoOutput(true);
    conn.setDoInput(true);
    conn.setRequestMethod(reqMethod);
    conn.setRequestProperty("Content-Type", "application/json");
    conn.setRequestProperty("User-Agent", "Mozilla/5.0");
    conn.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
    conn.setRequestProperty("accept", "application/json");
    if (reqMethod.equals("POST")) {
      val writer = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream));
      writer.write(reqBody);
      writer.flush();
      writer.close();
    }
    val resCode = conn.getResponseCode;
    val buff = new StringBuilder();
    val reader = new BufferedReader(new InputStreamReader(conn.getInputStream));
    var line = reader.readLine();
    while (line != null) {
      buff.append(line);
      line = reader.readLine();
    }
    buff.toString();
  }


}
