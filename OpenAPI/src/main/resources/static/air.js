/* 개인 API 인증키 */

const serviceKey = "WCQYQB3bkrkzZfjc6UGwBUSEyH6oDSWPkqxO36vcZJN3K0nA6PTt90Sc9/KEX0eAbwa94oMljoUwJ2Vn4Bv4dA==";

const getAirPollution = (sidoName) => {

const requestUrl = 'http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty';

const sidoName = "서울";

// 쿼리 스트링 생성 (URLSearchParams.toString())

const searchParams = new URLSearchParams();

searchParams.append('returnType', 'JSON');

searchParams.append('sidoName', sidoName);

// fetch(requestUrl)
fetch(`${requestUrl}?${searchParams.toString()}`)

.then(resp => resp.json())

.then(result => {

console.log(result);

})

.catch(e => console.log(e));

}


// 서울 부산 대전 세개