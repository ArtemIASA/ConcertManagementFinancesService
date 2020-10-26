package org.concertManagement.controllers;


import org.concertManagement.entities.Finances;
import org.concertManagement.entities.dto.FinancesDTO;
import org.concertManagement.services.FinancesService;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("services/finances")
public class FinancesController {
    private final FinancesService financesService;

    @Autowired
    public FinancesController(FinancesService financesService) {
        this.financesService = financesService;
    }

    @PostMapping
    public ResponseEntity<Void> changeProfit(@RequestBody FinancesDTO financesDTO){
        financesService.changeProfit(financesDTO.getConcert_id(), financesDTO.getToAdd());
        return ResponseEntity.ok().build();
    }
}
