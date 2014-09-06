package dTunesStore.dataStore;


public class MusicInfo
{
	private String songName, albumName, singerName;
	private int duration;
	/**
	 * 
	 * @return String
	 */
	public String getSongName()
	{
		return songName;
	}
	/**
	 * 
	 * @return void
	 */
	public void setSongName(String songName)
	{
		this.songName = songName;
	}
	/**
	 * 
	 * @return String
	 */
	public String getAlbumName()
	{
		return albumName;
	}
	/**
	 * 
	 * @return void
	 */
	public void setAlbumName(String albumName)
	{
		this.albumName = albumName;
	}
	/**
	 * 
	 * @return String
	 */
	public String getSingerName()
	{
		return singerName;
	}
	/**
	 * 
	 * @return void
	 */
	public void setSingerName(String singerName)
	{
		this.singerName = singerName;
	}
	/**
	 * 
	 * @return int
	 */
	public int getDuration()
	{
		return duration;
	}
	/**
	 * 
	 * @return void
	 */
	public void setDuration(int duration)
	{
		this.duration = duration;
	}

} 

