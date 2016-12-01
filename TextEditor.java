import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;


public class TextEditor extends JFrame implements ActionListener {

    public static void main(String[] args) {
        new TextEditor();
    }

    private JMenu file; //define file menu

    private JMenu edit; //define edit menu

    private JMenuItem newFile; //define new file

    private JMenuItem open; //define open file

    private JMenuItem save; //define save file

    private JMenuItem saveAs; //define save file as

    private JMenuItem delete; //define delete file

    private JMenuItem selectAll; //define select all text

    private JMenuItem customize; //define customize text

    private JFrame cust;

    private JComboBox jcomp1;
    private JComboBox jcomp2;
    private JLabel jcomp3;
    private JLabel jcomp4;
    private JComboBox jcomp5;
    private JLabel jcomp6;
    private JLabel jcomp7;
    private JFrame frame;


    private JMenuItem cut; //define cut text

    private JMenuItem copy; //define copy text

    private JMenuItem paste; //define paste text

    private JFrame editorWindow; //define text editor window

    private Border textBorder; //define text border

    private JScrollPane scroll; //define scroll

    private JTextArea textArea; //define text area

    private Font textFont; //define text font

    private JFrame window; //define window to open or save file

    private boolean opened = false; //is file opened

    private boolean saved = false; //is file saved

    private File openedFile;

    public JTextArea getTextArea() {
        return textArea;
    }

    public void setTextArea(JTextArea text) {
        textArea = text;
    }


    public TextEditor() {
        super("TextEditor");
        fileMenu();
        editMenu();
        createTextArea();
        createEditorWindow();
    }

