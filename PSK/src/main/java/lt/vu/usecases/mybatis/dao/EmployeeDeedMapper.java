package lt.vu.usecases.mybatis.dao;

import lt.vu.usecases.mybatis.model.EmployeeDeed;
import org.apache.ibatis.annotations.Param;
import org.mybatis.cdi.Mapper;

import java.util.List;

@Mapper
public interface EmployeeDeedMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.EMPLOYEE_DEED
     *
     * @mbg.generated Mon May 06 19:02:24 EEST 2019
     */
    int deleteByPrimaryKey(@Param("employeeId") Integer employeeId, @Param("deedId") Integer deedId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.EMPLOYEE_DEED
     *
     * @mbg.generated Mon May 06 19:02:24 EEST 2019
     */
    int insert(EmployeeDeed record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.EMPLOYEE_DEED
     *
     * @mbg.generated Mon May 06 19:02:24 EEST 2019
     */
    List<EmployeeDeed> selectAll();
}