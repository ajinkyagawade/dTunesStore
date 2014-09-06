dTunesStore
===========

Application of design patterns/principles for a simple multi-threaded application

The project is based on a local dTunesStore library. Each MusicInfo record having the format: song name, album name, lead singer name, duration, is stored using the Vector data structure inside the MusicStore class. The PopulateWorker class is used to spawn the threads to read data from a dataFile (having 200 entries) in order to populate the MusicStore. All spawned threads read from the same file, with no entry being read more than once and with all entries being read. Entries class from the util package is used to populate the dataFile with 200 entries. The SearchWorker class is used to spawn another set of threads, which read from another file, searchFile, having a list of words. For each word from searchFile, the MusicStore is searched for finding the entry that has the search word and for each successful hit, the entire entry is stored inside a new Vector data structure inside the Results class. The search word is read only once from the searchFile and can be any of the following: song name, album name, lead singer name or duration.

