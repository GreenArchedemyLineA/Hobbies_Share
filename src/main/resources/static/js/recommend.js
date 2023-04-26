/**
 * @author lhs
 */
const targetDiv = document.getElementById("aside-recommend");
 fetch("/recommend/age?id=10",{
	 method: "GET",
	 headers: {
		 "Content-Type": "application/json",
	 },	 
 })
 .then((response) => response.json())
 .then((data)=>{
	 console.log(data)
	 data.map((obj)=>{
		 const divTag = document.createElement("div");
		 divTag.classList.add('recommend')
		 const aTag = document.createElement("a");
		 aTag.innerText = obj.username;
		 aTag.href="#"
		 divTag.appendChild(aTag);
		 targetDiv.appendChild(divTag);
	 })
 })