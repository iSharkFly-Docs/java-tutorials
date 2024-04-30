package com.ossez.ws.server;

import jakarta.jws.WebService;

@WebService(endpointInterface = "com.ossez.ws.server.CountryService")
public class CountryServiceImpl implements CountryService {

    private CountryRepository countryRepository = new CountryRepository();

    @Override
    public Country findByName(String name) {
        return countryRepository.findCountry(name);
    }

}
