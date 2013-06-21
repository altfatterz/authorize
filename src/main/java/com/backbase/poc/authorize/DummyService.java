package com.backbase.poc.authorize;

import org.springframework.security.access.prepost.PreAuthorize;

public interface DummyService {

    @PreAuthorize("hasRole('admin')")
    void securedService();

}
