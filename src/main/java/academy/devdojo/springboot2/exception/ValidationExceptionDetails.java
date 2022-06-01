package academy.devdojo.springboot2.exception;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.Objects;

@Getter
@SuperBuilder
public class ValidationExceptionDetails extends ExceptionDetails{
    private final String fields;
    private final String fieldsMessage;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ValidationExceptionDetails that = (ValidationExceptionDetails) o;
        return Objects.equals(fields, that.fields) && Objects.equals(fieldsMessage, that.fieldsMessage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), fields, fieldsMessage);
    }
}
