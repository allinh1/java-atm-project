package com.company;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

    public class OptionMenu extends Account {
        Scanner menuInput = new Scanner(System.in);
        DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

        HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();

        public void getLogin() throws IOException {
            int x = 1;
            do {
                try {
                    data.put(1234, 1234);
                    data.put(12345, 54321);

                    System.out.println("Welcome to ATM Project");
                    System.out.println("Enter client number");
                    setCustomerNumber(menuInput.nextInt());

                    System.out.println("Enter PIN");
                    setPinNumber(menuInput.nextInt());
                } catch (Exception e) {
                    System.out.println("\n" + "Invalid" + "\n");
                    x = 2;
                }

                int cn = getCustomerNumber();
                int pn = getPinNumber();
                if (data.containsKey(cn) && data.get(cn) == pn) {
                    getAccountType();
                } else
                    System.out.println("\n" + "Wrong PIN or CN" + "\n");
            } while (x == 1);
        }

        public void getAccountType() {
            System.out.println("Select Account");
            System.out.println("1 - Checking");
            System.out.println("2 - Savings");
            System.out.println("3 - Exit");

            int selection = menuInput.nextInt();

            switch (selection) {
                case 1:
                    getChecking();
                    break;
                case 2:
                    getSaving();
                    break;
                case 3:
                    System.out.println("Peace out. BYE");
                    break;
                default:
                    System.out.println("Invalid Choice");
            }
        }

        public void getChecking() {
            System.out.println("Checking Account");
            System.out.println("1 - Balance");
            System.out.println("2 - Withdraw");
            System.out.println("3 - Deposit");
            System.out.println("4 - Exit");
            System.out.print("Choice: ");

            int selection = menuInput.nextInt();

            switch (selection) {
                case 1:
                    System.out.println(String.format("Checking Balance: " + moneyFormat.format(getCheckingBalance())));
                    getAccountType();
                    break;
                case 2:
                    getCheckingWithdrawInput();
                    getAccountType();
                    break;
                case 3:
                    getCheckingDepositInput();
                    getAccountType();
                    break;
                case 4:
                    System.out.println("Thank you for using ATM");
                    break;
                default:
                    System.out.println("Invalid Code");
            }
    }

        public void getSaving() {
            System.out.println("Saving Account");
            System.out.println("1 - Balance");
            System.out.println("2 - Withdraw");
            System.out.println("3 - Deposit");
            System.out.println("4 - Exit");
            System.out.print("Choice: ");

            int selection = menuInput.nextInt();

            switch (selection) {
                case 1:
                    System.out.println(String.format("Savings Balance: " + moneyFormat.format(getSavingBalance())));
                    getAccountType();
                    break;
                case 2:
                    getSavingWithdrawInput();
                    getAccountType();
                    break;
                case 3:
                    getSavingDepositInput();
                    getAccountType();
                    break;
                case 4:
                    System.out.println("Thank you for using ATM");
                    break;
                default:
                    System.out.println("Invalid Code");
            }

        }
}
