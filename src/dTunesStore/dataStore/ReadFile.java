package dTunesStore.dataStore;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import dTunesStore.util.Debug;

public class ReadFile
{
	private static BufferedReader reader;

	public ReadFile(String dataFileName)
	{
		try
		{
			if (Debug.getDebugValue() == 4)
				System.out.println("Inside constructor of ReadFile Class.");
			File f = new File(dataFileName);
			if (!f.exists())
			{
				System.out.println("File " + dataFileName
						+ " is not available\nExiting...");
				System.exit(0);
			}
			FileReader fr = new FileReader(f);
			reader = new BufferedReader(fr);
		}
		catch (Exception e)
		{
			System.out.println("***Exception***");
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}
	/**
	 * @return void
	 */
	public synchronized void read()
	{
		String line = "";
		try
		{
			while ((line = reader.readLine()) != null)
			{
				if (line.isEmpty())
				{
					continue;
				}

				line = line.trim();

				String[] parts = line.split(" ");

				if (parts.length == 4)
				{
					MusicInfo ms = new MusicInfo();
					ms.setSongName(parts[0]);
					ms.setAlbumName(parts[1]);
					ms.setSingerName(parts[2]);
					ms.setDuration(Integer.parseInt(parts[3].trim()));
					MusicStore.musicList.add(ms);
					// Thread.sleep(1);
				}
				else
				{
					System.out
							.println("*** Error *** \n Entry in file is not correct");
					System.exit(0);
				}
			}

		}
		catch (Exception e)
		{
			System.out.println("***Exception***");
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}
}