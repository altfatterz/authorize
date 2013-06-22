package com.backbase.poc.authorize.service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class DummyServiceImpl implements DummyService {

    @PreAuthorize("hasRole('admin')")
    public void securedService() {
    }
}
