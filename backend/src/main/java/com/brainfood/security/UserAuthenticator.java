package com.brainfood.security;

import com.brainfood.security.model.User;
import com.brainfood.security.model.UserCredentials;
import com.brainfood.security.repository.UserCredentialsRepository;
import com.brainfood.security.repository.UserRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Objects;

@Component
public class UserAuthenticator {

    @Autowired
    UserCredentialsRepository userCredentialsRepository;
    @Autowired
    UserRepository userRepository;
    @Getter
    @Setter
    @Autowired
    public BCryptPasswordEncoder bCryptPasswordEncoder;


    public Response createAuthentications(String username, String password, String email, String height, String weight, String gender, String birthdate) throws ParseException {
        if (userExistsByUsername(username))
            return Response.UsernameAlreadyExists;
        if (userExistsByEmail(email))
            return Response.EmailAlreadyExists;
        if (Objects.equals(height, "") || Objects.equals(weight, "") || Objects.equals(birthdate, "") ||
                Objects.equals(username, "") || Objects.equals(email, "") || Objects.equals(password, "")) {
            return Response.MissingInputs;
        }
        String encryptedPD = this.bCryptPasswordEncoder.encode(password);
        UserCredentials userCredentials = new UserCredentials();
        userCredentials.setPassword(encryptedPD);
        userCredentials.setUsername(username);
        userCredentials.setEmail(email);
        userCredentialsRepository.save(userCredentials);

        User user = new User();
        user.setID(userCredentials.getID());
        user.setUsername(username);
        user.setHeight(Integer.parseInt(height));
        user.setWeight(Integer.parseInt(weight));
        user.setGender(gender);
        user.setBirthdate(Date.valueOf(LocalDate.parse(birthdate)));
        userRepository.save(user);
        System.out.println(encryptedPD.length());
        return Response.UserCreated;
    }

    public UserCredentials getUserByUsername(String username) {
        return userCredentialsRepository.findByUsername(username);
    }

    public UserCredentials getUserByEmail(String email) {
        return userCredentialsRepository.findByEmail(email);
    }

    public boolean userExistsByEmail(String email) {
        return userCredentialsRepository.findByEmail(email) != null;
    }

    public boolean userExistsByUsername(String username) {
        return userCredentialsRepository.findByUsername(username) != null;
    }

}
