
//submit button
const form = document.getElementById('form-submit')
//input
const item = document.getElementById('new-order')



const headers = {
'Content-Type': 'application/json'
}

const baseUrl = 'http://localhost:8080/api/v1/menu'

const handleSubmit = async (e) => {
    e.preventDefault()
    let bodyObj = {
        body: item.value
    }
    console.log(bodyObj)
    await addItem(bodyObj);
    item.value = ''
}

//ask about routing
async function addItem(obj) {
    const response = await fetch(`${baseUrl}order/${orderId}`, {
        method: "POST",
        body: JSON.stringify(obj),
        headers: headers
    })
        .catch(err => console.error(err.message))
    if (response.status == 200) {
        alert("Order Placed");
    }
}


// get next order id? or change routing above

async function getOrdersTableSize() {
    await fetch(`${baseUrl}user/${userId}`, {
        method: "GET",
        headers: headers
    })
        .then(response => response.json())
        .then(data => createNoteCards(data))
        .catch(err => console.error(err))
}
//getFetchSize();


//event listener
form.addEventListener('click', handleSubmit)