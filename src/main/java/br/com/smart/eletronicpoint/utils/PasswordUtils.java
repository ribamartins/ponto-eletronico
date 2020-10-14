package br.com.smart.eletronicpoint.utils;

import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@NoArgsConstructor
public class PasswordUtils {

    private static final Logger log = LoggerFactory.getLogger((PasswordUtils.class));

    public static String generateBCrypt(String password){
        if(password == null){
            return password;
        }

        log.info("Generating hash com o BCrypt");
        BCryptPasswordEncoder bCryptEncoder = new BCryptPasswordEncoder();
        return bCryptEncoder.encode(password);
    }
}
