using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using static AccountRegistration.StudentInfoClass;

namespace AccountRegistration
{
    public partial class FrmConfirm : Form
    {
        private DelegateText DelProgram, DelLastName, DelFirstName, DelMiddleName, DelAddress;
        private DelegateNumber DelNumAge, DelNumContactNo, DelStudNo;

        public FrmConfirm()
        {
            InitializeComponent();
            // Form Events
            Load += new EventHandler(frmConfirm_Load);
            FormClosing += new FormClosingEventHandler(frmConfirm_FormClosing);

            // Function References
            DelProgram = new DelegateText(StudentInfoClass.GetProgram);
            DelLastName = new DelegateText(StudentInfoClass.GetLastName);
            DelFirstName = new DelegateText(StudentInfoClass.GetFirstName);
            DelMiddleName = new DelegateText(StudentInfoClass.GetMiddleName);
            DelAddress = new DelegateText(StudentInfoClass.GetAddress);

            DelNumAge = new DelegateNumber(StudentInfoClass.GetAge);
            DelNumContactNo = new DelegateNumber(StudentInfoClass.GetContactNo);
            DelStudNo = new DelegateNumber(StudentInfoClass.GetStudentNo);
        }

        private void submitButton_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void frmConfirm_Load(object sender, EventArgs e)
        {
            programLabel.Text = DelProgram(StudentInfoClass.Program);
            lastNameLabel.Text = DelLastName(StudentInfoClass.LastName);
            firstNameLabel.Text = DelFirstName(StudentInfoClass.FirstName);
            middleNameLabel.Text = DelMiddleName(StudentInfoClass.MiddleName);
            addressLabel.Text = DelAddress(StudentInfoClass.Address);

            ageLabel.Text = DelNumAge(StudentInfoClass.Age).ToString();
            contactNoLabel.Text = DelNumContactNo(StudentInfoClass.ContactNo).ToString();
            studentNoLabel.Text = DelStudNo(StudentInfoClass.StudentNo).ToString();
        }

        private void frmConfirm_FormClosing(object? sender, FormClosingEventArgs args)
        {
            DialogResult result = MessageBox.Show("Are you sure you want to submit this form?",
                                                  "Confirm Close",
                                                  MessageBoxButtons.YesNo,
                                                  MessageBoxIcon.Question);

            if (result == DialogResult.No)
            {
                args.Cancel = true;
            }
            else
            {
                this.DialogResult = DialogResult.OK;
            }
        }
    }
}
