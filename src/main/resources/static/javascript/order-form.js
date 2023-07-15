
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
    console.log(cookieArr)
    await addItem(bodyObj);
    item.value = ''
}


async function addItem(obj) {
    const response = await fetch(`${baseUrl}/createOrder/${userId}`, {
        method: "POST",
        body: JSON.stringify(obj),
        headers: headers
    })
        .catch(err => console.error(err.message))
    if (response.status == 200) {
        alert("Order Placed");
    }
}



async function getOrdersTableSize() {
    await fetch(`${baseUrl}user/${userId}`, {
        method: "GET",
        headers: headers
    })
        .then(response => response.json())
        .then(data => createNoteCards(data))
        .catch(err => console.error(err))
}

form.addEventListener('click', handleSubmit)