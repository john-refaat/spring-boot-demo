package mojo.springframework.demo.commands;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author john
 * @since 15/02/2024
 */
@Data
public class CompanyCommand {

    private Long id;
    private String name;
    private String address;
    private BigDecimal marketCapMUSD;
    private IndexCommand[] indices;
}
