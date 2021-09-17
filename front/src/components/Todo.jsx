import React,{ useState ,useEffect} from 'react'
import { StoreProvider } from './StoreProvider'
import TodoList from './TodoList'
const HOST_API = "http://localhost:8080/api";



const initialDb = []

const Todo = () => {

    const [db, setDb] = useState(initialDb)
    //const [Equipo,setEquipo]=useState([])
    useEffect(() => {
        fetchData()
    }, [])

    const fetchData = async () => {
        const data = await fetch(HOST_API + '/lists')
        const listas = await data.json()
        console.log(listas)
        setDb(listas)
    }
    
    async function postData(data = {}) {
        const response = await fetch(HOST_API + '/list', {
            method: 'POST',
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify(data) 
        });
        return response.json();
    }

    const [nombrelista, setNombrelista] = useState("")

    return (
        <div>
            <form action="">
				<input type="text"
                onChange={(event) => {
                    setNombrelista(event.target.value)
                    }} 
                />
				<button onClick={()=>postData({"name":nombrelista})}>Nueva Lista</button>
			</form>
            {db && db.map((el) => <StoreProvider> <TodoList key={el.id} el={el} /></StoreProvider>)}
    </div>
    )
}

export default Todo