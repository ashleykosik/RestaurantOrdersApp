
// html elements
const loginBtn = document.getElementById('login-form')
const loginId = document.getElementById('employee-id')
const loginPassword = document.getElementById('login-password')

const headers = {
    'Content-type':'application/json'
}

const baseUrl = 'http://localhost:8080/api/v1/employee'

const handleSubmit = async (e) => {
    e.preventDefault()

    let bodyObj = {
        id: parseInt(loginId.value),
        password: loginPassword.value
    }
    console.log(bodyObj)
    const response = await fetch(`${baseUrl}/login`, {
        method: "POST",
        body: JSON.stringify(bodyObj),
        headers: headers
    })
        .catch(err => console.error(err.message))

        const responseArr = await response.json()
        if (response.status === 200) {
            document.cookie = `userId=${responseArr[1]}`
            alert(responseArr[0])
        }
}

loginBtn.addEventListener('click', handleSubmit)