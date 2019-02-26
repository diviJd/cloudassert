package com.divya.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.divya.Pojo.Employee;
import com.divya.service.ServiceDaoImpl;

public class SelectAction {
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {

		ServiceDaoImpl dao = new ServiceDaoImpl();
		Employee emp = dao.displayEmpDetails();
		
		String result = (emp != null)? "success" : "failure";
		return mapping.findForward(result);
	}
}
