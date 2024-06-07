package model.entities;

import model.superClass.Account;
import model.superClass.Client;

public class SavingsAccount extends Account {

    public SavingsAccount(Client client, String login, String password) {
        super(client, login, password);
    }
}
