import { AppBar, Box, Toolbar, Typography } from '@mui/material';
import PeopleIcon from '@mui/icons-material/People';
import { useTheme } from '@mui/material/styles';

const NavBar = () => {
  const { palette } = useTheme()

  return (
    <Box sx={{ flexGrow: 1, backgroundColor: palette.tertiary[500] }}>
      <AppBar position="static">
        <Toolbar>
          <PeopleIcon sx={{ mr: 2 }} />
          <Typography variant="h4" component="div" sx={{ flexGrow: 1 }}>
            Parent Child Transaction App
          </Typography>
        </Toolbar>
      </AppBar>
    </Box>
  )
}

export default NavBar