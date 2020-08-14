var options = { weekday: 'long', year: 'numeric', month: 'long', day: 'numeric' };

(function ($) {
  // USE STRICT
  "use strict";

  try {
    //WidgetChart 1
    var ctx = document.getElementById("widgetChart1");
    if (ctx) {
      ctx.height = 130;
      var myChart = new Chart(ctx, {
        type: 'line',
        data: {
          labels: [dow[0], dow[1], dow[2], dow[3], dow[4], dow[5], dow[6]],
          type: 'line',
          datasets: [{
            data: [userCount[0], userCount[1], userCount[2], userCount[3],userCount[4], userCount[5], userCount[6]],
            label: 'Count',
            backgroundColor: 'rgba(255,255,255,.1)',
            borderColor: 'rgba(255,255,255,.55)',
          },]
        },
        options: {
          maintainAspectRatio: true,
          legend: {
            display: false
          },
          layout: {
            padding: {
              left: 0,
              right: 0,
              top: 0,
              bottom: 0
            }
          },
          responsive: true,
          scales: {
            xAxes: [{
              gridLines: {
                color: 'transparent',
                zeroLineColor: 'transparent'
              },
              ticks: {
                fontSize: 2,
                fontColor: 'transparent'
              }
            }],
            yAxes: [{
              display: false,
              ticks: {
                display: false,
              }
            }]
          },
          title: {
            display: false,
          },
          elements: {
            line: {
              borderWidth: 0
            },
            point: {
              radius: 0,
              hitRadius: 10,
              hoverRadius: 4
            }
          }
        }
      });
    }


    //WidgetChart 2
    var ctx = document.getElementById("widgetChart2");
    if (ctx) {
      ctx.height = 130;
      var myChart = new Chart(ctx, {
        type: 'line',
        data: {
          labels: ['January', 'February', 'March', 'April', 'May', 'June'],
          type: 'line',
          datasets: [{
            data: [1, 18, 9, 17, 34, 22],
            label: 'Dataset',
            backgroundColor: 'transparent',
            borderColor: 'rgba(255,255,255,.55)',
          },]
        },
        options: {

          maintainAspectRatio: false,
          legend: {
            display: false
          },
          responsive: true,
          tooltips: {
            mode: 'index',
            titleFontSize: 12,
            titleFontColor: '#000',
            bodyFontColor: '#000',
            backgroundColor: '#fff',
            titleFontFamily: 'Montserrat',
            bodyFontFamily: 'Montserrat',
            cornerRadius: 3,
            intersect: false,
          },
          scales: {
            xAxes: [{
              gridLines: {
                color: 'transparent',
                zeroLineColor: 'transparent'
              },
              ticks: {
                fontSize: 2,
                fontColor: 'transparent'
              }
            }],
            yAxes: [{
              display: false,
              ticks: {
                display: false,
              }
            }]
          },
          title: {
            display: false,
          },
          elements: {
            line: {
              tension: 0.00001,
              borderWidth: 1
            },
            point: {
              radius: 4,
              hitRadius: 10,
              hoverRadius: 4
            }
          }
        }
      });
    }


    //WidgetChart 3
    var ctx = document.getElementById("widgetChart3");
    if (ctx) {
      ctx.height = 130;
      var myChart = new Chart(ctx, {
        type: 'line',
        data: {
          labels: ['January', 'February', 'March', 'April', 'May', 'June'],
          type: 'line',
          datasets: [{
            data: [65, 59, 84, 84, 51, 55],
            label: 'Dataset',
            backgroundColor: 'transparent',
            borderColor: 'rgba(255,255,255,.55)',
          },]
        },
        options: {

          maintainAspectRatio: false,
          legend: {
            display: false
          },
          responsive: true,
          tooltips: {
            mode: 'index',
            titleFontSize: 12,
            titleFontColor: '#000',
            bodyFontColor: '#000',
            backgroundColor: '#fff',
            titleFontFamily: 'Montserrat',
            bodyFontFamily: 'Montserrat',
            cornerRadius: 3,
            intersect: false,
          },
          scales: {
            xAxes: [{
              gridLines: {
                color: 'transparent',
                zeroLineColor: 'transparent'
              },
              ticks: {
                fontSize: 2,
                fontColor: 'transparent'
              }
            }],
            yAxes: [{
              display: false,
              ticks: {
                display: false,
              }
            }]
          },
          title: {
            display: false,
          },
          elements: {
            line: {
              borderWidth: 1
            },
            point: {
              radius: 4,
              hitRadius: 10,
              hoverRadius: 4
            }
          }
        }
      });
    }


    //WidgetChart 4
    var ctx = document.getElementById("widgetChart4");
    if (ctx) {
      ctx.height = 115;
      var myChart = new Chart(ctx, {
        type: 'bar',
        data: {
          labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'],
          datasets: [
            {
              label: "My First dataset",
              data: [78, 81, 80, 65, 58, 75, 60, 75, 65, 60, 60, 75],
              borderColor: "transparent",
              borderWidth: "0",
              backgroundColor: "rgba(255,255,255,.3)"
            }
          ]
        },
        options: {
          maintainAspectRatio: true,
          legend: {
            display: false
          },
          scales: {
            xAxes: [{
              display: false,
              categoryPercentage: 1,
              barPercentage: 0.65
            }],
            yAxes: [{
              display: false
            }]
          }
        }
      });
    }

    // Recent Report
    const brandProduct = 'rgba(0,181,233,0.8)'
    const brandService = 'rgba(0,173,95,0.8)'

    var elements = 10
    var data1 = [52, 60, 55, 50, 65, 80, 57, 70, 105, 115]
    var data2 = [102, 70, 80, 100, 56, 53, 80, 75, 65, 90]

    var ctx = document.getElementById("recent-rep-chart");
    if (ctx) {
      ctx.height = 250;
      var myChart = new Chart(ctx, {
        type: 'line',
        data: {
          labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', ''],
          datasets: [
            {
              label: 'My First dataset',
              backgroundColor: brandService,
              borderColor: 'transparent',
              pointHoverBackgroundColor: '#fff',
              borderWidth: 0,
              data: data1

            },
            {
              label: 'My Second dataset',
              backgroundColor: brandProduct,
              borderColor: 'transparent',
              pointHoverBackgroundColor: '#fff',
              borderWidth: 0,
              data: data2

            }
          ]
        },
        options: {
          maintainAspectRatio: true,
          legend: {
            display: false
          },
          responsive: true,
          scales: {
            xAxes: [{
              gridLines: {
                drawOnChartArea: true,
                color: '#f2f2f2'
              },
              ticks: {
                fontFamily: "Poppins",
                fontSize: 12
              }
            }],
            yAxes: [{
              ticks: {
                beginAtZero: true,
                maxTicksLimit: 5,
                stepSize: 50,
                max: 150,
                fontFamily: "Poppins",
                fontSize: 12
              },
              gridLines: {
                display: true,
                color: '#f2f2f2'

              }
            }]
          },
          elements: {
            point: {
              radius: 0,
              hitRadius: 10,
              hoverRadius: 4,
              hoverBorderWidth: 3
            }
          }


        }
      });
    }

    // Percent Chart
    var ctx = document.getElementById("percent-chart");
    if (ctx) {
      ctx.height = 280;
      var myChart = new Chart(ctx, {
        type: 'doughnut',
        data: {
          datasets: [
            {
              label: "My First dataset",
              data: [60, 40],
              backgroundColor: [
                '#00b5e9',
                '#fa4251'
              ],
              hoverBackgroundColor: [
                '#00b5e9',
                '#fa4251'
              ],
              borderWidth: [
                0, 0
              ],
              hoverBorderColor: [
                'transparent',
                'transparent'
              ]
            }
          ],
          labels: [
            'Products',
            'Services'
          ]
        },
        options: {
          maintainAspectRatio: false,
          responsive: true,
          cutoutPercentage: 55,
          animation: {
            animateScale: true,
            animateRotate: true
          },
          legend: {
            display: false
          },
          tooltips: {
            titleFontFamily: "Poppins",
            xPadding: 15,
            yPadding: 10,
            caretPadding: 0,
            bodyFontSize: 16
          }
        }
      });
    }

  } catch (error) {
    console.log(error);
  }



  try {

    // Recent Report 2
    const bd_brandProduct2 = 'rgba(0,181,233,0.9)'
    const bd_brandService2 = 'rgba(0,173,95,0.9)'
    const brandProduct2 = 'rgba(0,181,233,0.2)'
    const brandService2 = 'rgba(0,173,95,0.2)'

    var data3 = [52, 60, 55, 50, 65, 80, 57, 70, 105, 115]
    var data4 = [102, 70, 80, 100, 56, 53, 80, 75, 65, 90]

    var ctx = document.getElementById("recent-rep2-chart");
    if (ctx) {
      ctx.height = 230;
      var myChart = new Chart(ctx, {
        type: 'line',
        data: {
          labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', ''],
          datasets: [
            {
              label: 'My First dataset',
              backgroundColor: brandService2,
              borderColor: bd_brandService2,
              pointHoverBackgroundColor: '#fff',
              borderWidth: 0,
              data: data3

            },
            {
              label: 'My Second dataset',
              backgroundColor: brandProduct2,
              borderColor: bd_brandProduct2,
              pointHoverBackgroundColor: '#fff',
              borderWidth: 0,
              data: data4

            }
          ]
        },
        options: {
          maintainAspectRatio: true,
          legend: {
            display: false
          },
          responsive: true,
          scales: {
            xAxes: [{
              gridLines: {
                drawOnChartArea: true,
                color: '#f2f2f2'
              },
              ticks: {
                fontFamily: "Poppins",
                fontSize: 12
              }
            }],
            yAxes: [{
              ticks: {
                beginAtZero: true,
                maxTicksLimit: 5,
                stepSize: 50,
                max: 150,
                fontFamily: "Poppins",
                fontSize: 12
              },
              gridLines: {
                display: true,
                color: '#f2f2f2'

              }
            }]
          },
          elements: {
            point: {
              radius: 0,
              hitRadius: 10,
              hoverRadius: 4,
              hoverBorderWidth: 3
            },
            line: {
              tension: 0
            }
          }


        }
      });
    }

  } catch (error) {
    console.log(error);
  }


  try {

    // Recent Report 3
    const bd_brandProduct3 = 'rgba(0,181,233,0.9)';
    const bd_brandService3 = 'rgba(0,173,95,0.9)';
    const brandProduct3 = 'transparent';
    const brandService3 = 'transparent';

    var data5 = [52, 60, 55, 50, 65, 80, 57, 115];
    var data6 = [102, 70, 80, 100, 56, 53, 80, 90];

    var ctx = document.getElementById("recent-rep3-chart");
    if (ctx) {
      ctx.height = 230;
      var myChart = new Chart(ctx, {
        type: 'line',
        data: {
          labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July', ''],
          datasets: [
            {
              label: 'My First dataset',
              backgroundColor: brandService3,
              borderColor: bd_brandService3,
              pointHoverBackgroundColor: '#fff',
              borderWidth: 0,
              data: data5,
              pointBackgroundColor: bd_brandService3
            },
            {
              label: 'My Second dataset',
              backgroundColor: brandProduct3,
              borderColor: bd_brandProduct3,
              pointHoverBackgroundColor: '#fff',
              borderWidth: 0,
              data: data6,
              pointBackgroundColor: bd_brandProduct3

            }
          ]
        },
        options: {
          maintainAspectRatio: false,
          legend: {
            display: false
          },
          responsive: true,
          scales: {
            xAxes: [{
              gridLines: {
                drawOnChartArea: true,
                color: '#f2f2f2'
              },
              ticks: {
                fontFamily: "Poppins",
                fontSize: 12
              }
            }],
            yAxes: [{
              ticks: {
                beginAtZero: true,
                maxTicksLimit: 5,
                stepSize: 50,
                max: 150,
                fontFamily: "Poppins",
                fontSize: 12
              },
              gridLines: {
                display: false,
                color: '#f2f2f2'
              }
            }]
          },
          elements: {
            point: {
              radius: 3,
              hoverRadius: 4,
              hoverBorderWidth: 3,
              backgroundColor: '#333'
            }
          }


        }
      });
    }

  } catch (error) {
    console.log(error);
  }

  try {
    //WidgetChart 5
    var ctx = document.getElementById("widgetChart5");
    if (ctx) {
      ctx.height = 220;
      var myChart = new Chart(ctx, {
        type: 'bar',
        data: {
          labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'],
          datasets: [
            {
              label: "My First dataset",
              data: [78, 81, 80, 64, 65, 80, 70, 75, 67, 85, 66, 68],
              borderColor: "transparent",
              borderWidth: "0",
              backgroundColor: "#ccc",
            }
          ]
        },
        options: {
          maintainAspectRatio: true,
          legend: {
            display: false
          },
          scales: {
            xAxes: [{
              display: false,
              categoryPercentage: 1,
              barPercentage: 0.65
            }],
            yAxes: [{
              display: false
            }]
          }
        }
      });
    }

  } catch (error) {
    console.log(error);
  }

  try {

    // Percent Chart 2
    var ctx = document.getElementById("percent-chart2");
    if (ctx) {
      ctx.height = 209;
      var myChart = new Chart(ctx, {
        type: 'doughnut',
        data: {
          datasets: [
            {
              label: "My First dataset",
              data: [60, 40],
              backgroundColor: [
                '#00b5e9',
                '#fa4251'
              ],
              hoverBackgroundColor: [
                '#00b5e9',
                '#fa4251'
              ],
              borderWidth: [
                0, 0
              ],
              hoverBorderColor: [
                'transparent',
                'transparent'
              ]
            }
          ],
          labels: [
            'Products',
            'Services'
          ]
        },
        options: {
          maintainAspectRatio: false,
          responsive: true,
          cutoutPercentage: 87,
          animation: {
            animateScale: true,
            animateRotate: true
          },
          legend: {
            display: false,
            position: 'bottom',
            labels: {
              fontSize: 14,
              fontFamily: "Poppins,sans-serif"
            }

          },
          tooltips: {
            titleFontFamily: "Poppins",
            xPadding: 15,
            yPadding: 10,
            caretPadding: 0,
            bodyFontSize: 16,
          }
        }
      });
    }

  } catch (error) {
    console.log(error);
  }

  try {
    //Sales chart
    var ctx = document.getElementById("sales-chart");
    if (ctx) {
      ctx.height = 150;
      var myChart = new Chart(ctx, {
        type: 'line',
        data: {
          labels: ["2010", "2011", "2012", "2013", "2014", "2015", "2016"],
          type: 'line',
          defaultFontFamily: 'Poppins',
          datasets: [{
            label: "Foods",
            data: [0, 30, 10, 120, 50, 63, 10],
            backgroundColor: 'transparent',
            borderColor: 'rgba(220,53,69,0.75)',
            borderWidth: 3,
            pointStyle: 'circle',
            pointRadius: 5,
            pointBorderColor: 'transparent',
            pointBackgroundColor: 'rgba(220,53,69,0.75)',
          }, {
            label: "Electronics",
            data: [0, 50, 40, 80, 40, 79, 120],
            backgroundColor: 'transparent',
            borderColor: 'rgba(40,167,69,0.75)',
            borderWidth: 3,
            pointStyle: 'circle',
            pointRadius: 5,
            pointBorderColor: 'transparent',
            pointBackgroundColor: 'rgba(40,167,69,0.75)',
          }]
        },
        options: {
          responsive: true,
          tooltips: {
            mode: 'index',
            titleFontSize: 12,
            titleFontColor: '#000',
            bodyFontColor: '#000',
            backgroundColor: '#fff',
            titleFontFamily: 'Poppins',
            bodyFontFamily: 'Poppins',
            cornerRadius: 3,
            intersect: false,
          },
          legend: {
            display: false,
            labels: {
              usePointStyle: true,
              fontFamily: 'Poppins',
            },
          },
          scales: {
            xAxes: [{
              display: true,
              gridLines: {
                display: false,
                drawBorder: false
              },
              scaleLabel: {
                display: false,
                labelString: 'Month'
              },
              ticks: {
                fontFamily: "Poppins"
              }
            }],
            yAxes: [{
              display: true,
              gridLines: {
                display: false,
                drawBorder: false
              },
              scaleLabel: {
                display: true,
                labelString: 'Value',
                fontFamily: "Poppins"

              },
              ticks: {
                fontFamily: "Poppins"
              }
            }]
          },
          title: {
            display: false,
            text: 'Normal Legend'
          }
        }
      });
    }


  } catch (error) {
    console.log(error);
  }

  try {

    //Team chart
    var ctx = document.getElementById("team-chart");
    if (ctx) {
      ctx.height = 150;
      var myChart = new Chart(ctx, {
        type: 'line',
        data: {
          labels: ["2010", "2011", "2012", "2013", "2014", "2015", "2016"],
          type: 'line',
          defaultFontFamily: 'Poppins',
          datasets: [{
            data: [0, 7, 3, 5, 2, 10, 7],
            label: "Expense",
            backgroundColor: 'rgba(0,103,255,.15)',
            borderColor: 'rgba(0,103,255,0.5)',
            borderWidth: 3.5,
            pointStyle: 'circle',
            pointRadius: 5,
            pointBorderColor: 'transparent',
            pointBackgroundColor: 'rgba(0,103,255,0.5)',
          },]
        },
        options: {
          responsive: true,
          tooltips: {
            mode: 'index',
            titleFontSize: 12,
            titleFontColor: '#000',
            bodyFontColor: '#000',
            backgroundColor: '#fff',
            titleFontFamily: 'Poppins',
            bodyFontFamily: 'Poppins',
            cornerRadius: 3,
            intersect: false,
          },
          legend: {
            display: false,
            position: 'top',
            labels: {
              usePointStyle: true,
              fontFamily: 'Poppins',
            },


          },
          scales: {
            xAxes: [{
              display: true,
              gridLines: {
                display: false,
                drawBorder: false
              },
              scaleLabel: {
                display: false,
                labelString: 'Month'
              },
              ticks: {
                fontFamily: "Poppins"
              }
            }],
            yAxes: [{
              display: true,
              gridLines: {
                display: false,
                drawBorder: false
              },
              scaleLabel: {
                display: true,
                labelString: 'Value',
                fontFamily: "Poppins"
              },
              ticks: {
                fontFamily: "Poppins"
              }
            }]
          },
          title: {
            display: false,
          }
        }
      });
    }


  } catch (error) {
    console.log(error);
  }

  try {
    //bar chart
    var ctx = document.getElementById("barChart");
    if (ctx) {
      ctx.height = 200;
      var myChart = new Chart(ctx, {
        type: 'bar',
        defaultFontFamily: 'Poppins',
        data: {
          labels: ["January", "February", "March", "April", "May", "June", "July"],
          datasets: [
            {
              label: "My First dataset",
              data: [65, 59, 80, 81, 56, 55, 40],
              borderColor: "rgba(0, 123, 255, 0.9)",
              borderWidth: "0",
              backgroundColor: "rgba(0, 123, 255, 0.5)",
              fontFamily: "Poppins"
            },
            {
              label: "My Second dataset",
              data: [28, 48, 40, 19, 86, 27, 90],
              borderColor: "rgba(0,0,0,0.09)",
              borderWidth: "0",
              backgroundColor: "rgba(0,0,0,0.07)",
              fontFamily: "Poppins"
            }
          ]
        },
        options: {
          legend: {
            position: 'top',
            labels: {
              fontFamily: 'Poppins'
            }

          },
          scales: {
            xAxes: [{
              ticks: {
                fontFamily: "Poppins"

              }
            }],
            yAxes: [{
              ticks: {
                beginAtZero: true,
                fontFamily: "Poppins"
              }
            }]
          }
        }
      });
    }


  } catch (error) {
    console.log(error);
  }

  try {

    //radar chart
    var ctx = document.getElementById("radarChart");
    if (ctx) {
      ctx.height = 200;
      var myChart = new Chart(ctx, {
        type: 'radar',
        data: {
          labels: [["Eating", "Dinner"], ["Drinking", "Water"], "Sleeping", ["Designing", "Graphics"], "Coding", "Cycling", "Running"],
          defaultFontFamily: 'Poppins',
          datasets: [
            {
              label: "My First dataset",
              data: [65, 59, 66, 45, 56, 55, 40],
              borderColor: "rgba(0, 123, 255, 0.6)",
              borderWidth: "1",
              backgroundColor: "rgba(0, 123, 255, 0.4)"
            },
            {
              label: "My Second dataset",
              data: [28, 12, 40, 19, 63, 27, 87],
              borderColor: "rgba(0, 123, 255, 0.7",
              borderWidth: "1",
              backgroundColor: "rgba(0, 123, 255, 0.5)"
            }
          ]
        },
        options: {
          legend: {
            position: 'top',
            labels: {
              fontFamily: 'Poppins'
            }

          },
          scale: {
            ticks: {
              beginAtZero: true,
              fontFamily: "Poppins"
            }
          }
        }
      });
    }

  } catch (error) {
    console.log(error)
  }

  try {

    //line chart
    var ctx = document.getElementById("lineChart");
    if (ctx) {
      ctx.height = 150;
      var myChart = new Chart(ctx, {
        type: 'line',
        data: {
          labels: ["January", "February", "March", "April", "May", "June", "July"],
          defaultFontFamily: "Poppins",
          datasets: [
            {
              label: "My First dataset",
              borderColor: "rgba(0,0,0,.09)",
              borderWidth: "1",
              backgroundColor: "rgba(0,0,0,.07)",
              data: [22, 44, 67, 43, 76, 45, 12]
            },
            {
              label: "My Second dataset",
              borderColor: "rgba(0, 123, 255, 0.9)",
              borderWidth: "1",
              backgroundColor: "rgba(0, 123, 255, 0.5)",
              pointHighlightStroke: "rgba(26,179,148,1)",
              data: [16, 32, 18, 26, 42, 33, 44]
            }
          ]
        },
        options: {
          legend: {
            position: 'top',
            labels: {
              fontFamily: 'Poppins'
            }

          },
          responsive: true,
          tooltips: {
            mode: 'index',
            intersect: false
          },
          hover: {
            mode: 'nearest',
            intersect: true
          },
          scales: {
            xAxes: [{
              ticks: {
                fontFamily: "Poppins"

              }
            }],
            yAxes: [{
              ticks: {
                beginAtZero: true,
                fontFamily: "Poppins"
              }
            }]
          }

        }
      });
    }


  } catch (error) {
    console.log(error);
  }


  try {

    //doughut chart
    var ctx = document.getElementById("doughutChart");
    if (ctx) {
      ctx.height = 150;
      var myChart = new Chart(ctx, {
        type: 'doughnut',
        data: {
          datasets: [{
            data: [45, 25, 20, 10],
            backgroundColor: [
              "rgba(0, 123, 255,0.9)",
              "rgba(0, 123, 255,0.7)",
              "rgba(0, 123, 255,0.5)",
              "rgba(0,0,0,0.07)"
            ],
            hoverBackgroundColor: [
              "rgba(0, 123, 255,0.9)",
              "rgba(0, 123, 255,0.7)",
              "rgba(0, 123, 255,0.5)",
              "rgba(0,0,0,0.07)"
            ]

          }],
          labels: [
            "Green",
            "Green",
            "Green",
            "Green"
          ]
        },
        options: {
          legend: {
            position: 'top',
            labels: {
              fontFamily: 'Poppins'
            }

          },
          responsive: true
        }
      });
    }


  } catch (error) {
    console.log(error);
  }


  try {

    //pie chart
    var ctx = document.getElementById("pieChart");
    if (ctx) {
      ctx.height = 200;
      var myChart = new Chart(ctx, {
        type: 'pie',
        data: {
          datasets: [{
            data: [45, 25, 20, 10],
            backgroundColor: [
              "rgba(0, 123, 255,0.9)",
              "rgba(0, 123, 255,0.7)",
              "rgba(0, 123, 255,0.5)",
              "rgba(0,0,0,0.07)"
            ],
            hoverBackgroundColor: [
              "rgba(0, 123, 255,0.9)",
              "rgba(0, 123, 255,0.7)",
              "rgba(0, 123, 255,0.5)",
              "rgba(0,0,0,0.07)"
            ]

          }],
          labels: [
            "Green",
            "Green",
            "Green"
          ]
        },
        options: {
          legend: {
            position: 'top',
            labels: {
              fontFamily: 'Poppins'
            }

          },
          responsive: true
        }
      });
    }


  } catch (error) {
    console.log(error);
  }

  try {

    // polar chart
    var ctx = document.getElementById("polarChart");
    if (ctx) {
      ctx.height = 200;
      var myChart = new Chart(ctx, {
        type: 'polarArea',
        data: {
          datasets: [{
            data: [15, 18, 9, 6, 19],
            backgroundColor: [
              "rgba(0, 123, 255,0.9)",
              "rgba(0, 123, 255,0.8)",
              "rgba(0, 123, 255,0.7)",
              "rgba(0,0,0,0.2)",
              "rgba(0, 123, 255,0.5)"
            ]

          }],
          labels: [
            "Green",
            "Green",
            "Green",
            "Green"
          ]
        },
        options: {
          legend: {
            position: 'top',
            labels: {
              fontFamily: 'Poppins'
            }

          },
          responsive: true
        }
      });
    }

  } catch (error) {
    console.log(error);
  }

  try {

    // single bar chart
    var ctx = document.getElementById("singelBarChart");
    if (ctx) {
      ctx.height = 150;
      var myChart = new Chart(ctx, {
        type: 'bar',
        data: {
          labels: ["Sun", "Mon", "Tu", "Wed", "Th", "Fri", "Sat"],
          datasets: [
            {
              label: "My First dataset",
              data: [40, 55, 75, 81, 56, 55, 40],
              borderColor: "rgba(0, 123, 255, 0.9)",
              borderWidth: "0",
              backgroundColor: "rgba(0, 123, 255, 0.5)"
            }
          ]
        },
        options: {
          legend: {
            position: 'top',
            labels: {
              fontFamily: 'Poppins'
            }

          },
          scales: {
            xAxes: [{
              ticks: {
                fontFamily: "Poppins"

              }
            }],
            yAxes: [{
              ticks: {
                beginAtZero: true,
                fontFamily: "Poppins"
              }
            }]
          }
        }
      });
    }

  } catch (error) {
    console.log(error);
  }

})(jQuery);


