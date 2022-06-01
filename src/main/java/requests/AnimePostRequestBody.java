package requests;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class AnimePostRequestBody {

    @NotEmpty(message = "The anime's name cannot be empty")
    @NotNull(message = "The anime's name cannot be null")
    private String name;
}
