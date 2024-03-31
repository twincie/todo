package com.example.todo.todo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {
    private List<Todo> todos = new ArrayList<>();

    public List<Todo> getAllTodos() {
        return todos;
    }
    public Todo addTodo(Todo todo){
        todo.setId(System.currentTimeMillis());
        todos.add(todo);
        return todo;
    }
    public Todo updateTodo(Long id, Todo updatedTodo){
        Todo existingTodo = todos.stream().filter(todo -> todo.getId().equals(id)).findFirst().orElse(null);
        if(existingTodo != null){
            existingTodo.setTitle(updatedTodo.getTitle());
            existingTodo.setCompleted(updatedTodo.getCompleted());
        }
        return existingTodo;
    }

    public void deleteTodo(Long id){
        todos.removeIf(todo -> todo.getId().equals((id)));
    }
}
