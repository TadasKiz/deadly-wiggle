/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.vu.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.johnzon.mapper.JohnzonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "EMPLOYEE")
@NamedQueries({
    @NamedQuery(name = "Employee.findAll", query = "SELECT s FROM Employee s"),
    @NamedQuery(name = "Employee.findById", query = "SELECT s FROM Employee s WHERE s.id = :id"),
    @NamedQuery(name = "Employee.findByFirstName", query = "SELECT s FROM Employee s WHERE s.firstName LIKE :firstName"),
    @NamedQuery(name = "Employee.findByLastName", query = "SELECT s FROM Employee s WHERE s.lastName LIKE :lastName"),
    @NamedQuery(name = "Employee.findByRegistrationNo", query = "SELECT s FROM Employee s WHERE s.registrationNo = :registrationNo")
})
@Getter
@Setter
@EqualsAndHashCode(of = "registrationNo")
@ToString(of = {"id", "firstName", "lastName", "registrationNo"})
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Size(min = 3, max = 20)
    @Column(name = "FIRST_NAME")
    private String firstName;

    @Size(min = 3, max = 20)
    @Column(name = "LAST_NAME")
    private String lastName;

    @Size(min = 3, max = 20)
    @Column(name = "REGISTRATION_NO")
    private String registrationNo;

    @Version
    @Column(name = "OPT_LOCK_VERSION")
    private Integer optLockVersion;

    @JoinTable(name = "Employee_Deed", joinColumns = {
        @JoinColumn(name = "EMPLOYEE_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "DEED_ID", referencedColumnName = "ID")})
    @ManyToMany
    @JohnzonIgnore
    private List<Deed> deedList = new ArrayList<>();

    @JoinColumn(name = "COMPANY_ID", referencedColumnName = "ID")
    @ManyToOne
    @JohnzonIgnore
    private Company company;

}
