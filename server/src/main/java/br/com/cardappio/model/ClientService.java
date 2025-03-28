package br.com.cardappio.model;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClientService {

    private final ClientRepository repository;

    public List<Client> findAll() {
        return repository.findAll();
    }

    public Client findOne(Long id) {
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public Long save(Client newClient) {
        return repository.save(newClient).getId();
    }

    public Client update(final Long id, final Client updatedClient) {
        return repository.findById(id)
                .map(client -> repository.save(updatedClient))
                .orElseThrow(EntityNotFoundException::new);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}
