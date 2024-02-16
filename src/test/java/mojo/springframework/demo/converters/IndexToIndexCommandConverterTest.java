package mojo.springframework.demo.converters;

import mojo.springframework.demo.commands.IndexCommand;
import mojo.springframework.demo.domain.Index;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author john
 * @since 16/02/2024
 */
class IndexToIndexCommandConverterTest {

    private IndexToIndexCommandConverter indexToIndexCommandConverter;

    @BeforeEach
    void setUp() {
        indexToIndexCommandConverter = new IndexToIndexCommandConverter();
    }

    @Test
    void convert() {
        // Given
        Index index = new Index(1L, "index1", new HashSet<>());

        // When
        IndexCommand result = indexToIndexCommandConverter.convert(index);

        // Then
        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("index1", result.getName());
    }
}