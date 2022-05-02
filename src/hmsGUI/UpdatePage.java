package hmsGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import hmsGUI.Updates.BillUpdate;
import hmsGUI.Updates.DoctorUpdate;
import hmsGUI.Updates.MedicineUpdate;
import hmsGUI.Updates.RoomUpdate;
import hmsGUI.Updates.StaffRecUpdate;
import hmsGUI.Updates.TreatUpdate;
import hmsGUI.Updates.patientRecUpdate;

public class UpdatePage {
    /**
     * Creates the page containing all the buttons relating to update operations
     */
    public static void create() {
        // title
        JFrame frame = new JFrame("HMS - Update Operations");

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 450, 400);

        JLabel label = new JLabel(ManipulationOps.background);
        label.setBounds(0, 0, 400, 300);
        label.setOpaque(false);
        frame.setContentPane(label);
        
        frame.getContentPane().setLayout(null);

        // navigate to staff updates
        JButton btnUpdateNurse = new JButton("Update Staff Records");
        btnUpdateNurse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StaffRecUpdate.create();
            }
        });
        btnUpdateNurse.setContentAreaFilled(false);
        btnUpdateNurse.setBounds(22, 234, 165, 23);
        frame.add(btnUpdateNurse);

        // navigate to doctor updates
        JButton btnUpdatedocInfo = new JButton("Update Doctor Specialty");
        btnUpdatedocInfo.setBounds(22, 32, 170, 23);
        frame.add(btnUpdatedocInfo);
        btnUpdatedocInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DoctorUpdate.create();
            }
        });
        btnUpdatedocInfo.setContentAreaFilled(false);

        // navigate to patient updates
        JButton btnUpdatePatientInfo = new JButton("Update Patient Info");
        btnUpdatePatientInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                patientRecUpdate.create();
            }
        });
        btnUpdatePatientInfo.setContentAreaFilled(false);
        btnUpdatePatientInfo.setBounds(22, 66, 165, 23);
        frame.add(btnUpdatePatientInfo);
        
        // navigate to room updates
        JButton btnUpdateRoom = new JButton("Update Room Info");
        btnUpdateRoom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RoomUpdate.create();
            }
        });
        btnUpdateRoom.setContentAreaFilled(false);
        btnUpdateRoom.setBounds(22, 100, 165, 23);
        frame.add(btnUpdateRoom);

        // navigate to bill updates
        JButton btnUpdateBill = new JButton("Update Bill Info");
        btnUpdateBill.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BillUpdate.create();
            }
        });
        btnUpdateBill.setContentAreaFilled(false);
        btnUpdateBill.setBounds(22, 134, 165, 23);
        frame.add(btnUpdateBill);
        
        // navigate to medicine updates
        JButton btnUpdateMed = new JButton("Update Medicine Info");
        btnUpdateMed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MedicineUpdate.create();
            }
        });
        btnUpdateMed.setContentAreaFilled(false);
        btnUpdateMed.setBounds(22, 168, 165, 23);
        frame.add(btnUpdateMed);

        // navigate to treat updates
        JButton btnUpdTreat = new JButton("Update Treat Info");
        btnUpdTreat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TreatUpdate.create();
            }
        });
        btnUpdTreat.setContentAreaFilled(false);
        btnUpdTreat.setBounds(22, 202, 165, 23);
        frame.add(btnUpdTreat);
    }

}
