package org.homeWork13.tamplates.todo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Todo {
    public int userId;
    public int id;
    public String title;
    public boolean completed;
}
