package ir.jamshidi.service;

import ir.jamshidi.dao.CompanyDao;
import ir.jamshidi.model.Company;

public class CompanyService extends BaseService {
    protected static CompanyService instance;

    public static CompanyService getInstance() {
        if (instance == null)
            instance = new CompanyService();
        return instance;
    }

    public void initCompanies() {
        Company company = new Company("TBT");
        CompanyDao.getInstance().save(company);
        company = new Company("ATC");
        CompanyDao.getInstance().save(company);
        company = new Company("BBT");
        CompanyDao.getInstance().save(company);
        company = new Company("CCA");
        CompanyDao.getInstance().save(company);
    }
}
