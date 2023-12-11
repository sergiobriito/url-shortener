document.getElementById('apiForm').addEventListener('submit', function(e) {
    e.preventDefault();

    const apiUrl = "http://localhost:8080/api/v1/url-shortener"
    let requestData = document.getElementById('requestData').value;

    let myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");

    let requestBody = { "url": requestData };

    let requestOptions = {
      method: 'POST',
      headers: myHeaders,
      body: JSON.stringify(requestBody),
    };

    fetch(apiUrl, requestOptions)
      .then(response => response.text()) 
      .then(result => {
        document.getElementById('response').innerText = result;
      })
      .catch(error => {
        console.error('Error:', error);
        document.getElementById('response').innerText = 'Error: ' + error.message;
      });
});