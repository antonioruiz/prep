package com.aruiz.java8core;

import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.aruiz.java8core.Person.Sex;

public class Person {
	
	public enum Sex {
        MALE, FEMALE
    }

    String name;
    LocalDate birthday;
    Sex gender;
    String emailAddress;
    

    public Person(String name, LocalDate birthday, Sex gender, String emailAddress) {
		super();
		this.name = name;
		this.birthday = birthday;
		this.gender = gender;
		this.emailAddress = emailAddress;
	}


	public int getAge() {
		LocalDate today = LocalDate.now();
		int result = today.getYear()- birthday.getYear();
		if(today.getMonthValue() < birthday.getMonthValue()){
			result--;
		}else if(today.getMonthValue() == birthday.getMonthValue() && 
				today.getDayOfMonth() < birthday.getDayOfMonth()){
			result--;
		}
		
        return result;
    }

    
    @Override
	public String toString() {
		return "Person [name=" + name + ", gender=" + gender  +", birthday="+ birthday + ", emailAddress=" + emailAddress + "]";
	}


	public void printPerson() {
        System.out.println(this);
    }


	public static List<Person> createRoster() {

		ArrayList<Person> result = new ArrayList<Person>();
		result.add(new Person("joe", Year.parse("1980").atMonth(5).atDay(10), Sex.MALE, "joe@email.com"));
		result.add(new Person("natalie", Year.parse("2000").atMonth(2).atDay(14), Sex.FEMALE, "nat@email.net"));
		result.add(new Person("paul", Year.parse("1970").atMonth(8).atDay(7), Sex.FEMALE, "paul@email.net"));
		result.add(new Person("tomorrow", Year.parse("1997").atMonth(8).atDay(4), Sex.FEMALE, "tomorrow@email.net"));
		result.add(new Person("today", Year.parse("1997").atMonth(8).atDay(3), Sex.MALE, "today@email.net"));
		return result;
	}


	public Sex getGender() {
		return this.gender;
	}


	public String getEmailAddress() {
		return this.emailAddress;
	}

}
