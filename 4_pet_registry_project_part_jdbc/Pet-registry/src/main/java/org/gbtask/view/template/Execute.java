package org.gbtask.view.template;

import org.gbtask.model.base.Animal;


@FunctionalInterface
public interface Execute {
    void AnimalExecute(Animal animal);
}