package com.gerenciador.comics.client;

import com.gerenciador.comics.resources.response.ComicResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "marvel", url = "${url.marvel}/v1/public")
public interface ComicsClient {

    @GetMapping("/comics/{comicId}")
    public ResponseEntity<ComicResponse> getById(@PathVariable String comicId,
                                                 @RequestParam(value = "ts") Long timeStamp,
                                                 @RequestParam(value = "apikey") String publicKey,
                                                 @RequestParam(value = "hash") String hashMD5);
}
