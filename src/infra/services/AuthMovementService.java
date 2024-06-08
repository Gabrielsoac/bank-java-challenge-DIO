package infra.services;

import domain.entities.CurrentAccount;
import domain.superClass.Account;

import java.util.List;

public interface AuthMovementService {

    CurrentAccount authentication(List<CurrentAccount> accountList, String login, String password);
    boolean authenticationMovement(Account account);
}
