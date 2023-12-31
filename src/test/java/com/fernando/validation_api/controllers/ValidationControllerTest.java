package com.fernando.validation_api.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fernando.validation_api.dtos.requests.ValidateCpfDTO;
import com.fernando.enums.RequestMethod;
import com.fernando.validation_api.dtos.requests.ValidateCnpjDTO;
import com.fernando.validation_api.dtos.requests.ValidateEmailDTO;
import com.fernando.validation_api.dtos.responses.CpfDTO;
import com.fernando.validation_api.dtos.responses.CnpjDTO;
import com.fernando.validation_api.dtos.responses.EmailDTO;
import com.fernando.validation_api.dtos.responses.MethodNotAlowedResponseError;
import com.fernando.validation_api.dtos.responses.ResponseError;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(ValidationController.class)
public class ValidationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    void assertRequestPOST(String requestURL, Object requestBody, Object responseBody) throws Exception {
        mockMvc.perform(post(requestURL).contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(requestBody)))
                .andDo(print())
                .andExpect(
                        content()
                                .json(objectMapper.writeValueAsString(responseBody)));
    }

    void assertRequestPOST(String requestURL, Object responseBody) throws Exception {
        mockMvc.perform(post(requestURL).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(
                        content()
                                .json(objectMapper.writeValueAsString(responseBody)));
    }

    void assertRequestGET(String requestURL, Object responseBody) throws Exception {
        mockMvc.perform(get(requestURL).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(
                        content()
                                .json(objectMapper.writeValueAsString(responseBody)));
    }

    @Test
    void shouldReturnCpfValueWhenToRequestCpfEndpointWithValidCpf() throws Exception {
        ValidateCpfDTO validateCpfDTO = new ValidateCpfDTO("136.775.118-79");
        CpfDTO cpfDTO = new CpfDTO(validateCpfDTO.cpf());

        assertRequestPOST("/validations/cpf", validateCpfDTO, cpfDTO);
    }

    @Test
    void shouldReturnEmailValueWhenToRequestEmailEndpointWithValidEmail() throws Exception {
        ValidateEmailDTO validateEmailDTO = new ValidateEmailDTO("fbarros@gmail.com");
        EmailDTO emailDTO = new EmailDTO(validateEmailDTO.email());

        assertRequestPOST("/validations/email", validateEmailDTO, emailDTO);
    }

    @Test
    void shouldReturnCnpjValueWhenToRequestCpnjEndpointWithValidCnpj() throws Exception {
        ValidateCnpjDTO validateCpnjDTO = new ValidateCnpjDTO("41.381.074/6738-65");

        CnpjDTO cnpjDTO = new CnpjDTO(validateCpnjDTO.cnpj());

        assertRequestPOST("/validations/cnpj", validateCpnjDTO, cnpjDTO);
    }

    @Test
    void shouldReturnErrorResponseErrorCpfDoesNotValidMessageWhenToRequestCpfEndpointWithInvalidCpf() throws Exception {
        ValidateCpfDTO validateCpfDTO = new ValidateCpfDTO("000.000.000-00");
        ResponseError responseError = new ResponseError("CPF doesn't valid", HttpStatus.BAD_REQUEST.value());

        assertRequestPOST("/validations/cpf", validateCpfDTO, responseError);
    }

    @Test
    void shouldReturnErrorResponseErrorEmailDoesNotValidMessageWhenToRequestEmailEndpointWithInvalidEmail()
            throws Exception {

        ValidateEmailDTO validateEmailDTO = new ValidateEmailDTO("fbarros");
        ResponseError responseError = new ResponseError("Email doesn't valid", HttpStatus.BAD_REQUEST.value());

        assertRequestPOST("/validations/email", validateEmailDTO, responseError);
    }

    @Test
    void shouldReturnErrorResponseErrorWithCnpjDoesNotValidMessageWhenToRequestCnpjEndpointWithInvalidCnpj()
            throws Exception {

        ValidateCnpjDTO validateCpnjDTO = new ValidateCnpjDTO("99.999.999/9999-99");
        ResponseError responseError = new ResponseError("CNPJ doesn't valid", HttpStatus.BAD_REQUEST.value());

        assertRequestPOST("/validations/cnpj", validateCpnjDTO, responseError);
    }

    @Test
    void shouldReturnErrorResponseErrorCnpjDoesNotValidMessageWhenToRequestCnpjEndpointWithEmptyCnpj()
            throws Exception {

        ValidateCnpjDTO validateCpnjDTO = new ValidateCnpjDTO("");
        ResponseError responseError = new ResponseError("CNPJ doesn't valid", HttpStatus.BAD_REQUEST.value());

        assertRequestPOST("/validations/cnpj", validateCpnjDTO, responseError);

    }

    @Test
    void shouldReturnErrorResponseErrorWithCpfDoesNotValidMessageWhenToRequestCpfEndpointWithEmptyCpf()
            throws Exception {
        ValidateCpfDTO validateCpfDTO = new ValidateCpfDTO("");
        ResponseError responseError = new ResponseError("CPF doesn't valid", HttpStatus.BAD_REQUEST.value());

        assertRequestPOST("/validations/cpf", validateCpfDTO, responseError);
    }

    @Test
    void shouldReturnErrorResponseErrorWithCnpjValueDoesNotFoundMessageWhenToRequestCpfEndpointWithNullCnpj()
            throws Exception {
        ValidateCnpjDTO validateCpnjDTO = new ValidateCnpjDTO(null);
        ResponseError responseError = new ResponseError("CNPJ value doesn't found", HttpStatus.BAD_REQUEST.value());

        assertRequestPOST("/validations/cnpj", validateCpnjDTO, responseError);
    }

    @Test
    void shouldReturnErrorResponseErrorWithCpfValueDoesNotFoundMessageWhenToRequestCpfEndpointWithNullCpf()
            throws Exception {
        ValidateCpfDTO validateCpfDTO = new ValidateCpfDTO(null);
        ResponseError responseError = new ResponseError("CPF value doesn't found", HttpStatus.BAD_REQUEST.value());

        assertRequestPOST("/validations/cpf", validateCpfDTO, responseError);
    }

    @Test
    void shouldReturnErrorResponseErrorWithEmailEndpointRequireBodyWithEmailValueMessageWhenToRequestCpfEndpointWithNullBody()
            throws Exception {
        ResponseError responseError = new ResponseError("Email endpoint require body with Email value",
                HttpStatus.BAD_REQUEST.value());

        assertRequestPOST("/validations/email", responseError);
    }

    @Test
    void shouldReturnErrorResponseErrorWithCpfEndpointRequireBodyWithCpfValueMessageWhenToRequestCpfEndpointWithNullBody()
            throws Exception {
        ResponseError responseError = new ResponseError("CPF endpoint require body with CPF value",
                HttpStatus.BAD_REQUEST.value());

        assertRequestPOST("/validations/cpf", responseError);

    }

    @Test
    void shouldReturnErrorResponseErrorWithCnpjEndpointRequireBodyWithCnpjValueMessageWhenToRequestCpfEndpointWithNullBody()
            throws Exception {
        ResponseError responseError = new ResponseError("CNPJ endpoint require body with CNPJ value",
                HttpStatus.BAD_REQUEST.value());

        assertRequestPOST("/validations/cnpj", responseError);

    }

    @Test
    void shouldReturnErrorResponseErrorWithMethodGetDoesNotAlowedMessageToRequireWithGETMethod()
            throws Exception {
        MethodNotAlowedResponseError responseError = new MethodNotAlowedResponseError
        ("Method GET doesn't alowed",
                HttpStatus.METHOD_NOT_ALLOWED.value(),
                RequestMethod.GET.getValue());

        assertRequestGET("/validations/email", responseError);

    }

}