package application;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {
	@FXML
	private TextField text_1;
	@FXML
	private Button but_1;
	@FXML
	private TextField text_2;
	@FXML
	private Button but_2;
	String numa="admin";
	String pasa="admin";
	//but_1�Ķ���(��ʦ��¼)
	
public void actionPerformed1(ActionEvent event) {
		
		
	String text1 = text_1.getText();
	String text2 = text_2.getText();
		Boolean b11=false;
		b11=tlogin.findteacher(text1,text2);
		if(b11)
		{
			Stage primaryStage1 = (Stage)but_1.getScene().getWindow();
			try {
				Parent root = FXMLLoader.load(getClass().getResource("teacher.fxml"));
				Scene scene = new Scene(root,571,368);
				 primaryStage1.setResizable(false);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage1.setScene(scene);
				primaryStage1.setTitle("��ʦ����");
				primaryStage1.show();
				aboutclass.setclass();
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			
		}
		else {
			
			Stage primaryStage1=new Stage();
			try {
				Parent root = FXMLLoader.load(getClass().getResource("tip.fxml"));
				Scene scene = new Scene(root,256,87);
				 primaryStage1.setResizable(false);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage1.setScene(scene);
				primaryStage1.setTitle("��ʾ");
				primaryStage1.show();
				primaryStage1.setAlwaysOnTop(true);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	//but_2�Ķ�����ѧ����½��
	public void actionPerformed(ActionEvent event) {
		// TODO Autogenerated
		String text1 = text_1.getText();
		String text2 = text_2.getText();
		Boolean b11=false;
		iint.delete(1);
	    iint.add(text1);
		b11=tlogin.findstudent(text1,text2);
		if(b11)
		{
			Stage primaryStage1 = (Stage)but_2.getScene().getWindow();
			try {
				Parent root = FXMLLoader.load(getClass().getResource("student.fxml"));
				Scene scene = new Scene(root,336,135);
				 primaryStage1.setResizable(false);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage1.setScene(scene);
				primaryStage1.setTitle("ǩ�������");
				primaryStage1.show();
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		else {
			
			Stage primaryStage1=new Stage();
			try {
				Parent root = FXMLLoader.load(getClass().getResource("tip.fxml"));
				Scene scene = new Scene(root,256,87);
				 primaryStage1.setResizable(false);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage1.setScene(scene);
				primaryStage1.setTitle("��ʾ");
				primaryStage1.show();
				primaryStage1.setAlwaysOnTop(true);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}	
	}
	//����Ա����
	public void actionPerformed2(ActionEvent event) {
		
		
		String text1 = text_1.getText();
		String text2 = text_2.getText();
			Boolean b11=false;
			
			if(text1.equals(numa)&&text2.equals(pasa))
			{
				Stage stage = (Stage)but_2.getScene().getWindow();
			    stage.close();
				Stage primaryStage1=new Stage();
				try {
					Parent root = FXMLLoader.load(getClass().getResource("admin.fxml"));
					Scene scene = new Scene(root,540,182);
					 primaryStage1.setResizable(false);
					scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
					primaryStage1.setScene(scene);
					primaryStage1.setTitle("����Ա����");
					primaryStage1.show();
					aboutclass.setclass();
				} catch(Exception e) {
					e.printStackTrace();
				}
				
				
			}
			else {
				
				Stage primaryStage1=new Stage();
				try {
					Parent root = FXMLLoader.load(getClass().getResource("tip.fxml"));
					Scene scene = new Scene(root,256,87);
					 primaryStage1.setResizable(false);
					scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
					primaryStage1.setScene(scene);
					primaryStage1.setTitle("��ʾ");
					primaryStage1.show();
					primaryStage1.setAlwaysOnTop(true);
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
			
		}
	public void actionPerformed3(ActionEvent event) {
		Stage stage = (Stage)but_2.getScene().getWindow();
	    stage.close();
		Stage primaryStage1=new Stage();
		try {
			Parent root = FXMLLoader.load(getClass().getResource("password.fxml"));
			Scene scene = new Scene(root,364,203);
			 primaryStage1.setResizable(false);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage1.setScene(scene);
			primaryStage1.setTitle("�޸�����");
			primaryStage1.show();
			aboutclass.setclass();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	}