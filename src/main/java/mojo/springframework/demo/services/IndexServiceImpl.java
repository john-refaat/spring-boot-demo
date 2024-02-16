package mojo.springframework.demo.services;

import lombok.extern.slf4j.Slf4j;
import mojo.springframework.demo.commands.IndexCommand;
import mojo.springframework.demo.converters.IndexToIndexCommandConverter;
import mojo.springframework.demo.domain.Index;
import mojo.springframework.demo.repository.IndexRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * @author john
 * @since 15/02/2024
 */
@Slf4j
@Service
public class IndexServiceImpl implements IndexService {

    private final IndexToIndexCommandConverter indexToIndexCommand;
    private final IndexRepository indexRepository;

    public IndexServiceImpl(IndexToIndexCommandConverter indexToIndexCommand, IndexRepository indexRepository) {
        this.indexToIndexCommand = indexToIndexCommand;
        this.indexRepository = indexRepository;
    }


    @Override
    public Set<IndexCommand> findAllIndexes() {
       Set<IndexCommand> result = new HashSet<>();
        /*result.add(indexToIndexCommand.convert(new Index(1L, "S&P500")));
        result.add(indexToIndexCommand.convert(new Index(2L, "NASDAQ")));
        result.add(indexToIndexCommand.convert(new Index(3L, "RUT")));
        result.add(indexToIndexCommand.convert(new Index(4L, "DJIA")));*/
        indexRepository.findAll().forEach( i -> result.add(indexToIndexCommand.convert(i)));
        log.info("Found Indices: " + result );
        return result;
    }
}
