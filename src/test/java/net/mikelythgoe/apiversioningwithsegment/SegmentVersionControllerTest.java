package net.mikelythgoe.apiversioningwithsegment;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SegmentVersionController.class)
public class SegmentVersionControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @Test
    void helloV1_ShouldReturnVersion1() throws Exception {
        mockMvc.perform(get("/hello/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Hello Version 1"));
    }

    @Test
    void helloV2_ShouldReturnVersion2() throws Exception {
        mockMvc.perform(get("/hello/2")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Hello Version 2"));
    }

    @Test
    void helloV3point5_ShouldReturnVersion3point5() throws Exception {
        mockMvc.perform(get("/hello/3.5")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Hello Version 3.5"));
    }

    @Test
    void helloV9_ShouldReturnVersion9() throws Exception {
        mockMvc.perform(get("/hello/9")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Hello Version 9"));
    }

    @Test
    void helloV9point9_ShouldReturnVersion9point9() throws Exception {
        mockMvc.perform(get("/hello/9.9")
                        .accept(MediaType.APPLICATION_JSON ))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Hello Version 9.9"));
    }

    @Test
    void hello_WithoutQueryParameter_ShouldReturnDefaultResponse() throws Exception {
        // Config has been defined as requiring a version.
        // So not having a version should return a bad request
        mockMvc.perform(get("/hello")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void hello_WithInvalidVersion_ShouldReturnBadRequest() throws Exception {
        // Invalid Version should return the default response,
        // unless we have set "Version Required" in the config.
        // So this should return the DEFAULT response
        mockMvc.perform(get("/hello?version=99999")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
        ;
    }
}
