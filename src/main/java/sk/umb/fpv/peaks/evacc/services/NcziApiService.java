package sk.umb.fpv.peaks.evacc.services;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import sk.umb.fpv.peaks.evacc.DTOs.NcziPatientsHospDTO;
import sk.umb.fpv.peaks.evacc.DTOs.NcziVaccinesDTO;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class NcziApiService {

    private final RestTemplate restTemplate;
    public NcziApiService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public NcziVaccinesDTO getVaccinations(){
        String url = "https://data.korona.gov.sk/api/vaccinations/in-slovakia";
        return this.restTemplate.getForObject(url, NcziVaccinesDTO.class);
    }

    public NcziPatientsHospDTO getPatientsInHospitals(){
        String url = "https://data.korona.gov.sk/api/hospital-patients/in-slovakia";
        return this.restTemplate.getForObject(url, NcziPatientsHospDTO.class);
    }
}
