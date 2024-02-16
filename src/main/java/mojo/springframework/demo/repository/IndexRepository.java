package mojo.springframework.demo.repository;

import mojo.springframework.demo.domain.Index;
import org.springframework.data.repository.CrudRepository;

/**
 * @author john
 * @since 16/02/2024
 */
public interface IndexRepository extends CrudRepository<Index, Long> {
}
