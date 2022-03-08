package com.hrexample.staff;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;
import com.hrexample.staff.role.JobRole;

/**
 * Represent a statutory, part-time employee whose is paid an hourly wage and
 * is eligible for benefits after working a certain number of hours.
 * 
 * @since 1.0
 */
public class PartTimeEmployee extends HourlyWageStaff {
  /** Number of hours that must be worked to be eligible for benefits. */
  private int minimumBenefitHours;

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
   * @param aPerHourWage
   *   hourly wage of employee.
   * @param aMinBenefitHours
   *   hours that must be worked to be eligible for benefits.
   * @throws IllegalArgumentException
   *   if {@code aMinBenefitHours} is less than zero.
   */
  public PartTimeEmployee(final int anID, final Set<JobRole> someRoles, final String aName, 
      final Date aHiredDate, final BigDecimal aPerHourWage, final int aMinBenefitHours) {
    super(anID, someRoles, BENEFIT_ELIGIBLE, aName, aHiredDate, aPerHourWage);
    if (aMinBenefitHours < 0)
      throw new IllegalArgumentException("minimum benefit hours cannot be negative");
    this.minimumBenefitHours = aMinBenefitHours;
  }

  /**
   * Get number of hours that must be worked to be eligible for benefits.
   * 
   * @return hours to be eligible for benefits.
   */
  public int getMinimumBenefitHours() {
    return this.minimumBenefitHours;
  }

  /**
   * Set hours that must be worked to be eligible for benefits
   * 
   * @param aMinBenefitHours
   *   hours to be eligible for benefits.
   * @throws IllegalArgumentException
   *   if {@code aMinBenefitHours} is less than zero.
   */
  public void setMinimumBenefitHours(final int aMinBenefitHours) {
    if (aMinBenefitHours < 0)
      throw new IllegalArgumentException("minimum benefit hours cannot be negative");
    this.minimumBenefitHours = aMinBenefitHours;
  }
}
