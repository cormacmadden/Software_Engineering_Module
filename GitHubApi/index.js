//javascript
const apiData = {
    url: 'https://api.github.com/',
    type: 'users',
    id: 'defunkt',
}

const apiURL = `${apiData.url}${apiData.type}/${apiData.id}`

fetch(apiURL) 
    .then(data => data.json())
    .then((user) => generateHTML(user))

const generateHTML = (data) => {
    console.log(data)
    const html = `
        <div class="name"> ${data.name}<\div>
        <div class="bio"> ${data.bio}<\div>
        `
    const d3Div = document.querySelector('.GitHub_d3')
    d3Div.innerHTML = html
}

d3.select();