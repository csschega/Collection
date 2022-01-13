/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package fxassigntry;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
//import javafx.Table1;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Callback;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CSS Chega
 */
public class FXAssigntry extends Application {
   

    @Override
    public void start(Stage primaryStage) {
        
        
        TableView table = new TableView<>();

        
          
        Label dsid = new Label("SID");
        Label dstdid = new Label("Studid");
        Label dfname = new Label("Firstname");
        Label dlname = new Label("Lastname");
        Label dsection = new Label("Section");
        Label ddept = new Label("Departement");

        TextField tsid = new TextField();
        TextField tstudid = new TextField();
        TextField tfname = new TextField();
        TextField tlname = new TextField();
        TextField tsection = new TextField();
        TextField tdept = new TextField();

        Button insert = new Button();
        insert.setText("Insert");

        Button update = new Button();
        update.setText("Update");
        
        Button view = new Button();
        view.setText("View");
        
        Button distinct = new Button();
        distinct.setText("Distinct");
        
        Button select = new Button();
        select.setText("Select");
        
        HBox hbox = new HBox(dsid, tsid);
        hbox.setSpacing(20);
        
        HBox hboxb = new HBox(insert, update,view,distinct,select);
        hboxb.setSpacing(20);

        HBox hbox2 = new HBox(dstdid, tstudid);
        hbox2.setSpacing(20);

        HBox hbox3 = new HBox(dfname, tfname);
        hbox.setSpacing(20);

        HBox hbox4 = new HBox(dlname, tlname);
        hbox2.setSpacing(20);

        HBox hbox5 = new HBox(dsection, tsection);
        hbox.setSpacing(20);

        HBox hbox6 = new HBox(ddept, tdept);
        hbox2.setSpacing(20);

        VBox vb = new VBox();
        vb.setSpacing(20);

        vb.getChildren().addAll(hbox, hbox2, hbox3, hbox4, hbox5, hbox6, hboxb,table);

        insert.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                DBConnection db = new DBConnection();
                Connection con = null;
                try {
                    con = db.connMethod();
                    if (con != null) {
                        Alert a = new Alert(Alert.AlertType.INFORMATION);
                        //a.setContentText("you are connected sucssfuly");
                        //a.showAndWait();
                    } else {
                        Alert a = new Alert(Alert.AlertType.INFORMATION);
                        a.setContentText("you are not connected sucssfuly");
                        a.showAndWait();
                    }
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(FXAssigntry.class.getName()).log(Level.SEVERE, null, ex);
                }

                
                
                try {
                    //Connection conn= DriverManager.getConnection(db.con);
                    
                    if(tsid.getText().equals("")||tstudid.getText().equals("")||tfname.getText().equals("")||tlname.getText().equals("")||tsection.getText().equals("")||tdept.getText().equals(""))
                    {
                        JOptionPane.showMessageDialog(null, "insert Every Needed Information");
                        //a.setContentText("insert Every Needed Information");
                    }
                    else
                    {
                    String query = "insert into dept_tbl(SID,Studid,Firstname,Lastname,Section,Department) values(?,?,?,?,?,?)";
                    PreparedStatement ps = con.prepareStatement(query);
                    ps.setString(1, tsid.getText());
                    ps.setString(2, tstudid.getText());
                    ps.setString(3, tfname.getText());
                    ps.setString(4, tlname.getText());
                    ps.setString(5, tsection.getText());
                    ps.setString(6, tdept.getText());
                    ps.execute();
                    JOptionPane.showMessageDialog(null, "inserted successfuly");
                    
                    tsid.setText("");
                        tstudid.setText("");
                        tfname.setText("");
                        tlname.setText("");
                        tsection.setText("");
                        tdept.setText("");
                    }
                    //System.out.println("inserted successfuly");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "insertion failed");
                    //System.out.println(ex.getMessage());
                }

            }
        });
        
        update.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) 
            {
         Alert a = new Alert(Alert.AlertType.INFORMATION);
                 DBConnection db = new DBConnection();
                Connection con = null; 
                try
                {
                    con = db.connMethod();                  
                     String value=tfname.getText();    
                     String value1="Aman";
                     String sql = "UPDATE dept_tbl SET Firstname='"+value+"' WHERE Firstname='"+value1+"'";
                    PreparedStatement statement = con.prepareStatement(sql);
                    statement.executeUpdate();  
                    
                    
                    a.setContentText("Updated successfuly");
                    a.showAndWait();
            }
                catch(Exception ex)
                {
                  System.out.println(ex.getMessage());  
                }
        }
        });
        
        
        view.setOnAction(new EventHandler<ActionEvent>() {
 private ObservableList<ObservableList> data;
 
            @Override
            public void handle(ActionEvent event) 
            {
             
                DBConnection obj1;
        Connection c;
        ResultSet rs;
        data = FXCollections.observableArrayList();
        try {

            table.setStyle("-fx-background-color:red; -fx-font-color:yellow ");
            obj1 = new DBConnection();
            c = obj1.connMethod();
                String SQL = "SELECT * from dept_tbl";
                rs = c.createStatement().executeQuery(SQL);
                for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                final int j = i;
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i + 1));
                col.setCellValueFactory((Callback<TableColumn.CellDataFeatures<ObservableList, String>,
                        ObservableValue<String>>) param -> new SimpleStringProperty(param.getValue().get(j).toString()));

                table.getColumns().addAll(col);
                //System.out.println("Column [" + i + "] ");

            }


            while (rs.next()) {
                ObservableList<String> row = FXCollections.observableArrayList();
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                row.add(rs.getString(i));
                }
                //System.out.println("Row[1]added " + row);
                data.add(row);

            }


            table.setItems(data);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error ");
        }      
         
        }
        });
        
        distinct.setOnAction(new EventHandler<ActionEvent>() {
 private ObservableList<ObservableList> data;
 //private TableView tbl;
            @Override
            public void handle(ActionEvent event) 
            {
             
                DBConnection obj1;
        Connection c;
        ResultSet rs;
        data = FXCollections.observableArrayList();
        try {

            table.setStyle("-fx-background-color:red; -fx-font-color:yellow ");
            obj1 = new DBConnection();
            c = obj1.connMethod();
                String SQL = "SELECT distinct Section from dept_tbl";
                rs = c.createStatement().executeQuery(SQL);
                for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                final int j = i;
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i + 1));
                col.setCellValueFactory((Callback<TableColumn.CellDataFeatures<ObservableList, String>,
                        ObservableValue<String>>) param -> new SimpleStringProperty(param.getValue().get(j).toString()));

                table.getColumns().addAll(col);
                //System.out.println("Column [" + i + "] ");

            }


            while (rs.next()) {
                ObservableList<String> row = FXCollections.observableArrayList();
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                row.add(rs.getString(i));
                }
                //System.out.println("Row[1]added " + row);
                data.add(row);

            }


            table.setItems(data);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error ");
        }      
         
        }
        });
        
        select.setOnAction(new EventHandler<ActionEvent>() {
 private ObservableList<ObservableList> data;
 //private TableView tbl;
            @Override
            public void handle(ActionEvent event) 
            {
             
                DBConnection obj1;
        Connection c;
        ResultSet rs;
        data = FXCollections.observableArrayList();
        try {

            table.setStyle("-fx-background-color:red; -fx-font-color:yellow ");
            obj1 = new DBConnection();
            c = obj1.connMethod();
                String SQL = "SELECT Department from dept_tbl where Firstname = 'Elias' and Section='secA' and Department='CS' ";
                rs = c.createStatement().executeQuery(SQL);
                for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                final int j = i;
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i + 1));
                col.setCellValueFactory((Callback<TableColumn.CellDataFeatures<ObservableList, String>,
                        ObservableValue<String>>) param -> new SimpleStringProperty(param.getValue().get(j).toString()));

                table.getColumns().addAll(col);
                //System.out.println("Column [" + i + "] ");

            }


            while (rs.next()) {
                ObservableList<String> row = FXCollections.observableArrayList();
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                row.add(rs.getString(i));
                }
                //System.out.println("Row[1]added " + row);
                data.add(row);

            }


            table.setItems(data);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error ");
        }      
         
        }
        });
        
        Scene scene = new Scene(vb, 900, 700);
        primaryStage.setTitle("Dept_tbl");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
