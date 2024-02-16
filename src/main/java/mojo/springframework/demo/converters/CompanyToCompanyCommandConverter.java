package mojo.springframework.demo.converters;

import mojo.springframework.demo.commands.CompanyCommand;
import mojo.springframework.demo.commands.IndexCommand;
import mojo.springframework.demo.domain.Company;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author john
 * @since 16/02/2024
 */
@Component
public class CompanyToCompanyCommandConverter implements Converter<Company, CompanyCommand> {

    private IndexToIndexCommandConverter indexToIndexCommand;

    public CompanyToCompanyCommandConverter(IndexToIndexCommandConverter indexToIndexCommand) {
        this.indexToIndexCommand = indexToIndexCommand;
    }

    @Override
    public CompanyCommand convert(Company source) {
        CompanyCommand companyCommand = new CompanyCommand();
        if (source != null) {
            companyCommand.setId(source.getId());
            companyCommand.setName(source.getName());
            companyCommand.setAddress(source.getAddress());
            companyCommand.setMarketCapMUSD(source.getMarketCapMUSD());
            companyCommand.setIndices(source.getIndices().stream().map(i -> indexToIndexCommand.convert(i)).toArray(IndexCommand[]::new));
        }
        return companyCommand;
    }
}
