package domain.superClass;

import java.time.LocalDate;

public class Client {

    private String name;
    private LocalDate birthDate;

    public Client(String name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setName(String name) {
        this.name = name;
    }
}
