
//submit button
const form = document.getElementById('form-submit')
//input
const order = document.getElementById('new-order')



const headers = {
'Content-Type': 'application/json'
}

const baseUrl = 'http://localhost:8080/api/v1/menu'

const handleSubmit = async (e) => {
    e.preventDefault()
    let bodyObj = {
        body: order
    }
    await addOrder(bodyObj);
    order.value = ''
}

//ask about routing
async function addOrder(obj) {
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
getFetchSize();


//event listener
form.addEventListener('submit', handleSubmit)