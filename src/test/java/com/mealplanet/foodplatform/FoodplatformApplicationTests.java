package com.mealplanet.foodplatform;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mealplanet.foodplatform.model.Order;
import com.mealplanet.foodplatform.model.OrderItem;
import com.mealplanet.foodplatform.service.OrderService;
import org.aspectj.weaver.ast.Or;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
@SpringBootTest
@AutoConfigureMockMvc
class FoodplatformApplicationTests {
	ObjectMapper mapper = new ObjectMapper();

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private OrderService orderService;

	@Test
	public void testGetOrderSummary() throws Exception {
		Order order = new Order();
		Mockito.when(orderService.getOrderSummary(1L,1L)).thenReturn(order);

		mockMvc.perform(MockMvcRequestBuilders.get("/order/summary?restaurantId=1&orderId=1"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.content().json(mapper.writeValueAsString(order)));
	}

}