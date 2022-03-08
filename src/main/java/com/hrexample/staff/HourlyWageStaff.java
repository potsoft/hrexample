package com.hrexample.staff;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;
import com.hrexample.staff.role.JobRole;

/**
 * Abstract base class representing a staff member whose is paid an hourly wage.
 * 
 * @since 1.0
 */
public abstract class HourlyWageStaff extends StaffMember {
  /** Hourly wage of staff member. */
  private BigDecimal hourlyWage;

  /**
   * Constructor that initializes an instance of this class.
   * 
   * @param anID 
   *   the ID of the instance.
   * @param someRoles
   *   one or more job roles initially assigned to the staff member.
   * @param anEligibleFlag
   *   true if can be enrolled in benefits package at some point, false if  
   *   staff member is contractually never eligible for benefits.
   * @param aName
   *   full legal name of staff member.
   * @param aHiredDate
   *   date on which staff member entered service with organization.
   * @param aPerHourWage
   *   hourly wage of staff member.
   * @throws IllegalArgumentException
   *   if {@code aPerHourWage} is NULL or less than or equal to zero.
   */
  public HourlyWageStaff(final int anID, final Set<JobRole> someRoles, 
      final boolean anEligibleFlag, final String aName, final Date aHiredDate, 
      final BigDecimal aPerHourWage) {
    super(anID, someRoles, anEligibleFlag, aName, aHiredDate);
    if (null == aPerHourWage || aPerHourWage.intValue() <= 0)
      throw new IllegalArgumentException("hourly wage must be specified as greater than zero");
    this.hourlyWage = aPerHourWage;
  }

  /**
   * Get hourly wage of staff member.
   * 
   * @return hourly wage
   */
  public BigDecimal getHourlyWage() {
    return this.hourlyWage;
  }

  /**
   * Set hourly wage of staff member.
   * 
   * @param aPerHourWage
   *   hourly wage.
   * @throws IllegalArgumentException
   *   if {@code aPerHourWage} is NULL or less than or equal to zero.
   */
  public void setHourlyWage(final BigDecimal aPerHourWage) {
    if (null == aPerHourWage || aPerHourWage.intValue() <= 0)
      throw new IllegalArgumentException("hourly wage must be specified as greater than zero");
    this.hourlyWage = aPerHourWage;
  }
}
