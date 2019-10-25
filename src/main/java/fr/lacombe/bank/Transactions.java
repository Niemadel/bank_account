package fr.lacombe.bank;

import java.util.ArrayList;
import java.util.List;

public class Transactions {

    private List<OperationLine> transactions = new ArrayList<>();

    public void add(OperationLine operationLine) {
        transactions.add(operationLine);
    }

}
