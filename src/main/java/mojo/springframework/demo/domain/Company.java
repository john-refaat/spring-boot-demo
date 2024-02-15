package mojo.springframework.demo.domain;



import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

/**
 * @author john
 * @since 14/02/2024
 */
@Getter
@Setter
@ToString
@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;

    @ManyToMany
    @JoinTable(name = "company_index",
            joinColumns = @JoinColumn(name = "company_id"),
            inverseJoinColumns = @JoinColumn(name = "index_id"))
    private Set<Index> indices;

    @ManyToOne
    private Industry industry;

    @ManyToOne
    private Sector sector;

    private BigDecimal marketCapUSD;

}
