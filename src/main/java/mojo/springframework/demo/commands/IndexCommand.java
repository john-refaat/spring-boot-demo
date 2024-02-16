package mojo.springframework.demo.commands;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author john
 * @since 15/02/2024
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IndexCommand {
    private Long id;
    private String name;
}
