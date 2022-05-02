package hmsGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
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

    public static void create() {
        JFrame frame = new JFrame("Hospital Management System - Operations");
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
        frame.setBounds(100, 100, 700, 394);

        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        frame.setContentPane(contentPane);
        frame.getContentPane().setLayout(null);

        JButton btnUpdateNurse = new JButton("Update Staff Records");
        btnUpdateNurse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StaffRecUpdate.create();
            }
        });
        btnUpdateNurse.setBounds(22, 234, 165, 23);
        contentPane.add(btnUpdateNurse);

        JButton btnUpdatedocInfo = new JButton("Update Doctor Info");
        btnUpdatedocInfo.setBounds(22, 32, 165, 23);
        contentPane.add(btnUpdatedocInfo);
        btnUpdatedocInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DoctorUpdate.create();
            }
        });
        JButton btnUpdatePatientInfo = new JButton("Update Patient Info");
        btnUpdatePatientInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                patientRecUpdate.create();
            }
        });
        btnUpdatePatientInfo.setBounds(22, 66, 165, 23);
        contentPane.add(btnUpdatePatientInfo);
        
        JButton btnUpdateRoom = new JButton("Update Room Info");
        btnUpdateRoom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RoomUpdate.create();
            }
        });
        btnUpdateRoom.setBounds(22, 100, 165, 23);
        contentPane.add(btnUpdateRoom);

        JButton btnUpdateBill = new JButton("Update Bill Info");
        btnUpdateBill.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BillUpdate.create();
            }
        });
        btnUpdateBill.setBounds(22, 134, 165, 23);
        contentPane.add(btnUpdateBill);
        
        JButton btnUpdateMed = new JButton("Update Medicine Info");
        btnUpdateMed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MedicineUpdate.create();
            }
        });
        btnUpdateMed.setBounds(22, 168, 165, 23);
        contentPane.add(btnUpdateMed);

        JButton btnUpdTreat = new JButton("Update Medicine Info");
        btnUpdTreat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TreatUpdate.create();
            }
        });
        btnUpdTreat.setBounds(22, 202, 165, 23);
        contentPane.add(btnUpdTreat);

    }
    
}
