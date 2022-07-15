/**
 * 
 */
package StepDefinition;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * @author hermanx
 *
 */
public class oidsSteps {
	@Given("I have a list of prefixes for which to filter in the snmp file")
	public void i_have_a_list_of_prefixes_for_which_to_filter_in_the_snmp_file() {
	}

	@When("I input an invalid SNMP {string}")
	public void i_input_an_invalid_snmp(String trap) {
		Runtime runtime = Runtime.getRuntime();
		
		try {
		    Process p1 = runtime.exec("cmd /c start ..\\bin\\oid.bat < ");
		    
		    InputStream is = p1.getInputStream();
		    int i = 0;
		    while( (i = is.read() ) != -1) {
		        System.out.print((char)i);
		    }
		} catch(IOException ioException) {
		    System.out.println(ioException.getMessage() );
		}	
	}

	@Then("I verify the trap is correctly flagged as invalid")
    // Write code here that parse the CLI output looking for word "invalid"

	public void i_verify_the_trap_is_correctly_flagged_as_invalid() {
	}

	@Then("I verify the trap is a successor of any prefix to be {string}")
	public void i_verify_the_trap_is_a_successor_of_any_prefix_to_be(String result) {
	}
	
	@When("I input a SNMP {string} to the CLI utility")
	public void i_input_a_snmp_to_the_cli_utility(String string) {
	    // Write code here that input trap to the CLI utility
	}

	@Then("I verify the trap is a successor of any prefix to be true")
	public void i_verify_the_trap_is_a_successor_of_any_prefix_to_be_true() {
	    // Write code here that parse the CLI output looking for word "true"
	}

	@Then("I verify the trap is a successor of any prefix to be false")
	public void i_verify_the_trap_is_a_successor_of_any_prefix_to_be_false() {
	    // Write code here that parse the CLI output looking for word "false"
	}

}
