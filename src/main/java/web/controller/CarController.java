package web.controller;

import org.springframework.web.bind.annotation.*;
import web.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import web.service.CarServiceImpl;

import java.util.List;

@Controller
public class CarController {


    private final CarServiceImpl carServiceImpl;

    @Autowired
    public CarController(CarServiceImpl carServiceImpl) {

        this.carServiceImpl = carServiceImpl;
    }

    @RequestMapping("/")
    public String getCar(@RequestParam(required = false, defaultValue = "0") int count, Model model) {
        List<Car> cars = carServiceImpl.getCar(count);
        model.addAttribute("cars", cars);
        return "cars";
    }
}
