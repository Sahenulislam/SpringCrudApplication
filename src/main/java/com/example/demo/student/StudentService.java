package com.example.demo.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Page;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.Nodes;
import com.example.demo.entity.Student;
import com.example.demo.repository.NodesRepository;
import com.example.demo.repository.StudentRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class StudentService {
 
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	NodesRepository nodesRepository;
	

	public Student save(Student student) {
		return studentRepository.save(student);
	}

	public Nodes save(Nodes nodes) {
		return nodesRepository.save(nodes);
	}
	
	
	public List<Student> saveAll(List<Student>student) {
		return studentRepository.saveAll(student);
	}
	
	
	public List<Student> findAll(){
		
		return studentRepository.findAll();
    }

	public List<Nodes> findAllNodes(){

		return nodesRepository.findAll();
	}
	
	
	public Student findById(int id) {
		return studentRepository.findById(id).orElse(null);
	}


	public List<Student> findAllBySection(String Section){
		return studentRepository.findAllBySection(Section);
	}

	public Page<Student> findAllBySectionPaging(String section, int page, int pagesize) {
		return studentRepository.findAllBySection(section,PageRequest.of(page,pagesize));
	}

	public Page<Student> findAll(int page, int pagesize)
	{
		Pageable sortedByName = PageRequest.of(page,pagesize);
		return studentRepository.findAll(sortedByName);
	}
	
	public String deleteById(int id) {
		studentRepository.deleteById(id);
		return "product removed || "+id; 
	}

	// not needed
	public Student update(int id, Student pStudent) {
	    // Find the existing student by ID
	    Optional<Student> optionalExistingStudent = studentRepository.findById(id);


	    // Check if the student exists in the database
	    if (optionalExistingStudent.isPresent()) {
	        Student existingStudent = optionalExistingStudent.get();

	        // Update the existing student's data with the new data
	        existingStudent.setStudentName(pStudent.getStudentName());
	        existingStudent.setStudentIntake(pStudent.getStudentIntake());
	        existingStudent.setStudentSection(pStudent.getStudentSection());

	        // Save the updated student record in the database
	        return studentRepository.save(existingStudent); ////////////save alada
	    } else {
	        // Handle the case where the student with the given ID does not exist
	        // You might throw an exception, return null, or handle it in some other way
	        return null;
	    }
	}


	public List<Nodes> fetchAndSaveDataFromThirdPartyApi() {
		String uri = "http://172.17.17.14:8080/goapi/anwarcloud/nodes";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List<Object>> jsonResponse = restTemplate.exchange(uri,
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Object>>() {});

//		ObjectMapper objectMapper = new ObjectMapper();
			// Deserialize JSON array into a list of Nodes objects
//			List<Nodes> nodesList = objectMapper.readValue(jsonResponse, new TypeReference<List<Nodes>>() {});

			// Save the list of entities to the database
//			nodesRepository.saveAll(jsonResponse.getBody());

			return null;
	}


	/*public String fetchAndSaveDataFromThirdPartyApi(){
		
		String uri = "http://172.17.17.14:8080/goapi/anwarcloud/nodes";
		RestTemplate restTemplate = new RestTemplate();
		String jsonResponse = restTemplate.getForObject(uri, String.class);

		ObjectMapper objectMapper = new ObjectMapper();
		 try {
	            Nodes myEntity = objectMapper.readValue(jsonResponse, Nodes.class);

	            // Save the entity to the database
	            nodesRepository.saveAll(myEntity);
	        } catch (IOException e) {
	            // Handle exception
	            e.printStackTrace();	        }
		return jsonResponse;
	}*/


	public Object callThirdPartyApi(){
		String uri = "http://172.17.17.14:8080/goapi/anwarcloud/nodes";
		RestTemplate restTemplate = new RestTemplate();
		String jsonResponse = restTemplate.getForObject(uri, String.class);

		ObjectMapper objectMapper = new ObjectMapper();
		try {
			Nodes myEntity = objectMapper.readValue(jsonResponse, Nodes.class);

			// Save the entity to the database
			nodesRepository.save(myEntity);
		} catch (IOException e) {
			// Handle exception
			e.printStackTrace();
		}
		return jsonResponse;
	}


}
