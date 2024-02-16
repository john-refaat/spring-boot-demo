package mojo.springframework.demo.converters;

import mojo.springframework.demo.commands.IndexCommand;
import mojo.springframework.demo.domain.Index;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author john
 * @since 16/02/2024
 */
@Component
public class IndexCommandToIndexConverter implements Converter<IndexCommand, Index> {
    @Override
    public Index convert(IndexCommand source) {
        Index index = new Index();
        if (source != null) {
            index.setId(source.getId());
            index.setName(source.getName());
        }
        return index;
    }
}
