package edu.osu.cs362;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.Random;

import org.apache.commons.lang3.ObjectUtils;
import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for TimeTable class.
 */

public class TimeTableRandomTest {

    private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */

    /**
     * Generates a random Appt object.
     */
    public static Appt randomAppointment(Random random, String title){
        int startHour=ValuesGenerator.getRandomIntBetween(random, 0, 23);
        int startMinute=ValuesGenerator.getRandomIntBetween(random, 0, 59);
        int startDay=ValuesGenerator.getRandomIntBetween(random, 1, 31);
        int startMonth=ValuesGenerator.getRandomIntBetween(random, 0, 12);
        int startYear=2017;
        String description=ValuesGenerator.getString(random);
        //Construct a new Appointment object with the initial data
        Appt appt = new Appt(startHour,
                startMinute ,
                startDay ,
                startMonth ,
                startYear ,
                title,
                description);
        return appt;
    }

    /**
     * Generates a random CalDay object.
     */

   /* public static CalDay randomCalDay(Random random){
        //create calendar day
        GregorianCalendar cal = new GregorianCalendar();
        CalDay day = new CalDay(cal);

        //add random appointments
        for (int i = 0; i < ValuesGenerator.RandInt(random); i++){
            day.addAppt(randomAppointment(random));
        }
        return day;
    }
    */

    /**
     * Generate Random Tests that tests TimeTable Class.
     */
	 @Test
	  public void randomtest()  throws Throwable  {
         long startTime = Calendar.getInstance().getTimeInMillis();
         long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

         long randomseed =System.currentTimeMillis();
//		 System.out.println(" Seed:"+randomseed );
         Random random = new Random(randomseed);

         System.out.println("Start testing...");
         TimeTable tt = new TimeTable();

         for (int iteration = 0; elapsed < TestTimeout; iteration++){
             //create a linked list of appointments to feed in as input to deleteAppt function
             LinkedList<Appt> listAppts = new LinkedList<Appt>();
             LinkedList<Appt> temp = new LinkedList<Appt>();


             // generate some appointments
             for (int i = 0; i < ValuesGenerator.RandInt(random); i++){
                 String title = ValuesGenerator.getString(random);
                 listAppts.add(randomAppointment(random, title));
             }


             //select a random title from the linked list, and remove it
             for (int i = 0; (i < ValuesGenerator.getRandomIntBetween(random, 0, listAppts.size())-1); i++){
                 int index = ValuesGenerator.getRandomIntBetween(random, 0, listAppts.size()-1);
                 if (index%7 != 0){
                     //if (listAppts.get(index)!=null)
                         temp = tt.deleteAppt(listAppts, listAppts.get(index));
                 } else {
                     int startHour=15;
                     int startMinute=30;
                     int startDay=-10; 		//11
                     int startMonth=5; 	//4
                     int startYear=2017;
                     String title="Birthday Party";
                     String description="This is my birthday party.";
                     Appt appt = new Appt(startHour,
                             startMinute ,
                             startDay ,
                             startMonth ,
                             startYear ,
                             title,
                             description);
                     listAppts.add(appt);

                     temp = tt.deleteAppt(listAppts, listAppts.getLast());
                     temp = tt.deleteAppt(listAppts, null);
                     temp = tt.deleteAppt(null, listAppts.getLast());
                     temp = tt.deleteAppt(listAppts, randomAppointment(random, ValuesGenerator.getString(random)));
                 }
             }



             elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
             if((iteration%10000)==0 && iteration!=0 )
                 System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
         }


         System.out.println("Done testing...");


	 }


	/*@Test
    public void test2() throws Throwable  {
        long randomseed =System.currentTimeMillis();
//		System.out.println(" Seed:"+randomseed );
        Random random = new Random(randomseed);
        LinkedList<Appt> listAppts = new LinkedList<Appt>();
        for (int i = 0; i < ValuesGenerator.RandInt(random); i++){
            String title = ValuesGenerator.getString(random);
            listAppts.add(randomAppointment(random, title));
        }
        int startHour=15;
        int startMinute=30;
        int startDay=-10; 		//11
        int startMonth=5; 	//4
        int startYear=2017;
        String title="Birthday Party";
        String description="This is my birthday party.";
        Appt appt = new Appt(startHour,
                startMinute ,
                startDay ,
                startMonth ,
                startYear ,
                title,
                description);
        listAppts.add(appt);

        TimeTable tt = new TimeTable();

        listAppts = tt.deleteAppt(listAppts, listAppts.getLast());

        listAppts = tt.deleteAppt(listAppts, null);
        //listAppts = tt.deleteAppt(null, listAppts.getLast());


    }*/


}
