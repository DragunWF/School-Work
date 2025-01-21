using System.Text.RegularExpressions;

namespace Inventory
{
    public partial class frmAddProduct : Form
    {
        private string _ProductName = "", _Category = "", _MfgDate = "", _ExpDate = "", _Description = "";
        private int _Quantity = 0;
        private double _SellPrice = 0;
        private BindingSource showProductList;

        public frmAddProduct()
        {
            InitializeComponent();
            showProductList = new BindingSource();
        }

        private void btnAddProduct_Click(object sender, EventArgs e)
        {
            _ProductName = Product_Name(txtProductName.Text);
            _Category = cbCategory.Text;
            _MfgDate = dtPickerMfgDate.Value.ToString("yyyy-MM-dd");
            _ExpDate = dtPickerExpDate.Value.ToString("yyyy-MM-dd");
            _Description = richTxtDescription.Text;
            _Quantity = Quantity(txtQuantity.Text);
            _SellPrice = SellingPrice(txtSellPrice.Text);
            if (_Quantity != 0 && _SellPrice != 0 && _ProductName != "") 
            {
                showProductList.Add(new ProductClass(_ProductName, _Category, _MfgDate,
                    _ExpDate, _SellPrice, _Quantity, _Description));
            }
            gridViewProductList.AutoSizeColumnsMode = DataGridViewAutoSizeColumnsMode.Fill;
            gridViewProductList.DataSource = showProductList;
        }

        public string Product_Name(string name)
        {
            try
            {
                if (!Regex.IsMatch(name, @"^[a-zA-Z]+$"))
                {
                    throw new StringFormatException("Invalid string input!");
                }
                return name;
            } 
            catch (StringFormatException e)
            {
                MessageBox.Show(e.Message);
                return "";
            }
        }
        public int Quantity(string qty)
        {
            try
            {
                if (!Regex.IsMatch(qty, @"^[0-9]"))
                {
                    throw new NumberFormatException("Invalid number input!");
                }
                return Convert.ToInt32(qty);
            }
            catch (NumberFormatException e) 
            {
                MessageBox.Show(e.Message);
                return 0;
            }
        }
        public double SellingPrice(string price)
        {
            try
            {
                if (!Regex.IsMatch(price.ToString(), @"^(\d*\.)?\d+$"))
                {
                    throw new CurrencyFormatException("Invalid currency input!");
                }
                return Convert.ToDouble(price);
            }
            catch (CurrencyFormatException e)
            {
                MessageBox.Show(e.Message);
                return 0;
            }
        }

        private void frmAddProduct_Load(object sender, EventArgs e)
        {
            string[] ListOfProductCategory =
            {
                "Beverages",
                "Bread/Bakery",
                "Canned/Jarred Goods",
                "Dairy",
                "Frozen Goods",
                "Meat",
                "Personal Care",
                "Other"
            };
            foreach (string product in ListOfProductCategory) 
            {
                cbCategory.Items.Add(product);
            }
        }
    }
}
