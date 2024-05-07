using StudentNamespace;
using System.Reflection.Metadata.Ecma335;

namespace StudentInfoApplication
{
    public partial class frmStudentInfo : Form
    {
        private readonly List<StudentInfo> students;

        public frmStudentInfo()
        {
            InitializeComponent();
            students = new List<StudentInfo>();
        }

        private void SubmitButton_Click(object sender, EventArgs e)
        {
            try
            {
                if (idBox.Text.Length == 0 || firstNameBox.Text.Length == 0 || lastNameBox.Text.Length == 0)
                {
                    MessageBox.Show("Please fill in all the text boxes first!");
                    return;
                }
                students.Add(new StudentInfo(int.Parse(idBox.Text), firstNameBox.Text, lastNameBox.Text));
                int latest = students.Count - 1;
                idListBox.Items.Add(students[latest].GetId());
                firstNameListBox.Items.Add(students[latest].GetFirstName());
                lastNameListBox.Items.Add(students[latest].GetLastName());
            }
            catch (Exception error)
            {
                MessageBox.Show("Please make sure your input is valid!");
            }
        }
    }
}

namespace StudentNamespace
{
    class StudentInfo
    {
        private int id;
        private string firstName;
        private string lastName;

        public StudentInfo(int id, string firstName, string lastName)
        {
            this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public StudentInfo(int id, string firstName)
        {
            this.id = id;
            this.firstName = firstName;
        }

        public StudentInfo(int id)
        {
            this.id = id;
        }

        public int GetId() => id;
        public void SetId(int id) { this.id = id; }

        public string GetFirstName() => firstName;
        public void SetFirstName(string firstName) => this.firstName = firstName;

        public string GetLastName() => lastName;
        public void SetLastName(string lastName) => this.lastName = lastName;
    }
}
