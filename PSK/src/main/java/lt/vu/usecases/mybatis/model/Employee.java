package lt.vu.usecases.mybatis.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Employee {

    private Integer id;
    private String firstName;
    private String lastName;
    private Integer companyId;
    private String registrationNo;

    // Rankomis prirašyti:
    private Company company;
    private List<Deed> deeds;
}