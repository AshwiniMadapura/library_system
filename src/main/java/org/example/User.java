package org.example;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User {

    List<Book> availableBooks=new ArrayList<>();

    public Boolean validateUser() {
        Scanner input = new Scanner(System.in);
        String user, password;
        System.out.println("Enter your username: ");
        user=input.nextLine();

        System.out.println("Enter your password: ");
        password=input.nextLine();

        if (user.equals("user") && password.equals("pass")){
            System.out.println("Welcome user!");
            System.out.println("Press enter to view available books");
            String choice=input.nextLine();
            return true;
        }else {
            System.out.println("please enter correct credentials");
            return false;
        }
    }

    public void selectBook(){
        System.out.println("*******************************************");
        System.out.println("Please enter Book ID to lend any book");
        Scanner input = new Scanner(System.in);

       int bookId= Integer.parseInt(input.nextLine());


        try {
            ObjectMapper mapper=new ObjectMapper();
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            mapper.setVisibility(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));
            InputStream inputStream = new FileInputStream(new File("src/main/resources/books_data.json"));
            TypeReference<List<Book>> typeReference = new TypeReference<List<Book>>() {};
            List<Book> books=mapper.readValue(inputStream,typeReference);
            for (Book b:books){
                if (bookId== b.Number){
                    System.out.println("Book lent is---- "+b.Title+", written by -- "+b.Author);
                    b.setLent(true);
                    System.out.println("Press enter to view available books");
                    String choice=input.nextLine();
                }

                if (b.getLent()==false){
                    availableBooks.add(b);}
            }
            System.out.println("*****************************");
            System.out.println("Available books are");
            System.out.println("*****************************");
            for (Book b:availableBooks) {
                System.out.println("||Book Title--- " + b.getTitle() + " || Author --- " + b.getAuthor() + " || Genre --- " + b.getGenre() + " || Book ID---" + b.getNumber());
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

    }

}
