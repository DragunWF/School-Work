namespace WordGuessApplication
{
    partial class Form1
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
            panel1 = new Panel();
            wordLabel = new Label();
            wordBox = new TextBox();
            guessButton = new Button();
            wrongWordList = new ListBox();
            panel2 = new Panel();
            label1 = new Label();
            panel1.SuspendLayout();
            panel2.SuspendLayout();
            SuspendLayout();
            // 
            // panel1
            // 
            panel1.BackColor = Color.DarkSeaGreen;
            panel1.Controls.Add(wordLabel);
            panel1.Location = new Point(12, 12);
            panel1.Name = "panel1";
            panel1.Size = new Size(344, 98);
            panel1.TabIndex = 0;
            // 
            // wordLabel
            // 
            wordLabel.AutoSize = true;
            wordLabel.Font = new Font("Segoe UI", 18F, FontStyle.Regular, GraphicsUnit.Point);
            wordLabel.ForeColor = SystemColors.ControlLightLight;
            wordLabel.Location = new Point(122, 29);
            wordLabel.Name = "wordLabel";
            wordLabel.Size = new Size(102, 32);
            wordLabel.TabIndex = 0;
            wordLabel.Text = "ubiquity";
            wordLabel.TextAlign = ContentAlignment.MiddleCenter;
            // 
            // wordBox
            // 
            wordBox.Location = new Point(12, 116);
            wordBox.Name = "wordBox";
            wordBox.Size = new Size(344, 23);
            wordBox.TabIndex = 1;
            // 
            // guessButton
            // 
            guessButton.BackColor = Color.DarkSeaGreen;
            guessButton.Font = new Font("Segoe UI", 12F, FontStyle.Regular, GraphicsUnit.Point);
            guessButton.ForeColor = SystemColors.ButtonHighlight;
            guessButton.Location = new Point(122, 145);
            guessButton.Name = "guessButton";
            guessButton.Size = new Size(123, 33);
            guessButton.TabIndex = 2;
            guessButton.Text = "Guess";
            guessButton.UseVisualStyleBackColor = false;
            guessButton.Click += guessButton_Click;
            // 
            // wrongWordList
            // 
            wrongWordList.FormattingEnabled = true;
            wrongWordList.ItemHeight = 15;
            wrongWordList.Location = new Point(362, 41);
            wrongWordList.Name = "wrongWordList";
            wrongWordList.Size = new Size(108, 94);
            wrongWordList.TabIndex = 3;
            // 
            // panel2
            // 
            panel2.BackColor = Color.DarkSeaGreen;
            panel2.Controls.Add(label1);
            panel2.Font = new Font("Segoe UI", 8F, FontStyle.Regular, GraphicsUnit.Point);
            panel2.Location = new Point(362, 12);
            panel2.Name = "panel2";
            panel2.Size = new Size(111, 23);
            panel2.TabIndex = 4;
            panel2.Tag = "";
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Font = new Font("Segoe UI", 10F, FontStyle.Regular, GraphicsUnit.Point);
            label1.ForeColor = SystemColors.ControlLightLight;
            label1.Location = new Point(3, 0);
            label1.Name = "label1";
            label1.Size = new Size(105, 19);
            label1.TabIndex = 5;
            label1.Text = "Wrong Guesses";
            // 
            // Form1
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(481, 185);
            Controls.Add(panel2);
            Controls.Add(wrongWordList);
            Controls.Add(guessButton);
            Controls.Add(wordBox);
            Controls.Add(panel1);
            Name = "Form1";
            Text = "Form1";
            panel1.ResumeLayout(false);
            panel1.PerformLayout();
            panel2.ResumeLayout(false);
            panel2.PerformLayout();
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Panel panel1;
        private TextBox wordBox;
        private Button guessButton;
        private ListBox wrongWordList;
        private Panel panel2;
        private Label label1;
        private Label wordLabel;
    }
}
