namespace TextFileWriterApp
{
    partial class FrmLab1
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
            btnCreate = new Button();
            txtInput = new RichTextBox();
            SuspendLayout();
            // 
            // btnCreate
            // 
            btnCreate.Font = new Font("Segoe UI", 14.25F, FontStyle.Regular, GraphicsUnit.Point, 0);
            btnCreate.Location = new Point(80, 158);
            btnCreate.Name = "btnCreate";
            btnCreate.Size = new Size(107, 44);
            btnCreate.TabIndex = 1;
            btnCreate.Text = "Create";
            btnCreate.UseVisualStyleBackColor = true;
            btnCreate.Click += this.btnCreate_Click;
            // 
            // txtInput
            // 
            txtInput.Location = new Point(12, 39);
            txtInput.Name = "txtInput";
            txtInput.Size = new Size(240, 96);
            txtInput.TabIndex = 2;
            txtInput.Text = "";
            // 
            // FrmLab1
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(264, 244);
            Controls.Add(txtInput);
            Controls.Add(btnCreate);
            Name = "FrmLab1";
            Text = "FrmLab1";
            ResumeLayout(false);
        }

        #endregion
        private Button btnCreate;
        private RichTextBox txtInput;
    }
}
