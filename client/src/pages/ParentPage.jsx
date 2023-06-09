import { useState, useEffect } from 'react';
import { useNavigate } from "react-router-dom";
import { 
  Table, 
  TableHead, 
  TableBody, 
  TableRow, 
  TableCell, 
  TableContainer, 
  TableFooter, 
  TablePagination, 
  Paper 
} from '@mui/material';
import TablePaginationActions from '../components/TablePaginationActions';
import axios from 'axios';

const ParentPage = () => {
  const [page, setPage] = useState(0);
  const [rowsPerPage, setRowsPerPage] = useState(2);
  const [total, setTotal] = useState(0);
  const [parents, setParents] = useState([]);
  const navigate = useNavigate();
  
  useEffect(() => {
    
    const fetchParents = async () => {
      const response = await axios.get(`${import.meta.env.VITE_APP_API_URL}/api/parent?page=${page}`);
      const { content, pageable, totalElements } = response.data;
      setParents(content);
      setRowsPerPage(pageable.pageSize);
      setTotal(totalElements);
    }

    fetchParents();

  }, [page]);

  const handleChangePage = (
    event,
    newPage,
  ) => {
    setPage(newPage);
  };

  // Avoid a layout jump when reaching the last page with empty rows.
  const emptyRows =
    page > 0 ? Math.max(0, (1 + page) * rowsPerPage - total) : 0;

  const redirectToChildren = (parentId) => {
    navigate(`/child/${parentId}`);
  }

  return (
    <TableContainer component={Paper}>
      <Table sx={{ minWidth: 500 }} aria-label="custom pagination table">
        <TableHead>
          <TableRow>
            <TableCell>ID</TableCell>
            <TableCell align="right">Sender</TableCell>
            <TableCell align="right">Receiver</TableCell>
            <TableCell align="right">Total Amount</TableCell>
            <TableCell align="right">Total Paid Amount</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {parents.map((parent) => (
            <TableRow key={parent.id}>
              <TableCell component="th" scope="row">
                {parent.id}
              </TableCell>
              <TableCell style={{ width: 160 }} align="right">
                {parent.sender}
              </TableCell>
              <TableCell style={{ width: 160 }} align="right">
                {parent.receiver}
              </TableCell>
              <TableCell style={{ width: 160 }} align="right">
                {parent.totalAmount}
              </TableCell>
              <TableCell 
                style={{ 
                  width: 160, 
                  cursor: 'pointer', 
                  textDecoration: 'underline' 
                }} 
                align="right" 
                onClick={() => redirectToChildren(parent.id)}>
                {parent.totalPaidAmount}
              </TableCell>
            </TableRow>
          ))}
          {emptyRows > 0 && (
            <TableRow style={{ height: 53 * emptyRows }}>
              <TableCell colSpan={6} />
            </TableRow>
          )}
        </TableBody>
        <TableFooter>
          <TableRow>
            <TablePagination
              colSpan={3}
              count={total}
              rowsPerPage={rowsPerPage}
              rowsPerPageOptions={[]} // hide rows per page
              page={page}
              onPageChange={handleChangePage}
              ActionsComponent={() => 
                <TablePaginationActions
                  count={total}
                  page={page}
                  rowsPerPage={rowsPerPage}
                  onPageChange={handleChangePage}
                />}
            />
          </TableRow>
        </TableFooter>
      </Table>
    </TableContainer>
  );
};

export default ParentPage;