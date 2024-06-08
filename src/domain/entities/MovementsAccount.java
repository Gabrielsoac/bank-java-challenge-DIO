package domain.entities;

import domain.entities.enums.MovementType;

import java.time.LocalDate;

public class MovementsAccount {

    private LocalDate date;
    private MovementType type;
    private Double amount;

    public MovementsAccount(LocalDate date, MovementType type, Double amount) {
        this.date = date;
        this.type = type;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Dia: " + date + " Movimentação: " + type + " Valor: " + amount + "\n";
    }
}


