/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package work3.nodo;

import work3.model.Student;

public class StudentNodo {
    
    public Student student;
    public StudentNodo sig;
    public StudentNodo ant;
    
    public StudentNodo(Student student){
        this.student = student;
        sig = null;
        ant = null;
    }
}
