package com.hamitmizrak.business.services.impl;

import com.hamitmizrak.bean.ModelMapperBean;
import com.hamitmizrak.bean.PasswordEncoderBean;
import com.hamitmizrak.business.dto.RegisterDto;
import com.hamitmizrak.business.services.IRegisterService;
import com.hamitmizrak.data.entity.RegisterEntity;
import com.hamitmizrak.data.repository.IRegisterRepository;
import com.hamitmizrak.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

//LOMBOK
@RequiredArgsConstructor
@Log4j2
//SneakyThrows

//Service: Asıl iş yükünü yapan class
@Service
public class RegisterServiceImpl implements IRegisterService {

    //Injection
    private final IRegisterRepository iUserRegisterRepository;
    private final ModelMapperBean modelMapperBean;
    private final PasswordEncoderBean passwordEncoderBean;


    // MODEL MAPPER
    @Override
    public RegisterDto EntityToDto(RegisterEntity userRegisterEntity) {
        return modelMapperBean.modelMapperMethod().map(userRegisterEntity, RegisterDto.class);
    }

    @Override
    public RegisterEntity DtoToEntity(RegisterDto userRegisterDto) {
        return modelMapperBean.modelMapperMethod().map(userRegisterDto, RegisterEntity.class);
    }

    // CREATE
    @Transactional //create delete update (manipulation)
    @Override
    public RegisterDto createRegister(RegisterDto registerDto) {
        //eğer objenin içi doluysa
        if (registerDto != null) {
            //sifreyi masklemek
            registerDto.setPasswd(passwordEncoderBean.passwordEncoderMethod().encode(registerDto.getPasswd()));
            RegisterEntity entityMapper = DtoToEntity(registerDto);
            RegisterEntity userRegisterEntity = iUserRegisterRepository.save(entityMapper);
            //ID dönsün
            registerDto.setId(userRegisterEntity.getId());
        }
        return registerDto;
    }

    // LIST
    // @Transactional: select ve list için yazmama gerek yok
    @Override
    public List<RegisterDto> getAllRegisters() {
        Iterable<RegisterEntity> entityList = iUserRegisterRepository.findAll();
        //Entity Listesi , Dto Listesine cevir
        List<RegisterDto> dtoList = new ArrayList<>();
        for (RegisterEntity temp : entityList) {
            RegisterDto userRegisterDto = EntityToDto(temp);
            dtoList.add(userRegisterDto);
        }
        return dtoList;
    }

    // FIND
    // @Transactional: select ve list için yazmama gerek yok
    @Override
    public RegisterDto getFindByRegisterId(Long id) {
        //1.YOL
      /*
        Optional<UserRegisterEntity> findEntity= iUserRegisterRepository.findById(id);
        //Model Mapper
       UserRegisterDto findDto= EntityToDto(findEntity.get());
        // findEntity.isPresent() VEYA findEntity!=null
        if(findEntity.isPresent()){
            return findDto;
        }
        */

        //2.YOL
       RegisterEntity findEntity = iUserRegisterRepository.findById(id)
                //Lambda expression
                .orElseThrow(() -> new ResourceNotFoundException(id + " nolu id bulunamadı"));
        //Model Mapper
        RegisterDto findDto = EntityToDto(findEntity);
        return findDto;
    }

    // DELETE
    @Transactional
    @Override
    public Map<String,Boolean>  deleteRegister(Long id) {
        RegisterEntity findEntity = iUserRegisterRepository.findById(id)
                //Lambda expression
                .orElseThrow(() -> new ResourceNotFoundException(id + " nolu id bulunamadı"));
        //Obje doluysa silsin
        Map<String,Boolean> deleteResponse=new LinkedHashMap<>();
        if(findEntity!=null){
            iUserRegisterRepository.delete(findEntity);
            deleteResponse.put("Silindi",Boolean.TRUE);
        }
        //Model Mapper: eğer aşağıdaki Object döndürmek istersen
        //UserRegisterDto findDto = EntityToDto(findEntity);
        return deleteResponse;
    }

    //UPDATE
    @Transactional
    @Override
    public RegisterDto updateRegister(Long id,RegisterDto userRegisterDto) {
        RegisterEntity findEntity = iUserRegisterRepository.findById(id)
                //Lambda expression
                .orElseThrow(() -> new ResourceNotFoundException(id + " nolu id bulunamadı"));
        //Obje doluysa silsin
        if(findEntity!=null){
            findEntity.setUname(userRegisterDto.getUname());
            findEntity.setEmail(userRegisterDto.getEmail());
            findEntity.setPasswd(passwordEncoderBean.passwordEncoderMethod().encode(findEntity.getPasswd()));
            iUserRegisterRepository.save(findEntity);
        }
        //Model Mapper
        RegisterDto findDto = EntityToDto(findEntity);
        return findDto;
    }
}
