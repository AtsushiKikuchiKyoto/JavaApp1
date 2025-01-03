package in.techcamp.firstapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KaikeiGroupService {

    @Autowired
    private KaikeiGroupRepository kaikeiGroupRepository;

    public KaikeiGroupDTO getGroupById(Long id) {
        return kaikeiGroupRepository.findById(id);
    }
}
