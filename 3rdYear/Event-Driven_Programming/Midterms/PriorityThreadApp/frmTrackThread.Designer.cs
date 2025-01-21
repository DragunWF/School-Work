namespace PriorityThreadApp
{
    partial class frmTrackThread
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
            runBtn = new Button();
            threadStateText = new Label();
            SuspendLayout();
            // 
            // runBtn
            // 
            runBtn.Location = new Point(82, 111);
            runBtn.Name = "runBtn";
            runBtn.Size = new Size(88, 26);
            runBtn.TabIndex = 0;
            runBtn.Text = "Run";
            runBtn.UseVisualStyleBackColor = true;
            runBtn.Click += runBtn_Click;
            // 
            // threadStateText
            // 
            threadStateText.AutoSize = true;
            threadStateText.Font = new Font("Segoe UI", 16F);
            threadStateText.Location = new Point(51, 53);
            threadStateText.Name = "threadStateText";
            threadStateText.Size = new Size(158, 30);
            threadStateText.TabIndex = 1;
            threadStateText.Text = "-Thread Starts-";
            // 
            // frmTrackThread
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(264, 197);
            Controls.Add(threadStateText);
            Controls.Add(runBtn);
            Name = "frmTrackThread";
            Text = "frmTrackThread";
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Button runBtn;
        private Label threadStateText;
    }
}
