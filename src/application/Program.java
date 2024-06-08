package application;

import domain.entities.Bank;
import domain.entities.CurrentAccount;
import domain.exceptions.AccountNotFoundException;
import domain.superClass.Client;
import infra.services.AuthMovementService;
import infra.services.AuthMovementServiceImpl;

import java.time.LocalDate;
import java.util.Scanner;

public class Program {

    static Bank bank = new Bank();
    static final AuthMovementService authMovementService = new AuthMovementServiceImpl();

    public static void main(String[] args) {
        initialMenuOptions();
    }

    private static void login(String login, String password){
        try{
            CurrentAccount account = authMovementService.authentication(bank.getCurrentAccounts(), login, password);
            menuMain(account);
        } catch (AccountNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void registerCurrentAccount(){

        Scanner input = new Scanner(System.in);

        System.out.println("Bem-vindo ao banco do Gabs" +
                "\n" +
                "Cadastre-se: " +
                "\n");

        System.out.print("Digite o seu nome completo: ");
        String name = input.nextLine();

        System.out.print("Digite seu ano de nascimento: ");
        int year = input.nextInt();
        System.out.print("Digite seu mês de nascimento: ");
        int month = input.nextInt();
        System.out.print("Digite seu dia de nascimento: ");
        int day = input.nextInt();
        input.nextLine();
        LocalDate birthDate = LocalDate.of(year, month, day);

        System.out.print("Crie seu login: ");
        String login = input.nextLine();
        System.out.print("Crie sua senha: ");
        String password = input.nextLine();

        bank.addCurrentAccount(new CurrentAccount(new Client(name, LocalDate.of(year, month, day)), login, password));

        System.out.print("Cadastro Realizado com sucesso!");
    }

    private static void menuMain(CurrentAccount account){

        Scanner sc = new Scanner(System.in);
        boolean menu = true;
        while (menu) {
            System.out.print("Escolha uma opção: \n" +
                    "(2) - Sacar \n" +
                    "(3) - Depositar\n" +
                    "(4) - Extrato\n" +
                    "(0) - Sair\n");

            int choice = sc.nextInt();

            switch (choice) {
                case 2:
                    System.out.println("Digite o valor de saque: ");
                    Double amount = sc.nextDouble();
                    bank.getCurrentAccounts().stream().filter(x -> x.getLogin().equals(account.getLogin())).forEach(x -> x.withdraw(amount));
                    continue;
                case 3:
                    System.out.println("Digite o valor a depositar: ");
                    Double value = sc.nextDouble();
                    bank.getCurrentAccounts().stream().filter(x -> x.getLogin().equals(account.getLogin())).forEach(x -> x.deposit(value));
                    continue;
                case 4:
                    account.getExtract();
                    continue;
                case 0:
                    System.out.println("Obrigado por usar o Gab's Bank");
                    menu = false;
            }
        }
        sc.close();
    }
    private static void initialMenuOptions(){

        Scanner sc = new Scanner(System.in);
        boolean menu = true;
        while(menu) {
            System.out.println("Por favor, escolha uma opção:\n" +
                    "(1) - Registrar\n" +
                    "(2) - Login\n" +
                    "(3) - Sair");
            System.out.println("Escolha: ");
            int mainMenu = sc.nextInt();

            switch (mainMenu){
                case 1:
                    registerCurrentAccount();
                    continue;
                case 2:
                    System.out.println("Digite seu usuário e senha");
                    System.out.print("Digite seu login: ");
                    String login = sc.next();
                    System.out.print("Digite seu senha: ");
                    String password = sc.next();
                    login(login, password);
                case 3:
                    System.out.println("Obrigado por ser nosso cliente!");
                    menu = false;
            }
        }
       sc.close();
    }
}

