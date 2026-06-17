function StudentCard({ name, course }) {
  return (
    <div
      style={{
        border: "1px solid black",
        padding: "10px",
        marginBottom: "10px",
        width: "200px",
        height: "300px",
      }}
    >
      <h1>WELCOME DEAR</h1>
      <h2>This is student card</h2>
      <p>{name}</p>
      <p>{course}</p>
    </div>
  );
}
export default StudentCard;
