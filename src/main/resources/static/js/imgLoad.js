const mainImg = document.getElementById("main");
const loadClientX = document.body.clientWidth;
mainImg.width = document.body.clientWidth*0.8;
window.addEventListener('resize', () => {
    const clientX = document.body.clientWidth;
    console.log(clientX)
	mainImg.width = clientX*0.8;
	mainImg.height = 300*0.8;
	//mainImg.height = 300;
})