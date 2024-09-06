using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Reflection.Metadata.Ecma335;
using System.Text;
using System.Threading.Tasks;
using static System.Windows.Forms.VisualStyles.VisualStyleElement;

namespace AccountRegistration
{
    public class StudentInfoClass
    {
        public static string FirstName = " ", LastName = " ", MiddleName = " ", Address = " ", Program = " ";
        public static long Age = 0, ContactNo = 0, StudentNo = 0;

        public delegate long DelegateNumber(long Number);
        public delegate string DelegateText(string Text);

        #region Getter methods for String types

        public static string GetFirstName(string firstName) => firstName;
        public static string GetLastName(string lastName) => lastName;
        public static string GetMiddleName(string middleName) => middleName;
        public static string GetAddress(string address) => address;
        public static string GetProgram(string program) => program;

        #endregion

        #region Getter Methods for Long Types

        public static long GetAge(long age) => age;
        public static long GetContactNo(long contactNo) => contactNo;
        public static long GetStudentNo(long studentNo) => studentNo;

        #endregion
    }
}
