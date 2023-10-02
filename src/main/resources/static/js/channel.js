var submitButton = document.querySelector('.submit-button')
submitButton.addEventListener('click', postMessage)

async function postMessage() {
	var messageInput = document.querySelector('#message-input')
	var channelId = extractChannelIdFromUrl()
	var messageText = messageInput.value
	var username = sessionStorage.getItem('username')
	
	var message = {
		"text": messageText,
		"user": {"username": username},
		"channelId": channelId
	}
	
	fetch('/message', {
				method: 'POST',
				headers: {
				'Content-Type': 'application/json'
				},
			body: JSON.stringify(message)
			})
	.then((response) => response.json())
	.then( (response) => {
		console.log(response)
	})
	.catch( (error) => {
	        console.error(error)
	        })
	.finally( () => {
		messageInput.value = ''
	})
}

function extractChannelIdFromUrl() {
    // Get the current URL
    var currentUrl = window.location.href;

    // Extract the channel ID from the URL (assuming it's the last segment)
    var segments = currentUrl.split('/');
    var extractedId = segments[segments.length - 1];

    return extractedId
    
    }