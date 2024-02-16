package mojo.springframework.demo.converters;

import mojo.springframework.demo.commands.CompanyCommand;
import mojo.springframework.demo.domain.Company;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author john
 * @since 16/02/2024
 */
@Component
public class CompanyCommandToCompanyConverter implements Converter<CompanyCommand, Company> {

    private IndexCommandToIndexConverter indexCommandToIndex;

    public CompanyCommandToCompanyConverter(IndexCommandToIndexConverter indexCommandToIndexCommand) {
        this.indexCommandToIndex = indexCommandToIndexCommand;
    }

    @Override
    public Company convert(CompanyCommand source) {
        Company company = new Company();
        if (source != null) {
            company.setId(source.getId());
            company.setName(source.getName());
            company.setAddress(source.getAddress());
            company.setMarketCapMUSD(source.getMarketCapMUSD());
            company.setIndices(Stream.of(source.getIndices()).map(i -> indexCommandToIndex.convert(i)).collect(Collectors.toSet()));
            // Set other properties if needed
        }
        return company;
    }
}

