package domain.entities;

import domain.exceptions.AccountNotFoundException;
import domain.superClass.Account;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Bank {

    private final List<CurrentAccount> currentAccounts;
    private final List<SavingsAccount> savingsAccounts;
    private final List<Account> disabledAccounts;


    public Bank() {
        this.savingsAccounts = new ArrayList<>();
        this.currentAccounts = new ArrayList<>();
        this.disabledAccounts = new ArrayList<>();
    }

    public List<CurrentAccount> getCurrentAccounts() {
        return currentAccounts;
    }

    public List<SavingsAccount> getSavingsAccounts() {
        return savingsAccounts;
    }

    public List<Account> getDisabledAccounts() {
        return disabledAccounts;
    }

    public void addCurrentAccount(CurrentAccount account) {
        this.currentAccounts.add(account);
    }

    public void addSavingsAccount(SavingsAccount savingsAccount) {
        this.savingsAccounts.add(savingsAccount);
    }
    public void removeCurrentAccount(String name, LocalDate birthDate) {

        long accountExist = currentAccounts.stream().filter(x -> x.getClient().getName().equals(name) && x.getClient().getBirthDate().equals(birthDate)).count();
        if (accountExist == 0) throw new AccountNotFoundException("Conta não encontrada");

        currentAccounts.stream().filter(x -> x.getClient().getName().equals(name) && x.getClient().getBirthDate().equals(birthDate)).limit(1).forEach(disabledAccounts::add);
        currentAccounts.removeIf((x) -> x.getClient().getName().equals(name) && x.getClient().getBirthDate().equals(birthDate));

        System.out.println("Conta Deletada!");
        }

    public void removeSavingsAccount(String name, LocalDate birthDate) {

        long accountExist = savingsAccounts.stream().filter(x -> x.getClient().getName().equals(name) && x.getClient().getBirthDate().equals(birthDate)).count();
        if (accountExist == 0) throw new AccountNotFoundException("Conta não encontrada");

        currentAccounts.stream().filter(x -> x.getClient().getName().equals(name) && x.getClient().getBirthDate().equals(birthDate)).limit(1).forEach(disabledAccounts::add);
        currentAccounts.removeIf((x) -> x.getClient().getName().equals(name) && x.getClient().getBirthDate().equals(birthDate));

        System.out.println("Conta Deletada!");
    }
}
