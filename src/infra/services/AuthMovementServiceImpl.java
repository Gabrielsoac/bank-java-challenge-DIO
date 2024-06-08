package infra.services;

import domain.entities.CurrentAccount;
import domain.exceptions.AccountNotFoundException;
import domain.exceptions.IncorrectUserOrPasswordException;
import domain.superClass.Account;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class AuthMovementServiceImpl implements AuthMovementService {

    @Override
    public CurrentAccount authentication(List<CurrentAccount> accountList, String login, String password) {

        Optional<CurrentAccount> currentAccount = accountList.stream().filter(x -> x.getLogin().equals(login) && x.getPassword().equals(password)).findFirst();

        if(currentAccount.isPresent()) {
            return currentAccount.get();
        }
        throw new AccountNotFoundException("Conta não encontrada");

    }

    @Override
    public boolean authenticationMovement(Account account) {
        System.out.println("Entre com seu Login e Senha");
        Scanner input = new Scanner(System.in);

        try {
            System.out.print("Login: ");
            String loginInput = input.nextLine();
            System.out.print("Senha: ");
            String passwordInput = input.nextLine();

            if (account.getLogin().equals(loginInput) && account.getPassword().equals(passwordInput)) {
                return true;
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        throw new IncorrectUserOrPasswordException("Usuário ou Senha incorretos");
    }


}
