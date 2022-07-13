/**
 * 
 */
package StepDefinition;

import java.io.IOException;
import java.io.InputStream;

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
		Runtime runtime = Runtime.getRuntime();
		try {
		    Process p1 = runtime.exec("cmd /c start ..\\bin\\oid.bat");
		    InputStream is = p1.getInputStream();
		    int i = 0;
		    while( (i = is.read() ) != -1) {
		        System.out.print((char)i);
		    }
		} catch(IOException ioException) {
		    System.out.println(ioException.getMessage() );
		}	}

	@When("I input an invalid SNMP trap {string}")
	public void i_input_an_invalid_snmp_trap(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("I verify the trap is correctly flagged as invalid")
	public void i_verify_the_trap_is_correctly_flagged_as_invalid() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("I verify the trap is a successor of any prefix to be result true")
	public void i_verify_the_trap_is_a_successor_of_any_prefix_to_be_result_true() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

}
