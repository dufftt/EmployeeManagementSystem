import './App.css';
import Sidebar from "./component/navigation/Sidebar";
import "@fortawesome/fontawesome-free/css/all.css";
import Home from "./component/Page/Home";

function App() {
  return (
      <div className="min-h-screen"><Sidebar/><Home/></div>
  );
}

export default App;
