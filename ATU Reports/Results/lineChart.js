            $(document).ready(function(){
                var line1 = [1,1,1,1,1,1,2,1,0,2,0,1,1,1,0,0,0,0,0,0,0,1,1,1,1,1,0,0,0,1,1,1,1,0,0,1,0,1,1,0,1,0,0,1,1,1,1,1,1,1,0,0,1,0,0,0,0,0,0,1,0,0,0,0,0,0];
                var line2 = [0,0,0,0,0,0,0,1,1,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0];
                var line3 = [0,0,0,0,0,0,0,0,1,0,1,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1,0,1,0,0,0,1,2,0,2];

var ticks = [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65];$.jqplot('line', [line1, line2, line3], {
        animate: true,
axesDefaults:{min:0,tickInterval: 1},        seriesDefaults: {
            rendererOptions: {
                smooth: true
            }
        },
        series: [{lineWidth: 1.5, label: 'Passed'},
            {lineWidth: 1.5, label: 'Failed'},
            {lineWidth: 1.5, label: 'Skipped'}],
        axes: {
            xaxis: {
                label: "Run Number",
                ticks: ticks,
                tickOptions: {
                    formatString: "%'d "
                },
                pad: 1.2,
                rendererOptions: {
                    tickInset: 0.3,
                    minorTicks: 1
                }
            },
            yaxis: {
                label: "TC Number"
                ,tickOptions: {
                    formatString: "%'d Tc"
                },
            }
        },
        highlighter: {
            show: true,
            sizeAdjust: 10,
            tooltipLocation: 'n',
            tooltipAxes: 'y',
            tooltipFormatString: '%d :&nbsp;<b><i><span style="color:black;">Test Cases</span></i></b>',
            useAxesFormatters: false
        },
        cursor: {
            show: true
        },
        grid: {background: '#ffffff', drawGridLines: true, gridLineColor: '#cccccc', borderColor: '#cccccc',
            borderWidth: 0.5, shadow: false},
        legend: {show: true, placement: 'outside', location: 'e'},
        seriesColors: ["#7BB661", "#E03C31", "#21ABCD"]
    });
});
