
//javascript
const username = "cormacmadden"
const password = "nJM64e7lAmb2"

const clientID = "15257381503e8459f1cf0efef56f69f8a0073d09"

const headers = {
    "Authorization" : `Basic ${btoa(`${username}:${password}`)}`
}

const apiData = {
    url: 'https://api.github.com/',
    type: 'users',
    id: 'defunkt',
}

const apiURL = `${apiData.url}${apiData.type}/${apiData.id}`
const issuesUrl = 'https://api.github.com/search/repositories?q=stars:>100000'

const generateHTML = (data) => {
    console.log(data)
    data.items.forEach(i => console.log(i.full_name))

    const html = `
        <div class="name"> ${data.name}<\div>
        <div class="bio"> ${data.bio}<\div>
        `
    const d3Div = document.querySelector('.GitHub_d3')
    d3Div.innerHTML = html
}


fetch(issuesUrl)
    .then(data => data.json())
    .then((user) => generateHTML(user))

d3.selectAll();