function setUsername() {
    const usernameInput = document.getElementById('username');
    const username = usernameInput.value;

    if (username.trim() !== '') {
        // Save the username to sessionStorage
        sessionStorage.setItem('username', username);

        // Redirect to the channels page
        window.location.href = '/channels'; // Replace with your channels page URL
    }
}
