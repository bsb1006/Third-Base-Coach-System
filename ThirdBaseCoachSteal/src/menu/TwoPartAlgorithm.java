package menu;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.regex.*;

class FileCheck
{
	//constructor
	FileCheck()
	{

	}

	//check to see if the files exist that will be used for data storage and searching
	public boolean doesExist(File userFile)
	{
		if(userFile.exists() == true)
		{

			System.out.println(userFile.getName() + " exists");
			return true;		
		}
		if(userFile.exists() == false)
		{

			System.out.println(userFile.getName() + " does not exist");
			System.out.println("Attempting to create file");

			try
			{
				if(userFile.createNewFile() == true)
				{
					System.out.println(userFile.getName() + " was successfully created");
					return true;
				}
			}

			catch(IOException errorName)
			{
				//if the file can't open, this prevents the whole program from crashing
				System.out.println(userFile.getName() + " was not able to be created");

				//prints the details of the error through the exception handler  
				errorName.printStackTrace();
				return false;
			}

			return true;
		}

		else
		{
			System.out.println("Unable to determine file existance");
			return false;
		}
	}

}

//this class is used to determine which file user input goes
//searches the files and determines the indicator and steal sign (2-step steal sequence)
class Determine
{
	String fileStr;
	String tempStr;
	String checkVal;
	private String stealVal;
	int lineCount;

	//constructor
	Determine()
	{
		fileStr = " ";
		tempStr = " ";
		checkVal = " ";
		lineCount = 0;
	}
	
	public void setSteal(String temp)
	{
		stealVal = temp;
	}
	
	//this will be used for stats and checking new strings
	public String getSteal()
	{
		return stealVal;
	}

	//The user input will contain an int that tell us if the player stole or not
	//That will be used to sort the input string into the correct file
	public void sortInput(File userFile, File newFile, File noStealFile)
	{
		try 
		{
			//clears the steal file if there is anything in it. Prevents leftover data from sticking around
			if(newFile.length() >= 0)
			{
				newFile.delete();
				newFile.createNewFile();
			}
			if(noStealFile.length() >= 0)
			{
				noStealFile.delete();
				noStealFile.createNewFile();
			}
			
			Scanner sortSc = new Scanner(userFile);
			FileWriter fileWrite = new FileWriter(newFile);
			FileWriter noStlWrite = new FileWriter(noStealFile);
			BufferedWriter buffWrite = new BufferedWriter(fileWrite);
			BufferedWriter noStlBuff = new BufferedWriter(noStlWrite);
			String steal = String.valueOf("1");
			String noSteal = String.valueOf("0");
			
			//searches every file line
			while(sortSc.hasNextLine() == true)
			{
				//splits each line at the space
				String fLine[] = sortSc.nextLine().split(" ", 2);
				
				//if the section after the space is a 1, write that sequence to the steal file
				if(fLine[1].endsWith(steal))
				{
					buffWrite.write(fLine[0]);
					buffWrite.newLine();
				}
				if(fLine[1].endsWith(noSteal))
				{
					noStlBuff.write(fLine[0]);
					noStlBuff.newLine();
				}
			}
			//close up scanner and buffered writer
			buffWrite.close();
			noStlBuff.close();
			sortSc.close();
		}
		
		catch (FileNotFoundException e) 
		{
			
			System.out.println("Scanner error: Sort method");
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			
			System.out.println("FileWriter error: Sort method");
			e.printStackTrace();
		}
		
		
	}

