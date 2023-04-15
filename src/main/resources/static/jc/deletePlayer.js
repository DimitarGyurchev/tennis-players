function deletePlayer(id) {
    fetch(`/players/delete/${id}`, {
        method: 'DELETE'
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            window.location.reload();
        })
        .catch(error => {
            console.error('There was a problem with the delete request:', error);
        });
}
