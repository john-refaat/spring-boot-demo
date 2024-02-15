package mojo.springframework.demo.converters;

import mojo.springframework.demo.commands.IndexCommand;
import org.springframework.core.convert.converter.Converter;

/**
 * @author john
 * @since 15/02/2024
 */
public class StringToIndexCommandConverter implements Converter<String, IndexCommand> {
    @Override
    public IndexCommand convert(String source) {
        // Parse the input string and extract the id and name
        // You can use regular expressions or other methods to extract the values
        // For simplicity, let's assume the format is fixed

        String[] parts = source.split(",");
        Long id = Long.parseLong(parts[0].substring(parts[0].indexOf("=") + 1));
        String name = parts[1].substring(parts[1].indexOf("=") + 1);

        IndexCommand indexCommand = new IndexCommand();
        indexCommand.setId(id);
        indexCommand.setName(name);
        return indexCommand;
    }
}
