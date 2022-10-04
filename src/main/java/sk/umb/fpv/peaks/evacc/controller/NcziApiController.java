package sk.umb.fpv.peaks.evacc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.umb.fpv.peaks.evacc.service.api.service.NcziApiService;
import sk.umb.fpv.peaks.evacc.service.api.dto.*;

@RestController
public class NcziApiController {

    private NcziApiService service;
    public NcziApiController(NcziApiService service) {
        this.service = service;
    }

    @GetMapping("/api/nczi/vaccinations")
    public TotalVaccinationsDTO getVaccinations(){
        NcziVaccinesDTO dto = service.getVaccinations();
        TotalVaccinationsDTO totalDto = new TotalVaccinationsDTO();
        totalDto.sum = dto.page.get(0).dose1_count + dto.page.get(0).dose2_count;
        return totalDto;
    }

    @GetMapping("/api/nczi/hospital/patients")
    public TotalHospitalPatientsDTO getHospitalPatients(){
        NcziPatientsDTO dto = service.getHospitalPatients();
        TotalHospitalPatientsDTO totalDto = new TotalHospitalPatientsDTO();
        totalDto.sum = dto.page.get(0).confirmed_covid + dto.page.get(0).suspected_covid;
        return totalDto;
    }

    @GetMapping("/api/nczi/agtests")
    public TotalPositiveDTO getPositives(){
        NcziPositiveDTO dto = service.getPositives();
        TotalPositiveDTO totalDto = new TotalPositiveDTO();
        totalDto.sum = dto.page.get(0).positives_sum;
        return totalDto;
    }


}
