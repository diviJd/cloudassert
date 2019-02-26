package com.divya.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.divya.Pojo.Employee;
import com.divya.Pojo.User;
import com.divya.service.ServiceDao;
import com.divya.service.ServiceDaoImpl;

public class InsertAction extends Action {
	
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
				
		Employee emp = (Employee) form;
		String empID = emp.getEmpID();
		String empName = emp.getEmpName();
		String empType = emp.getEmpType();
		String deptName = emp.getDeptName();
		
		ServiceDaoImpl dao = new ServiceDaoImpl();
		String result = dao.insertEmpDetails(empID, empName, empType, deptName);
		
		return mapping.findForward(result);
	}
}
