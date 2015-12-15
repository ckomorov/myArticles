package tritpo;

import java.sql.*;

import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

public class btnAction {//TODO: rename -> DatabaseService
	
	public static void addArticle(){//InsertArticle
		
		Connection connection = null;
		connection = sqlConnection.dbConnector();
		try{
		String query = " insert into Articles (ID, Article, Adress) values (?, ?, ?)";
		PreparedStatement pst = connection.prepareStatement(query);
		pst.setString(1, window.textFieldId.getText());//TODO: that class responsibility is to talk with db, please remove responsibility to interract with view.
		pst.setString(2, window.textFieldAdress.getText());
		pst.setString(3, "http://" + window.textFieldArticle.getText());
		pst.execute();
		
		window.textFieldId.setText("");
		window.textFieldAdress.setText("");
		window.textFieldArticle.setText("");
		
		String query1 = " select ID, Article, Adress from Articles";
		PreparedStatement pst1 = connection.prepareStatement(query1);
		ResultSet rs = pst1.executeQuery();
		window.table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception e1) {
			e1.printStackTrace();
			}
	}
	
	public static void refreshArticle(){//TODO: SelectArticles
		//TODO: external world should interract with that class via entities, not tables.
		Connection connection = null;
		connection=sqlConnection.dbConnector();
		try{
		String query1 = " select ID, Article, Adress from Articles";
		PreparedStatement pst1 = connection.prepareStatement(query1);
		ResultSet rs = pst1.executeQuery();
		window.table.setModel(DbUtils.resultSetToTableModel(rs));
		}catch (Exception q){
			q.printStackTrace();
		}
	}
	
	public static void deleteArticle(){
		Connection connection = null;
		try{
			connection=sqlConnection.dbConnector();
			String query = " delete from Articles where ID = '"+ win2.textField.getText() +"' ";
			PreparedStatement pst = connection.prepareStatement(query);
			pst.execute();
			btnAction.refreshArticle();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
	}
	
	public static void openArticle(){//TODO: Article should contain url
								//TODO: remove.
		Connection connection = null;
		connection=sqlConnection.dbConnector();
		try{
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select Adress from Articles where ID = '" + win3.textField.getText() + "'" );
			String adress = rs.getString("Adress");
			openBrowser.OpenVk(adress);
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
}





