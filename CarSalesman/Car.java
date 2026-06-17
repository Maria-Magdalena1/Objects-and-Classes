package EntryLevel.CarSalesman;

public class Car {
    private String model;
    private Engine engine;
    private String weight;
    private String color;

    public Car(String model, Engine engine) {
        this(model, engine, "n/a", "n/a");
    }

    public Car(String model, Engine engine, String color) {
        this(model, engine, "n/a", color);
    }

    public Car(String model, Engine engine, String weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    @Override
    public String toString() {
        return String.format("%s:%n" +
                        "  %s:%n" +
                        "    Power: %d%n" +
                        "    Displacement: %s%n" +
                        "    Efficiency: %s%n" +
                        "  Weight: %s%n" +
                        "  Color: %s",
                model,
                engine.getModel(),
                engine.getPower(),
                engine.getDisplacement(),
                engine.getEfficiency(),
                weight,
                color);
    }
}
