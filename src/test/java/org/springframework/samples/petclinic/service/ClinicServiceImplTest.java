package org.springframework.samples.petclinic.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.samples.petclinic.model.PetType;
import org.springframework.samples.petclinic.repository.PetRepository;

@ExtendWith(MockitoExtension.class)
public class ClinicServiceImplTest {
    
    @Mock
    PetRepository petRepository;
    
    @InjectMocks
    ClinicServiceImpl service;
    
    @Test
    void findPetTypes() {
    	List<PetType> petTypes = new ArrayList<PetType>();
    	petTypes.add(new PetType());
    	
    	when(petRepository.findPetTypes()).thenReturn(petTypes);
    	
    	assertEquals(1, service.findPetTypes().size());
    	verify(petRepository).findPetTypes();
    }
}
