package ir.jamshidi;

import ir.jamshidi.dto.BusScheduleSearchDTO;
import ir.jamshidi.service.BusScheduleService;
import ir.jamshidi.service.CompanyService;

public class Main {
    public static void main(String[] args) {
        CompanyService.getInstance().initCompanies();
        BusScheduleService.getInstance().init();

        BusScheduleSearchDTO dto = new BusScheduleSearchDTO();
        dto.setCompanyName("TBT");
        dto.setStartPoint("TEH");
//        dto.setDestination("ESF");
//        dto.setBusType(BusType.VIP);
//        dto.setDate(java.sql.Date.valueOf("2021-12-26"));
//        dto.setFromPrice(20000L);
//        dto.setFromPrice(100000L);
        System.out.println("page 1");
        dto.setOffset(0);
        dto.setPageSize(4);
        BusScheduleService.getInstance().findSchedules(dto);

        System.out.println("page 2");
        dto.setOffset(4);
        dto.setPageSize(4);
        BusScheduleService.getInstance().findSchedules(dto);
    }


}
