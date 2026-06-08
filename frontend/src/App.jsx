import { useState } from "react";

function App() {

  const [students, setStudents] = useState([]);
  const [count, setCount] = useState(0);

  const getStudents = async () => {

    const response = await fetch(
   "http://localhost:8080/students" );
    const data = await response.json();
    setStudents(data);
  };
  const getBcaStudents = async () => {

    const response = await fetch(
   "http://localhost:8080/students/bca" );
    const data = await response.json();
    setStudents(data);
  };
  const fetchTotalStudentsCount= async () => {

    const response = await fetch(
   "http://localhost:8080/students/count" );
    const data = await response.json();
    setCount(data);
  };
  

  return (
    <div>
      <button onClick={getStudents}>
        Get Student
      </button>
      <button onClick={getBcaStudents}>
        show bca student
      </button>
      <ul>
        {students.map(student=>(
          <li key={student.id}>
            {student.name} - {student.course}
          </li>
        ))}
      </ul>
      <button onClick={fetchTotalStudentsCount}> Get total student count</button>
      <p>Total students:{count}</p>
          
    </div>
  );
}

export default App;