package pe.edu.cibertec.backoffice_s.response;


import pe.edu.cibertec.backoffice_s.dto.CarDetailDto;

public record FindCarsByIdResponse(String code, String error, CarDetailDto car) {
}
