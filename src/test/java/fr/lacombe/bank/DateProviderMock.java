package fr.lacombe.bank;

import java.time.LocalDateTime;

public class DateProviderMock implements DateProvider {

    @Override
    public LocalDateTime date() {
        return LocalDateTime.of(2019, 10, 29, 10, 46);
    }

}