	//searches the file to find the steal signal
	//will only be used on the steal file because we don't care about the sequences that didn't result in a steal
	//searchFile is used for AB-formatted signals (two steps)
	public boolean searchFile(File userFile)
	{
		System.out.println("Finding Steal Signal...");
		
		try
		{   
			//creates a file-reader of the class "BufferedReader" that is used to access the user file
			BufferedReader readFile = new BufferedReader(new FileReader(userFile));
			int fileLines = 0;

			//as long as the file has a valid next line, increase fileLines
			while(readFile.readLine() != null)
			{
				fileLines++;
			}

				for(int i = 0; i < fileStr.length(); i++)
				{
					Scanner sc = new Scanner(userFile);

					//this is the first line in the file that will be broken down and used to search for a pattern
					fileStr = sc.nextLine();
					
					//checks each line for a pattern
					while(sc.hasNextLine() == true)
					{					
						tempStr = sc.nextLine();
						//checks for a pair of characters
						checkVal = fileStr.substring(i, i+2);
//						System.out.println("Checking for sequence: " + checkVal);
						lineCount = lineCount +1;
						
						//checks to make sure we don't try to access outside of the string length
						if((i+1)>=fileStr.length())
						{
							System.out.println("End of string");
							break;
						}

						//checks if each line contains the substring
						if(tempStr.contains(checkVal) == true)
						{
//							System.out.println("Sequence found in line: " + lineCount);

							//this lets us know when the end of the file has been reached
							if(lineCount + 1 == fileLines)
							{
								setSteal(checkVal);
								System.out.println("Steal Sequence found: " + getSteal());
								Menu.key = checkVal;
								sc.close();
								return true;
								//break;
							}

						}
						else
						{
							//alerts that the sequence was not found in the string and resets the search
//							System.out.println("Sequence not found int line: " + lineCount);
							lineCount = 0;
							break;
						}
					}
					sc.close();

					//has to have the "+1" because we take the first string away and use it to search
					//therefore lineCount will never equal fileLines and we need the added one
					if(lineCount +1 == fileLines)
					{
						break;
					}
				}

			readFile.close();
		}
		//error handling for Scanner opening
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}

		//error handling for BufferedReader opening
		//Java likes to throw errors without these catch statements
		catch (IOException e1)
		{

			e1.printStackTrace();
		}

		return false;
	}


//threeStep is used for steal signals in an ABC pattern
public boolean threeStep(File userFile)
{
	System.out.println("Finding Steal Signal...");
	
	try
	{   
		//creates a file-reader of the class "BufferedReader" that is used to access the user file
		BufferedReader readFile = new BufferedReader(new FileReader(userFile));
		int fileLines = 0;

		//as long as the file has a valid next line, increase fileLines
		while(readFile.readLine() != null)
		{
			fileLines++;
		}

			for(int i = 0; i < fileStr.length(); i++)
			{
				Scanner sc = new Scanner(userFile);

				//this is the first line in the file that will be broken down and used to search for a pattern
				fileStr = sc.nextLine();
				//System.out.println("fileStr: " + fileStr);
				//checks each line for a pattern
				while(sc.hasNextLine() == true)
				{					
					tempStr = sc.nextLine();
					
					//Checking if it equals three because the steal signal could be the whole fileStr
					if(fileStr.length() == 3) 
					{
						checkVal = fileStr;
						//System.out.println("Caught CheckVal: " + checkVal);
					}
					else
					{
						//checks for a set of characters
						checkVal = fileStr.substring(i, i+3);
					}
					
//					System.out.println("Checking for sequence: " + checkVal);
					lineCount = lineCount +1;
					
					//checks to make sure we don't try to access outside of the string length
					if((i+3)>fileStr.length())
					{
						System.out.println("End of string");
						sc.close();
						return false;
					}

					//checks if each line contains the substring
					if(tempStr.contains(checkVal) == true)
					{
//						System.out.println("Sequence found in line: " + lineCount);

						//this lets us know when the end of the file has been reached
						if(lineCount + 1 == fileLines)
						{
							setSteal(checkVal);
							System.out.println("Steal Sequence found: " + getSteal());
							Menu.key = checkVal;
							sc.close();
							return true;
							//break;
						}

					}
					else
					{
						//alerts that the sequence was not found in the string and resets the search
//						System.out.println("Sequence not found int line: " + lineCount);
						lineCount = 0;
						break;
					}
				}
				sc.close();

				//has to have the "+1" because we take the first string away and use it to search
				//therefore lineCount will never equal fileLines and we need the added one
				if(lineCount +1 == fileLines)
				{
					break;
				}
			}

		readFile.close();
	}
	//error handling for Scanner opening
	catch (FileNotFoundException e)
	{
		e.printStackTrace();
	}

	//error handling for BufferedReader opening
	//Java likes to throw errors without these catch statements
	catch (IOException e1)
	{

		e1.printStackTrace();
	}

	return false;
}

