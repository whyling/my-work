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

public class addtController {
	@FXML
	private TextField text2;
	@FXML
	private TextField text3;
	@FXML
	private Button but;
	@FXML
	private TextField text1;

	// Event Listener on Button[#but].onAction
	@FXML
	boolean Find(){//�ж��Ƿ����ҳ���ͬѧ��
		String driver = "com.mysql.cj.jdbc.Driver";
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
			String sql = "select id from teacher where number = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, text2.getText());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return true;
	}
	// Event Listener on Button[#but].onAction
	@FXML
	public void but1(ActionEvent event) {
		// TODO Autogenerated
		if(Find()){//���Ҳ�����������
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
				String sql = "insert into teacher(name,number,password) values(?,?,?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, text1.getText());
				pstmt.setString(2, text2.getText());
				pstmt.setString(3, text3.getText());
				int count = pstmt.executeUpdate();
				if (count == 1) {
					try {
						Stage stage = (Stage)but.getScene().getWindow();
					    stage.close();
						Parent root = FXMLLoader.load(getClass().getResource("tips.fxml"));
						Scene scene = new Scene(root,235,101);
						 stage.setResizable(false);
						scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
						stage.setScene(scene);
						stage.setTitle("��ʾ");
						stage.show();
						aboutclass.setclass();
					} catch(Exception e) {
						e.printStackTrace();
					}
				} else {
					try {//��ʧ������ʾʧ��
	                      Stage stage1=new Stage();
						Parent root = FXMLLoader.load(getClass().getResource("tipf.fxml"));
						Scene scene = new Scene(root,280,115);
						 stage1.setResizable(false);
						scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
						stage1.setScene(scene);
						stage1.setTitle("��ʾ");
						stage1.show();
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
			try {//��ʧ������ʾʧ��
                  Stage stage1=new Stage();
				Parent root = FXMLLoader.load(getClass().getResource("tipf.fxml"));
				Scene scene = new Scene(root,280,115);
				 stage1.setResizable(false);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				stage1.setScene(scene);
				stage1.setTitle("��ʾ");
				stage1.show();
				aboutclass.setclass();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
}
}