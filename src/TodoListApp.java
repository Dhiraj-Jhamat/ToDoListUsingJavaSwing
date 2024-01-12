import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TodoListApp extends JFrame {

    private DefaultListModel todoListModel;
    private JList todoList;
    private JTextField newItemTextField;

    public TodoListApp() {
        setTitle("Todo List App");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialize components
        todoListModel = new DefaultListModel();
        todoList = new JList(todoListModel);
        newItemTextField = new JTextField(20);
        JButton addButton = new JButton("Add");
        JButton removeButton = new JButton("Remove");

       // Setting Layout
        setLayout(new BorderLayout());

        // Adding Components;
        add(new JScrollPane(todoList), BorderLayout.CENTER);

        JPanel inputPanel = new JPanel();
        inputPanel.add(newItemTextField);
        inputPanel.add(addButton);
        inputPanel.add(removeButton);

        add(inputPanel, BorderLayout.SOUTH);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNewItem();
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeSelectedItem();
            }
        });
    }

    private void addNewItem() {
        String newItem = newItemTextField.getText().trim();
        if (!newItem.isEmpty()) {
            todoListModel.addElement(newItem);
            newItemTextField.setText("");
        }
    }

    private void removeSelectedItem() {
        int selectedIndex = todoList.getSelectedIndex();
        if (selectedIndex != -1) {
            todoListModel.remove(selectedIndex);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TodoListApp().setVisible(true);
            }
        });
    }
}
