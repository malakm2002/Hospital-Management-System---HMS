package hmsGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import hmsGUI.Deletions.Delete;
import hmsGUI.Insertions.NurseInsertion;


public class ManipulationOps {
   public static void createFrame() {
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

      JButton btnInsertNurse = new JButton("Insert a new Nurse");
      btnInsertNurse.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            NurseInsertion.create();
         }
      });
      btnInsertNurse.setBounds(22, 32, 141, 23);
      contentPane.add(btnInsertNurse);

      JButton btnInsertJanitor = new JButton("Insert a new Janitor");
      btnInsertJanitor.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {

         }
      });
      btnInsertJanitor.setBounds(22, 66, 141, 23);
      contentPane.add(btnInsertJanitor);

      JButton btnInsertDoctor = new JButton("Insert a new Doctor");
      btnInsertDoctor.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {

         }
      });
      btnInsertDoctor.setBounds(22, 100, 141, 23);
      contentPane.add(btnInsertDoctor);

      JButton btnInsertRoom = new JButton("Insert a new Room");
      btnInsertRoom.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
         }
      });
      btnInsertRoom.setBounds(22, 134, 141, 23);
      contentPane.add(btnInsertRoom);

      JButton btnInsertBill = new JButton("Insert a new Bill");
      btnInsertBill.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
         }
      });
      btnInsertBill.setBounds(22, 168, 141, 23);
      contentPane.add(btnInsertBill);

      JButton btnInsertPatient = new JButton("Insert a new Patient");
      btnInsertPatient.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
         }
      });
      btnInsertPatient.setBounds(22, 202, 141, 23);
      contentPane.add(btnInsertPatient);

      JButton btnInsertMedicine = new JButton("Insert a new Medicine");
      btnInsertMedicine.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
         }
      });
      btnInsertMedicine.setBounds(22, 236, 141, 23);
      contentPane.add(btnInsertMedicine);

      JButton btnInsertRecord = new JButton("Insert a new Cashier");
      btnInsertRecord.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            NurseInsertion.create();

         }
      });
      btnInsertRecord.setBounds(22, 270, 141, 23);
      contentPane.add(btnInsertRecord);

      JButton btnInsertTreatment = new JButton("Insert a new Treatment record");
      btnInsertTreatment.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
         }
      });
      btnInsertTreatment.setBounds(22, 304, 141, 23);
      contentPane.add(btnInsertTreatment);

      JButton btnDelete = new JButton("Delete a value");
      btnInsertTreatment.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
           Delete.create();
        }
      });
      btnDelete.setBounds(222, 32, 141, 23);
      contentPane.add(btnDelete);
   }
}
