namespace EmployeeApplication
{
    partial class frmComputeSalary
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
            label2 = new Label();
            firstNameTextBox = new TextBox();
            lastNameTextBox = new TextBox();
            departmentTextBox = new TextBox();
            jobTitleTextBox = new TextBox();
            label3 = new Label();
            label4 = new Label();
            rateTextBox = new TextBox();
            totalHoursTextBox = new TextBox();
            label5 = new Label();
            label6 = new Label();
            computeButton = new Button();
            firstNameText = new Label();
            lastNameText = new Label();
            basicSalaryText = new Label();
            SuspendLayout();
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Location = new Point(12, 9);
            label1.Name = "label1";
            label1.Size = new Size(62, 15);
            label1.TabIndex = 0;
            label1.Text = "First name";
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Location = new Point(160, 9);
            label2.Name = "label2";
            label2.Size = new Size(61, 15);
            label2.TabIndex = 1;
            label2.Text = "Last name";
            // 
            // firstNameTextBox
            // 
            firstNameTextBox.Location = new Point(12, 27);
            firstNameTextBox.Name = "firstNameTextBox";
            firstNameTextBox.Size = new Size(142, 23);
            firstNameTextBox.TabIndex = 2;
            // 
            // lastNameTextBox
            // 
            lastNameTextBox.Location = new Point(160, 27);
            lastNameTextBox.Name = "lastNameTextBox";
            lastNameTextBox.Size = new Size(142, 23);
            lastNameTextBox.TabIndex = 3;
            // 
            // departmentTextBox
            // 
            departmentTextBox.Location = new Point(12, 76);
            departmentTextBox.Name = "departmentTextBox";
            departmentTextBox.Size = new Size(142, 23);
            departmentTextBox.TabIndex = 4;
            // 
            // jobTitleTextBox
            // 
            jobTitleTextBox.Location = new Point(160, 76);
            jobTitleTextBox.Name = "jobTitleTextBox";
            jobTitleTextBox.Size = new Size(142, 23);
            jobTitleTextBox.TabIndex = 5;
            // 
            // label3
            // 
            label3.AutoSize = true;
            label3.Location = new Point(12, 58);
            label3.Name = "label3";
            label3.Size = new Size(70, 15);
            label3.TabIndex = 6;
            label3.Text = "Department";
            // 
            // label4
            // 
            label4.AutoSize = true;
            label4.Location = new Point(160, 58);
            label4.Name = "label4";
            label4.Size = new Size(48, 15);
            label4.TabIndex = 7;
            label4.Text = "Job title";
            // 
            // rateTextBox
            // 
            rateTextBox.Location = new Point(12, 150);
            rateTextBox.Name = "rateTextBox";
            rateTextBox.Size = new Size(142, 23);
            rateTextBox.TabIndex = 8;
            // 
            // totalHoursTextBox
            // 
            totalHoursTextBox.Location = new Point(160, 150);
            totalHoursTextBox.Name = "totalHoursTextBox";
            totalHoursTextBox.Size = new Size(142, 23);
            totalHoursTextBox.TabIndex = 9;
            // 
            // label5
            // 
            label5.AutoSize = true;
            label5.Location = new Point(12, 132);
            label5.Name = "label5";
            label5.Size = new Size(78, 15);
            label5.TabIndex = 10;
            label5.Text = "Rate per hour";
            // 
            // label6
            // 
            label6.AutoSize = true;
            label6.Location = new Point(160, 132);
            label6.Name = "label6";
            label6.Size = new Size(107, 15);
            label6.TabIndex = 11;
            label6.Text = "Total hours worked";
            // 
            // computeButton
            // 
            computeButton.Location = new Point(100, 179);
            computeButton.Name = "computeButton";
            computeButton.Size = new Size(108, 29);
            computeButton.TabIndex = 12;
            computeButton.Text = "Compute Salary";
            computeButton.UseVisualStyleBackColor = true;
            computeButton.Click += computeButton_Click;
            // 
            // firstNameText
            // 
            firstNameText.AutoSize = true;
            firstNameText.Location = new Point(38, 223);
            firstNameText.Name = "firstNameText";
            firstNameText.Size = new Size(169, 15);
            firstNameText.TabIndex = 13;
            firstNameText.Text = "First name:   <first name here>";
            // 
            // lastNameText
            // 
            lastNameText.AutoSize = true;
            lastNameText.Location = new Point(38, 247);
            lastNameText.Name = "lastNameText";
            lastNameText.Size = new Size(166, 15);
            lastNameText.TabIndex = 14;
            lastNameText.Text = "Last name:   <last name here>";
            // 
            // basicSalaryText
            // 
            basicSalaryText.AutoSize = true;
            basicSalaryText.Location = new Point(38, 271);
            basicSalaryText.Name = "basicSalaryText";
            basicSalaryText.Size = new Size(104, 15);
            basicSalaryText.TabIndex = 15;
            basicSalaryText.Text = "Basic Salary:  00.00";
            // 
            // frmComputeSalary
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(317, 307);
            Controls.Add(basicSalaryText);
            Controls.Add(lastNameText);
            Controls.Add(firstNameText);
            Controls.Add(computeButton);
            Controls.Add(label6);
            Controls.Add(label5);
            Controls.Add(totalHoursTextBox);
            Controls.Add(rateTextBox);
            Controls.Add(label4);
            Controls.Add(label3);
            Controls.Add(jobTitleTextBox);
            Controls.Add(departmentTextBox);
            Controls.Add(lastNameTextBox);
            Controls.Add(firstNameTextBox);
            Controls.Add(label2);
            Controls.Add(label1);
            Name = "frmComputeSalary";
            Text = "Employee Salary Calculator";
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Label label1;
        private Label label2;
        private TextBox firstNameTextBox;
        private TextBox lastNameTextBox;
        private TextBox departmentTextBox;
        private TextBox jobTitleTextBox;
        private Label label3;
        private Label label4;
        private TextBox rateTextBox;
        private TextBox totalHoursTextBox;
        private Label label5;
        private Label label6;
        private Button computeButton;
        private Label firstNameText;
        private Label lastNameText;
        private Label basicSalaryText;
    }
}
