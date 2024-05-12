namespace EmployeeApplication
{
    partial class frmEmployeeDatabase
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
            idTextBox = new TextBox();
            label3 = new Label();
            firstNameTextBox = new TextBox();
            label4 = new Label();
            lastNameTextBox = new TextBox();
            label5 = new Label();
            positionTextBox = new TextBox();
            submitButton = new Button();
            label6 = new Label();
            dataGrid = new DataGridView();
            ((System.ComponentModel.ISupportInitialize)dataGrid).BeginInit();
            SuspendLayout();
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Font = new Font("Segoe UI", 13F, FontStyle.Bold, GraphicsUnit.Point);
            label1.Location = new Point(12, 9);
            label1.Name = "label1";
            label1.Size = new Size(140, 25);
            label1.TabIndex = 0;
            label1.Text = "Add Employee:";
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Font = new Font("Segoe UI", 10F, FontStyle.Regular, GraphicsUnit.Point);
            label2.Location = new Point(12, 44);
            label2.Name = "label2";
            label2.Size = new Size(96, 19);
            label2.TabIndex = 1;
            label2.Text = "Employee ID *";
            // 
            // idTextBox
            // 
            idTextBox.Location = new Point(12, 66);
            idTextBox.Name = "idTextBox";
            idTextBox.Size = new Size(155, 23);
            idTextBox.TabIndex = 2;
            // 
            // label3
            // 
            label3.AutoSize = true;
            label3.Font = new Font("Segoe UI", 10F, FontStyle.Regular, GraphicsUnit.Point);
            label3.Location = new Point(12, 92);
            label3.Name = "label3";
            label3.Size = new Size(83, 19);
            label3.TabIndex = 3;
            label3.Text = "First name *";
            // 
            // firstNameTextBox
            // 
            firstNameTextBox.Location = new Point(12, 114);
            firstNameTextBox.Name = "firstNameTextBox";
            firstNameTextBox.Size = new Size(155, 23);
            firstNameTextBox.TabIndex = 4;
            // 
            // label4
            // 
            label4.AutoSize = true;
            label4.Font = new Font("Segoe UI", 10F, FontStyle.Regular, GraphicsUnit.Point);
            label4.Location = new Point(12, 140);
            label4.Name = "label4";
            label4.Size = new Size(82, 19);
            label4.TabIndex = 5;
            label4.Text = "Last name *";
            // 
            // lastNameTextBox
            // 
            lastNameTextBox.Location = new Point(12, 162);
            lastNameTextBox.Name = "lastNameTextBox";
            lastNameTextBox.Size = new Size(155, 23);
            lastNameTextBox.TabIndex = 6;
            // 
            // label5
            // 
            label5.AutoSize = true;
            label5.Font = new Font("Segoe UI", 10F, FontStyle.Regular, GraphicsUnit.Point);
            label5.Location = new Point(12, 188);
            label5.Name = "label5";
            label5.Size = new Size(67, 19);
            label5.TabIndex = 7;
            label5.Text = "Position *";
            // 
            // positionTextBox
            // 
            positionTextBox.Location = new Point(12, 210);
            positionTextBox.Name = "positionTextBox";
            positionTextBox.Size = new Size(155, 23);
            positionTextBox.TabIndex = 8;
            // 
            // submitButton
            // 
            submitButton.BackColor = SystemColors.Highlight;
            submitButton.BackgroundImageLayout = ImageLayout.None;
            submitButton.Font = new Font("Segoe UI", 9.75F, FontStyle.Regular, GraphicsUnit.Point);
            submitButton.ForeColor = SystemColors.ButtonHighlight;
            submitButton.Location = new Point(41, 239);
            submitButton.Name = "submitButton";
            submitButton.Size = new Size(89, 30);
            submitButton.TabIndex = 9;
            submitButton.Text = "Submit";
            submitButton.UseVisualStyleBackColor = false;
            submitButton.Click += submitButton_Click;
            // 
            // label6
            // 
            label6.AutoSize = true;
            label6.Font = new Font("Segoe UI", 10F, FontStyle.Regular, GraphicsUnit.Point);
            label6.Location = new Point(174, 13);
            label6.Name = "label6";
            label6.Size = new Size(96, 19);
            label6.TabIndex = 11;
            label6.Text = "Employee List:";
            // 
            // dataGrid
            // 
            dataGrid.ColumnHeadersHeightSizeMode = DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            dataGrid.Location = new Point(174, 35);
            dataGrid.Name = "dataGrid";
            dataGrid.ReadOnly = true;
            dataGrid.RowTemplate.Height = 25;
            dataGrid.Size = new Size(443, 234);
            dataGrid.TabIndex = 12;
            dataGrid.TabStop = false;
            // 
            // frmEmployeeDatabase
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(629, 286);
            Controls.Add(dataGrid);
            Controls.Add(label6);
            Controls.Add(submitButton);
            Controls.Add(positionTextBox);
            Controls.Add(label5);
            Controls.Add(lastNameTextBox);
            Controls.Add(label4);
            Controls.Add(firstNameTextBox);
            Controls.Add(label3);
            Controls.Add(idTextBox);
            Controls.Add(label2);
            Controls.Add(label1);
            Name = "frmEmployeeDatabase";
            Text = "Employee Database";
            ((System.ComponentModel.ISupportInitialize)dataGrid).EndInit();
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Label label1;
        private Label label2;
        private TextBox idTextBox;
        private Label label3;
        private TextBox firstNameTextBox;
        private Label label4;
        private TextBox lastNameTextBox;
        private Label label5;
        private TextBox positionTextBox;
        private Button submitButton;
        private Label label6;
        private DataGridView dataGrid;
    }
}
