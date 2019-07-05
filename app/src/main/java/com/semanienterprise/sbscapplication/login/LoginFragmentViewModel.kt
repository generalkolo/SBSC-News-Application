package com.semanienterprise.sbscapplication.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginFragmentViewModel : ViewModel() {
    val _showAdminPanel = MutableLiveData<Boolean>()
    val showAdminPanel: LiveData<Boolean>
        get() = _showAdminPanel

    fun adminPanelShown() {
        _showAdminPanel.value = null
    }

    val _showToastMessage = MutableLiveData<String>()
    val showToastMessage: LiveData<String>
        get() = _showToastMessage

    fun toastMessageShown() {
        _showToastMessage.value = null
    }

    val _showEndUserFragment = MutableLiveData<Boolean>()
    val showEndUserFragment: LiveData<Boolean>
        get() = _showEndUserFragment

    fun endUserFragmentShown() {
        _showEndUserFragment.value = null
    }

    fun processLogin(username: String, password: String) {
        if (username == "admin" && password == "admin") {
            _showAdminPanel.value = true
        } else if (username == "user" && password == "user") {
            _showEndUserFragment.value = true
        } else {
            _showToastMessage.value = "Wrong Credentials Entered"
        }
    }
}
