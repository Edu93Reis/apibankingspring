import React from 'react';

import Login from '../view/login'
import CadastroUsuario from '../view/cadastraUsuario'
import Home from '../view/home'

import { Route, Switch, HashRouter } from 'react-router-dom'

function Rotas( ){
    return (
        <HashRouter>
            <Switch>
                <Route path="/home" component={Home} />
                <Route path="/login" component={Login} />
                <Route path="cadastro-usuario" component={CadastroUsuario} />
            </Switch>
        </HashRouter>
    )
}

export default Rotas