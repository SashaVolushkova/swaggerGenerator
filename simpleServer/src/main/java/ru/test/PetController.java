package ru.test;

import ru.generated.openapi.pet.api.PetsApi;
import ru.generated.openapi.pet.model.Pet;
import org.jeasy.random.EasyRandom;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class PetController implements PetsApi {
    private final EasyRandom generator;

    public PetController() {
        this.generator = new EasyRandom();
    }

    @Override
    public ResponseEntity<Void> createPets() {
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<List<Pet>> listPets(@Valid Integer limit) {
        return ResponseEntity.ok().body(generator.objects(Pet.class, 5)
                .collect(Collectors.toList()));
    }

    @Override
    public ResponseEntity<Pet> showPetById(String petId) {
        return ResponseEntity.ok().body(generator.nextObject(Pet.class));
    }
}
