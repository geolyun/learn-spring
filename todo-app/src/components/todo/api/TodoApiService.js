import { apiClient } from './ApiClient'
    
export const retrieveAllTodosForUsernameApi
    = (username) => apiClient.get(`/users/${username}/todos`)

export const deleteTodoApi
    = (username, id) => apiClient.delete(`/users/${username}/todos/${id}`)

export const retrieveTodoApi
    = (username, id) => apiClient.get(`/users/${username}/todos/${id}`)

export const updateTodoApi
= (username, id, todo) => apiClient.put(`/users/${username}/todos/${id}`, todo)

export const createTodoApi
= (username, todo) => apiClient.post(`/users/${username}/todos`, todo)

// javascript에서 backtick(`) 문자를 사용하여 문자열을 표현한것을 템플릿 리터럴이라고 한다.
// 이렇게 사용하면, 두가지 기능이 있는데 (1)줄바꿈을 쉽게 할수 있고, (2)문자열 내부에 표현식을 포함할 수 있게 된다.