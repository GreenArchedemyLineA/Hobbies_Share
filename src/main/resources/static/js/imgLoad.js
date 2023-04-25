const mainImg = document.getElementById("main");
const loadClientX = document.body.clientWidth;
mainImg.src = `https://plchldr.co/i/${loadClientX}x400`
window.addEventListener('resize', () => {
    const clientX = document.body.clientWidth;
    console.log(clientX)
    mainImg.src = `https://plchldr.co/i/${clientX}x400`
})