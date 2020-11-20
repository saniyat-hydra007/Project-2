import java.awt.BorderLayout;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class LoginSystem extends JFrame {
    JPanel pText, pBody, pfooter;
    JButton log, InfoAdder;
    JLabel jl=new JLabel();
    JLabel jl2=new JLabel();
    JLabel jl3=new JLabel();
    JLabel jl4=new JLabel();
    JTextField jtf1, jtf2, jtf3;
    JTextField jtf, src;
    Container contentpane;
    String name, email, password;

    public LoginSystem() throws FileNotFoundException {
        super("My Login System");
        contentpane = getContentPane();
        contentpane.setLayout(new BorderLayout());
        pText = new JPanel();
        pBody = new JPanel();
        pfooter = new JPanel();

        jtf1 = new JTextField(25);
        jtf2 = new JTextField(25);
        jtf3 = new JTextField(17);

        jtf = new JTextField(15);
        src = new JTextField(15);


// Set BorderLayout for the panel, add label
        jl.setText("Name");
        pBody.add(jl);
        pBody.add(jtf1, BorderLayout.CENTER);
        jl2.setText("Email");
        pBody.add(jl2);
        pBody.add(jtf2, BorderLayout.CENTER);
        jl3.setText("Password");
        pBody.add(jl3);
        pBody.add(jtf3, BorderLayout.CENTER);


        InfoAdder = new JButton("Registation");
        log = new JButton("Sign In");


        pBody.add(InfoAdder, BorderLayout.CENTER);
        pfooter.add(log);

        contentpane.add(pText, BorderLayout.NORTH);
        contentpane.add(pBody, BorderLayout.CENTER);
        contentpane.add(pfooter, BorderLayout.SOUTH);

        setSize(700, 300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

//add new info
        InfoAdder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                name = jtf1.getText().trim();
                String data = name;

                email = jtf2.getText().trim();
                String data2 = email;

                password = jtf3.getText().trim();
                String data3 = password;
                try {
                    FileWriter reader = new FileWriter("Information.txt", true);
                    reader.write(data2 + " " + data3 + " " + data + "\n");
                    reader.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });

        log.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                Project1 p2 = new Project1();
            }

        });
    }


    public static void main(String[] args) throws FileNotFoundException {
        new LoginSystem();
    }
}

   class Project1 {
        JFrame f1 = new JFrame("Log In");
        String found2, found3;
        JPanel pbody = new JPanel();


        Project1() {
            JTextField mail;
            JTextField pass;
            JTextArea show;

            JLabel l=new JLabel();
            JLabel l2=new JLabel();
            JButton jb1 = new JButton("login");

            mail = new JTextField(20);
            pass = new JTextField(15);

            show=new JTextArea(10,20);


            jb1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    found2 = mail.getText().trim();
                    String data2 = found2;

                    found3=pass.getText().trim();
                    String data3=found3;

                    try {
                        FileInputStream f = new FileInputStream("Information.txt");
                        Scanner reader2 = new Scanner(f);
                        String search = reader2.toString();
                        while (reader2.hasNextLine()) {
                            String s = reader2.nextLine();
                            String str[] = s.split(" ");

                            if (data2.equals(str[0].trim()) && data3.equals(str[1].trim())) {
                                show.setText("Login Successful");
                            }
                        else {
                            show.setText("Login Unsuccessful");
                        }

                        }
                        reader2.close();
                    } catch (IOException exception) {
                        exception.printStackTrace();
                    }
                    }
            });
                    l.setText("Email");
                    pbody.add(l);
                    pbody.add(mail, BorderLayout.CENTER);
                    l2.setText("Password");
                    pbody.add(l2);
                    pbody.add(pass, BorderLayout.CENTER);
                    pbody.add(jb1, BorderLayout.PAGE_END);
                    pbody.add(show,BorderLayout.SOUTH);

                    f1.setVisible(true);
                    f1.setContentPane(pbody);
                    f1.setSize(600, 400);
                    f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                }


        }
