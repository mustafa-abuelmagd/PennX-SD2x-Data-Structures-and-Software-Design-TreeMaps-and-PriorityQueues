/*
 * SD2x Homework #5
 * Implement the method below according to the specification in the assignment description.
 * Please be sure not to change the method signature!
 */

import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class MovieRatingsParser {

	public static TreeMap<String, PriorityQueue<Integer>> parseMovieRatings(List<UserMovieRating> allUsersRatings) {
		if (allUsersRatings == null || allUsersRatings.isEmpty() ) {
			return new TreeMap<String, PriorityQueue<Integer>>();
		}
		TreeMap<String, PriorityQueue<Integer>>  newTreeMap = new TreeMap<String, PriorityQueue<Integer>>();
		
		for (UserMovieRating rating : allUsersRatings ) {
			if (rating != null && rating.getMovie() != null 
					&& rating.getMovie() !="" && !(rating.getUserRating()<0) ) {
				String movieName = rating.getMovie().toLowerCase();
				if (!newTreeMap.containsKey(movieName)) {
					newTreeMap.put(movieName  , new PriorityQueue<Integer>());
					newTreeMap.get(movieName).add(rating.getUserRating());
				}
				else {
					newTreeMap.get(movieName).add(rating.getUserRating());
				}				
			}
		}		
		return newTreeMap; 
	}

}
