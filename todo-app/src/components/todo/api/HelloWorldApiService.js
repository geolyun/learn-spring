import axios from "axios";

// export function retrieveHelloWorldBean() {
//     return axios.get('http://localhost:8080/hello-world-bean')
// }

const apiClient = axios.create(
    {
        baseURL: 'http://localhost:8080'
    }
)

export const retrieveHelloWorldBean 
    = () => apiClient.get('/hello-world-bean')


//Response to preflight request doesn't pass access control check => Authorization header
export const retrieveHelloWorldPathVariable 
    = (username) => apiClient.get(`/hello-world/path-variable/${username}`,{
        headers: {
            Authorization: 'Basic Z2VvbHl1bjpkdW1teQ=='
        }
    })

export const executeBasicAuthenticationService 
    = (token) => apiClient.get(`/basicauth`,{
        headers: {
            Authorization: token
        }
    })

// javascript에서 backtick(`) 문자를 사용하여 문자열을 표현한것을 템플릿 리터럴이라고 한다.
// 이렇게 사용하면, 두가지 기능이 있는데 (1)줄바꿈을 쉽게 할수 있고, (2)문자열 내부에 표현식을 포함할 수 있게 된다.