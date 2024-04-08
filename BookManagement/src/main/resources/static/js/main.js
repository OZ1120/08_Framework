/* 책 등록 / 검색, 수정, 삭제 버튼 클릭 시 각자 페이지로 이동 */





// ----------------------------------------------------------------------------

/* 모든 책 조회 */

// 조회 버튼
const selectBookList = document.querySelector("#selectBookList");

// tbody
const bookList = document.querySelector("#bookList");

// 조회버튼 클릭시
selectBookList.addEventListener("click", ()=>{
  
  fetch("/selectBookList")
  .then(response => response.json())
  .then(list => {

    console.log(list);

    bookList.innerHTML = "";



  })
});


// ----------------------------------------------------------------------------


/* 책 등록  */

// 등록 버튼
const addBtn = document.querySelector("#add-btn");

const add = document.querySelector("#add");

addBtn.addEventListener("click",()=>{

});


