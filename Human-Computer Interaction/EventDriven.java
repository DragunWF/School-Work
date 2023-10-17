// ELMS - 05 HandsOnActivity 1, Human-Computer Interaction

public class EventDriven {
        public static void main(String[] args) {
                InputUI inputUI = new InputUI();
                inputUI.setVisible(true);
                inputUI.onReady();
        }
}

class InputUI extends javax.swing.JFrame {
        public InputUI() {
                initComponents();
                this.setTitle("INPUT");
        }

        private void initComponents() {
                jPanel1 = new javax.swing.JPanel();
                firstNameLabel = new javax.swing.JLabel();
                firstNameField = new javax.swing.JTextField();
                lastNameField = new javax.swing.JTextField();
                lastNameLabel = new javax.swing.JLabel();
                middleNameField = new javax.swing.JTextField();
                middleNameLabel = new javax.swing.JLabel();
                mobileNumberField = new javax.swing.JTextField();
                mobileNumberLabel = new javax.swing.JLabel();
                emailField = new javax.swing.JTextField();
                submitButton = new javax.swing.JButton();
                emailLabel = new javax.swing.JLabel();
                clearButton = new javax.swing.JButton();
                errorLabel = new javax.swing.JLabel();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

                jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

                firstNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                firstNameLabel.setText("First Name");

                lastNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                lastNameLabel.setText("Last Name");

                middleNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                middleNameLabel.setText("Middle Name");

                mobileNumberLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                mobileNumberLabel.setText("Mobile Number");

                submitButton.setText("Submit");
                submitButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                submitButtonActionPerformed(evt);
                        }
                });

                emailLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                emailLabel.setText("Email Address");

                clearButton.setText("Clear All");
                clearButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                clearButtonActionPerformed(evt);
                        }
                });

                errorLabel.setForeground(new java.awt.Color(255, 51, 51));
                errorLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                errorLabel.setText("You must fill all fields!");

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(47, 47, 47)
                                                                                                .addGroup(jPanel1Layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(errorLabel,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                168,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addGroup(jPanel1Layout
                                                                                                                                .createSequentialGroup()
                                                                                                                                .addGap(9, 9, 9)
                                                                                                                                .addComponent(submitButton)
                                                                                                                                .addPreferredGap(
                                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                                                                .addComponent(clearButton))))
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(78, 78, 78)
                                                                                                .addComponent(emailLabel,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                107,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout
                                                                .createSequentialGroup()
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                                                .addGroup(jPanel1Layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(mobileNumberLabel,
                                                                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                107,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(lastNameLabel,
                                                                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                107,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                jPanel1Layout
                                                                                                                .createSequentialGroup()
                                                                                                                .addGap(19, 19, 19)
                                                                                                                .addGroup(jPanel1Layout
                                                                                                                                .createParallelGroup(
                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                .addComponent(emailField,
                                                                                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                                                                .addGroup(jPanel1Layout
                                                                                                                                                .createSequentialGroup()
                                                                                                                                                .addGroup(jPanel1Layout
                                                                                                                                                                .createParallelGroup(
                                                                                                                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                                                                                                .addComponent(firstNameLabel,
                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                                105,
                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                                                .addComponent(firstNameField,
                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                                107,
                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                                                                .addPreferredGap(
                                                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                Short.MAX_VALUE)
                                                                                                                                                .addComponent(lastNameField,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                107,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                                                .addGroup(jPanel1Layout
                                                                                                                                                .createSequentialGroup()
                                                                                                                                                .addComponent(middleNameLabel,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                107,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                                                                                                .addGroup(jPanel1Layout
                                                                                                                                                .createSequentialGroup()
                                                                                                                                                .addComponent(middleNameField,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                107,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                                .addPreferredGap(
                                                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                Short.MAX_VALUE)
                                                                                                                                                .addComponent(mobileNumberField,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                107,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                                                .addGap(22, 22, 22)));
                jPanel1Layout.setVerticalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(lastNameLabel,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                14,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(firstNameLabel))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(firstNameField,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                26,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(lastNameField,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                26,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(middleNameLabel)
                                                                                .addComponent(mobileNumberLabel))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(middleNameField,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                26,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(mobileNumberField,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                26,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(10, 10, 10)
                                                                .addComponent(emailLabel)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(emailField,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                26,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(submitButton)
                                                                                .addComponent(clearButton))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(errorLabel)
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)));

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
                                                                .createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jPanel1,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
                                                                .createSequentialGroup()
                                                                .addGap(0, 24, Short.MAX_VALUE)
                                                                .addComponent(jPanel1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)));

                pack();
        }

        private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {
                String[] textFieldContents = {
                                firstNameField.getText(),
                                lastNameField.getText(),
                                middleNameField.getText(),
                                mobileNumberField.getText(),
                                emailField.getText(),
                };
                boolean valid = true;
                for (String content : textFieldContents) {
                        if (content.length() == 0) {
                                valid = false;
                                break;
                        }
                }
                if (valid) {
                        Data.setFirstName(textFieldContents[0]);
                        Data.setLastName(textFieldContents[1]);
                        Data.setMiddleName(textFieldContents[2]);
                        Data.setMobileNumber(textFieldContents[3]);
                        Data.setEmailAddress(textFieldContents[4]);

                        OutputUI obj = new OutputUI();
                        obj.setVisible(true);
                        obj.onReady();
                        this.dispose();
                } else {
                        errorLabel.setText("You must fill out all the fields!");
                }
        }

        private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {
                firstNameField.setText("");
                lastNameField.setText("");
                middleNameField.setText("");
                mobileNumberField.setText("");
                emailField.setText("");
        }

        public void onReady() {
                // Set Error label text to an empty string
                errorLabel.setText("");
        }

        // Variables declaration
        private javax.swing.JButton clearButton;
        private javax.swing.JTextField emailField;
        private javax.swing.JLabel emailLabel;
        private javax.swing.JLabel errorLabel;
        private javax.swing.JTextField firstNameField;
        private javax.swing.JLabel firstNameLabel;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JTextField lastNameField;
        private javax.swing.JLabel lastNameLabel;
        private javax.swing.JTextField middleNameField;
        private javax.swing.JLabel middleNameLabel;
        private javax.swing.JTextField mobileNumberField;
        private javax.swing.JLabel mobileNumberLabel;
        private javax.swing.JButton submitButton;
        // End of variables declaration
}

class OutputUI extends javax.swing.JFrame {
        public OutputUI() {
                initComponents();
                this.setTitle("OUTPUT");
        }

        private void initComponents() {
                jPanel1 = new javax.swing.JPanel();
                jLabel1 = new javax.swing.JLabel();
                jLabel2 = new javax.swing.JLabel();
                jLabel3 = new javax.swing.JLabel();
                jLabel4 = new javax.swing.JLabel();
                jLabel5 = new javax.swing.JLabel();
                firstNameOutput = new javax.swing.JLabel();
                lastNameOutput = new javax.swing.JLabel();
                middleNameOutput = new javax.swing.JLabel();
                mobileNumberOutput = new javax.swing.JLabel();
                emailOutput = new javax.swing.JLabel();
                okayButton = new javax.swing.JButton();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

                jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

                jLabel1.setText("First Name:");
                jLabel2.setText("Last Name:");
                jLabel3.setText("Middle Name:");
                jLabel4.setText("Mobile Number:");
                jLabel5.setText("Email Address:");
                firstNameOutput.setText("-");
                lastNameOutput.setText("-");
                middleNameOutput.setText("-");
                mobileNumberOutput.setText("-");
                emailOutput.setText("-");

                okayButton.setText("Okay");
                okayButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                okayButtonActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(jLabel1,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                89,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(firstNameOutput,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                157,
                                                                                                                Short.MAX_VALUE))
                                                                                .addComponent(okayButton,
                                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(jLabel5,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                89,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(emailOutput,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                Short.MAX_VALUE))
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(jLabel4,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                89,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(mobileNumberOutput,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                Short.MAX_VALUE))
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(jLabel3,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                89,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(middleNameOutput,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                Short.MAX_VALUE))
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(jLabel2,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                89,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(lastNameOutput,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                Short.MAX_VALUE)))
                                                                .addContainerGap()));
                jPanel1Layout.setVerticalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(27, 27, 27)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jLabel1)
                                                                                .addComponent(firstNameOutput))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jLabel2)
                                                                                .addComponent(lastNameOutput))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jLabel3)
                                                                                .addComponent(middleNameOutput))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jLabel4)
                                                                                .addComponent(mobileNumberOutput))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jLabel5)
                                                                                .addComponent(emailOutput))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(okayButton)
                                                                .addContainerGap(26, Short.MAX_VALUE)));

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jPanel1,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addContainerGap()));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jPanel1,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addContainerGap()));

                pack();
        }

        private void okayButtonActionPerformed(java.awt.event.ActionEvent evt) {
                this.dispose();
        }

        public void onReady() {
                firstNameOutput.setText(Data.getFirstName());
                lastNameOutput.setText(Data.getLastName());
                middleNameOutput.setText(Data.getMiddleName());
                mobileNumberOutput.setText(Data.getMobileNumber());
                emailOutput.setText(Data.getEmailAddress());
        }

        // Variables declaration
        private javax.swing.JLabel emailOutput;
        private javax.swing.JLabel firstNameOutput;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JLabel jLabel4;
        private javax.swing.JLabel jLabel5;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JLabel lastNameOutput;
        private javax.swing.JLabel middleNameOutput;
        private javax.swing.JLabel mobileNumberOutput;
        private javax.swing.JButton okayButton;
        // End of variables declaration
}

class Data {
        private static String firstName;
        private static String lastName;
        private static String middleName;
        private static String mobileNumber;
        private static String emailAddress;

        public static String getFirstName() {
                return firstName;
        }

        public static void setFirstName(String value) {
                firstName = value;
        }

        public static String getLastName() {
                return lastName;
        }

        public static void setLastName(String value) {
                lastName = value;
        }

        public static String getMiddleName() {
                return middleName;
        }

        public static void setMiddleName(String value) {
                middleName = value;
        }

        public static String getMobileNumber() {
                return mobileNumber;
        }

        public static void setMobileNumber(String value) {
                mobileNumber = value;
        }

        public static String getEmailAddress() {
                return emailAddress;
        }

        public static void setEmailAddress(String value) {
                emailAddress = value;
        }
}