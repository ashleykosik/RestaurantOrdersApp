
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

const handleSubmit = async (e) => {
    e.preventDefault()
    let bodyObj = {
        body: item.value
    }

    console.log(bodyObj)
    const response = await fetch(`${baseUrl}/createOrder/${userId}`, {
            method: "POST",
            body: JSON.stringify(bodyObj),
            headers: headers
        })
            .catch(err => console.error(err.message))

        const responseArr = await response.json()

        if (response.status === 200){
            alert("Order Placed");
            item.value = ''
        }
}

form.addEventListener('click', handleSubmit)