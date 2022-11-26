package com.applydigital.challenge.controller;

import com.applydigital.challenge.Util;
import com.applydigital.challenge.dto.StoryDTO;
import com.applydigital.challenge.repository.entity.StoryEntity;
import com.applydigital.challenge.service.HackNewsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@Validated
@RequestMapping("/api/v1/hacknews")
public class HackNewsController {

    private final HackNewsService hackNewsService;

    private final Util util;

    /**
     * list Stories By Author
     *
     * @return List<StoryDTO>
     */
    @GetMapping(value = "/byAuthor/{author}", params = { "page", "size" })
    public Page<StoryEntity> listStoriesByAuthor(@PathVariable("author") String author,
                                                 @RequestParam("page") int page,
                                                 @RequestParam("size")
                                                     @Min(value = 1, message = "min size: 1")
                                                     @Max(value = 5, message = "max size: 5")
                                                     int size){

        /**
         * @todo CHALLENGE
         * - OK fetch once an hour
         * - OK articles about Java on Hacker News
         * - OK insert the data from the API into a database
         * - OK a REST API
         * - OK filtered by author, _tags, title
         * - OK The whole project has to be uploaded to Gitlab
         * - OK searchable by month word (e.g. september) using the “created_at” field.

         * - paginated results with a maximum of 5 >>> @todo adds full stacktrace (npi)
         * - At least 30% test coverage (statements) for the server component

         * - allow the user to remove items
         * - JWT must be sent in the headers
         * - Dockerized
         * - docker-compose

         * ? Tests and linters should run on a GitLab pipeline (gitlab-ci.yml)
         * ? API Doc: Swagger, should be exposed at /api/docs
         * - README
         */

        log.info("GET /api/v1/hacknews/byAuthor/{} page: {}, size: {}", author, page, size);
        Page<StoryEntity> response = hackNewsService.listStoriesByAuthor(author, page, size);
        log.info("Response /api/v1/hacknews/byAuthor/{}: {}", author, util.objToJson(response));

        return response;
    }

    /**
     * list Stories By Title
     *
     * @return List<StoryDTO>
     */
    @GetMapping(value = "/byTitle/{title}", params = { "page", "size" })
    public Page<StoryEntity> listStoriesByTitle(@PathVariable("title") String title,
                                             @RequestParam("page") int page,
                                             @RequestParam("size")
                                                 @Min(value = 1, message = "min size: 1")
                                                 @Max(value = 5, message = "max size: 5")
                                                 int size){

        log.info("GET /api/v1/hacknews/byTitle/{} page: {}, size: {}", title, page, size);
        Page<StoryEntity> response = hackNewsService.listStoriesByTitle(title, page, size);
        log.info("Response /api/v1/hacknews/byTitle/{}: {}", title, util.objToJson(response));

        return response;
    }

    /**
     * list Stories By Tag
     *
     * @return List<StoryDTO>
     */
    @GetMapping(value = "/byTag/{tag}", params = { "page", "size" })
    public Page<StoryEntity> listStoriesByTag(@PathVariable("tag") String tag,
                                           @RequestParam("page") int page,
                                           @RequestParam("size")
                                               @Min(value = 1, message = "min size: 1")
                                               @Max(value = 5, message = "max size: 5")
                                               int size){

        log.info("GET /api/v1/hacknews/byTag/{} page: {}, size: {}", tag, page, size);
        Page<StoryEntity> response = hackNewsService.listStoriesByTag(tag, page, size);
        log.info("Response /api/v1/hacknews/byTag/{}: {}", tag, util.objToJson(response));

        return response;
    }

    @GetMapping(value = "/byMonth/{month}" ,params = { "page", "size" })
    public Page<StoryEntity> listStoriesByMonth(@PathVariable("month") String month,
                                              @RequestParam("page") int page,
                                              @RequestParam("size")
                                              @Min(value = 1, message = "min size: 1")
                                              @Max(value = 5, message = "max size: 5")
                                              int size){
        log.info("GET /api/v1/hacknews/byMonth/{} page: {}, size: {}", month, page, size);
        Page<StoryEntity> response = hackNewsService.listStoriesByMonth(month, page, size);
        log.info("Response /api/v1/hacknews/byMonth/{}: {}", month, util.objToJson(response));

        return response;

    }

    //@DeleteMapping(value = "/{id}")
}
