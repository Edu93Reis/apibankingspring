//package com.internetbanking.edu.internetbankingedu.model;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.Optional;
//
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestInstance;
//import org.junit.jupiter.api.TestInstance.Lifecycle;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.TestExecutionListeners;
//import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
//
//import com.internetbanking.edu.internetbankingedu.enums.RoleEnum;
//import com.internetbanking.edu.internetbankingedu.repository.UserRepository;
//
//@SpringBootTest
//@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class })
//@ActiveProfiles( "dev" )
//@TestInstance(Lifecycle.PER_CLASS)
//public class UserModelTest 
//{
//	
//	static final String cpf = "172.760.150-50";
//	static final Long id = 1L;
//	
//	@Autowired
//	UserRepository repository;
//	
//	@Test
//	public void testSave() throws Exception {
//		User response = repository.save( returnMockUser( ) );
//		
//		assertNotNull(response);
//	}
//	
//	@Test
//	public void testFindByCpf(){
//		Optional<User> response = repository.findByCpf(cpf);
//		
//		assertTrue(response.isPresent());
//		assertEquals(cpf, response.get().getCpf());
//	}
//
//	@Test
//	public void testFindById(){
//		Optional<User> response = repository.findById( id );
//		
//		assertTrue(response.isPresent());
//	}
//
//	@Test
//	public void existsByCPF(){
//		boolean response = repository.existsByCpf( cpf );
//		
//		assertTrue( response == true );
//	}
//	
//	@AfterAll
//	private void tearDown() {
//		repository.deleteAll();
//	}
//	
//	private User returnMockUser( ) throws ParseException
//	{
//		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
//		Date data = formatter.parse( "28/02/1993" );
//		return new User( null, "Edu", cpf, data, "123", RoleEnum.ROLE_USER, 1234567 );
//	}
//	
//}
