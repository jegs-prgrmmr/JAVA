package EndTerm_Projects;
import java.util.*;
public class SyPlaylist {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		
		String[] songTitles = {
        "Blinding Lights", "Levitating", "Montero (Call Me By Your Name)", "Peaches", "Stay", "Good 4 U",
        "Save Your Tears", "Butter", "Industry Baby", "Deja Vu", "Kiss Me More", "Permission to Dance",
        "Mood", "Bad Habits", "Driver's License", "Fancy Like", "Astronaut in the Ocean", "Heartbreak Anniversary",
        "You Right", "My Universe", "Essence", "Forever After All", "Mood Swings", "The Business", "Shivers",
        "Heat Waves", "Cold Heart (Pnau Remix)", "Life Goes On", "Arcade", "Without You", "Beautiful Mistakes",
        "Anyone", "Vampire", "Dreams", "Before You Go", "Watermelon Sugar", "Dynamite", "Say So", "Savage Love",
        "Sour Candy", "WAP", "Holy", "Rockstar", "Positions", "Memories", "Sicko Mode", "Sucker", "Used to Be Young",
        "Rush", "Flowers"
    };

    String[] artists = {
        "The Weeknd", "Dua Lipa feat. DaBaby", "Lil Nas X", "Justin Bieber feat. Daniel Caesar, Giveon",
        "The Kid LAROI, Justin Bieber", "Olivia Rodrigo", "The Weeknd", "BTS", "Lil Nas X feat. Jack Harlow",
        "Olivia Rodrigo", "Doja Cat feat. SZA", "BTS", "24kGoldn feat. iann dior", "Ed Sheeran", "Olivia Rodrigo",
        "Walker Hayes", "Masked Wolf", "Giveon", "Doja Cat feat. The Weeknd", "Coldplay, BTS", "Wizkid feat. Tems",
        "Luke Combs", "Pop Smoke feat. Lil Tjay", "Tiësto", "Ed Sheeran", "Glass Animals", "Elton John, Dua Lipa",
        "BTS", "Duncan Laurence", "The Kid LAROI", "Maroon 5 feat. Megan Thee Stallion", "Justin Bieber",
        "Olivia Rodrigo", "Fleetwood Mac", "Lewis Capaldi", "Harry Styles", "BTS", "Doja Cat", "Jawsh 685, Jason Derulo",
        "Lady Gaga, BLACKPINK", "Cardi B feat. Megan Thee Stallion", "Justin Bieber feat. Chance The Rapper",
        "DaBaby feat. Roddy Ricch", "Ariana Grande", "Maroon 5", "Travis Scott", "Jonas Brothers", "Miley Cyrus",
        "Troye Sivan", "Miley Cyrus"
    };

    String[] durations = {
        "3:20", "3:23", "2:17", "3:18", "2:24", "2:58", "3:35", "2:45", "3:27", "3:35",
        "3:28", "3:07", "2:21", "3:51", "4:02", "2:42", "2:13", "3:17", "3:06", "3:30",
        "4:09", "3:53", "3:33", "2:44", "3:28", "3:58", "3:22", "3:27", "3:04", "2:41",
        "3:47", "3:10", "4:05", "4:14", "3:35", "2:54", "3:19", "3:58", "2:51", "2:38",
        "3:07", "3:32", "3:01", "2:52", "3:09", "5:12", "3:01", "3:22", "3:43", "3:22"
    };
		
    System.out.print("Enter playlist name: ");
    String playlistName = scan.nextLine();
    int playlistType = 0;
    
    do {
      System.out.println("[1] - Random Playlist");
      System.out.println("[2] - Custom Playlist");
      System.out.print("Choose playlist type: ");
      playlistType = scan.nextInt();

      if (playlistType != 1 && playlistType != 2) {
          System.err.println("\nINVALID ENTRY\nPlease choose between random playlist or custom playlist.\n");
      }

    } while (playlistType != 1 && playlistType != 2);
    
