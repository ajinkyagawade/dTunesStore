package dTunesStore.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
public class Entries 
{
	public static void main(String[] args) 
	{
		try
		{
			String data;
			int duration=0;
			int i;
			File file = new File("dataFile.txt");
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			for(i=1; i<=200; i++)
			{
				duration = duration + 1;
				data = "song"+i+" album"+i+" singer"+i+" "+duration+"\n";
				writer.write(data);
			}
			writer.close();
			System.out.println("Records inserted successfully !!!!");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
