package domain.entities;

import domain.superClass.Account;
import domain.superClass.Client;

public class SavingsAccount extends Account {

    public SavingsAccount(Client client, String login, String password) {
        super(client, login, password);
    }
}
