import { Routes, Route } from "react-router-dom";
import Login from "./pages/Login";
import Home from "./pages/Home";
import Menu from "./pages/Menu";
import Cart from "./pages/Cart";
import TrackOrder from "./pages/TrackOrder";

function App() {
    const isAuthenticated = localStorage.getItem("token");
  return (
    <Routes>
      <Route path="/" element={<Login />} />
      <Route path="/home" element={isAuthenticated ? <Home /> : <Login />}
        />
      <Route path="/menu" element={<Menu />} />
      <Route path="/cart" element={<Cart />} />
      <Route path="/track" element={<TrackOrder />} />
    </Routes>
  );
}

export default App;