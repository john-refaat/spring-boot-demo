package mojo.springframework.demo.converters;

import mojo.springframework.demo.commands.IndexCommand;
import mojo.springframework.demo.domain.Index;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author john
 * @since 16/02/2024
 */
class IndexCommandToIndexConverterTest {

    private IndexCommandToIndexConverter indexCommandToIndex;

    @BeforeEach
    void setUp() {
        indexCommandToIndex = new IndexCommandToIndexConverter();
    }

    @Test
    void convert() {
        //Given
        IndexCommand indexCommand = new IndexCommand(1L, "index1");

        //When
        Index result = indexCommandToIndex.convert(indexCommand);

        //Then
        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("index1", result.getName());
    }
}