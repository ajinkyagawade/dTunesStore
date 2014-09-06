package dTunesStore.dataStore;

import dTunesStore.util.Debug;

public class PopulateWorker implements Runnable
{

	private static ReadFile readData;

	public PopulateWorker(int nn, ReadFile rf)
	{
		try
		{
			if (Debug.getDebugValue() == 4)
				System.out
						.println("Inside constructor of PopulateWorker Class.");
			if (nn < 1 || nn > 5)
			{
				System.out
						.println("Number of threads should be between 1 to 5\nExiting...");
				System.exit(0);
			}

			readData = rf;

			// Creating Threads to read data files
			for (int i = 0; i < nn; i++)
			{
				Thread t = new Thread(new PopulateWorker());
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

	public PopulateWorker()
	{
	}
	/**
	 * @return void
	 */
	public void run()
	{
		int dg = Debug.getDebugValue();
		if (dg >= 3)
			System.out.println("Inside run() method of PopulateWorker Class.");

		try
		{
			readData.read();
		}
		catch (Exception e)
		{
			System.out.println("***Exception***");
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

}
