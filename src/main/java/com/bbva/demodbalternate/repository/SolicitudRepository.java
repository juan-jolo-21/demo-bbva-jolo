package com.bbva.demodbalternate.repository;

import com.bbva.demodbalternate.model.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolicitudRepository extends JpaRepository<Solicitud,String> {
}
