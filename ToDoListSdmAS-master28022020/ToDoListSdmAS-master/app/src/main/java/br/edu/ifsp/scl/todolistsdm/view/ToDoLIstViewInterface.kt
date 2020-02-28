package br.edu.ifsp.scl.todolistsdm.view

import br.edu.ifsp.scl.todolistsdm.model.entity.Tarefa

interface ToDoLIstViewInterface {
    fun setTarefas(listaTarefas: MutableList<Tarefa>)
    fun  setRetorno(tarefa: Tarefa)
}