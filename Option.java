/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 *
 * @author Dell
 */
public class Option {

    static Scanner sc = new Scanner(System.in);
    static final String ACCOUNT_NUMBER_VALID = "^\\d{10}$";
    static final char[] chars = {'1', 'A', 'a', 'B', 'b', 'C',
        'c', '2', 'D', 'd', 'E', 'e', 'F', 'f', '3', 'G', 'g', 'H', 'h',
        'I', 'i', 'J', 'j', 'K', 'k', 'L', 'l', '4', 'M', 'm', 'N', 'n',
        'O', 'o', '5', 'P', 'p', 'Q', 'q', 'R', 'r', 'S', 's', 'T', 't',
        '6', '7', 'U', 'u', 'V', 'v', 'U', 'u', 'W', 'w', '8', 'X', 'x',
        'Y', 'y', 'Z', 'z', '9'};

    public static int checkRanger(int min, int max, Locale language) {
        while (true) {
            try {
                int n = Integer.parseInt(sc.nextLine());
                if (n < min || n > max) {
                    throw new NumberFormatException();
                }
                return n;
            } catch (NumberFormatException e) {
                getWordLanguage(language, "errorCheckInputIntLimit");
   
            }
        }
    }

    public static String checkString(Locale Language) {
        while (true) {
            String n = sc.nextLine();
            if (n.isEmpty()) {
                getWordLanguage(Language, "errCheckInputIntLimit");
            }
            return n;
        }
    }

    public static int checkAccount(Locale language) {
        while (true) {
            String n = sc.nextLine().trim();
            if (n.matches(ACCOUNT_NUMBER_VALID)) {
                return Integer.parseInt(n);
            }
            else{
                getWordLanguage(language, "errCheckInputAccount");
            }
        }

    }

    public static String checkPassword(Locale languge) {
        while (true) {
            String pass = sc.nextLine();
            int countD = 0, countL = 0;
            for (int i = 0; i < pass.length(); i++) {
                if (Character.isDigit(pass.charAt(i))) {
                    countD++;
                }
                if (Character.isLetter(pass.charAt(i))) {
                    countL++;
                }
                if (pass.isEmpty()) {
                    System.out.println("Error! reinput");
                }
                if (pass.length() > 6 && pass.length() < 15 && countD >= 1 && countL >= 1) {
                    return pass;
                } else {
                    System.out.println("Error!");
                }
            }

        }
    }

    static boolean checkInputCaptcha(String captchaGenerated, Locale language) {
        System.out.println(captchaGenerated);
        getWordLanguage(language, "enterCaptcha");
        String captchaInput = checkString(language);
        for (int i = 0; i < captchaInput.length(); i++) {
            if (!captchaGenerated.contains(Character.toString(captchaInput.charAt(i)))) {
                return false;
            }
        }
        return true;
    }

    static String generateCaptchaText() {
        String randomStrValue = "";
        final int LENGTH = 6;
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for (int i = 0; i < LENGTH; i++) {
            index = (int) (Math.random() * (chars.length - 1));
            sb.append(chars[index]);
        }
        return sb.toString();
    }

    public static void login(Locale language) {
        getWordLanguage(language, "Enter AccountNumber: ");
        int acc = checkAccount(language);
        getWordLanguage(language, "Enter password: ");
        String pas = checkPassword(language);
        String cap = generateCaptchaText();
        while (true) {            
            if(checkInputCaptcha(cap, language)){
                getWordLanguage(language,"login success");
            }else{
                getWordLanguage(language, "errCaptchaIncorrect");
            }
        }

    }

    static void getWordLanguage(Locale curLocate, String key) {
        ResourceBundle words = ResourceBundle.getBundle("Language/" + curLocate, curLocate);
        String value = words.getString(key);
        System.out.printf(value);
    }

    public static void display() {
        Locale vietnamese = new Locale("vi");
        Locale english = Locale.ENGLISH;
        System.out.println("1. Vietnamese");
        System.out.println("2. English");
        System.out.println("3. Exit");
        System.out.println("Your choice: ");
        int choice = checkRanger(1, 3, english);
        switch(choice){
            case 1:
                login(vietnamese);
                break;
            case 2:
                login(english);
                break;
            case 3:
                return;
        }
    }

    public static void main(String[] args) {
        display();
    }

}
