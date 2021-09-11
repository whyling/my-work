package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.event.ActionEvent;

public class passwordController {
	@FXML
	private TextField text1;
	@FXML
	private TextField text2;
	@FXML
	private TextField text3;
	@FXML
	private Button but1;
	@FXML
	private Button but2;

	// Event Listener on Button[#but1].onAction
	@FXML
	public void action1(ActionEvent event) {
		// TODO Autogenerated
		if(tlogin.findteacher(text1.getText(), text2.getText()))//判断原密码是否正确
		{
			// TODO Autogenerated
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/test";
			String uid = "root";
			String pwd = "root";
			Connection conn = null;
			Statement stmt = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				Class.forName(driver);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				conn = DriverManager.getConnection(url, uid, pwd);
				String sql = "UPDATE teacher SET password =? WHERE number = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,text3.getText());
				pstmt.setString(2,text1.getText());
				int count = pstmt.executeUpdate();
				if (count == 1) {
					try {//若成功则提示成功
						Stage stage = (Stage)but1.getScene().getWindow();
					    stage.close();
						Parent root = FXMLLoader.load(getClass().getResource("tips.fxml"));
						Scene scene = new Scene(root,235,101);
						 stage.setResizable(false);//禁止改动窗口大小
						scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
						stage.setScene(scene);
						stage.setTitle("提示");
						stage.show();
						aboutclass.setclass();
					} catch(Exception e) {
						e.printStackTrace();
					}
				} 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					pstmt.close();
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
	}
		else {
			try {//若失败则提示失败
                Stage stage1=new Stage();
				Parent root = FXMLLoader.load(getClass().getResource("tipf.fxml"));
				Scene scene = new Scene(root,280,115);
				 stage1.setResizable(false);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				stage1.setScene(scene);
				stage1.setTitle("提示");
				stage1.show();
				aboutclass.setclass();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	// Event Listener on Button[#but2].onAction
	@FXML
	public void action2(ActionEvent event) {

		if(tlogin.findstudent(text1.getText(), text2.getText()))//
		{
			// TODO Autogenerated
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/test";
			String uid = "root";
			String pwd = "root";
			Connection conn = null;
			Statement stmt = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				Class.forName(driver);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				conn = DriverManager.getConnection(url, uid, pwd);
				String sql = "UPDATE student SET password =? WHERE number = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,text3.getText());
				pstmt.setString(2,text1.getText());
				int count = pstmt.executeUpdate();
				if (count == 1) {
					try {//若成功则提示成功
						Stage stage = (Stage)but1.getScene().getWindow();
					    stage.close();
						Parent root = FXMLLoader.load(getClass().getResource("tips.fxml"));
						Scene scene = new Scene(root,235,101);
						 stage.setResizable(false);//禁止改动窗口大小
						scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
						stage.setScene(scene);
						stage.setTitle("提示");
						stage.show();
						aboutclass.setclass();
					} catch(Exception e) {
						e.printStackTrace();
					}
				} 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					pstmt.close();
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
	}
		else {
			try {//若失败则提示失败
                Stage stage1=new Stage();
				Parent root = FXMLLoader.load(getClass().getResource("tipf.fxml"));
				Scene scene = new Scene(root,280,115);
				 stage1.setResizable(false);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				stage1.setScene(scene);
				stage1.setTitle("提示");
				stage1.show();
				aboutclass.setclass();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
