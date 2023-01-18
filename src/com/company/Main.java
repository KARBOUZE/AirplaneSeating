package com.company;

import com.company.Audiences.Audience;
import com.company.Audiences.SeatAudiences;

import java.util.Scanner;

public class Main {

    //private  static int i=0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String firstName;
        String lastName;
        String email;
        String phoneNumber;
	    // add passengers
        for(int i=0;i<37;i++){
            System.out.println("Enter your first name: ");
            firstName = sc.nextLine();
            if(!firstName.isEmpty()) {
                System.out.println("Enter your last name: ");
                lastName = sc.nextLine();
                if (!lastName.isEmpty()) {
                    System.out.println("Enter your email: ");
                    email = sc.nextLine();
                    if (!email.isEmpty()) {
                        System.out.println("Enter your phone number: ");
                        phoneNumber = sc.nextLine();
                        if (!phoneNumber.isEmpty()) {
                            Audience audience = new Audience(firstName, lastName, email, phoneNumber);
                            SeatAudiences stAd = new SeatAudiences();
                            stAd.addSeatAudiences(audience);
                            int n = showPassenger();
                            if(n == -1){break;}
                        }
                    }
                }
            }
        }

        showPassenger();

    }

    public static int showPassenger(){
        Scanner sc = new Scanner(System.in);
        int nb;
        System.out.println("Enter 0 if you want to see a list of passenger information with their place numbers and continue adding passengers or enter -1 to see a list of passenger without continue or  enter another number to continue adding passengers: ");
        // reading the complete line for the integer
        // and converting it to an integer
        nb = Integer.parseInt(sc.nextLine());
        if (nb == 0) {
            SeatAudiences.showListPassenger();
        }else if(nb == -1) {
            return -1;
        }
        return 1;
    }
}
