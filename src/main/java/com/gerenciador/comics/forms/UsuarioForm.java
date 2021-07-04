package com.gerenciador.comics.forms;

import com.gerenciador.comics.domains.Usuario;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class UsuarioForm {
    @NotBlank(message = "Nome não deve ser nulo ou vazio")
    private String nome;
    @Email(message = "Insira um email válido")
    @NotBlank(message = "Email não deve ser nulo ou vazio")
    private String email;
    @CPF(message = "Insira um CPF válido")
    @NotBlank(message = "CPF não deve ser nulo ou vazio")
    private String cpf;

    @NotNull(message = "Data de nascimento não deve ser nula ou vazia")
    private Date dataNascimento;

    public UsuarioForm(){

    }
    public UsuarioForm(Usuario usuario){
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.cpf = usuario.getCpf();
        this.dataNascimento = usuario.getDataNascimento();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
