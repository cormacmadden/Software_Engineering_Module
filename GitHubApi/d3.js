//data = Object.assign(d3.JSONParse(await FileAttachment("data.json").text(), ({letter, frequency}) => ({name: letter, value: +frequency})).sort((a, b) => d3.descending(a.value, b.value)), {format: "%", y: "↑ Frequency"})

const svg = d3.select("GitHub_d3").append('svg')
.attr("viewBox", [0, 0, width, height]);

svg.append("g")
.attr("fill", color)
.selectAll("rect")
.data(data)
.join("rect")
.attr("x", (d, i) => x(i))
.attr("y", d => y(d.value))
.attr("height", d => y(0) - y(d.value))
.attr("width", x.bandwidth());

svg.append("g")
.call(xAxis);

svg.append("g")
.call(yAxis);

return svg.node();

