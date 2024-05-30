namespace CashierApplication
{
    partial class frmLoginAccount
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
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
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            label1 = new Label();
            usernameTextBox = new TextBox();
            label2 = new Label();
            passwordTextBox = new TextBox();
            loginButton = new Button();
            SuspendLayout();
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Font = new Font("Segoe UI", 10.5F, FontStyle.Regular, GraphicsUnit.Point);
            label1.Location = new Point(38, 9);
            label1.Name = "label1";
            label1.Size = new Size(71, 19);
            label1.TabIndex = 0;
            label1.Text = "Username";
            // 
            // usernameTextBox
            // 
            usernameTextBox.Location = new Point(42, 31);
            usernameTextBox.Name = "usernameTextBox";
            usernameTextBox.Size = new Size(172, 23);
            usernameTextBox.TabIndex = 1;
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Font = new Font("Segoe UI", 10.5F, FontStyle.Regular, GraphicsUnit.Point);
            label2.Location = new Point(38, 57);
            label2.Name = "label2";
            label2.Size = new Size(67, 19);
            label2.TabIndex = 2;
            label2.Text = "Password";
            // 
            // passwordTextBox
            // 
            passwordTextBox.Location = new Point(42, 79);
            passwordTextBox.Name = "passwordTextBox";
            passwordTextBox.PasswordChar = '●';
            passwordTextBox.Size = new Size(172, 23);
            passwordTextBox.TabIndex = 3;
            // 
            // loginButton
            // 
            loginButton.BackColor = SystemColors.ActiveCaption;
            loginButton.Font = new Font("Segoe UI", 11.25F, FontStyle.Bold, GraphicsUnit.Point);
            loginButton.ForeColor = SystemColors.ControlLightLight;
            loginButton.Location = new Point(42, 108);
            loginButton.Name = "loginButton";
            loginButton.Size = new Size(172, 36);
            loginButton.TabIndex = 4;
            loginButton.Text = "Login";
            loginButton.UseVisualStyleBackColor = false;
            loginButton.Click += loginButton_Click;
            // 
            // frmLoginAccount
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(258, 161);
            Controls.Add(loginButton);
            Controls.Add(passwordTextBox);
            Controls.Add(label2);
            Controls.Add(usernameTextBox);
            Controls.Add(label1);
            Name = "frmLoginAccount";
            Text = "User Login";
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Label label1;
        private TextBox usernameTextBox;
        private Label label2;
        private TextBox passwordTextBox;
        private Button loginButton;
    }
}