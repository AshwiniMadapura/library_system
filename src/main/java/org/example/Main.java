package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        User user=new User();
        boolean validate=user.validateUser();
        if (validate==true){
            Books books=new Books();
            books.displayBookDetails();
            user.selectBook();
        }

    }
}