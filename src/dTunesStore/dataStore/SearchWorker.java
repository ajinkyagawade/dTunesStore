package dTunesStore.dataStore;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import dTunesStore.util.Debug;
import dTunesStore.util.Results;

public class SearchWorker implements Runnable
{
	private static BufferedReader searchReader;
	private static Results outObject;

	public SearchWorker(String searchFileName, int mm)
	{
		try
		{
			if (Debug.getDebugValue() == 4)
				System.out.println("Inside constructor of SearchWorker Class.");
			if (mm < 1 || mm > 5)
			{
				System.out
						.println("Number of threads should be between 1 to 5\nExiting...");
				System.exit(0);
			}
			File f = new File(searchFileName);
			if (!f.exists())
			{
				System.out.println("File " + searchFileName
						+ " is not available\nExiting...");
				System.exit(0);
			}
			FileReader fr = new FileReader(f);
			searchReader = new BufferedReader(fr);
			outObject = new Results();

			// Creating Threads to read search file
			for (int i = 0; i < mm; i++)
			{
				Thread t = new Thread(new SearchWorker());
				t.join();
				t.start();
			}
			Thread.sleep(5000);

		}
		catch (Exception e)
		{
			System.out.println("***Exception***");
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	public SearchWorker()
	{
	}
	/**
	 * @return void
	 */
	public void run()
	{

		try
		{
			int dg = Debug.getDebugValue();
			if (dg >= 3)
				System.out
						.println("Inside run() method of SearchWorker Class.");
			readSearchFile();
		}
		catch (Exception e)
		{
			System.out.println("***Exception***");
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	/**
	 * 
	 * @return void
	 */
	public synchronized void readSearchFile() throws Exception
	{
		String line = "";
		try
		{
			while ((line = searchReader.readLine()) != null)
			{
				if (line.isEmpty())
				{
					continue;
				}
				line = line.trim();
				searchRecord(line);
			}
		}

		catch (Exception e)
		{
			System.out.println("***Exception***");
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	/**
	 * 
	 * @return void
	 */
	private void searchRecord(String line)
	{
		for (int i = 0; i < MusicStore.musicList.size(); i++)
		{
			MusicInfo item = MusicStore.musicList.get(i);
			String duration = String.valueOf(item.getDuration());
			if (line.equals(item.getSongName())
					|| line.equals(item.getAlbumName())
					|| line.equals(item.getSingerName())
					|| line.equals(duration))
			{

				outObject.writeResult(item);
				break;
			}
		}
	}

}
