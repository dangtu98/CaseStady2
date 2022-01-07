package Interface;

import Model.Staff;

import java.util.ArrayList;


public interface Manager {
   void displayAllStaff();
   void addStaff();
   Staff editStaff(int id);
   Staff deleteStaff(int id);



}
