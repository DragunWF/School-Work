namespace OrganizationProfile
{
    partial class frmRegistration
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
            txtStudentNo = new TextBox();
            txtLastName = new TextBox();
            txtAge = new TextBox();
            txtMiddleInitial = new TextBox();
            label1 = new Label();
            label2 = new Label();
            label3 = new Label();
            label4 = new Label();
            txtFirstName = new TextBox();
            label5 = new Label();
            label6 = new Label();
            btnRegister = new Button();
            label7 = new Label();
            datePickerBirthday = new DateTimePicker();
            cbPrograms = new ComboBox();
            label8 = new Label();
            label9 = new Label();
            cbGender = new ComboBox();
            label10 = new Label();
            txtContactNo = new TextBox();
            SuspendLayout();
            // 
            // txtStudentNo
            // 
            txtStudentNo.Location = new Point(88, 61);
            txtStudentNo.Name = "txtStudentNo";
            txtStudentNo.Size = new Size(114, 23);
            txtStudentNo.TabIndex = 0;
            // 
            // txtLastName
            // 
            txtLastName.Location = new Point(88, 96);
            txtLastName.Name = "txtLastName";
            txtLastName.Size = new Size(114, 23);
            txtLastName.TabIndex = 1;
            // 
            // txtAge
            // 
            txtAge.Location = new Point(88, 132);
            txtAge.Name = "txtAge";
            txtAge.Size = new Size(90, 23);
            txtAge.TabIndex = 2;
            // 
            // txtMiddleInitial
            // 
            txtMiddleInitial.Location = new Point(431, 96);
            txtMiddleInitial.Name = "txtMiddleInitial";
            txtMiddleInitial.Size = new Size(55, 23);
            txtMiddleInitial.TabIndex = 4;
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Font = new Font("Segoe UI", 21.75F, FontStyle.Bold, GraphicsUnit.Point, 0);
            label1.Location = new Point(18, 9);
            label1.Name = "label1";
            label1.Size = new Size(184, 40);
            label1.TabIndex = 5;
            label1.Text = "Registration";
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Location = new Point(19, 64);
            label2.Name = "label2";
            label2.Size = new Size(70, 15);
            label2.TabIndex = 6;
            label2.Text = "Student No.";
            // 
            // label3
            // 
            label3.AutoSize = true;
            label3.Location = new Point(19, 99);
            label3.Name = "label3";
            label3.Size = new Size(63, 15);
            label3.TabIndex = 7;
            label3.Text = "Last Name";
            // 
            // label4
            // 
            label4.AutoSize = true;
            label4.Location = new Point(54, 135);
            label4.Name = "label4";
            label4.Size = new Size(28, 15);
            label4.TabIndex = 8;
            label4.Text = "Age";
            // 
            // txtFirstName
            // 
            txtFirstName.Location = new Point(278, 96);
            txtFirstName.Name = "txtFirstName";
            txtFirstName.Size = new Size(114, 23);
            txtFirstName.TabIndex = 9;
            // 
            // label5
            // 
            label5.AutoSize = true;
            label5.Location = new Point(208, 99);
            label5.Name = "label5";
            label5.Size = new Size(64, 15);
            label5.TabIndex = 10;
            label5.Text = "First Name";
            // 
            // label6
            // 
            label6.AutoSize = true;
            label6.Location = new Point(398, 99);
            label6.Name = "label6";
            label6.Size = new Size(27, 15);
            label6.TabIndex = 11;
            label6.Text = "M.I.";
            // 
            // btnRegister
            // 
            btnRegister.BackColor = SystemColors.ButtonHighlight;
            btnRegister.Location = new Point(219, 219);
            btnRegister.Name = "btnRegister";
            btnRegister.Size = new Size(86, 33);
            btnRegister.TabIndex = 12;
            btnRegister.Text = "Register";
            btnRegister.UseVisualStyleBackColor = false;
            btnRegister.Click += btnRegister_Click;
            // 
            // label7
            // 
            label7.AutoSize = true;
            label7.Font = new Font("Segoe UI", 9F);
            label7.Location = new Point(31, 176);
            label7.Name = "label7";
            label7.Size = new Size(51, 15);
            label7.TabIndex = 13;
            label7.Text = "Birthday";
            // 
            // datePickerBirthday
            // 
            datePickerBirthday.CalendarFont = new Font("Segoe UI", 8F);
            datePickerBirthday.Font = new Font("Segoe UI", 8F);
            datePickerBirthday.Location = new Point(88, 176);
            datePickerBirthday.Name = "datePickerBirthday";
            datePickerBirthday.Size = new Size(206, 22);
            datePickerBirthday.TabIndex = 14;
            // 
            // cbPrograms
            // 
            cbPrograms.FormattingEnabled = true;
            cbPrograms.Location = new Point(278, 61);
            cbPrograms.Name = "cbPrograms";
            cbPrograms.Size = new Size(208, 23);
            cbPrograms.TabIndex = 15;
            // 
            // label8
            // 
            label8.AutoSize = true;
            label8.Location = new Point(219, 64);
            label8.Name = "label8";
            label8.Size = new Size(53, 15);
            label8.TabIndex = 16;
            label8.Text = "Program";
            // 
            // label9
            // 
            label9.AutoSize = true;
            label9.Location = new Point(219, 135);
            label9.Name = "label9";
            label9.Size = new Size(48, 15);
            label9.TabIndex = 17;
            label9.Text = "Gender:";
            // 
            // cbGender
            // 
            cbGender.FormattingEnabled = true;
            cbGender.Location = new Point(278, 132);
            cbGender.Name = "cbGender";
            cbGender.Size = new Size(89, 23);
            cbGender.TabIndex = 18;
            // 
            // label10
            // 
            label10.AutoSize = true;
            label10.Font = new Font("Segoe UI", 9F);
            label10.Location = new Point(300, 176);
            label10.Name = "label10";
            label10.Size = new Size(71, 15);
            label10.TabIndex = 19;
            label10.Text = "Contact No.";
            // 
            // txtContactNo
            // 
            txtContactNo.Location = new Point(377, 173);
            txtContactNo.Name = "txtContactNo";
            txtContactNo.Size = new Size(109, 23);
            txtContactNo.TabIndex = 20;
            // 
            // frmRegistration
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(500, 269);
            Controls.Add(txtContactNo);
            Controls.Add(label10);
            Controls.Add(cbGender);
            Controls.Add(label9);
            Controls.Add(label8);
            Controls.Add(cbPrograms);
            Controls.Add(datePickerBirthday);
            Controls.Add(label7);
            Controls.Add(btnRegister);
            Controls.Add(label6);
            Controls.Add(label5);
            Controls.Add(txtFirstName);
            Controls.Add(label4);
            Controls.Add(label3);
            Controls.Add(label2);
            Controls.Add(label1);
            Controls.Add(txtMiddleInitial);
            Controls.Add(txtAge);
            Controls.Add(txtLastName);
            Controls.Add(txtStudentNo);
            Name = "frmRegistration";
            Text = "Organization Profile";
            Load += frmRegistration_Load;
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private TextBox txtStudentNo;
        private TextBox txtLastName;
        private TextBox txtAge;
        private TextBox txtMiddleInitial;
        private Label label1;
        private Label label2;
        private Label label3;
        private Label label4;
        private TextBox txtFirstName;
        private Label label5;
        private Label label6;
        private Button btnRegister;
        private Label label7;
        private DateTimePicker datePickerBirthday;
        private ComboBox cbPrograms;
        private Label label8;
        private Label label9;
        private ComboBox cbGender;
        private Label label10;
        private TextBox txtContactNo;
    }
}
