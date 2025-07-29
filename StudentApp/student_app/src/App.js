import './App.css';
import {Home} from '../src/Components/Home';
import { About } from "../src/Components/About";
import { Contact } from "../src/Components/Contact";

function App() {
  return (
    <center>
      <div className="container">
        <Home />
        <About />
        <Contact />
      </div>
    </center>
  );
}

export default App;