//
// (function ($) {
//     // USE STRICT
//     "use strict";
//     $(".animsition").animsition({
//       inClass: 'fade-in',
//       outClass: 'fade-out',
//       inDuration: 900,
//       outDuration: 900,
//       linkElement: 'a:not([target="_blank"]):not([href^="#"]):not([class^="chosen-single"])',
//       loading: true,
//       loadingParentElement: 'html',
//       loadingClass: 'page-loader',
//       loadingInner: '<div class="page-loader__spin"></div>',
//       timeout: false,
//       timeoutCountdown: 5000,
//       onLoadEvent: true,
//       browser: ['animation-duration', '-webkit-animation-duration'],
//       overlay: false,
//       overlayClass: 'animsition-overlay-slide',
//       overlayParentElement: 'html',
//       transition: function (url) {
//         window.location.href = url;
//       }
//     });
//
//
//   })(jQuery);
(function ($) {
  // USE STRICT
  "use strict";

  // Map
  try {

    var vmap = $('#vmap');
    if(vmap[0]) {
      vmap.vectorMap( {
        map: 'world_en',
        backgroundColor: null,
        color: '#ffffff',
        hoverOpacity: 0.7,
        selectedColor: '#1de9b6',
        enableZoom: true,
        showTooltip: true,
        values: sample_data,
        scaleColors: [ '#1de9b6', '#03a9f5'],
        normalizeFunction: 'polynomial'
      });
    }

  } catch (error) {
    console.log(error);
  }

  // Europe Map
  try {

    var vmap1 = $('#vmap1');
    if(vmap1[0]) {
      vmap1.vectorMap( {
        map: 'europe_en',
        color: '#007BFF',
        borderColor: '#fff',
        backgroundColor: '#fff',
        enableZoom: true,
        showTooltip: true
      });
    }

  } catch (error) {
    console.log(error);
  }

  // USA Map
  try {

    var vmap2 = $('#vmap2');

    if(vmap2[0]) {
      vmap2.vectorMap( {
        map: 'usa_en',
        color: '#007BFF',
        borderColor: '#fff',
        backgroundColor: '#fff',
        enableZoom: true,
        showTooltip: true,
        selectedColor: null,
        hoverColor: null,
        colors: {
            mo: '#001BFF',
            fl: '#001BFF',
            or: '#001BFF'
        },
        onRegionClick: function ( event, code, region ) {
            event.preventDefault();
        }
      });
    }

  } catch (error) {
    console.log(error);
  }

  // Germany Map
  try {

    var vmap3 = $('#vmap3');
    if(vmap3[0]) {
      vmap3.vectorMap( {
        map: 'germany_en',
        color: '#007BFF',
        borderColor: '#fff',
        backgroundColor: '#fff',
        onRegionClick: function ( element, code, region ) {
            var message = 'You clicked "' + region + '" which has the code: ' + code.toUpperCase();

            alert( message );
        }
      });
    }

  } catch (error) {
    console.log(error);
  }

  // France Map
  try {

    var vmap4 = $('#vmap4');
    if(vmap4[0]) {
      vmap4.vectorMap( {
        map: 'france_fr',
        color: '#007BFF',
        borderColor: '#fff',
        backgroundColor: '#fff',
        enableZoom: true,
        showTooltip: true
      });
    }

  } catch (error) {
    console.log(error);
  }

  // Russia Map
  try {
    var vmap5 = $('#vmap5');
    if(vmap5[0]) {
      vmap5.vectorMap( {
        map: 'russia_en',
        color: '#007BFF',
        borderColor: '#fff',
        backgroundColor: '#fff',
        hoverOpacity: 0.7,
        selectedColor: '#999999',
        enableZoom: true,
        showTooltip: true,
        scaleColors: [ '#C8EEFF', '#006491' ],
        normalizeFunction: 'polynomial'
      });
    }


  } catch (error) {
    console.log(error);
  }

  // Brazil Map
  try {

    var vmap6 = $('#vmap6');
    if(vmap6[0]) {
      vmap6.vectorMap( {
        map: 'brazil_br',
        color: '#007BFF',
        borderColor: '#fff',
        backgroundColor: '#fff',
        onRegionClick: function ( element, code, region ) {
            var message = 'You clicked "' + region + '" which has the code: ' + code.toUpperCase();
            alert( message );
        }
      });
    }

  } catch (error) {
    console.log(error);
  }
})(jQuery);
(function ($) {
  // Use Strict
  "use strict";
  try {
    var progressbarSimple = $('.js-progressbar-simple');
    progressbarSimple.each(function () {
      var that = $(this);
      var executed = false;
      $(window).on('load', function () {

        that.waypoint(function () {
          if (!executed) {
            executed = true;
            /*progress bar*/
            that.progressbar({
              update: function (current_percentage, $this) {
                $this.find('.js-value').html(current_percentage + '%');
              }
            });
          }
        }, {
            offset: 'bottom-in-view'
          });

      });
    });
  } catch (err) {
    console.log(err);
  }
})(jQuery);
(function ($) {
  // USE STRICT
  "use strict";

  // Scroll Bar
  try {
    var jscr1 = $('.js-scrollbar1');
    if(jscr1[0]) {
      const ps1 = new PerfectScrollbar('.js-scrollbar1');
    }

    var jscr2 = $('.js-scrollbar2');
    if (jscr2[0]) {
      const ps2 = new PerfectScrollbar('.js-scrollbar2');

    }

  } catch (error) {
    console.log(error);
  }

})(jQuery);
(function ($) {
  // USE STRICT
  "use strict";

  // Select 2
  try {

    $(".js-select2").each(function () {
      $(this).select2({
        minimumResultsForSearch: 20,
        dropdownParent: $(this).next('.dropDownSelect2')
      });
    });

  } catch (error) {
    console.log(error);
  }


})(jQuery);
(function ($) {
  // USE STRICT
  "use strict";

  // Dropdown
  try {
    var menu = $('.js-item-menu');
    var sub_menu_is_showed = -1;

    for (var i = 0; i < menu.length; i++) {
      $(menu[i]).on('click', function (e) {
        e.preventDefault();
        $('.js-right-sidebar').removeClass("show-sidebar");
        if (jQuery.inArray(this, menu) == sub_menu_is_showed) {
          $(this).toggleClass('show-dropdown');
          sub_menu_is_showed = -1;
        }
        else {
          for (var i = 0; i < menu.length; i++) {
            $(menu[i]).removeClass("show-dropdown");
          }
          $(this).toggleClass('show-dropdown');
          sub_menu_is_showed = jQuery.inArray(this, menu);
        }
      });
    }
    $(".js-item-menu, .js-dropdown").click(function (event) {
      event.stopPropagation();
    });

    $("body,html").on("click", function () {
      for (var i = 0; i < menu.length; i++) {
        menu[i].classList.remove("show-dropdown");
      }
      sub_menu_is_showed = -1;
    });

  } catch (error) {
    console.log(error);
  }

  var wW = $(window).width();
    // Right Sidebar
    var right_sidebar = $('.js-right-sidebar');
    var sidebar_btn = $('.js-sidebar-btn');

    sidebar_btn.on('click', function (e) {
      e.preventDefault();
      for (var i = 0; i < menu.length; i++) {
        menu[i].classList.remove("show-dropdown");
      }
      sub_menu_is_showed = -1;
      right_sidebar.toggleClass("show-sidebar");
    });

    $(".js-right-sidebar, .js-sidebar-btn").click(function (event) {
      event.stopPropagation();
    });

    $("body,html").on("click", function () {
      right_sidebar.removeClass("show-sidebar");

    });


  // Sublist Sidebar
  try {
    var arrow = $('.js-arrow');
    arrow.each(function () {
      var that = $(this);
      that.on('click', function (e) {
        e.preventDefault();
        that.find(".arrow").toggleClass("up");
        that.toggleClass("open");
        that.parent().find('.js-sub-list').slideToggle("250");
      });
    });

  } catch (error) {
    console.log(error);
  }


  try {
    // Hamburger Menu
    $('.hamburger').on('click', function () {
      $(this).toggleClass('is-active');
      $('.navbar-mobile').slideToggle('500');
    });
    $('.navbar-mobile__list li.has-dropdown > a').on('click', function () {
      var dropdown = $(this).siblings('ul.navbar-mobile__dropdown');
      $(this).toggleClass('active');
      $(dropdown).slideToggle('500');
      return false;
    });
  } catch (error) {
    console.log(error);
  }

})(jQuery);

