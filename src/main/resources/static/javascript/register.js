//form, username, & password inputs/elements
const registerBtn =  document.getElementById('register-form')
const firstName = document.getElementById('first-name')
const lastName = document.getElementById('last-name')
const phoneNumber = document.getElementById('register-phone')
const email = document.getElementById('register-email')
const registerPassword = document.getElementById('register-password')

//

const headers = {
'Content-Type': 'application/json'
}

const baseUrl = 'http://localhost:8080/api/v1/employee'

const handleSubmit = async (e) => {
    e.preventDefault()


    let bodyObj = {
        email: email.value,
        firstName: firstName.value,
        lastName: lastName.value,
        password: registerPassword.value,
        phoneNumber: phoneNumber.value
    }

    console.log(bodyObj)

    const response = await fetch(`${baseUrl}/register`, {
        method: "POST",
        body: JSON.stringify(bodyObj),
        headers: headers
    })
        .catch(err => console.error(err.message))

    const responseArr = await response.json()

    if (response.status === 200){
        window.location.replace(responseArr[0]);
    }
}

registerBtn.addEventListener("click", handleSubmit)