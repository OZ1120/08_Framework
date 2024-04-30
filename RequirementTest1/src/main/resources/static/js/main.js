const selectAll = document.querySelector("#selectAll");
const tbody = document.querySelector("#tbody");

selectAll.addEventListener("click", e =>{
  
  const createTd = (text) => {
    const td = document.createElement("td");
    td.innerText= text;
    return td;
  }
  fetch("/main/select")
  .then(response => response.JSON())
  .then(list =>{
    
    // const stdList = JSON.parse(result);
    console.log(list);

    tbody.innerHTML = "";

    list.forEach(student,index => {

      const keyList = ['studentNo', 'studentName', 'studentMajor', 'studentGender']

      const tr = document.createElement("tr");
      keyList.forEach( key => {
        const td = createTd(student[key])
        tr.append(td);
      })

      tbody.append(tr);
      
    });


  })
})
