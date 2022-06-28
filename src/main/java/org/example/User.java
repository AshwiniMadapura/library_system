package org.example;

import java.util.Scanner;

public class User {
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
}
