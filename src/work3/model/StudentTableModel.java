/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package work3.model;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import work3.list.List;

public class StudentTableModel extends AbstractTableModel {
    
    private final String[] columnNames = new String[]{
        "ID", "Nombre"
    };
    
    private final Class[] columnClass = new Class[] {
        String.class, String.class, Integer.class
    };
    
    @Override
    public String getColumnName(int column)
    {
        return columnNames[column];
    }
    @Override
    public Class<?> getColumnClass(int columnIndex)
    {
        return columnClass[columnIndex];
    }
    @Override
    public int getColumnCount()
    {
        return columnNames.length;
    }
    @Override
    public int getRowCount()
    {
        return List.studens.listSize();
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        try {
            Student row;
            row = List.studens.getStudentAt(rowIndex+1);
            if(row!=null){
                switch (columnIndex) {
                    case 0:
                        return row.getIdStudent();
                    case 1:
                        return row.getName();
                    default:
                        break;
                }
                
            }
                       
        } catch (Exception ex) {
            Logger.getLogger(StudentTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null; 
    }
    @Override
   public void setValueAt(Object aValue, int rowIndex, int columnIndex)
   {    
       Student instance = (Student)aValue;
       Student row = null;
        try {
            row =List.studens.getStudentAt(rowIndex-1);
        } catch (Exception ex) {
            Logger.getLogger(StudentTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(row!=null){
            switch (columnIndex) {
            case 0:
                row.setIdStudent((Integer) instance.getIdStudent());
                break;
            case 1:
                row.setName((String) instance.getName());
                break;
            default:
                break;
            }
        }  
   }
   
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex)
    {
        return false;
    }
    
}