////////////////////////////////////////used for A*C searches/////////////////////////////
// * = any random signal
public boolean wildStep(File userFile)
{
	System.out.println("Finding Steal Signal...");
	
	try
	{   
		//creates a file-reader of the class "BufferedReader" that is used to access the user file
		BufferedReader readFile = new BufferedReader(new FileReader(userFile));
		int fileLines = 0;

		//as long as the file has a valid next line, increase fileLines
		while(readFile.readLine() != null)
		{
			fileLines++;
		}

			for(int i = 0; i < fileStr.length(); i++)
			{
				Scanner sc = new Scanner(userFile);

				//this is the first line in the file that will be broken down and used to search for a pattern
				fileStr = sc.nextLine();
				
				//checks each line for a pattern
				while(sc.hasNextLine() == true)
				{					
					tempStr = sc.nextLine();
					//Checking if it equals three because the steal signal could be the whole fileStr
					if(fileStr.length() == 3) 
					{
						checkVal = fileStr;
					}
					else
					{
						//checks for a set of characters
						checkVal = fileStr.substring(i, i+3);
					}
					
////////////////////////////////////USE THIS FOR THE WILD CHAR CHECK///////////////////////////////////					
					//sets signal 1 and 3 and ignores the middle character 
					String start = String.valueOf(checkVal.charAt(0));
					String end = String.valueOf(checkVal.charAt(2));
					//sets the pattern for searching, in this case it is A(char)C style
					Pattern wild = Pattern.compile(start + '.' + end);
					//used to match the set pattern
					Matcher match = wild.matcher(tempStr);
					//finds out if the pattern was found in the string tempStr
					boolean found = match.find();
///////////////////////////////////////////////////////////////////////////////////////////////////////
					
					
//					System.out.println("Checking for sequence: " + checkVal);
					lineCount = lineCount +1;
					
					//checks to make sure we don't try to access outside of the string length
					if((i+3)>fileStr.length())
					{
						System.out.println("End of string");
						sc.close();
						return false;
					}

					//checks if each line contains the substring
					if(found == true)
					{
//						System.out.println("Sequence found in line: " + lineCount);

						//this lets us know when the end of the file has been reached
						if(lineCount + 1 == fileLines)
						{
							String temp = String.valueOf(wild);
							setSteal(temp);
							System.out.println("Steal Sequence found: " + getSteal() + "  (period stands for any single character)");
							Menu.key = getSteal();
							sc.close();
							return true;
							//break;
						}

					}
					else
					{
						//alerts that the sequence was not found in the string and resets the search
//						System.out.println("Sequence not found int line: " + lineCount);
						lineCount = 0;
						break;
					}
				}
				sc.close();

				//has to have the "+1" because we take the first string away and use it to search
				//therefore lineCount will never equal fileLines and we need the added one
				if(lineCount +1 == fileLines)
				{
					break;
				}
			}

		readFile.close();
	}
	//error handling for Scanner opening
	catch (FileNotFoundException e)
	{
		e.printStackTrace();
	}

	//error handling for BufferedReader opening
	//Java likes to throw errors without these catch statements
	catch (IOException e1)
	{

		e1.printStackTrace();
	}

	return false;
}


}

public class TwoPartAlgorithm {

	public static void main(String args[])
	{
		//for testing, change this -----v to either AllData, AllData2, AllData3. Each has a different kind of steal signal
		File allData = new File("data.txt");
		File stlFile = new File("StealFile.txt");
		File noStlFile = new File("NoStealFile.txt");

		FileCheck check = new FileCheck();
		Determine find = new Determine();

		check.doesExist(allData);
		check.doesExist(stlFile);
		check.doesExist(noStlFile);
		
		find.sortInput(allData, stlFile, noStlFile);

		if(find.threeStep(stlFile) == false)
		{
			if(find.wildStep(stlFile) == false)
			{
				find.searchFile(stlFile);
			}
		}
	}
}