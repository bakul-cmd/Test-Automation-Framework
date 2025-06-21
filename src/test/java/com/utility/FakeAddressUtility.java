package com.utility;

import java.util.Locale;

import com.github.javafaker.Faker;
import com.ui.pojo.AddressPOJO;

public class FakeAddressUtility {

	public static AddressPOJO getFakeAddress() {
		Faker faker=new Faker(new Locale("en-US"));
		
		AddressPOJO addressPojo=
				new AddressPOJO(faker.company().name(),
						faker.address().buildingNumber(),
						faker.address().streetAddress(),
						faker.address().city(),
						customZipCode(faker),
						faker.phoneNumber().cellPhone(),
						faker.phoneNumber().cellPhone(),"other","office ad",
						faker.address().state());
		
		return addressPojo;
		
	}
	
	private static String customZipCode(Faker faker) {
	
		String zip=String.format("%05d",faker.number().numberBetween(10000, 99999) );
		return zip;

	}

}
