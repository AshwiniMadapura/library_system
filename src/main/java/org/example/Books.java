package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Books {

    public void displayBookDetails(){

        System.out.println("---------Available books are-------------");

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
