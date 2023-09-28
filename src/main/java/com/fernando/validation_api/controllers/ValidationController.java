package com.fernando.validation_api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.fernando.validation_api.dtos.requests.ValidateCpfDTO;
import com.fernando.validation_api.dtos.requests.ValidateCnpjDTO;
import com.fernando.validation_api.dtos.requests.ValidateEmailDTO;
import com.fernando.validation_api.dtos.responses.CpfDTO;
import com.fernando.validation_api.dtos.responses.CnpjDTO;
import com.fernando.validation_api.dtos.responses.EmailDTO;
import com.fernando.validation_api.exceptions.RequestBodyException;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/validations")
public class ValidationController {
    @GetMapping("/cpf")
    public @ResponseBody ResponseEntity<CpfDTO> validateCPF(
        @RequestBody(required = false)
        @Valid ValidateCpfDTO validateCPFDao) {
            if (validateCPFDao == null) {
                throw new RequestBodyException("CPF endpoint require body with CPF value");
            }
            CpfDTO cpfDTO = new CpfDTO(validateCPFDao.cpf());
        return ResponseEntity.ok().body(cpfDTO);
    }

    @GetMapping("/email")
    public @ResponseBody ResponseEntity<EmailDTO> validateEmail(
        @RequestBody(required = false)
        @Valid ValidateEmailDTO validateEmailDAO) {
            if (validateEmailDAO == null) {
                throw new RequestBodyException("Email endpoint require body with Email value");
            }
            EmailDTO emailDTO = new EmailDTO(validateEmailDAO.email());
        return ResponseEntity.ok().body(emailDTO);
    }

    @GetMapping("/cnpj")
    public @ResponseBody ResponseEntity<CnpjDTO> validateCPNJ(
        @RequestBody(required = false)
        @Valid ValidateCnpjDTO validateCPNJDTO) {
            if (validateCPNJDTO == null) {
                throw new RequestBodyException("CNPJ endpoint require body with CNPJ value");
            }
            CnpjDTO cpnjDTO = new CnpjDTO(validateCPNJDTO.cnpj());
            return ResponseEntity.ok().body(cpnjDTO);
        }
}