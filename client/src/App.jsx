import { BrowserRouter, Route, Routes } from "react-router-dom"
import ParentPage from "./pages/ParentPage"
import ChildPage from "./pages/ChildPage"
import './App.css'
import NavBar from "./pages/NavBar"

function App() {

  return (
    <>
      <BrowserRouter>
        <NavBar />
        <Routes>
          <Route path="/" element={<ParentPage />} />
          <Route path="/child/:parentId" element={<ChildPage />} />
        </Routes>
      </BrowserRouter>
    </>
  )
}

export default App
