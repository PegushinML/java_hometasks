package Exceptions_task.terminal;


import Exceptions_task.account.Account;
import Exceptions_task.account.account_services.exceptions.AccountIsLockedException;
import Exceptions_task.account.account_services.exceptions.WrongPinException;
import Exceptions_task.account.account_services.pin_validation.PinAccount;
import Exceptions_task.account.account_services.pin_validation.PinValidator;
import Exceptions_task.account.account_services.pin_validation.PinValidatorImpl;
import Exceptions_task.terminal.Terminal;
import Exceptions_task.terminal.exceptions.ConnectionException;
import Exceptions_task.terminal.exceptions.InsufficientFundsException;
import Exceptions_task.terminal.exceptions.TerminalException;
import Exceptions_task.terminal.exceptions.WrongMoneyValueExceptions;

/**
 * Created by Maxim on 11/13/2016.
 */
public class TerminalImpl implements Terminal {

    private final Account account;
    private final PinValidator validator;
    private final TerminalServer server;

    public TerminalImpl(Account account) {
        this.account = account;
        this.validator = new PinValidatorImpl((PinAccount) account);
        this.server = new TerminalServer(account);
    }

    @Override
    public double checkAccount(int pin) throws TerminalException {
        try {
            validator.checkPin(pin);
            System.out.println("Correct pin!");
            return account.checkAccount();
        } catch (AccountIsLockedException e) {
            e.printStackTrace();
            throw new TerminalException();
        } catch (WrongPinException e) {
            e.printStackTrace();
            throw new TerminalException();
        }
    }

    @Override
    public void putMoney(int pin, double amount) throws TerminalException {
        try {
            validator.checkPin(pin);
            System.out.println("Correct pin!");
            server.connect();
            server.moneyOperation(amount);
        } catch (AccountIsLockedException e) {
            e.printStackTrace();
            throw new TerminalException();
        } catch (WrongPinException e) {
            e.printStackTrace();
            throw new TerminalException();
        } catch (ConnectionException e) {
            e.printStackTrace();
            throw new TerminalException();
        } catch (InsufficientFundsException e) {
            e.printStackTrace();
            throw new TerminalException();
        } catch (WrongMoneyValueExceptions wrongMoneyValueExceptions) {
            wrongMoneyValueExceptions.printStackTrace();
            throw new TerminalException();
        }
    }

    @Override
    public void getMoney(int pin, double amount) throws TerminalException {
        try {
            validator.checkPin(pin);
            System.out.println("Correct pin!");
            server.connect();
            server.moneyOperation(-amount);
        } catch (AccountIsLockedException e) {
            e.printStackTrace();
            throw new TerminalException();
        } catch (WrongPinException e) {
            e.printStackTrace();
            throw new TerminalException();
        } catch (ConnectionException e) {
            e.printStackTrace();
            throw new TerminalException();
        } catch (InsufficientFundsException e) {
            e.printStackTrace();
            throw new TerminalException();
        } catch (WrongMoneyValueExceptions wrongMoneyValueExceptions) {
            wrongMoneyValueExceptions.printStackTrace();
            throw new TerminalException();
        }
    }


}
