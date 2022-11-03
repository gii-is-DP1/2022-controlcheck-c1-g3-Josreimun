package org.springframework.samples.petclinic.recoveryroom;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/recoveryroom")
public class RecoveryRoomController {

    private final RecoveryRoomService recoveryRoomService;
    
    private static final String VIEWS_RECOVERYROOM_CREATE_FORM = "recoveryroom/createOrUpdateRecoveryRoomForm";
    private static final String VIEWS_RECOVERYROOM_LIST = "recoveryroom/recoveryRoomList";

    @ModelAttribute("recoveryRoomTypes")
    public List<RecoveryRoomType> populateProductTypes() {
        return this.recoveryRoomService.getAllRecoveryRoomTypes();
    }

    @Autowired
    public RecoveryRoomController(RecoveryRoomService recoveryRoomService) {
        this.recoveryRoomService = recoveryRoomService;
    }

    @GetMapping
    public ModelAndView showRecoveryRoomList() {
        ModelAndView mav = new ModelAndView(VIEWS_RECOVERYROOM_LIST);
        mav.addObject("recoveryRooms", recoveryRoomService.getAll());
        return mav;
    }

    @GetMapping("/create")
    public ModelAndView createRecoveryRoom() {
        ModelAndView mav = new ModelAndView(VIEWS_RECOVERYROOM_CREATE_FORM);
        mav.addObject("recoveryRoom", new RecoveryRoom());
        return mav;
    }

//    @PostMapping("/create")
//    public ModelAndView processCreationForm(@Valid RecoveryRoom recoveryRoom, BindingResult result) throws DuplicatedRoomNameException {
//       ModelAndView mav;
//        if (result.hasErrors()) {
//            mav = new ModelAndView(VIEWS_RECOVERYROOM_CREATE_FORM);
//            mav.addObject("recoveryRoom", recoveryRoom);
//            mav.addObject("types", recoveryRoomService.getAllRecoveryRoomTypes());
//        } else {
//            this.recoveryRoomService.save(recoveryRoom);
//            mav = new ModelAndView("welcome");
//        }
//        return mav;
//    }
    
}
