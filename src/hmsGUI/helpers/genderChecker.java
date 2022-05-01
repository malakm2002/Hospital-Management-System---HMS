package hmsGUI.helpers;

import javax.swing.JCheckBox;

public class genderChecker {
    private char gender;
    public genderChecker(JCheckBox maleBox, JCheckBox femaleBox){
        if(maleBox.isSelected()){
            gender = 'M';
        }
        else{
            gender = 'F';
        }

    }
    public char getGender(){
        return gender;
    }
    
}
