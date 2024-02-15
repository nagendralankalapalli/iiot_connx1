package com.beauto.iiotconnx.servicesimpl;

import java.sql.Timestamp;

//import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.beauto.iiotconnx.config.JwtUtil;
import com.beauto.iiotconnx.dto.LoginRequestDto;
import com.beauto.iiotconnx.dto.LoginResponseDto;
import com.beauto.iiotconnx.dto.Message;
import com.beauto.iiotconnx.dto.UserRequestDto;
import com.beauto.iiotconnx.dto.UserResponse;
import com.beauto.iiotconnx.model.User;
import com.beauto.iiotconnx.repository.UserRepository;
import com.beauto.iiotconnx.services.UserService;
import com.beauto.iiotconnx.util.Constants;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private Message message;

	@Override
	public ResponseEntity<?> userRegistration(UserRequestDto request) {

		log.info("In UserServiceImpl userRegistration() with request: {}", request);
		UserResponse userResponse = new UserResponse();
		User user = new User();

		try {
			boolean emailCheck = userRepository.existsByEmail(request.getEmail());
			 //long currentTimeMillis = System.currentTimeMillis();
			if (!emailCheck) {

				userResponse.setMessage(Constants.WELCOME);
				userResponse.setRollId(request.getRoleId());
				userResponse.setEmail(request.getEmail());

				String encodedPassword = passwordEncoder.encode(request.getPassword());
				user.setPassword(encodedPassword);

				user.setUserName(request.getUsername());
				user.setEmail(request.getEmail());
				user.setPassword(encodedPassword);
				user.setCreateTime(new Timestamp(System.currentTimeMillis()));
				user.setStatus(request.getStatus());
				user.setDescription(request.getDescription());
//				user.setAddedBy(request.getAddedBy());
				user.setRoleId(request.getRoleId());
				user.setDepartmentId(request.getDepartmentId());
				user.setOrganizationId(request.getOrganizationId());
				user.setDeletedFlag(false);
				userRepository.save(user);

				return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);
			} else {
				userResponse.setMessage(Constants.EMAIL_ALREADY_EXISTS);
				userResponse.setRollId(request.getRoleId());
				userResponse.setEmail(request.getEmail());
				return ResponseEntity.status(HttpStatus.CONFLICT).body(userResponse);
			}
		} catch (Exception e) {
			log.error("Error occurred In UserServiceImpl userRegistration(): {}", e.getMessage());
			userResponse.setMessage(Constants.INTERNAL_SERVER_ERROR);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(userResponse);
		}
	}

	@Override
	public ResponseEntity<?> userLogin(LoginRequestDto request) {


		try {
			User user = userRepository.getUserByEmail(request.getEmail());
			
			if (user != null && !user.isDeletedFlag()) {
			try {
				authenticationManager.authenticate(
						new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
			} catch (Exception ex) {
				log.error("Error occurred In UserServiceImpl login() INVALID_USERNAME_PASSWORD:" + ex.getMessage());
				message.setMessage(Constants.INVALID_PASSWORD);
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(message);
			}
			LoginResponseDto responses = createLoginResponse(user);
			String token = jwtUtil.generateToken(request.getEmail());
			responses.setToken(token);
			// responses.setMessage(Constants.LOGIN_SUCCESSFULL);
			return ResponseEntity.status(HttpStatus.OK).body(responses);

			} else {
				message.setMessage(Constants.USER_NOT_EXISTS_OR_DELETED);
				return ResponseEntity.status(HttpStatus.CONFLICT).body(message);
			}
		} catch (Exception e) {
			// log.error("Error occurred In UserServiceImpl login() :" + e.getMessage());
			message.setMessage(Constants.INTERNAL_SERVER_ERROR);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(message);
		}
	}

	private LoginResponseDto createLoginResponse(User user) {
		LoginResponseDto response = new LoginResponseDto();

		 response.setUserId(user.getId());
		response.setRoleId(user.getRoleId());
		// response.setDesignation(user.getDesignation());
		response.setUsername(user.getUserName());
		response.setCreatedDate(user.getCreateTime());
		response.setDepartmentId(user.getDepartmentId());
		response.setOrganizationId(user.getOrganizationId());
		response.setMessage(user.getRoleId() == 1 ? "Login successfully As admin!!" : Constants.LOGIN_SUCCESSFULL);
		return response;
	}

}