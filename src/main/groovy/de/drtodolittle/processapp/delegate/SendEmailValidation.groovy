package de.drtodolittle.processapp.delegate

import org.camunda.bpm.engine.delegate.JavaDelegate
import org.camunda.bpm.engine.delegate.DelegateExecution

public class SendEmailValidation implements JavaDelegate {

    public void execute(DelegateExecution execution) throws Exception {
      String email = (String) execution.getVariable("email")
      String firstname = (String) execution.getVariable("firstname")
      String lastname = (String) execution.getVariable("lastname")
      String processId = execution.getProcessInstanceId()
	  
	  String export = "$email;$processId;$firstname;$lastname"
	  new File("/var/drtodolittle/emailvalidation/$processId").write(export)
    }

}