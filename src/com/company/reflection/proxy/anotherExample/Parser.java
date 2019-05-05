package com.company.reflection.proxy.anotherExample;

import java.io.IOException;
import java.nio.file.Path;

public interface Parser {

    @WithReturnValue
    String read() throws IOException;

    @WithArgs
    boolean copy(Path path) throws IOException;
}
