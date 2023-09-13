import React, {useEffect, useState} from 'react';

function App() {
    const [spotNameData, setSpotNameData] = useState([]);
    const [spotSummaryData, setSpotSummaryData] = useState([]);
    const [loading, setLoading] = useState(true);

    useEffect(() => { 
        // 렌더링할때, 화면에 무언가 표시하려 할때 
        // 함수를 실행시키려고 useEffect를 써요
        fetch("/guide/강릉") 
        // fetch는 연결하는 명령어에요. localhost:8080/guide/강릉 페이지와 연결할 거에요.
        // localhost:8080은 설정 파일에 설정해놓은 게 있어서 생략이 가능해졌어요. 
            .then((response) => { // 연결이 잘 되면
                return response.json(); 
                // localhost:8080/guide/강릉이 응답하는(리턴하는) 거를 텍스트로 바꾼거에요.
                // GuideController 보시면 저희가 리턴하는 게 문자열이어서 .text()를 쓴거에요.
            }) // 
            .then(function (data) { 
                console.log(data);
                setLoading(false);
            })
    }, []);
    return (
        <div>
            {
                loading ? 
                <p>로딩중</p> 
                : 
                null
                
            }
        </div> 
    );
}

export default App;