
const cookieArr = document.cookie.split("=")
const userId = parseInt(cookieArr[1]);

//submit button
const form = document.getElementById('form-submit')
//input
const item = document.getElementById('new-order')

const headers = {
'Content-Type': 'application/json'
}

const baseUrl = 'http://localhost:8080/api/v1/order'

async function handleSubmit (e) {
    e.preventDefault()
    let bodyObj = {
        item: item.value
    }

    console.log(bodyObj)
    await fetch(`${baseUrl}/createOrder/${userId}`, {
            method: "POST",
            body: JSON.stringify(bodyObj),
            headers: headers
        })
            .catch(err => console.error(err.message))
            .then(alert("Order Placed"));

}

form.addEventListener('click', handleSubmit)