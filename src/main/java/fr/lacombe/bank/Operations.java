package fr.lacombe.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Operations {

    private List<OperationLine> operationLines = new ArrayList<>();

    public void add(OperationLine operationLine) {
        operationLines.add(operationLine);
    }

    public List<OperationLine> getOperationsList() {
        return operationLines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operations that = (Operations) o;
        return Objects.equals(operationLines, that.operationLines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operationLines);
    }
}
