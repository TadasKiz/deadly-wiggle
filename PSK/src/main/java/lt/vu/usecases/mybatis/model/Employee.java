package lt.vu.usecases.mybatis.model;

import java.util.List;

public class Employee {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.EMPLOYEE.ID
     *
     * @mbg.generated Mon May 06 19:02:24 EEST 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.EMPLOYEE.FIRST_NAME
     *
     * @mbg.generated Mon May 06 19:02:24 EEST 2019
     */
    private String firstName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.EMPLOYEE.LAST_NAME
     *
     * @mbg.generated Mon May 06 19:02:24 EEST 2019
     */
    private String lastName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.EMPLOYEE.COMPANY_ID
     *
     * @mbg.generated Mon May 06 19:02:24 EEST 2019
     */
    private Integer companyId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.EMPLOYEE.REGISTRATION_NO
     *
     * @mbg.generated Mon May 06 19:02:24 EEST 2019
     */
    private String registrationNo;

    /**
     * HAND WRITTEN EXTRAS
     */

    private Company company;
    private List<Deed> deeds;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Deed> getDeeds() {
        return deeds;
    }

    public void setDeeds(List<Deed> deeds) {
        this.deeds = deeds;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.EMPLOYEE.ID
     *
     * @return the value of PUBLIC.EMPLOYEE.ID
     *
     * @mbg.generated Mon May 06 19:02:24 EEST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.EMPLOYEE.ID
     *
     * @param id the value for PUBLIC.EMPLOYEE.ID
     *
     * @mbg.generated Mon May 06 19:02:24 EEST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.EMPLOYEE.FIRST_NAME
     *
     * @return the value of PUBLIC.EMPLOYEE.FIRST_NAME
     *
     * @mbg.generated Mon May 06 19:02:24 EEST 2019
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.EMPLOYEE.FIRST_NAME
     *
     * @param firstName the value for PUBLIC.EMPLOYEE.FIRST_NAME
     *
     * @mbg.generated Mon May 06 19:02:24 EEST 2019
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.EMPLOYEE.LAST_NAME
     *
     * @return the value of PUBLIC.EMPLOYEE.LAST_NAME
     *
     * @mbg.generated Mon May 06 19:02:24 EEST 2019
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.EMPLOYEE.LAST_NAME
     *
     * @param lastName the value for PUBLIC.EMPLOYEE.LAST_NAME
     *
     * @mbg.generated Mon May 06 19:02:24 EEST 2019
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.EMPLOYEE.COMPANY_ID
     *
     * @return the value of PUBLIC.EMPLOYEE.COMPANY_ID
     *
     * @mbg.generated Mon May 06 19:02:24 EEST 2019
     */
    public Integer getCompanyId() {
        return companyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.EMPLOYEE.COMPANY_ID
     *
     * @param companyId the value for PUBLIC.EMPLOYEE.COMPANY_ID
     *
     * @mbg.generated Mon May 06 19:02:24 EEST 2019
     */
    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.EMPLOYEE.REGISTRATION_NO
     *
     * @return the value of PUBLIC.EMPLOYEE.REGISTRATION_NO
     *
     * @mbg.generated Mon May 06 19:02:24 EEST 2019
     */
    public String getRegistrationNo() {
        return registrationNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.EMPLOYEE.REGISTRATION_NO
     *
     * @param registrationNo the value for PUBLIC.EMPLOYEE.REGISTRATION_NO
     *
     * @mbg.generated Mon May 06 19:02:24 EEST 2019
     */
    public void setRegistrationNo(String registrationNo) {
        this.registrationNo = registrationNo;
    }
}