import React from 'react';
import { StoreProvider } from './components/StoreProvider';
import TodoForm from './components/TodoForm';
import TodoList from './components/TodoList';

function App() {
  return <StoreProvider>
    <h3>To-Do List</h3>
    <TodoForm />
    <TodoList />
  </StoreProvider>
}

export default App;
