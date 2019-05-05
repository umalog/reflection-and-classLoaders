package com.company.reflection.proxy.anotherExample;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileParser implements Parser {

    @Override
    public String read() throws IOException {
        return new String(
                Files.readAllBytes(Paths.get(".gitignore")),
                StandardCharsets.UTF_8
        );

    }

    @Override
    public boolean copy(Path path) throws IOException {
        Files.copy(Paths.get(".gitignore"), path);
        return true;
    }


}
