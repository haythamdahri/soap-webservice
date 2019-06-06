package com.action.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;

import com.action.entities.Action;

public class ActionDaoImpl implements ActionDao {

	private Connection connection;

	public ActionDaoImpl() {
		// Initalize database connection
		this.connection = Config.getInstance().getConnection();
	}

	@Override
	public void add(Action action) {
		try {
			PreparedStatement preparedStatement = this.connection
					.prepareStatement("insert into action values (NULL, ?, ?, ?, ?, ?, ?)");
			preparedStatement.setString(1, action.getName());
			preparedStatement.setDouble(2, action.getOpeningAmount());
			preparedStatement.setDouble(3, action.getClosingAmount());
			java.sql.Date sqlDate = new java.sql.Date(action.getDate().getTime());
			preparedStatement.setDate(4, sqlDate);
			preparedStatement.setDouble(5, action.getVariation());
			preparedStatement.setLong(6, action.getBourseId());
			preparedStatement.executeUpdate();
		} catch (Exception ex) {
			System.out.println("Add exception: " + ex.getMessage());
		}
	}

	@Override
	public Action find(Long id) {
		try {
			// Create new BourseDao object to retrieve bourse from its id
			BourseDao bourseDao = new BourseDaoImpl();

			PreparedStatement preparedStatement = this.connection.prepareStatement("select *from action where id=?");
			preparedStatement.setLong(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				Timestamp ts = resultSet.getTimestamp(5);
				java.sql.Date date = new java.sql.Date(ts.getTime());
				return new Action(String.valueOf(resultSet.getLong(1)), resultSet.getString(2), resultSet.getDouble(3),
						resultSet.getDouble(4), date, resultSet.getLong(7));
			}
		} catch (Exception ex) {
			System.out.println("Add action exception: " + ex.getMessage());
		}
		return null;
	}

	// name is unique
	@Override
	public Collection<Action> findByName(String name) {
		try {
			// Create new BourseDao object to retrieve bourse from its id
			BourseDao bourseDao = new BourseDaoImpl();

			PreparedStatement preparedStatement = this.connection.prepareStatement("select *from action where name=?");
			preparedStatement.setString(1, name);
			ResultSet resultSet = preparedStatement.executeQuery();
			Collection<Action> actions = new ArrayList<Action>();
			while (resultSet.next()) {
				Timestamp ts = resultSet.getTimestamp(5);
				java.sql.Date date = new java.sql.Date(ts.getTime());
				actions.add(new Action(String.valueOf(resultSet.getLong(1)), resultSet.getString(2),
						resultSet.getDouble(3), resultSet.getDouble(4), date, resultSet.getLong(7)));
			}
			return actions;
		} catch (Exception ex) {
			System.out.println("Add actions by id exception: " + ex.getMessage());
		}
		return null;
	}

	@Override
	public Collection<Action> findById(Long id) {
		try {
			// Create new BourseDao object to retrieve bourse from its id
			BourseDao bourseDao = new BourseDaoImpl();

			PreparedStatement preparedStatement = this.connection.prepareStatement("select *from action where id=?");
			preparedStatement.setLong(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			Collection<Action> actions = new ArrayList<Action>();
			while (resultSet.next()) {
				Timestamp ts = resultSet.getTimestamp(5);
				java.sql.Date date = new java.sql.Date(ts.getTime());
				actions.add(new Action(String.valueOf(resultSet.getLong(1)), resultSet.getString(2),
						resultSet.getDouble(3), resultSet.getDouble(4), date, resultSet.getLong(7)));
			}
			return actions;
		} catch (Exception ex) {
			System.out.println("Add actions by id exception: " + ex.getMessage());
		}
		return null;
	}

	@Override
	public Collection<Action> findAll() {
		try {
			// Create new BourseDao object to retrieve bourse from its id
			BourseDao bourseDao = new BourseDaoImpl();

			Statement statement = this.connection.createStatement();
			Collection<Action> actions = new ArrayList<Action>();
			ResultSet resultSet = statement.executeQuery("select * from action");
			while (resultSet.next()) {

				Timestamp ts = resultSet.getTimestamp(5);
				java.sql.Date date = new java.sql.Date(ts.getTime());

				actions.add(new Action(String.valueOf(resultSet.getLong(1)), resultSet.getString(2),
						resultSet.getDouble(3), resultSet.getDouble(4), date, resultSet.getLong(7)));
			}
			return actions;
		} catch (Exception ex) {
			System.out.println("Find all actions exception: " + ex.getMessage());
		}
		return null;
	}

	@Override
	public boolean update(Action action) {
		try {
			PreparedStatement preparedStatement = this.connection.prepareStatement(
					"update action set name=?, opening_amount=?, closing_amount=?, date=?, bourse_id=? where id=?");
			preparedStatement.setString(1, action.getName());
			preparedStatement.setDouble(2, action.getOpeningAmount());
			preparedStatement.setDouble(3, action.getClosingAmount());
			java.sql.Date sqlDate = new java.sql.Date(action.getDate().getTime());
			preparedStatement.setDate(4, sqlDate);
			preparedStatement.setLong(5, action.getBourseId());
			preparedStatement.setLong(6, Long.parseLong(action.getId()));
			if (preparedStatement.executeUpdate() > 0) {
				return true;
			}
		} catch (Exception ex) {
			System.out.println("Update action exception: " + ex.getMessage());
		}
		return false;
	}

	@Override
	public boolean delete(Long id) {
		try {
			PreparedStatement preparedStatement = this.connection.prepareStatement("delete from action where id=?");
			preparedStatement.setLong(1, id);
			if (preparedStatement.executeUpdate() > 0) {
				return true;
			}
		} catch (Exception ex) {
			System.out.println("Delete action exception: " + ex.getMessage());
		}
		return false;
	}

	@Override
	public Collection<Action> findByBourseId(Long id) {

		try {
			// Create new BourseDao object to retrieve bourse from its id
			BourseDao bourseDao = new BourseDaoImpl();

			PreparedStatement preparedStatement = this.connection
					.prepareStatement("select *from action where bourse_id=?");
			preparedStatement.setLong(1, id);
			Collection<Action> actions = new ArrayList<Action>();
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {

				Timestamp ts = resultSet.getTimestamp(5);
				java.sql.Date date = new java.sql.Date(ts.getTime());

				actions.add(new Action(String.valueOf(resultSet.getLong(1)), resultSet.getString(2),
						resultSet.getDouble(3), resultSet.getDouble(4), date, resultSet.getLong(7)));
			}
			return actions;
		} catch (Exception ex) {
			System.out.println("Find actions by bourse exception: " + ex.getMessage());
		}
		return null;

	}

}
