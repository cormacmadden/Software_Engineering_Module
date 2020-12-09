using GitHubApi.WebSite.Services;
using GitHubApi.wwwroot;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace GitHubApi.Controllers
{
    [Route("[controller]")]
    [ApiController]
    public class ProductsController : ControllerBase
    {
        public ProductsController(JsonFileProductService productService)
        {
            this.ProductService = ProductService;
        }

        public JsonFileProductService ProductService { get; }

        public IEnumerable<Product> Get()
        {
            return ProductService.GetProducts();
        }
    }
}
