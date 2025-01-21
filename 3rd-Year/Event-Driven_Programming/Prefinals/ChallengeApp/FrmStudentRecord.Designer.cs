namespace ChallengeApp
{
    partial class FrmStudentRecord
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
            lvRecords = new ListView();
            label1 = new Label();
            btnRegister = new Button();
            btnFind = new Button();
            btnUpload = new Button();
            openFileDialog1 = new OpenFileDialog();
            SuspendLayout();
            // 
            // lvRecords
            // 
            lvRecords.Location = new Point(12, 44);
            lvRecords.Name = "lvRecords";
            lvRecords.Size = new Size(360, 189);
            lvRecords.TabIndex = 0;
            lvRecords.UseCompatibleStateImageBehavior = false;
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Font = new Font("Segoe UI", 18F, FontStyle.Regular, GraphicsUnit.Point, 0);
            label1.Location = new Point(12, 9);
            label1.Name = "label1";
            label1.Size = new Size(145, 32);
            label1.TabIndex = 1;
            label1.Text = "View Record";
            // 
            // btnRegister
            // 
            btnRegister.Font = new Font("Segoe UI", 9.75F, FontStyle.Regular, GraphicsUnit.Point, 0);
            btnRegister.Location = new Point(378, 44);
            btnRegister.Name = "btnRegister";
            btnRegister.Size = new Size(90, 28);
            btnRegister.TabIndex = 2;
            btnRegister.Text = "Register";
            btnRegister.UseVisualStyleBackColor = true;
            btnRegister.Click += btnRegister_Click;
            // 
            // btnFind
            // 
            btnFind.Font = new Font("Segoe UI", 9.75F, FontStyle.Regular, GraphicsUnit.Point, 0);
            btnFind.Location = new Point(378, 78);
            btnFind.Name = "btnFind";
            btnFind.Size = new Size(90, 28);
            btnFind.TabIndex = 3;
            btnFind.Text = "Find";
            btnFind.UseVisualStyleBackColor = true;
            btnFind.Click += btnFind_Click;
            // 
            // btnUpload
            // 
            btnUpload.Font = new Font("Segoe UI", 9.75F, FontStyle.Regular, GraphicsUnit.Point, 0);
            btnUpload.Location = new Point(378, 112);
            btnUpload.Name = "btnUpload";
            btnUpload.Size = new Size(90, 28);
            btnUpload.TabIndex = 4;
            btnUpload.Text = "Upload";
            btnUpload.UseVisualStyleBackColor = true;
            btnUpload.Click += btnUpload_Click;
            // 
            // openFileDialog1
            // 
            openFileDialog1.FileName = "openFileDialog1";
            // 
            // FrmStudentRecord
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(480, 245);
            Controls.Add(btnUpload);
            Controls.Add(btnFind);
            Controls.Add(btnRegister);
            Controls.Add(label1);
            Controls.Add(lvRecords);
            Name = "FrmStudentRecord";
            Text = "FrmStudentRecord";
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private ListView lvRecords;
        private Label label1;
        private Button btnRegister;
        private Button btnFind;
        private Button btnUpload;
        private OpenFileDialog openFileDialog1;
    }
}