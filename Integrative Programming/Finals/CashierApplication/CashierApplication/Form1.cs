namespace CashierApplication
{
    public partial class frmPurchaseDiscountedItem : Form
    {
        private ItemNamespace.DiscountedItem item;

        public frmPurchaseDiscountedItem()
        {
            InitializeComponent();
        }

        private void computeButton_Click(object sender, EventArgs e)
        {
            try
            {
                if (isEmpty(itemTextBox) || isEmpty(discountTextBox) || isEmpty(priceTextBox) || isEmpty(quantityTextBox))
                {
                    MessageBox.Show("Please do not leave any of the item boxes empty!");
                }
                else
                {
                    item = new ItemNamespace.DiscountedItem(
                        itemTextBox.Text, Convert.ToDouble(priceTextBox.Text),
                        Convert.ToInt32(quantityTextBox.Text), Convert.ToDouble(discountTextBox.Text)
                    );
                    totalAmountText.Text = $"Total Amount: {item.getTotalPrice()}";
                }
            }
            catch (Exception err)
            {
                MessageBox.Show("Please make sure your input is valid!");
            }
        }

        private void submitButton_Click(object sender, EventArgs e)
        {
            if (isEmpty(paymentTextBox))
            {
                MessageBox.Show("Do not leave the payment price empty!");
            } 
            else if (item == null)
            {
                MessageBox.Show("Compute the item and total amount first!");
            }
            else
            {
                try
                {
                    item.setPayment(Convert.ToDouble(paymentTextBox.Text));
                    changeText.Text = $"Change: {item.getChange()}";
                } 
                catch (Exception err)
                {
                    MessageBox.Show("Please make sure your payment input is valid!");
                }
            }
        }

        private bool isEmpty(TextBox textBox)
        {
            return textBox.Text.Length == 0;
        }
    }
}

namespace ItemNamespace
{
    public abstract class Item
    {
        protected string item_name;
        protected double item_price;
        protected int item_quantity;

        public Item(string name, double price, int quantity)
        {
            item_name = name;
            item_price = price;
            item_quantity = quantity;
        }

        public abstract double getTotalPrice();

        public abstract void setPayment(double amount);
    }

    public class DiscountedItem : Item
    {
        public double item_discount;
        private double discounted_price;
        private double payment_amount;
        private double change;

        public DiscountedItem(string name, double price, int quantity, double discount) : base(name, price, quantity)
        {
            item_discount = discount / 100;
        }

        public override double getTotalPrice()
        {
            discounted_price = item_price * item_quantity * (1 - item_discount);
            return Math.Round(discounted_price, 2);
        }

        public override void setPayment(double amount)
        {
            payment_amount = amount;
        }

        public double getChange()
        {
            change = payment_amount - getTotalPrice();
            return Math.Round(change, 2);
        }
    }
}