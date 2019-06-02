package com.action.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import com.action.entities.Bourse;

public class BourseDaoImpl implements BourseDao {

	private Connection connection;	
	
	public BourseDaoImpl() {
		// Initalize database connection
		this.connection = Config.getInstance().getConnection();
		
	}
	
	@Override
	public void add(Bourse bourse) {
		try {
			PreparedStatement preparedStatement = this.connection.prepareStatement("insert into bourse values (NULL, ?)");	
			preparedStatement.setString(1, bourse.getName());
			preparedStatement.executeUpdate();
		}
		catch(Exception ex) {
			System.out.println("Add bourse exception: " + ex.getMessage());
		}		
	}

	@Override
	public Bourse find(Long id) {
		try {
			PreparedStatement preparedStatement = this.connection.prepareStatement("select *from bourse where id=?");	
			preparedStatement.setLong(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if( resultSet.next() ) {
				return new Bourse(String.valueOf(resultSet.getLong(1)), resultSet.getString(2));
			}
		}
		catch(Exception ex) {
			System.out.println("Find bourse exception: " + ex.getMessage());
		}
		return null;
	}
	
	@Override
	public Collection<Bourse> findById(Long id) {
		try {
			PreparedStatement preparedStatement = this.connection.prepareStatement("select *from bourse where id=?");	
			preparedStatement.setLong(1, id);
			Collection<Bourse> bourses = new ArrayList<Bourse>();
			ResultSet resultSet = preparedStatement.executeQuery();
			while( resultSet.next() ) {
				bourses.add(new Bourse(String.valueOf(resultSet.getLong(1)), resultSet.getString(2)));
			}
			return bourses;
		}
		catch(Exception ex) {
			System.out.println("Find bourses by id exception: " + ex.getMessage());
		}
		return null;
	}

	@Override
	public Collection<Bourse> findAll() {
		try {
			Statement statement = this.connection.createStatement();	
			Collection<Bourse> bourses = new ArrayList<Bourse>();
			ResultSet resultSet = statement.executeQuery("select * from bourse");
			while( resultSet.next() ) {
				bourses.add(new Bourse(String.valueOf(resultSet.getLong(1)), resultSet.getString(2)));
			}
			return bourses;
		}
		catch(Exception ex) {
			System.out.println("Find all bourses exception: " + ex.getMessage());
		}
		return null;
	}

	@Override
	public boolean update(Bourse bourse) {
		try {
			PreparedStatement preparedStatement = this.connection.prepareStatement("update bourse set name=? where id=?");	
			preparedStatement.setString(1, bourse.getName());
			preparedStatement.setLong(2, Long.parseLong(bourse.getId()));
			if( preparedStatement.executeUpdate() > 0 ) {
				return true;
			}
		}
		catch(Exception ex) {
			System.out.println("Update bourse exception: " + ex.getMessage());
		}
		return false;
	}

	@Override
	public boolean delete(Long id) {
		try {
			PreparedStatement preparedStatement = this.connection.prepareStatement("delete from bourse where id=?");	
			preparedStatement.setLong(1, id);
			if( preparedStatement.executeUpdate() > 0 ) {
				return true;
			}
		}
		catch(Exception ex) {
			System.out.println("Delete bourse exception: " + ex.getMessage());
		}
		return false;
	}

}
