namespace StudentInfoApplication
{
    partial class frmStudentInfo
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
            idBox = new TextBox();
            lastNameBox = new TextBox();
            firstNameBox = new TextBox();
            label1 = new Label();
            label2 = new Label();
            label3 = new Label();
            SubmitButton = new Button();
            lastNameListBox = new ListBox();
            firstNameListBox = new ListBox();
            idListBox = new ListBox();
            label4 = new Label();
            label5 = new Label();
            label6 = new Label();
            SuspendLayout();
            // 
            // idBox
            // 
            idBox.Location = new Point(12, 39);
            idBox.Name = "idBox";
            idBox.Size = new Size(101, 23);
            idBox.TabIndex = 0;
            // 
            // lastNameBox
            // 
            lastNameBox.Location = new Point(119, 39);
            lastNameBox.Name = "lastNameBox";
            lastNameBox.Size = new Size(101, 23);
            lastNameBox.TabIndex = 1;
            // 
            // firstNameBox
            // 
            firstNameBox.Location = new Point(226, 39);
            firstNameBox.Name = "firstNameBox";
            firstNameBox.Size = new Size(101, 23);
            firstNameBox.TabIndex = 2;
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Location = new Point(12, 21);
            label1.Name = "label1";
            label1.Size = new Size(70, 15);
            label1.TabIndex = 3;
            label1.Text = "Student ID *";
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Location = new Point(119, 21);
            label2.Name = "label2";
            label2.Size = new Size(69, 15);
            label2.TabIndex = 4;
            label2.Text = "Last name *";
            // 
            // label3
            // 
            label3.AutoSize = true;
            label3.Location = new Point(226, 21);
            label3.Name = "label3";
            label3.Size = new Size(70, 15);
            label3.TabIndex = 5;
            label3.Text = "First name *";
            // 
            // SubmitButton
            // 
            SubmitButton.Location = new Point(252, 68);
            SubmitButton.Name = "SubmitButton";
            SubmitButton.Size = new Size(75, 23);
            SubmitButton.TabIndex = 6;
            SubmitButton.Text = "Submit";
            SubmitButton.UseVisualStyleBackColor = true;
            SubmitButton.Click += SubmitButton_Click;
            // 
            // lastNameListBox
            // 
            lastNameListBox.FormattingEnabled = true;
            lastNameListBox.ItemHeight = 15;
            lastNameListBox.Location = new Point(227, 118);
            lastNameListBox.Name = "lastNameListBox";
            lastNameListBox.Size = new Size(101, 124);
            lastNameListBox.TabIndex = 7;
            // 
            // firstNameListBox
            // 
            firstNameListBox.FormattingEnabled = true;
            firstNameListBox.ItemHeight = 15;
            firstNameListBox.Location = new Point(119, 118);
            firstNameListBox.Name = "firstNameListBox";
            firstNameListBox.Size = new Size(101, 124);
            firstNameListBox.TabIndex = 8;
            // 
            // idListBox
            // 
            idListBox.FormattingEnabled = true;
            idListBox.ItemHeight = 15;
            idListBox.Location = new Point(12, 118);
            idListBox.Name = "idListBox";
            idListBox.Size = new Size(101, 124);
            idListBox.TabIndex = 9;
            // 
            // label4
            // 
            label4.AutoSize = true;
            label4.Location = new Point(12, 100);
            label4.Name = "label4";
            label4.Size = new Size(83, 15);
            label4.TabIndex = 10;
            label4.Text = "Student ID List";
            // 
            // label5
            // 
            label5.AutoSize = true;
            label5.Location = new Point(119, 100);
            label5.Name = "label5";
            label5.Size = new Size(85, 15);
            label5.TabIndex = 11;
            label5.Text = "First Name List";
            // 
            // label6
            // 
            label6.AutoSize = true;
            label6.Location = new Point(227, 100);
            label6.Name = "label6";
            label6.Size = new Size(84, 15);
            label6.TabIndex = 12;
            label6.Text = "Last Name List";
            // 
            // frmStudentInfo
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(340, 254);
            Controls.Add(label6);
            Controls.Add(label5);
            Controls.Add(label4);
            Controls.Add(idListBox);
            Controls.Add(firstNameListBox);
            Controls.Add(lastNameListBox);
            Controls.Add(SubmitButton);
            Controls.Add(label3);
            Controls.Add(label2);
            Controls.Add(label1);
            Controls.Add(firstNameBox);
            Controls.Add(lastNameBox);
            Controls.Add(idBox);
            Name = "frmStudentInfo";
            Text = "Student Info";
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private TextBox idBox;
        private TextBox lastNameBox;
        private TextBox firstNameBox;
        private Label label1;
        private Label label2;
        private Label label3;
        private Button SubmitButton;
        private ListBox lastNameListBox;
        private ListBox firstNameListBox;
        private ListBox idListBox;
        private Label label4;
        private Label label5;
        private Label label6;
    }
}
