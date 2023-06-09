import { useMemo } from 'react'
import { BrowserRouter, Route, Routes } from 'react-router-dom'
import { Box, CssBaseline, useMediaQuery } from '@mui/material'
import { ThemeProvider, createTheme } from '@mui/material/styles';
import { themeSettings } from './theme'
import NavBar from './pages/NavBar'
import ParentPage from './pages/ParentPage'
import ChildPage from './pages/ChildPage'

function App() {
  const prefersDarkMode = useMediaQuery('(prefers-color-scheme: dark)');
  themeSettings.palette.mode = prefersDarkMode ? 'dark' : 'light';

  const theme = useMemo(() => createTheme(themeSettings), [])

  return (
    <>
      <BrowserRouter>
        <ThemeProvider theme={theme}>
          <CssBaseline />
          <Box width="100%" height="100%" padding="1rem 2rem 4rem 2rem">
            <NavBar />
            <Routes>
              <Route path="/" element={<ParentPage />} />
              <Route path="/child/:parentId" element={<ChildPage />} />
            </Routes>
          </Box>
        </ThemeProvider>
        
      </BrowserRouter>
    </>
  )
}

export default App
