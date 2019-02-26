package com.divya.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.divya.Pojo.Employee;

public class ServiceDaoImpl implements ServiceDao {
	static Connection connection = null;

	// get db connection object and return. if already created will return existing
	// object.
	private Connection getDBConnection() {
		try {
			if (connection == null) {
				connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cloudassert", "postgres",
						"postgres");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	// all 3 methods used getDBConnection method and do operations on tables.s
	@Override
	public String insertEmpDetails(String empId, String empName, String empType, String deptName) {
		String SQL = "INSERT INTO public.Employees VALUES(?,?,?,?)";

		long id = 0;
		try {
			PreparedStatement pstmt = getDBConnection().prepareStatement(SQL);

			pstmt.setString(1, empId);
			pstmt.setString(1, empName);
			pstmt.setString(1, empType);
			pstmt.setInt(1, Integer.parseInt(getDeptID(deptName)));

			int affectedRows = pstmt.executeUpdate();
			// check the affected rows
			if (affectedRows > 0) {
				// get the ID back
				try (ResultSet rs = pstmt.getGeneratedKeys()) {
					if (rs.next()) {
						id = rs.getLong(1);
					}
				} catch (SQLException ex) {
					System.out.println(ex.getMessage());
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return (id != 0) ? "success" : "failure";
	}

	private String getDeptID(String deptName) {

		Statement statement;
		String deptID = null;
		try {
			statement = getDBConnection().createStatement();
			ResultSet resultSet = statement
					.executeQuery("SELECT DeptID FROM public.Department where DeptName='" + deptName + "'");
			while (resultSet.next()) {
				deptID = resultSet.getString("DeptId");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return deptID;

	}

	@Override
	public String updateEmpDetails(String empId, String empType, String deptName) {
		String SQL = null;
		long id = 0;
		
		try {
			PreparedStatement pstmt = getDBConnection().prepareStatement(SQL);
			
			if (empType != null && deptName != null) {
				SQL = "update public.Employees set EmpType=?, DeptId=? where EmpId=" + empId;
				pstmt.setString(1, empType);
				pstmt.setInt(1, Integer.parseInt(getDeptID(deptName)));
			}			
			else if (empType != null && deptName == null) {
				SQL = "update public.Employees set EmpType=? where EmpId=" + empId;
				pstmt.setString(1, empType);
			}
			else if(empType == null && deptName != null) {
				SQL = "update public.Employees set DeptId=? where EmpId=" + empId;
				pstmt.setInt(1, Integer.parseInt(getDeptID(deptName)));
			}
			
			int affectedRows = pstmt.executeUpdate();
			if (affectedRows > 0) {
				try (ResultSet rs = pstmt.getGeneratedKeys()) {
					if (rs.next()) {
						id = rs.getLong(1);
					}
				} catch (SQLException ex) {
					System.out.println(ex.getMessage());
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return (id != 0) ? "success" : "failure";
	}

	@Override
	public String deleteEmpDetails(String empId) {
		String SQL = null;
		if (empId != null) {
			SQL = "delete from public.Employees where EmpId=" + empId;
		}
		long id = 0;
		try {
			PreparedStatement pstmt = getDBConnection().prepareStatement(SQL);

			pstmt.setString(1, empId);

			int affectedRows = pstmt.executeUpdate();
			if (affectedRows > 0) {
				try (ResultSet rs = pstmt.getGeneratedKeys()) {
					if (rs.next()) {
						id = rs.getLong(1);
					}
				} catch (SQLException ex) {
					System.out.println(ex.getMessage());
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return (id != 0) ? "success" : "failure";
	}

	@Override
	public Employee displayEmpDetails() {

		Statement statement;
		Employee emp = new Employee();
		try {
			statement = getDBConnection().createStatement();
			ResultSet resultSet = statement.executeQuery("select * from public.Employees");

			while (resultSet.next()) {
				//System.out.printf("Employee Name " + resultSet.getString("EmpName"));
				emp.setEmpID(resultSet.getString("EmpId"));
				emp.setEmpID(resultSet.getString("EmpName"));
				emp.setEmpID(resultSet.getString("EmpType"));
				emp.setEmpID(resultSet.getString("DeptName"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return emp;
	}

	/*@Override
	public String departmentDetails() {
		// TODO Auto-generated method stub
		return null;
	}*/

}
