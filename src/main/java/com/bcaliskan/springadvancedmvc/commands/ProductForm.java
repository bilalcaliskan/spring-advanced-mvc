package com.bcaliskan.springadvancedmvc.commands;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.URL;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Getter
@Setter
public class ProductForm {

    private Integer id;
    private Integer version;

    @NotEmpty
    @Size(min = 5, max = 200)
    private String description;

    @NotNull
    @Min(0)
    @Max(5000)
    private BigDecimal price;

    @NotEmpty
    @URL
    private String imageUrl;

}
