package springmvc.example.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springmvc.example.model.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao{

	NamedParameterJdbcTemplate namedparameterjdbctemplet;
	
	@Autowired

	public void setNamedparameterjdbctemplet(NamedParameterJdbcTemplate namedparameterjdbctemplet) {
		this.namedparameterjdbctemplet = namedparameterjdbctemplet;
	}

	
	public List<Customer> listAllCUstomers() {
		String sql = "select id,firstname,lastname,gender,address from customer";
		List<Customer> list = namedparameterjdbctemplet.
		
		return null;
	}

	public void addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
	}

	public void deleteCustomer(int id) {
		// TODO Auto-generated method stub
		
	}

	public void updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
	}

	public void findCustomerById(int id) {
		// TODO Auto-generated method stub
		
	}

	
	
}
