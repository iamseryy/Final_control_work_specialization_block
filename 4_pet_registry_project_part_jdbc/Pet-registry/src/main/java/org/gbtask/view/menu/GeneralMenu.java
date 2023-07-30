package org.gbtask.view.menu;

import org.gbtask.view.template.impl.AddAnimalTemplate;
import org.gbtask.view.template.impl.ExitTemplate;
import org.gbtask.view.template.impl.FindAnimalTemplate;
import org.gbtask.view.template.impl.PrintRegistryTemplate;

import java.util.Arrays;
import java.util.List;

public interface GeneralMenu {
    String header = "\nPet registry\n";
    List<MenuItem> generalMenuItems = Arrays.asList(
            new MenuItem[] {
                    new MenuItem("1 Print registry", () -> new PrintRegistryTemplate().output()),
                    new MenuItem("2 Find animal by id", () -> new FindAnimalTemplate().output()),
                    new MenuItem("3 Add animal", () -> new AddAnimalTemplate().output()),
                    new MenuItem("4 Exit", () -> new ExitTemplate().output())
            }
    );
}
