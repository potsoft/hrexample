package com.hrexample;

import org.junit.Test;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import com.hrexample.staff.ContractEmployee;
import com.hrexample.staff.FullTimeEmployee;
import com.hrexample.staff.HourlyWageStaff;
import com.hrexample.staff.PartTimeEmployee;
import com.hrexample.staff.StaffMember;
import com.hrexample.staff.role.JobRole;
import static org.junit.Assert.*;

/**
 * Unit test for HR employee example.
 */
public class AppTest {
  /** Incremented to obtain the next surrogate ID. */
  private static int nextId = 1;
  
  /** Obtain the next surrogate ID. */
  private static int getNextId() { return nextId++; }

  /** Convert {@LocalDate} to a {@code java.util.Date}. */
  private static Date convertToDate(final LocalDate aDateToConvert) { 
    return java.sql.Date.valueOf(aDateToConvert);
  }

  /** Test that a full-time employee can be instantiated correctly. */
  @Test
  public void testFullTimeEmployee() {
    // Create a full-time employee with manager role and verify attributes of
    // instantiated full-time employee instance.
    String expectedName = "Ed Too-Tall Jones";
    Date expectHireDate = convertToDate(LocalDate.of(1985, 10, 23));
    BigDecimal expectedSalary = BigDecimal.valueOf(3000000L);
    FullTimeEmployee fte = new FullTimeEmployee(getNextId(), JobRole.SINGLE_ROLE_MANAGER, 
      expectedName, expectHireDate, expectedSalary);
    
    assertTrue(SurrogateIdentity.class.isAssignableFrom(fte.getClass()));
    assertTrue(StaffMember.class.isAssignableFrom(fte.getClass()));
    assertFalse(HourlyWageStaff.class.isAssignableFrom(fte.getClass()));
    
    assertTrue("full-time employee has valid surrogate ID", fte.getId() < nextId);
    assertTrue("full-time employee is eligible for benefits", fte.isEligibleForBenefits());
    assertEquals("full-time employee name is correct", expectedName, fte.getName());
    assertEquals("full-time employee hire date is correct", expectHireDate, fte.getDateHired());
    assertEquals("full-time employee salary is correct", expectedSalary, fte.getSalary());
    assertTrue("full-time employee is manager", fte.hasRole(JobRole.MANAGER));
    
    // Add S/W development role and verify additional role..
    boolean wasRoleAdded = fte.addJobRole(JobRole.DEVELOPER);
    assertTrue("role added to full-time employee", wasRoleAdded);
 
    Set<JobRole> jobRoles = fte.getJobRoles();
    assertEquals("number of full-time employee roles is correct", 2, jobRoles.size());
    assertTrue("full-time employee is developer and manager", 
     jobRoles.contains(JobRole.DEVELOPER) && jobRoles.contains(JobRole.MANAGER));

    // Remove manager role and verify removal.
    boolean wasRoleRemoved = fte.removeJobRole(JobRole.MANAGER);
    assertTrue("role removed full-time employee", wasRoleRemoved);
    jobRoles = fte.getJobRoles();
    assertEquals("number of full-time employee roles is correct", 1, fte.getJobRoles().size());
    assertTrue("full-time employee is developer", fte.hasRole(JobRole.DEVELOPER));
  }

  /** Test that a part-time employee can be instantiated correctly. */
  @Test
  public void testPartTimeEmployee() {
    // Create a part-time employee with sales role and verify attributes of
    // instantiated part-time employee instance.
    String expectedName = "Anna Karenina";
    Date expectHireDate = convertToDate(LocalDate.of(2002, 12, 31));
    BigDecimal expectedHourlyWage = BigDecimal.valueOf(3050L, 2); // $30.50
    Integer expectedMinimumBenefitHours = Integer.valueOf(200);
    PartTimeEmployee pte = new PartTimeEmployee(getNextId(), JobRole.SINGLE_ROLE_SALESMAN, 
      expectedName, expectHireDate, expectedHourlyWage, expectedMinimumBenefitHours.intValue());
    
    assertTrue(SurrogateIdentity.class.isAssignableFrom(pte.getClass()));
    assertTrue(StaffMember.class.isAssignableFrom(pte.getClass()));
    assertTrue(HourlyWageStaff.class.isAssignableFrom(pte.getClass()));

    assertTrue("part-time employee is manager", pte.hasRole(JobRole.SALESMAN));
    assertTrue("part-time employee has valid surrogate ID", pte.getId() < nextId);
    assertTrue("part-time employee is eligible for benefits", pte.isEligibleForBenefits());
    assertEquals("part-time employee name is correct", expectedName, pte.getName());
    assertEquals("part-time employee hire date is correct", expectHireDate, pte.getDateHired());
    assertEquals("part-time employee salary is correct", expectedHourlyWage.unscaledValue().longValueExact(), 
      pte.getHourlyWage().unscaledValue().longValueExact());
  }

  /** Test that a contract employee can be instantiated correctly. */
  @Test
  public void testContractEmployee() {
    // Create a contract employee with sales role and verify attributes of
    // instantiated contract employee instance.
    String expectedName = "James Fenimore Cooper";
    Date expectHireDate = convertToDate(LocalDate.of(1999, 7, 4));
    BigDecimal expectedHourlyWage = BigDecimal.valueOf(5030L, 2); // $50.30
    Set<JobRole> expectedjobRoles = new HashSet<JobRole>(Arrays.asList(
      new JobRole[] { JobRole.ANALYST, JobRole.DEVELOPER, JobRole.TESTER }));
    ContractEmployee cte = new ContractEmployee(getNextId(), expectedjobRoles, 
      expectedName, expectHireDate, expectedHourlyWage);

    assertTrue(SurrogateIdentity.class.isAssignableFrom(cte.getClass()));
    assertTrue(StaffMember.class.isAssignableFrom(cte.getClass()));
    assertTrue(HourlyWageStaff.class.isAssignableFrom(cte.getClass()));

    assertTrue("contract employee has valid surrogate ID", cte.getId() < nextId);
    assertFalse("contract employee is eligible for benefits", cte.isEligibleForBenefits());
    assertEquals("contract employee name is correct", expectedName, cte.getName());
    assertEquals("contract employee hire date is correct", expectHireDate, cte.getDateHired());
    assertEquals("contract employee salary is correct", expectedHourlyWage.unscaledValue().longValueExact(), 
      cte.getHourlyWage().unscaledValue().longValueExact());

    Set<JobRole> jobRoles = cte.getJobRoles();
    assertEquals("number of contract employee roles is correct", 3, jobRoles.size());
    assertTrue(jobRoles.stream().allMatch(
      role -> JobRole.ANALYST.equals(role) || JobRole.DEVELOPER.equals(role) || JobRole.TESTER.equals(role)
    ));
  }
}