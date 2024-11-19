namespace BasicCalculator
{
    partial class FrmBasicCalculator
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
            FirstNumText = new TextBox();
            SecondNumText = new TextBox();
            OperatorCB = new ComboBox();
            ComputeBtn = new Button();
            label2 = new Label();
            TotalText = new Label();
            SuspendLayout();
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Font = new Font("Segoe UI", 18F, FontStyle.Regular, GraphicsUnit.Point, 0);
            label1.Location = new Point(12, 9);
            label1.Name = "label1";
            label1.Size = new Size(180, 32);
            label1.TabIndex = 0;
            label1.Text = "Basic Calculator";
            // 
            // FirstNumText
            // 
            FirstNumText.Font = new Font("Segoe UI", 18F, FontStyle.Regular, GraphicsUnit.Point, 0);
            FirstNumText.Location = new Point(12, 44);
            FirstNumText.Name = "FirstNumText";
            FirstNumText.Size = new Size(237, 39);
            FirstNumText.TabIndex = 1;
            FirstNumText.Text = "0";
            FirstNumText.TextAlign = HorizontalAlignment.Right;
            // 
            // SecondNumText
            // 
            SecondNumText.Font = new Font("Segoe UI", 18F, FontStyle.Regular, GraphicsUnit.Point, 0);
            SecondNumText.Location = new Point(12, 135);
            SecondNumText.Name = "SecondNumText";
            SecondNumText.Size = new Size(237, 39);
            SecondNumText.TabIndex = 2;
            SecondNumText.Text = "0";
            SecondNumText.TextAlign = HorizontalAlignment.Right;
            // 
            // OperatorCB
            // 
            OperatorCB.Font = new Font("Segoe UI", 18F, FontStyle.Regular, GraphicsUnit.Point, 0);
            OperatorCB.FormattingEnabled = true;
            OperatorCB.Location = new Point(90, 89);
            OperatorCB.Name = "OperatorCB";
            OperatorCB.Size = new Size(86, 40);
            OperatorCB.TabIndex = 3;
            // 
            // ComputeBtn
            // 
            ComputeBtn.Font = new Font("Segoe UI", 11.25F, FontStyle.Regular, GraphicsUnit.Point, 0);
            ComputeBtn.Location = new Point(90, 292);
            ComputeBtn.Name = "ComputeBtn";
            ComputeBtn.Size = new Size(91, 33);
            ComputeBtn.TabIndex = 5;
            ComputeBtn.Text = "Compute";
            ComputeBtn.UseVisualStyleBackColor = true;
            ComputeBtn.Click += ComputeBtn_Click;
            // 
            // label2
            // 
            label2.BackColor = SystemColors.ActiveCaptionText;
            label2.Font = new Font("Segoe UI", 14.25F, FontStyle.Regular, GraphicsUnit.Point, 0);
            label2.ForeColor = Color.Lime;
            label2.Location = new Point(12, 188);
            label2.Name = "label2";
            label2.Size = new Size(237, 88);
            label2.TabIndex = 6;
            label2.Text = "Total:";
            // 
            // TotalText
            // 
            TotalText.AutoSize = true;
            TotalText.BackColor = SystemColors.ActiveCaptionText;
            TotalText.Font = new Font("Segoe UI", 18F, FontStyle.Regular, GraphicsUnit.Point, 0);
            TotalText.ForeColor = Color.Lime;
            TotalText.Location = new Point(22, 220);
            TotalText.Name = "TotalText";
            TotalText.Size = new Size(92, 32);
            TotalText.TabIndex = 7;
            TotalText.Text = "000000";
            // 
            // FrmBasicCalculator
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(273, 337);
            Controls.Add(TotalText);
            Controls.Add(label2);
            Controls.Add(ComputeBtn);
            Controls.Add(OperatorCB);
            Controls.Add(SecondNumText);
            Controls.Add(FirstNumText);
            Controls.Add(label1);
            Name = "FrmBasicCalculator";
            Text = "FrmBasicCalculator";
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Label label1;
        private TextBox FirstNumText;
        private TextBox SecondNumText;
        private ComboBox OperatorCB;
        private Button button1;
        private Button ComputeBtn;
        private Label label2;
        private Label TotalText;
    }
}
