import ApiService from "../apiService";

import ErroValidacao from "../exception/ErroValidacao";

class UserService extends ApiService {

    constructor( ){
        super('api/usuarios')
    }

    salvar( usuario ){
        return this.post( '/', usuario )
    }

    autenticar( credenciais ){
        return this.post('/autenticar', credenciais )
    }

    returnUser( idUsuario ){
        return this.get( '/listaUsuario', idUsuario )
    }

    returnUsers( idUsuario ){
        return this.get( `/${idUsuario}` )
    }

    validar( usuario ){
        const erros = []

        if( !usuario.nome ){
            erros.push('O campo nome é obrigatório!')
        }

        if( !usuario.email ){
            erros.push('O campo e-mail é orbigatorio!')
        }else if( !usuario.email.match(/^[a-z0-9.]+@[a-z0-9]+\.[a-z]/) ){
            erros.push('E-mail inválido!')
        }

        if( !usuario.senha || !usuario.senhaRepeticao )
        {
            erros.push('Digite a senha nos campos informados!')
        }else if( usuario.senha !== usuario.senhaRepeticao ){
            erros.push('As senhas não batem!')
        }

        if( erros && erros.length > 0){
            throw new ErroValidacao( erros );
        }

    }

}

export default UserService;