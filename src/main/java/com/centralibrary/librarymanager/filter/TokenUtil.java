package com.centralibrary.librarymanager.filter;

import com.centralibrary.librarymanager.exception.BusinessException;
import com.centralibrary.librarymanager.entity.Staff;
import com.centralibrary.librarymanager.entity.Student;
import com.centralibrary.librarymanager.repo.StaffRepository;
import com.centralibrary.librarymanager.repo.StudentRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TokenUtil {

    @Value("${login.token.expiry.inseconds}")
    int tokenExpiry;

    @Value("${login.token.secret}")
    String tokenSecret;

    @Autowired
    StaffRepository staffRepository;

    @Autowired
    StudentRepository studentRepository;

    public Claims validateToken(String jwtToken) {
        String token = jwtToken.replaceAll("Bearer ", "");
        return Jwts.parser().setSigningKey(tokenSecret).parseClaimsJws(token).getBody();
    }

    public String generateToken(String email) {
        Staff staff = staffRepository.findByEmailAddress(email);
        if (staff != null) {
            return Jwts.builder().setSubject(email)
                    .claim("roles", "staff")
                    .setIssuedAt(new Date())
                    .signWith(SignatureAlgorithm.HS256, tokenSecret)
                    .setExpiration(new Date(System.currentTimeMillis() + (tokenExpiry * 1000)))
                    .compact();
        }
        Student student = studentRepository.findByEmailAddress(email);
        if (student != null) {
            return Jwts.builder().setSubject(email)
                    .claim("roles", "student")
                    .setIssuedAt(new Date())
                    .signWith(SignatureAlgorithm.HS256, "root123")
                    .setExpiration(new Date(System.currentTimeMillis() + (tokenExpiry * 1000)))
                    .compact();
        }

        throw new BusinessException("Not a valid user role", 403);
    }
}
