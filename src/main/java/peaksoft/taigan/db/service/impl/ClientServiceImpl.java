package peaksoft.taigan.db.service.impl;

import org.springframework.stereotype.Service;
import peaksoft.taigan.db.domain.model.Client;
import peaksoft.taigan.db.repo.ClientRepo;
import peaksoft.taigan.db.service.ClientService;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepo clientRepo;

    public ClientServiceImpl(ClientRepo clientRepo) {
        this.clientRepo = clientRepo;
    }

    @Override
    public List<Client> getAllClients() {
        return clientRepo.findAll();
    }
}
