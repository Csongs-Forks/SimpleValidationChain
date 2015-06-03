package net.bircs.validation.generic;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.Years;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class DateValidationUtil {
	
	private char separatorChar = '/';
	String datePattern = "dd/MM/yyyy";

	public int getAge(String date) {
		DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy");
		DateTime birthdate = formatter.parseDateTime(date);
		DateTime now = new DateTime();
		Years age = Years.yearsBetween(birthdate, now);
		return age.getYears();
	}

	private char getSeparator() {
		return separatorChar;
	}

	public String getPattern() {
		return this.datePattern;
	}
}
