package src.main.java.com.example.middlewareapp;
@Controller
public class MainController {
    @Autowired private UserRepository userRepository;
    @Autowired private BookRepository bookRepository;
    @Autowired private PhoneRepository phoneRepository;
    @Autowired private EmployeeRepository employeeRepository;
    @Autowired private StudentRepository studentRepository;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("users", userRepository.findAll());
        model.addAttribute("books", bookRepository.findAll());
        model.addAttribute("phones", phoneRepository.findAll());
        model.addAttribute("employees", employeeRepository.findAll());
        model.addAttribute("students", studentRepository.findAll());
        return "index";
    }

    // Приклад методу додавання (для інших - аналогічно)
    @PostMapping("/add-student")
    public String addStudent(@ModelAttribute Student student) {
        studentRepository.save(student);
        return "redirect:/";
    }
}