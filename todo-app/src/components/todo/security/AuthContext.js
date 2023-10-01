import { createContext, useContext, useState } from "react";
import { executeBasicAuthenticationService } from "../api/HelloWorldApiService";

//1: Create a Context
export const AuthContext = createContext()

export const useAuth = () => useContext(AuthContext)

//2: Share the created context with other components
export default function AuthProvider({ children }) {

    //3: Put some state in the context
    const [isAuthenticated, setAuthenticated] = useState(false);

    const [username, setUsername] = useState(null);

    const [token, setToken] = useState(null)

    // function login(username, password) {
    //     if(username==='geolyun' && password==='dummy') {
    //         setAuthenticated(true)
    //         setUsername(username)
    //         return true
    //     } else {
    //         setAuthenticated(false)
    //         setUsername(null)
    //         return false
    //     }
    // }

    async function login(username, password) {

    // async와 await는 자바스크립트의 비동기 처리 패턴 중 가장 최근에 나온 문법

        // btoa() 함수는 이진 문자열(String 객체 내 모든 문자가 이진 데이터의 바이트 한 개)로부터 Base64 인코딩된 ASCII 문자열을 생성해 반환합니다.
        const batoken = 'Basic ' + window.btoa( username + ":" + password )

        try {

            const response = await executeBasicAuthenticationService(batoken)
            
            if(response.status==200) {
                setAuthenticated(true)
                setUsername(username)
                setToken(batoken)
                return true
            } else {
                setAuthenticated(false)
                setUsername(null)
                setToken(null)
                return false
            }
        } catch(error){
            logout()
            return false
        }
    }

    function logout() {
        setAuthenticated(false)
        setToken(null)
        setUsername(null)
    }

    return (
        <AuthContext.Provider value={ {isAuthenticated, login, logout, username, token} }>
            {children}
        </AuthContext.Provider>
    )
}

