package com.hrexample.staff.role;

import java.util.Collections;
import java.util.Set;

import com.hrexample.SurrogateIdentity;

/**
 * Represents a role that staff member plays in the job, and defines the available roles.
 * 
 * @since 1.0
 */
public class JobRole extends SurrogateIdentity {
  /** Management role. */
  public final static JobRole MANAGER = new JobRole(1, "manager");
  /** Management role as singleton set for convenience. */
  public final static Set<JobRole> SINGLE_ROLE_MANAGER = Collections.singleton(MANAGER);
  
  /** Statutory executive role. */
  public final static JobRole EXECUTIVE = new JobRole(2, "executive");
  /** Management role as singleton set for convenience. */
  public final static Set<JobRole> SINGLE_ROLE_EXECUTIVE = Collections.singleton(EXECUTIVE);
  
  /** Business development role. */  
  public final static JobRole SALESMAN = new JobRole(3, "salesman");
  /** Business development role as singleton set for convenience. */
  public final static Set<JobRole> SINGLE_ROLE_SALESMAN = Collections.singleton(SALESMAN);
  
  /** Solution analyst role. */
  public final static JobRole ANALYST = new JobRole(4, "analyst");
  /** Solution analyst role as singleton set for convenience. */
  public final static Set<JobRole> SINGLE_ROLE_ANALYST = Collections.singleton(ANALYST);

  /** Software development role. */
  public final static JobRole DEVELOPER = new JobRole(5, "developer");
  /** Software development role as singleton set for convenience. */
  public final static Set<JobRole> SINGLE_ROLE_DEVELOPER = Collections.singleton(DEVELOPER);
  
  /** Software QA role. */
  public final static JobRole TESTER = new JobRole(6, "tester");
  /** Software QA role as singleton set for convenience. */
  public final static Set<JobRole> SINGLE_ROLE_TESTER = Collections.singleton(TESTER);

  /** Name of this job role. */
  private final String name;

  /**
   * Constructor that initializes an instance of this class.
   * 
   * @param anID 
   *   the ID of the instance, should be unique among job role instances.
   * @param aRoleName
   *   unique name of role.
   */
  private JobRole(final int anID, final String aRoleName) {
    super(anID);
    this.name = aRoleName;
  }

  /**
   * Get the name of this job role.
   * 
   * @return the role name.
   */
  public String getName() {
    return this.name;
  }
}
