package baseballSign;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;

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
	int lineCount;

	//constructor
	Determine()
	{
		fileStr = " ";
		tempStr = " ";
		checkVal = " ";
		lineCount = 0;
	}

	//The user input will contain an int that tell us if the player stole or not
	//That will be used to sort the input string into the correct file
	public void sortInput(File userFile, File newFile)
	{
		try 
		{
			if(newFile.length() >= 0)
			{
				newFile.delete();
				newFile.createNewFile();
			}
			
			Scanner sortSc = new Scanner(userFile);
			FileWriter fileWrite = new FileWriter(newFile);
			BufferedWriter buffWrite = new BufferedWriter(fileWrite);
			String steal = String.valueOf("1");
			
			while(sortSc.hasNextLine() == true)
			{
				String fLine[] = sortSc.nextLine().split(" ", 2);
				if(fLine[1].endsWith(steal))
				{
					buffWrite.write(fLine[0]);
					buffWrite.newLine();
				}
			}
			buffWrite.close();
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
	public void searchFile(File userFile)
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
								System.out.println("Steal Sequence found: " + checkVal);
								break;
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

	}

}



public class TwoPartAlgorithm {

	public static void main(String args[])
	{
		File allData = new File("AllData2.txt");
		File stlFile = new File("StealFile.txt");
		File noStlFile = new File("NoStealFile.txt");

		FileCheck check = new FileCheck();
		Determine find = new Determine();

		check.doesExist(allData);
		check.doesExist(stlFile);
		check.doesExist(noStlFile);
		
		find.sortInput(allData, stlFile);

		find.searchFile(stlFile);

		System.out.println("END OF TEST");
	}

}