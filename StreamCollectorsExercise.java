
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class StreamCollectorsExercise {


    public static void getPlayersByCountry(List<Player> p) {
        Map<Object, Object> countryNameWithPlayerName = p.stream()
                .collect(Collectors.toMap(p1 -> p1.getPlayerName(), p1 -> p1.getCountry()));
        System.out.println(countryNameWithPlayerName);
    }

    public static void getPlayerNamesByCountry(List<Player> p) {
        Map<Object, Object> countryNameWithPlayerName1 = p.stream()
                .filter(player -> player.getMatchesPlayed() > 100)
                .collect(Collectors.toMap(p1 -> p1.getPlayerName(), p1 -> p1.getCountry()));
        System.out.println(countryNameWithPlayerName1);
    }

    public static void getTotalPlayersByCountry(List<Player> p) {
        Map<String, Long> n = p.stream()
                .collect(Collectors.groupingBy(n1 -> n1.getCountry(), Collectors.counting()));

        System.out.println(n);
    }

    public static void getTotalRunsByCountry(List<Player> p) {
        Map<String, Long> t1 = p.stream()
                .collect(Collectors.groupingBy(t -> t.getCountry(), Collectors.summingLong(t2 -> t2.getRuns())));
        System.out.println(t1);
    }
    public static void getMaxScoreByCountry(List<Player> p) {

		Map<Object, Object> highest = p.stream()
        .collect(Collectors.groupingBy(Player::getCountry, Collectors.groupingBy(Player::getRuns,TreeMap::new, Collectors.toList())))
        .entrySet().stream()
        .collect(Collectors.toMap(e -> e.getKey(),
                e -> e.getValue().lastEntry().getKey()));
		System.out.println(highest);
	}
	public static void getPlayerNamesStringByCountry(List<Player> p){
		Map<Object, Object> countryNameWithPlayerName = p.stream().collect(Collectors.toMap(p1->p1.getCountry(),p1->p1.getPlayerName(), (s, a) -> s + ", " + a, LinkedHashMap::new));
		System.out.println(countryNameWithPlayerName);
		}

public static void main(String[] args) {
    List<Player> player = Arrays.asList(new Player("Ram",198,7644,165,"England"),
            new Player("Raju",154,8743,123,"SA"),
            new Player("Vijay",254,13243,198,"Pakistan"),
            new Player("Rahul",240,7630,190,"India"),
            new Player("Suresh",323,18735,210,"India"));

    getPlayersByCountry(player);
    getTotalPlayersByCountry(player);
    getPlayerNamesByCountry(player);
    getTotalRunsByCountry(player);
    getMaxScoreByCountry(player);
	getPlayerNamesStringByCountry(player);


}
}

