package com.dev.bisa.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.bisa.exception.ResourceNotFoundException;
import com.dev.bisa.model.Policy;
import com.dev.bisa.repository.PolicyRepository;

@RestController
@CrossOrigin(origins="*", allowedHeaders = "*")
@RequestMapping("/api/v1")
public class PolicyController {
	@Autowired
    private PolicyRepository policyRepository;
	
	@GetMapping("/policys")
    public List<Policy> getAllPolicys() {
        return policyRepository.findAll();
    }
	
	@GetMapping("/policys/{id}")
    public ResponseEntity<Policy> getPolicyById(@PathVariable(value = "id") Long policyId)
        throws ResourceNotFoundException {
        Policy policy = policyRepository.findById(policyId)
          .orElseThrow(() -> new ResourceNotFoundException("Poliza no encontrada para:: " + policyId));
        return ResponseEntity.ok().body(policy);
    }
	
	@PostMapping("/policys")
    public Policy createPolicy(@Valid @RequestBody Policy policy) {
        return policyRepository.save(policy);
    }
	
	@PutMapping("/policys/{id}")
    public ResponseEntity<Policy> updatePolicy(@PathVariable(value = "id") Long policyId,
         @Valid @RequestBody Policy policyDetails) throws ResourceNotFoundException {
        Policy policy = policyRepository.findById(policyId)
        .orElseThrow(() -> new ResourceNotFoundException("Poliza no encontrado para :: " + policyId));

        policy.setNombre(policyDetails.getNombre());
        policy.setApPaterno(policyDetails.getApPaterno());
        policy.setApMaterno(policyDetails.getApMaterno());
        policy.setProductId(policyDetails.getProductId());
        policy.setValorAsegurado(policyDetails.getValorAsegurado());
        policy.setPrimaUsd(policyDetails.getPrimaUsd());
        policy.setVigInicio(policyDetails.getVigInicio());
        policy.setVigFin(policyDetails.getVigFin());
        final Policy updatedPolicy = policyRepository.save(policy);
        return ResponseEntity.ok(updatedPolicy);
    }
	
	@DeleteMapping("/policys/{id}")
    public Map<String, Boolean> deletePolicy(@PathVariable(value = "id") Long policyId)
         throws ResourceNotFoundException {
        Policy policy = policyRepository.findById(policyId)
       .orElseThrow(() -> new ResourceNotFoundException("Poliza no encontrado para :: " + policyId));

        policyRepository.delete(policy);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
