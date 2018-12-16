/**
 * This file was generated by the Jeddict
 */
package Entity.domain;

import java.time.LocalDate;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * @author puyaa
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(length = 31)
public abstract class Person {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "person_id")
    private Long personId;

    @Basic
    @Column(name = "first_name")
    private String firstName;

    @Basic
    @Column(name = "last_name")
    private String lastName;

    @Basic
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Basic
    @Enumerated(EnumType.STRING)
    private Gender gender;

    public Person() {
    }

    public Person(Long personId, String firstName, String lastName, Gender gender) {
        this.personId = personId;
        this.firstName = firstName;
        this.lastName = lastName;

        this.gender = gender;
    }

    public Long getPersonId() {
        return this.personId;
    }

    public void setPerson_id(Long personId) {
        this.personId = personId;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Gender getGender() {
        return this.gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return " personId=" + personId + ", firstName=" + firstName + ", lastName=" + lastName + ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + '}';
    }

}
