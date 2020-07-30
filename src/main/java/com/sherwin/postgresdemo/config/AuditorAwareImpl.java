package com.sherwin.postgresdemo.config;

import com.sherwin.postgresdemo.employee.Employee;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        if (SecurityContextHolder.getContext().getAuthentication() == null ||
                SecurityContextHolder.getContext().getAuthentication().getPrincipal().equals("anonymousUser")) {
            return Optional.of("admin@gmail.com");
        } else {
            return Optional.of(((Employee) SecurityContextHolder.getContext().
                    getAuthentication().getPrincipal()).getFirstName());
        }
    }
}
