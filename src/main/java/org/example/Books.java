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

public class Books {


    public void displayBookDetails()  {

        System.out.println("---------Available books are-------------");
//        JSONParser jsonParser = new JSONParser();

        try {
            ObjectMapper mapper=new ObjectMapper();
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            mapper.setVisibility(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));
            InputStream inputStream = new FileInputStream(new File("src/main/resources/books_data.json"));
            TypeReference<List<Book>> typeReference = new TypeReference<List<Book>>() {};
            List<Book> books=mapper.readValue(inputStream,typeReference);
            for (Book b:books){
                System.out.println("Book Title is---- "+b.getTitle()+" Author is--- "+b.getAuthor());
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
//        ***************************************
//        JSONArray jsonarray = new JSONArray();
//        for (int i = 0; i < jsonarray.length(); i++) {
//            JSONObject jsonobject = jsonarray.getJSONObject(i);
//            String title = jsonobject.getString("Title");
//            String author = jsonobject.getString("Author");
//            System.out.println(title+author);
//        }
//        **********************************************
//        try (FileReader reader = new FileReader("books_data.json"))
//        {
//            //Read JSON file
//            Object obj = jsonParser.parse(reader);
//
//            JSONArray employeeList = (JSONArray) obj;
//            System.out.println(employeeList);
//
//            //Iterate over employee array
//            employeeList.forEach( book -> parseBookObject( (JSONObject) book ) );
//
//        }catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }


//        ***********************working csv file*************************
//
//        System.out.println("---------Available books are-------------");
//        ArrayList<String> colData = new ArrayList<>();
//        try (BufferedReader fileReader
//                     = new BufferedReader(new FileReader("src/main/resources/books_data.csv"))) {
//            String line = "";
//
//            //Read the file line by line
//            while ((line = fileReader.readLine()) != null) {
//                //Get all tokens available in line
//                String[] fields = line.split(" ,");
//
//                for (String field : fields) {
//                    System.out.println(field);
//                }
//                //Verify tokens
//                System.out.println();
//                System.out.println("Please type the book number to select book");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
