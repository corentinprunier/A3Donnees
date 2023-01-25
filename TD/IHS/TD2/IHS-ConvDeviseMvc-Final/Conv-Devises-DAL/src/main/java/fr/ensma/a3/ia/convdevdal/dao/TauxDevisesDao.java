package fr.ensma.a3.ia.convdevdal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TauxDevisesDao extends AbstractDao<EntityTauxDevises> {

	@Override
	public Optional<EntityTauxDevises> getById(String id) {
		EntityTauxDevises entity = null;
		Connection conn = null;
		PreparedStatement stmt;
		ResultSet rs;
		try {
			conn = connectDB();
			stmt = conn.prepareStatement("SELECT * FROM Taux_Devises WHERE ID = ?;");
			stmt.setString(1, id);
			rs = stmt.executeQuery();
			if (rs != null ) {
				entity = createEntityFromRs(rs);
			}
			rs.close();
			stmt.close();
			closeDB(conn);
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.exit(0);
		}
		return Optional.ofNullable(entity);
	}

	@Override
	public List<EntityTauxDevises> getAll() {
		List<EntityTauxDevises> listres = new ArrayList<EntityTauxDevises>();
		Connection conn = null;
		Statement stmt;
		ResultSet rs;
		String sql;
		try {
			conn = connectDB();
			stmt = conn.createStatement();
			sql = "SELECT * FROM Taux_Devises";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				listres.add(createEntityFromRs(rs));
			}
			rs.close();
			stmt.close();
			closeDB(conn);
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.exit(0);
		}
		return listres;
	}

	private EntityTauxDevises createEntityFromRs(final ResultSet rs) {
		EntityTauxDevises entity = new EntityTauxDevises();
		try {
			entity.setId(rs.getString("ID"));
			entity.setLabel(rs.getString("NAME"));
			entity.setTauxConversion(rs.getFloat("TAUX"));
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.exit(0);
		}
		return entity;
	}
	
	@Override
	public void save(EntityTauxDevises entity) {
		Connection conn = null;
		PreparedStatement stmt;
		try {
			conn = connectDB();
			stmt = conn.prepareStatement("INSERT INTO Taux_Devises (ID,NAME,TAUX)"
					+ "VALUES (?,?,?);");
			stmt.setString(1, entity.getId());
			stmt.setString(2, entity.getLabel());
			stmt.setFloat(3, entity.getTauxConversion());
			
			stmt.executeUpdate();
			stmt.close();
			closeDB(conn);
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.exit(0);
		}
		
	}

	@Override
	public void update(EntityTauxDevises entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(EntityTauxDevises entity) {
		// TODO Auto-generated method stub
		
	}

	
	
}
