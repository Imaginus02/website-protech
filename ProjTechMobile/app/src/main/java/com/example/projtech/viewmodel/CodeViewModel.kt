package com.example.projtech.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.projtech.database.dao.CodeDao
import com.example.projtech.database.dto.CodeCommandDto
import com.example.projtech.database.dto.CodeDto
import com.example.projtech.database.model.Code
import kotlinx.coroutines.Dispatchers

class CodeViewModel(private val codeDao: CodeDao) : ViewModel() {


    val networkState: MutableLiveData<State> by lazy {
        MutableLiveData<State>().also { it.postValue(State.ONLINE) }
    }

    fun findById(codeId: Long): LiveData<CodeDto> =
        liveData(Dispatchers.IO) {
            emit(codeDao.findById(codeId).toDto())
        }

    fun save(codeId: Long, command: CodeCommandDto): LiveData<CodeDto> =
        liveData(Dispatchers.IO) {
            val code = Code(
                id = codeId,
                name = command.name,
//                actions = emptyList<Action>()
            )
            emit(code.toDto())
        }
}