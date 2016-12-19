package Exceptions_task;


import Exceptions_task.account.Account;
import Exceptions_task.account.AccountImpl;
import Exceptions_task.terminal.Terminal;
import Exceptions_task.terminal.TerminalImpl;
import Exceptions_task.terminal.exceptions.TerminalException;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Account account = new AccountImpl(1, 1111, 50000);
        Terminal terminal = new TerminalImpl(account);
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Checking funds. Write pin");
            System.out.println(terminal.checkAccount(scanner.nextInt()));
        } catch (TerminalException e) {
            e.printStackTrace();
        }

        try {
            System.out.println("Putting money. Write pin and money amount");
            terminal.putMoney(scanner.nextInt(), scanner.nextInt());
        } catch (TerminalException e) {
            e.printStackTrace();
        }

        try {
            System.out.println("Getting money. Write pin and money amount");
            terminal.getMoney(scanner.nextInt(), scanner.nextInt());
        } catch (TerminalException e) {
            e.printStackTrace();
        }

        try {
            System.out.println("Checking funds. Write pin");
            System.out.println(terminal.checkAccount(scanner.nextInt()));
        } catch (TerminalException e) {
            e.printStackTrace();
        }

    }
}
