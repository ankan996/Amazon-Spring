package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//Spring will automatically register this bean when it will get @Component into the spring container
// with a bean id as "thatSillyCoach"

//@Component("thatSillyCoach")


@Component("tennisCoach")
@Scope("prototype")
public class TennisCoach implements Coach {
	
	// setting up a private field for FortuneService
	private FortuneService FortuneService;
	/*
	 * @Autowired
	 * 
	 * @Qualifier("randomFortuneService") private FortuneService fortuneService;
	 */
	
	// constructor injection
		@Autowired
	public TennisCoach(@Qualifier("randomFortuneService")FortuneService theFortuneService) {
		this.FortuneService = theFortuneService;
	}
	
	// default constructor
	
	public TennisCoach() {
		System.out.println("----- TennisCoach: Inside default constructor -----");
	}
	
	// define a setter method
	
	/*
	 * @Autowired public void setFortuneService(FortuneService theFortuneService) {
	 * System.out.
	 * println("----- TennisCoach: Inside setFortuneService() method -----");
	 * this.fortuneService = theFortuneService;
	 * 
	 * }
	 */
	
	
	/*
	 * @Autowired public void ankan(FortuneService theFortuneService) {
	 * System.out.println("----- TennisCoach: Inside Ankan() method -----");
	 * this.fortuneService = theFortuneService;
	 * 
	 * }
	 */

	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley!";
	}

	@Override
	public String getDailyFortune() {
		
		return FortuneService.getFortune();
	}

}
