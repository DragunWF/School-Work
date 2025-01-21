using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace CashierApplication
{
    public partial class frmLoginAccount : Form
    {
        private List<UserAccountNamespace.Cashier> accounts = new();
        private UserAccountNamespace.Cashier currentAccount;

        public frmLoginAccount()
        {
            InitializeComponent();
            accounts.Add(new UserAccountNamespace.Cashier("Marc Leonardo", "IT", "dragunwf", "password"));
            accounts.Add(new UserAccountNamespace.Cashier("Luq Hussin", "Accounting", "warcook", "password"));
        }

        private void loginButton_Click(object sender, EventArgs e)
        {
            if (isEmpty(usernameTextBox) || isEmpty(passwordTextBox))
            {
                MessageBox.Show("Please do not leave either of the username and password fields empty!");
            }
            else if (!loginAccount())
            {
                usernameTextBox.Text = "";
                passwordTextBox.Text = "";
                MessageBox.Show("Username and password does not match!");
            }
            else
            {
                MessageBox.Show($"Welcome {currentAccount.getFullName()} of {currentAccount.getDepartment()}");
                Hide();
                new frmPurchaseDiscountedItem().ShowDialog();
                Close();
            }
        }

        private bool loginAccount()
        {
            foreach (UserAccountNamespace.Cashier account in accounts)
            {
                if (account.getUserName() == usernameTextBox.Text && 
                    account.getPassword() == passwordTextBox.Text)
                {
                    currentAccount = account;
                    return true;
                }
            }
            return false;
        }

        private bool isEmpty(TextBox textBox)
        {
            return textBox.Text.Length == 0;
        }
    }
}

namespace UserAccountNamespace
{
    public abstract class UserAccount
    {
        private string full_name;
        protected string user_name;
        protected string user_password;

        public UserAccount(string name, string uName, string password)
        {
            full_name = name;
            user_name = uName;
            user_password = password;
        }

        public abstract bool validateLogin(string uName, string password);

        public string getFullName()
        {
            return full_name;
        }

        // These methods are here so I can implement a feature that validates credentials
        public string getUserName()
        {
            return user_name;
        }

        public string getPassword()
        {
            return user_password;
        }
    }

    public class Cashier : UserAccount
    {
        private string department;

        public Cashier(string name, string department, string uName, string password) : base(name, uName, password)
        {
            this.department = department;
        }

        public override bool validateLogin(string uName, string password)
        {
            throw new NotImplementedException();
        }

        public string getDepartment()
        {
            return department;
        }
    }
}