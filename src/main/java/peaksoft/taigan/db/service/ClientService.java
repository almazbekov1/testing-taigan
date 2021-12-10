package peaksoft.taigan.db.service;

import peaksoft.taigan.db.domain.model.Client;

import java.util.List;

public interface ClientService {
    List<Client> getAllClients();
}
