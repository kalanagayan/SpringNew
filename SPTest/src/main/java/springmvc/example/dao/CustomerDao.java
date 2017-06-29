package springmvc.example.dao;

import java.util.List;

import springmvc.example.model.Customer;

public interface CustomerDao {

	public List<Customer> listAllCUstomers();
	
	public void addCustomer(Customer customer);
	
	public void deleteCustomer(int id);
	
	public void updateCustomer(Customer customer);
	
	public Customer findCustomerById(int id);
	
}
