import { useState } from "react";

function App() {

  const [student, setStudent] = useState(null);

  const getStudent = async () => {

    const response = await fetch(
   "http://localhost:8080/students" );
    const data = await response.json();
    setStudent(data);
  };

  return (
    <div>
      <button onClick={getStudent}>
        Get Student
      </button>
          <div>
            <h2>ID : {student?.id}</h2>
            <h2>Name : {student?.name}</h2>
          </div>
    </div>
  );
}

export default App;