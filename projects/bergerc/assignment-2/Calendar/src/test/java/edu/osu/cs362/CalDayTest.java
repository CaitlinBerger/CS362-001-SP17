package edu.osu.cs362;

import org.junit.Test;

import java.util.GregorianCalendar;
import java.util.LinkedList;

import static org.junit.Assert.*;

/**
 * Created by Caitlin on 5/1/2017.
 */
public class CalDayTest {
    @Test
    public void test0() throws Throwable {
        CalDay day = new CalDay();
        assertEquals(null, day.iterator());

        try{

        }catch(Exception e){}
    }

    @Test
    public void test1() throws Throwable {
        GregorianCalendar cal = new GregorianCalendar();
        CalDay day = new CalDay(cal);
        assertEquals(cal.get(cal.DAY_OF_MONTH), day.getDay());
        assertEquals(cal.get(cal.MONTH), day.getMonth());
        assertEquals(cal.get(cal.YEAR), day.getYear());

        int startHour=13;
        int startMinute=30;
        int startDay=10;
        int startMonth=4;
        int startYear=2017;
        String title="Birthday Party";
        String description="This is my birthday party.";
        //Construct a new Appointment object
        Appt appt = new Appt(startHour,
                startMinute ,
                startDay ,
                startMonth ,
                startYear ,
                title,
                description);
        day.addAppt(appt);

        LinkedList<Appt> appts = new LinkedList<Appt>();
        appts.add(appt);
        assertEquals(appts, day.getAppts());

        startHour=7;
        startMinute=30;
        startDay=10;
        startMonth=4;
        startYear=2017;
        title="Calculus Test";
        description="Section 3.1-3.7";
        Appt appt2 = new Appt(startHour,
                startMinute ,
                startDay ,
                startMonth ,
                startYear ,
                title,
                description);
        day.addAppt(appt2);
        appts = new LinkedList<Appt>();
        appts.add(appt2);
        appts.add(appt);
        assertEquals(appts, day.getAppts());
        assertEquals(2, day.getSizeAppts());

        assertEquals("\t --- 4/1/2017 --- \n" +
                " --- -------- Appointments ------------ --- \n" +
                "\t4/10/2017 at 7:30am ,Calculus Test, Section 3.1-3.7\n" +
                " \t4/10/2017 at 1:30pm ,Birthday Party, This is my birthday party.\n" +
                " \n", day.toString());

    }

}