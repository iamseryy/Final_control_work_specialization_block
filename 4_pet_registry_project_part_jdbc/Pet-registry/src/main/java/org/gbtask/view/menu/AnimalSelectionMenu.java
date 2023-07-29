package org.gbtask.view.menu;

import org.gbtask.view.template.impl.AddAnimalTemplate;
import org.gbtask.view.template.impl.AddCatTemplate;
import org.gbtask.view.template.impl.ExitTemplate;

import java.util.Arrays;
import java.util.List;

public interface AnimalSelectionMenu {
    String header = "\nChoose the animal\n";
    List<MenuItem> menuItems = Arrays.asList(
            new MenuItem[]{
                    new MenuItem("1 Cat", () -> new AddCatTemplate().output()),
                    new MenuItem("2 Dog", () -> new AddAnimalTemplate().output()),
                    new MenuItem("3 Exit", () -> new ExitTemplate().output())
            }
    );
}