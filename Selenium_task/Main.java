package org.example;

public class Main {
    public static void main(String[] args){
        Add_new_shift addNewShift = new Add_new_shift();
        addNewShift.LoginToPage();
        addNewShift.GoToShiftPage();
        addNewShift.AddShift();
        addNewShift.SearchShift();
        addNewShift.DeleteShift();
        addNewShift.CloseWindow();
    }
}