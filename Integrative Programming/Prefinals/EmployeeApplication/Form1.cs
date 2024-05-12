namespace EmployeeApplication
{
    public partial class frmEmployeeDatabase : Form
    {
        private readonly List<EmployeeNamespace.Employee> employees = new();

        public frmEmployeeDatabase()
        {
            InitializeComponent();
            dataGrid.DataSource = employees;
        }

        private void submitButton_Click(object sender, EventArgs e)
        {
            if (IsEmpty(idTextBox) || IsEmpty(firstNameTextBox) || IsEmpty(lastNameTextBox) || IsEmpty(positionTextBox))
            {
                MessageBox.Show("Please do not leave any text boxes empty!");
                return;
            }
            employees.Add(
                new EmployeeNamespace.Employee(idTextBox.Text, firstNameTextBox.Text, 
                lastNameTextBox.Text, positionTextBox.Text)
            );
            dataGrid.DataSource = null;
            dataGrid.DataSource = employees;
            ResetTextBoxes();
        }

        private void ResetTextBoxes()
        {
            idTextBox.Text = "";
            firstNameTextBox.Text = "";
            lastNameTextBox.Text = "";
            positionTextBox.Text = "";
        }

        private static bool IsEmpty(TextBox textBox)
        {
            return textBox.Text.Length == 0;
        }
    }
}

namespace EmployeeNamespace
{
    public class Employee
    {
        // Encapsulation via properties with shortened getters and setters
        public string id { get; set; }
        public string firstName { get; set; }
        public string lastName { get; set; }
        public string position { get; set; }

        public Employee(string id, string firstName, string lastName, string position)
        {
            this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
            this.position = position;
        }

        public Employee()
        {
            // Default constructor (Overloaded)
            id = "1";
            firstName = "Leonardo";
            lastName = "Da Vinci";
            position = "Artist";
        }
    }
}
