package de.drtodolittle.processapp.delegate

import org.camunda.bpm.engine.delegate.JavaDelegate
import org.camunda.bpm.engine.delegate.DelegateExecution
import org.camunda.bpm.engine.IdentityService

public class CreateUser implements JavaDelegate {

    public void execute(DelegateExecution execution) throws Exception {
      String email = (String) execution.getVariable("email")
      String firstname = (String) execution.getVariable("firstname")
      String lastname = (String) execution.getVariable("lastname")
      String password = (String) execution.getVariable("password")
	  
	  IdentityService identityService = execution.getProcessEngineServices().getIdentityService()
	  def newUser = identityService.newUser(email)
	  newUser.setEmail(email)
	  newUser.setFirstName(firstname)
	  newUser.setLastName(lastname)
	  newUser.setPassword(password)
	  identityService.saveUser(newUser)
	  
	  identityService.createMembership(email, "drtodolittle-user")
    }

}