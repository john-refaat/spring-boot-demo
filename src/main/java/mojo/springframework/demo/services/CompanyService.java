package mojo.springframework.demo.services;

import mojo.springframework.demo.domain.Company;

import java.util.Set;

/**
 * @author john
 * @since 15/02/2024
 */
public interface CompanyService {

    Set<Company> findAllCompanies();

}
