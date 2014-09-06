package dTunesStore.driver;

import dTunesStore.dataStore.MusicStore;
import dTunesStore.dataStore.PopulateWorker;
import dTunesStore.dataStore.ReadFile;
import dTunesStore.dataStore.SearchWorker;
import dTunesStore.util.Debug;
import dTunesStore.util.Results;

public class Driver
{

	public static void main(String args[])
	{
		try
		{
			String dataFileName = args[0];
			int nn = Integer.parseInt(args[1]);
			String searchFileName = args[2];
			int mm = Integer.parseInt(args[3]);
			int debugValue = Integer.parseInt(args[4]);

			Debug.setDebugValue(debugValue);
			new PopulateWorker(nn, new ReadFile(dataFileName));
			new SearchWorker(searchFileName, mm);
			if (Debug.getDebugValue() >= 1)
				new Results().displayFoundRecords();
		}

		catch (Exception e)
		{
			System.out.println("***Exception***");
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

	} 
} 
