using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CalculatorApplication
{
    public delegate T Formula<T>(T arg1, T arg2);

    public class CalculatorClass
    {
        public Formula<double> info;
        private event Formula<double> calculateEvent;
        public event Formula<double> CalculateEvent
        {
            add
            {
                calculateEvent += value;
                Console.WriteLine("Delegate has been added!");
            }
            remove
            {
                calculateEvent -= value;
                Console.WriteLine("Delegate has been removed!");
            }
        }

        public double GetSum(double num1, double num2) => num1 + num2;
        public double GetDifference(double num1, double num2) => num1 - num2;
        public double GetProduct(double num1, double num2) => num1 * num2;
        public double GetQuotient(double num1, double num2) => num1 / num2;
    }
}
