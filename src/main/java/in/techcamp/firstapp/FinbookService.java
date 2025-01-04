package in.techcamp.firstapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FinbookService {

    @Autowired
    private KaikeiFinbookRepository repository;

    public FinbookWithGroupDTO getFinbookWithGroupName(Long id) {
        return repository.findByIdBindGroupName(id);
    }
}
