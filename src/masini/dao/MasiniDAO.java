package masini.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import masini.helper.*;
import masini.pojo.*;

public class MasiniDAO {

	public static ArrayList<Masini> getAll() throws SQLException {
		ArrayList<Masini> result = new ArrayList<Masini>();
		Connection conn = MasiniHelper.getConnection();
		Statement stmt = conn.createStatement();
		String query = "select * from masini";
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			Masini m = new Masini();
			m.setId(rs.getInt("id"));
			m.setTip_masina(rs.getString("tip_masina"));
			m.setNr_usi(rs.getInt("nr_usi"));
			m.setAn_fabricatie(rs.getDate("an_fabricatie"));
			result.add(m);
		}

		return result;
	}

	public static Masini getById(int id) throws SQLException {
		Masini result = null;
		Connection conn = MasiniHelper.getConnection();
		String query = "select * from masini where id=?";
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.setInt(1, id);

		ResultSet rs = stmt.executeQuery();
		if (rs.next()) {
			result = new Masini();
			result.setId(rs.getInt("id"));
			result.setTip_masina(rs.getString("tip_masina"));
			result.setNr_usi(rs.getInt("nr_usi"));
			result.setAn_fabricatie(rs.getDate("an_fabricatie"));
		}
		return result;
	}

	
	public static void create(Masini s) throws SQLException {
		Connection c=  MasiniHelper.getConnection();
		String query = "insert into masini (tip_masina, nr_usi, an_fabricatie) values (?,?,?)";
		PreparedStatement ps = c.prepareStatement(query);
		ps.setString(1, s.getTip_masina());
		ps.setInt(2, s.getNr_usi());
		ps.setDate(3, s.getAn_fabricatie());
		ps.executeUpdate();
		System.out.println("S-a inserat cu succes "+ s.getTip_masina());
				
	}
	
	
	public static String delete(String tip_masina) throws SQLException {
		Connection c = MasiniHelper.getConnection();
		String deleteQuery = "delete from masini where tip_masina=?";
		PreparedStatement ps = c.prepareStatement(deleteQuery);
		ps.setString(1, tip_masina);
		int deleted = ps.executeUpdate();

		return deleted == 0 ? "Nu a fost sters nici-o inregistrare"
				: "A fost sters cu succes " + deleted + " inregistrari";

	}

	
	public static boolean update(Masini s) throws SQLException {

		Connection c = MasiniHelper.getConnection();
		String query = "update masini set tip_masina=?, nr_usi=?, an_fabricatie=? where id=?";
		PreparedStatement ps = c.prepareStatement(query);
		ps.setString(1, s.getTip_masina());
		ps.setInt(2, s.getNr_usi());
		ps.setDate(3, s.getAn_fabricatie());
		ps.setInt(4, s.getId());

		int ar = ps.executeUpdate();

		return ar == 0 ? false : true;

	}
}
