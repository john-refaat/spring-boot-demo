package mojo.springframework.demo.converters;

import mojo.springframework.demo.commands.IndexCommand;
import mojo.springframework.demo.domain.Index;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author john
 * @since 15/02/2024
 */
@Component
public class IndexToIndexCommand implements Converter<Index, IndexCommand> {


    @Override
    public IndexCommand convert(Index source) {
        IndexCommand indexCommand = new IndexCommand();
        if (source != null) {
            indexCommand.setId(source.getId());
            indexCommand.setName(source.getName());
        }
        return indexCommand;
    }
}
