package com.omnilink.veiculosclientesapi.controllers;

import com.omnilink.veiculosclientesapi.domain.cliente.Cliente;
import com.omnilink.veiculosclientesapi.services.ClienteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ClienteController.class)
@WithMockUser(username = "admin", roles = {"USER"})  // Adicione esta linha para simular um usuário autenticado
public class ClienteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClienteService clienteService;

    @Test
    public void shouldReturnAllClientes() throws Exception {
        Cliente cliente1 = new Cliente("12345678901", "Cliente 1", "cliente1@example.com", "1234567890", null);
        Cliente cliente2 = new Cliente("09876543210", "Cliente 2", "cliente2@example.com", "0987654321", null);

        when(clienteService.findAll()).thenReturn(Arrays.asList(cliente1, cliente2));

        mockMvc.perform(get("/clientes")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"cpf\":\"12345678901\",\"nome\":\"Cliente 1\"},{\"cpf\":\"09876543210\",\"nome\":\"Cliente 2\"}]"));
    }
}
