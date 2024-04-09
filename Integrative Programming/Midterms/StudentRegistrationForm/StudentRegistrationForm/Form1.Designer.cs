namespace StudentRegistrationForm
{
    partial class Form1
    {
        /// <summary>
        ///  Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        ///  Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        ///  Required method for Designer support - do not modify
        ///  the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            label1 = new Label();
            lastNameText = new TextBox();
            firstNameText = new TextBox();
            middleNameText = new TextBox();
            label2 = new Label();
            label3 = new Label();
            label4 = new Label();
            label5 = new Label();
            maleRadioButton = new RadioButton();
            femaleRadioButton = new RadioButton();
            dayComboBox = new ComboBox();
            label6 = new Label();
            monthComboBox = new ComboBox();
            yearComboBox = new ComboBox();
            registerStudentButton = new Button();
            programComboBox = new ComboBox();
            label7 = new Label();
            SuspendLayout();
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Font = new Font("Segoe UI", 12.5F, FontStyle.Bold, GraphicsUnit.Point);
            label1.Location = new Point(10, 32);
            label1.Name = "label1";
            label1.Size = new Size(224, 23);
            label1.TabIndex = 0;
            label1.Text = "Student Registration Form";
            // 
            // lastNameText
            // 
            lastNameText.Location = new Point(12, 91);
            lastNameText.Name = "lastNameText";
            lastNameText.Size = new Size(218, 23);
            lastNameText.TabIndex = 1;
            // 
            // firstNameText
            // 
            firstNameText.Location = new Point(12, 139);
            firstNameText.Name = "firstNameText";
            firstNameText.Size = new Size(218, 23);
            firstNameText.TabIndex = 2;
            // 
            // middleNameText
            // 
            middleNameText.Location = new Point(12, 186);
            middleNameText.Name = "middleNameText";
            middleNameText.Size = new Size(218, 23);
            middleNameText.TabIndex = 3;
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Font = new Font("Segoe UI", 12F, FontStyle.Bold, GraphicsUnit.Point);
            label2.Location = new Point(10, 67);
            label2.Name = "label2";
            label2.Size = new Size(101, 21);
            label2.TabIndex = 4;
            label2.Text = "Last Name *";
            // 
            // label3
            // 
            label3.AutoSize = true;
            label3.Font = new Font("Segoe UI", 12F, FontStyle.Bold, GraphicsUnit.Point);
            label3.Location = new Point(10, 117);
            label3.Name = "label3";
            label3.Size = new Size(103, 21);
            label3.TabIndex = 5;
            label3.Text = "First Name *";
            // 
            // label4
            // 
            label4.AutoSize = true;
            label4.Font = new Font("Segoe UI", 12F, FontStyle.Bold, GraphicsUnit.Point);
            label4.Location = new Point(10, 165);
            label4.Name = "label4";
            label4.Size = new Size(125, 21);
            label4.TabIndex = 6;
            label4.Text = "Middle Name *";
            // 
            // label5
            // 
            label5.AutoSize = true;
            label5.Font = new Font("Segoe UI", 12F, FontStyle.Bold, GraphicsUnit.Point);
            label5.Location = new Point(10, 216);
            label5.Name = "label5";
            label5.Size = new Size(76, 21);
            label5.TabIndex = 7;
            label5.Text = "Gender *";
            // 
            // maleRadioButton
            // 
            maleRadioButton.AutoSize = true;
            maleRadioButton.Location = new Point(90, 219);
            maleRadioButton.Name = "maleRadioButton";
            maleRadioButton.Size = new Size(51, 19);
            maleRadioButton.TabIndex = 8;
            maleRadioButton.TabStop = true;
            maleRadioButton.Text = "Male";
            maleRadioButton.UseVisualStyleBackColor = true;
            // 
            // femaleRadioButton
            // 
            femaleRadioButton.AutoSize = true;
            femaleRadioButton.Location = new Point(147, 219);
            femaleRadioButton.Name = "femaleRadioButton";
            femaleRadioButton.Size = new Size(63, 19);
            femaleRadioButton.TabIndex = 9;
            femaleRadioButton.TabStop = true;
            femaleRadioButton.Text = "Female";
            femaleRadioButton.UseVisualStyleBackColor = true;
            // 
            // dayComboBox
            // 
            dayComboBox.FormattingEnabled = true;
            dayComboBox.Location = new Point(12, 272);
            dayComboBox.Name = "dayComboBox";
            dayComboBox.Size = new Size(53, 23);
            dayComboBox.TabIndex = 10;
            dayComboBox.Text = "-Day-";
            // 
            // label6
            // 
            label6.AutoSize = true;
            label6.Font = new Font("Segoe UI", 12F, FontStyle.Bold, GraphicsUnit.Point);
            label6.Location = new Point(10, 248);
            label6.Name = "label6";
            label6.Size = new Size(118, 21);
            label6.TabIndex = 11;
            label6.Text = "Date of Birth *";
            // 
            // monthComboBox
            // 
            monthComboBox.FormattingEnabled = true;
            monthComboBox.Location = new Point(71, 272);
            monthComboBox.Name = "monthComboBox";
            monthComboBox.Size = new Size(70, 23);
            monthComboBox.TabIndex = 12;
            monthComboBox.Text = "-Month-";
            // 
            // yearComboBox
            // 
            yearComboBox.FormattingEnabled = true;
            yearComboBox.Location = new Point(147, 272);
            yearComboBox.Name = "yearComboBox";
            yearComboBox.Size = new Size(80, 23);
            yearComboBox.TabIndex = 13;
            yearComboBox.Text = "-Year-";
            // 
            // registerStudentButton
            // 
            registerStudentButton.BackColor = Color.Crimson;
            registerStudentButton.ForeColor = SystemColors.ControlLightLight;
            registerStudentButton.Location = new Point(10, 359);
            registerStudentButton.Name = "registerStudentButton";
            registerStudentButton.Size = new Size(218, 35);
            registerStudentButton.TabIndex = 14;
            registerStudentButton.Text = "Register Student";
            registerStudentButton.UseVisualStyleBackColor = false;
            registerStudentButton.Click += OnRegisterStudent;
            // 
            // programComboBox
            // 
            programComboBox.FormattingEnabled = true;
            programComboBox.Location = new Point(13, 330);
            programComboBox.Name = "programComboBox";
            programComboBox.Size = new Size(214, 23);
            programComboBox.TabIndex = 15;
            programComboBox.Text = "-Select Program-";
            // 
            // label7
            // 
            label7.AutoSize = true;
            label7.Font = new Font("Segoe UI", 12F, FontStyle.Bold, GraphicsUnit.Point);
            label7.Location = new Point(10, 306);
            label7.Name = "label7";
            label7.Size = new Size(154, 21);
            label7.TabIndex = 16;
            label7.Text = "Program to apply *";
            // 
            // Form1
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(248, 423);
            Controls.Add(label7);
            Controls.Add(programComboBox);
            Controls.Add(registerStudentButton);
            Controls.Add(yearComboBox);
            Controls.Add(monthComboBox);
            Controls.Add(label6);
            Controls.Add(dayComboBox);
            Controls.Add(femaleRadioButton);
            Controls.Add(maleRadioButton);
            Controls.Add(label5);
            Controls.Add(label4);
            Controls.Add(label3);
            Controls.Add(label2);
            Controls.Add(middleNameText);
            Controls.Add(firstNameText);
            Controls.Add(lastNameText);
            Controls.Add(label1);
            Name = "Form1";
            Text = "Form1";
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Label label1;
        private TextBox lastNameText;
        private TextBox firstNameText;
        private TextBox middleNameText;
        private Label label2;
        private Label label3;
        private Label label4;
        private Label label5;
        private RadioButton maleRadioButton;
        private RadioButton femaleRadioButton;
        private ComboBox dayComboBox;
        private Label label6;
        private ComboBox monthComboBox;
        private ComboBox yearComboBox;
        private Button registerStudentButton;
        private ComboBox programComboBox;
        private Label label7;
    }
}
