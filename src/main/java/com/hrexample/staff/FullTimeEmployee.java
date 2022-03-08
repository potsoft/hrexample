package com.hrexample.staff;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;
import com.hrexample.staff.role.JobRole;

/**
 * Represent a statutory, full-time employee whose is paid an annual salary.
 * 
 * @since 1.0
 */
public class FullTimeEmployee extends StaffMember {
  /** Annual salary of employee. */
  private BigDecimal salary;

  /**
   * Constructor that initializes an instance of this class.
   * 
   * @param anID 
   *   the ID of the instance.
   * @param someRoles
   *   one or more job roles initially assigned to the employee.
   * @param aName
   *   full legal name of employee.
   * @param aHiredDate
   *   date on which employee entered service with organization.
   * @param aSalary
   *   annual salary of employee.
   * @throws IllegalArgumentException
   *   if {@code aSalary} is NULL or less than or equal to zero.
   */
  public FullTimeEmployee(final int anID, final Set<JobRole> someRoles, 
      final String aName, final Date aHiredDate, final BigDecimal aSalary) {
    super(anID, someRoles, BENEFIT_ELIGIBLE, aName, aHiredDate);
    if (null == aSalary || aSalary.intValue() <= 0)
      throw new IllegalArgumentException("salary must be specified as greater than zero");
    this.salary = aSalary;
  }

  /**
   * Get annual salary of employee.
   * 
   * @return the salary
   */
  public BigDecimal getSalary() {
    return this.salary;
  }

  /**
   * Set annual salary of employee.
   * 
   * @param aSalary
   *   annual salary.
   * @throws IllegalArgumentException
   *   if {@code aSalary} is NULL or less than or equal to zero.
   */
  public void setSalary(final BigDecimal aSalary) {
    if (null == aSalary || aSalary.intValue() <= 0)
      throw new IllegalArgumentException("salary must be specified as greater than zero");
    this.salary = aSalary;
  }
}
