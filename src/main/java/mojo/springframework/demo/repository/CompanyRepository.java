package mojo.springframework.demo.repository;

import mojo.springframework.demo.domain.Company;
import org.springframework.data.repository.CrudRepository;

/**
 * @author john
 * @since 15/02/2024
 */
public interface CompanyRepository extends CrudRepository<Company, Long> {
}
