package ua.raghoulwave.bergut_api.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.raghoulwave.bergut_api.entity.OAuthAccount;
import ua.raghoulwave.bergut_api.service.OAuthAccountService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/entities/oauth_account")
@RequiredArgsConstructor
public class OAuthAccountController {

    private final OAuthAccountService service;

    @GetMapping("/get_all")
    public List<OAuthAccount> getAll() {

        List<OAuthAccount> response = service.getAll();

        log.info(
                "Getting all: {}",
                response
        );

        return response;
    }
}
