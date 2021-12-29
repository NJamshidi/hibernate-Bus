package ir.jamshidi.service;

import ir.jamshidi.dao.BusDao;
import ir.jamshidi.dao.BusScheduleDao;
import ir.jamshidi.dao.CompanyDao;
import ir.jamshidi.dto.BusScheduleCreationDTO;
import ir.jamshidi.dto.BusScheduleSearchDTO;
import ir.jamshidi.enums.BusType;
import ir.jamshidi.model.Bus;
import ir.jamshidi.model.BusSchedule;
import ir.jamshidi.model.Company;

import java.util.List;

public class BusScheduleService extends BaseService {
    protected static BusScheduleService instance;

    public static BusScheduleService getInstance() {
        if (instance == null)
            instance = new BusScheduleService();
        return instance;
    }

    public void init(){
        saveNewSchedule(new BusScheduleCreationDTO(java.sql.Date.valueOf("2021-12-26"), java.sql.Time.valueOf("15:30:00"),300000L, "TBT", BusType.SIMPLE,"tehran-11","TEH","ESF",30));
        saveNewSchedule(new BusScheduleCreationDTO(java.sql.Date.valueOf("2021-12-26"), java.sql.Time.valueOf("15:30:00"),600000L, "TBT", BusType.VIP,"tehran-12","TEH","ESF",20));
        saveNewSchedule(new BusScheduleCreationDTO(java.sql.Date.valueOf("2021-12-27"), java.sql.Time.valueOf("15:30:00"),300000L, "TBT", BusType.SIMPLE,"tehran-11","TEH","ESF",30));
        saveNewSchedule(new BusScheduleCreationDTO(java.sql.Date.valueOf("2021-12-27"), java.sql.Time.valueOf("15:30:00"),600000L, "TBT", BusType.VIP,"tehran-12","TEH","ESF",20));
        saveNewSchedule(new BusScheduleCreationDTO(java.sql.Date.valueOf("2021-12-26"), java.sql.Time.valueOf("15:30:00"),350000L, "BBT", BusType.SIMPLE,"tehran-13","TEH","ESF",30));
        saveNewSchedule(new BusScheduleCreationDTO(java.sql.Date.valueOf("2021-12-26"), java.sql.Time.valueOf("15:30:00"),650000L, "BBT", BusType.VIP,"tehran-14","TEH","ESF",20));
        saveNewSchedule(new BusScheduleCreationDTO(java.sql.Date.valueOf("2021-12-27"), java.sql.Time.valueOf("15:30:00"),320000L, "BBT", BusType.SIMPLE,"tehran-13","TEH","ESF",30));
        saveNewSchedule(new BusScheduleCreationDTO(java.sql.Date.valueOf("2021-12-27"), java.sql.Time.valueOf("15:30:00"),630000L, "BBT", BusType.VIP,"tehran-14","TEH","ESF",20));

        saveNewSchedule(new BusScheduleCreationDTO(java.sql.Date.valueOf("2021-12-26"), java.sql.Time.valueOf("15:30:00"),700000L, "TBT", BusType.SIMPLE,"tehran-15","TEH","MHD",30));
        saveNewSchedule(new BusScheduleCreationDTO(java.sql.Date.valueOf("2021-12-26"), java.sql.Time.valueOf("15:30:00"),900000L, "TBT", BusType.VIP,"tehran-16","TEH","MHD",20));
        saveNewSchedule(new BusScheduleCreationDTO(java.sql.Date.valueOf("2021-12-28"), java.sql.Time.valueOf("15:30:00"),600000L, "TBT", BusType.SIMPLE,"tehran-15","TEH","MHD",30));
        saveNewSchedule(new BusScheduleCreationDTO(java.sql.Date.valueOf("2021-12-28"), java.sql.Time.valueOf("15:30:00"),850000L, "TBT", BusType.VIP,"tehran-16","TEH","MHD",20));
        saveNewSchedule(new BusScheduleCreationDTO(java.sql.Date.valueOf("2021-12-26"), java.sql.Time.valueOf("15:30:00"),1500000L, "BBT", BusType.SIMPLE,"tehran-17","TEH","MHD",30));
        saveNewSchedule(new BusScheduleCreationDTO(java.sql.Date.valueOf("2021-12-26"), java.sql.Time.valueOf("15:30:00"),1300000L, "BBT", BusType.VIP,"tehran-18","TEH","MHD",20));
        saveNewSchedule(new BusScheduleCreationDTO(java.sql.Date.valueOf("2021-12-28"), java.sql.Time.valueOf("15:30:00"),980000L, "BBT", BusType.SIMPLE,"tehran-17","TEH","MHD",30));
        saveNewSchedule(new BusScheduleCreationDTO(java.sql.Date.valueOf("2021-12-28"), java.sql.Time.valueOf("15:30:00"),1320000L, "BBT", BusType.VIP,"tehran-18","TEH","MHD",20));

       saveNewSchedule(new BusScheduleCreationDTO(java.sql.Date.valueOf("2021-12-30"), java.sql.Time.valueOf("15:30:00"),700000L, "CCA", BusType.SIMPLE,"tehran-15","TEH","SHZ",30));
        saveNewSchedule(new BusScheduleCreationDTO(java.sql.Date.valueOf("2021-12-29"), java.sql.Time.valueOf("15:30:00"),900000L, "CCA", BusType.VIP,"tehran-16","TEH","SHZ",20));
        saveNewSchedule(new BusScheduleCreationDTO(java.sql.Date.valueOf("2021-12-30"), java.sql.Time.valueOf("15:30:00"),600000L, "CCA", BusType.SIMPLE,"tehran-15","TEH","SHZ",30));
        saveNewSchedule(new BusScheduleCreationDTO(java.sql.Date.valueOf("2022-01-01"), java.sql.Time.valueOf("15:30:00"),850000L, "ATC", BusType.VIP,"tehran-16","TEH","SHZ",20));
        saveNewSchedule(new BusScheduleCreationDTO(java.sql.Date.valueOf("2022-01-02"), java.sql.Time.valueOf("15:30:00"),1100000L, "ATC", BusType.SIMPLE,"tehran-17","TEH","SHZ",30));
        saveNewSchedule(new BusScheduleCreationDTO(java.sql.Date.valueOf("2022-01-03"), java.sql.Time.valueOf("15:30:00"),1400000L, "ATC", BusType.VIP,"tehran-18","TEH","TBR",20));
        saveNewSchedule(new BusScheduleCreationDTO(java.sql.Date.valueOf("2022-01-04"), java.sql.Time.valueOf("15:30:00"),920000L, "ATC", BusType.SIMPLE,"tehran-17","TEH","TBR",30));
        saveNewSchedule(new BusScheduleCreationDTO(java.sql.Date.valueOf("2022-01-05"), java.sql.Time.valueOf("15:30:00"),1120000L, "BBT", BusType.VIP,"tehran-18","TEH","TBR",20));
    }

    public void saveNewSchedule(BusScheduleCreationDTO schedule) {
        Company company = CompanyDao.getInstance().findByName(schedule.getCompanyName());
        if (company == null) {
            company = new Company(schedule.getCompanyName());
            CompanyDao.getInstance().save(company);
        }
        Bus bus = BusDao.getInstance().findByPlaque(schedule.getPlaque());
        if (bus == null) {
            bus = new Bus();
            bus.setType(schedule.getBusType());
            bus.setPlaque(schedule.getPlaque());
            bus.setCompany(company);
            bus.setCapacity(schedule.getCapacity());
            BusDao.getInstance().save(bus);
        }
        BusSchedule busSchedule = new BusSchedule(bus, schedule.getDate(), schedule.getTime(), schedule.getPrice(), schedule.getStartPoint(), schedule.getDestinations());
        BusScheduleDao.getInstance().save(busSchedule);
    }

    public List<BusScheduleCreationDTO> findSchedules(BusScheduleSearchDTO dto){
        List<BusSchedule> schedules = BusScheduleDao.getInstance().findSchedules(dto);
        System.out.println(schedules);
        return null;
    }
}
