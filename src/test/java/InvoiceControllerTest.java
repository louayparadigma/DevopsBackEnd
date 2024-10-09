import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import tn.esprit.devops_project.controllers.InvoiceController;
import tn.esprit.devops_project.entities.Invoice;

import static org.mockito.Mockito.when;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)

public class InvoiceControllerTest {

    private MockMvc mockMvc;
    @InjectMocks
    private InvoiceController invoiceService;

    @Mock
    private Invoice invoice;
/*
      @Test
      public void TestGetInvoicesBySupplier() throws Exception {

          Invoice newInvoice = new Invoice();
          newInvoice.setIdInvoice(2L);  // Assuming ID is 2
          newInvoice.setAmount(1000.0);
          newInvoice.setSupplierId(1L);

          // Convert the Invoice object to JSON string
          ObjectMapper objectMapper = new ObjectMapper();
          String invoiceJson = objectMapper.writeValueAsString(newInvoice);

          // Mock the service to add an invoice
          when(invoiceService.addInvoice(newInvoice)).thenReturn(newInvoice);

          // 1. Add Invoice (POST)
          mockMvc.perform(post("/invoice")
                          .contentType(MediaType.APPLICATION_JSON)
                          .content(invoiceJson))
                  .andExpect(status().isCreated());

          // 2. Verify the Invoice is Added (GET)
          when(invoiceService.getInvoiceById(2L)).thenReturn(newInvoice);
          mockMvc.perform(get("/invoice/2"))
                  .andExpect(status().isOk())
                  .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                  .andExpect(jsonPath("$.idInvoice").value(2L))
                  .andExpect(jsonPath("$.amount").value(1000.0))
                  .andExpect(jsonPath("$.supplierId").value(1L));

          // 3. Delete Invoice (DELETE)
          mockMvc.perform(delete("/invoice/2"))
                  .andExpect(status().isNoContent());

          // 4. Verify the Invoice is Deleted (GET should return 404)
          when(invoiceService.getInvoiceById(2L)).thenReturn(null);
          mockMvc.perform(get("/invoice/2"))
                  .andExpect(status().isNotFound());
          }

      }
*/
  }