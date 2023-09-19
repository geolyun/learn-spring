import { Link } from 'react-router-dom';
import { useAuth } from './security/AuthContext';

function HeaderComponent() {

    // const authContext = useContext(AuthContext)
    const authContext = useAuth()
    const isAuthenticated = authContext.isAuthenticated

    function logout() {
        authContext.logout()
    }

    console.log(authContext)
    // console.log(authContext.number);

    return (

        // <header className='header'>
        //     <div className='container'>
        //         <ul className='navbar-nav'>
        //             <li className='nav-item'><a className='nav-link' href='https://www.naver.com'>Naver</a></li>
        //             <li className='nav-item'><Link className='nav-link' to='/welcome/geolyun'>Home</Link></li>
        //             <li className='nav-item'><Link className='nav-link' to='/todos'>Todos</Link></li>
        //             <li className='nav-item'><Link className='nav-link' to='/logout'>Logout</Link></li>
        //             <li className='nav-item'><Link className='nav-link' to='/'>Login</Link></li>
        //         </ul>


        //     </div>
        // </header>
        
        // nav-link 없으면 파란색으로 표시됨, navbar-nav 지우면 옆으로 있던 목록이 없어짐

        <header className="border-bottom border-light border-5 mb-5 p-2">
            <div className="container">
                <div className="row">
                    <nav className="navbar navbar-expand-lg">
                        <a className="navbar-brand ms-2 fs-2 fw-bold text-black" href="https://github.com/geolyun">CutyTeddyBear</a>
                        <div className="collapse navbar-collapse">
                            <ul className="navbar-nav">
                                <li className="nav-item fs-5">
                                    {isAuthenticated 
                                        && <Link className="nav-link" to="/welcome/geolyun">Home</Link>}
                                </li>
                                <li className="nav-item fs-5">
                                    {isAuthenticated 
                                        && <Link className="nav-link" to="/todos">Todos</Link>}
                                </li>
                            </ul>
                        </div>
                        <ul className="navbar-nav">
                            <li className="nav-item fs-5">
                                {!isAuthenticated 
                                        && <Link className="nav-link" to="/login">Login</Link>}
                            </li>
                            <li className="nav-item fs-5">
                                {isAuthenticated 
                                        && <Link className="nav-link" to="/logout" onClick={logout}>Logout</Link>}
                            </li>
                        </ul>
                    </nav>
                </div>
            </div>
        </header>


    )
}

export default HeaderComponent