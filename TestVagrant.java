import java.util.*;


class Song {
    private String songName;

    public Song(String name) {
        this.songName = name;
    }

    public String getSongName() {
        return songName;
    }

    @Override
    public String toString() {
        return songName;
    }
}

class RecentSongsStore {
    private Map<String, LinkedHashSet<Song>> userSongsMap;
    private int capacity;

    public RecentSongsStore(int capacity) {
        this.capacity = capacity;
        userSongsMap = new HashMap<>();
    }

public void addSong(String user, Song song) {
        if (!userSongsMap.containsKey(user)) {
            userSongsMap.put(user, new LinkedHashSet<>(capacity));
        }

        LinkedHashSet<Song> recentSongs = userSongsMap.get(user);
        recentSongs.remove(song);
        recentSongs.add(song);

        if (recentSongs.size() > capacity) {
            Iterator<Song> iterator = recentSongs.iterator();
            iterator.next(); 
            iterator.remove(); 
        }
    }

public List<Song> getRecentSongs(String user) {
        LinkedHashSet<Song> recentSongs = userSongsMap.getOrDefault(user, new LinkedHashSet<>());
        return new ArrayList<>(recentSongs);
    }

public void displayRecentSongsForAllUsers() {
        for (Map.Entry<String, LinkedHashSet<Song>> entry : userSongsMap.entrySet()) {
            String user = entry.getKey();
            LinkedHashSet<Song> recentSongs = entry.getValue();
            System.out.print(user + " : ");
            for (Song song : recentSongs) {
                System.out.print(song + ",");
            }
            System.out.println();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        RecentSongsStore store = new RecentSongsStore(3);

        store.addSong("Rajesh", new Song("S1"));
        store.addSong("Rajesh", new Song("S2"));
        store.addSong("Rajesh", new Song("S3"));
        store.addSong("Raju", new Song("S2"));
        store.addSong("Raju", new Song("S3"));
        store.addSong("Raju", new Song("S1"));
        
        store.displayRecentSongsForAllUsers();

        store.addSong("Rajesh", new Song("S4"));
        store.displayRecentSongsForAllUsers();

        store.addSong("Rajesh", new Song("S2"));
        store.displayRecentSongsForAllUsers();

        store.addSong("Rajesh", new Song("S1"));
        store.displayRecentSongsForAllUsers();
        
        store.addSong("Raju", new Song("S1"));
        store.displayRecentSongsForAllUsers();

        store.addSong("Raju", new Song("S2"));
        store.displayRecentSongsForAllUsers();

        store.addSong("Raju", new Song("S3"));
        store.displayRecentSongsForAllUsers();
    }
}

