package com.banco811.banco811.services;

import com.banco811.banco811.dto.request.ContaRequest;
import com.banco811.banco811.dto.response.ContaResponse;

public interface ContaService {
    ContaResponse create(ContaRequest contaRequest);

}