// =======
// Preloader
// =======

var $preloader = $('#page-preloader');
$preloader.delay(400).fadeOut('slow');

(function ($) {
  // USE STRICT
  "use strict";

  // Load more
  try {
    var list_load = $('.js-list-load');
    if (list_load[0]) {
      list_load.each(function () {
        var that = $(this);
        that.find('.js-load-item').hide();
        var load_btn = that.find('.js-load-btn');
        load_btn.on('click', function (e) {
          $(this).text("Loading...").delay(1500).queue(function (next) {
            $(this).hide();
            that.find(".js-load-item").fadeToggle("slow", 'swing');
          });
          e.preventDefault();
        });
      })

    }
  } catch (error) {
    console.log(error);
  }

})(jQuery);
(function ($) {
  // USE STRICT
  "use strict";

  try {

    $('[data-toggle="tooltip"]').tooltip();

  } catch (error) {
    console.log(error);
  }

  // Chatbox
  try {
    var inbox_wrap = $('.js-inbox');
    var message = $('.au-message__item');
    message.each(function(){
      var that = $(this);

      that.on('click', function(){
        $(this).parent().parent().parent().toggleClass('show-chat-box');
      });
    });


  } catch (error) {
    console.log(error);
  }

})(jQuery);

// function drawVisor() {
//   const canvas = document.getElementById('visor');
//   const ctx = canvas.getContext('2d');
//
//   ctx.beginPath();
//   ctx.moveTo(5, 45);
//   ctx.bezierCurveTo(15, 64, 45, 64, 55, 45);
//
//   ctx.lineTo(55, 20);
//   ctx.bezierCurveTo(55, 15, 50, 10, 45, 10);
//
//   ctx.lineTo(15, 10);
//
//   ctx.bezierCurveTo(15, 10, 5, 10, 5, 20);
//   ctx.lineTo(5, 45);
//
//   ctx.fillStyle = '#2f3640';
//   ctx.strokeStyle = '#f5f6fa';
//   ctx.fill();
//   ctx.stroke();
// }
//
// const cordCanvas = document.getElementById('cord');
// const ctx = cordCanvas.getContext('2d');
//
// let y1 = 160;
// let y2 = 100;
// let y3 = 100;
//
// let y1Forward = true;
// let y2Forward = false;
// let y3Forward = true;
//
// function animate() {
//   requestAnimationFrame(animate);
//   ctx.clearRect(0, 0, innerWidth, innerHeight);
//
//   ctx.beginPath();
//   ctx.moveTo(130, 170);
//   ctx.bezierCurveTo(250, y1, 345, y2, 400, y3);
//
//   ctx.strokeStyle = 'white';
//   ctx.lineWidth = 8;
//   ctx.stroke();
//
//
//   if (y1 === 100) {
//     y1Forward = true;
//   }
//
//   if (y1 === 300) {
//     y1Forward = false;
//   }
//
//   if (y2 === 100) {
//     y2Forward = true;
//   }
//
//   if (y2 === 310) {
//     y2Forward = false;
//   }
//
//   if (y3 === 100) {
//     y3Forward = true;
//   }
//
//   if (y3 === 317) {
//     y3Forward = false;
//   }
//
//   y1Forward ? y1 += 1 : y1 -= 1;
//   y2Forward ? y2 += 1 : y2 -= 1;
//   y3Forward ? y3 += 1 : y3 -= 1;
// }
//
// drawVisor();
// animate();

