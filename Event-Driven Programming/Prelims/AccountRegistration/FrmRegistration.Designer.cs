namespace AccountRegistration
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
            label2 = new Label();
            label3 = new Label();
            label4 = new Label();
            label5 = new Label();
            label6 = new Label();
            label7 = new Label();
            studentNoTextBox = new TextBox();
            lastNameTextBox = new TextBox();
            firstNameTextBox = new TextBox();
            ageTextBox = new TextBox();
            contactNoTextBox = new TextBox();
            middleNameTextBox = new TextBox();
            programComboBox = new ComboBox();
            label8 = new Label();
            addressRichTextBox = new RichTextBox();
            nextButton = new Button();
            SuspendLayout();
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Font = new Font("Segoe UI", 12F);
            label1.Location = new Point(12, 9);
            label1.Name = "label1";
            label1.Size = new Size(94, 21);
            label1.TabIndex = 0;
            label1.Text = "Student No.:";
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Font = new Font("Segoe UI", 12F);
            label2.Location = new Point(182, 9);
            label2.Name = "label2";
            label2.Size = new Size(74, 21);
            label2.TabIndex = 1;
            label2.Text = "Program:";
            // 
            // label3
            // 
            label3.AutoSize = true;
            label3.Font = new Font("Segoe UI", 12F);
            label3.Location = new Point(12, 69);
            label3.Name = "label3";
            label3.Size = new Size(84, 21);
            label3.TabIndex = 2;
            label3.Text = "Last Name";
            // 
            // label4
            // 
            label4.AutoSize = true;
            label4.Font = new Font("Segoe UI", 12F);
            label4.Location = new Point(182, 69);
            label4.Name = "label4";
            label4.Size = new Size(86, 21);
            label4.TabIndex = 3;
            label4.Text = "First Name";
            // 
            // label5
            // 
            label5.AutoSize = true;
            label5.Font = new Font("Segoe UI", 12F);
            label5.Location = new Point(348, 69);
            label5.Name = "label5";
            label5.Size = new Size(104, 21);
            label5.TabIndex = 4;
            label5.Text = "Middle Name";
            // 
            // label6
            // 
            label6.AutoSize = true;
            label6.Font = new Font("Segoe UI", 12F);
            label6.Location = new Point(12, 128);
            label6.Name = "label6";
            label6.Size = new Size(40, 21);
            label6.TabIndex = 5;
            label6.Text = "Age:";
            // 
            // label7
            // 
            label7.AutoSize = true;
            label7.Font = new Font("Segoe UI", 12F);
            label7.Location = new Point(182, 128);
            label7.Name = "label7";
            label7.Size = new Size(94, 21);
            label7.TabIndex = 6;
            label7.Text = "Contact No.:";
            // 
            // studentNoTextBox
            // 
            studentNoTextBox.Location = new Point(12, 33);
            studentNoTextBox.Name = "studentNoTextBox";
            studentNoTextBox.Size = new Size(151, 23);
            studentNoTextBox.TabIndex = 7;
            // 
            // lastNameTextBox
            // 
            lastNameTextBox.Location = new Point(12, 93);
            lastNameTextBox.Name = "lastNameTextBox";
            lastNameTextBox.Size = new Size(151, 23);
            lastNameTextBox.TabIndex = 8;
            // 
            // firstNameTextBox
            // 
            firstNameTextBox.Location = new Point(182, 93);
            firstNameTextBox.Name = "firstNameTextBox";
            firstNameTextBox.Size = new Size(151, 23);
            firstNameTextBox.TabIndex = 10;
            // 
            // ageTextBox
            // 
            ageTextBox.Location = new Point(12, 152);
            ageTextBox.Name = "ageTextBox";
            ageTextBox.Size = new Size(151, 23);
            ageTextBox.TabIndex = 11;
            // 
            // contactNoTextBox
            // 
            contactNoTextBox.Location = new Point(182, 152);
            contactNoTextBox.Name = "contactNoTextBox";
            contactNoTextBox.Size = new Size(151, 23);
            contactNoTextBox.TabIndex = 12;
            // 
            // middleNameTextBox
            // 
            middleNameTextBox.Location = new Point(348, 93);
            middleNameTextBox.Name = "middleNameTextBox";
            middleNameTextBox.Size = new Size(151, 23);
            middleNameTextBox.TabIndex = 13;
            // 
            // programComboBox
            // 
            programComboBox.FormattingEnabled = true;
            programComboBox.Items.AddRange(new object[] { "BS in Computer Science", "BS in Information Technology", "BS in Information Systems", "BS in Accountancy" });
            programComboBox.Location = new Point(182, 33);
            programComboBox.Name = "programComboBox";
            programComboBox.Size = new Size(241, 23);
            programComboBox.TabIndex = 14;
            // 
            // label8
            // 
            label8.AutoSize = true;
            label8.Font = new Font("Segoe UI", 12F);
            label8.Location = new Point(12, 192);
            label8.Name = "label8";
            label8.Size = new Size(66, 21);
            label8.TabIndex = 15;
            label8.Text = "Address";
            // 
            // addressRichTextBox
            // 
            addressRichTextBox.Location = new Point(12, 216);
            addressRichTextBox.Name = "addressRichTextBox";
            addressRichTextBox.Size = new Size(487, 144);
            addressRichTextBox.TabIndex = 16;
            addressRichTextBox.Text = "";
            // 
            // nextButton
            // 
            nextButton.Font = new Font("Segoe UI", 12F);
            nextButton.Location = new Point(219, 366);
            nextButton.Name = "nextButton";
            nextButton.Size = new Size(72, 26);
            nextButton.TabIndex = 17;
            nextButton.Text = "Next";
            nextButton.UseVisualStyleBackColor = true;
            nextButton.Click += nextButton_Click;
            // 
            // FrmRegistration
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(512, 402);
            Controls.Add(nextButton);
            Controls.Add(addressRichTextBox);
            Controls.Add(label8);
            Controls.Add(programComboBox);
            Controls.Add(middleNameTextBox);
            Controls.Add(contactNoTextBox);
            Controls.Add(ageTextBox);
            Controls.Add(firstNameTextBox);
            Controls.Add(lastNameTextBox);
            Controls.Add(studentNoTextBox);
            Controls.Add(label7);
            Controls.Add(label6);
            Controls.Add(label5);
            Controls.Add(label4);
            Controls.Add(label3);
            Controls.Add(label2);
            Controls.Add(label1);
            Name = "FrmRegistration";
            Text = "FrmRegistration";
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Label label1;
        private Label label2;
        private Label label3;
        private Label label4;
        private Label label5;
        private Label label6;
        private Label label7;
        private TextBox studentNoTextBox;
        private TextBox lastNameTextBox;
        private TextBox firstNameTextBox;
        private TextBox ageTextBox;
        private TextBox contactNoTextBox;
        private TextBox middleNameTextBox;
        private ComboBox programComboBox;
        private Label label8;
        private RichTextBox addressRichTextBox;
        private Button nextButton;
    }
}
