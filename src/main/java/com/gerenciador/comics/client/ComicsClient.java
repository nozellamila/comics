package com.gerenciador.comics.client;

import com.gerenciador.comics.resources.response.ComicIdResponse;
import com.gerenciador.comics.resources.response.ComicsResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "marvel", url = "${url.marvel}/v1/public")
public interface ComicsClient {
    @GetMapping("/comics")
    public ComicsResponse getAll(@RequestParam(value = "ts") Long timeStamp,
                                 @RequestParam(value = "apikey") String publicKey, @RequestParam(value = "hash") String hashMD5);
    @GetMapping("/comics/{comicId}")
    public ComicIdResponse getById(@PathVariable String comicId, @RequestParam(value = "ts") Long timeStamp,
                                   @RequestParam(value = "apikey") String publicKey, @RequestParam(value = "hash") String hashMD5);

}