package com.company;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {

    public static void main(String[] args) {
	// write your code here
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://community-open-weather-map.p.rapidapi.com/find?q=london&cnt=1&mode=null&lon=0&type=link%2C%20accurate&lat=0&units=imperial%2C%20metric"))
                    .header("x-rapidapi-key", "dce3abc61cmsh4157b9b27fee1ecp148432jsna06f64aac9b3")
                    .header("x-rapidapi-host", "community-open-weather-map.p.rapidapi.com")
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
            System.out.println();

            JSONObject obj = new JSONObject(response.body());

            System.out.println(obj.getString("message")); //John
            System.out.println(obj.getString("cod")); //John
            System.out.println(obj.getInt("count")); //John

            var objProp = obj.getJSONArray("list");

            JSONArray jsonarray = new JSONArray(objProp);

            for (int i = 0; i < jsonarray.length(); i++) {
                JSONObject jsonobject = jsonarray.getJSONObject(0);

             //   System.out.println(jsonobject);

                Integer name = jsonobject.getInt("dt");
                String url = jsonobject.getString("rain");

                System.out.println(" DT - " + name);
                System.out.println("  - " + name);

            }


           // System.out.println(objProp); //John

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //System.out.println("Testing Open Weather API..");
    }
}

