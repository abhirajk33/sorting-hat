package com.vedantu.sorting.hat;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.vedantu.sorting.hat.models.Registration;
import com.vedantu.sorting.hat.models.Registration.RegistrationCommand;
import com.vedantu.sorting.hat.models.Registration.StudentClass;
import com.vedantu.sorting.hat.models.Registration.StudentFoodPreference;
import com.vedantu.sorting.hat.utils.Constants;

public class SortingHat {

	public static void main(String[] args) {

		try (Scanner scanner = new Scanner(System.in)) {

			String beginCommand = scanner.nextLine();
			String command;
			int capacity;

			String[] beginCommandArray = beginCommand.split(Constants.SPLITTER);

			if (!beginCommandArray[0].equals(Constants.INIT_COMMAND)) {
				System.out.println("Invalid command! - " + beginCommand);
			}

			capacity = Integer.parseInt(beginCommandArray[1]);

			List<Set<Integer>> registrations = new ArrayList<>();
			for (int i = 0; i < 5; i++) {
				registrations.add(new HashSet<Integer>());
			}

			int tolalRegistrations = 0;

			while (true) {
				command = scanner.nextLine();
				if (command.equals(Constants.FINISH_COMMAND)) {
					break;
				}

				String commandArray[] = command.split(Constants.SPLITTER);

				Registration reg = null;
				try {
					reg = new Registration(RegistrationCommand.valueOf(commandArray[0]),
										Integer.parseInt(commandArray[1]), 
										StudentClass.valueOf(commandArray[2]),
										StudentFoodPreference.valueOf(commandArray[3]));

				} catch (Exception e) {
					System.out.println("Invalid command!");
					continue;
				}

				tolalRegistrations++;

				if (tolalRegistrations <= capacity) {

					if (StudentFoodPreference.V.equals(reg.getStudentFoodPreference())) {
						if (StudentClass.B.equals(reg.getStudentClass())) {
							registrations.get(0).add(reg.getStudentRollNumber());
						} else {
							registrations.get(1).add(reg.getStudentRollNumber());
						}
					} else {
						if (StudentClass.B.equals(reg.getStudentClass())) {
							registrations.get(2).add(reg.getStudentRollNumber());
						} else {
							registrations.get(3).add(reg.getStudentRollNumber());
						}
					}

				} else {
					registrations.get(4).add(reg.getStudentRollNumber());
				}
			}

			String category[] = { "BV", "AV", "BNV", "ANV", "NA" };
			for (int i = 0; i < 5; i++) {
				System.out.println(category[i] + " : " + registrations.get(i));
			}
		}
	}
}
