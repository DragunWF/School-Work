using EmployeeInterface;

namespace EmployeeApplication
{
    public partial class frmComputeSalary : Form
    {
        private EmployeeNamespace.PartTimeEmployee employee;

        public frmComputeSalary()
        {
            InitializeComponent();
            employee = new EmployeeNamespace.PartTimeEmployee("<first name here>", "<last name here>", "Default Department", "Default Worker");
        }

        private void computeButton_Click(object sender, EventArgs e)
        {
            try
            {
                if (isEmpty(firstNameTextBox) || isEmpty(lastNameTextBox) || isEmpty(departmentTextBox) ||
                    isEmpty(jobTitleTextBox) || isEmpty(rateTextBox) || isEmpty(totalHoursTextBox)) {
                    MessageBox.Show("Please do not leave any text boxes empty!");
                }
                else
                {
                    // Setting basic info via accessing the properties (As per instructions)
                    employee.FirstName = firstNameTextBox.Text;
                    employee.LastName = lastNameTextBox.Text;
                    employee.Department = departmentTextBox.Text;
                    employee.JobTitle = jobTitleTextBox.Text;
                    employee.computeSalary(
                        int.Parse(totalHoursTextBox.Text), double.Parse(rateTextBox.Text)
                    );

                    firstNameText.Text = $"First name:   {employee.FirstName}";
                    lastNameText.Text = $"Last name:   {employee.LastName}";
                    basicSalaryText.Text = $"Basic Salary:   {employee.BasicSalary}";
                }
            }
            catch (Exception err)
            {
                MessageBox.Show("Please make sure your input is valid!");
            }
        }

        private bool isEmpty(TextBox textBox)
        {
            return textBox.Text.Length == 0;
        }
    }
}

namespace EmployeeInterface
{
    public interface IEmployee
    {
        public string FirstName { get; set; }
        public string LastName { get; set; }
        public string Department { get; set; }
        public string JobTitle { get; set; }
        public double BasicSalary { get; }

        public void computeSalary(int hoursWorked, double ratePerHour);
    }
}

namespace EmployeeNamespace
{
    public class PartTimeEmployee : IEmployee
    {
        private string first_name;
        private string last_name;
        private string department;
        private string job_title;
        private double basic_salary;

        public string FirstName
        {
            get
            {
                return first_name;
            }
            set
            {
                first_name = value;
            }
        }

        public string LastName
        {
            get
            {
                return last_name;
            }
            set
            {
                last_name = value;
            }
        }

        public string Department
        {
            get
            {
                return department;
            }
            set
            {
                department = value;
            }
        }

        public string JobTitle
        {
            get
            {
                return job_title;
            }
            set
            {
                job_title = value;
            }
        }

        public double BasicSalary
        {
            get
            {
                return basic_salary;
            }
        }

        public PartTimeEmployee(string FName, string LName, string dept, string job)
        {
            first_name = FName;
            last_name = LName;
            department = dept;
            job_title = job;
        }

        public void computeSalary(int hoursWorked, double ratePerHour)
        {
            basic_salary = hoursWorked * ratePerHour;
        }

        public double getSalary()
        {
            return basic_salary;
        }
    }
}