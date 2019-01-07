/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package work3.list;

import work3.model.Student;
import work3.nodo.StudentNodo;

public class DoubleLinkedCircularListStudent {
    
    private StudentNodo actual;
    private int size = 1;
    private boolean passed=false;
    
    public DoubleLinkedCircularListStudent(){
        actual = null;
    }
    
    public int listSize(){
        return size;
    }
    
    public boolean empty(){
        return(actual==null);
    }
    
    public void addToFinal(String name){
        Student newStudent = new Student(size,name);
        StudentNodo nuevo = new StudentNodo(newStudent);
        if(empty()){
            actual = nuevo;  
        }else{
            StudentNodo aux = actual;
            aux.ant = nuevo;
            while(aux.sig!=null && aux.sig!=actual){
               aux = aux.sig; 
            }
            aux.sig = nuevo;
            nuevo.ant = aux;
            nuevo.sig = actual;
        }   
        size++;
    }

    public Student getStudentAt(int idRef) throws Exception{
        if(!empty()){
            if(idRef>=1){
                if(idRef==1){     
                    return actual.student;
                }else{
                    StudentNodo aux = actual;
                    for(int i=1; i<idRef; i++){
                        aux = aux.sig;
                    }
                    return aux.student;
                }
            }
            passed = false;
        }
        return null;
    }
     
    public void print(){
        
        StudentNodo temp = actual;
        
        while(temp != null && !passed){
            if(temp.ant != null){
                System.out.println("Anterior: "+temp.ant.student.getIdStudent() +
                        "Nombre: " + temp.ant.student.getName());
            }
            System.out.println("Actual: "+temp.student.getIdStudent() + 
                    "Nombre: "+temp.student.getName());
            if(temp.sig != null){
                System.out.println("Siguiente: "+temp.sig.student.getIdStudent() + 
                        "Nombre: " + temp.sig.student.getName());
            }
            System.out.println("-----------------------------");
            if(temp.sig==actual){
                passed = true;
            }
            temp = temp.sig;
        }
        passed = false;
        
    }
    
}
