import React from 'react';
import { render } from '@testing-library/react';

import Rotas from './rotas';
import Navbar from '../../../../minhasfinancas/minhas-financas-app/src/components/navbar';

import 'bootswatch/dist/flatly/bootstrap.css'
import '../custom.css'

import 'toastr/build/toastr.min.js'

class App extends React.Component {

  render( ){
    return(
      <>
        <Navbar />
        <div className="container" >
            <Rotas />
        </div>
      </>
    )
  }

}

export default App;