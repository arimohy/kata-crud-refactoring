import React,{ useState ,useEffect} from 'react'
import { StoreProvider } from './StoreProvider'
import TodoList from './TodoList'
import { useForm } from "react-hook-form";
const HOST_API = "http://localhost:8080/api";



const initialDb = []

const Todo = () => {
    const { register, formState: { errors } } = useForm();
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
        const newData= await response.json()
        setDb([...db,newData])
        console.log(newData)
    }

    const [nombrelista, setNombrelista] = useState("")

    return (
        <div >
            <form>
				<input type="text"
                {...register("nombrelista", { required: true })}
                onChange={(event) => {
                    setNombrelista(event.target.value)
                    }} 
                />
                {errors.nombrelista && <span>este campo es requerido</span>}
				<button onClick={(e)=>{
                    e.preventDefault()
                    postData({"name":nombrelista})
                    //setDb(...db,nombrelista)
                    }
                    }>Nueva Lista</button>
			</form>
            {db && db.map((el) => <StoreProvider> <TodoList key={el.id} el={el} setDb={setDb} db={db} /></StoreProvider>)}
    </div>
    )
}

export default Todo