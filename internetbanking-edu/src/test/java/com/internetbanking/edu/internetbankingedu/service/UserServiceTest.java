//package com.internetbanking.edu.internetbankingedu.service;
//
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.Optional;
//
//import org.junit.jupiter.api.AfterAll;
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
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.TestExecutionListeners;
//import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
//
//import com.internetbanking.edu.internetbankingedu.enums.RoleEnum;
//import com.internetbanking.edu.internetbankingedu.model.User;
//import com.internetbanking.edu.internetbankingedu.model.service.UserService;
//import com.internetbanking.edu.internetbankingedu.repository.UserRepository;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//@ActiveProfiles("dev")
//@TestInstance( Lifecycle.PER_CLASS )
//@TestMethodOrder( OrderAnnotation.class )
//@TestExecutionListeners( { DependencyInjectionTestExecutionListener.class, MockitoTestExecutionListener.class } )
//public class UserServiceTest 
//{
//	@Autowired
//	private UserService service;
//
//	@MockBean
//	private UserRepository repository;
//	
//	static final String cpf = "172.760.150-50";
//	
//	@Test
//	@Order(1)
//	public void testSave() throws Exception {
//		
//		BDDMockito.given(repository.save(Mockito.any(User.class)))
//						.willReturn( returnMockUser( ) );
//		User response = service.save(new User());
//		
//		assertNotNull(response);
//	}
//	
//	@Test
//	@Order(2)
//	public void testFindByCpf(){
//		
//		BDDMockito.given(repository.findByCpf(Mockito.anyString()))
//			.willReturn(Optional.ofNullable(new User()));
//
//		Optional<User> response = service.findByCpf(cpf);
//		assertTrue(!response.isEmpty());
//	}
//	
//	private User returnMockUser( ) throws ParseException
//	{
//		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
//		Date data = formatter.parse( "28/02/1993" );
//		return new User( null, "Edu", cpf, data, "123", RoleEnum.ROLE_USER, 1234567 );
//	}
//	
//	@AfterAll
//	private void tearDown() {
//		repository.deleteAll();
//	}
//}