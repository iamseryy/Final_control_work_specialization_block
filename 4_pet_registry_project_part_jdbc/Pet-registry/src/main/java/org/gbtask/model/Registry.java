package org.gbtask.model;

import org.gbtask.model.base.Animal;

import java.util.Calendar;


public record Registry(int id, Animal animal, String note, Calendar createdDate) {
}
