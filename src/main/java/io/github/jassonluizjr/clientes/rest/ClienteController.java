package io.github.jassonluizjr.clientes.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import io.github.jassonluizjr.clientes.model.Cliente;
import io.github.jassonluizjr.clientes.repository.ClienteRepository;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

	public final ClienteRepository repository;
	
	@Autowired
	public ClienteController(ClienteRepository repository) {
		this.repository = repository;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente savar(@RequestBody Cliente cliente) {
		return repository.save(cliente);
	}
	
	@GetMapping("{id}")
	public Cliente findById(@PathVariable Integer id) {
		return repository.findById(id)
				.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
	   repository.findById(id)
				.map(cliente -> {
					repository.delete(cliente);
					return Void.TYPE;
				})
				.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	@PutMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void atualiza(@PathVariable Integer id , @RequestBody Cliente clienteAtualizado) {
		repository.findById(id)
					.map(cliente -> {
						cliente.setNome(clienteAtualizado.getNome());
						cliente.setCpf(clienteAtualizado.getCpf());
						return repository.save(cliente);
					})
					.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
}
