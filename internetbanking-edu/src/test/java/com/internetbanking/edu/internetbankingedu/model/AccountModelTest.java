//package com.internetbanking.edu.internetbankingedu.model;
//
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//import java.math.BigDecimal;
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
//import com.internetbanking.edu.internetbankingedu.repository.AccountRepository;
//
//@SpringBootTest
//@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class })
//@ActiveProfiles( "dev" )
//@TestInstance(Lifecycle.PER_CLASS)
//public class AccountModelTest {
//	static final String conta = "1727601";
//	
//	@Autowired
//	AccountRepository repository;
//	
//	@Test
//	public void testSave() throws Exception {
//		Account response = repository.save( returnMockAccount( ) );
//		
//		assertNotNull(response);
//	}
//	
//	@Test
//	public void findByAccountNumber(){
//		Optional<Account> response = repository.findByAccountNumber( conta );
//		
//		assertTrue(response.isPresent());
//	}
//
//	@AfterAll
//	private void tearDown() {
//		repository.deleteAll();
//	}
//	
//	private Account returnMockAccount( ) throws ParseException
//	{
//		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
//		Date data = formatter.parse( "28/02/1993" );
//		return new Account( null, conta, new BigDecimal( "1400" ), false );
//	}
//
//}
