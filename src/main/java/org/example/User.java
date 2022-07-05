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
import java.util.List;
import java.util.Scanner;

public class User {
    int bookId;

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

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

        bookId= Integer.parseInt(input.nextLine());


        try {
            ObjectMapper mapper=new ObjectMapper();
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            mapper.setVisibility(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));
            InputStream inputStream = new FileInputStream(new File("src/main/resources/books_data.json"));
            TypeReference<List<Book>> typeReference = new TypeReference<List<Book>>() {};
            List<Book> books=mapper.readValue(inputStream,typeReference);
            for (Book b:books){
                if (bookId== b.Number){
                    System.out.println("Book selected is---- "+b.Title+", written by -- "+b.Author);
                    b.setLent(true);
                    System.out.println(b.getLent());
//                    System.out.println("Press enter to view available books");
//                    String choice=input.nextLine();

//                    to add selected item in new json file
//                    JSONObject lentBookDetails = new JSONObject();
//                    lentBookDetails.put("Title", b.Title);
//                    lentBookDetails.put("Author", b.Author);
//                    lentBookDetails.put("Genre", b.Genre);
//                    lentBookDetails.put("Publisher", b.Publisher);
//                    lentBookDetails.put("Number", b.Number);
//                    lentBookDetails.put("SubGenre", b.SubGenre);
//
//                    //Add lent books to list
//                    JSONArray lentBookList = new JSONArray();
//                    lentBookList.add(lentBookDetails);
//                    //Write JSON file
//                    try (FileWriter file = new FileWriter("src/main/resources/loan.json")) {
//                        //We can write any JSONArray or JSONObject instance to the file
//                        file.write(lentBookList.toJSONString());
//                        file.flush();
//
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }


                }
                System.out.println(b.getLent() +"selected"+ b.Title);

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
