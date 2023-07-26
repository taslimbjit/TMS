import { Routes, Route } from 'react-router-dom'

import { useEffect, useState } from 'react';

import PrivateOutlet from './Pages/PrivateOutlet';
import config from './utils/config';
import SignIn from './pages/SignIn';


function App() {
  const [user, setUser] = useState();
  const [auth, setAuth] =useState(false);
  const key = () => {
    console.log(config.key)
    if (config.key != null) {
      setUser(config.key.type);
      setAuth(true);
    }
    else {
      setUser('');
      setAuth(false);
    }
  }

  
  useEffect(() => {
    key();
  }, []);
  return (
    <div>
      <Routes>
        {user == '' && <Route path='/*' element={<PrivateOutlet auth={auth} />}/> }
        { user?.toLowerCase() == 'admin' &&(
          <Route path='/*' element={<PrivateOutlet auth={auth} />}>
        </Route>
        )}
        <Route path='/signin' element={<SignIn />}></Route>
         
      </Routes>
    </div>
  );
      }

export default App;