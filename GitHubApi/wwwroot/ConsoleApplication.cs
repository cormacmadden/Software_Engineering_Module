using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace GitHubApi.wwwroot
{
    public class ConsoleApplication
    {
    }
    namespace ConsoleApplication
    {
        class Program
        {
            static void Main(string[] args)
            {
                var client = new RestClient() { Method = "Get", EndPoint = "http://dry-cliffs-19849.herokuapp.com/users/2.json" };
                var result = client.MakeRequest();
                Console.WriteLine(result);
            }
        }

        class RestClient
        {
            public string EndPoint { get; set; } = string.Empty;
            public string Method { get; set; } = string.Empty;

            public string MakeRequest()
            {
                var request = WebRequest.Create(EndPoint) as WebRequest;

                request.Method = Method.ToString();
                using (var stream = new StreamReader(request.GetResponse().GetResponseStream()))
                {
                    var result = stream.ReadToEnd();
                    return result;
                }
            }


        }
    }
}
