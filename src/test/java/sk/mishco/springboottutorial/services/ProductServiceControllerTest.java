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
    private ProductServiceImpl productService;
    private ProductDTO productDTO;

    private ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setupBeforeTest() {
        productRepository.deleteAll();
        productDTO = new ProductDTO();
        productDTO.setId(10L);
        productDTO.setName("testObject");
        productService = new ProductServiceImpl(productRepository);
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
        String resStr = "Product is created successfully";
        MvcResult result = this.mockMvc.perform(
                post("/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonStr)
        )
                .andDo(print())
                .andExpect(status().is2xxSuccessful()).andReturn();

        assertEquals(resStr, result.getResponse().getContentAsString());
    }


    @Test
    void deleteProductTest() throws Exception {
        long id = 10L;
        String resStr = "Product is deleted successfully";
        productService.put(productDTO);

        MvcResult result = this.mockMvc.perform(
                delete("/products/" + id))
                .andDo(print())
                .andExpect(status().is2xxSuccessful()).andReturn();

        assertEquals(resStr, result.getResponse().getContentAsString());
    }

    @Test
    void updateProductTest() throws Exception {
        long id = 10L;
        String resStr = "Product is updated successfully";
        productService.put(productDTO);

        String jsonStr = objectMapper.writeValueAsString(productDTO);

        MvcResult result = this.mockMvc.perform(
                put("/products/" + id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonStr)
        )
                .andDo(print())
                .andExpect(status().is2xxSuccessful()).andReturn();
        assertEquals(resStr, result.getResponse().getContentAsString());

    }
}