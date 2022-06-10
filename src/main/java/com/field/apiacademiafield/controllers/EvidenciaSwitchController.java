package com.field.apiacademiafield.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.field.apiacademiafield.dtos.EvidenciaSwitchDTO;
import com.field.apiacademiafield.models.Evidencia;
import com.field.apiacademiafield.models.EvidenciaSwitch;
import com.field.apiacademiafield.models.Switch;
import com.field.apiacademiafield.repositories.EvidenciaRepository;
import com.field.apiacademiafield.repositories.EvidenciaSwitchRepository;
import com.field.apiacademiafield.repositories.SwitchRepository;



@RestController
@RequestMapping("/evidenciaSwitch")
public class EvidenciaSwitchController {

	@Autowired
	private EvidenciaSwitchRepository repository;

	@Autowired
	private SwitchRepository switchRepository;

	@Autowired
	private EvidenciaRepository evidenciaRepository;

	@GetMapping
	public ResponseEntity<Object> findAll(){

		List<EvidenciaSwitch>	list = repository.findAll();
		List <EvidenciaSwitchDTO> newList = new ArrayList<EvidenciaSwitchDTO>();

		for (EvidenciaSwitch evidenciaSwitch : list) {
			EvidenciaSwitchDTO evidenciaSwitchDto = new EvidenciaSwitchDTO();
			BeanUtils.copyProperties(evidenciaSwitch,evidenciaSwitchDto);
			newList.add(evidenciaSwitchDto);
		}

		return ResponseEntity.status(HttpStatus.OK).body(newList);

	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> findAll(@PathVariable("id") Integer id){

		Optional<EvidenciaSwitch> evidenciaSwitchOptional = repository.findById(id);

		if(!evidenciaSwitchOptional.isPresent()) {

			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body("Join Not Found!");

		}

		EvidenciaSwitchDTO evidenciaSwitchDTO = new EvidenciaSwitchDTO(); 
		BeanUtils.copyProperties(evidenciaSwitchOptional.get(),evidenciaSwitchDTO);
		return ResponseEntity.status(HttpStatus.OK).body(evidenciaSwitchDTO);
	}


	@PostMapping
	public ResponseEntity<Object> save(@RequestBody EvidenciaSwitchDTO evidenciaSwitchDTO){


		Optional<Switch> switchOptional = switchRepository.findById(evidenciaSwitchDTO.getMyswitch_id());

		if(!switchOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Switch Not Found!");
		}

		Optional<Evidencia> evidenciaOptional = evidenciaRepository.findById(evidenciaSwitchDTO.getEvidencia_id());

		if(!evidenciaOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Evidencia Not Found!");
		}


		EvidenciaSwitch evidenciaSwitch = new EvidenciaSwitch();


		BeanUtils.copyProperties(evidenciaSwitchDTO,evidenciaSwitch );

		evidenciaSwitch.setMyswitch(switchOptional.get());
		evidenciaSwitch.setEvidencia(evidenciaOptional.get());

		return ResponseEntity
				.status(HttpStatus.OK)
				.body(repository.save(evidenciaSwitch));	

	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> update(@PathVariable("id") Integer id, @RequestParam("file") MultipartFile file){
		Optional<EvidenciaSwitch> evidenciaSwitchOptional = repository.findById(id);

		if(!evidenciaSwitchOptional.isPresent()) {

			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body("Join Not Found!");

		}

		try {


			EvidenciaSwitch evidenciaSwitch = evidenciaSwitchOptional.get();

			String fileName = evidenciaSwitch.getId() +"_"+ StringUtils.cleanPath(file.getOriginalFilename());


			String uploadDir = "evidencias_switchs";

			Path uploadPath = Paths.get(uploadDir);

			if (!Files.exists(uploadPath)) {
				Files.createDirectories(uploadPath);
			}


			InputStream inputStream = file.getInputStream();
			Path filePath = uploadPath.resolve(fileName);
			Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);


			var downloadUrl =  ServletUriComponentsBuilder.fromCurrentContextPath()
					.path("/evidenciaSwitch/download/")
					.path(evidenciaSwitch.getId().toString())
					.toUriString();

			var viewUrl = ServletUriComponentsBuilder.fromCurrentContextPath()
					.path("/"+uploadDir+"/")
					.path(fileName)
					.toUriString(); 

			evidenciaSwitch.setName(fileName);

			evidenciaSwitch.setType(file.getContentType());

			evidenciaSwitch.setFoto(file.getBytes());

			evidenciaSwitch.setUriPhoto(downloadUrl);

			evidenciaSwitch.setViewPhoto(viewUrl);


			var response = repository.save(evidenciaSwitch);

			response.setFoto(null);

			return ResponseEntity
					.status(HttpStatus.OK)
					.body(response);


		}catch(IOException ioe) {

			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body("Error Upload photo in Path: " + ioe);
		}
		catch (Exception e) {
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body("Error save photo in database: " + e);
		}

	}


	@GetMapping("/download/{id}")
	public ResponseEntity<Object> downloadImagem(@PathVariable("id") Integer id){

		Optional<EvidenciaSwitch> evidenciaSwitchOptional = repository.findById(id);



		if(!evidenciaSwitchOptional.isPresent()) {

			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body("Join Not Found!");

		}

		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(evidenciaSwitchOptional.get().getType()))
				.header(HttpHeaders.CONTENT_DISPOSITION,"file; filename=\""+evidenciaSwitchOptional.get().getName()+"\"")
				.body(new ByteArrayResource(evidenciaSwitchOptional.get().getFoto()));

	}

}
