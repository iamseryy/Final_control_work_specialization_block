package org.gbtask.view.template.impl;

import org.gbtask.view.template.Template;

import java.util.Optional;

public class AddCatTemplate  implements Template {
    @Override
    public void output() {
        ui.output("\nAdd a cat\n");
        ui.output("Complete the following fields or enter an empty string to cancel\n");

        Optional<String> nameOpt = ui.input("Name: ", String::toString);
        if(nameOpt.isEmpty()){
            ui.output("\nCancelled\n");
            return;
        }


    }
}
