namespace CalculatorApplication
{
    partial class FrmCalculator
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
            txtBoxInput1 = new TextBox();
            txtBoxInput2 = new TextBox();
            cbOperator = new ComboBox();
            btnEqual = new Button();
            lblDisplayTotal = new Label();
            label5 = new Label();
            SuspendLayout();
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Font = new Font("Segoe UI", 12F, FontStyle.Regular, GraphicsUnit.Point, 0);
            label1.Location = new Point(33, 20);
            label1.Name = "label1";
            label1.Size = new Size(145, 21);
            label1.TabIndex = 0;
            label1.Text = "Enter First Number:";
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Font = new Font("Segoe UI", 12F, FontStyle.Regular, GraphicsUnit.Point, 0);
            label2.Location = new Point(12, 88);
            label2.Name = "label2";
            label2.Size = new Size(166, 21);
            label2.TabIndex = 1;
            label2.Text = "Enter Second Number:";
            // 
            // label3
            // 
            label3.AutoSize = true;
            label3.Font = new Font("Segoe UI", 12F, FontStyle.Regular, GraphicsUnit.Point, 0);
            label3.Location = new Point(113, 136);
            label3.Name = "label3";
            label3.Size = new Size(65, 21);
            label3.TabIndex = 2;
            label3.Text = "Answer:";
            // 
            // txtBoxInput1
            // 
            txtBoxInput1.Font = new Font("Consolas", 12F, FontStyle.Regular, GraphicsUnit.Point, 0);
            txtBoxInput1.Location = new Point(184, 19);
            txtBoxInput1.Name = "txtBoxInput1";
            txtBoxInput1.Size = new Size(186, 26);
            txtBoxInput1.TabIndex = 3;
            // 
            // txtBoxInput2
            // 
            txtBoxInput2.Font = new Font("Consolas", 12F, FontStyle.Regular, GraphicsUnit.Point, 0);
            txtBoxInput2.Location = new Point(184, 87);
            txtBoxInput2.Name = "txtBoxInput2";
            txtBoxInput2.Size = new Size(186, 26);
            txtBoxInput2.TabIndex = 4;
            // 
            // cbOperator
            // 
            cbOperator.Font = new Font("Consolas", 12F, FontStyle.Regular, GraphicsUnit.Point, 0);
            cbOperator.FormattingEnabled = true;
            cbOperator.Items.AddRange(new object[] { "+", "-", "*", "/" });
            cbOperator.Location = new Point(237, 51);
            cbOperator.Name = "cbOperator";
            cbOperator.Size = new Size(79, 27);
            cbOperator.TabIndex = 5;
            // 
            // btnEqual
            // 
            btnEqual.Font = new Font("Consolas", 14.25F, FontStyle.Regular, GraphicsUnit.Point, 0);
            btnEqual.Location = new Point(218, 185);
            btnEqual.Name = "btnEqual";
            btnEqual.Size = new Size(108, 29);
            btnEqual.TabIndex = 6;
            btnEqual.Text = "Calculate";
            btnEqual.UseVisualStyleBackColor = true;
            btnEqual.Click += btnEqual_Click;
            // 
            // lblDisplayTotal
            // 
            lblDisplayTotal.AutoSize = true;
            lblDisplayTotal.Font = new Font("Segoe UI", 12F, FontStyle.Regular, GraphicsUnit.Point, 0);
            lblDisplayTotal.Location = new Point(184, 136);
            lblDisplayTotal.Name = "lblDisplayTotal";
            lblDisplayTotal.Size = new Size(82, 21);
            lblDisplayTotal.TabIndex = 7;
            lblDisplayTotal.Text = "<answer>";
            // 
            // label5
            // 
            label5.BackColor = SystemColors.ActiveCaptionText;
            label5.BorderStyle = BorderStyle.Fixed3D;
            label5.Location = new Point(184, 166);
            label5.Name = "label5";
            label5.Size = new Size(186, 3);
            label5.TabIndex = 8;
            // 
            // FrmCalculator
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(388, 236);
            Controls.Add(label5);
            Controls.Add(lblDisplayTotal);
            Controls.Add(btnEqual);
            Controls.Add(cbOperator);
            Controls.Add(txtBoxInput2);
            Controls.Add(txtBoxInput1);
            Controls.Add(label3);
            Controls.Add(label2);
            Controls.Add(label1);
            Name = "FrmCalculator";
            Text = "FrmCalculator";
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Label label1;
        private Label label2;
        private Label label3;
        private TextBox txtBoxInput1;
        private TextBox txtBoxInput2;
        private ComboBox cbOperator;
        private Button btnEqual;
        private Label lblDisplayTotal;
        private Label label5;
    }
}
