package com.applydigital.challenge.controller;

import com.applydigital.challenge.util.Util;
import com.applydigital.challenge.entity.StoryEntity;
import com.applydigital.challenge.service.HackNewsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

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
    @GetMapping(params = { "author", "page", "size" })
    public Page<StoryEntity> listStoriesByAuthor(@RequestParam("author") String author,
                                                 @RequestParam("page") int page,
                                                 @RequestParam("size")
                                                     @Min(value = 0, message = "min size = 0")
                                                     @Max(value = 5, message = "max size = 5") int size){

        /**
         * @todo CHALLENGE
         * - OK fetch once an hour
         * - OK articles about Java on Hacker News
         * - OK insert the data from the API into a database
         * - OK a REST API
         * - OK filtered by author, _tags, title
         * - OK The whole project has to be uploaded to Gitlab
         * - OK searchable by month word (e.g. september) using the “created_at” field.
         * - OK paginated results with a maximum of 5 >>> @todo adds full stacktrace on error (npi)
         * - OK At least 30% test coverage (statements) for the server component
         * - OK allow the user to remove items
         * - OK JWT must be sent in the headers

         * - Dockerized

         * - docker-compose

         * ? Tests and linters should run on a GitLab pipeline (gitlab-ci.yml)
         * ? API Doc: Swagger, should be exposed at /api/docs
         * - README
         */

        log.info("GET /api/v1/hacknews?author:{} page: {}, size: {}", author, page, size);
        Page<StoryEntity> response = hackNewsService.listStoriesByAuthor(author, page, size);
        log.info("Response /api/v1/hacknews?author:{}: {}", author, util.objToJson(response));

        return response;
    }

    /**
     * list Stories By Title
     *
     * @return List<StoryDTO>
     */
    @GetMapping(params = { "title", "page", "size" })
    public Page<StoryEntity> listStoriesByTitle(@RequestParam("title") String title,
                                                @RequestParam("page") int page,
                                                @RequestParam("size")
                                                    @Min(value = 0, message = "min size = 0")
                                                    @Max(value = 5, message = "max size = 5") int size){

        log.info("GET /api/v1/hacknews?title:{} page: {}, size: {}", title, page, size);
        Page<StoryEntity> response = hackNewsService.listStoriesByTitle(title, page, size);
        log.info("Response /api/v1/hacknews?title:{}: {}", title, util.objToJson(response));

        return response;
    }

    /**
     * list Stories By Tag
     *
     * @return List<StoryDTO>
     */
    @GetMapping(params = { "tag", "page", "size" })
    public Page<StoryEntity> listStoriesByTag(@RequestParam("tag") String tag,
                                              @RequestParam("page") int page,
                                              @RequestParam("size")
                                                  @Min(value = 0, message = "min size = 0")
                                                  @Max(value = 5, message = "max size = 5") int size){

        log.info("GET /api/v1/hacknews?tag:{} page: {}, size: {}", tag, page, size);
        Page<StoryEntity> response = hackNewsService.listStoriesByTag(tag, page, size);
        log.info("Response /api/v1/hacknews?tag:{}: {}", tag, util.objToJson(response));

        return response;
    }

    @GetMapping(params = { "month", "page", "size" })
    public Page<StoryEntity> listStoriesByMonth(@RequestParam("month") String month,
                                                @RequestParam("page") int page,
                                                @RequestParam("size")
                                                    @Min(value = 0, message = "min size = 0")
                                                    @Max(value = 5, message = "max size = 5") int size){
        log.info("GET /api/v1/hacknews?month:{} page: {}, size: {}", month, page, size);
        Page<StoryEntity> response = hackNewsService.listStoriesByMonth(month, page, size);
        log.info("Response /api/v1/hacknews?month:{}: {}", month, util.objToJson(response));

        return response;

    }

    @DeleteMapping(value = "/{id}")
    public StoryEntity deleteStory(@PathVariable("id") Long id){
        log.info("DELETE /api/v1/hacknews/{}", id);
        StoryEntity story = hackNewsService.remove(id);
        log.info("Response /api/v1/hacknews/{}", util.objToJson(story));

        return story;
    }
}
