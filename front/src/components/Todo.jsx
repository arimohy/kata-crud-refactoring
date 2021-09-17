import React,{ useState ,useEffect} from 'react'
import { StoreProvider } from './StoreProvider'
import TodoList from './TodoList'
const HOST_API = "http://localhost:8080/api";



const initialDb = [
    
]

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


    return (
        <div>
            <form action="">
				<input type="text" />
				<button>Nueva Lista</button>
			</form>
      {db && db.map((el) => <StoreProvider> <TodoList key={el.id} el={el} /></StoreProvider>)}
    </div>
  )
}

export default Todo