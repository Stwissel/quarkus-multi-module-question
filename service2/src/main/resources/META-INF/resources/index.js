
const setupFetch = (button, target, url) => {
    button.addEventListener('click', (event) => {
        fetch(url)
            .then(resp => resp.json())
            .then(json => {
                target.innerText = JSON.stringify(json);
            })
            .catch(err => {
                console.error(err);
                target.innerText = err.message;
            });
    })
}


const bootstrap = () => {
    const button1 = document.getElementById('trigger1');
    const button2 = document.getElementById('trigger2');
    const target1 = document.getElementById('service1result');
    const target2 = document.getElementById('service2result');

    setupFetch(button1, target1, 'http://localhost:8080/hello');
    setupFetch(button2, target2, '/frontend');
}

// Bring the show on the road
if (document.readyState != 'loading') {
    bootstrap();
} else {
    document.addEventListener('DOMContentLoaded', bootstrap);
}