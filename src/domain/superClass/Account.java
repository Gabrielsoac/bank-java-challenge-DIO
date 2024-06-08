package domain.superClass;

import domain.entities.MovementsAccount;
import domain.entities.enums.MovementType;
import infra.services.AuthMovementService;
import infra.services.AuthMovementServiceImpl;
import infra.services.ExtractServiceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Account {

    protected String agency = "0001";
    protected static int number = 1;
    protected Double balance;
    protected Client client;
    protected String login;
    protected String password;
    protected List<MovementsAccount> lastMoviments;

    protected AuthMovementService authMovimentService = new AuthMovementServiceImpl();
    protected ExtractServiceImpl extractService = new ExtractServiceImpl();

    public Account(Client client, String login, String password) {
        number = number + 1;
        this.client = client;
        this.login = login;
        this.password = password;
        this.lastMoviments = new ArrayList<>();
        this.balance = 0.0;    }

    public void deposit(double amount){
        authMovimentService.authenticationMovement(this);
        this.balance += amount;
        lastMoviments.add(new MovementsAccount(LocalDate.now(), MovementType.DEPOSIT, amount));
    }

    public String getAgency() {
        return agency;
    }

    public Integer getNumber() {
        return number;
    }

    public Double getBalance() {
        return balance;
    }

    public Client getClient() {
        return client;
    }

    public List<MovementsAccount> getLastMoviments() {
        return lastMoviments;
    }

    public String getPassword() {
        return password;
    }

    public String getLogin() {
        return login;
    }

    public void receiveTransfer(Double amount) {
        this.balance += amount;
        lastMoviments.add(new MovementsAccount(LocalDate.now(), MovementType.RECEIVE_TRANSFER, amount));
    }

    public void getExtract(){
        extractService.extractAccount(this);
    }
}
