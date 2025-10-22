/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ojt.javaojt.validate_menu;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
//import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.sql.Date;


public class Validation {

    public static Scanner sc = new Scanner(System.in);

    public static String checkInputString() {
        while (true) {
            String value = sc.nextLine();
            if (value.isEmpty()) {
                System.err.println("Not Empty!");
                System.out.print("Input again: ");
            } else {
                return value.trim();
            }
        }
    }

    public static int checkInputIntToArr() {
        while (true) {
            try {
                int num = Integer.parseInt(sc.nextLine());
                if (num <= 0) {
                    throw new NumberFormatException();
                } else {
                    return num;
                }
            } catch (Exception e) {
                System.err.println("Must be Input Integer and Positive!");
                System.out.print("Input again: ");
            }
        }

    }

    public static int checkInputIntLimit(int min, int max) {
        while (true) {
            try {
                int num = Integer.parseInt(sc.nextLine());
                if (num < min || num > max) {
                    throw new NumberFormatException();
                } else {
                    return num;
                }
            } catch (Exception e) {
                System.err.println("Input number must be in " + min + " to " + max + "!");
                System.out.print("Input again: ");
            }
        }
    }

    public static float checkInputFloat() {
        while (true) {
            try {
                float num = Float.parseFloat(sc.nextLine());
//                System.out.println("");
                return num;
            } catch (Exception e) {
                System.err.println("Input must be number!");
                System.out.print("Enter again: ");
            }
        }
    }

    public static int checkInputInt() {
        while (true) {
            try {
                int num = Integer.parseInt(sc.nextLine());
                return num;
            } catch (Exception e) {
                System.err.println("Input must be number!");
                System.out.print("Enter again: ");
            }
        }
    }

    public static double checkInputDouble() {
        while (true) {
            try {
                double num = Double.parseDouble(sc.nextLine());
                return num;
            } catch (Exception e) {
                System.err.println("Input must be number!");
                System.out.print("Enter again: ");
            }
        }
    }

    public static double checkInputDoubleToArr() {
        while (true) {
            try {
                double num = Double.parseDouble(sc.nextLine());
                if (num <= 0) {
                    throw new NumberFormatException();
                } else {
                    return num;
                }
            } catch (Exception e) {
                System.err.println("Must be Input Integer and Positive!");
                System.out.print("Input again: ");
            }
        }

    }

  
    
    public  static String checkInputEmail2(){
         while(true){
             try {
                 String regex = "^[A-Za-z0-9+_.-]+@gmail.com+$";
                 String email= sc.nextLine();
                 if(!email.matches(regex)){
                     throw new Exception();
                 }else{
                     return email;
                 }
                         
             }catch (Exception e) {
                System.err.println("Wrong type Email!");
                System.out.print("Input again: ");
            }
         }
    }
    
    
    
//    public static String checkInputCodeStudent(ArrayList<Student> std) {
//        String code = checkInputString();
//
//        try {
//            while (true) {
//                boolean isDuplicate = false;
//                for (int i = 0; i < std.size(); i++) {
//                    if (std.get(i).getId().equals(code)) {
//                        isDuplicate = true;
//                        System.err.println("This code had available!");
//                        System.out.print("Enter again: ");
//                        code = checkInputString();
//                    }
//                }
//                if (!isDuplicate) {
//                    break;
//                }
//            }
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//
//        return code;
//    }


    public static boolean checkInputYN() {
        System.out.print("Do you want to continue(Y/N): ");
        while (true) {
            String result = checkInputString();
            if (result.equalsIgnoreCase("Y")) {
                return true;
            }
            if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.err.println("Please input Y/N.");
            System.out.print("Enter again: ");
        }
    }

    public static String checkInput2Type(String a, String b) {
        while (true) {
            String result = checkInputString();
            if (result.equalsIgnoreCase(a)) {
                return a;
            }
            if (result.equalsIgnoreCase(b)) {
                return b;
            }
            System.err.println("Please input " + a + " or " + b + ".");
            System.out.print("Enter again: ");
        }
    }

    public static char checkInputUD() {
        while (true) {
            String result = checkInputString();
            if (result.equalsIgnoreCase("U")) {
                return 'U';
            }
            if (result.equalsIgnoreCase("D")) {
                return 'D';
            }
            System.err.println("Please input Update(U) or Delete(D).");
            System.out.print("Enter again: ");
        }
    }

