package com.example.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Pick a month. Your options are: ");
        for (Month month : Month.values()) {
            System.out.print(month.getEnglishName() + ", ");
        }
        System.out.println();

        String newMonth = scan.nextLine().toUpperCase();
        int chosenMonthInt = convertToEnumOrdinal(newMonth);

        if (chosenMonthInt == -1) {
            System.out.println("INVALID INPUT. TRY AGAIN.");
        } else {
            ArrayList<Month> chosenMonthAndAfter = new ArrayList<>();

            for (Month month : Month.values()) {
                if (month.ordinal() >= chosenMonthInt) {
                    chosenMonthAndAfter.add(month);
                }
            }

            System.out.println("Your chosen month was " + chosenMonthAndAfter.get(0).getEnglishName());
            System.out.println("The months following it is/are: ");

            if (chosenMonthAndAfter.size() == 1){
                System.out.println("There are no more months after December");
            } else {
                for (int i = 1; i < chosenMonthAndAfter.size(); i++) {
                    System.out.print(chosenMonthAndAfter.get(i).getEnglishName() + ", ");
                }
            }
        }
        
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File("May.json"), Month.MAY);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int convertToEnumOrdinal(String month) {
        switch (month) {
            case "JANUARY":
                return 0;
            case "FEBRUARY":
                return 1;
            case "MARCH":
                return 2;
            case "APRIL":
                return 3;
            case "MAY":
                return 4;
            case "JUNE":
                return 5;
            case "JULY":
                return 6;
            case "AUGUST":
                return 7;
            case "SEPTEMBER":
                return 8;
            case "OCTOBER":
                return 9;
            case "NOVEMBER":
                return 10;
            case "DECEMBER":
                return 11;
            default:
                return -1;
        }
    }
}
