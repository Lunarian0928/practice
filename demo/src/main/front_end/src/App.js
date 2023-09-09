import React, {useEffect, useState} from 'react';
function App() {
    const [message, setMessage] = useState(''); 
    // GuideController에서 가져오는 chatGPT의 대답을 집어넣을 상태값이에요.
    // 상태는 react랑 무조건 엮이는 친구고 이 친구가 없으면
    // 상태값이 바뀌어도 화면에 출력되지가 않아요.
    
    // const [loading, setLoading] = useState(true);
    // 로딩되는지 알 수 있는 상태값과 그런 상태를 설정할 수 있는 데이터에요.


    useEffect(() => { 
        // 렌더링할때, 화면에 무언가 표시하려 할때 
        // 함수를 실행시키려고 useEffect를 써요
        fetch("/guide/강릉") 
        // fetch는 연결하는 명령어에요. localhost:8080/guide/강릉 페이지와 연결할 거에요.
        // localhost:8080은 설정 파일에 설정해놓은 게 있어서 생략이 가능해졌어요. 
            .then((response) => { // 연결이 잘 되면
                return response.text(); 
                // localhost:8080/guide/강릉이 응답하는(리턴하는) 거를 텍스트로 바꾼거에요.
                // GuideController 보시면 저희가 리턴하는 게 문자열이어서 .text()를 쓴거에요.
            }) // 
            .then(function (data) {
                setMessage(data); // 여기서 data는 response.text()를 얘기해요.
                // setMessage를 통해 message는 data=response.text()=chatGPT 대답이 됩니다.
            });
    }, []);
    

    return (
        <div>
            강릉에서 가져온 데이터입니다 : {message} 
        </div> 
    );
}

export default App;