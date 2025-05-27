using Microsoft.AspNetCore.Mvc;

namespace PT_Plarisan_Marc.Controllers
{
    public class MovieController : Controller
    {
        public IActionResult Index()
        {
            return View();
        }
    }
}
