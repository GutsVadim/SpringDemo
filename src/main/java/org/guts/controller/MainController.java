package org.guts.controller;

import org.guts.entity.Note;
import org.guts.service.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @Autowired
    private NotesService notesService;

    @RequestMapping("/")
    public String index(Model model) {
        return "index";
    }

    @RequestMapping("/notes")
    public String notes(Model model) {
        model.addAttribute("notes", notesService.findNotes());
        return "notes";
    }

    @RequestMapping(value = "/notes/add", method = RequestMethod.POST)
    public String addNote(@RequestParam("title") String title, @RequestParam("text") String text) {
        notesService.saveNote(new Note(1, title, text));
        return "redirect:/notes";
    }

}
