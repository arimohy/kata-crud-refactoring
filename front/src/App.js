import React from 'react';
import { StoreProvider } from './components/StoreProvider';
import TodoForm from './components/TodoForm';
import TodoList from './components/TodoList';
import Todo from './components/Todo';

function App() {
  return (
		<div>
				<h2>LISTAS TODO</h2>
				<Todo/>
		</div>
	)
}

export default App;
