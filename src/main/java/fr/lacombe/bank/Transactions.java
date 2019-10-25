package fr.lacombe.bank;

import java.util.ArrayList;
import java.util.List;

public class Transactions {

    private List<Amount> operationsAmount = new ArrayList<>();

    public void add(Amount amount) {
        operationsAmount.add(amount);
    }

    public List<Amount> getOperationsAmount() {
        return operationsAmount;
    }

}
