package pe.edu.cibertec.backoffice_s.response;


import pe.edu.cibertec.backoffice_s.dto.CarDto;

public record FindCarsResponse(String code, String error, Iterable<CarDto> cars) {
}
