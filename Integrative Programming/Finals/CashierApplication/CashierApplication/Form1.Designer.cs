namespace CashierApplication
{
    partial class frmPurchaseDiscountedItem
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
            itemTextBox = new TextBox();
            discountTextBox = new TextBox();
            priceTextBox = new TextBox();
            quantityTextBox = new TextBox();
            label1 = new Label();
            label2 = new Label();
            label3 = new Label();
            label4 = new Label();
            computeButton = new Button();
            totalAmountText = new Label();
            paymentTextBox = new TextBox();
            label6 = new Label();
            changeText = new Label();
            submitButton = new Button();
            SuspendLayout();
            // 
            // itemTextBox
            // 
            itemTextBox.Location = new Point(12, 41);
            itemTextBox.Name = "itemTextBox";
            itemTextBox.Size = new Size(151, 23);
            itemTextBox.TabIndex = 0;
            // 
            // discountTextBox
            // 
            discountTextBox.Location = new Point(169, 41);
            discountTextBox.Name = "discountTextBox";
            discountTextBox.Size = new Size(141, 23);
            discountTextBox.TabIndex = 1;
            // 
            // priceTextBox
            // 
            priceTextBox.Location = new Point(54, 70);
            priceTextBox.Name = "priceTextBox";
            priceTextBox.Size = new Size(109, 23);
            priceTextBox.TabIndex = 2;
            // 
            // quantityTextBox
            // 
            quantityTextBox.Location = new Point(231, 70);
            quantityTextBox.Name = "quantityTextBox";
            quantityTextBox.Size = new Size(79, 23);
            quantityTextBox.TabIndex = 3;
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Location = new Point(12, 23);
            label1.Name = "label1";
            label1.Size = new Size(34, 15);
            label1.TabIndex = 4;
            label1.Text = "Item:";
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Location = new Point(169, 23);
            label2.Name = "label2";
            label2.Size = new Size(78, 15);
            label2.TabIndex = 5;
            label2.Text = "Discount (%):";
            // 
            // label3
            // 
            label3.AutoSize = true;
            label3.Location = new Point(12, 73);
            label3.Name = "label3";
            label3.Size = new Size(36, 15);
            label3.TabIndex = 6;
            label3.Text = "Price:";
            // 
            // label4
            // 
            label4.AutoSize = true;
            label4.Location = new Point(169, 73);
            label4.Name = "label4";
            label4.Size = new Size(56, 15);
            label4.TabIndex = 7;
            label4.Text = "Quantity:";
            // 
            // computeButton
            // 
            computeButton.Location = new Point(128, 99);
            computeButton.Name = "computeButton";
            computeButton.Size = new Size(75, 23);
            computeButton.TabIndex = 8;
            computeButton.Text = "Compute";
            computeButton.UseVisualStyleBackColor = true;
            computeButton.Click += computeButton_Click;
            // 
            // totalAmountText
            // 
            totalAmountText.AutoSize = true;
            totalAmountText.Font = new Font("Segoe UI", 10F, FontStyle.Regular, GraphicsUnit.Point);
            totalAmountText.Location = new Point(24, 132);
            totalAmountText.Name = "totalAmountText";
            totalAmountText.Size = new Size(95, 19);
            totalAmountText.TabIndex = 9;
            totalAmountText.Text = "Total Amount:";
            // 
            // paymentTextBox
            // 
            paymentTextBox.Location = new Point(125, 163);
            paymentTextBox.Name = "paymentTextBox";
            paymentTextBox.Size = new Size(100, 23);
            paymentTextBox.TabIndex = 10;
            // 
            // label6
            // 
            label6.AutoSize = true;
            label6.Location = new Point(12, 166);
            label6.Name = "label6";
            label6.Size = new Size(107, 15);
            label6.TabIndex = 11;
            label6.Text = "Payment Received:";
            // 
            // changeText
            // 
            changeText.AutoSize = true;
            changeText.Font = new Font("Segoe UI", 10F, FontStyle.Regular, GraphicsUnit.Point);
            changeText.Location = new Point(60, 197);
            changeText.Name = "changeText";
            changeText.Size = new Size(59, 19);
            changeText.TabIndex = 12;
            changeText.Text = "Change:";
            // 
            // submitButton
            // 
            submitButton.Location = new Point(231, 162);
            submitButton.Name = "submitButton";
            submitButton.Size = new Size(75, 23);
            submitButton.TabIndex = 13;
            submitButton.Text = "Submit";
            submitButton.UseVisualStyleBackColor = true;
            submitButton.Click += submitButton_Click;
            // 
            // frmPurchaseDiscountedItem
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(326, 263);
            Controls.Add(submitButton);
            Controls.Add(changeText);
            Controls.Add(label6);
            Controls.Add(paymentTextBox);
            Controls.Add(totalAmountText);
            Controls.Add(computeButton);
            Controls.Add(label4);
            Controls.Add(label3);
            Controls.Add(label2);
            Controls.Add(label1);
            Controls.Add(quantityTextBox);
            Controls.Add(priceTextBox);
            Controls.Add(discountTextBox);
            Controls.Add(itemTextBox);
            Name = "frmPurchaseDiscountedItem";
            Text = "Purchase Discounted Item";
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private TextBox itemTextBox;
        private TextBox discountTextBox;
        private TextBox priceTextBox;
        private TextBox quantityTextBox;
        private Label label1;
        private Label label2;
        private Label label3;
        private Label label4;
        private Button computeButton;
        private Label totalAmountText;
        private TextBox paymentTextBox;
        private Label label6;
        private Label changeText;
        private Button submitButton;
    }
}