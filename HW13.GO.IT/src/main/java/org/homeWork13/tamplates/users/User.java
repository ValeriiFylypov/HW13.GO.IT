package org.homeWork13.tamplates.users;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class User{
    public int id;
    public String name;
    public String username;
    public String email;
    public Address address;
    public String phone;
    public String website;
    public Company company;

}

