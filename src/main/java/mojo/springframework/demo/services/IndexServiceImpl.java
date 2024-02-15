package mojo.springframework.demo.services;

import mojo.springframework.demo.commands.IndexCommand;
import mojo.springframework.demo.converters.IndexToIndexCommand;
import mojo.springframework.demo.domain.Index;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * @author john
 * @since 15/02/2024
 */
@Service
public class IndexServiceImpl implements IndexService {

    private final IndexToIndexCommand indexToIndexCommand;

    public IndexServiceImpl(IndexToIndexCommand indexToIndexCommand) {
        this.indexToIndexCommand = indexToIndexCommand;
    }


    @Override
    public Set<IndexCommand> findAllIndexes() {
        Set<IndexCommand> result = new HashSet<>();
        result.add(indexToIndexCommand.convert(new Index(1L, "S&P500")));
        result.add(indexToIndexCommand.convert(new Index(2L, "NASDAQ")));
        result.add(indexToIndexCommand.convert(new Index(3L, "RUT")));
        result.add(indexToIndexCommand.convert(new Index(4L, "DJIA")));
        return result;
    }
}
