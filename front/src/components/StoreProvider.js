import React,{useReducer,createContext} from 'react'
import { reducer } from './Reducer';

const initialState = {
  todo: { list: [], item: {} }
};

const Store = createContext(initialState)

const StoreProvider = ({ children }) => {
  const [state, dispatch] = useReducer(reducer, initialState);

  return <Store.Provider value={{ state, dispatch }}>
    {children}
  </Store.Provider>

}
export {StoreProvider};
export default Store