package dTunesStore.dataStore;

import java.util.Vector;

import dTunesStore.util.Debug;

public class MusicStore implements Store
{

	public static Vector<MusicInfo> musicList;
	static
	{
		musicList = new Vector<MusicInfo>();
	}

	public MusicStore()
	{
		if (Debug.getDebugValue() == 4)
			System.out.println("Inside constructor of MusicStore Class.");		
	}
	/**
	 * @return void
	 */
	public void displayData()
	{
		int i;
		System.out.println("size = " + musicList.size());
		for (i = 0; i < musicList.size(); i++)
		{
			MusicInfo item = musicList.get(i);
			System.out.println(item.getSongName() + " " + item.getAlbumName()
					+ " " + item.getSingerName() + " " + item.getDuration());
		}
	}

}
