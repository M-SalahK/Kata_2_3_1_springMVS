package web.service;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarServiceImpl implements CarService {
    private final List<Car> cars;

    {
        cars = new ArrayList<>();
        cars.add(new Car("Кибиев", 1997, "2600"));
        cars.add(new Car("Рамзан", 1997, "2600"));
        cars.add(new Car("Сайд-Магомедович", 1997, "2600"));
    }

    @Override
    public List<Car> getCar(int count) {
        if (count == 0) {
            return cars;
        } else {
            return cars.stream().limit(count).collect(Collectors.toList());
        }
    }
}