    if (playlistType == 1) {
    	int numOfTracks = 0;
    	
    	do {
    		System.out.print("Enter number of tracks to generate: ");
    		numOfTracks = scan.nextInt();
    		
    		if (numOfTracks > songTitles.length) {
    			System.err.println("\nINVALID ENTRY\nThe maximum playlist size has been exceeded.\nPlease try again.\n");
    		}
    		
    	} while (numOfTracks > songTitles.length);
    	
    	randomPlaylist(playlistName, songTitles, artists, durations, numOfTracks);
    } else if (playlistType == 2) {
    	customPlaylist(playlistName, songTitles, artists, durations);
    }
     
	}
	
	public static void randomPlaylist(String playlistName, String[] songTitles, String[] artists, String[] durations, int numOfTracks) {
		Random random = new Random();
		int minutes = 0, seconds = 0;
		System.out.println("Generated Playlist: " + playlistName);
		
		boolean[] selectedIndices = new boolean[songTitles.length];

    for (int j = 0; j < numOfTracks; j++) {
    	int randomIndex;
      do {
      	randomIndex = random.nextInt(songTitles.length);
      } while (selectedIndices[randomIndex]);

      selectedIndices[randomIndex] = true; 

      System.out.println((j + 1) + ". " + songTitles[randomIndex] + " - " + artists[randomIndex] + " (" + durations[randomIndex] + ") ");
      String duration = durations[randomIndex];
      int[] durationArray = convertDurationToMinutes(duration);
      
      minutes += durationArray[0];
      seconds += durationArray[1];
		}
		
		int addMin = seconds / 60;
	  seconds %= 60;
	    
	  System.out.printf("Total Playlist Time: %d:%02d\n", (minutes + addMin), seconds);
	}
	
	public static void customPlaylist(String playlistName, String[] songTitles, String[] artists, String[] durations) {
		int minutes = 0, seconds = 0;
		int trackCounter = 0;
		boolean[] removedTracks = new boolean[songTitles.length];

		while (true) {
			System.out.println("\nAvailable Tracks:");
			boolean anyAvailableTracks = false;
			for (int j = 0; j < songTitles.length; j++) {
				if (!removedTracks[j]) {
					anyAvailableTracks = true;
					System.out.println((j + 1) + ". " + songTitles[j] + " - " + artists[j] + " (" + durations[j] + ")");
				}
			}

			if (!anyAvailableTracks) {
				System.out.println("No tracks available.");
				break;
			}
			System.out.println();
			System.out.print("Please enter the desired track number to add (Enter [0] to finish): ");
			int trackNumber = scan.nextInt();
			scan.nextLine();

			if (trackNumber == 0) {
				break;
			}

			if (trackNumber >= 1 && trackNumber <= songTitles.length && !removedTracks[trackNumber - 1]) {
				System.out.println("Added: " + songTitles[trackNumber - 1] + " - " + artists[trackNumber - 1] + " (" + durations[trackNumber - 1] + ")");
				int[] durationArray = convertDurationToMinutes(durations[trackNumber - 1]);
				minutes += durationArray[0];
				seconds += durationArray[1];
				removedTracks[trackNumber - 1] = true;
				trackCounter++;
			} else {
				System.err.println("INVALID TRACK NUMBER\nPlease enter a valid track.\n");
			}
		}
		System.out.println("\nCustomized Playlist: " + playlistName);
		if (trackCounter > 0) {
			System.out.println("Playlist Tracks:");
			int displayCounter = 1;
			for (int j = 0; j < removedTracks.length; j++) {
				if (removedTracks[j]) {
					System.out.println(displayCounter + ". " + songTitles[j] + " - " + artists[j] + " (" + durations[j] + ")");
					displayCounter++;
				}
			}
			int addMin = seconds / 60;
			seconds %= 60;

			System.out.printf("Total Playlist Time: %d:%02d\n", (minutes + addMin), seconds);
		} else {
			System.out.println("No tracks added to the playlist.");
		}
	}

	public static int[] convertDurationToMinutes(String duration) {
		String[] parts = duration.split(":");
		int minutes = Integer.parseInt(parts[0]);
		int seconds = Integer.parseInt(parts[1]);
		return new int[]{minutes, seconds};
	}
	
}