package com.chat.webservice.filter;

import com.chat.webservice.api.HttpHeader;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.is;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("classpath:controller-test-context.xml")
public class AuthenticationFilterTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

//    @Autowired
//    private AuthenticationFilter filter;

    private MockMvc mockMvc;

//    @Before
//    public void setUp() throws Exception {
//        mockMvc = webAppContextSetup(webApplicationContext).addFilter(filter).build();
//    }
//
//    @Test
//    public void testAuthIgnore() throws Exception {
//        mockMvc.perform(
//                get("/auth/login")
//                        .param("login", "login")
//                        .param("pass", "1234")
//        )
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(APPLICATION_JSON));
//    }
//
//    @Test
//    public void testAnotherPathWithToken() throws Exception {
//        mockMvc.perform(
//                get("/friend")
//                        .header(HttpHeader.TOKEN.getHeader(), "validToken")
//        )
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(APPLICATION_JSON));
//    }
//
//    @Test
//    public void testAnotherPathWithoutToken() throws Exception {
//        mockMvc.perform(
//                get("/friend")
//        )
//                .andExpect(status().isUnauthorized())
//                .andExpect(content().contentType(APPLICATION_JSON))
//                .andExpect(jsonPath("$.message", is(AuthenticationFilter.ERROR_UNAUTHORIZED)));
//    }
//
//    @Test
//    public void testAnotherPathWitIncorrectToken() throws Exception {
//        mockMvc.perform(
//                get("/friend")
//                        .header(HttpHeader.TOKEN.getHeader(), "incorrectToken")
//        )
//                .andExpect(status().isUnauthorized())
//                .andExpect(content().contentType(APPLICATION_JSON))
//                .andExpect(jsonPath("$.message", is(AuthenticationFilter.ERROR_UNAUTHORIZED)));
//    }

}