package br.com.thiagoft.examples;

import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 * Java 8 have now a new Date/Time Api.
 *
 * @author thiagofonseca
 */
public class UsingDates {

    public static void main(String[] args) {
        /**
         * LocalDate is a new class for the instant Date.
         * the method now() returns the current Date.
         * OBS: just the Date: xx/xx/xxxx according of your system Locale
         */
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);

        /**
         * of allows you to set a custom Date.
         * Some examples of methods of a LocalDate bellow.
         */
        LocalDate birthDay = LocalDate.of(1988, Month.JULY, 14);
        birthDay.getDayOfMonth();
        birthDay.getDayOfWeek();
        birthDay.getDayOfYear();
        birthDay.getMonth();
        birthDay.getYear();

        /**
         * The class Period can manipulate dates
         */
        Period period = Period.between(birthDay, localDate);
        System.out.println(period.getYears());


        /**
         * Some other methods of LocalDate.
         * The same can be done with minus.
         */
        LocalDate dataCalculada = LocalDate.now();
        dataCalculada = dataCalculada.plusDays(1);
        dataCalculada = dataCalculada.plusMonths(1);
        dataCalculada = dataCalculada.plusWeeks(1);
        dataCalculada = dataCalculada.plusYears(1);

        dataCalculada = dataCalculada.plus(Period.ofDays(1));

        /**
         * The new DateTimeFormatter
         * You can write the pattern as you want, dd/MM/yyyy hh:mm:ss,
         * OBS: Take care about the type of object that you are formatting,
         * the pattern must support the object Type.
         */
        DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println(dataCalculada.format(formatterDate));

        /**
         * The LocalDateTime works like LocalDate but with time properties
         */
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatterDateTime = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
        System.out.println(localDateTime.format(formatterDateTime));

        /**
         * The LocalTime works like LocalDate but just with time properties
         */
        LocalTime localTime = LocalTime.now();
        DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("hh:mm:ss");
        System.out.println(localTime.format(formatterTime));

    }

}
