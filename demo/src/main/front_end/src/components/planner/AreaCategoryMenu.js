import React from 'react';
import RoundRectBtn from '../btn/RoundRectBtn';
const AreaCategoryMenu = (props) => {
    return (
        <ul>
            {props.categoryData.map((area, index) => {return <li key={index}><RoundRectBtn label={area.name} /></li>})}
        </ul>
        
    );    
}

export default AreaCategoryMenu;