    // creating main menu
    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.add(file);
        menuBar.add(edit);
        menuBar.setBackground(Color.DARK_GRAY);
        menuBar.setForeground(Color.WHITE);
        return menuBar;
    }

    private void fileMenu() {

        //Create File Menu
        file = new JMenu("File");
        file.setPreferredSize(new Dimension(55, 30));
        file.setFont(new Font("File", Font.PLAIN, 25));
        file.setForeground(Color.WHITE);

        //Add file menu items
        newFile = new JMenuItem("New");

        newFile.addActionListener(this);

        newFile.setPreferredSize(new Dimension(150, 30));

        newFile.setEnabled(true);

        newFile.setFont(new Font("New", Font.PLAIN, 25));

        open = new JMenuItem("Open");

        open.addActionListener(this);

        open.setPreferredSize(new Dimension(150, 30));

        open.setEnabled(true);

        open.setFont(new Font("Open", Font.PLAIN, 25));

        save = new JMenuItem("Save");

        save.addActionListener(this);

        save.setPreferredSize(new Dimension(150, 30));

        save.setEnabled(true);

        save.setFont(new Font("Save", Font.PLAIN, 25));

        saveAs = new JMenuItem("Save As");

        saveAs.addActionListener(this);

        saveAs.setPreferredSize(new Dimension(150, 30));

        saveAs.setEnabled(true);

        saveAs.setFont(new Font("Save As", Font.PLAIN, 25));

        customize = new JMenuItem("Customize");

        customize.addActionListener(this);

        customize.setEnabled(true);

        customize.setFont(new Font("Customize", Font.PLAIN, 25));

        delete = new JMenuItem("Delete Selected");

        delete.addActionListener(this);

        delete.setPreferredSize(new Dimension(220, 30));

        delete.setEnabled(true);

        delete.setFont(new Font("Del. Selected", Font.PLAIN, 25));

        //Adding items to menu
        file.add(newFile);
        file.add(open);
        file.add(save);
        file.add(saveAs);
        //file.add(delete);
        file.add(customize);
    }

    //adding items to edit menu
    private void editMenu() {

        edit = new JMenu("Edit");

        edit.setForeground(Color.WHITE);

        edit.setPreferredSize(new Dimension(55, 30));

        edit.setFont(new Font("Edit", Font.PLAIN, 25));

        selectAll = new JMenuItem("Select All");

        selectAll.addActionListener(this);

        selectAll.setPreferredSize(new Dimension(150, 30));

        selectAll.setEnabled(true);

        selectAll.setFont(new Font("Select All", Font.PLAIN, 25));

        copy = new JMenuItem("Copy");

        copy.addActionListener(this);

        copy.setPreferredSize(new Dimension(150, 30));

        copy.setEnabled(true);

        copy.setFont(new Font("Copy", Font.PLAIN, 25));

        paste = new JMenuItem("Paste");

        paste.addActionListener(this);

        paste.setPreferredSize(new Dimension(150, 30));

        paste.setEnabled(true);

        paste.setFont(new Font("Paste", Font.PLAIN, 25));

        cut = new JMenuItem("Cut");

        cut.addActionListener(this);

        cut.setPreferredSize(new Dimension(150, 30));

        cut.setEnabled(true);

        cut.setFont(new Font("Cut", Font.PLAIN, 25));

        //Adding items to menu
        edit.add(selectAll);
        edit.add(copy);
        edit.add(paste);
        edit.add(delete);
        edit.add(cut);
    }

    private JTextArea createTextArea() {

        textBorder = BorderFactory.createBevelBorder(0, Color.BLACK, Color.BLACK);

        textArea = new JTextArea(40, 60);

        textArea.setEditable(true);

        textArea.setBorder(BorderFactory.createCompoundBorder(textBorder, BorderFactory.createEmptyBorder(2, 5, 0, 0)));

        textFont = new Font("Times New Roman", 15, 20);

        textArea.setFont(textFont);

        return textArea;
    }


    private JFrame createEditorWindow() {

        JScrollPane scrollPane = new JScrollPane(textArea);
        TextLineNumber tln = new TextLineNumber(textArea);
        scrollPane.setRowHeaderView(tln);

        editorWindow = new JFrame("TextEditor");
        editorWindow.setVisible(true);
        editorWindow.setExtendedState(Frame.MAXIMIZED_BOTH);
        editorWindow.setDefaultCloseOperation(EXIT_ON_CLOSE);

        //create menu bar
        editorWindow.setJMenuBar(createMenuBar());
        //editorWindow.add(scroll, BorderLayout.CENTER);
        editorWindow.add(scrollPane);
        editorWindow.pack();

        //application on center of screen
        editorWindow.setLocationRelativeTo(null);
        return editorWindow;
    }

    public void MyPanel() {
        frame = new JFrame("Customize");
        frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
        frame.getContentPane();
        frame.pack();
        frame.setSize(435, 266);
        frame.setVisible(true);


        //construct preComponents
        String[] jcomp1Items = {"Black", "White", "Gray", "Red", "Orange", "Yellow", "Green", "Blue", "Purple", "Pink"};
        String[] jcomp2Items = {"Black", "White", "Gray", "Red", "Orange", "Yellow", "Green", "Blue", "Purple", "Pink"};
        String[] jcomp5Items = {"Regular Document", "Java", "C/C++", "Assembly", "HTML"};

        //construct components
        jcomp1 = new JComboBox(jcomp1Items);
        jcomp2 = new JComboBox(jcomp2Items);
        jcomp3 = new JLabel("Background Color");
        jcomp4 = new JLabel("Text Color");
        jcomp5 = new JComboBox(jcomp5Items);
        jcomp6 = new JLabel("Color Scheme");
        jcomp7 = new JLabel("Various ways to customize Notepad - -");

        //adjust size and set layout
        frame.setPreferredSize(new Dimension(435, 266));
        frame.setLayout(null);

        //add components
        frame.add(jcomp1);
        frame.add(jcomp2);
        frame.add(jcomp3);
        frame.add(jcomp4);
        frame.add(jcomp5);
        frame.add(jcomp6);
        frame.add(jcomp7);

        //set component bounds (only needed by Absolute Positioning)
        jcomp1.setBounds(70, 105, 100, 25);
        jcomp2.setBounds(270, 105, 100, 25);
        jcomp3.setBounds(60, 70, 130, 25);
        jcomp4.setBounds(280, 70, 100, 25);
        jcomp5.setBounds(130, 200, 175, 25);
        jcomp6.setBounds(165, 165, 100, 25);
        jcomp7.setBounds(75, 10, 290, 45);


        jcomp1.setSelectedIndex(1);
        jcomp1.addActionListener(this);

        jcomp2.setSelectedIndex(1);
        jcomp2.addActionListener(this);

        jcomp5.setSelectedIndex(1);
        jcomp5.addActionListener(this);

    }


    //method for saving files
    private void saveFile(File filename) {

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
            writer.write(textArea.getText());
            writer.close();
            saved = true;
            window.setTitle("JavaText - " + filename.getName());
        }

        catch (IOException err) {
            err.printStackTrace();
        }
    }

    //method for opening files
    private void openFile(File filename) {

        try {
            openedFile = filename;
            FileReader reader = new FileReader(filename);
            textArea.read(reader, null);
            opened = true;
            window.setTitle("JavaEdit - " + filename.getName());
        }

        catch (IOException err) {
            err.printStackTrace();
        }
    }

    // method to perform a specific action
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == newFile) {
            new TextEditor();
        }

        else if (e.getSource() == open) {
            JFileChooser open = new JFileChooser();
            open.showOpenDialog(null);
            File file = open.getSelectedFile();
            openFile(file);
        }

        else if (e.getSource() == save) {
            JFileChooser save = new JFileChooser();
            File filename = save.getSelectedFile();

            if (opened == false && saved == false) {
                save.showSaveDialog(null);
                int confirmationResult;

                if (filename.exists()) {
                    confirmationResult = JOptionPane.showConfirmDialog(save, "Replace existing file?");

                    if (confirmationResult == JOptionPane.YES_OPTION) {
                        saveFile(filename);
                    }
                }

                else {
                    saveFile(filename);
                }
            }
        }

        else if (e.getSource() == saveAs) {
            JFileChooser saveAs = new JFileChooser();
            saveAs.showSaveDialog(null);
            File filename = saveAs.getSelectedFile();
            int confirmationResult;

            if (filename.exists()) {
                confirmationResult = JOptionPane.showConfirmDialog(saveAs, "Replace existing file?");

                if (confirmationResult == JOptionPane.YES_OPTION) {
                    saveFile(filename);
                }
            }
            else {
                saveFile(filename);
            }
        }

        else if (e.getSource() == customize) {
            MyPanel();
        }

        else if (e.getSource() == jcomp1) {
            JComboBox cb = (JComboBox) e.getSource();
            String color = (String) cb.getSelectedItem();

            switch (color) {
                case "Black":
                    textArea.setBackground(Color.BLACK);
                    break;

                case "White":
                    textArea.setBackground(Color.WHITE);
                    break;

                case "Gray":
                    textArea.setBackground(Color.GRAY);
                    break;

                case "Red":
                    textArea.setBackground(Color.RED);
                    break;

                case "Orange":
                    textArea.setBackground(Color.ORANGE);
                    break;

                case "Yellow":
                    textArea.setBackground(Color.YELLOW);
                    break;

                case "Green":
                    textArea.setBackground(Color.GREEN);
                    break;

                case "Blue":
                    textArea.setBackground(Color.BLUE);
                    break;

                case "Purple":
                    textArea.setBackground(Color.MAGENTA);
                    break;

                case "Pink":
                    textArea.setBackground(Color.PINK);
                    break;
            }
        }

        else if (e.getSource() == jcomp2) {
            JComboBox cb = (JComboBox) e.getSource();
            String color = (String) cb.getSelectedItem();

            switch (color) {
                case "Black":
                    textArea.setForeground(Color.BLACK);
                    break;

                case "White":
                    textArea.setForeground(Color.WHITE);
                    break;

                case "Gray":
                    textArea.setForeground(Color.GRAY);
                    break;

                case "Red":
                    textArea.setForeground(Color.RED);
                    break;

                case "Orange":
                    textArea.setForeground(Color.ORANGE);
                    break;

                case "Yellow":
                    textArea.setForeground(Color.YELLOW);
                    break;

                case "Green":
                    textArea.setForeground(Color.GREEN);
                    break;

                case "Blue":
                    textArea.setForeground(Color.BLUE);
                    break;

                case "Purple":
                    textArea.setForeground(Color.MAGENTA);
                    break;

                case "Pink":
                    textArea.setForeground(Color.PINK);
                    break;
            }
        }

        //{"Regular Document", "Java", "C/C++", "Assembly", "HTML"};
        else if (e.getSource() == jcomp5) {
            JComboBox cb = (JComboBox) e.getSource();
            String color = (String) cb.getSelectedItem();

            switch (color) {
                case "Regular Document":
                    textArea.setBackground(Color.WHITE);
                    textArea.setForeground(Color.BLACK);

                case "Java":
                    textArea.setBackground(Color.DARK_GRAY);
                    textArea.setForeground(Color.WHITE);
                    String text = textArea.getText();

                    //if(textArea.getText(0,4).equals("from")){

                        //textArea.setBackground(Color.RED);
                    //}

                    break;
                case "C/C++":
                    textArea.setBackground(Color.DARK_GRAY);
                    textArea.setForeground(Color.WHITE);
                    break;
                case "Assembly":
                    textArea.setBackground(Color.DARK_GRAY);
                    textArea.setForeground(Color.WHITE);
                    break;
                case "HTML":
                    textArea.setBackground(Color.DARK_GRAY);
                    textArea.setForeground(Color.WHITE);
                    break;
            }
        }

        else if (e.getSource() == delete) {
            textArea.replaceSelection("");
        }

        else if (e.getSource() == selectAll) {
            textArea.selectAll();
        }

        else if (e.getSource() == copy) {
            textArea.copy();
        }

        else if (e.getSource() == paste) {
            textArea.paste();
        }

        else if (e.getSource() == cut) {
            textArea.cut();
        }
    }
