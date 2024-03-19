namespace StudentGradeApplication
{
    partial class FrmStudentGradeProgram
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
            englishTextBox = new TextBox();
            label1 = new Label();
            mathTextBox = new TextBox();
            label2 = new Label();
            label3 = new Label();
            scienceTextBox = new TextBox();
            label4 = new Label();
            filipinoTextBox = new TextBox();
            label5 = new Label();
            historyTextBox = new TextBox();
            label6 = new Label();
            nameTextBox = new TextBox();
            label7 = new Label();
            generateAverageButton = new Button();
            resultText = new Label();
            averageLabel = new Label();
            SuspendLayout();
            // 
            // englishTextBox
            // 
            englishTextBox.Location = new Point(70, 89);
            englishTextBox.Name = "englishTextBox";
            englishTextBox.Size = new Size(100, 23);
            englishTextBox.TabIndex = 0;
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Location = new Point(19, 92);
            label1.Name = "label1";
            label1.Size = new Size(45, 15);
            label1.TabIndex = 1;
            label1.Text = "English";
            // 
            // mathTextBox
            // 
            mathTextBox.Location = new Point(70, 118);
            mathTextBox.Name = "mathTextBox";
            mathTextBox.Size = new Size(100, 23);
            mathTextBox.TabIndex = 2;
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Location = new Point(26, 121);
            label2.Name = "label2";
            label2.Size = new Size(35, 15);
            label2.TabIndex = 3;
            label2.Text = "Math";
            // 
            // label3
            // 
            label3.AutoSize = true;
            label3.Location = new Point(18, 150);
            label3.Name = "label3";
            label3.Size = new Size(47, 15);
            label3.TabIndex = 5;
            label3.Text = "Science";
            // 
            // scienceTextBox
            // 
            scienceTextBox.Location = new Point(70, 147);
            scienceTextBox.Name = "scienceTextBox";
            scienceTextBox.Size = new Size(100, 23);
            scienceTextBox.TabIndex = 4;
            // 
            // label4
            // 
            label4.AutoSize = true;
            label4.Location = new Point(19, 179);
            label4.Name = "label4";
            label4.Size = new Size(46, 15);
            label4.TabIndex = 7;
            label4.Text = "Filipino";
            // 
            // filipinoTextBox
            // 
            filipinoTextBox.Location = new Point(70, 176);
            filipinoTextBox.Name = "filipinoTextBox";
            filipinoTextBox.Size = new Size(100, 23);
            filipinoTextBox.TabIndex = 6;
            // 
            // label5
            // 
            label5.AutoSize = true;
            label5.Location = new Point(19, 208);
            label5.Name = "label5";
            label5.Size = new Size(45, 15);
            label5.TabIndex = 9;
            label5.Text = "History";
            // 
            // historyTextBox
            // 
            historyTextBox.Location = new Point(70, 205);
            historyTextBox.Name = "historyTextBox";
            historyTextBox.Size = new Size(100, 23);
            historyTextBox.TabIndex = 8;
            // 
            // label6
            // 
            label6.AutoSize = true;
            label6.Location = new Point(97, 71);
            label6.Name = "label6";
            label6.Size = new Size(43, 15);
            label6.TabIndex = 10;
            label6.Text = "Grades";
            // 
            // nameTextBox
            // 
            nameTextBox.Location = new Point(70, 33);
            nameTextBox.Name = "nameTextBox";
            nameTextBox.Size = new Size(336, 23);
            nameTextBox.TabIndex = 11;
            // 
            // label7
            // 
            label7.AutoSize = true;
            label7.Location = new Point(26, 36);
            label7.Name = "label7";
            label7.Size = new Size(42, 15);
            label7.TabIndex = 12;
            label7.Text = "Name:";
            // 
            // generateAverageButton
            // 
            generateAverageButton.Location = new Point(70, 234);
            generateAverageButton.Name = "generateAverageButton";
            generateAverageButton.Size = new Size(100, 43);
            generateAverageButton.TabIndex = 13;
            generateAverageButton.Text = "Generate Average";
            generateAverageButton.UseVisualStyleBackColor = true;
            generateAverageButton.Click += generateAverageButton_Click;
            // 
            // resultText
            // 
            resultText.AutoSize = true;
            resultText.Location = new Point(176, 135);
            resultText.Name = "resultText";
            resultText.Size = new Size(79, 15);
            resultText.TabIndex = 14;
            resultText.Text = "<Result Text>";
            // 
            // averageLabel
            // 
            averageLabel.AutoSize = true;
            averageLabel.Location = new Point(176, 164);
            averageLabel.Name = "averageLabel";
            averageLabel.Size = new Size(90, 15);
            averageLabel.TabIndex = 15;
            averageLabel.Text = "<Average Text>";
            // 
            // Form1
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(425, 302);
            Controls.Add(averageLabel);
            Controls.Add(resultText);
            Controls.Add(generateAverageButton);
            Controls.Add(label7);
            Controls.Add(nameTextBox);
            Controls.Add(label6);
            Controls.Add(label5);
            Controls.Add(historyTextBox);
            Controls.Add(label4);
            Controls.Add(filipinoTextBox);
            Controls.Add(label3);
            Controls.Add(scienceTextBox);
            Controls.Add(label2);
            Controls.Add(mathTextBox);
            Controls.Add(label1);
            Controls.Add(englishTextBox);
            Name = "Form1";
            Text = "Form1";
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private TextBox englishTextBox;
        private Label label1;
        private TextBox mathTextBox;
        private Label label2;
        private Label label3;
        private TextBox scienceTextBox;
        private Label label4;
        private TextBox filipinoTextBox;
        private Label label5;
        private TextBox historyTextBox;
        private Label label6;
        private TextBox nameTextBox;
        private Label label7;
        private Button generateAverageButton;
        private Label resultText;
        private Label averageLabel;
    }
}