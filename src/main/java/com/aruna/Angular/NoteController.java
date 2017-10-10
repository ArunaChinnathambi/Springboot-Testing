/* ******************NORMAL SPRING BOOT ANNOTATIONS******************* */
// package com.aruna.Angular;

// import java.util.List;
// import com.aruna.Angular.Note;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/Note")
// public class NoteController
// {
// @Autowired
// private NoteServiceInterface noteService;

// @RequestMapping(value = "get" , method=RequestMethod.GET)
// public List<Note> getAll()
// {
//     return noteService.getAll();
// }

// 	@RequestMapping(value = "save" , method = RequestMethod.POST)
// 	public Note save(@RequestBody Note item) {
// 		return noteService.save(item);

// 	}

// @RequestMapping(value = "get/{id}", method = RequestMethod.GET)
// 	public Note find(@PathVariable Long id) {
// 		return noteService.find(id);
// 	}
    

// 	@RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
// 	public void delete(@PathVariable Long id) {
// 		noteService.delete(id);

// 	}
//      @RequestMapping(value = "update/{id}", method = RequestMethod.PUT)

// 		public Note update(@RequestBody Note nt, @PathVariable Long id) {
// 		nt.setId(id);
// 		return noteService.update(nt,id);
// 	}
// }



/* ******************NEW SPRING BOOT ANNOTATIONS******************* */

package com.aruna.Angular;

import java.util.List;
import com.aruna.Angular.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController

public class NoteController
{
@Autowired
private NoteServiceInterface noteService;

@GetMapping( "/Note/get")
public List<Note> getAll()
{
    return noteService.getAll();
}

	@PostMapping("/Note/save")
	public Note save(@RequestBody Note item) {
		return noteService.save(item);

	}

@GetMapping("/Note/get/{id}")
	public Note find(@PathVariable Long id) {
		return noteService.find(id);
	}
    

	@DeleteMapping("/Note/delete/{id}")
	public void delete(@PathVariable Long id) {
		noteService.delete(id);

	}
     @PutMapping("/Note/update/{id}")

		public Note update(@RequestBody Note nt, @PathVariable Long id) {
		nt.setId(id);
		return noteService.update(nt,id);
	}
}