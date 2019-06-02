package com.action.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import com.action.entities.Administrateur;

public class AdministrateurDaoImpl implements AdministrateurDao {

	private Connection connection;	
	
	public AdministrateurDaoImpl() {
		// Initalize database connection
		this.connection = Config.getInstance().getConnection();
		
	}
	
	@Override
	public void add(Administrateur administrateur) {
		try {
			PreparedStatement preparedStatement = this.connection.prepareStatement("insert into administrateur values (NULL, ?, ?, ?, ?)");	
			preparedStatement.setString(1, administrateur.getFirstName());
			preparedStatement.setString(2, administrateur.getLastName());
			preparedStatement.setString(3, administrateur.getEmail());
			preparedStatement.setString(4, administrateur.getPassword());
			preparedStatement.executeUpdate();
		}
		catch(Exception ex) {
			System.out.println("Add administrateur exception: " + ex.getMessage());
		}		
	}

	@Override
	public Administrateur find(Long id) {
		try {
			PreparedStatement preparedStatement = this.connection.prepareStatement("select *from administrateur where id=?");	
			preparedStatement.setLong(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if( resultSet.next() ) {
				return new Administrateur(String.valueOf(resultSet.getLong(1)), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5));
			}
		}
		catch(Exception ex) {
			System.out.println("Find administrateur exception: " + ex.getMessage());
		}
		return null;
	}

	@Override
	public Collection<Administrateur> findAll() {
		try {
			Statement statement = this.connection.createStatement();	
			Collection<Administrateur> administrateurs = new ArrayList<Administrateur>();
			ResultSet resultSet = statement.executeQuery("select * from administrateur");
			while( resultSet.next() ) {
				administrateurs.add(new Administrateur(String.valueOf(resultSet.getLong(1)), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5)));
			}
			return administrateurs;
		}
		catch(Exception ex) {
			System.out.println("Find all admins exception: " + ex.getMessage());
		}
		return null;
	}

	@Override
	public boolean update(Administrateur administrateur) {
		try {
			PreparedStatement preparedStatement = this.connection.prepareStatement("update bourse set first_name=?, last_name=?, email=?, password=? where id=?");	
			preparedStatement.setString(1, administrateur.getFirstName());
			preparedStatement.setString(2, administrateur.getLastName());
			preparedStatement.setString(3, administrateur.getEmail());
			preparedStatement.setString(4, administrateur.getPassword());
			preparedStatement.setLong(5, Long.parseLong(administrateur.getId()));
			if( preparedStatement.executeUpdate() > 0 ) {
				return true;
			}
		}
		catch(Exception ex) {
			System.out.println("Update administrateur exception: " + ex.getMessage());
		}
		return false;
	}

	@Override
	public boolean delete(Long id) {
		try {
			PreparedStatement preparedStatement = this.connection.prepareStatement("delete from administrateur where id=?");	
			preparedStatement.setLong(1, id);
			if( preparedStatement.executeUpdate() > 0 ) {
				return true;
			}
		}
		catch(Exception ex) {
			System.out.println("Delete adminsitrateur exception: " + ex.getMessage());
		}
		return false;
	}

}
