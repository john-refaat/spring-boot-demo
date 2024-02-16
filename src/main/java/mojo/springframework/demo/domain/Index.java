package mojo.springframework.demo.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

/**
 * @author john
 * @since 15/02/2024
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Index {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "indices")
    private Set<Company> companies;

}
