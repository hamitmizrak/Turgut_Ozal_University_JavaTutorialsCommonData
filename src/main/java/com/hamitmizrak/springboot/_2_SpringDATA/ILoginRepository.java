package com.hamitmizrak.springboot._2_SpringDATA;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILoginRepository extends CrudRepository<LoginEntity,Long> {

    //Delivered Query
    LoginEntity findByEmail(String email);
}
