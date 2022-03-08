package com.hrexample.staff;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;
import com.hrexample.staff.role.JobRole;

/**
 * Represent a contract employee whose is paid an hourly wage and is not
 * eligible for benefits.
 * 
 * @since 1.0
 */
public class ContractEmployee extends HourlyWageStaff {
  /**
   * Constructor that initializes an instance of this class.
   * 
   * @param anID 
   *   the ID of the instance.
   * @param someRoles
   *   one or more job roles initially assigned to the contractor.
   * @param aName
   *   full legal name of contractor.
   * @param aHiredDate
   *   date on which contractor entered service with organization.
   * @param aPerHourWage
   *   hourly wage of contractor.
   * @throws IllegalArgumentException
   *   if {@code aMinBenefitHours} is less than zero.
   */
  public ContractEmployee(final int anID, final Set<JobRole> someRoles, 
      final String aName, final Date aHiredDate, final BigDecimal aPerHourWage) {
    super(anID, someRoles, BENEFIT_INELIGIBLE, aName, aHiredDate, aPerHourWage);
  }
}
