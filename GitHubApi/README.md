# CSU33012-Github-API
Assignment to visualize Github data using the Github API.

## Assigment Objectives:
* Use the GitHub API to retrieve and display data.
* Visualise the data in a useful or interesting manner. 

## Solution:
I decided it would be interesting to try recreate the popular ranking bar charts that you find on YouTube, but apply it to some data from the GitHub API.
Initially I wanted to show the top repositories on github over the years, but I found getting historical data for this difficult.
So I settled on ranking the number of commits for a single repository.

## Approach:
I initially spent a lot of time trying to use ASP.NET and code in c# but progress was painfully slow.
I then changed to using Javascript with Node.js. Although I had no experience with it, the programming needed was at a much higher level than what I needed for ASP.NET.

## Resources:
* **ASP.NET** - I had initially attempted to use this as I had experience with using APIs with C#, and a friend suggested it as a good option. However, I found retieving the data to be un-necessarily complicated.
* **blazer** - When using C# and ASP.NET I used blazer to display the information I was retreiving.
* **d3** - This was my main resource for visualising the data. I used an example from: https://observablehq.com/@d3/bar-chart-race-explained (It also proved to be a lot more difficult than I had expected.)
* **GitHub API** - I used the GitHub API to extract data.

### Visualisations:
![](README%20screenshots/Capture2.png)

## Running the project:
The project will be run in local host (http://localhost:3000 to view in browser). 
To run the project, all you must do is clone the repository and use the following commands:
* `cd Sweng-GitHub-Access/'Github Access'/github_analytics` 
* `npm install`
* `npm install d3`
* `npx https-server`
