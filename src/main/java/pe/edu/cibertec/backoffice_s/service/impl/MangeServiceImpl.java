package pe.edu.cibertec.backoffice_s.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.backoffice_s.dto.CarDto;
import pe.edu.cibertec.backoffice_s.dto.CarDetailDto;
import pe.edu.cibertec.backoffice_s.entity.Car;
import pe.edu.cibertec.backoffice_s.repository.CarRepository;
import pe.edu.cibertec.backoffice_s.service.ManageService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MangeServiceImpl implements ManageService {

    @Autowired
    CarRepository carRepository;


    @Override
    public List<CarDto> getAllCar() throws Exception {
        List<CarDto>cars=new ArrayList<>();

        Iterable<Car>iterable=carRepository.findAll();
        iterable.forEach(car -> {
            cars.add(new CarDto(car.getCar_id(),
                    car.getModel(),
                    car.getColor(),
                    car.getOwnerName()));
        });
        return cars;
    }

    @Override
    public Optional<CarDto> getAllCarsById(int id) throws Exception {

        Optional<Car>optional=carRepository.findById(id);
        return optional.map(car -> new CarDto(car.getCar_id(),
                car.getModel(),
                car.getColor(),
                car.getOwnerName()));





    }


    @Override
    public Optional<CarDetailDto> getCarById(int car_id) throws Exception {
        Optional<Car> optional = carRepository.findById(car_id);
        return optional.map(car -> new CarDetailDto(car.getCar_id(),
                car.getMake(),
                car.getModel(),
                car.getYear(),
                car.getVin(),
                car.getLicensePlate(),
                car.getOwnerName(),
                car.getOwnerContact(),
                car.getPurchaseDate(),
                car.getMileage(),
                car.getEngineType(),
                car.getColor(),
                car.getInsuranceCompany(),
                car.getInsurancePolicyNumber(), car.getRegistrationExpirationDate(), car.getServiceDueDate()));




    }

    @Override
    public boolean updateCar(CarDto carDto) throws Exception {
        // Buscar el carro en la base de datos por su ID
        Optional<Car> optional = carRepository.findById(carDto.car_id());

        //  existe, actualizar los campos y guardar
        return optional.map(car -> {
            car.setModel(carDto.model());
            car.setColor(carDto.color());
            car.setOwnerName(carDto.ownerName());
            carRepository.save(car);
            return true;
        }).orElse(false);
    }


    @Override
    public boolean deleteCarById(int id) throws Exception {
        Optional<Car> optional = carRepository.findById(id);
        return optional.map(car -> {
            carRepository.delete(car);
            return true;
        }).orElse(false);
    }

    @Override
    public boolean addCar(CarDto carDto) throws Exception {

        Optional<Car> optional = carRepository.findById(carDto.car_id());
        if (optional.isPresent()) {
            return false;
        } else {
            Car car = new Car();
            car.setModel(carDto.model());
            car.setColor(carDto.color());
            car.setEngineType(carDto.ownerName());
            carRepository.save(car);
            return true;
        }

    }
}
