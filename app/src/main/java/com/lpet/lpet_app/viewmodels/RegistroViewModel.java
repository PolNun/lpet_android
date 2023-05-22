package com.lpet.lpet_app.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.lpet.lpet_app.models.LoginModel;
import com.lpet.lpet_app.models.RegistroModel;
import com.lpet.lpet_app.repositories.LoginRepository;
import com.lpet.lpet_app.repositories.RegistroRepository;

public class RegistroViewModel extends ViewModel {
    // ATRIBUTOS
    private static final MutableLiveData<String> correoElectronicoLiveData = new MutableLiveData<>();
    private static final MutableLiveData<String> contrasenaLiveData = new MutableLiveData<>();
    private MutableLiveData<RegistroModel> registroModelLivedata = new MutableLiveData<>();
    private static RegistroRepository registroRepository;

    // METODOS
    //METODO CONSTRUCTOR
    public RegistroViewModel() {
        registroRepository = new RegistroRepository();
    }

    // METODOS GETTERS
    public static LiveData<String> getCorreoElectronicoLiveData() {
        return correoElectronicoLiveData;
    }

    public static LiveData<String> getContrasenaLiveData() {
        return contrasenaLiveData;
    }

    //METODOS SETTERS
    public void setCorreoElectronico(String correoElectronico) {
        correoElectronicoLiveData.setValue(correoElectronico);
    }

    public void setContrasena(String contrasena) {
        contrasenaLiveData.setValue(contrasena);
    }

    public void setLoginModel(RegistroModel registroModel) {
        registroModelLivedata.setValue(registroModel);
    }

    //METODO validarCredencialesLoginViewModel
    public boolean validarCredencialesRegistroViewModel() {
        return registroRepository.validarCredencialesRegistroRepository(getCorreoElectronicoLiveData().getValue(), getContrasenaLiveData().getValue());
    }
    //METODO guardarUsuarioViewModel
    public static void guardarUsuarioRegistroViewModel(){
        registroRepository.guardarUsuarioRegistroRepository(getCorreoElectronicoLiveData().getValue(), getContrasenaLiveData().getValue());

    }
}
