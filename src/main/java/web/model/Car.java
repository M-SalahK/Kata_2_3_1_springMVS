package web.model;

public class Car {
    private String model;
    private int year;
    private String horsepower;

    public Car(String model, int year, String Horsepower) {
        this.model = model;
        this.year = year;
        this.horsepower = Horsepower;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(String color) {
        this.horsepower = color;
    }
}
