package org.gbtask.view.menu;

import org.gbtask.view.template.impl.*;

import java.util.Arrays;
import java.util.List;

public interface AnimalSelectionMenu {
    String header = "\nChoose the animal\n";
    List<MenuItem> menuItems = Arrays.asList(
            new MenuItem[]{
                    new MenuItem("1 Cat", () -> new AddCatTemplate().output()),
                    new MenuItem("2 Dog", () -> new AddDogTemplate().output()),
                    new MenuItem("3 Hamster", () -> new AddHamsterTemplate().output()),
                    new MenuItem("4 Camel", () -> new AddCamelTemplate().output()),
                    new MenuItem("5 Donkey", () -> new AddDonkeyTemplate().output()),
                    new MenuItem("6 Horse", () -> new AddHorseTemplate().output()),
                    new MenuItem("7 Exit", () -> new BackTemplate().output())
            }
    );
}