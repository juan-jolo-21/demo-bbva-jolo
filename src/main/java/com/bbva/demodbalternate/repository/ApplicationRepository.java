package com.bbva.demodbalternate.repository;

import com.bbva.demodbalternate.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application,String> {
    
}
