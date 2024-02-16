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
class CompanyToCompanyCommandConverterTest {

    private CompanyToCompanyCommandConverter companyToCompanyCommandConverter;

    @Mock
    private IndexToIndexCommandConverter indexToIndexCommandConverter;

    @BeforeEach
    void setUp() {
        companyToCompanyCommandConverter = new CompanyToCompanyCommandConverter(indexToIndexCommandConverter);
    }

    @Test
    void convert() {
        //Given
        Company company = new Company();
        company.setId(1L);
        company.setName("company1");
        company.setIndices(new HashSet<>());
        company.getIndices().add(new Index(1L, "index1"));

        //When
        Mockito.when(indexToIndexCommandConverter.convert(ArgumentMatchers.any(Index.class))).thenReturn(new IndexCommand(1L, "index1"));
        CompanyCommand result = companyToCompanyCommandConverter.convert(company);

        //Then
        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("company1", result.getName());
        assertEquals(1L, result.getIndices()[0].getId());
        assertEquals("index1", result.getIndices()[0].getName());
    }
}