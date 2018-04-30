package hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Controller
public class GreetingController {

	@Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    private void postConstruct() {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        String sql = "insert into aakashrathore.people values (?)";
        jdbcTemplate.update(sql, name);
	
	
        return "greeting";
    }


    @GetMapping("/newstudent")
    public String newStudent(@RequestParam(name = "student", required=false, defaultValue="Burgers") String student, Model model)
    {
	model.addAttribute("student", student);

	return "student";
    }	


    @GetMapping("/newstaff")
    public String newStaff(@RequestParam(name = "staffMember", required=false, defaultValue="Burgers") String staffMember, Model model)
    {
	model.addAttribute("staffMember", staffMember);

	return "staffMember";
    }	

    @GetMapping("/newlease")
    public String newLease(@RequestParam(name = "lease", required=false, defaultValue="Burgers") String lease, Model model)
    {
	model.addAttribute("lease", lease);

	return "newlease";
    }	

    // Used for testing purposes, feel free to mess it up
    @GetMapping("/dummy")
    public String myGreeting(@RequestParam(name = "sammy", required=false, defaultValue="Burgers") String sammy, Model model)
    {
	model.addAttribute("sammy", sammy);
	
	return "dummy";
    }
    
    @GetMapping("/query1")
    public String query1(Model model)
    {
	
	String sql = "SELECT * from aakashrathore.people";
	List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
	
	int itr = 100;
	for (Map row : rows){

		System.out.println(row.get("NAME"));
		model.addAttribute("name" + itr, row.get("NAME"));		
		itr++;
	}
        return "query1";
    } 
}


