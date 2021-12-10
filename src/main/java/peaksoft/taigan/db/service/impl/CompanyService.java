package peaksoft.taigan.db.service.impl;

import org.springframework.stereotype.Service;
import peaksoft.taigan.db.domain.model.Company;
import peaksoft.taigan.db.repo.CompanyRepo;

@Service
public class CompanyService {

    private final CompanyRepo companyRepo;

    public CompanyService(CompanyRepo companyRepo) {
        this.companyRepo = companyRepo;
    }

    public void save(Company company){
        companyRepo.save(company);
    }
}
