
//html elements
const triggerOrder = document.getElementById('trigger-order')
const updateOrderBtn = document.getElementById('edit-button')

const orderNum = document.getElementById('edit-order-number')
const item = document.getElementById('order-body')





const headers = {
'Content-Type': 'application/json'
}

const baseUrl = "http://localhost:8080/api/v1/"

async function getActiveOrders() {
    await fetch(`${baseUrl}order/active`, {
        method: "GET",
        headers: headers
    })
        .then(response => response.json())
        .then(data => createCards(data))
        .catch(err => console.error(err))
}

async function getAllOrders() {
    await fetch(`${baseUrl}order`, {
        method: "GET",
        headers: headers
    })
        .catch(err => console.error(err))
         // store orders.length in session storage
         return document.cookie = response
}

async function getOrderById(orderId) {
    await fetch(`${baseUrl}order/` + orderId, {
    method: "GET",
    headers: headers
    })
    .then(res => res.json())
    .then(data => populateModal(data))
    .catch(err => console.error(err.message))
}

async function handleDelete(orderId){
    await fetch(`${baseUrl}order/` + orderId, {
        method: "DELETE",
        headers: headers
    })
        .catch(err => console.error(err))

    return getActiveOrders();
}

async function handleOrderEdit(e){
       e.preventDefault()
    let bodyObj = {
        orderId: orderNum.value,
        item: item.value
    }
    console.log(bodyObj)

    await fetch(baseUrl + `order`, {
        method: "PUT",
        body: JSON.stringify(bodyObj),
        headers: headers
    })
        .catch(err => console.error(err))

    return getActiveOrders();
}

const createCards = (array) => {
const container = document.getElementById("active-orders")
    container.innerHTML = ''
    array.forEach(obj => {
    //console.log(obj)
        let orderCard = document.createElement("div")
        orderCard.classList.add("m-2")
        orderCard.innerHTML = `
            <div class="card d-flex" style="width: 18rem; height: 18rem;">
                    <div class="card-body d-flex flex-column  justify-content-between" style="height: available">
                        <h2>Order #${obj.orderId}</h2>
                            <p id="body${obj.orderId}">${obj.item}</p>

                        <div class="d-flex justify-content-between">
                            <button class="brown-btn" onclick="handleDelete(${obj.orderId})">Delete</button>
                        </div>
                    </div>
                </div>
        `
        container.append(orderCard);
    })
}


function handleLogout(){
    let c = document.cookie.split(";");
    for(let i in c){
        document.cookie = /^[^=]+/.exec(c[i])[0]+"=;expires=Thu, 01 Jan 1970 00:00:00 GMT"
    }
}

const populateModal = (obj) =>{
    console.log(obj)
    body.innerText = ''
    body.innerText = obj.body
    updateOrderBtn.setAttribute('data-note-id', obj.id)
}

async function createOrder() {
    const response = await fetch(`${baseUrl}order/createOrder`, {
            method: "POST",
            headers: headers
        })
            .catch(err => console.error(err.message))
            const responseArr = await response.json()
        if (response.status == 200) {
           window.location.replace(responseArr[0])
           return getAllOrders()
        }
    }

getActiveOrders();

// trigger order form page
//triggerOrder.addEventListener('click', createOrder)
// button to trigger delete

// trigger edit
updateOrderBtn.addEventListener("click", handleOrderEdit);
//})