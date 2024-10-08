using System.Text.RegularExpressions;

namespace OrganizationProfile
{
    public partial class frmRegistration : Form
    {
        private string _FullName;
        private int _Age;
        private long _ContactNo;
        private long _StudentNo;

        public frmRegistration()
        {
            InitializeComponent();
        }

        private void btnRegister_Click(object sender, EventArgs e)
        {
            try
            {
                StudentInformationClass.SetFullName = FullName(txtLastName.Text, txtFirstName.Text, txtMiddleInitial.Text);
                StudentInformationClass.SetStudentNo = StudentNumber(txtStudentNo.Text);
                StudentInformationClass.SetProgram = cbPrograms.Text;
                StudentInformationClass.SetGender = cbGender.Text;
                StudentInformationClass.SetContactNo = ContactNo(txtContactNo.Text);
                StudentInformationClass.SetAge = Age(txtAge.Text);
                StudentInformationClass.SetBirthday = datePickerBirthday.Value.ToString("yyyyMM-dd");

                frmConfirmation frm = new frmConfirmation();
                frm.ShowDialog();
            }
            catch (FormatException fe)
            {
                MessageBox.Show(fe.Message);
            }
            catch (ArgumentNullException ane)
            {
                MessageBox.Show(ane.Message);
            }
            catch (OverflowException oe)
            {
                MessageBox.Show(oe.Message);
            }
            catch (IndexOutOfRangeException ie)
            {
                MessageBox.Show(ie.Message);
            }
            finally
            {
                // Instructions require me to put a "finally" keyword in this lab exercise
            }
        }

        private void frmRegistration_Load(object sender, EventArgs e)
        {
            string[] ListOfProgram = {
                 "BS Information Technology",
                 "BS Computer Science",
                 "BS Information Systems",
                 "BS in Accountancy",
                 "BS in Hospitality Management",
                 "BS in Tourism Management"
            };
            for (int i = 0; i < ListOfProgram.Length; i++)
            {
                cbPrograms.Items.Add(ListOfProgram[i].ToString());
            }
            string[] Genders = { "Male", "Female" };
            foreach (string gender in Genders)
            {
                cbGender.Items.Add(gender);
            }
        }

        public long StudentNumber(string studNum)
        {
            if (Regex.IsMatch(studNum, @"^[0-9]{10,11}$"))
            {
                _StudentNo = long.Parse(studNum);
            }
            else
            {
                // A format exception will be thrown automatically anyway if the parsing
                // is incompatible but the instructions require me to throw this "manually"
                // so here it is I guess...
                throw new FormatException();
            }
            return _StudentNo;
        }

        public long ContactNo(string Contact)
        {
            if (Regex.IsMatch(Contact, @"^[0-9]{10,11}$"))
            {
                _ContactNo = long.Parse(Contact);
            }
            else
            {
                throw new IndexOutOfRangeException();
            }
            return _ContactNo;
        }

        public string FullName(string LastName, string FirstName, string MiddleInitial)
        {
            if (Regex.IsMatch(LastName, @"^[a-zA-Z]+$") || Regex.IsMatch(FirstName, @"^[a-zA-Z]+$") || Regex.IsMatch(MiddleInitial, @"^[a-zA-Z]+$"))
            {
                _FullName = LastName + ", " + FirstName + ", " + MiddleInitial;
            }
            else
            {
                throw new OverflowException();
            }
            return _FullName;
        }

        public int Age(string age)
        {
            if (Regex.IsMatch(age, @"^[0-9]{1,3}$"))
            {
                _Age = Int32.Parse(age);
            }
            else
            {
                throw new ArgumentNullException();
            }
            return _Age;
        }
    }
}
