package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.masai.bean.Admin;
import com.masai.exceptions.AdminException;
import com.masai.utility.DBUtil;

public class AdminDaoImpl implements AdminDao {

	
	@Override
	public String registerAdmin(Admin admin) {

		String message = "Not registered...";

		try (Connection conn = DBUtil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("insert into admin values (?,?,?,?)");

			ps.setInt(1, admin.getaId());
			ps.setString(2, admin.getaName());
			ps.setString(3, admin.getaEmail());
			ps.setString(4, admin.getaPass());

			int x = ps.executeUpdate();

			if (x > 0)
				message = "Admin Registered Succesfully...";
			else
				message = "Admin data is already present inside the DataBase...";

		} catch (SQLException e) {
			message = e.getMessage();
		}

		return message;
	}

	@Override
	public Admin loginAdmin(String email, String password) throws AdminException {

		Admin admin = null;

		try (Connection conn = DBUtil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("select * from admin where aEmail = ? AND aPass = ?");

			ps.setString(1, email);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				int aId = rs.getInt("aId");
				String aName = rs.getString("aName");
				String aEmail = rs.getString("aEmail");
				String aPass = rs.getString("aPass");

				admin = new Admin(aId, aName, aEmail, aPass);
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		if (admin == null)
			throw new AdminException("Invalid Credentials..");

		return admin;
	}

	
	
}
