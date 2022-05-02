package hmsGUI.helpers;

import javax.swing.JCheckBox;

public class genderChecker {
    private char gender;

    // sets 'gender' according to the provided check boxes
    public genderChecker(JCheckBox maleBox, JCheckBox femaleBox){
        if(maleBox.isSelected()){
            gender = 'M';
        }
        else{
            gender = 'F';
        }

    }

    // returns the gender as a char
    public char getGender(){
        return gender;
    }
    
}
