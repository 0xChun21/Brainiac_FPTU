
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author trinh
 */
public class Option implements IOption {

    @Override
    public void display(ArrayList<Expense> list) {
        System.out.printf("%2s%20s%20s%20s", "ID", "Date", "Amount", "Content\n");
        for (Expense o : list) {
            System.out.println(o);
        }
    }

    @Override
    public void add(ArrayList<Expense> list) {
        Validate v = new Validate();
        Scanner sc = new Scanner(System.in);
        String date = v.getDate();
        System.out.print("input amount: ");
        double amount = Double.parseDouble(sc.nextLine());
        System.out.print("input content: ");
        String content = sc.nextLine();

        int last = list.size() - 1;
        int id;
        if (last == -1) {
            id = 1;
        } else {
            id = list.get(last).getId() + 1;
        }
        Expense e = new Expense(id, date, amount, content);
        list.add(e);
    }

    @Override
    public void remove(ArrayList<Expense> list) {
        Scanner sc = new Scanner(System.in);
        int id;
        System.out.print("input id: ");
        id = Integer.parseInt(sc.nextLine());
        boolean check = true;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                list.remove(i);
                check = false;
                System.out.println("Delete an expense successful");
                break;
            }
        }
        if (check) {
            System.out.println("Delete an expense fail");
        }
    }

}
