//package com.internetbanking.edu.internetbankingedu.controller;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
//import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestInstance;
//import org.junit.jupiter.api.TestInstance.Lifecycle;
//import org.junit.jupiter.api.TestMethodOrder;
//import org.mockito.BDDMockito;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.boot.test.mock.mockito.MockitoTestExecutionListener;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.TestExecutionListeners;
//import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.internetbanking.edu.internetbankingedu.dto.model.user.UserDTO;
//import com.internetbanking.edu.internetbankingedu.enums.RoleEnum;
//import com.internetbanking.edu.internetbankingedu.model.User;
//import com.internetbanking.edu.internetbankingedu.model.service.UserService;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//@ActiveProfiles("dev")
//@TestInstance(Lifecycle.PER_CLASS)
//@TestMethodOrder(OrderAnnotation.class)
//@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, MockitoTestExecutionListener.class })
//public class UserControllerTest {
//
//	static final String URL = "api/usuarios";
//	static final Long id = 1L;
//	static final String nome = "Edu";
//	static final String senha = "123";
//	static final String cpf = "172.760.150-50";
//	
//	HttpHeaders headers;
//
//	@Autowired
//	MockMvc mockMvc;
//	
//	@MockBean
//	UserService userService;
//	
//	@BeforeAll
//	private void setUp() {
//		headers = new HttpHeaders();
//        headers.set("X-api-key", "FX001-ZBSY6YSLP");
//	}
//	
//	@Test
//	@Order(1)
//	public void testSave() throws Exception {
//		
//		BDDMockito.given(userService.save(Mockito.any(User.class))).willReturn( returnMockUser( ) );
//		
//		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
//		Date data = formatter.parse( "28/02/1993" );
//		int conta = 0;
//		mockMvc.perform(MockMvcRequestBuilders.post(URL).content( getJsonPayload( nome, cpf, data, senha, RoleEnum.ROLE_ADMIN) )
//			.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
//			.headers(headers))
//		.andDo(MockMvcResultHandlers.print())
//		.andExpect(status().isCreated())
////		.andExpect(jsonPath("$.data.id").value( id))
//		.andExpect(jsonPath("$.data.nome").value( nome))
//		.andExpect(jsonPath("$.data.cpf").value( cpf ))
//		.andExpect(jsonPath("$.data.dataNascimento").value( data ))
//		.andExpect(jsonPath("$.data.senha").value( senha ))
//		.andExpect(jsonPath("$.data.role").value(RoleEnum.ROLE_ADMIN.getValue()));
////		.andExpect(jsonPath("$.data.account").value(conta));
//		
//	}
//	
//	private User returnMockUser( ) throws ParseException
//	{
//		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
//		Date data = formatter.parse( "28/02/1993" );
//		return new User( null, nome, cpf, data, "123", RoleEnum.ROLE_USER, 1234567 );
//	}
//	
////	private String getJsonPayload( String name, String cpf, Date dataNasc, String senha, RoleEnum role ) 
//	private String getJsonPayload( User dto ) 
//			throws JsonProcessingException {
////		UserDTO dto = new UserDTO( name, cpf, dataNasc, senha, role.getValue() );
//		return new ObjectMapper().writeValueAsString( dto );
//	}
//	
//}