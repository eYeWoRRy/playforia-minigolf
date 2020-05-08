package agolf;

import java.awt.*;
import java.awt.event.*;
import java.util.regex.Pattern;

class TrackTestLoginPanel extends Panel implements ActionListener, KeyListener {

    private GameApplet gameApplet;
    private int width;
    private int height;
    private TextField textFieldName;
    private TextField textFieldPassword;
    private Button buttonOk;
    private Label labelError;
    private Pattern pattern;
    private Label labelName;
    private Label labelName2;
    private Label labelPassword;
    private Label labelPassword2;

    protected TrackTestLoginPanel(GameApplet gameApplet, int width, int height) {
        this.gameApplet = gameApplet;
        this.width = width;
        this.height = height;
        this.setSize(width, height);
        pattern = Pattern.compile("[^a-zA-Z0-9 ]");
        this.create();
    }

    public void addNotify() {
        super.addNotify();
        this.repaint();
    }

    public void paint(Graphics var1) {
        this.update(var1);
    }

    public void update(Graphics g) {
        g.setColor(GameApplet.colourGameBackground);
        g.fillRect(0, 0, this.width, this.height);
    }

    public void actionPerformed(ActionEvent evt) {
        String username = this.textFieldName.getText().trim();
        String password = this.textFieldPassword.getText().trim();
        //String password = '';
        this.gameApplet.trackTestLogin(username, password);

    }

    public void keyPressed(KeyEvent evt) {
        if(evt.getKeyCode() == KeyEvent.VK_ENTER && buttonOk.isEnabled()) {
            actionPerformed(null);
            return;
        }
        boolean found = pattern.matcher(textFieldName.getText()).find() || textFieldName.getText().trim().equals("");
        if(found) {
            labelError.setVisible(true);
            buttonOk.setEnabled(false);
        } else {
            labelError.setVisible(false);
            buttonOk.setEnabled(true);
        }
    }

    private void create() {
        this.setLayout(null);
        this.textFieldName = new TextField("");//("(name)");
        this.textFieldName.setBounds(this.width / 2 - 75, this.height / 2 - 60, 150, 25);
        this.textFieldName.setBackground(Color.white);
        this.textFieldName.setForeground(Color.black);
        textFieldName.addKeyListener(this);
        this.add(this.textFieldName);
        textFieldName.requestFocus();
        this.textFieldPassword = new TextField("");//("(password)");
        this.textFieldPassword.setBounds(this.width / 2 - 75, this.height / 2 - 10, 150, 25);
        this.textFieldPassword.setBackground(Color.white);
        this.textFieldPassword.setForeground(Color.black);
        textFieldPassword.setEchoChar('*');
        //this.add(this.textFieldPassword); //Don't show this field
        this.buttonOk = new Button("OK");
        this.buttonOk.setBounds(this.width / 2 - 75, this.height / 2 + 50, 75, 25);
        this.buttonOk.addActionListener(this);
        this.add(this.buttonOk);
        labelError = new Label("Only spaces, alphabetical and numerical characters are allowed");
        labelError.setBounds(width / 2 - 75, height / 2 - 35, 400, 25);
        labelError.setForeground(Color.red);
        labelError.setVisible(false);
        add(labelError);
        labelName = new Label("Nickname:");
        labelName.setBounds(width / 2 - 200, height / 2 - 60, 75, 25);
        add(labelName);
        //No more labels needed
        // labelName2 = new Label("");
        // labelName2.setBounds(width / 2 + 80, height / 2 - 60, 75, 25);
        // labelName2.setForeground(Color.red);
        // add(labelName2);
        // labelPassword = new Label("");
        // labelPassword.setBounds(width / 2 - 150, height / 2 - 10, 75, 25);
        // add(labelPassword);
        // labelPassword2 = new Label("");
        // labelPassword2.setBounds(width / 2 + 80, height / 2 - 10, 75, 25);
        // labelPassword2.setForeground(Color.red);
        // add(labelPassword2);
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }
}
