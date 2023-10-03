var submitButton = document.querySelector('.submit-button')
submitButton.addEventListener('click', postMessage)

function postMessage() {
	var messageInput = document.querySelector('#message-input')
	var channelId = extractChannelIdFromUrl()
	var messageText = messageInput.value
	var username = sessionStorage.getItem('username')
	
	var message = {
		"text": messageText,
		"user": username,
		"channelId": channelId
	}
	
	fetch('/message', {
				method: 'POST',
				headers: {
				'Content-Type': 'application/json'
				},
			body: JSON.stringify(message),
			responseType: 'json'
			})

    .then((response) => {
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        return response.json();
    })
    .then ((data) => {
            console.log(data)})
	.finally( () => {
		messageInput.value = ''
	})
}

function extractChannelIdFromUrl() {
    // Get the current URL
    var currentUrl = window.location.href;

    // Extract the channel ID from the URL (assuming it's the last segment)
    var segments = currentUrl.split('/');
    let channelId = segments[segments.length - 1];


    return channelId
    
    }



// Function to fetch and update messages
async function getMessages () {
    let channelId = extractChannelIdFromUrl()
	let messageContainer = document.querySelector("#messages")
	fetch(`/message/${channelId}`)
        .then(response => response.json())
        .then(messages => {
          messageContainer.innerHTML = "";
                              messages.forEach(message => {
                                  const messageElement = document.createElement("div");
                                  messageElement.innerText = `${message.user.username}: ${message.text}`;
                                  messageContainer.appendChild(messageElement);
            });
        })
        .catch(error => {
            console.error('Error during fetch:', error)
        })

}

document.getElementById('message-input').addEventListener('keydown', function (e) {
    if (e.key === 'Enter') {
        e.preventDefault(); // Prevent the default behavior (e.g., newline)
        postMessage(); // Call the postMessage function
    }
});


setInterval(getMessages, 500)