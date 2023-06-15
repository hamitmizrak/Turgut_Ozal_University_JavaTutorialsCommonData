package com.hamitmizrak.finalhome.webprogramming;

import com.hamitmizrak.bean.ModelMapperBean;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

//LOMBOK
@RequiredArgsConstructor
@Log4j2

@Service
public class JqueryServiceImpl implements  IJqueryService{

    //Injection
    private final IJqueryRepository iJqueryRepository;
    private final ModelMapperBean modelMapperBean;


    // MODEL MAPPER
    @Override
    public JqueryDto EntityToDto(JqueryEntity jqueryEntity) {
        return modelMapperBean.modelMapperMethod().map(jqueryEntity, JqueryDto.class);
    }

    @Override
    public JqueryEntity DtoToEntity(JqueryDto jqueryDto) {
        return modelMapperBean.modelMapperMethod().map(jqueryDto, JqueryEntity.class);
    }

    // CREATE
    @Transactional //create delete update (manipulation)
    public JqueryDto createRegister(JqueryDto jqueryDto) {
        //eğer objenin içi doluysa
        if (jqueryDto != null) {
            JqueryEntity jqueryEntity = DtoToEntity(jqueryDto);
            JqueryEntity jqueryEntity1 = iJqueryRepository.save(jqueryEntity);
            //ID dönsün
            jqueryDto.setId(jqueryEntity1.getId());
        }
        return jqueryDto;
    }

    // LIST
    // @Transactional: select ve list için yazmama gerek yok
    public List<JqueryDto> getAllRegisters() {
        Iterable<JqueryEntity> entityList = iJqueryRepository.findAll();
        //Entity Listesi , Dto Listesine cevir
        List<JqueryDto> dtoList = new ArrayList<>();
        for (JqueryEntity temp : entityList) {
            JqueryDto userRegisterDto = EntityToDto(temp);
            dtoList.add(userRegisterDto);
        }
        return dtoList;
    }

}// end class
