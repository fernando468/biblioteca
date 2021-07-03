package com.app.backend.shared.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Objects;

import com.app.backend.shared.models.File;

import org.springframework.web.multipart.MultipartFile;

public class FileUtil {
    private static final String DIRECTORY = System.getProperty("user.dir") + java.io.File.separator +
            "src" + java.io.File.separator + "main" + java.io.File.separator + "resources" + java.io.File.separator + "static" +
            java.io.File.separator + "uploads";

    public static File criarArquivo(MultipartFile arquivo) {
        try {
            Path path = Files.createDirectories(Paths.get(DIRECTORY));
            String novoNome = String.format("%d", new Date().getTime()).concat(Objects.requireNonNull(arquivo.getOriginalFilename()));
            Files.copy(arquivo.getInputStream(), path.resolve(novoNome));
            return new File(
                    novoNome,
                    arquivo.getOriginalFilename(),
                    "http://localhost:8080"
            );
        } catch (IOException e) {
            throw new RuntimeException("Não foi possível salvar o arquivo!", e);
        }
    }

    public static void removerArquivo(String nomeDoArquivo) {
        Path path = Paths.get(DIRECTORY + java.io.File.separator + nomeDoArquivo);
        try {
            Files.delete(path);
        } catch (IOException e) {
            throw new RuntimeException("Não foi possível remover o arquivo.", e);
        }
    }
}
