package com.arepin;

import com.arepin.dao.CardRepository;
import com.arepin.dao.CardRepositoryFile;
import com.arepin.dao.CardRepositoryInMemory;
import com.arepin.entity.Card;
import com.arepin.service.PostPrinter;

import java.util.Arrays;

public class CLIApp {
    public static void main(String[] args) {
        CardRepository cardRepository = new CardRepositoryFile("C:\\Users\\yes4k\\OneDrive\\Рабочий стол\\Проекты\\data.txt");
       // CardRepository cardRepository = new CardRepositoryInMemory();
        Card[] cards = cardRepository.findAll();
        System.out.println(Arrays.toString(cards));
        PostPrinter postPrinter = new PostPrinter() {
        };
        System.out.println(postPrinter.print(cards));
    }
}
