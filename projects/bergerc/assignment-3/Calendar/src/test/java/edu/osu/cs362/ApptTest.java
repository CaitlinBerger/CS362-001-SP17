package edu.osu.cs362;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Caitlin on 5/1/2017.
 */
public class ApptTest {
	@Test
	public void test1() throws Throwable {
		int startHour=13;
		int startMinute=30;
		int startDay=10;
		int startMonth=4;
		int startYear=2017;
		String title="Birthday Party";
		String description="This is my birthday party.";
		//Construct a new Appointment object with the initial data
		Appt appt = new Appt(startHour,
				startMinute ,
				startDay ,
				startMonth ,
				startYear ,
				title,
				description);
		// assertions
		assertTrue(appt.getValid());
		assertEquals(13, appt.getStartHour());
		assertEquals(30, appt.getStartMinute());
		assertEquals(10, appt.getStartDay());
		assertEquals(04, appt.getStartMonth());
		assertEquals(2017, appt.getStartYear());
		assertEquals("Birthday Party", appt.getTitle());
		assertEquals("This is my birthday party.", appt.getDescription());

		// change start hour, minute, day, month, year to invalid numbers to test the result,
		//  then reset to another valid value, to test the setvalue functions.
		appt.setStartHour(-1);
		assertFalse(appt.getValid());
		appt.setStartHour(1);

		appt.setStartMinute(62);
		assertFalse(appt.getValid());
		appt.setStartMinute(0);

		appt.setStartDay(0);
		assertFalse(appt.getValid());
		appt.setStartDay(15);

		appt.setStartMonth(13);
		assertFalse(appt.getValid());
		appt.setStartMonth(6);

		//test setDescription and setTitle functions

		title = "21st Birthday";
		description = "It's going to be lit.";

		appt.setStartYear(2018);
		appt.setTitle(title);
		appt.setDescription(description);

		assertTrue(appt.getValid());
		assertEquals(1, appt.getStartHour());
		assertEquals(0, appt.getStartMinute());
		assertEquals(15, appt.getStartDay());
		assertEquals(6, appt.getStartMonth());
		assertEquals(2018, appt.getStartYear());
		assertEquals("21st Birthday", appt.getTitle());
		assertEquals("It's going to be lit.", appt.getDescription());

	}

	@Test
	public void test2() throws Throwable{
		int startHour=31;
		int startMinute=30;
		int startDay=10;
		int startMonth=4;
		int startYear=2017;
		String title="Birthday Party";
		String description="This is my birthday party.";
		String printResult;
		//Construct a new Appointment object with the initial data
		Appt appt = new Appt(startHour,
				startMinute ,
				startDay ,
				startMonth ,
				startYear ,
				title,
				description);

		assertEquals(null, appt.toString());

		appt.setStartHour(13);
		assertEquals("\t4/10/2017 at 1:30pm ,Birthday Party, This is my birthday party.\n", appt.toString());

	}



}