package mk.finki.ukim.eshop.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import mk.finki.ukim.eshop.model.domain.Category;

public record CreateCategoryDto(@NotBlank(message = "A name is required") String name,
                                @Size(max = 512, message = "The description must be up to 512 characters") String description) {
   public Category toCategory() {
       return new Category(name, description);
   }
}
