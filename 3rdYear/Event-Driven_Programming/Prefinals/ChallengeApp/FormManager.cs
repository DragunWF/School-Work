namespace ChallengeApp
{
    class FormManager
    {
        private static FrmRegistration frmRegistration;
        private static FrmStudentRecord frmStudentRecord;

        public static void openRegistrationForm()
        {
            frmRegistration.Show();
            frmStudentRecord.Hide();
        }

        public static void openStudentRecordForm()
        {
            if (frmStudentRecord == null)
            {
                frmStudentRecord = new FrmStudentRecord();
            }
            frmStudentRecord.Show();
            frmRegistration.Hide();
        }

        public static void setFrmRegistration(FrmRegistration value) => frmRegistration = value;
        public static FrmRegistration getFrmRegistration() => frmRegistration;
    }
}
