import React from 'react';
import './scss/App.scss';
import Planner from './components/planner/Planner';
function App() {
    return ( 
        <div>
            <header>
                <h1 id="logo">Miwu</h1>
            </header>   
            <Planner />
        </div> 
    );
}

export default App;