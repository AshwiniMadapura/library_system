package org.example;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import java.io.*;
import java.util.List;
import java.util.Scanner;

public class Books {


    public void displayBookDetails()  {

        System.out.println("---------Available books are-------------");

        try {
            ObjectMapper mapper=new ObjectMapper();
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            mapper.setVisibility(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));
            InputStream inputStream = new FileInputStream(new File("src/main/resources/books_data.json"));
            TypeReference<List<Book>> typeReference = new TypeReference<List<Book>>() {};
            List<Book> books=mapper.readValue(inputStream,typeReference);
            for (Book b:books){
                if (b.getLent()==false) {
                    System.out.println("||Book Title--- " + b.getTitle() + " || Author --- " + b.getAuthor() + " || Genre --- " + b.getGenre() + " || Book ID---" + b.getNumber());
                }
                }

        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (JsonParseException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        TypeReference<List<Book>> typeReference = new TypeReference<List<Book>>() {
        };

    }
}
