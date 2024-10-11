using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Inventory
{
    class NumberFormatException : Exception
    {
        public NumberFormatException(string message) : base(message) { }
    }

    class StringFormatException : Exception
    {
        public StringFormatException(string message) : base(message) { }
    }

    class CurrencyFormatException : Exception
    {
        public CurrencyFormatException(string message) : base(message) { }
    }
}
