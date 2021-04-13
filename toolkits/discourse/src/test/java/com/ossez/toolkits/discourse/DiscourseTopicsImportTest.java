package com.ossez.toolkits.discourse;

import com.google.gson.Gson;
import com.ossez.toolkits.discourse.common.model.entity.BBSOssezForumAttach;
import com.ossez.toolkits.discourse.common.model.entity.BBSOssezForumPost;
import com.ossez.toolkits.discourse.common.model.request.TopicRequest;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.joda.time.DateTime;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Test Logger and function
 *
 * @author YuCheng Hu
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DiscourseTopicsImportTest {
    private static Logger logger = LoggerFactory.getLogger(DiscourseTopicsImportTest.class);


    @BeforeAll
    protected void setUp() throws Exception {
    }

    @AfterAll
    protected void tearDown() throws Exception {
    }

    /**
     * Tests search functionality for the customer object.
     */
    @Test
    public void testPost() throws IOException, InterruptedException {
        List<String> idList = FileUtils.readLines(new File("C:\\Users\\yhu\\Pictures\\Pics\\2021-01\\1.txt"));
        for (String id : idList) {
            processPost(NumberUtils.toLong(id));
            Thread.sleep(6000);
//            break;

        }


        // make sure the customer was found
//        assertNotNull(bbsOssezForumPost);
    }

    @Test
    public void testDateTime() throws IOException {
        DateTime dateTime = new DateTime(1256834117 * 1000L);
        System.out.println(dateTime.toString());

    }

    private void processPost(Long tid) throws IOException {
        String postCtx = StringUtils.EMPTY;

//        BBSOssezForumPost bbsOssezForumPost = PostFactory.getBBSOssezForumPostTid(tid);
//        if (bbsOssezForumPost == null)
//            return;
//
//        logger.debug("Questions Content - {}", bbsOssezForumPost.getSubject());
//
//        String postCtx = bbsOssezForumPost.getMessage();
////        logger.debug(">>>>{}", postCtx);
//
//
//        String pattern = "\\[attach\\]((\\d)*?)\\[\\/attach\\]";
//
//        // Create a Pattern object
//        Pattern r = Pattern.compile(pattern);
//
//        // Now create matcher object.
//        Matcher m = r.matcher(postCtx);
//
//        while (m.find()) {
//            String attachId = StringUtils.substringBetween(m.group(0), "[attach]", "[/attach]");
//            logger.debug("{}", attachId);
//            BBSOssezForumAttach bbsOssezForumAttach = PostFactory.getBBSOssezForumAttach(NumberUtils.toLong(attachId));
//            if (bbsOssezForumAttach!= null) {
//                String fullURL = "![](https://cdn.ossez.com/com-ossez-www/data/attachment/forum/" + bbsOssezForumAttach.getAttachment() + ")";
//                postCtx = StringUtils.replace(postCtx, m.group(0), fullURL);
//            }
//        }

        logger.debug("{}", postCtx);


        CloseableHttpClient client = HttpClients.createDefault();

        HttpPost httpPost = new HttpPost("https://www.ossez.com/posts.json");
        httpPost.setHeader(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8");
        httpPost.setHeader("Api-Key", "8d789c529c4c22bf1dac3de7dbe7b29af10f2429aeb9a1914eff6da70c2265a9");
        httpPost.setHeader("Api-Username", "honeymoose");

        TopicRequest topicRequest = new TopicRequest();
        topicRequest.setTitle(bbsOssezForumPost.getSubject());
        topicRequest.setRaw(postCtx);
        topicRequest.setCreated_at(new DateTime(bbsOssezForumPost.getDateline() * 1000L).toString() );
        topicRequest.setCategory(30);

        StringEntity postingString = new StringEntity(new Gson().toJson(topicRequest),  StandardCharsets.UTF_8);

        httpPost.setEntity(postingString);


        CloseableHttpResponse response = client.execute(httpPost);

        logger.info("{}", EntityUtils.toString(response.getEntity()), StandardCharsets.UTF_8);
        client.close();
    }

}
