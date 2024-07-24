This README provides a simple overview of the Java program designed to manage recently played songs:
## Features

- Add Song: Adds a new song to a user's recent playlist. If the playlist exceeds capacity, the least recently played song is automatically removed.
  
- Get Recent Songs: Retrieves the list of recently played songs for a specific user.
  
- Display Recent Songs for All Users: Retrieve the recent songs for all users.

# Song Class

- Represents a song with attributes:
  - `songName`: Name of the song.
  
- Provides methods:
  - `getSongName()`: Retrieves the name of the song.
  - `toString()`: Overrides the default `toString()` method to return the song's name.

# RecentSongsStore Class

- Manages recent songs using:
  - `HashMap<String, LinkedHashSet<Song>> userSongsMap`: Maps each user to their set of songs.
  - `capacity`: Specifies the maximum number of songs each user can store.
  
# Methods

- `addSong(String user, Song song)`: Adds a song to a user's playlist. Manages capacity by removing the oldest song if necessary.
  
- `getRecentSongs(String user)`: Retrieves the list of recently played songs for a user.
  
- `displayRecentSongsForAllUsers()`: Displays the recent songs for all users.

# Main Class

- Contains the `main` method to demonstrate the functionality of `RecentSongsStore`.
- Creates an instance of `RecentSongsStore` with an initial capacity.
- Adds songs for a user and displays the recent songs for every each addition.

To run the program:

1. Compile the `TestVagrant.java` file by using below command 
   TestVagrant.java
2. Run the compiled program by using below command:
   java TestVagrant
   
