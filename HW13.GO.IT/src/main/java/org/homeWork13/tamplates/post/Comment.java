package org.homeWork13.tamplates.post;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class        Comment {
    public int postId;
    public int id;
    public String name;
    public String email;
    public String body;
}
