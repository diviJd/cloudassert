package com.divya.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.divya.Pojo.Employee;
import com.divya.service.ServiceDaoImpl;

public class UpdateAction {
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {

		Employee emp = (Employee) form;
		String empID = emp.getEmpID();
		String empType = emp.getEmpType();
		String deptName = emp.getDeptName();

		ServiceDaoImpl dao = new ServiceDaoImpl();
		String result = dao.updateEmpDetails(empID, empType, deptName);

		return mapping.findForward(result);
	}
}
