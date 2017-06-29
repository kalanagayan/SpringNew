package springmvc.example.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
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
		List<Customer> list = namedparameterjdbctemplet.query(sql,getSqlParameterByModel(null),new Customermapper());
		return list;
	}

	public void addCustomer(Customer customer) {
		String sql = "insert into customer(firstname,lastname,gender,address) values (:firstname, :lastname, :gender, :address)";
		namedparameterjdbctemplet.update(sql,getSqlParameterByModel(customer));
	}

	public void deleteCustomer(int id) {
		String sql = "delete from customer where id=:id";
		namedparameterjdbctemplet.update(sql,getSqlParameterByModel(id));
				
	}

	public void updateCustomer(Customer customer) {
		String sql = "update customer set firstname = :firstname,lastname = :lastname,gender = :gender,address = :address";
		namedparameterjdbctemplet.update(sql,getSqlParameterByModel(customer));
	}

	public Customer findCustomerById(int id) {
		String sql = "select * from customer where id = :id";
		Customer customer = namedparameterjdbctemplet.queryForObject(sql,getSqlParameterByModel(id),new Customermapper());
		return customer;
	}

	private SqlParameterSource getSqlParameterByModel(int id){
		MapSqlParameterSource paramtersource = new MapSqlParameterSource();
		paramtersource.addValue("id", id);
		return paramtersource;
	}
	
	private SqlParameterSource getSqlParameterByModel(Customer customer){
		MapSqlParameterSource paramtersource = new MapSqlParameterSource();
		if(customer != null){
			paramtersource.addValue("firstname",customer.getFirstname());
			paramtersource.addValue("lastname", customer.getLastname());
			paramtersource.addValue("gender",customer.getGender());
			paramtersource.addValue("address",customer.getAddress());
		}
		return paramtersource;
	}
	
	private static final class Customermapper implements RowMapper<Customer>{	
		public Customer mapRow(ResultSet rs,int rownum) throws SQLException{
			Customer customer = new Customer();
			customer.setId(rs.getInt("id"));
			customer.setFirstname(rs.getString("firstname"));
			customer.setLastname(rs.getString("lastname"));
			customer.setGender(rs.getString("gender"));
			customer.setAddress(rs.getString("address"));
			return customer;
		}
	}
		
	
	
	
}
