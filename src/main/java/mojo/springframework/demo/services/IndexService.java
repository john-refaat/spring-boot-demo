package mojo.springframework.demo.services;

import mojo.springframework.demo.commands.IndexCommand;
import mojo.springframework.demo.domain.Index;

import java.util.Set;

/**
 * @author john
 * @since 15/02/2024
 */
public interface IndexService {

    Set<IndexCommand> findAllIndexes();
}
