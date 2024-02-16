package mojo.springframework.demo.services;

import lombok.extern.slf4j.Slf4j;
import mojo.springframework.demo.commands.CompanyCommand;
import mojo.springframework.demo.converters.CompanyCommandToCompanyConverter;
import mojo.springframework.demo.converters.CompanyToCompanyCommandConverter;
import mojo.springframework.demo.domain.Company;
import mojo.springframework.demo.repository.CompanyRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

/**
 * @author john
 * @since 15/02/2024
 */
@Slf4j
@Service
public class CompanyServiceImpl implements CompanyService{
    private final CompanyRepository companyRepository;
    private final CompanyToCompanyCommandConverter companyToCompanyCommand;
    private final CompanyCommandToCompanyConverter companyCommandToCompany;

    public CompanyServiceImpl(CompanyRepository companyRepository, CompanyToCompanyCommandConverter companyToCompanyCommand, CompanyCommandToCompanyConverter companyCommandToCompany) {
        this.companyRepository = companyRepository;
        this.companyToCompanyCommand = companyToCompanyCommand;
        this.companyCommandToCompany = companyCommandToCompany;
    }

    @Transactional
    @Override
    public Set<CompanyCommand> findAllCompanies() {
        log.info("Find All Companies");
        Set<CompanyCommand> companyCommands  = new HashSet<CompanyCommand>();
        companyRepository.findAll().forEach(company -> companyCommands.add(companyToCompanyCommand.convert(company)));
        return companyCommands;
    }

    @Transactional
    @Override
    public void saveOrUpdate(CompanyCommand companyCommand) {
        log.info("Save Or Update Company");
        if(companyCommand == null)
            return;
        Company company = companyCommandToCompany.convert(companyCommand);
        if (company != null) {
            companyRepository.save(company);
        }
    }
}
