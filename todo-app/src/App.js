import './App.css';
import Counter from './components/counter/Counter';

function App() {
  return (
    <div className='App'>
      <Counter by={1}/>
      <Counter by={2}/>
      <Counter by={5}/>
    </div>
  )
}

// function PlayingWithProps(properties) {
  
//   console.log(properties)
//   console.log(properties.property1)
//   console.log(properties.property2)

//   return (
//     <div></div>
//   )
// }

function PlayingWithProps( {property1, property2} ) {
  
  console.log(property1)
  console.log(property2)

  return (
    <div></div>
  )
}

export default App;
