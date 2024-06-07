package services;

import exceptions.IncorrectUserOrPasswordException;
import model.superClass.Account;

import java.util.Scanner;

public class AuthMovementServiceImpl implements AuthMovementService {

    @Override
    public boolean authentication(Account account) {
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
