package ir.jamshidi.dao;

import com.mysql.cj.util.StringUtils;
import ir.jamshidi.dto.BusScheduleSearchDTO;
import ir.jamshidi.model.Bus;
import ir.jamshidi.model.BusSchedule;
import ir.jamshidi.model.Company;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

public class BusScheduleDao extends BaseDao {
    protected static BusScheduleDao instance;

    public static BusScheduleDao getInstance() {
        if (instance == null)
            instance = new BusScheduleDao();
        return instance;
    }

    public List<BusSchedule> findSchedules(BusScheduleSearchDTO dto) {
        Session session = getSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<BusSchedule> cr = builder.createQuery(BusSchedule.class);
        Root<BusSchedule> root = cr.from(BusSchedule.class);
        Join<BusSchedule, Bus> busJoin = root.join("bus", JoinType.INNER);
        Join<Bus, Company> companyJoin = busJoin.join("company", JoinType.INNER);

        List<Predicate> predicates = new ArrayList<>();

        if (!StringUtils.isNullOrEmpty(dto.getCompanyName())) {
            predicates.add(builder.equal(companyJoin.get("name"), dto.getCompanyName()));
        }
        if (dto.getFromPrice() != null) {
            predicates.add(builder.ge(root.get("price"), dto.getFromPrice()));
        }
        if (dto.getToPrice() != null) {
            predicates.add(builder.le(root.get("price"), dto.getToPrice()));
        }
        if (!StringUtils.isNullOrEmpty(dto.getStartPoint())) {
            predicates.add(builder.equal(root.get("startPoint"), dto.getStartPoint()));
        }
        if (!StringUtils.isNullOrEmpty(dto.getDestination())) {
            predicates.add(builder.equal(root.get("destination"), dto.getDestination()));
        }
        if (dto.getBusType() != null) {
            predicates.add(builder.equal(busJoin.get("type"), dto.getBusType()));
        }
        if (dto.getDate() != null) {
            predicates.add(builder.equal(root.get("date"), dto.getDate()));
        }


        cr.select(root).where(predicates.toArray(Predicate[]::new));
        Query<BusSchedule> query = session.createQuery(cr);
        if (dto.getOffset() != null && dto.getPageSize() != null) {
            query.setFirstResult(dto.getOffset());
            query.setMaxResults(dto.getPageSize());
        }
        return query.getResultList();
    }
}
