package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Vector;

import jdk.jshell.spi.ExecutionControl;
import query.*;

public class VoterGUI implements ActionListener {

    private JLabel title;
    private JLabel output;
    private JLabel input;
    private JFrame frame;
    private JPanel mainPanel;
    private JPanel innerPanel;
    private JPanel buttonsPanel;
    private JPanel inputPanel;
    private JPanel titlePanel;
    private JPanel outputPanel;
    private JTable voterJTable;
    private JPanel areaPanel;
    private JPanel readoutPanel;
    private JTextArea data_ouput;
    private JComboBox queryList;
    private JScrollPane result;

    public VoterGUI() {
        frame = new JFrame();
        frame.setPreferredSize(new Dimension(450,700));

        mainPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        innerPanel = new JPanel(new GridLayout(2,1));
        innerPanel.setBorder(BorderFactory.createEmptyBorder(45,10,45,10));
        buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        readoutPanel = new JPanel();

        titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        titlePanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        inputPanel = new JPanel();
        outputPanel = new JPanel();

        areaPanel = new JPanel();

        queryList = new JComboBox<>(DbQueryType.values());
        queryList.addActionListener(this::showPanel);

        data_ouput = new JTextArea();
        queryList.setPreferredSize(new Dimension(200, 20));
        result = new JScrollPane(data_ouput);
        result.setPreferredSize(new Dimension(100, 100));

        title = new JLabel("Voter GUI");
        title.setFont(new Font("Dialog", Font.BOLD, 26));
        title.setForeground(Color.BLACK);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        titlePanel.add(title, null);

        input = new JLabel("Query:");
        input.setFont(new Font("Dialog", Font.BOLD, 18));
        input.setForeground(Color.BLACK);
        input.setHorizontalAlignment(SwingConstants.CENTER);

        output = new JLabel("Result:");
        output.setFont(new Font("Dialog", Font.BOLD, 18));
        output.setForeground(Color.BLACK);
        output.setHorizontalAlignment(SwingConstants.CENTER);

        Vector<String> columns = new Vector<>();
        Collections.addAll(columns, "VoterID", "SSN", "Name", "Age", "Gender", "Ethnicity", "FelonStatus", "PartyID");
        voterJTable = new JTable(new Vector<>(), columns);
        voterJTable.setVisible(false);

        JButton executeButton = new JButton("Execute");
        executeButton.setSize(125, 25);

        executeButton.addActionListener(this);

        //panel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        //panel.setLayout(new GridLayout(0, 1));
        //panel.add(addButton);

        JPanel outputTable = new JPanel();
        outputPanel.add(outputTable);

        mainPanel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        mainPanel.add(titlePanel, BorderLayout.NORTH);
        mainPanel.add(innerPanel, BorderLayout.CENTER);
        innerPanel.add(inputPanel, BorderLayout.CENTER);
        innerPanel.add(areaPanel, BorderLayout.CENTER);
        innerPanel.add(outputPanel, BorderLayout.CENTER);
        innerPanel.add(readoutPanel, BorderLayout.CENTER);
        inputPanel.add(input, BorderLayout.CENTER);
        inputPanel.add(input);
        areaPanel.add(queryList);

        mainPanel.add(voterJTable);

        buttonsPanel.add(executeButton);
        mainPanel.add(buttonsPanel, BorderLayout.SOUTH);

        frame.add(mainPanel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Deliverable4 Group 7 GUI");
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JPanel outputTable = new JPanel();
        outputPanel.add(outputTable);
    }

    public void showPanel(ActionEvent e) {

        voterJTable.setVisible(false);

        DbQueryType type = null;
        for (DbQueryType t: DbQueryType.getList()) {
            if (t.value.equals(((DbQueryType) queryList.getSelectedItem()).value)) {
                type = t;
                break;
            }
        }

        try {
            switch (type) {

                case VOTER:

                    VoterQuery q = new VoterQuery();
                    VoterResult r = (VoterResult) q.executeQuery();
                    DefaultTableModel model = (DefaultTableModel) voterJTable.getModel();
                    while (model.getRowCount() > 0) {
                        model.removeRow(0);
                    }
                    for (int i = 0; i < r.Age.size(); i++) {
                        model.addRow(new Object[]{r.VoterID.get(i), r.SSN.get(i), r.Name.get(i), r.Age.get(i), r.Gender.get(i), r.Ethnicity.get(i), r.FelonStatus.get(i), r.PartyID.get(i)});
                    }
                    voterJTable.setVisible(true);

                    break;

                case ROW_COUNT:

                case VOTER_TOTAL_COUNT:

                case CANDIDATE_BY_PARTY:

                case VOTER_PER_STATE_COUNT:

                case PARTY_ELECTED_BY_STATE:

                case STATES_WITH_DIFFERENT_ELECTED_PARTY:

                default:
                    System.out.println("Unrecognized db query type");
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}