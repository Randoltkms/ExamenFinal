package pe.edu.cibertec.backoffice_s.service;

import pe.edu.cibertec.backoffice_s.dto.CarDto;
import pe.edu.cibertec.backoffice_s.dto.CarDetailDto;

import java.util.List;
import java.util.Optional;

public interface ManageService {

    List<CarDto> getAllCar() throws Exception;

    Optional<CarDto> getAllCarsById(int id) throws Exception;

    Optional<CarDetailDto>getCarById(int car_id)throws Exception;

    boolean updateCar(CarDto carDto)throws Exception;

    boolean deleteCarById(int car)throws Exception;

    boolean addCar(CarDto carDetailDto )throws Exception;



}
