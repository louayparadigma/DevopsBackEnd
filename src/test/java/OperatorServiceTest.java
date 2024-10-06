import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import tn.esprit.devops_project.controllers.OperatorController;
import tn.esprit.devops_project.entities.Operator;
import tn.esprit.devops_project.services.OperatorServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify; // Add this for verification
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete; // Add for delete request
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(OperatorController.class)
public class OperatorServiceTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private OperatorServiceImpl operatorService;

    @InjectMocks
    private OperatorController operatorController;

    @Autowired
    private ObjectMapper objectMapper;

    private Operator operator;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        operator = new Operator(1L, "John", "Doe", "password123", null);
    }

    @Test
    public void createModifyAndDeleteOperatorTest() throws Exception {
        when(operatorService.addOperator(operator)).thenReturn(operator);

        mockMvc.perform(post("/operator")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(operator)))
                .andExpect(status().isOk());

        operator.setFname("Jane");

        when(operatorService.updateOperator(operator)).thenReturn(operator);

        mockMvc.perform(put("/operator")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(operator)))
                .andExpect(status().isOk());

        mockMvc.perform(delete("/operator/{operatorId}", operator.getIdOperator()))
                .andExpect(status().isOk());

        verify(operatorService).deleteOperator(operator.getIdOperator());
    }
}
