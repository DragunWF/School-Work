namespace Threads_App
{
    partial class FrmBasicThread
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
            stateLabel = new Label();
            runBtn = new Button();
            SuspendLayout();
            // 
            // stateLabel
            // 
            stateLabel.AutoSize = true;
            stateLabel.Font = new Font("Segoe UI", 18F);
            stateLabel.Location = new Point(12, 36);
            stateLabel.Name = "stateLabel";
            stateLabel.Size = new Size(267, 32);
            stateLabel.TabIndex = 0;
            stateLabel.Text = "-Before starting thread-";
            // 
            // runBtn
            // 
            runBtn.Font = new Font("Segoe UI", 12F);
            runBtn.Location = new Point(93, 115);
            runBtn.Name = "runBtn";
            runBtn.Size = new Size(104, 30);
            runBtn.TabIndex = 1;
            runBtn.Text = "Run";
            runBtn.UseVisualStyleBackColor = true;
            runBtn.Click += runBtn_Click;
            // 
            // FrmBasicThread
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(293, 182);
            Controls.Add(runBtn);
            Controls.Add(stateLabel);
            Name = "FrmBasicThread";
            Text = "BasicThread";
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Label stateLabel;
        private Button runBtn;
    }
}
