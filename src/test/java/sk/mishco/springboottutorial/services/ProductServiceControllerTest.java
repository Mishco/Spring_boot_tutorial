package sk.mishco.springboottutorial.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import sk.mishco.springboottutorial.ProductRepository;
import sk.mishco.springboottutorial.model.ProductDTO;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ProductServiceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ProductRepository productRepository;
    private ProductService productService;
    private ProductDTO productDTO;

    private ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setupBeforeTest() {
        productRepository.deleteAll();
        productDTO = new ProductDTO();
        productDTO.setId(10L);
        productDTO.setName("testObject");
        productService = new ProductService(productRepository);
    }

    @Test
    void getProducts() throws Exception {
        this.mockMvc.perform(
                get("/products"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(productService.getProducts().toString()));
    }


    @Test
    void createProductTest() throws Exception {


        String jsonStr = objectMapper.writeValueAsString(productDTO);

        MvcResult result = this.mockMvc.perform(
                post("/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonStr)
        )
                .andDo(print())
                .andExpect(status().is2xxSuccessful()).andReturn();

        assertEquals(result.getResponse().getContentAsString(), "Product is created successfully");
    }


    @Test
    void deleteProductTest() throws Exception {
        long id = 10L;
        productService.put(productDTO);

        MvcResult result = this.mockMvc.perform(
                delete("/products/" + id))
                .andDo(print())
                .andExpect(status().is2xxSuccessful()).andReturn();

        assertEquals(result.getResponse().getContentAsString(), "Product is deleted successfully");
    }

    @Test
    void updateProductTest() throws Exception {
        long id = 10L;
        productService.put(productDTO);

        String jsonStr = objectMapper.writeValueAsString(productDTO);

        MvcResult result = this.mockMvc.perform(
                put("/products/" + id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonStr)
        )
                .andDo(print())
                .andExpect(status().is2xxSuccessful()).andReturn();
        assertEquals(result.getResponse().getContentAsString(), "Product is updated successfully");

    }
}