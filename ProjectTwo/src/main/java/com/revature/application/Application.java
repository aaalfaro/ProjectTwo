package com.revature.application;

import com.revature.model.Status;
import com.revature.model.Trainee;
import com.revature.service.StatusService;
import com.revature.service.TraineeService;

public class Application {

	//This class was used to populate the Dummy DB
	
	public static void main(String[] args) {
		
//		String[] arr = {"Patrick Walsh", "Dan Pickles", "Karan Dhirar", "Brian Connolly",
//				"Genesis Bonds", "Ankit Garg", "Ryan Lessley", "Steven Kelsey", "Emily Higgins",
//				"Taylor Kemper", "Richard Orr", "Nickolas Jurczak", "Yuvaraj Damodaran", "Fred Belotte",
//				"Mehrab Rahman", "Peter Alagna", "Stanley Medikonda", "Gray Wynne", "Orson Wallace",
//				"Shelby Levinson", "Walter Payne", "Natalie Church", "Archer Radcliff", "Raghavan Swaminathan"};
//
//		for(int i = 0; i<arr.length;i++ ) {
//			TrainerService.insertNewTrainer(new Trainer(arr[i]));
//		}
		
//		String[] arr = {"J2EE", ".NET", "SDET", "BPM", "Appian BPM", "PEGA BPM", "Microsoft Dynamics 365", "JTA", "Microservices", "Oracle Fusion",
//				"Salesforce", "Business Analyst", "System Admin", "QA", "Other"};
//		for(int i = 0; i<arr.length;i++ ) {
//			SkillTypeService.addSkill(new SkillType(arr[i]));
//		}
		
//		List<Trainer> trainers = TrainerService.getAllTrainers();
//		for(Trainer t : trainers) {
//			System.out.println(t.getName());
//		}
		
//		String[] t = {"Revature", "Corporate", "University", "Other"};
//		for(int i = 0; i<t.length;i++ ) {
//			TrainingTypeService.addType(new TrainingType(t[i]));
//		}
		
//		String[] status = {"Dropped","Employed","Confirmed","Marketing","Training","Selected","Signed"};
//		for(int i = 0; i<status.length;i++ ) {
//			StatusService.addStatus(new Status(status[i]));
//		}
//		Batch JTA = new Batch("JTA-1804", "Revature LLC, 11730 Plaza America Drive, 2nd Floor Reston VA 20190", 80,70, 1,1,2018);
//		Batch BA = new Batch("BA-2265", "Tech Incubator at Queens College, 65-30 Kissena Blvd, CEP Hall 2 Queens NY 11367",70,65,2,1,2018);
//		BatchService.addBatch(JTA);
//		BatchService.addBatch(BA);
//		
//		Trainee Andy = new Trainee("Andy Alfaro", "andy@alfaro.com", "aaa91", "123-456-7890", "Mt St Mary's University", "Bachelors Science",
//				"Computer Science", "some guy", "lolwut", 100, "www.fakeurl.com");
//		TraineeService.insertTrainee(Andy);
	
		Status status = StatusService.getEverything().get(0);
		System.out.println(status);
		Trainee Bobby = new Trainee("Bobby","fake@email.com","aaaa","1234567890","A Good University","Culinary Alchemy","Cooking with fire","recruit","screener",50,"url.com",status);
		TraineeService.insertTrainee(Bobby);
	}
}


