package hello.springmvc.basic.requestmapping;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mapping/users")
public class MappingClassController {

	@GetMapping
	public String users() {
		return "get users";
	}

	@PostMapping
	public String addUser() {
		return "post users";
	}

	@GetMapping("/{userId}")
	public String findUser(@PathVariable String userId) {
		return "get UserId : " + userId;
	}

	@PatchMapping("/{userId}")
	public String updateUser(@PathVariable String userId) {
		return "update userId : " + userId;
	}

	@DeleteMapping
	public String deleteUser(@PathVariable String userId) {
		return "delete userId : " + userId;
	}

}