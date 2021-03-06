package com.linyunpeng.util;

import java.io.IOException;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

public class StringNullAdapter extends TypeAdapter {
       
    public String read(JsonReader reader) throws IOException {
        if (reader.peek() == JsonToken.NULL) {
            reader.nextNull();           
           return "";       
     }
        return reader.nextString();   
 }

    public void write(JsonWriter writer, Object value) throws IOException {
        if (value == null) {
            writer.value("");            
            return;       
         }
        writer.value((String) value);    
      }

}

