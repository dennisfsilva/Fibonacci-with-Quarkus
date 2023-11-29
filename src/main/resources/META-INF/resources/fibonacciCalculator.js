// Asynchronous function to calculate Fibonacci
async function calculateFibonacci() {
    const apiEndpoint = 'http://localhost:8080/fibonacci/';
    const numberInput = document.getElementById('number');
    const resultsTableBody = document.getElementById('resultsTableBody');

    // Parse the input value as an integer
    const number = parseInt(numberInput.value);

    // Check if the input is a non-negative number
    if (number < 0) {
        // Add a visual indication for an invalid input
        numberInput.classList.add('invalid-input');
        return;
    }

    try {
        // Fetch data from the API
        const response = await fetch(`${apiEndpoint}${number}`);
        const result = await response.json();

        // Create a new row and insert the result into the results table
        const row = document.createElement('tr');
        row.innerHTML = `
            <td class="py-2 px-4 whitespace-nowrap text-sm font-medium text-white dark:text-white">${number}</td>
            <td class="py-2 px-4 whitespace-nowrap text-sm text-white dark:text-white">${result}</td>
        `;
        resultsTableBody.prepend(row);

        // Clear input field after successful calculation
        numberInput.value = '';
    } catch (error) {
        // Log and display an error message
        console.error('Error fetching data:', error);
        showError('An error occurred. Please try again.');
    }

    // Function to display an error message
    function showError(message) {
        const errorContainer = document.getElementById('errorContainer');
        errorContainer.innerText = message;
    }
}
