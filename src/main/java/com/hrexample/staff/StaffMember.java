package com.hrexample.staff;

import java.util.HashSet;
import java.util.Collections;
import java.util.Date;
import java.util.Set;
import com.hrexample.SurrogateIdentity;
import com.hrexample.staff.role.JobRole;

/**
 * Abstract base class for domain entity classes representing members
 * of the organization's staff that provides some common attributes.
 * 
 * @since 1.o
 */
public abstract class StaffMember extends SurrogateIdentity {
  /** Job role(s) assigned to this staff member. */
  private final Set<JobRole> roles;
  /** Can this staff member contractually be enrolled in a benefits package? */
  private final boolean isEligibleForBenefits;
  /** Full legal name of staff member. */
  private String name;
  /** Date on which staff member entered service with organization. */
  private Date dateHired;
  
  /** Indicator that a staff member may be enrolled in a benefits package. */
  public final static boolean BENEFIT_ELIGIBLE = true;
  /** Indicator that a staff member may NOT be enrolled in a benefits package. */
  public final static boolean BENEFIT_INELIGIBLE = false;

  /**
   * Constructor that initializes an instance of this class.
   * 
   * @param anID 
   *   the ID of the instance, should be unique among instances of 
   *   a specific domain entity.
   * @param someRoles
   *   one or more job roles initially assigned to the staff member.
   * @param anEligibleFlag
   *   true if can be enrolled in benefits package at some point, false if  
   *   staff member is contractually never eligible for benefits.
   * @throws IllegalArgumentException
   *   if {@code someRoles} is NULL or is empty list (at least one job role is required).
   */
  protected StaffMember(final int anID, final Set<JobRole> someRoles, final boolean anEligibleFlag) {
    super(anID);
    if (null == someRoles || someRoles.size() == 0)
      throw new IllegalArgumentException("one or more JobRole must be specified");
    this.roles = new HashSet<JobRole>(someRoles);
    this.isEligibleForBenefits = anEligibleFlag;
  }
  
  /**
   * Constructor that initializes an instance of this class.
   * 
   * @param anID 
   *   the ID of the instance, should be unique among instances of 
   *   a specific domain entity.
   * @param someRoles
   *   one or more job roles initially assigned to the staff member.
   * @param anEligibleFlag
   *   true if can be enrolled in benefits package at some point, false if  
   *   staff member is contractually never eligible for benefits.
   * @param aName
   *   full legal name of staff member.
   * @param aHiredDate
   *   date on which staff member entered service with organization.
   * @throws IllegalArgumentException
   *   if {@code someRoles} is NULL or is empty list (at least one job role is required).
   */
  protected StaffMember(final int anID, final Set<JobRole> someRoles, final boolean anEligibleFlag,
      final String aName, final Date aHiredDate) {
    super(anID);
    if (null == someRoles || someRoles.size() == 0)
      throw new IllegalArgumentException("one or more JobRole must be specified");
    if (null == aName || aName.isEmpty() || aName.isBlank())
      throw new IllegalArgumentException("non-blank name must be specified");
    if (null == aHiredDate)
      throw new IllegalArgumentException("hire date must be specified");
    this.roles = new HashSet<JobRole>(someRoles);
    this.isEligibleForBenefits = anEligibleFlag;
    this.name = aName;
    this.dateHired = aHiredDate;
  }

  /**
   * Get the staff member name.
   * 
   * @return the full legal name
   */
  public String getName() {
    return this.name;
  }

  /**
   * Get the staff member name.
   * 
   * @param aName staff member's full legal name.
   */
  public void setName(final String aName) {
    this.name = aName;
  }

  /**
   * Get the date on which staff member entered service.
   * 
   * @return the service entry date
   */
  public Date getDateHired() {
    return this.dateHired;
  }

  /**
   * Set the date on which staff member entered service.
   * 
   * @param aHireDate date on which staff member entered service.
   */
  public void setDateHired(final Date aHireDate) {
    this.dateHired = aHireDate;
  }

  /**
   * Can this staff member be enrolled in a benefits package?
   *  
   * @return true if can be enrolled at some point, false if never eligible for benefits.
   */
  public boolean isEligibleForBenefits() {
    return this.isEligibleForBenefits;
  }

  /**
   * Get job role(s) assigned to this staff member.
   * 
   * @return assigned job roles
   */
  public Set<JobRole> getJobRoles() {
    return Collections.unmodifiableSet(this.roles);
  }
  
  /**
   * Check if specified role is assigned to this staff member.
   * 
   * @param aRoleToCheck role to check
   * @return true if role is assigned, false if not.
   */
  public boolean hasRole(final JobRole aRoleToCheck) {
    return this.roles.contains(aRoleToCheck);
  }
  
  /**
   * Assign job role(s) to this staff member, replacing any existing roles.
   * 
   * @param someRoles
   *   one or more job roles to assign to staff member.
   * @throws IllegalArgumentException
   *   if {@code someRoles} is NULL or is empty list (at least one job role is required).
   */
  public void setJobRoles(final Set<JobRole> someRoles) {
    if (null == someRoles || someRoles.size() == 0)
      throw new IllegalArgumentException("one or more JobRole must be specified");
    this.roles.clear();
    this.roles.addAll(someRoles);
  }

  /**
   * Assign additional job role to this staff member.
   * 
   * @param  aNewRole  new job role
   * @return true if new role was added, false if role was already assigned
   */
  public boolean addJobRole(final JobRole aNewRole) {
    return this.roles.add(aNewRole);
  }

  /**
   * Remove job role from this staff member.
   * 
   * @param  anExistingRole  job role to remove
   * @return true if role was removed, false if role was never assigned
   */
  public boolean removeJobRole(final JobRole anExistingRole) {
    return this.roles.remove(anExistingRole);
  }
}
