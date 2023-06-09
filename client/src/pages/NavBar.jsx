import { Link } from 'react-router-dom'
import { Box, Typography } from '@mui/material'
import FlexBetween from '../components/FlexBetween'

const NavBar = () => {
  return (
    <>
			<FlexBetween gap="0.75rem">
        <Typography variant="h4" fontSize="16px">
          ParentChildApp
        </Typography>
      </FlexBetween>
    </>
  )
}

export default NavBar