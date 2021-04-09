package menu;

import java.util.*;
import java.io.*;

public class Menu {
	public static void main(String[] args) {
		//========================================================//
		//                      MAIN MENU                         //
		System.out.println("Welcome to the TBC Steal Predictor!");
		
		boolean run = true;
		boolean duplicate = false;
		int i;
		int j;
		int variable_num = 0;
		int sequence_num = 0;
		
		int phase = 1;
		
		Vector<Character> variableVector = new Vector<Character>(); // Holds the variables
		Vector<String> descriptionVector = new Vector<String>(); // Holds the descriptions to what each variable means
		
		Vector<String> sequenceVector = new Vector<String>(); // Holds the sequences
		Vector<Integer> stealVector = new Vector<Integer>(); // Holds the results of each sequence
		
		Vector<String> dataVector = new Vector<String>();
		
		Scanner var = new Scanner(System.in);
		Scanner des = new Scanner(System.in);
		
		while (run == true) {
			System.out.println("Select an option: \n"
					+ "1. Variable input \n"
					+ "2. Sequence input \n"
					+ "3. Predict Steal Sequence \n"
					+ "4. Record accuracy of prediction \n"
					+ "5. Reset \n"
					+ "0. Exit the program");
			
			//Vector<Vector<String>> variables = new Vector<Vector<String>>();

			int mainMenu_choice = 0;
			int menu_choice = 0;
			
			mainMenu_choice = var.nextInt();
		//=========================================================//
			
		//=========================================================//
		//                       VARIABLES                         //
			switch (mainMenu_choice) {
				case 1:
					boolean loop1 = true;
					if (phase != 1) {
						System.out.println("You cannot edit variables at this point.");
					}
					
					else {
						while (loop1 == true) {
							System.out.println("What would you like to do? \n"
									+ "1. Enter variables \n"
									+ "2. Edit variables \n"
									+ "3. Delete variables \n"
									+ "0. Go back to the main menu \n");
							
							menu_choice = var.nextInt();
							
			//=========================================================//
			//                        ADDING                           //
							switch (menu_choice) {
								case 1:
									char variable;
									String description;
									boolean loop = true;
									while (loop == true) {
										duplicate = false;
										System.out.println("Enter an alphabetic character (only the first character will be used): ");

										variable = var.next().charAt(0);
										
										while (Character.isAlphabetic(variable) == false) 
										{
											System.out.println("That is not an alphabetic character, try again.");
											variable = var.next().charAt(0);
										}
										
										if (Character.isLowerCase(variable) == true)
											variable = Character.toUpperCase(variable);
											
										// This checks to see if the variable already exists. 
										
										for (i = 0; i < variable_num; i++) {
											if (variable == variableVector.get(i)) {
												System.out.println("That variable already exists.");
												duplicate = true;
											}
										}
										
										// This will not execute if the variable already exists.
										
										if (duplicate == false) {
											System.out.println(variable);
											
											
											System.out.println("Enter the description: ");
											description = des.nextLine();
											System.out.println(description);
											
											variableVector.add(variable);
											descriptionVector.add(description);
											
											//Collections.sort(variableVector);
											
											//variables[variable_num][0] = variable;
											variable_num += 1;
											
											//System.out.println("The following has been added: ");
											//System.out.println(variable + ": " + description);
											
											System.out.println("Variables: ");
											
											for (i = 0; i < variable_num; i++) {
												System.out.print(variableVector.get(i) + ": ");
												System.out.print(descriptionVector.get(i) + "\n");
											}
											
											
										}
										
										System.out.println("Press 1 to enter more variables: ");
										int exit;
										exit = var.nextInt();
										
										if (exit != 1) {
											loop = false;
											//var.close();
											//des.close();
										}
									}
								break;
				//=================================================//
								
				//=================================================//		
				//                   EDITING                       //
							case 2:
								if (variable_num == 0)
									System.out.println("There are no variables to edit, go to option 1 to input variables.");
								
								else {
									loop = true;
									while (loop == true) {
										duplicate = false;
										System.out.println("Select a variable to edit: ");
										for (i = 0; i < variable_num; i++) {
											System.out.print(i + " " + variableVector.get(i) + ": ");
											System.out.print(descriptionVector.get(i) + "\n");
										}
										int edit = var.nextInt();
										System.out.println(edit);
										
										if ((edit >= variable_num) || (edit < 0))
											System.out.println("That is not in the range of acceptable values.");
										
										else {
											System.out.println("Enter: \n"
													+ "1. Change variable \n"
													+ "2. Change description \n"
													+ "3. Change both");
											int change = var.nextInt();
											
											switch (change) {
												case 1:
													System.out.println("Enter an alphabetic character (only the first character will be used): ");
													variable = var.next().charAt(0);
													
													while (Character.isAlphabetic(variable) == false) 
													{
														System.out.println("That is not an alphabetic character, try again.");
														variable = var.next().charAt(0);
													}
													
													if (Character.isLowerCase(variable) == true)
														variable = Character.toUpperCase(variable);

													for (i = 0; i < variable_num; i++) {
														if (variable == variableVector.get(i)) {
															System.out.println("That variable already exists.");
															duplicate = true;
														}
													}
													
													if (duplicate == false) {
														System.out.println(variable);
														
														variableVector.set(edit, variable);
														
														//Collections.sort(variableVector);
														
														//variables[variable_num][0] = variable;
														
														System.out.println("Variables: ");
														
														for (i = 0; i < variable_num; i++) {
															System.out.print(variableVector.get(i) + ": ");
															System.out.print(descriptionVector.get(i) + "\n");
														}
													}
													
													
													break;
												
												case 2:
													System.out.println("Enter the description: ");
													description = des.nextLine();
													System.out.println(description);
													
													descriptionVector.set(edit, description);
													
													for (i = 0; i < variable_num; i++) {
														System.out.print(variableVector.get(i) + ": ");
														System.out.print(descriptionVector.get(i) + "\n");
													}
													
													break;
													
												case 3:
													System.out.println("Enter a character (only the first character will be used): ");
													variable = var.next().charAt(0);

													while (Character.isAlphabetic(variable) == false) 
													{
														System.out.println("That is not an alphabetic character, try again.");
														variable = var.next().charAt(0);
													}
													
													if (Character.isLowerCase(variable) == true)
														variable = Character.toUpperCase(variable);
													
													for (i = 0; i < variable_num; i++) {
														if (variable == variableVector.get(i)) {
															System.out.println("That variable already exists.");
															duplicate = true;
														}
													}
													
													if (duplicate == false) {
														System.out.println(variable);
														
														System.out.println("Enter the description: ");
														description = des.nextLine();
														System.out.println(description);
														
														descriptionVector.set(edit, description);
														variableVector.set(edit, variable);
														
														//Collections.sort(variableVector);
														
														//variables[variable_num][0] = variable;
														
														System.out.println("Variables: ");
														
														for (i = 0; i < variable_num; i++) {
															System.out.print(variableVector.get(i) + ": ");
															System.out.print(descriptionVector.get(i) + "\n");
														}
													}
													break;
													
												default:
													System.out.println("This is not an acceptable value.");
													break;
											}
											
											System.out.println("Enter 1 to edit more variables");
											int exit;
											exit = var.nextInt();
											
											if (exit != 1) {
												loop = false;
												//var.close();
												//des.close();
											}
										}
									}				
								}
								break;
				//===============================================//
				
			    //===============================================//
				//                  DELETING                     //
							case 3:
								loop = true;
								while (loop == true) {
									if (variable_num == 0) {
										System.out.println("There are no variables to delete, go to option 1 to input variables.");
										loop = false;
									}
										
									else {
										System.out.println("Select a variable to delete: ");
										for (i = 0; i < variable_num; i++) {
											System.out.print(i + " " + variableVector.get(i) + ": ");
											System.out.print(descriptionVector.get(i) + "\n");
										}
											
										int edit = var.nextInt();
										System.out.println(edit);
											
										if ((edit >= variable_num) || (edit < 0))
											System.out.println("That is not in the range of acceptable values.");
											
										else {
											variable_num -= 1;
												
											variableVector.remove(edit);
											descriptionVector.remove(edit);
											
											
											/* Task to be done later
											 * 
											 * if (sequence_num > 0) {
												int end = sequence_num;
												int num = 0;
												Vector<Integer> deleteVector = new Vector<Integer>();
												for (i = 0; i < end; i++) {
													//System.out.println(i);
													int delete = 0;
													String str = sequenceVector.get(i);
													System.out.println(str);
													for (j = 0; j < str.length(); j++) {
														char chr = str.charAt(j);
														System.out.println(chr);
														if (chr == variableVector.get(edit)){
															delete += 1;
															System.out.println(variableVector.get(edit));
														}
															
													}
													if (delete > 0) {
														deleteVector.add(i);
														System.out.println(deleteVector.get(i));
													}
													
													else
														System.out.println("NO");
												}
												for (num = 0; num < deleteVector.size(); num++) {
													System.out.println(sequenceVector.get(num) + " has been deleted.");
													//sequenceVector.remove(num);
													//stealVector.remove(num);
													//deleteVector.set(index, element)
													
												}
												//System.out.println("Sequences with that variable were deleted");
											}*
											 *
											 */
												
											System.out.println("Variables: ");
												
											for (i = 0; i < variable_num; i++) {
												System.out.print(i + " " + variableVector.get(i) + ": ");
												System.out.print(descriptionVector.get(i) + "\n");
											}
												
											System.out.println("Enter 1 to delete more variables.");
											int exit;
											exit = var.nextInt();
												
											if (exit != 1) {
												loop = false;
												//var.close();
												//des.close();
											}
										}
									}
								}
								
								break;
								
							case 0:
								loop1 = false;
								
							default:
								System.out.println("That is not an acceptable value.");
								break;
							}
							
							
						}
			//=========================================================//
					}
					break;
					
					
		//=========================================================//
		//                       SEQUENCES                         //
				case 2:
					if (variable_num == 0)
						System.out.println("\nThere are no variables to make sequences from. Go to option 1 to input variables.\n");
					
					else {
						loop1 = true;
						while (loop1 == true) {
							System.out.println("What would you like to do? \n"
									+ "1. Enter sequences \n"
									+ "2. Edit sequences \n"
									+ "3. Delete sequences \n"
									+ "0. Go back to the main menu \n");
							
							menu_choice = var.nextInt();
				//==========================================================//
				//                         ADDING                           //
							
							switch (menu_choice) {
							case 1:
								String sequence;
								boolean loop = true;
								while (loop == true) {
									int wrong = 0;
									int correct = 0;
									int steal = 0;
									System.out.println("Enter a sequence: ");
									
									sequence = des.nextLine();
									System.out.println(sequence);
									
									char[] characters = new char[sequence.length()];
									
									for (i = 0; i < sequence.length(); i++) {
										characters[i] = sequence.charAt(i);
									}
									
									/*
									 * for (char c : characters) {
										System.out.print(c);
									}
									*/
									//Vector<Character> wrongVector = new Vector<Character>();
									for (i = 0; i < sequence.length(); i++) {
										correct = 0;
										
										for (j = 0; j < variable_num; j++) {
											if (characters[i] == variableVector.get(j)) {
												//System.out.println("YES");
												correct = 1;
											}
										}
										
										if (correct == 0) {
											
											System.out.println(characters[i] + " [Character #" + (i+1) + "] has not been entered into the system.");
											wrong = 1;
										}
											
									}
									
									if (wrong == 0) {
										System.out.println("If this sequence was a steal, press 1.");
										steal = var.nextInt();
										
										if (steal != 1)
											steal = 0;
										
										sequence_num += 1;
										
										sequenceVector.add(sequence);
										stealVector.add(steal);
										
										System.out.println("Sequences: ");
										
										for (i = 0; i < sequence_num; i++) {
											System.out.print(sequenceVector.get(i) + ": ");
											if (stealVector.get(i) == 1)
												System.out.print("Yes\n");
											else
												System.out.print("No\n");
										}
									}
										
									
									System.out.println("Press 1 to enter more sequences: ");
									int exit;
									exit = var.nextInt();
									
									if (exit != 1) {
										loop = false;
									}
								}
									
								break;
			//==========================================================//
			
			//==========================================================//
			//                        EDITING                           //
							case 2:
								System.out.println("EDIT");
								loop = true;
								while (loop == true) {
									int wrong = 0;
									if (sequence_num == 0) {
										System.out.println("There are no sequences to edit, go to option 1 to input sequences.");
										loop = false;
									}
									
									else {
										System.out.println("Select a sequence to edit: ");
										for (i = 0; i < sequence_num; i++) {
											System.out.print(i + " " + sequenceVector.get(i) + ": ");
											if (stealVector.get(i) == 1)
												System.out.print("Yes\n");
											else
												System.out.print("No\n");
										}
										
										int edit = var.nextInt();
										System.out.println(edit);
											
										if ((edit >= sequence_num) || (edit < 0))
											System.out.println("That is not in the range of acceptable values.");
										
										else {
											System.out.println("Enter: \n"
													+ "1. Change sequence \n"
													+ "2. Change steal \n"
													+ "3. Change both");
											int change = var.nextInt();
											
											switch (change) {
												case 1:
													wrong = 0;
													int correct = 0;
													int steal = 0;
													System.out.println("Enter a sequence: ");
														
													sequence = des.nextLine();
													System.out.println(sequence);
														
													char[] characters = new char[sequence.length()];
														
													for (i = 0; i < sequence.length(); i++) {
														characters[i] = sequence.charAt(i);
													}
														
													/*
													 * for (char c : characters) {
														System.out.print(c);
													}
													*/
													
													for (i = 0; i < sequence.length(); i++) {
														correct = 0;
														
														for (j = 0; j < variable_num; j++) {
															if (characters[i] == variableVector.get(j)) {
																//System.out.println("YES");
																correct = 1;
															}
														}
														
														if (correct == 0) {
															System.out.println(characters[i] + " [Character #" + (i+1) + "] has not been entered into the system.");
															wrong = 1;
														}
															
													}
													
													if (wrong == 0) {
														sequenceVector.set(edit, sequence);
														
														System.out.println("Sequences: ");
														
														for (i = 0; i < sequence_num; i++) {
															System.out.print(sequenceVector.get(i) + ": ");
															if (stealVector.get(i) == 1)
																System.out.print("Yes\n");
															else
																System.out.print("No\n");
														}
													}

													break;
												
												case 2:

													System.out.println("If this sequences was a steal, press 1.");
													steal = var.nextInt();

													if (steal != 1)
														steal = 0;
													
													stealVector.set(edit, steal);
													
													System.out.println("Sequences: ");
													
													for (i = 0; i < sequence_num; i++) {
														System.out.print(sequenceVector.get(i) + ": ");
														if (stealVector.get(i) == 1)
															System.out.print("Yes\n");
														else
															System.out.print("No\n");
													}
												
													break;
													
												case 3:
													System.out.println("Enter a sequence: ");
													
													sequence = des.nextLine();
													System.out.println(sequence);
														
													characters = new char[sequence.length()];
														
													for (i = 0; i < sequence.length(); i++) {
														characters[i] = sequence.charAt(i);
													}
														
													/*
													 * for (char c : characters) {
														System.out.print(c);
													}
													*/
													
													for (i = 0; i < sequence.length(); i++) {
														correct = 0;
														
														for (j = 0; j < variable_num; j++) {
															if (characters[i] == variableVector.get(j)) {
																//System.out.println("YES");
																correct = 1;
															}
														}
														
														if (correct == 0) {
															System.out.println(characters[i] + " [Character #" + (i+1) + "] has not been entered into the system.");
															wrong = 1;
														}
															
													}
													
													if (wrong == 0) {
														System.out.println("If this sequences was a steal, press 1.");
														steal = var.nextInt();

														if (steal != 1)
															steal = 0;
														
														sequenceVector.set(edit, sequence);
														stealVector.set(edit, steal);
														
														System.out.println("Sequences: ");
														
														for (i = 0; i < sequence_num; i++) {
															System.out.print(sequenceVector.get(i) + ": ");
															if (stealVector.get(i) == 1)
																System.out.print("Yes\n");
															else
																System.out.print("No\n");
														}
													}
													
													break;
													
												default:
													System.out.println("This is not an acceptable value.");
													break;
											}
											
											System.out.println("Enter 1 to edit more variables");
											int exit;
											exit = var.nextInt();
											
											if (exit != 1) {
												loop = false;
												//var.close();
												//des.close();
											}
										
										}
									}
								}
								break;
			
			//==========================================================//
			
			//==========================================================//
			//                       DELETING                           //
							case 3:
								loop = true;
								while (loop == true) {
									if (sequence_num == 0) {
										System.out.println("There are no sequences to delete, go to option 1 to input sequences.");
										loop = false;
									}
									
									else {
										System.out.println("Select a sequence to delete: ");
										for (i = 0; i < sequence_num; i++) {
											System.out.print(i + " " + sequenceVector.get(i) + ": ");
											if (stealVector.get(i) == 1)
												System.out.print("Yes\n");
											else
												System.out.print("No\n");
										}
										
										int edit = var.nextInt();
										System.out.println(edit);
											
										if ((edit >= sequence_num) || (edit < 0))
											System.out.println("That is not in the range of acceptable values.");
											
										else {
											sequence_num -= 1;
												
											sequenceVector.remove(edit);
											stealVector.remove(edit);
												
											System.out.println("Sequences: ");
												
											for (i = 0; i < sequence_num; i++) {
												System.out.print(i + " " + sequenceVector.get(i) + ": ");
												if (stealVector.get(i) == 1)
													System.out.print("Yes\n");
												else
													System.out.print("No\n");
											}
												
											System.out.println("Enter 1 to delete more sequences.");
											int exit;
											exit = var.nextInt();
												
											if (exit != 1) {
												loop = false;
												//var.close();
												//des.close();
											}
										}
									}
								}
								
								break;
		//=========================================================//
								
							case 0:
								loop1 = false;
								
							default:
								System.out.println("This is not an acceptable value");
								break;
							}
						}
					}
					break;
					
		//=========================================================//
					
		//=========================================================//
		//                      PREDICTION                         //
				case 3:
					if (sequence_num <= 0)
						System.out.println("There are not enough sequences to make a prediction on.");
					
					else if (phase != 1) 
						System.out.println("You've already made a prediction. Select option 4 to test the accuracy of the prediction.");
					
					else {
						
						dataVector.clear();
						
						for (i = 0; i < sequence_num; i++) {
							dataVector.add(sequenceVector.get(i) + " " + stealVector.get(i));
							//System.out.println(dataVector.get(i));
						}
						
						try {
							File myObj = new File("data.txt");
							
							if (myObj.createNewFile())
								System.out.println("File created: " + myObj.getName());
							else {
								myObj.delete();
								myObj.createNewFile();
								System.out.println("Overwrote the file: " + myObj.getName());
							}
							
						} catch (IOException e) {
							System.out.println("An error occurred.");
							e.printStackTrace();
						}
						
						try {
							FileWriter dataWriter = new FileWriter("data.txt");
							
							i = 0;
							
							for (i = 0; i < sequence_num; i++) {
								dataWriter.write(dataVector.get(i) + "\n");
								System.out.println(dataVector.get(i));
								
								if (i == sequence_num - 1)
									dataWriter.close();
							}
							
							System.out.println("Wrote to the file.");
							
						} catch (IOException e) {
							System.out.println("An error occured.");
							e.printStackTrace();
						}
						
						TwoPartAlgorithm predictor = new TwoPartAlgorithm();
						predictor.main(args);
						phase = 2;
						sequenceVector.clear();
						stealVector.clear();
						dataVector.clear();
						
						sequence_num = 0;
					}
					
					break;
					
		//=========================================================//
				
		//=========================================================//
		//                       ACCURACY                          //
				case 4:
					if (phase != 2)
						System.out.println("A prediction has not been made yet.");
					
					else {
						System.out.println("4");
					}
					
					break;
		
		//=========================================================//
		
		//=========================================================//
		//                        RESET                            //
					
				case 5:
					if (variable_num == 0 && sequence_num == 0)
						System.out.println("There is nothing to reset.");
					
					else {
						System.out.println("Press 1 if you are sure you'd like to reset the system.");
						
						int reset = 0;
						
						reset = var.nextInt();
						
						if (reset == 1) {
							variableVector.clear();
							descriptionVector.clear();
							sequenceVector.clear();
							stealVector.clear();
							dataVector.clear();
							
							variable_num = 0;
							sequence_num = 0;
							phase = 1;
							
							System.out.println("The system has been reset.");
						}
					}

					break;
					
		//=========================================================//
					
				case 0:
					System.out.println("Goodbye.");
					run = false;
					break;
					
				default:
					System.out.println("Select a valid number.");
					break;
			}
		}
	var.close();
	des.close();
	}
}