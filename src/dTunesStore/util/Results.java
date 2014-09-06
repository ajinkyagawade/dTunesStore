package dTunesStore.util;

import java.util.Vector;

import dTunesStore.dataStore.MusicInfo;

public class Results implements ResultInterface
{
	public static Vector<MusicInfo> resultList = new Vector<MusicInfo>();

	public Results()
	{
		int dg = Debug.getDebugValue();
		if(dg>3)
			System.out.println("Inside constructor of Results Class.");		
	}
	/**
	 * 
	 * @return void
	 */
	public synchronized void writeResult(MusicInfo hitRecord)
	{
		try
		{
			resultList.add(hitRecord);
			if(Debug.getDebugValue()>=2)
				System.out.println("New Record added to Results List");
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
	public void displayFoundRecords()
	{
		int i;
		System.out.println("\n*** List of Found Records ***");
		for (i = 0; i < resultList.size(); i++)
		{
			MusicInfo item = resultList.get(i);
			System.out.println(item.getSongName() + " " + item.getAlbumName()
					+ " " + item.getSingerName() + " " + item.getDuration());
		}
	}
	
}