package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        User user=new User();
        Books books=new Books();
        Book book=new Book();
        boolean validate=user.validateUser();

        if (validate==true){
            books.displayBookDetails();
            user.selectBook();
            System.out.println("Book ID selecetd is"+user.getBookId());

//            if (book.getLent()==false){
//            books.displayBookDetails();}
        }

    }
}