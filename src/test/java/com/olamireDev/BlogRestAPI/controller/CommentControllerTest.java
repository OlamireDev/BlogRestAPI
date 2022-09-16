package com.olamireDev.BlogRestAPI.controller;

import com.olamireDev.BlogRestAPI.model.Comment;
import com.olamireDev.BlogRestAPI.service.CommentService;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Date;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
class CommentControllerTest {
    MockMvc mockMvc;

    @Mock
    CommentService commentService;

    @InjectMocks
    CommentController commentController;
    @Before
    void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(commentController).build();
    }

    @Test
    void getPostComments() {
    }

    @Test
    void getComment() throws Exception {
        when(commentService.getComment(1L)).thenReturn(new Comment(1l, "I love your designs cant wait to see more", "Obi Wan Kenobi"));
        mockMvc.perform(get("/comment/1")).andExpect(status().is2xxSuccessful()).
                andExpect(jsonPath("$.content", Matchers.is("I love your designs cant wait to see more"))).
                andExpect(jsonPath("$.content", Matchers.is("Obi Wan Kenobi")));
    }

    @Test
    void editComment() {
    }

    @Test
    void deleteComment() {
    }

    @Test
    void newComment() {
    }

    @Test
    void searchComments() {
    }
}