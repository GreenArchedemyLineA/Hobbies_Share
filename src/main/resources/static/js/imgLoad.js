const mainImg = document.getElementById("main");
const loadClientX = document.body.clientWidth;
mainImg.width = document.body.clientWidth;
window.addEventListener('resize', () => {
    const clientX = document.body.clientWidth;
    console.log(clientX)
	mainImg.width = clientX;
	//mainImg.height = 300;
})