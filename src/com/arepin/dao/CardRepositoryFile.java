package com.arepin.dao;

import com.arepin.entity.Card;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class CardRepositoryFile implements CardRepository {
    private final static int NAME_POS = 0;
    private final static int PRICE_POS = 1;
    private final static int AMOUNT_POS = 2;

    private final Path pathToFile;

    public CardRepositoryFile(String pathToFile) {
        this.pathToFile = Paths.get(pathToFile);
    }

    @Override
    public Card[] findAll() {
        try {
            return Files.lines(pathToFile)
                    .filter(line -> !line.isBlank())
                    .map(line -> convertToCard(line))
                    .collect(Collectors.toList())
                    .toArray(new Card[0]);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Can't read data file", e);
        }
    }

    private static Card convertToCard(String line) {
        var data = line.split(";");

        Card card = new Card();
        card.setName(data[NAME_POS]);
        card.setPrice(Integer.parseInt(data[PRICE_POS]));
        card.setAmount(Integer.parseInt(data[AMOUNT_POS]));

        return card;
    }
}
