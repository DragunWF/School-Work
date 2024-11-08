namespace ChallengeApp
{
    partial class FrmRegistration
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
            txtStudentNo = new TextBox();
            label2 = new Label();
            label3 = new Label();
            txtLastName = new TextBox();
            label4 = new Label();
            txtAge = new TextBox();
            label5 = new Label();
            label6 = new Label();
            label7 = new Label();
            label8 = new Label();
            txtFirstName = new TextBox();
            dtpBirthday = new DateTimePicker();
            label9 = new Label();
            cbProgram = new ComboBox();
            cbGender = new ComboBox();
            label10 = new Label();
            txtMI = new TextBox();
            txtContactNo = new TextBox();
            btnRegister = new Button();
            btnRecords = new Button();
            SuspendLayout();
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Font = new Font("Segoe UI", 18F, FontStyle.Regular, GraphicsUnit.Point, 0);
            label1.Location = new Point(12, 9);
            label1.Name = "label1";
            label1.Size = new Size(140, 32);
            label1.TabIndex = 0;
            label1.Text = "Registration";
            // 
            // txtStudentNo
            // 
            txtStudentNo.Location = new Point(95, 59);
            txtStudentNo.Name = "txtStudentNo";
            txtStudentNo.Size = new Size(120, 23);
            txtStudentNo.TabIndex = 1;
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Font = new Font("Segoe UI", 9.75F, FontStyle.Regular, GraphicsUnit.Point, 0);
            label2.Location = new Point(12, 60);
            label2.Name = "label2";
            label2.Size = new Size(77, 17);
            label2.TabIndex = 2;
            label2.Text = "Student No.";
            // 
            // label3
            // 
            label3.AutoSize = true;
            label3.Font = new Font("Segoe UI", 9.75F, FontStyle.Regular, GraphicsUnit.Point, 0);
            label3.Location = new Point(19, 94);
            label3.Name = "label3";
            label3.Size = new Size(70, 17);
            label3.TabIndex = 3;
            label3.Text = "Last Name";
            // 
            // txtLastName
            // 
            txtLastName.Location = new Point(95, 93);
            txtLastName.Name = "txtLastName";
            txtLastName.Size = new Size(120, 23);
            txtLastName.TabIndex = 4;
            // 
            // label4
            // 
            label4.AutoSize = true;
            label4.Font = new Font("Segoe UI", 9.75F, FontStyle.Regular, GraphicsUnit.Point, 0);
            label4.Location = new Point(58, 126);
            label4.Name = "label4";
            label4.Size = new Size(31, 17);
            label4.TabIndex = 5;
            label4.Text = "Age";
            // 
            // txtAge
            // 
            txtAge.Location = new Point(95, 126);
            txtAge.Name = "txtAge";
            txtAge.Size = new Size(120, 23);
            txtAge.TabIndex = 6;
            // 
            // label5
            // 
            label5.AutoSize = true;
            label5.Font = new Font("Segoe UI", 9.75F, FontStyle.Regular, GraphicsUnit.Point, 0);
            label5.Location = new Point(34, 178);
            label5.Name = "label5";
            label5.Size = new Size(55, 17);
            label5.TabIndex = 7;
            label5.Text = "Birthday";
            // 
            // label6
            // 
            label6.AutoSize = true;
            label6.Font = new Font("Segoe UI", 9.75F, FontStyle.Regular, GraphicsUnit.Point, 0);
            label6.Location = new Point(232, 60);
            label6.Name = "label6";
            label6.Size = new Size(59, 17);
            label6.TabIndex = 8;
            label6.Text = "Program";
            // 
            // label7
            // 
            label7.AutoSize = true;
            label7.Font = new Font("Segoe UI", 9.75F, FontStyle.Regular, GraphicsUnit.Point, 0);
            label7.Location = new Point(224, 94);
            label7.Name = "label7";
            label7.Size = new Size(71, 17);
            label7.TabIndex = 9;
            label7.Text = "First Name";
            // 
            // label8
            // 
            label8.AutoSize = true;
            label8.Font = new Font("Segoe UI", 9.75F, FontStyle.Regular, GraphicsUnit.Point, 0);
            label8.Location = new Point(237, 127);
            label8.Name = "label8";
            label8.Size = new Size(54, 17);
            label8.TabIndex = 10;
            label8.Text = "Gender:";
            // 
            // txtFirstName
            // 
            txtFirstName.Location = new Point(298, 93);
            txtFirstName.Name = "txtFirstName";
            txtFirstName.Size = new Size(120, 23);
            txtFirstName.TabIndex = 11;
            // 
            // dtpBirthday
            // 
            dtpBirthday.Location = new Point(95, 174);
            dtpBirthday.Name = "dtpBirthday";
            dtpBirthday.Size = new Size(200, 23);
            dtpBirthday.TabIndex = 12;
            // 
            // label9
            // 
            label9.AutoSize = true;
            label9.Font = new Font("Segoe UI", 9.75F, FontStyle.Regular, GraphicsUnit.Point, 0);
            label9.Location = new Point(301, 175);
            label9.Name = "label9";
            label9.Size = new Size(77, 17);
            label9.TabIndex = 13;
            label9.Text = "Contact No.";
            // 
            // cbProgram
            // 
            cbProgram.FormattingEnabled = true;
            cbProgram.Items.AddRange(new object[] { "BS Information Technology", "BS Computer Science", "BS Information Systems", "BS Accounting" });
            cbProgram.Location = new Point(297, 59);
            cbProgram.Name = "cbProgram";
            cbProgram.Size = new Size(218, 23);
            cbProgram.TabIndex = 14;
            // 
            // cbGender
            // 
            cbGender.FormattingEnabled = true;
            cbGender.Items.AddRange(new object[] { "Male", "Female" });
            cbGender.Location = new Point(298, 127);
            cbGender.Name = "cbGender";
            cbGender.Size = new Size(121, 23);
            cbGender.TabIndex = 15;
            // 
            // label10
            // 
            label10.AutoSize = true;
            label10.Location = new Point(424, 96);
            label10.Name = "label10";
            label10.Size = new Size(24, 15);
            label10.TabIndex = 16;
            label10.Text = "M.I";
            // 
            // txtMI
            // 
            txtMI.Location = new Point(454, 93);
            txtMI.Name = "txtMI";
            txtMI.Size = new Size(61, 23);
            txtMI.TabIndex = 17;
            // 
            // txtContactNo
            // 
            txtContactNo.Location = new Point(384, 174);
            txtContactNo.Name = "txtContactNo";
            txtContactNo.Size = new Size(131, 23);
            txtContactNo.TabIndex = 18;
            // 
            // btnRegister
            // 
            btnRegister.Location = new Point(251, 211);
            btnRegister.Name = "btnRegister";
            btnRegister.Size = new Size(79, 29);
            btnRegister.TabIndex = 19;
            btnRegister.Text = "Register";
            btnRegister.UseVisualStyleBackColor = true;
            btnRegister.Click += btnRegister_Click;
            // 
            // btnRecords
            // 
            btnRecords.Location = new Point(440, 212);
            btnRecords.Name = "btnRecords";
            btnRecords.Size = new Size(75, 28);
            btnRecords.TabIndex = 20;
            btnRecords.Text = "Records";
            btnRecords.UseVisualStyleBackColor = true;
            btnRecords.Click += btnRecords_Click;
            // 
            // FrmRegistration
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(537, 252);
            Controls.Add(btnRecords);
            Controls.Add(btnRegister);
            Controls.Add(txtContactNo);
            Controls.Add(txtMI);
            Controls.Add(label10);
            Controls.Add(cbGender);
            Controls.Add(cbProgram);
            Controls.Add(label9);
            Controls.Add(dtpBirthday);
            Controls.Add(txtFirstName);
            Controls.Add(label8);
            Controls.Add(label7);
            Controls.Add(label6);
            Controls.Add(label5);
            Controls.Add(txtAge);
            Controls.Add(label4);
            Controls.Add(txtLastName);
            Controls.Add(label3);
            Controls.Add(label2);
            Controls.Add(txtStudentNo);
            Controls.Add(label1);
            Name = "FrmRegistration";
            Text = "FrmRegistration";
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Label label1;
        private TextBox txtStudentNo;
        private Label label2;
        private Label label3;
        private TextBox txtLastName;
        private Label label4;
        private TextBox txtAge;
        private Label label5;
        private Label label6;
        private Label label7;
        private Label label8;
        private TextBox txtFirstName;
        private DateTimePicker dtpBirthday;
        private Label label9;
        private ComboBox cbProgram;
        private ComboBox cbGender;
        private Label label10;
        private TextBox txtMI;
        private TextBox txtContactNo;
        private Button btnRegister;
        private Button btnRecords;
    }
}
