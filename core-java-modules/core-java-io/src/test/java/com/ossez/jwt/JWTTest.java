package com.ossez.jwt;

import com.nimbusds.jose.shaded.json.JSONArray;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class JWTTest {
    private static final Logger logger = LoggerFactory.getLogger(JWTTest.class);

    private static final String HOME = System.getProperty("user.home");

    /**
     *
     */
    @Test
    public void claimsValueTest() {
        String token = "eyJ0eXAiOiJKV1QiLC"; //Change your Token
        try {
            SignedJWT sjwt = SignedJWT.parse(token);

            JWTClaimsSet claims = sjwt.getJWTClaimsSet();
            JSONArray groups = (JSONArray) claims.getClaim("roles");
            logger.debug("roles - {}", groups.toJSONString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
