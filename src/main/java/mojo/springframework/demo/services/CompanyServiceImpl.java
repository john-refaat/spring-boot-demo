package mojo.springframework.demo.services;

import mojo.springframework.demo.domain.Company;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * @author john
 * @since 15/02/2024
 */
@Service
public class CompanyServiceImpl implements CompanyService{
    @Override
    public Set<Company> findAllCompanies() {
        return new HashSet<>();
    }
}
