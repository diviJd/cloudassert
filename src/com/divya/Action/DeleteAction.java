package com.divya.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.divya.Pojo.Employee;
import com.divya.service.ServiceDaoImpl;

public class DeleteAction {
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {

		Employee emp = (Employee) form;
		String empID = emp.getEmpID();

		ServiceDaoImpl dao = new ServiceDaoImpl();
		String result = dao.deleteEmpDetails(empID);

		return mapping.findForward(result);
	}
}
