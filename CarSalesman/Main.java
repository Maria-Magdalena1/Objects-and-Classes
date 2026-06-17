package EntryLevel.CarSalesman;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Engine> engines = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            String model = data[0];
            int power = Integer.parseInt(data[1]);

            Engine engine;
            if (data.length == 2) {
                engine = new Engine(model, power);
            } else if (data.length == 3) {
                if (Character.isDigit(data[2].charAt(0))) {
                    engine = new Engine(model, power, data[2]);
                } else {
                    engine = new Engine(model, power, "n/a", data[2]);
                }
            } else {
                engine = new Engine(model, power, data[2], data[3]);
            }

            engines.put(model, engine);
        }

        int m = Integer.parseInt(scanner.nextLine());

        List<Car> cars = new ArrayList<>();
        for (int i = 1; i <= m; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            String model = data[0];
            Engine engine = engines.get(data[1]);
            Car car;

            if (data.length == 2) {
                car = new Car(model, engine);
            } else if (data.length == 3) {
                if (Character.isDigit(data[2].charAt(0))) {
                    car = new Car(model, engine, data[2], "n/a");
                } else {
                    car = new Car(model, engine, data[2]);
                }
            } else {
                car = new Car(model, engine, data[2], data[3]);
            }

            cars.add(car);
        }

        for (Car car : cars) {
            System.out.println(car);
        }
    }
}
