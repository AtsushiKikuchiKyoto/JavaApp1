package in.techcamp.firstapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KaikeiGroupService {

    @Autowired
    private KaikeiGroupRepository kaikeiGroupRepository;

    public List<KaikeiGroupDTO> getGroupAll() {
        List<KaikeiGroupEntity> groupEntities = kaikeiGroupRepository.findAll();
        return groupEntities.stream().map(entity -> {
            KaikeiGroupDTO dto = new KaikeiGroupDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setInfo(entity.getInfo());
            return  dto;
        }).toList();
    }
    public KaikeiGroupDTO getGroupById(Long id) {
        return kaikeiGroupRepository.findById(id);
    }
}
