/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gravity;

import java.io.StringWriter;
import javax.json.Json;
import javax.json.JsonObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Figure {
    private JsonObject json;
     public Figure(JsonObject json) {
        this.json = json;
    }

    private  JSONObject getJson(Integer speed, Integer angle){
        //angle %= 180;
        final Double g = 9.80665;
        JSONObject obj = new JSONObject();
        JSONArray list = new JSONArray();
           //     System.out.println(speed + " " + angle + "    ***********************   " + time);

        Double max = Double.MIN_VALUE;
        Double sin = Math.sin(angle* Math.PI / 180);
        Double cos = Math.cos(angle* Math.PI / 180);
        Double time = 2.0 * speed * sin / g;
        int scale  = 1;
        for (double t = 0.0; t <= time; t += time/100){
            Double x = speed * t * cos;
            list.add(x);
            Double y = speed * t * sin - 0.5 * g * t * t;
            list.add(y);
            if (Math.abs(x) > max) max = Math.abs(x);
            if (Math.abs(y) > max) max = Math.abs(y);
            if (max > scale) scale *= 5;
        }
        obj.put("max",scale+1);
        obj.put("points", list);  
        return obj;
    }
     
     
    public String getJson() {
        StringWriter writer = new StringWriter();
        Json.createWriter(writer).write(json);
        Integer speed = Integer.parseInt(json.getString("speed"));
        Integer angle = Integer.parseInt(json.getString("angle"));
        JSONObject obj = getJson(speed,  angle);
        System.out.print(obj);
        return obj.toJSONString();
    }
    
    @Override
    public String toString() {
        StringWriter writer = new StringWriter();
        Json.createWriter(writer).write(json);
        return writer.toString();
    }
}
