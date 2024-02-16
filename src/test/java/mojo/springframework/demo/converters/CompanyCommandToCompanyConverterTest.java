package mojo.springframework.demo.converters;

import mojo.springframework.demo.commands.CompanyCommand;
import mojo.springframework.demo.commands.IndexCommand;
import mojo.springframework.demo.domain.Company;
import mojo.springframework.demo.domain.Index;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author john
 * @since 16/02/2024
 */
@ExtendWith(MockitoExtension.class)
class CompanyCommandToCompanyConverterTest {

    private CompanyCommandToCompanyConverter companyCommandToCompany;

    @Mock
    private IndexCommandToIndexConverter indexCommandToIndexConverter;

    @BeforeEach
    void setUp() {
        companyCommandToCompany = new CompanyCommandToCompanyConverter(indexCommandToIndexConverter);
    }

    @Test
    void convert() {
        // Given
        CompanyCommand companyCommand = new CompanyCommand();
        companyCommand.setId(1L);
        companyCommand.setName("company1");
        companyCommand.setIndices(new IndexCommand[]{new IndexCommand(2L, "index2")});

        Index index = new Index(2L, "index2", new HashSet<>());

        // When
        Mockito.when(indexCommandToIndexConverter.convert(ArgumentMatchers.any(IndexCommand.class))).thenReturn(index);
        Company company = companyCommandToCompany.convert(companyCommand);

        // Then
        assertNotNull(company);
        assertEquals(1L, company.getId());
        assertEquals("company1", company.getName());
        assertNotNull(company.getIndices());
        assertEquals(1, company.getIndices().size());
        assertTrue(company.getIndices().stream().findFirst().isPresent());
        assertEquals(2L, company.getIndices().stream().findFirst().get().getId());
    }
}