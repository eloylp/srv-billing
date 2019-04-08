package billing.domain;

import java.util.UUID;

public class Uuid {

    private final UUID value;

    Uuid() {
        this(UUID.randomUUID().toString());
    }

    private Uuid(String value) {
        this.value = UUID.fromString(value);
    }

    @Override
    public String toString() {
        return this.value.toString();
    }
}