"use strict";
//Wrapping all JavaScript code into a IIFE function for prevent global variables creation
(function ($) {

  var $body = $('body');
  var $window = $(window);

//hidding menu elements that do not fit in menu width
//processing center logo
  function menuHideExtraElements() {

    //cleaneng changed elements
    $('.sf-more-li, .sf-logo-li').remove();
    var windowWidth = $('body').innerWidth();

    $('.sf-menu').each(function () {
      var $thisMenu = $(this);
      var $menuWraper = $thisMenu.closest('.top-nav');
      $menuWraper.attr('style', '');
      if (windowWidth > 1199) {
        //grab all main menu first level items
        var $menuLis = $menuWraper.find('.sf-menu > li');
        $menuLis.removeClass('sf-xl-hidden');

        var $headerLogoCenter = $thisMenu.closest('.header_logo_center');
        var logoWidth = 0;
        var summaryLiWidth = 0;

        if ($headerLogoCenter.length) {
          var $logo = $headerLogoCenter.find('.logo');
          // 30/2 - left and right margins
          logoWidth = $logo.outerWidth(true) + 70;
        }

        // var wrapperWidth = $('.sf-menu').width();
        var wrapperWidth = $menuWraper.outerWidth(true);
        $menuLis.each(function (index) {
          //4 - 4px additional width for inline-block LI element
          var elementWidth = $(this).outerWidth() + 4;
          summaryLiWidth += elementWidth;
          if (summaryLiWidth >= (wrapperWidth - logoWidth)) {
            var $newLi = $('<li class="sf-more-li"><a>...</a><ul></ul></li>');
            $($menuLis[index - 1]).before($newLi);
            var newLiWidth = $($newLi).outerWidth(true);
            var $extraLiElements = $menuLis.filter(':gt(' + (index - 2) + ')');
            $extraLiElements.clone().appendTo($newLi.find('ul'));
            $extraLiElements.addClass('sf-xl-hidden');
            return false;
          }
        });

        //processing center logo
        if ($headerLogoCenter.length) {
          var $menuLisVisible = $headerLogoCenter.find('.sf-menu > li:not(.sf-xl-hidden)');
          var menuLength = $menuLisVisible.length;
          var summaryLiVisibleWidth = 0;
          $menuLisVisible.each(function () {
            summaryLiVisibleWidth += $(this).outerWidth();
          });

          var centerLi = Math.floor(menuLength / 2);
          if ((menuLength % 2 === 0)) {
            centerLi--;
          }
          var $liLeftFromLogo = $menuLisVisible.eq(centerLi);
          $liLeftFromLogo.after('<li class="sf-logo-li"><a href="#">&nbsp;</a></li>');
          $headerLogoCenter.find('.sf-logo-li').width(logoWidth);
          var liLeftRightDotX = $liLeftFromLogo.offset().left + $liLeftFromLogo.outerWidth();
          var logoLeftDotX = windowWidth / 2 - logoWidth / 2;
          var menuLeftOffset = liLeftRightDotX - logoLeftDotX;
          $menuWraper.css({'left': -menuLeftOffset})
        }

      }// > 991
    }); //sf-menu each
  } //menuHideExtraElements

  function initMegaMenu(timeOut) {
    var $megaMenu = $('.top-nav .mega-menu');
    if ($megaMenu.length) {
      setTimeout(function () {

        var windowWidth = $('body').innerWidth();
        if (windowWidth > 991) {
          $megaMenu.each(function () {
            var $thisMegaMenu = $(this);
            //temporary showing mega menu to proper size calc
            $thisMegaMenu.css({'display': 'block', 'left': 'auto'});

            //checking for sticked side header
            var stickedSideHeaderWidth = 0;
            var $stickedSideHeader = $('.header_side_sticked');
            if ($stickedSideHeader.length && $stickedSideHeader.hasClass('active-slide-side-header')) {
              stickedSideHeaderWidth = $stickedSideHeader.outerWidth(true);
              if ($stickedSideHeader.hasClass('header_side_right')) {
                stickedSideHeaderWidth = -stickedSideHeaderWidth;
              }
              windowWidth = windowWidth - stickedSideHeaderWidth;
            }
            var thisWidth = $thisMegaMenu.outerWidth();
            var thisOffset = $thisMegaMenu.offset().left - stickedSideHeaderWidth;
            var thisLeft = (thisOffset + (thisWidth / 2)) - windowWidth / 2;
            $thisMegaMenu.css({'left': -thisLeft, 'display': 'none'});
            if (!$thisMegaMenu.closest('ul').hasClass('nav')) {
              $thisMegaMenu.css('left', '');
            }
          });
        }
      }, timeOut);

    }
  }

//NOTE: affixed sidebar works bad with side headers
  function initAffixSidebar() {
    var $affixAside = $('.affix-aside');
    if ($affixAside.length) {

      $window = $(window);

      //on stick and unstick event
      $affixAside.on('affix.bs.affix', function (e) {
        var affixWidth = $affixAside.width() - 1;
        var affixLeft = $affixAside.offset().left;
        $affixAside
            .width(affixWidth)
            .css("left", affixLeft);

      }).on('affix-bottom.bs.affix', function (e) {
        var affixWidth = $affixAside.width() - 1;
        //if sticked left header
        var stickedSideHeaderWidth = 0;
        var $stickedSideHeader = $('.header_side_sticked');
        if ($stickedSideHeader.length && $stickedSideHeader.hasClass('active-slide-side-header') && !$stickedSideHeader.hasClass('header_side_right')) {
          stickedSideHeaderWidth = $stickedSideHeader.outerWidth(true);
        }
        var affixLeft = $affixAside.offset().left - stickedSideHeaderWidth - $('#box_wrapper').offset().left;
        ;

        $affixAside
            .width(affixWidth)
            .css("left", affixLeft);
      }).on('affix-top.bs.affix', function (e) {
        $affixAside.css({"width": "", "left": ""});
      });

      //counting offset
      var offsetTopAdd = 10;
      var offsetBottomAdd = 150;
      var offsetTop = $affixAside.offset().top - $('.page_header').height();
      //note that page_footer and page_copyright sections must exists - else this will cause error in last jQuery versions
      var offsetBottom = $('.page_footer').outerHeight(true) + $('.page_copyright').outerHeight(true);

      $affixAside.affix({
        offset: {
          top: offsetTop - offsetTopAdd,
          bottom: offsetBottom + offsetBottomAdd
        },
      });

      $window.on('resize', function () {
        //returning sidebar in top position if it is sticked because of unexpected behavior
        $affixAside.removeClass("affix affix-bottom").addClass("affix-top").trigger('affix-top.bs.affix');

        var offsetTopSectionsArray = [
          '.page_topline',
          '.page_toplogo',
          '.page_header',
          '.page_title',
          '.blog_slider',
          '.blog-featured-posts'
        ];
        var offsetTop = 0;

        offsetTopSectionsArray.map(function (val) {
          offsetTop += $(val).outerHeight(true) || 0;
        });
        //note that page_footer and page_copyright sections must exists - else this will cause error in last jQuery versions
        var offsetBottom = $('.page_footer').outerHeight(true)
            + $('.page_copyright').outerHeight(true);

        $affixAside.data('bs.affix').options.offset.top = offsetTop - offsetTopAdd;
        $affixAside.data('bs.affix').options.offset.bottom = offsetBottom + offsetBottomAdd;

        $affixAside.affix('checkPosition');

      });

      $affixAside.affix('checkPosition');

    }//eof checking of affix sidebar existing
  }

// Wrapping all JavaScript code into a IIFE function for prevent global variables creation
// and pass in jQuery to be mapped to $.
  (function ($) {
    jQuery(document).ready(function () {
      //jQuery UI slider for owl carousel
      if (jQuery().slider) {
        var $slider = jQuery(".owl-carousel-slider");
        $slider.each(function () {
          var $this = jQuery(this);
          var data = $this.data();
          $this.slider({
            value: 0,
            min: 0,
            max: data.itemsCount,
            step: 1,
            slide: function (event, ui) {
              jQuery(data.carousel).trigger('to.owl.carousel', [ui.value, 500])
            }
          });
        })
      }
    });
//end of IIFE function
  })(jQuery);

//photoSwipe gallery plugin
  function initPhotoSwipe() {
    if (typeof PhotoSwipe !== 'undefined') {

      //adding prettyPhoto for backward compatibility. Deprecated.
      //will leave only .photoswipe-link later
      var gallerySelectors = '.photoswipe-link, a[data-gal^="prettyPhoto"], [data-thumb] a';
      var $galleryLinks = $(gallerySelectors);
      if ($galleryLinks.length) {

        //adding photoswipe gallery markup
        if (!($('.pswp').length)) {
          $body.append('<div class="pswp" tabindex="-1" role="dialog" aria-hidden="true"><div class="pswp__bg"></div><div class="pswp__scroll-wrap"><div class="pswp__container"><div class="pswp__item"></div><div class="pswp__item"></div><div class="pswp__item"></div></div><div class="pswp__ui pswp__ui--hidden"><div class="pswp__top-bar"><div class="pswp__counter"></div><a class="pswp__button pswp__button--close" title="Close (Esc)"></a><a class="pswp__button pswp__button--share" title="Share"></a><a class="pswp__button pswp__button--fs" title="Toggle fullscreen"></a><a class="pswp__button pswp__button--zoom" title="Zoom in/out"></a><div class="pswp__preloader"><div class="pswp__preloader__icn"><div class="pswp__preloader__cut"><div class="pswp__preloader__donut"></div></div></div></div></div><div class="pswp__share-modal pswp__share-modal--hidden pswp__single-tap"><div class="pswp__share-tooltip"></div> </div><a class="pswp__button pswp__button--arrow--left" title="Previous (arrow left)"></a><a class="pswp__button pswp__button--arrow--right" title="Next (arrow right)"></a><div class="pswp__caption"><div class="pswp__caption__center"></div></div></div></div></div>');
          //if function already was called - return (all listeners was setted and .pswp gallery container was added)
        } else {
          return;
        }
        //adding prettyPhoto for backward compatibility. Deprecated.
        $('body').on('click', gallerySelectors, function (e) {
          e.preventDefault();

          var $link = $(this);
          var $linksParentContainer = $link.closest('.photoswipe-container, .isotope-wrapper, .owl-carousel, .flickr_ul, .images');
          var $links = $linksParentContainer.find(gallerySelectors);

          //if no container only adding this link
          if (!$links.length) {
            $links.push($link);
          }
          var items = [];

          var options = {
            bgOpacity: 0.7,
            showHideOpacity: true,
            history: false,
            shareEl: false,
            index: 0
          };
          var gallery = $('.pswp')[0];
          //building items array
          var counter = 0;
          var clonedClick = false;
          var clonedRealIndex = 0;
          $links.each(function (i) {
            var $this = $(this);
            //if cloned element (owl or flexslider thumbs) - continue
            if ($this.closest('.clone, .cloned').length) {
              if (($link[0] === $this[0])) {
                clonedClick = true;
                clonedRealIndex = parseInt($this.data('index'), 10);
                options.index = clonedRealIndex;
              }
              return;
            }
            var item = {};
            //start slide from clicked element
            if (($link[0] === $this[0])) {
              options.index = counter;
            }

            //video or image
            if ($this.data('iframe')) {
              //for wordpress - iframe tag is escaped
              //item.html = $this.data('iframe').replace(/&amp/g, '&').replace(/$lt;/g, '<').replace(/&gt;/g, '>').replace(/$quot;/g, '"');
              //for html - building iframe manually
              //autoplay only if 1 iframe in gallery
              var autoplay = ($links.length > 1) ? '' : '&autoplay=1';
              item.html = '<div class="embed-responsive embed-responsive-16by9">';
              // item.html += '<iframe class="embed-responsive-item" src="'+ $(this).data('iframe') + '?rel=0&autoplay=1'+ '"></iframe>';
              item.html += '<iframe class="embed-responsive-item" src="' + $(this).data('iframe') + '?rel=0' + autoplay + '&enablejsapi=1&api=1"></iframe>';
              item.html += '</div>';
            } else {
              item.src = $this.attr('href');
              //default values
              var width = 1170;
              var height = 780;
              //template data on A element
              var data = $this.data();
              //image data in Woo
              var dataImage = $this.find('img').first().data();
              if (data.width) {
                width = data.width;
              }
              if (data.height) {
                height = data.height;
              }
              if (typeof  dataImage !== 'undefined') {
                if (dataImage.large_image_width) {
                  width = dataImage.large_image_width;
                }
                if (dataImage.large_image_height) {
                  height = dataImage.large_image_height;
                }
              }
              item.w = width;
              item.h = height;
            }
            items.push(item);
            counter++;
          });

          var pswpGallery = new PhotoSwipe(gallery, PhotoSwipeUI_Default, items, options);
          pswpGallery.init();

          //pausing video on close and on slide change
          pswpGallery.listen('afterChange', function () {
            $(pswpGallery.container).find('iframe').each(function () {
              //"method":"pause" - form Vimeo, other - for YouTube
              $(this)[0].contentWindow.postMessage('{"method":"pause","event":"command","func":"pauseVideo","args":""}', '*')
            });
          });
          pswpGallery.listen('close', function () {
            $(pswpGallery.container).find('iframe').each(function () {
              //"method":"pause" - form Vimeo, other - for YouTube
              $(this)[0].contentWindow.postMessage('{"method":"pause","event":"command","func":"pauseVideo","args":""}', '*')
            });
          });

        });
      }

    }
  }

//team-slider
  (function ($) {
    jQuery(document).ready(function () {

      //team-slider
      $('.team-slider-item span').on('mouseenter', function () {
        var $item = $(this).closest('.team-slider-item');
        $('.team-slider-item.active').removeClass('active');
        $item.addClass('active');
      });

      // $('.team-slider-item span').on('mouseleave', function () {
      //     $('.team-slider-item.active').removeClass('active');
      // });

      //team-slider title last word
      jQuery('.slide-title span').html(function () {
        // separate the text by spaces
        var text = $(this).text().split(' ');
        // drop the last word and store it in a variable
        var last = text.pop();
        // join the text back and if it has more than 1 word add the span tag
        // to the last word
        return text.join(" ") + (text.length > 0 ? ' <span class="last">' + last + '</span>' : last);
      });

    });
//end of IIFE function
  })(jQuery);

//team-bio
  (function ($) {
    jQuery(document).ready(function () {
      function processDots(slider, value) {
        var $slider = jQuery(slider).closest('.owl-carousel-slider');
        var data = $slider.data();
        var divider = 1;
        if (data.itemsCount) {
          divider = 100 / data.itemsCount;
        }

        $slider.css('left', function () {
              return '-' + (value * divider) + '%';
            }
        )
            .find('.year-dot')
            .removeClass('active')
            .each(function (index, item) {
              if (value >= index) {
                jQuery(item).addClass('active');
              }
            })
            .end()
            .find('.year-label')
            .removeClass('active')
            .each(function (index, item) {
              if (value >= index) {
                jQuery(item).addClass('active');
              }
            });
      }

      var $carousel = $('.owl-carousel-bio');

      //adding slider behavior
      //jQuery UI slider for owl carousel
      if (jQuery().slider) {
        var $slider = jQuery(".owl-carousel-slider");
        $slider.each(function () {
          var $this = jQuery(this);
          var data = $this.data();
          $this.slider({
            range: "min",
            value: 0,
            min: 0,
            max: data.itemsCount,
            step: 1,
            slide: function (event, ui) {
              jQuery(data.carousel).trigger('to.owl.carousel', [ui.value, 500]);
              processDots(ui.handle, ui.value);
            }
          });
        });

        var owlSlider = $carousel.data('owlCarouselSlider') ? $carousel.data('owlCarouselSlider') : false;

        $carousel.on('changed.owl.carousel', function (e) {
          var indexTo = e.item.index;
          jQuery(owlSlider).slider("option", "value", indexTo);
          //dots processing
          var value = jQuery(owlSlider).slider("option", "value");
          processDots(owlSlider, value);
          return false;
        });
      }

      // //init carousel
      // $carousel.owlCarousel({
      //   loop: false,
      //   nav: false,
      //   dots: false,
      //   items: 1,
      //   navContainer: '.custom-nav',
      //   animateOut: 'fadeOutLeft',
      //   animateIn: 'fadeInLeft',
      // }).addClass('owl-carousel');

      $carousel.on('mousewheel', '.owl-stage', function (e) {
        if (e.originalEvent.wheelDelta < 0) {
          $carousel.trigger('next.owl');
        } else {
          $carousel.trigger('prev.owl');
        }
        e.preventDefault();
        e.stopPropagation();
      });

    });
//end of IIFE function
  })(jQuery);

//helper functions to init elements only when they appears in viewport (jQUery.appear plugin)
  function initAnimateElement(self, index) {
    var animationClass = !self.data('animation') ? 'fadeInUp' : self.data('animation');
    var animationDelay = !self.data('delay') ? 150 : self.data('delay');
    setTimeout(function () {
      self.addClass("animated " + animationClass);
    }, index * animationDelay);
  }

  function initCounter(self) {
    if (self.hasClass('counted')) {
      return;
    } else {
      self.countTo().addClass('counted');
    }
  }

  function initProgressbar(el) {
    el.progressbar({
      transition_delay: 300
    });
  }

  function initChart(el) {
    var data = el.data();
    var size = data.size ? data.size : 270;
    var line = data.line ? data.line : 20;
    var bgcolor = data.bgcolor ? data.bgcolor : '#ffffff';
    var trackcolor = data.trackcolor ? data.trackcolor : '#c14240';
    var speed = data.speed ? data.speed : 3000;

    el.easyPieChart({
      barColor: trackcolor,
      trackColor: bgcolor,
      scaleColor: false,
      scaleLength: false,
      lineCap: 'butt',
      lineWidth: line,
      size: size,
      rotate: 0,
      animate: speed,
      onStep: function (from, to, percent) {
        $(this.el).find('.percent').text(Math.round(percent));
      }
    });
  }

  function initGoogleMap() {
    //Google Map script
    var $googleMaps = $('#map, .page_map');
    if ($googleMaps.length) {
      $googleMaps.each(function () {
        var $map = $(this);

        var lat;
        var lng;
        var map;

        //map styles. You can grab different styles on https://snazzymaps.com/

        //dark style
        //var styles = [{"featureType":"all","elementType":"labels","stylers":[{"visibility":"on"}]},{"featureType":"all","elementType":"labels.text.fill","stylers":[{"saturation":36},{"color":"#000000"},{"lightness":40}]},{"featureType":"all","elementType":"labels.text.stroke","stylers":[{"visibility":"on"},{"color":"#000000"},{"lightness":16}]},{"featureType":"all","elementType":"labels.icon","stylers":[{"visibility":"off"}]},{"featureType":"administrative","elementType":"geometry.fill","stylers":[{"color":"#000000"},{"lightness":20}]},{"featureType":"administrative","elementType":"geometry.stroke","stylers":[{"color":"#000000"},{"lightness":17},{"weight":1.2}]},{"featureType":"administrative.locality","elementType":"labels.text.fill","stylers":[{"color":"#c4c4c4"}]},{"featureType":"administrative.neighborhood","elementType":"labels.text.fill","stylers":[{"color":"#707070"}]},{"featureType":"landscape","elementType":"geometry","stylers":[{"color":"#000000"},{"lightness":20}]},{"featureType":"poi","elementType":"geometry","stylers":[{"color":"#000000"},{"lightness":21},{"visibility":"on"}]},{"featureType":"poi.business","elementType":"geometry","stylers":[{"visibility":"on"}]},{"featureType":"road.highway","elementType":"geometry.fill","stylers":[{"color":"#be2026"},{"lightness":"0"},{"visibility":"on"}]},{"featureType":"road.highway","elementType":"geometry.stroke","stylers":[{"visibility":"off"}]},{"featureType":"road.highway","elementType":"labels.text.fill","stylers":[{"visibility":"off"}]},{"featureType":"road.highway","elementType":"labels.text.stroke","stylers":[{"visibility":"off"},{"hue":"#ff000a"}]},{"featureType":"road.arterial","elementType":"geometry","stylers":[{"color":"#000000"},{"lightness":18}]},{"featureType":"road.arterial","elementType":"geometry.fill","stylers":[{"color":"#575757"}]},{"featureType":"road.arterial","elementType":"labels.text.fill","stylers":[{"color":"#ffffff"}]},{"featureType":"road.arterial","elementType":"labels.text.stroke","stylers":[{"color":"#2c2c2c"}]},{"featureType":"road.local","elementType":"geometry","stylers":[{"color":"#000000"},{"lightness":16}]},{"featureType":"road.local","elementType":"labels.text.fill","stylers":[{"color":"#999999"}]},{"featureType":"road.local","elementType":"labels.text.stroke","stylers":[{"saturation":"-52"}]},{"featureType":"transit","elementType":"geometry","stylers":[{"color":"#000000"},{"lightness":19}]},{"featureType":"water","elementType":"geometry","stylers":[{"color":"#000000"},{"lightness":17}]}];

        // light style
        var styles = [{
          "featureType": "water",
          "elementType": "geometry",
          "stylers": [{"color": "#e9e9e9"}, {"lightness": 17}]
        }, {
          "featureType": "landscape",
          "elementType": "geometry",
          "stylers": [{"color": "#f5f5f5"}, {"lightness": 20}]
        }, {
          "featureType": "road.highway",
          "elementType": "geometry.fill",
          "stylers": [{"color": "#ffffff"}, {"lightness": 17}]
        }, {
          "featureType": "road.highway",
          "elementType": "geometry.stroke",
          "stylers": [{"color": "#ffffff"}, {"lightness": 29}, {"weight": 0.2}]
        }, {
          "featureType": "road.arterial",
          "elementType": "geometry",
          "stylers": [{"color": "#ffffff"}, {"lightness": 18}]
        }, {
          "featureType": "road.local",
          "elementType": "geometry",
          "stylers": [{"color": "#ffffff"}, {"lightness": 16}]
        }, {
          "featureType": "poi",
          "elementType": "geometry",
          "stylers": [{"color": "#f5f5f5"}, {"lightness": 21}]
        }, {
          "featureType": "poi.park",
          "elementType": "geometry",
          "stylers": [{"color": "#dedede"}, {"lightness": 21}]
        }, {
          "elementType": "labels.text.stroke",
          "stylers": [{"visibility": "on"}, {"color": "#ffffff"}, {"lightness": 16}]
        }, {
          "elementType": "labels.text.fill",
          "stylers": [{"saturation": 36}, {"color": "#333333"}, {"lightness": 40}]
        }, {"elementType": "labels.icon", "stylers": [{"visibility": "off"}]}, {
          "featureType": "transit",
          "elementType": "geometry",
          "stylers": [{"color": "#f2f2f2"}, {"lightness": 19}]
        }, {
          "featureType": "administrative",
          "elementType": "geometry.fill",
          "stylers": [{"color": "#fefefe"}, {"lightness": 20}]
        }, {
          "featureType": "administrative",
          "elementType": "geometry.stroke",
          "stylers": [{"color": "#fefefe"}, {"lightness": 17}, {"weight": 1.2}]
        }];

        //markers
        var $markers = $map.find('.marker');

        //map settings
        var address = $markers.first().find('.marker-address').text() ? $markers.first().find('.marker-address').text() : 'london, baker street, 221b';
        var geocoder = new google.maps.Geocoder();


        var draggable = $map.data('draggable') ? $map.data('draggable') : false;
        var scrollwheel = $map.data('scrollwheel') ? $map.data('scrollwheel') : false;

        //type your address after "address="
        geocoder.geocode({
          address: address
        }, function (data) {

          lat = data[0].geometry.location.lat();
          lng = data[0].geometry.location.lng();

          var center = new google.maps.LatLng(lat, lng);
          var settings = {
            mapTypeId: google.maps.MapTypeId.ROADMAP,
            zoom: 16,
            draggable: draggable,
            scrollwheel: scrollwheel,
            center: center,
            styles: styles
          };
          map = new google.maps.Map($map[0], settings);

          var infoWindows = [];

          $($markers).each(function (index) {

            var $marker = $(this);
            var markerTitle = $marker.find('.marker-title').text();

            //building info widnow HTML code
            var markerDescription = '';
            markerDescription += markerTitle ? '<h3 class="makret-title">' + markerTitle + '</h3>' : '';
            markerDescription += $marker.find('.marker-description').html() ? '<div class="marker-description">' + $marker.find('.marker-description').html() + '</div>' : '';
            if (markerDescription) {
              markerDescription = '<div class="map_marker_description">' + markerDescription + '</div>';
            }

            geocoder.geocode({
              address: $marker.find('.marker-address').text()
            }, function (data) {
              var iconSrc = $marker.find('.marker-icon').attr('src');

              var lat = data[0].geometry.location.lat();
              var lng = data[0].geometry.location.lng();

              var center = new google.maps.LatLng(lat, lng);

              var marker = new google.maps.Marker({
                position: center,
                title: markerTitle,
                map: map,
                icon: iconSrc
              });

              var infowindow = new google.maps.InfoWindow({
                content: markerDescription
              });

              infoWindows.push(infowindow);

              google.maps.event.addListener(marker, 'click', function () {
                for (var i = 0; i < infoWindows.length; i++) {
                  infoWindows[i].close();
                }
                infowindow.open(map, marker);
              });
            });
          });
        });
      }); //each Google map
    }//google map length
  }

  if ($('#map, .page_map').length) {
    window.templateInitGoogleMap = initGoogleMap;
  }

//function that initiating template plugins on window.load event
  function documentReadyInit() {
    ////////////
    //mainmenu//
    ////////////
    if ($().scrollbar) {
      $('[class*="scrollbar-"]').scrollbar();
    }
    if ($().superfish) {
      $('ul.sf-menu').superfish({
        popUpSelector: 'ul:not(.mega-menu ul), .mega-menu ',
        delay: 700,
        animation: {opacity: 'show', marginTop: 0},
        animationOut: {opacity: 'hide', marginTop: 5},
        speed: 200,
        speedOut: 200,
        disableHI: false,
        cssArrows: true,
        autoArrows: true,
        onInit: function () {
          var $thisMenu = $(this);
          $thisMenu.find('.sf-with-ul').after('<span class="sf-menu-item-mobile-toggler"/>');
          $thisMenu.find('.sf-menu-item-mobile-toggler').on('click', function (e) {
            var $parentLi = $(this).parent();
            if ($parentLi.hasClass('sfHover')) {
              $parentLi.superfish('hide');
            } else {
              $parentLi.superfish('show');
            }
          });
        }

      });
      $('ul.sf-menu-side').superfish({
        popUpSelector: 'ul:not(.mega-menu ul), .mega-menu ',
        delay: 500,
        animation: {opacity: 'show', height: 100 + '%'},
        animationOut: {opacity: 'hide', height: 0},
        speed: 400,
        speedOut: 300,
        disableHI: false,
        cssArrows: true,
        autoArrows: true
      });
    }


    //toggle mobile menu
    $('.page_header .toggle_menu, .page_toplogo .toggle_menu').on('click', function () {
      var $this = $(this);
      if (!$this.hasClass('toggle_menu_special')) {
        $this
            .toggleClass('mobile-active')
            .closest('.page_header')
            .toggleClass('mobile-active')
            .end()
            .closest('.page_toplogo')
            .next()
            .find('.page_header')
            .toggleClass('mobile-active');
      }
    });

    $('.sf-menu a').on('click', function () {
      var $this = $(this);
      //If this is a local link or item with sumbenu - not toggling menu
      if (($this.hasClass('sf-with-ul')) || !($this.attr('href').charAt(0) === '#')) {
        return;
      }
      $this
          .closest('.page_header')
          .toggleClass('mobile-active')
          .find('.toggle_menu')
          .toggleClass('mobile-active');
    });

    //side header processing
    var $sideHeader = $('.page_header_side');
    // toggle sub-menus visibility on menu-click
    $('ul.menu-click').find('li').each(function () {
      var $thisLi = $(this);
      //toggle submenu only for menu items with submenu
      if ($thisLi.find('ul').length) {
        $thisLi
            .append('<span class="toggle_submenu color-darkgrey"></span>')
            //adding anchor
            .find('.toggle_submenu, > a')
            .on('click', function (e) {
              var $thisSpanOrA = $(this);
              //if this is a link and it is already opened - going to link
              if (($thisSpanOrA.attr('href') === '#') || !($thisSpanOrA.parent().hasClass('active-submenu'))) {
                e.preventDefault();
              }
              if ($thisSpanOrA.parent().hasClass('active-submenu')) {
                $thisSpanOrA.parent().removeClass('active-submenu');
                return;
              }
              $thisLi.addClass('active-submenu').siblings().removeClass('active-submenu');
            });
      } //eof sumbenu check
    });
    if ($sideHeader.length) {
      $('.toggle_menu_side').on('click', function () {
        var $thisToggler = $(this);
        $thisToggler.toggleClass('active');
        if ($thisToggler.hasClass('header-slide')) {
          $sideHeader.toggleClass('active-slide-side-header');
        } else {
          if ($thisToggler.parent().hasClass('header_side_right')) {
            $body.toggleClass('active-side-header slide-right');
          } else {
            $body.toggleClass('active-side-header');
          }
          $body.parent().toggleClass('html-active-push-header');
        }
        //fixing mega menu and aside affix on toggling side sticked header
        if ($thisToggler.closest('.header_side_sticked').length) {
          initMegaMenu(600);
          var $affixAside = $('.affix-aside');
          if ($affixAside.length) {
            $affixAside.removeClass("affix affix-bottom").addClass("affix-top").css({
              "width": "",
              "left": ""
            }).trigger('affix-top.bs.affix');
            setTimeout(function () {
              $affixAside.removeClass("affix affix-bottom").addClass("affix-top").css({
                "width": "",
                "left": ""
              }).trigger('affix-top.bs.affix');
            }, 10);
          }
        }
      });
      //hidding side header on click outside header
      $body.on('mousedown touchstart', function (e) {
        if (!($(e.target).closest('.page_header_side').length) && !($sideHeader.hasClass('header_side_sticked'))) {
          $sideHeader.removeClass('active-slide-side-header');
          $body.removeClass('active-side-header slide-right');
          $body.parent().removeClass('html-active-push-header');
          var $toggler = $('.toggle_menu_side');
          if (($toggler).hasClass('active')) {
            $toggler.removeClass('active');
          }
        }
      });
    } //sideHeader check

    //1 and 2/3/4th level offscreen fix
    var MainWindowWidth = $window.width();
    $window.on('resize', function () {
      MainWindowWidth = $(window).width();
    });
    //2/3/4 levels
    $('.top-nav .sf-menu').on('mouseover', 'ul li', function () {
      // $('.mainmenu').on('mouseover', 'ul li', function(){
      if (MainWindowWidth > 991) {
        var $this = $(this);
        // checks if third level menu exist
        var subMenuExist = $this.find('ul').length;
        if (subMenuExist > 0) {
          var subMenuWidth = $this.find('ul, div').first().width();
          var subMenuOffset = $this.find('ul, div').first().parent().offset().left + subMenuWidth;
          // if sub menu is off screen, give new position
          if ((subMenuOffset + subMenuWidth) > MainWindowWidth) {
            var newSubMenuPosition = subMenuWidth + 0;
            $this.find('ul, div').first().css({
              left: -newSubMenuPosition,
            });
          } else {
            $this.find('ul, div').first().css({
              left: '100%',
            });
          }
        }
      }
      //1st level
    }).on('mouseover', '> li', function () {
      if (MainWindowWidth > 991) {
        var $this = $(this);
        var subMenuExist = $this.find('ul').length;
        if (subMenuExist > 0) {
          var subMenuWidth = $this.find('ul').width();
          var subMenuOffset = $this.find('ul').parent().offset().left;
          // if sub menu is off screen, give new position
          if ((subMenuOffset + subMenuWidth) > MainWindowWidth) {
            var newSubMenuPosition = MainWindowWidth - (subMenuOffset + subMenuWidth);
            $this.find('ul').first().css({
              left: newSubMenuPosition,
            });
          }
        }
      }
    });

    /////////////////////////////////////////
    //single page localscroll and scrollspy//
    /////////////////////////////////////////
    var navHeight = $('.page_header').outerHeight(true);
    //if sidebar nav exists - binding to it. Else - to main horizontal nav
    if ($('.mainmenu_side_wrapper').length) {
      $body.scrollspy({
        target: '.mainmenu_side_wrapper',
        offset: navHeight
      });
    } else if ($('.top-nav').length) {
      $body.scrollspy({
        target: '.top-nav',
        offset: navHeight
      })
    }
    if ($().localScroll) {
      $('.top-nav > ul, .mainmenu_side_wrapper > ul, #land,  .comments-link').localScroll({
        duration: 900,
        easing: 'easeInOutQuart',
        offset: -navHeight + 40
      });
    }

    //background image teaser and sections with half image bg
    //put this before prettyPhoto init because image may be wrapped in prettyPhoto link
    $(".bg_teaser, .cover-image").each(function () {
      var $element = $(this);
      var $image = $element.find("img").first();
      if (!$image.length) {
        $image = $element.parent().find("img").first();
      }
      if (!$image.length) {
        return;
      }
      var imagePath = $image.attr("src");
      $element.css("background-image", "url(" + imagePath + ")");
      var $imageParent = $image.parent();
      //if image inside link - adding this link, removing gallery to preserve duplicating gallery items
      if ($imageParent.is('a')) {
        $element.prepend($image.parent().clone().html(''));
        $imageParent.attr('data-gal', '');
      }
    });

    //video images preview - from WP
    $('.embed-placeholder').each(function () {
      $(this).on('click', function (e) {
        var $thisLink = $(this);
        // if prettyPhoto popup with YouTube - return
        if ($thisLink.attr('data-gal')) {
          return;
        }
        e.preventDefault();
        if ($thisLink.attr('href') === '' || $thisLink.attr('href') === '#') {
          $thisLink.replaceWith($thisLink.data('iframe').replace(/&amp/g, '&').replace(/$lt;/g, '<').replace(/&gt;/g, '>').replace(/$quot;/g, '"')).trigger('click');
        } else {
          $thisLink.replaceWith('<iframe class="embed-responsive-item" src="' + $thisLink.attr('href') + '?rel=0&autoplay=1' + '"></iframe>');
        }
      });
    });

    //toTop
    if ($().UItoTop) {
      $().UItoTop({easingType: 'easeInOutQuart'});
    }

    //parallax
    if ($().parallax) {
      $('.s-parallax').parallax("50%", 0.01);
    }

    //prettyPhoto
    if ($().prettyPhoto) {
      $("a[data-gal^='prettyPhoto']").prettyPhoto({
        hook: 'data-gal',
        theme: 'facebook' /* light_rounded / dark_rounded / light_square / dark_square / facebook / pp_default*/
      });
    }
    initPhotoSwipe();

    ////////////////////////////////////////
    //init Bootstrap JS components//
    ////////////////////////////////////////
    //adding .form-control class for search widgets
    $('[type="search"]').addClass('form-control');


    //bootstrap carousel
    if ($().carousel) {
      $('.carousel').carousel();
    }
    //bootstrap tab - show first tab
    $('.nav-tabs').each(function () {
      $(this).find('a').first().tab('show');
    });
    //video in bootstrap tabs
    $('a[data-toggle="tab"]').on('shown.bs.tab', function (e) {
      var iframe = $(e.relatedTarget.hash).find('iframe');
      var src = iframe.attr('src');
      iframe.attr('src', '');
      iframe.attr('src', src);
    });

    $('.tab-content').each(function () {
      $(this).find('.tab-pane').first().addClass('fade in');
    });
    //bootstrap collapse - show first tab
    $('.panel-group').each(function () {
      $(this).find('a').first().filter('.collapsed').trigger('click');
    });
    //tooltip
    if ($().tooltip) {
      $('[data-toggle="tooltip"]').tooltip();
    }

    //comingsoon counter
    if ($().countdown) {
      var $counter = $('#comingsoon-countdown');
      //today date plus month for demo purpose
      var date = ($counter.data('date') !== 'undefined') ? $counter.data('date') : false;
      if (date) {
        date = new Date(date);
      } else {
        date = new Date();
        date.setMonth(date.getMonth() + 1);
      }
      $counter.countdown({until: date});
    }

    /////////////////////////////////////////////////
    //PHP widgets - contact form, search, MailChimp//
    /////////////////////////////////////////////////

    //contact form processing
    $('form.contact-form').on('submit', function (e) {
      e.preventDefault();
      var $form = $(this);
      $($form).find('.contact-form-respond').remove();

      //checking on empty values
      $($form).find('[aria-required="true"], [required]').each(function (index) {
        var $thisRequired = $(this);
        if (!$thisRequired.val().length) {
          $thisRequired
              .addClass('invalid')
              .on('focus', function () {
                $thisRequired
                    .removeClass('invalid');
              });
        }
      });
      //if one of form fields is empty - exit
      if ($form.find('[aria-required="true"], [required]').hasClass('invalid')) {
        return;
      }

      //sending form data to PHP server if fields are not empty
      var request = $form.serialize();
      var ajax = jQuery.post("contact-form.php", request)
          .done(function (data) {
            $($form).find('[type="submit"]').attr('disabled', false).parent().append('<div class="contact-form-respond color-main mt-20">' + data + '</div>');
            //cleaning form
            var $formErrors = $form.find('.form-errors');
            if (!$formErrors.length) {
              $form[0].reset();
            }
          })
          .fail(function (data) {
            $($form).find('[type="submit"]').attr('disabled', false).blur().parent().append('<div class="contact-form-respond color-main mt-20">Mail cannot be sent. You need PHP server to send mail.</div>');
          })
    });


    //search modal
    $(".search_modal_button").on('click', function (e) {
      e.preventDefault();
      $('#search_modal').modal('show').find('input').first().focus();
    });
    //search form processing - not need in WP
    $('form.searchform, form.search-form').on('submit', function (e) {

      e.preventDefault();
      var $form = $(this);
      var $searchModal = $('#search_modal');
      $searchModal.find('div.searchform-respond').remove();

      //checking on empty values
      $($form).find('[type="text"], [type="search"]').each(function (index) {
        var $thisField = $(this);
        if (!$thisField.val().length) {
          $thisField
              .addClass('invalid')
              .on('focus', function () {
                $thisField.removeClass('invalid')
              });
        }
      });
      //if one of form fields is empty - exit
      if ($form.find('[type="text"]').hasClass('invalid')) {
        return;
      }

      $searchModal.modal('show');
      //sending form data to PHP server if fields are not empty
      var request = $form.serialize();
      var ajax = jQuery.post("search.php", request)
          .done(function (data) {
            $searchModal.append('<div class="searchform-respond">' + data + '</div>');
          })
          .fail(function (data) {
            $searchModal.append('<div class="searchform-respond">Search cannot be done. You need PHP server to search.</div>');

          })
    });

    //MailChimp subscribe form processing
    $('.signup').on('submit', function (e) {
      e.preventDefault();
      var $form = $(this);
      // update user interface
      $form.find('.response').html('Adding email address...');
      // Prepare query string and send AJAX request
      jQuery.ajax({
        url: 'mailchimp/store-address.php',
        data: 'ajax=true&email=' + escape($form.find('.mailchimp_email').val()),
        success: function (msg) {
          $form.find('.response').html(msg);
        }
      });
    });

    //twitter
    if ($().tweet) {
      $('.twitter').tweet({
        modpath: "./twitter/",
        count: 2,
        avatar_size: 48,
        loading_text: 'loading twitter feed...',
        join_text: 'auto',
        username: 'michaeljackson',
        template: "{avatar}<div class=\"tweet_right\">{join}<span class=\"tweet_text links-maincolor\">{tweet_text}</span>{time}</div>"
      });
    }

    // init timetable
    var $timetable = $('#timetable');
    if ($timetable.length) {
      // bind filter click
      $('#timetable_filter').on('click', 'a', function (e) {
        e.preventDefault();
        e.stopPropagation();
        var $thisA = $(this);
        if ($thisA.hasClass('selected')) {
          // return false;
          return;
        }
        var selector = $thisA.attr('data-filter');
        $timetable
            .find('tbody td')
            .removeClass('current')
            .end()
            .find(selector)
            .closest('td')
            .addClass('current');
        $thisA.closest('ul').find('a').removeClass('selected');
        $thisA.addClass('selected');
      });
    }

  }

//function that initiating template plugins on window.load event
  function windowLoadInit() {

    /////////
    //SHOP///
    /////////
    jQuery('#toggle_shop_view').on('click', function (e) {
      e.preventDefault();
      jQuery(this).toggleClass('grid-view');
      jQuery('#products').toggleClass('grid-view list-view');
    });
    //zoom image
    if (jQuery().elevateZoom) {
      jQuery('#product-image').elevateZoom({
        gallery: 'product-image-gallery',
        cursor: 'pointer',
        galleryActiveClass: 'active',
        responsive: true,
        loadingIcon: 'img/AjaxLoader.gif'
      });
    }

    //add review button
    jQuery('.review-link').on('click', function (e) {
      var $thisLink = jQuery(this);
      var reviewTabLink = jQuery('a[href="#reviews_tab"]');
      //show tab only if it's hidden
      if (!reviewTabLink.parent().hasClass('active')) {
        reviewTabLink
            .tab('show')
            .on('shown.bs.tab', function (e) {
              $window.scrollTo($thisLink.attr('href'), 400);
            })
      }
      $window.scrollTo($thisLink.attr('href'), 400);
    });

    //product counter
    jQuery('.plus, .minus').on('click', function (e) {
      var numberField = jQuery(this).parent().find('[type="number"]');
      var currentVal = numberField.val();
      var sign = jQuery(this).val();
      if (sign === '-') {
        if (currentVal > 1) {
          numberField.val(parseFloat(currentVal) - 1);
        }
      } else {
        numberField.val(parseFloat(currentVal) + 1);
      }
    });

    //remove product from cart
    jQuery('a.remove').on('click', function (e) {
      e.preventDefault();
      jQuery(this).closest('li, .woocommerce-mini-cart-item').remove();
    });

    //price filter - only for HTML
    if (jQuery().slider) {
      var $rangeSlider = jQuery(".slider-range-price");
      if ($rangeSlider.length) {
        var $priceMin = jQuery(".price_from");
        var $priceMax = jQuery(".price_to");
        $rangeSlider.slider({
          range: true,
          min: 0,
          max: 200,
          values: [30, 100],
          slide: function (event, ui) {
            $priceMin.html('$' + ui.values[0]);
            $priceMax.html('$' + ui.values[1]);
          }
        });
        $priceMin.html('$' + $rangeSlider.slider("values", 0));
        $priceMax.html('$' + $rangeSlider.slider("values", 1));
      }
    }

    //color filter
    jQuery(".color-filters").find("a[data-background-color]").each(function () {
      jQuery(this).css({"background-color": jQuery(this).data("background-color")});
    }); // end of SHOP

    //////////////
    //flexslider//
    //////////////
    if ($().flexslider) {
      var $introSlider = $(".page_slider .flexslider");
      $introSlider.each(function (index) {
        var $currentSlider = $(this);
        var data = $currentSlider.data();
        var nav = (data.nav !== 'undefined') ? data.nav : true;
        var dots = (data.dots !== 'undefined') ? data.dots : true;
        var speed = (data.speed !== 'undefined') ? data.speed : 7000;

        $currentSlider.flexslider({
          animation: "fade",
          pauseOnHover: true,
          useCSS: true,
          controlNav: dots,
          directionNav: nav,
          prevText: "",
          nextText: "",
          smoothHeight: false,
          slideshowSpeed: speed,
          animationSpeed: 600,
          start: function (slider) {
            slider.find('.intro_layers').children().css({'visibility': 'hidden'});
            slider.find('.flex-active-slide .intro_layers').children().each(function (index) {
              var self = $(this);
              var animationClass = !self.data('animation') ? 'fadeInRight' : self.data('animation');
              setTimeout(function () {
                self.addClass("animated " + animationClass);
              }, index * 250);
            });
          },
          after: function (slider) {
            slider.find('.flex-active-slide .intro_layers').children().each(function (index) {
              var self = $(this);
              var animationClass = !self.data('animation') ? 'fadeInRight' : self.data('animation');
              setTimeout(function () {
                self.addClass("animated " + animationClass);
              }, index * 250);
            });
          },
          end: function (slider) {
            slider.find('.intro_layers').children().each(function () {
              var self = $(this);
              var animationClass = !self.data('animation') ? 'fadeInRight' : self.data('animation');
              self.removeClass('animated ' + animationClass).css({'visibility': 'hidden'});
              // $(this).attr('class', '');
            });
          },

        })
        //wrapping nav with container - uncomment if need
        // .find('.flex-control-nav')
        // .wrap('<div class="container nav-container"/>')
      }); //.page_slider flex slider

      if ( document.getElementById('myVideo') ) {
        var $videobg = document.getElementById('myVideo');
        $videobg.currentTime = 0;
        $videobg.play();

        $('.slides').bind('classChanged','li:first', function () {
          $videobg.currentTime = 0;
          $videobg.play();
          $videobg.addEventListener('timeupdate', function () {
            if ( this.currentTime >= 20 ) {
              $videobg.currentTime = 0;
              $videobg.play();
            }
          })
        });
      }

      $(".flexslider").each(function (index) {
        var $currentSlider = $(this);
        //exit if intro slider already activated
        if ($currentSlider.find('.flex-active-slide').length) {
          return;
        }
        $currentSlider.flexslider({
          animation: "fade",
          useCSS: true,
          controlNav: true,
          directionNav: false,
          prevText: "",
          nextText: "",
          smoothHeight: false,
          slideshowSpeed: 5000,
          animationSpeed: 800
        })
      });
    }

    (function () {
      var originalAddClassMethod = jQuery.fn.addClass;
      var originalRemoveClassMethod = jQuery.fn.removeClass;
      jQuery.fn.addClass = function () {
        var result = originalAddClassMethod.apply(this, arguments);
        jQuery(this).trigger('classChanged');
        return result;
      }
      jQuery.fn.removeClass = function () {
        var result = originalRemoveClassMethod.apply(this, arguments);
        jQuery(this).trigger('classChanged');
        return result;
      }
    })();

    ////////////////
    //owl carousel//
    ////////////////
    if ($().owlCarousel) {
      $('.owl-carousel').each(function () {
        var $carousel = $(this);
        $carousel.find('> *').each(function (i) {
          $(this).attr('data-index', i);
        });
        var data = $carousel.data();

        var loop = data.loop ? data.loop : false,
            margin = (data.margin || data.margin === 0) ? data.margin : 30,
            nav = data.nav ? data.nav : false,
            navPrev = data.navPrev ? data.navPrev : '<i class="fa fa-chevron-left">',
            navNext = data.navNext ? data.navNext : '<i class="fa fa-chevron-right">',
            dots = data.dots ? data.dots : false,
            themeClass = data.themeclass ? data.themeclass : 'owl-theme',
            center = data.center ? data.center : false,
            items = data.items ? data.items : 4,
            autoplay = data.autoplay ? data.autoplay : false,
            responsiveXs = data.responsiveXs ? data.responsiveXs : 1,
            responsiveSm = data.responsiveSm ? data.responsiveSm : 2,
            responsiveMd = data.responsiveMd ? data.responsiveMd : 3,
            responsiveLg = data.responsiveLg ? data.responsiveLg : 4,
            draggable = (data.draggable === false) ? data.draggable : true,
            syncedClass = (data.syncedClass) ? data.syncedClass : false,
            filters = data.filters ? data.filters : false;

        if (filters) {
          $carousel.after($carousel.clone().addClass('owl-carousel-filter-cloned'));
          $(filters).on('click', 'a', function (e) {
            //processing filter link
            e.preventDefault();
            if ($(this).hasClass('selected')) {
              return;
            }
            var filterValue = $(this).attr('data-filter');
            $(this).siblings().removeClass('selected active');
            $(this).addClass('selected active');

            //removing old items
            for (var i = $carousel.find('.owl-item').length - 1; i >= 0; i--) {
              $carousel.trigger('remove.owl.carousel', [1]);
            }
            ;

            //adding new items
            var $filteredItems = $($carousel.next().find(' > ' + filterValue).clone());
            $filteredItems.each(function () {
              $carousel.trigger('add.owl.carousel', $(this));
              $(this).addClass('scaleAppear');
            });

            $carousel.trigger('refresh.owl.carousel');

            //reinit prettyPhoto in filtered OWL carousel
            if ($().prettyPhoto) {
              $carousel.find("a[data-gal^='prettyPhoto']").prettyPhoto({
                hook: 'data-gal',
                theme: 'facebook' /* light_rounded / dark_rounded / light_square / dark_square / facebook / pp_default*/
              });
            }
          });

        } //filters

        $carousel.owlCarousel({
          loop: loop,
          margin: margin,
          nav: nav,
          autoplay: autoplay,
          dots: dots,
          themeClass: themeClass,
          center: center,
          navText: [navPrev, navNext],
          mouseDrag: draggable,
          touchDrag: draggable,
          items: items,
          responsive: {
            0: {
              items: responsiveXs
            },
            767: {
              items: responsiveSm
            },
            992: {
              items: responsiveMd
            },
            1200: {
              items: responsiveLg
            }
          },
        })
            .addClass(themeClass);
        if (center) {
          $carousel.addClass('owl-center');
        }

        $window.on('resize', function () {
          $carousel.trigger('refresh.owl.carousel');
        });

        //topline two synced carousels
        if ($carousel.hasClass('owl-news-slider-items') && syncedClass) {
          $carousel.on('changed.owl.carousel', function (e) {
            var indexTo = loop ? e.item.index + 1 : e.item.index;
            $(syncedClass).trigger('to.owl.carousel', [indexTo]);
          })
        }


      });


    } //eof owl-carousel


    ////////////////////
    //header processing/
    ////////////////////
    //stick header to top
    //wrap header with div for smooth sticking
    var $header = $('.page_header').first();
    var boxed = $header.closest('.boxed').length;
    var headerSticked = $('.header_side_sticked').length;
    if ($header.length) {
      //hiding main menu 1st levele elements that do not fit width
      menuHideExtraElements();
      //mega menu
      initMegaMenu(1);
      //wrap header for smooth stick and unstick
      var headerHeight = $header.outerHeight();
      $header.wrap('<div class="page_header_wrapper"></div>');
      var $headerWrapper = $('.page_header_wrapper');
      if (!boxed) {
        $headerWrapper.css({height: headerHeight});
      }

      //headerWrapper background - same as header
      if ($header.hasClass('ls')) {
        $headerWrapper.addClass('ls');
        if ($header.hasClass('ms')) {
          $headerWrapper.addClass('ms');
        }
      } else if ($header.hasClass('ds')) {
        $headerWrapper.addClass('ds');
        if ($header.hasClass('bs')) {
          $headerWrapper.addClass('bs');
        }
        if ($header.hasClass('ms')) {
          $headerWrapper.addClass('ms');
        }

      } else if ($header.hasClass('cs')) {
        $headerWrapper.addClass('cs');
        if ($header.hasClass('cs2')) {
          $headerWrapper.addClass('cs2');
        }
        if ($header.hasClass('cs3')) {
          $headerWrapper.addClass('cs3');
        }
      } else if ($header.hasClass('gradient-background')) {
        $headerWrapper.addClass('gradient-background');
      }

      //get offset
      var headerOffset = 0;
      //check for sticked template headers
      if (!boxed && !($headerWrapper.css('position') === 'fixed')) {
        headerOffset = $header.offset().top;
      }

      //for boxed layout - show or hide main menu elements if width has been changed on affix
      $header.on('affixed-top.bs.affix affixed.bs.affix affixed-bottom.bs.affix', function (e) {
        if ($header.hasClass('affix-top')) {
          $headerWrapper.removeClass('affix-wrapper affix-bottom-wrapper').addClass('affix-top-wrapper');
          //cs to ls when affixed
          // if($header.hasClass('cs')) {
          // 	$header.removeClass('ls');
          // }
        } else if ($header.hasClass('affix')) {
          $headerWrapper.removeClass('affix-top-wrapper affix-bottom-wrapper').addClass('affix-wrapper');
          //cs to ls when affixed
          // if($header.hasClass('cs')) {
          // 	$header.addClass('ls');
          // }
        } else if ($header.hasClass('affix-bottom')) {
          $headerWrapper.removeClass('affix-wrapper affix-top-wrapper').addClass('affix-bottom-wrapper');
        } else {
          $headerWrapper.removeClass('affix-wrapper affix-top-wrapper affix-bottom-wrapper');
        }

        //calling this functions disable menu items animation when going from affix to affix-top with centered logo inside
        //in boxed layouts header is always fixed
        if (boxed && !($header.css('position') === 'fixed')) {
          menuHideExtraElements();
          initMegaMenu(1);
        }
        if (headerSticked) {
          initMegaMenu(1);
        }

      });

      //if header has different height on afixed and affixed-top positions - correcting wrapper height
      $header.on('affixed-top.bs.affix', function () {
        // $headerWrapper.css({height: $header.outerHeight()});
      });

      //fixing auto affix bug - toggle affix on click when page is at the top
      $header.on('affix.bs.affix', function () {
        if (!$window.scrollTop()) return false;
      });

      $header.affix({
        offset: {
          top: headerOffset,
          bottom: -10
        }
      });
    }

    //aside affix
    initAffixSidebar();

    $body.scrollspy('refresh');

    //appear plugin is used to elements animation, counter, pieChart, bootstrap progressbar
    if ($().appear) {
      //animation to elements on scroll
      var $animate = $('.animate');
      $animate.appear();

      $animate.filter(':appeared').each(function (index) {
        initAnimateElement($(this), index);
      });

      $body.on('appear', '.animate', function (e, $affected) {
        $($affected).each(function (index) {
          initAnimateElement($(this), index);
        });
      });

      //counters init on scroll
      if ($().countTo) {
        var $counter = $('.counter');
        $counter.appear();

        $counter.filter(':appeared').each(function () {
          initCounter($(this));
        });
        $body.on('appear', '.counter', function (e, $affected) {
          $($affected).each(function () {
            initCounter($(this));
          });
        });
      }

      //bootstrap animated progressbar
      if ($().progressbar) {
        var $progressbar = $('.progress .progress-bar');
        $progressbar.appear();

        $progressbar.filter(':appeared').each(function () {
          initProgressbar($(this));
        });
        $body.on('appear', '.progress .progress-bar', function (e, $affected) {
          $($affected).each(function () {
            initProgressbar($(this));
          });
        });
        //animate progress bar inside bootstrap tab
        $('a[data-toggle="tab"]').on('shown.bs.tab', function (e) {
          initProgressbar($($(e.target).attr('href')).find('.progress .progress-bar'));
        });
        //animate progress bar inside bootstrap dropdown
        $('.dropdown').on('shown.bs.dropdown', function (e) {
          initProgressbar($(this).find('.progress .progress-bar'));
        });
      }

      //circle progress bar
      if ($().easyPieChart) {
        var $chart = $('.chart');

        $chart.appear();

        $chart.filter(':appeared').each(function () {
          initChart($(this));
        });
        $body.on('appear', '.chart', function (e, $affected) {
          $($affected).each(function () {
            initChart($(this));
          });
        });

      }

    } //appear check

    //Flickr widget
    // use http://idgettr.com/ to find your ID
    if ($().jflickrfeed) {
      var $flickr = $("#flickr, .flickr_ul");
      if ($flickr.length) {
        if (!($flickr.hasClass('flickr_loaded'))) {
          $flickr.jflickrfeed({
            flickrbase: "http://api.flickr.com/services/feeds/",
            limit: 4,
            qstrings: {
              id: "131791558@N04"
            },
            itemTemplate: '<a href="{{image_b}}" class="photoswipe-link"><li><img alt="{{title}}" src="{{image_m}}" /></li></a>'
            //complete
          }, function (data) {
            initPhotoSwipe();
          }).addClass('flickr_loaded');
        }
      }
    }

    // Instagram widget
    if (jQuery().spectragram) {
      var Spectra = {
        instaToken: '3905738328.5104743.42b91d10580042e3aeeab90c926666a4',

        init: function () {
          jQuery.fn.spectragram.accessData = {
            accessToken: this.instaToken
          };

          //available methods: getUserFeed, getRecentTagged
          jQuery('.instafeed').each(function () {
            var $this = jQuery(this);
            if ($this.find('img').length) {
              return;
            }
            $this.spectragram('getUserFeed', {
              max: 4,
              wrapEachWith: '<div class="photo" />'
            });
          });

        }
      }

      Spectra.init();
    }

    // init Isotope
    $('.isotope-wrapper').each(function (index) {
      var $container = $(this);
      var layoutMode = ($container.hasClass('masonry-layout')) ? 'masonry' : 'fitRows';
      var columnWidth = ($container.children('.col-md-4').length) ? '.col-md-4' : false;
      $container.isotope({
        percentPosition: true,
        layoutMode: layoutMode,
        masonry: {
          //TODO for big first element in grid - giving smaller element to use as grid
          // columnWidth: '.isotope-wrapper > .col-md-4'
          columnWidth: columnWidth
        }
      });

      var $filters = $container.attr('data-filters') ? $($container.attr('data-filters')) : $container.prev().find('.filters');
      // bind filter click
      if ($filters.length) {
        $filters.on('click', 'a', function (e) {
          e.preventDefault();
          console.log($(this));
          var $thisA = $(this);
          var filterValue = $thisA.attr('data-filter');
          $container.isotope({filter: filterValue});
          $thisA.siblings().removeClass('selected active');
          $thisA.addClass('selected active');
        });
        //for works on select
        $filters.on('change', 'select', function (e) {
          e.preventDefault();
          var filterValue = $(this).val();
          $container.isotope({filter: filterValue});
        });
      }
    });


    /////////
    //SHOP///
    /////////
    $('#toggle_shop_view').on('click', function (e) {
      e.preventDefault();
      $(this).toggleClass('grid-view');
      $('#products').toggleClass('grid-view list-view');
    });


    //checkout collapse forms - only for HTML
    $('a.showlogin, a.showcoupon').on('click', function (e) {
      e.preventDefault();
      var $form = $(this).parent().next();

      if ($form.css('display') === 'none') {
        $form.show(150);
      } else {
        $form.hide(150);
      }
    });


    //remove product from cart - only for HTML
    $('a.remove').on('click', function (e) {
      e.preventDefault();
      $(this).closest('tr, .media').remove();
    });


    //flexslider - only for HTML
    // $('.images').flexslider({
    //   animation: "slide",
    //   controlNav: "thumbnails",
    //   selector: "figure > div",
    //   directionNav: false,
    // });

    //tabs - only for HTML
    $('.wc-tab, .woocommerce-tabs .panel:not(.panel .panel)').hide();

    $('.wc-tabs li a, ul.tabs li a').on('click', function (e) {
      e.preventDefault();
      var $tab = $(this);
      var $tabs_wrapper = $tab.closest('.wc-tabs-wrapper, .woocommerce-tabs');
      var $tabs = $tabs_wrapper.find('.wc-tabs, ul.tabs');

      $tabs.find('li').removeClass('active');
      $tabs_wrapper.find('.wc-tab, .panel:not(.panel .panel)').hide();

      $tab.closest('li').addClass('active');
      $tabs_wrapper.find($tab.attr('href')).show();
    });
    // Review link
    $('a.woocommerce-review-link').on('click', function () {
      $('.reviews_tab a').trigger('click');
      return true;
    });

    //parsing URL hash
    var hash = window.location.hash;
    var url = window.location.href;
    var $tabs = $('.wc-tabs, ul.tabs').first();

    if (hash.toLowerCase().indexOf('comment-') >= 0 || hash === '#reviews' || hash === '#tab-reviews') {
      $tabs.find('li.reviews_tab a').trigger('click');
    } else if (url.indexOf('comment-page-') > 0 || url.indexOf('cpage=') > 0) {
      $tabs.find('li.reviews_tab a').trigger('click');
    } else if (hash === '#tab-additional_information') {
      $tabs.find('li.additional_information_tab a').trigger('click');
    } else {
      $tabs.find('li:first a').trigger('click');
    }


    //price filter - only for HTML
    if ($().slider) {
      var $rangeSlider = $(".slider-range-price");
      if ($rangeSlider.length) {
        var $priceMin = $(".slider_price_min");
        var $priceMax = $(".slider_price_max");
        $rangeSlider.slider({
          range: true,
          min: 0,
          max: 100000,
          values: [1500, 30000],
          slide: function (event, ui) {
            $priceMin.val(ui.values[0]);
            $priceMax.val(ui.values[1]);
          }
        });
        $priceMin.val($rangeSlider.slider("values", 0));
        $priceMax.val($rangeSlider.slider("values", 1));
      }
    }


    //woocommerce related products, upsells products
    // $('.related.products ul.products, .upsells.products ul.products, .cross-sells ul.products')
    //     .addClass('owl-carousel top-right-nav')
    //     .owlCarousel({
    //       loop: true,
    //       autoplay: true,
    //       margin: 30,
    //       nav: true,
    //       dots: false,
    //       items: 3,
    //       navText: ['<i class="fa fa-chevron-left"></i>', '<i class="fa fa-chevron-right"></i>'],
    //       responsive: {
    //         0: {
    //           items: 1
    //         },
    //         767: {
    //           items: 2
    //         },
    //         992: {
    //           items: 2
    //         },
    //         1200: {
    //           items: 3
    //         }
    //       }
    //     });

    //color filter
    $(".color-filters").find("a[data-background-color]").each(function () {
      $(this).css({"background-color": $(this).data("background-color")});
    });
    ////////////////
    // end of SHOP//
    ////////////////


    //Unyson or other messages modal
    var $messagesModal = $('#messages_modal');
    if ($messagesModal.find('ul').length) {
      $messagesModal.modal('show');
    }

    //page preloader
    $(".preloaderimg").fadeOut(150);
    $(".preloader").fadeOut(150).delay(50, function () {
      $(this).remove();
    });
  }//eof windowLoadInit

  $(document).ready(function () {
    documentReadyInit();
    initGoogleMap();
  });

  $window.on('load', function () {
    windowLoadInit();
  }); //end of "window load" event

  $window.on('resize', function () {

    $body.scrollspy('refresh');

    //header processing
    menuHideExtraElements();
    initMegaMenu(1);
    var $header = $('.page_header').first();
    //checking document scrolling position
    if ($header.length && !$(document).scrollTop() && $header.first().data('bs.affix')) {
      $header.first().data('bs.affix').options.offset.top = $header.offset().top;
    }
    if (!$header.closest('.boxed').length) {
      var affixed = false;
      if ($header.hasClass('affix')) {
        affixed = true;
        //animation duration
        $header.removeClass('affix');

        //TODO fix header wrapper height from small to large when page is scrolled (not top)
        setTimeout(function () {
          //editing header wrapper height for smooth stick and unstick
          $(".page_header_wrapper").css({height: $header.first().outerHeight()});
          $header.addClass('affix');
        }, 250);
      }

      if (!affixed) {
        //editing header wrapper height for smooth stick and unstick
        $(".page_header_wrapper").css({height: $header.first().outerHeight()});
      }
    }

  });
//end of IIFE function
})(jQuery);

