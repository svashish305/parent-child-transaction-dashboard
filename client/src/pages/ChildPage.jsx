import { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';
import { 
  Table, 
  TableHead, 
  TableBody, 
  TableRow, 
  TableCell, 
  TableContainer, 
  Paper 
} from '@mui/material';
import axios from 'axios';

const ChildPage = () => {
  const [children, setChildren] = useState([]);

  const params = useParams();

  useEffect(() => {
    
    const fetchChildren = async () => {
      const response = await axios.get(`${import.meta.env.VITE_APP_API_URL}/api/child?parentId=${params.parentId}`);
      setChildren(response.data);
    }

    fetchChildren();

  }, [params.parentId]);

  return (
    <TableContainer component={Paper}>
      <Table sx={{ minWidth: 500 }} aria-label="custom pagination table">
        <TableHead>
          <TableRow>
            <TableCell>ID</TableCell>
            <TableCell align="right">Sender</TableCell>
            <TableCell align="right">Receiver</TableCell>
            <TableCell align="right">Total Amount</TableCell>
            <TableCell align="right">Paid Amount</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {children.map((child) => (
            <TableRow key={child.id}>
              <TableCell component="th" scope="row">
                {child.id}
              </TableCell>
              <TableCell style={{ width: 160 }} align="right">
                {child.sender}
              </TableCell>
              <TableCell style={{ width: 160 }} align="right">
                {child.receiver}
              </TableCell>
              <TableCell style={{ width: 160 }} align="right">
                {child.totalAmount}
              </TableCell>
              <TableCell style={{ width: 160 }} align="right">
                {child.paidAmount}
              </TableCell>
            </TableRow>
          ))}
        </TableBody>
      </Table>
    </TableContainer>
  );
};

export default ChildPage