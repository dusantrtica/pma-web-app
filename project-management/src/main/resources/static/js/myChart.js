const decodeHtml =(html) => {
    var txt = document.createElement("textarea");
    txt.innerHTML = html;
    return txt.value;
}

var chartData = decodeHtml(chartData);
var chartJsonArray = JSON.parse(chartData);

var numericData = chartJsonArray.map(({value}) => value);
var labelData = chartJsonArray.map(({label}) => label);

new Chart(document.getElementById('myPieChart'), {
    type: 'pie',
    data: {
        labels: labelData,
        datasets: [
            {
                data: numericData,
                backgroundColor: ["red", "blue", "green"],  
            }
        ]
    },
    options: {
        title: {
            display: true,
            text: "Project statuses"
        }
    }
});
