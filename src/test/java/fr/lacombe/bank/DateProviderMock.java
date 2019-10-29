package fr.lacombe.bank;

import java.time.LocalDate;

public class DateProviderMock implements DateProvider {

    @Override
    public LocalDate date() {
        return LocalDate.of(2019, 10, 29);
    }

}
