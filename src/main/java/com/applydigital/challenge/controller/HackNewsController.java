package com.applydigital.challenge.controller;

import com.applydigital.challenge.Util;
import com.applydigital.challenge.dto.StoryDTO;
import com.applydigital.challenge.service.HackNewsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/hacknews")
public class HackNewsController {

    private final HackNewsService hackNewsService;

    private final Util util;

    @GetMapping(value = "/byAuthor/{author}", params = { "page", "size" })
    public List<StoryDTO> listStoriesByAuthor(@PathVariable("author") String author,
                                              @RequestParam("page") int page,
                                              @RequestParam("size") int size){

        log.info("GET /api/v1/hacknews/byAuthor/{} page: {}, size: {}", author, page, size);
        List<StoryDTO> response = hackNewsService.listStoriesByAuthor(author);
        log.info("Response /api/v1/hacknews/byAuthor/{}: {}", author, util.objectToJson(response));

        return response;
    }

/*


    public ResponseEntity<List<StoryDTO>> listStoriesByAuthor(@PathVariable("author") String author,
                                                              @RequestParam("page") int page,
                                                              @RequestParam("size") int size){



    }

    //@GetMapping(value = "/byTag/{tag}" ,params = { "page", "size" })
    //@GetMapping(value = "/byTitle/{title}" ,params = { "page", "size" })
    //@GetMapping(value = "/byMonth/{month}" ,params = { "page", "size" })
    //@DeleteMapping(value = "/{id}")
 */


}
