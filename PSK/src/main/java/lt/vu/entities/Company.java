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
@Table(name = "COMPANY")
@NamedQueries({
    @NamedQuery(name = "Company.findAll", query = "SELECT u FROM Company u"),
    @NamedQuery(name = "Company.findById", query = "SELECT u FROM Company u WHERE u.id = :id"),
    @NamedQuery(name = "Company.findByTitle", query = "SELECT u FROM Company u WHERE u.title = :title"),
    @NamedQuery(name = "Company.findByOptLockVersion", query = "SELECT u FROM Company u WHERE u.optLockVersion = :optLockVersion")})
@Getter
@Setter
@EqualsAndHashCode(of = "title")
@ToString(of = {"id", "title"})
public class Company implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Size(max = 50)
    @Column(name = "TITLE")
    private String title;

    @Version
    @Column(name = "OPT_LOCK_VERSION")
    private Integer optLockVersion;

    @OneToMany(mappedBy = "company")
    private List<Employee> employeeList = new ArrayList<>();
}
