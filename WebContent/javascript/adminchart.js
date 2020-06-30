/**
 * 
 */

//var ctx = document.getElementById("myChart").getContext('2d');

var myChartData = {
type: 'bar',
data: {
labels: ["Charmaine", "Stanley", "Phyllis", "Jim", "Todd", "Dwight"],
datasets: [{
label: 'June Car Sales By Employee',
data: [10, 8, 8, 8, 1, 15],
backgroundColor: [
'rgba(255, 99, 132, 0.2)',
'rgba(54, 162, 235, 0.2)',
'rgba(255, 206, 86, 0.2)',
'rgba(75, 192, 192, 0.2)',
'rgba(153, 102, 255, 0.2)',
'rgba(255, 159, 64, 0.2)'
],
borderColor: [
'rgba(255,99,132,1)',
'rgba(54, 162, 235, 1)',
'rgba(255, 206, 86, 1)',
'rgba(75, 192, 192, 1)',
'rgba(153, 102, 255, 1)',
'rgba(255, 159, 64, 1)'
],
borderWidth: 1
}]
},
options: {
scales: {
yAxes: [{
ticks: {
beginAtZero: true
}
}]
}
}
}

var myChart = document.getElementById("myChart").getContext('2d');
new Chart(myChart, myChartData);
//new Chart(myChart).Line(myChartData);