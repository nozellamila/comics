package com.gerenciador.comics.services;

import com.gerenciador.comics.client.ComicsClient;
import com.gerenciador.comics.resources.response.ComicsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.Date;

@Service
public class ComicsService {
    private static final String PUBLIC_KEY = "e5adaa85ec57f307a002d9e921ec8fa1";
    private static final String PRIVATE_KEY = "0eac320423a5f262b6179246c28a15da0a975c1f";

    @Autowired
    private ComicsClient client;

    public ComicsResponse findAll() {
        Long timeStamp = new Date().getTime();

        return client.getAll(timeStamp, PUBLIC_KEY, buildHash(timeStamp));
    }

    private String buildHash(Long timeStamp) {
        return DigestUtils.md5Hex(timeStamp + PRIVATE_KEY + PUBLIC_KEY);
    }
}
