package com.ojt.testjdbc.model;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuV1 {

    private ArrayList listMenus = new ArrayList<>();

    public MenuV1() {
    }

    public void addMenu(String menu) {
        listMenus.add(menu);
    }

    public int printMenu(String menu) {
        System.out.println(menu);

        for (int i = 0; i < listMenus.size(); i++) {
            System.out.println((i + 1) + " " + listMenus.get(i));

            if (listMenus.size() - 1 == i) {
                System.out.println((listMenus.size() + 1) + " Exit!");
            }
        }

        System.out.print("Choose function: ");
        int choice = checkValue(1, listMenus.size() + 1);
        return choice;
    }

    private int checkValue(int min, int max) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                int choice = Integer.parseInt(sc.nextLine());
                if (choice < min || choice > max) {
                    throw new NumberFormatException();
                } else {
                    return choice;
                }

            } catch (NumberFormatException e) {
                System.out.print("Input again: ");
            }
        }
    }

    public static void main(String[] args) {
        start();
    }

    public static void start() {
        int choice;
        MenuV1 menu = new MenuV1();
        menu.addMenu("lan 1");
        menu.addMenu("Lan 2");
        while (true) {            
            choice = menu.printMenu("LIST");
            switch (choice) {
                case 1:
                    
                    break;
                default:
                    throw new AssertionError();
            }
        }
    }
}
