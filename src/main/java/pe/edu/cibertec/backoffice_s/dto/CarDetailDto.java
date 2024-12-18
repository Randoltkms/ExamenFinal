package pe.edu.cibertec.backoffice_s.dto;

import java.util.Date;

public record CarDetailDto(Integer car_id,
                           String  make,
                           String model,
                           Integer  year,
                           String vin,
                           String licensePlate,
                           String ownerName,
                           String ownerContact,
                           Date purchaseDate,
                           Integer mileage,
                           String engineType,
                           String     color,
                           String insuranceCompany,
                           String  insurancePolicyNumber,
                           Date registrationExpirationDate,
                           Date        serviceDueDate ) {
}
