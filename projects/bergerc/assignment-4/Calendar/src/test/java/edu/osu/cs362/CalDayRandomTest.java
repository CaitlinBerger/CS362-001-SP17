package edu.osu.cs362;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for CalDay class.
 */



public class CalDayRandomTest {
    private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
    private static final int NUM_TESTS=100;

    /**
     * Generates a random Appt object
     */
    public static Appt randomAppointment(){
        long randomseed =System.currentTimeMillis();
//		System.out.println(" Seed:"+randomseed );
        Random random = new Random(randomseed);

        int startHour=ValuesGenerator.getRandomIntBetween(random, 0, 23);
        int startMinute=ValuesGenerator.getRandomIntBetween(random, 0, 59);
        int startDay=ValuesGenerator.getRandomIntBetween(random, -30, 60);
        int startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 12);
        int startYear=2017;
        String title=ValuesGenerator.getString(random);
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
     * Returns a randomly selected method to be tested
     */
    public static String RandomSelectMethod(Random random){
        String[] methodArray = new String[] {"addAppt"};// The list of the of methods to be tested in the Appt class

        int n = random.nextInt(methodArray.length);// get a random number between 0 (inclusive) and  methodArray.length (exclusive)

        return methodArray[n] ; // return the method name
    }


    /**
     * Generate Random Tests that tests CalDay Class.
     */
	 @Test
	  public void radnomtest()  throws Throwable  {
	     long startTime = Calendar.getInstance().getTimeInMillis();
         long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

         long randomseed =System.currentTimeMillis();
//		 System.out.println(" Seed:"+randomseed );
         Random random = new Random(randomseed);

         System.out.println("Start testing...");

         for (int iteration = 0; elapsed < TestTimeout; iteration++){
             //create a new CalDay object
             GregorianCalendar cal = new GregorianCalendar();
             CalDay day = new CalDay(cal);

             //test the "addAppt" function
             for (int i = 0; i < ValuesGenerator.RandInt(random); i++){
                 day.addAppt(randomAppointment());

             }


             day = null;

             elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
             if((iteration%10000)==0 && iteration!=0 )
                 System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
         }


         System.out.println("Done testing...");
	 }


	
}
