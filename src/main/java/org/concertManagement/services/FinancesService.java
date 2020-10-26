package org.concertManagement.services;


import org.concertManagement.entities.Finances;
import org.concertManagement.repo.FinancesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
public class FinancesService {
    private final FinancesRepository financesRepository;

    @Autowired
    public FinancesService(FinancesRepository financesRepository) {
        this.financesRepository = financesRepository;
    }

    @Transactional
    public void changeProfit(UUID concertId, int toAdd){
        Finances finances1 = findFinancesByConcertId(concertId);
        finances1.setProfit(finances1.getProfit() + toAdd);
        financesRepository.save(finances1);
    }

    @Transactional
    public void changeExpenses(UUID concertId, int toAdd){
        Finances finances1 = findFinancesByConcertId(concertId);
        finances1.setExpenses(finances1.getExpenses() + toAdd);
        financesRepository.save(finances1);
    }

    private Finances findFinancesByConcertId(UUID concertId){
        List<Finances> finances = financesRepository.findByConcert_id(concertId);
        Finances finances1;
        if(finances.isEmpty()){
            finances1 = new Finances();
            finances1.setConcert_id(concertId);
        }
        else{
            finances1 = finances.get(0);
        }
        return finances1;
    }

}
