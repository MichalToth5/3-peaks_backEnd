package sk.umb.fpv.peaks.evacc.service;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import sk.umb.fpv.peaks.evacc.controller.dto.NcziPatientsDTO;
import sk.umb.fpv.peaks.evacc.controller.dto.NcziPositiveDTO;
import sk.umb.fpv.peaks.evacc.controller.dto.NcziVaccinesDTO;

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

    public NcziPatientsDTO getHospitalPatients(){
        String url = "https://data.korona.gov.sk/api/hospital-patients/in-slovakia";
        return this.restTemplate.getForObject(url, NcziPatientsDTO.class);
    }

    public NcziPositiveDTO getPositives(){
        String url = "https://data.korona.gov.sk/api/ag-tests/in-slovakia";
        return this.restTemplate.getForObject(url, NcziPositiveDTO.class);
    }
}
