import java.util.*;

public class Application {
	
    public static void main(String[] args) {
	
		// Словарь хранит города и население (данные Википедии по состоянию на 2018-2019 год) 
        ChainHashMap<String, Integer> cities = new ChainHashMap<>(); 
		
		cities.put("Moscow", 12615882);
		cities.put("Tomsk", 574002);
		cities.put("Ekaterinburg", 1468833);
		cities.put("Chelyabinsk", 1202371);
		cities.put("Magnitogorsk", 416521);
		cities.put("Tymen", 788666);
		cities.put("Habarovsk", 618150);
		cities.put("Peterburg", 5383968);
		cities.put("Ufa", 1120547);
		cities.put("Samara", 1163399);
		cities.put("Perm", 1051583);
		cities.put("Rostov", 1013533);
		cities.put("Voronej", 1054537);
		cities.put("Krasnodar", 918145);
		cities.put("Volgograd", 1013533);

        System.out.println(cities);
    }
}
