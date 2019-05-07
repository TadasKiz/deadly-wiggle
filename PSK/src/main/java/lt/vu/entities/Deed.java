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

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "DEED")
@NamedQueries({
    @NamedQuery(name = "Deed.findAll", query = "SELECT c FROM Deed c"),
    @NamedQuery(name = "Deed.findById", query = "SELECT c FROM Deed c WHERE c.id = :id"),
    @NamedQuery(name = "Deed.findByName", query = "SELECT c FROM Deed c WHERE c.name = :name"),
    @NamedQuery(name = "Deed.findByOptLockVersion", query = "SELECT c FROM Deed c WHERE c.optLockVersion = :optLockVersion")})
@Getter
@Setter
@EqualsAndHashCode(of = "name")
@ToString(of = {"id", "name"})
public class Deed implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Size(min = 4, max = 50)
    @Column(name = "NAME")
    private String name;

    @Version
    @Column(name = "OPT_LOCK_VERSION")
    private Integer optLockVersion;

    @ManyToMany(mappedBy = "deedList")
    private List<Employee> employeeList = new ArrayList<>();
}
