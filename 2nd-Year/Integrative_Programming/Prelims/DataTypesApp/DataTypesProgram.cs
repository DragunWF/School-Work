using System;

namespace DataTypesApp
{
    class DataTypesProgram
    {
        private static void Main()
        {
            int apples = int.Parse(Input("Enter the pieces of apple(s)"));
            double price = double.Parse(Input($"Enter the total price of {apples} apple(s)"));
            Console.WriteLine($"The total price of {apples} apple(s) is {price}");
            Console.WriteLine($"The value of the original price is {price}");
            Console.WriteLine($"The value of the converted price is {Math.Floor(price)}");
        }

        private static string Input(string prompt)
        {
            Console.Write($"{prompt}: ");
            return Console.ReadLine();
        }
    }
}