    public static String checkNameCourse() {
        while (true) {
            String value = checkInputString();

            if (value.equalsIgnoreCase("Java")) {
                return "Java";
            } else if (value.equalsIgnoreCase(".Net")) {
                return ".Net";
            } else if (value.equalsIgnoreCase("C") || value.equalsIgnoreCase("C++") || value.equalsIgnoreCase("C/C++")) {
                return "C/C++";
            } else {
                System.err.println("Course must be Java or .Net or C/C++!");
                System.out.print("Enter again: ");
            }
        }
    }

    public static String formatDateVstring(String patternDate) {
        System.out.print("Input Date in Form (" + patternDate + "): ");
        while (true) {
            SimpleDateFormat formatDate = new SimpleDateFormat(patternDate);
            formatDate.setLenient(false);
            try {
                Date date = (Date) formatDate.parse(checkInputString());
                String formattedDate = formatDate.format(date);
                return formattedDate;
            } catch (Exception e) {
                System.err.println("Invalue, Format '" + patternDate + "'!");
                System.out.print("Enter again: ");

            }
        }

    }

//    public static String formatDateVstringLargeToday(String patternDate) {
//        System.out.print("Input Date in Form (" + patternDate + "): ");
//        while (true) {
//            SimpleDateFormat formatDate = new SimpleDateFormat(patternDate);
//            formatDate.setLenient(false);
//            try {
//                Date date = (Date) formatDate.parse(checkInputString());
//                Date today = new Date();
//                if (date.compareTo(today) > 0) {
//                    String formattedDate = formatDate.format(date);
//                    return formattedDate;
//                } else if (date.compareTo(today) == 0) {
//                    System.err.println("Can't happen.");
//                    System.out.print("Input again: ");
//                } else {
//                    System.err.println("Input Date in the Past.");
//                    System.out.print("Input again: ");
//                }
//            } catch (Exception e) {
//                System.err.println("Invalue, Format '" + patternDate + "'!");
//                System.out.print("Enter again: ");
//
//            }
//        }
//
//    }

    //w6
    public static Date checkInputDate(String min, String max) throws ParseException {
        SimpleDateFormat type = new SimpleDateFormat("dd/MM/yyyy");
        type.setLenient(false);

        java.util.Date minDate = null;
        java.util.Date maxDate = null;
        
         try {
            minDate = type.parse(min);
            // nếu max bị null hoặc rỗng thì lấy ngày hiện tại
            if (max == null || max.isEmpty()) {
                maxDate = new java.util.Date();
            } else {
                maxDate = type.parse(max);
            }
        } catch (ParseException e) {
            System.err.println("⚠️ Lỗi định dạng min hoặc max ngày!");
            return null;
        }
        while (true) {
           
            try {
                java.util.Date utilDate = type.parse(sc.nextLine());
                if (utilDate.before(minDate) || utilDate.after(maxDate)) {
                    throw new Exception();
                }else
                return new java.sql.Date(utilDate.getTime());
            } catch (Exception e) {
                System.err.println("This date invalid or unabailable! ");
                System.out.print("Please enter again: ");
            }
        }
    }
    
    public static Date checkInputDate() throws ParseException {
        while (true) {
            SimpleDateFormat type = new SimpleDateFormat("dd/MM/yyyy");
            type.setLenient(false);
            try {
                java.util.Date utilDate = type.parse(sc.nextLine());
                return new java.sql.Date(utilDate.getTime());
            } catch (Exception e) {
                System.err.println("This date invalid or unabailable! ");
                System.out.print("Please enter again: ");
            }
        }
    }

    public static String formPhone(String... listPhone) {
        while (true) {
            try {
                String phone = checkInputString();
                for (String string : listPhone) {
                    if (string.equals(phone)) {
                        return phone;
                    }
                }
                throw new Exception();
            } catch (Exception e) {
                System.err.println("Please input Phone flow: ");
                for (String string : listPhone) {
                    System.err.println(" >>  " + string);
                }
                System.out.print("Enter again: ");
            }
        }
    }

    public static String LimitQuanNumber(int number) {
        while (true) {
            try {
                String value = checkInputString();
                if (value.matches("\\d{" + number + "}")) {
                    return value;
                }
                throw new Exception();
            } catch (Exception e) {
                System.out.println("Please input " + number + " number!");
                System.out.print("Enter again: ");
            }
        }
    }

    public static String checkInputEmail() {
        while (true) {            
            try {
                String value = checkInputString();
                if (value.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
                    return value;
                } else throw new Exception();
            } catch (Exception e) {
                System.out.println("Please input ");
            }
        }
    }
}
