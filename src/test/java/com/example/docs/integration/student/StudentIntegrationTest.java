package com.example.docs.integration.student;

import com.example.docs.integration.ApiDocBase;
import com.example.docs.student.domain.StudentResponse;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.example.docs.integration.TestUtil.asJsonString;
import static com.example.docs.integration.TestUtil.toJavaObject;
import static com.example.docs.integration.student.StudentTestInputData.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class StudentIntegrationTest extends ApiDocBase {

    private static String studentId = "";

    @Test
    void createStudent() throws Exception {

        MvcResult mvcResult = getMockMvc().perform(MockMvcRequestBuilders.post(getURI())
                .content(asJsonString(newStudentRequest()))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andReturn();
       setStudentId(toJavaObject(mvcResult.getResponse().getContentAsString(), StudentResponse.class).getStudentId());
    }

    @Test
    void readStudent() throws Exception {
        getMockMvc().perform(MockMvcRequestBuilders.get(getURI() + studentId)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void updateStudent() throws Exception {
        getMockMvc().perform(MockMvcRequestBuilders.put(getURI() + studentId)
                .content(asJsonString(updateStudentRequest()))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk());
    }

    private static void setStudentId(String studentId) {
        StudentIntegrationTest.studentId = studentId;
    }
}
