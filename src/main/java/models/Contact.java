package models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import manager.ApplicationManager;

@Setter
@Getter
@Builder
@ToString
public class Contact
{
    String name;
    String lastName;
    String phone;
    String email;
    String address;
    String description;

}
