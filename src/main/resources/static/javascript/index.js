
//html elements
const triggerOrder = document.getElementById('trigger-order')






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

async function handleDelete(noteId){
    await fetch(baseUrl + noteId, {
        method: "DELETE",
        headers: headers
    })
        .catch(err => console.error(err))

    return getNotes(userId);
}

async function handleNoteEdit(noteId){
    let bodyObj = {
        id: noteId,
        body: noteBody.value
    }

    await fetch(baseUrl, {
        method: "PUT",
        body: JSON.stringify(bodyObj),
        headers: headers
    })
        .catch(err => console.error(err))

    return getNotes(userId);
}

const createCards = (array) => {
const container = document.getElementById("active-orders")
    container.innerHTML = ''
    array.forEach(obj => {
    console.log(obj)
        let orderCard = document.createElement("div")
        orderCard.classList.add("m-2")
        orderCard.innerHTML = `
            <div class="card d-flex" style="width: 18rem; height: 18rem;">
                    <div class="card-body d-flex flex-column  justify-content-between" style="height: available">
                        <p class="card-text">Order #${obj.orderId}</p>
                        <div class="d-flex justify-content-between">
                            <button onclick="getNoteById(${obj.id})" type="button" class="lite-btn"
                                    data-bs-toggle="modal" data-bs-target="#note-edit-modal">
                                Edit
                            </button>
                            <button class="brown-btn btn" onclick="handleDelete(${obj.id})">Delete</button>
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
    noteBody.innerText = ''
    noteBody.innerText = obj.body
    updateNoteBtn.setAttribute('data-note-id', obj.id)
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
triggerOrder.addEventListener('click', createOrder)
// button to trigger delete

// trigger edit
//updateNoteBtn.addEventListener("click", (e)=>{
//    let noteId = e.target.getAttribute('data-note-id')
//    handleNoteEdit(noteId);
//})