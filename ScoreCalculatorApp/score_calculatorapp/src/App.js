import './App.css';
import { CalculateScore } from './Components/CalculateScore';
function App() {
  return (
    <center>
      <div>
        <CalculateScore
          Name={"Steeve"}
          School={"ABC Public School"}
          total={284}
          goal={3}
        />
      </div>
    </center>
  );
}

export default App;
