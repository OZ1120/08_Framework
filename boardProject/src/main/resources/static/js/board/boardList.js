/* 글쓰기 버튼 클릭시 */

const insertBtn = document.querySelector("#insertBtn")


// 글쓰기 버튼이 로그인 상태 일때
if(insertBtn!=null){
  insertBtn.addEventListener("click", ()=>{

    // * boardCode 얻오오는 방법
    // 1) @PathVariable("boardCode") 얻어오 전역 변수 저장
    // 2) location.pathname.split("/")[2] :: 브라우저 콘솔에서 확인함

    // get방식 요청
    location.href = `/editBoard/${boardCode}/insert`;
    
  })
}



