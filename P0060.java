/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p0060;

import java.util.Scanner;

/**
 *
 * @author Dell
 */
public class P0060 {
 static Scanner sc = new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    public static int checkInputNumber(){
        while (true) {            
            try {
                int n = Integer.parseInt(sc.nextLine());
                return n;
            } catch (NumberFormatException e) {
                System.err.print("It is not Integer!");
                System.out.println("Re-input");
            }
        }
    }
    public static int[] inputBills(){
        System.out.println("input number of bill:");
        int s =checkInputNumber();
        int[] numberOfBill = new int[s];
        for (int i = 0; i < numberOfBill.length; i++) {
            System.out.print("input value of bills"+(i+1)+" :");
            numberOfBill[i]=checkInputNumber();
        }
     return numberOfBill;
    }
    public static int checkWallet(){
            System.out.println("input value of wallet:");
            int wallet = checkInputNumber();
            return wallet;
    }
    public static int totalOfbills(int[]numberOfBill ){
      int total =0;
        for (int i = 0; i < numberOfBill.length; i++) {
            total += numberOfBill[i];
        }
      return total;
    }
    public static boolean compareElement(int total, int wallet){
            if (total<wallet) {
               return true; 
            } else {
                return false;
            }
    }        
    public static void display(int [] numberOfbill, int wallet){
        int total = totalOfbills(numberOfbill);
        System.out.println("this total of bill:"+total);
        if(compareElement(total, wallet)== true){
            System.out.println("you can buy it.");
    }
        else{
            System.out.println("you can't buy it");
        }
}
    public static void main(String[] args) { 
        System.out.println("======= Shopping program =======");
        int[] total = inputBills();
        int wallet = checkWallet();
        display(total, wallet);
        
        
    }
   
    
}
