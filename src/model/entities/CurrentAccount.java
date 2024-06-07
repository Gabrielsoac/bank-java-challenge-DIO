package model.entities;

import exceptions.InsufficientFundsException;
import model.entities.enums.MovementType;
import model.superClass.Account;
import model.superClass.Client;

import java.time.LocalDate;

public class CurrentAccount extends Account {

    public CurrentAccount(Client client, String login, String password) {
        super(client, login, password);
    }

    public void withdraw(double amount){
        authMovimentService.authentication(this);

        if (this.balance < amount){
            throw new InsufficientFundsException("Saldo Insuficiente, não foi possível realizar saque.");
        }

        this.balance -= amount;
        lastMoviments.add(new MovementsAccount(LocalDate.now(), MovementType.WITHDRAW, amount));
    }

    public void transfer(double amount, Account account){
        authMovimentService.authentication(this);

        if(this.balance < amount){
            throw new InsufficientFundsException("Saldo Insuficiente, não foi possível realizar transferência");
        }
        this.balance -= amount;
        account.receiveTransfer(amount);

        this.lastMoviments.add(new MovementsAccount(LocalDate.now(), MovementType.TRANSFER, amount));
    }
}
