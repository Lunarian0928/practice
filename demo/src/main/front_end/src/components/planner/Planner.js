import React, { useEffect, useState } from 'react';
import axios from 'axios';
import AreaCategoryMenu from './AreaCategoryMenu';

const Planner = () => {
    const [loading, setLoading] = useState(false);
    const [areaCodeData, setAreaCodeData] = useState([]);

    useEffect(() => {
        console.log(areaCodeData);
    }
    , [areaCodeData]);

    async function makeAreaCategoryMenu() {
        setLoading(true);
        axios.get('/areaCode')
        .then(response => {
            setAreaCodeData(response.data.response.body.items.item);
        })
        .catch(error => {
            console.log(error.response);
        });
    }
    console.log()
    return (
        <div id="planner"> 
            <h2>여행 플래너</h2>
            <button className="btn btn-warning" onClick={makeAreaCategoryMenu}>카테고리 만들기</button>
            {(areaCodeData.length != 0) ? <AreaCategoryMenu categoryData={areaCodeData} /> : null}

        </div>
    );    
};

export default Planner;