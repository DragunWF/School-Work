namespace QueuingProgram
{
    public class CashierClass
    {
        private int x;
        private static string lastDequeuedNum;
        public static string getNumberInQueue = "";
        public static Queue<string> CashierQueue;

        public CashierClass()
        {
            x = 10000;
            CashierQueue = new Queue<string>();
        }

        public string CashierGeneratedNumber(string CashierNumber)
        {
            x++;
            CashierNumber = CashierNumber + x.ToString();
            return CashierNumber;
        }

        public static void CallNextInLine()
        {
            if (CashierQueue.Count > 0)
            {
                lastDequeuedNum = CashierQueue.Dequeue();
            }
        }

        public static string getLastDequeuedNum() => lastDequeuedNum;
    }
}
