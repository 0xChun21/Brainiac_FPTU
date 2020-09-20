/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expense;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Dell
 */
public class Expense {

    static Scanner sc = new Scanner(System.in);

    public static int checkInputChoice(int min, int max) {
        while (true) {
            try {
                int n = Integer.parseInt(sc.nextLine());
                if (n < min || n > max) {
                    throw new NumberFormatException();
                }
                return n;
            } catch (NumberFormatException e) {
                System.out.println("Eror! Re-input your choice");
            }
        }
    }

    public static int checkInputInteger() {
        while (true) {
            try {
                int n = Integer.parseInt(sc.nextLine());
                return n;
            } catch (NumberFormatException e) {
                System.err.print("Eror! Re-input");
            }
        }
    }

    public static double checkInputDoble() {
        while (true) {
            try {
                double n = Double.parseDouble(sc.nextLine());
                return n;
            } catch (NumberFormatException e) {
                System.err.print("Error! Re-input");
            }

        }
    }

    public static String checkInputString() {
        while (true) {
            String n = sc.nextLine();
            if (n.isEmpty()) {
                System.err.println("Error! Re_input");
            } else {
                return n;
            }
        }
    }

    public static String checkDate() {
        while (true) {
            String d = sc.nextLine().trim();
            SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
            df.setLenient(false);
            try {
                df.parse(d);
                return d;
            } catch (Exception e) {
                System.err.println("Invalid date");
            }
        }
    }

    public static void addElements(ArrayList<Maneger> o, int id) {
        System.out.print("Enter Date:");
        String date = checkDate();
        System.out.print("Enter Amount:");
        int amount = checkInputInteger();
        System.out.print("Enter Content:");
        String content = checkInputString();
        o.add(new Maneger(id, date, amount, content));

    }

    public static void displayElements(ArrayList<Maneger> o) {
        if (o.size() == 0) {
            System.err.println("Error! no Element in here");
        }
        double total = 0;
        System.out.println("-------Display all expenses-------");
        System.out.printf("%7s%20s%20s%20s\n", "ID", "Date", "Amount", "Content");
        for (int i = 0; i < o.size(); i++) {
            System.out.printf("%7d%20s%20f%20s\n",o.get(i).getID(),o.get(i).getDate(),o.get(i).getNumber(),o.get(i).getContent());
            total += o.get(i).getNumber();
        }
        System.out.println("");
        System.out.print("Total:"+total);
        System.out.println("");
    }

    public static boolean checkID(ArrayList<Maneger> o, int id) {
        for (int i = 0; i < o.size(); i++) {
            if (o.get(i).getID() == id) {
                return true;
            }
        }
        return false;
    }

    public static void deleteElements(ArrayList<Maneger> o) {
        System.out.println("Enter Id check: ");
        int id = checkInputInteger();
        for (int i = 0; i < o.size(); i++) {
            if (o.get(i).getID()==id) {
                o.remove(i);
                System.out.println("delete susscesful!");
                break;
            } else {
                System.out.println("delete fail");
            }
  
        }
        
    }

    public static void displayResult() {
        ArrayList<Maneger> o = new ArrayList<>();
        int id = 0;
        while (true) {
            System.out.println("=======Handy Expense program=======");
            System.out.println("1. Add an expense");
            System.out.println("2. Display all expenses");
            System.out.println("3. Delete an expense");
            System.out.println("4. Quit");
            System.out.print("Your choice:");
            int choice = checkInputChoice(1, 4);
            switch (choice) {
                case 1:
                    addElements(o, ++id);
                    break;
                case 2:
                    displayElements(o);
                    break;
                case 3:
                    deleteElements(o);
                    break;
                case 4:
                    return;
            }
        }
    }

    public static void main(String[] args) throws IOException{
        displayResult();
    }
}
