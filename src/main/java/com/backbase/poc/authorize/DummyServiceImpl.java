package com.backbase.poc.authorize;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class DummyServiceImpl implements DummyService {

    @Override
    public void securedService() {
    }
}
