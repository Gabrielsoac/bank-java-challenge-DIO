package infra.services;

import domain.superClass.Account;

import java.util.ArrayList;
import java.util.List;

public class ExtractServiceImpl implements ExtractService{
    @Override
    public void extractAccount(Account account) {

        List<String> extract = new ArrayList<>();

        extract.add("Agência: " + account.getAgency());
        extract.add("Conta:"  + account.getNumber());
        extract.add("Nome: " + account.getClient().getName());
        extract.add("Saldo: " + account.getBalance());

        extract.forEach(System.out::println);
        System.out.println("Últimas movimentações");
        account.getLastMoviments().forEach(System.out::println);
    }
}
